package com.mes.lcr.billing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mes.lcr.billing.config.PartnerConfig;
import com.mes.lcr.billing.dao.AcclynkSettlementFileDTR;
import com.mes.lcr.billing.dao.AcculynkBillingRepository;
import com.mes.lcr.billing.dao.DailyDetailFileICDesc;
import com.mes.lcr.billing.dao.MBSDailySummaryIncomeExpense;
import com.mes.lcr.billing.dao.MbsPricing;
import com.mes.lcr.billing.dto.PinlessDebitNetworkFees;
import com.mes.lcr.util.BillingUtil;
import com.mes.lcr.util.ExpenseAcculynkDTRUtil;

@Component
public class LcrDailyBillingService implements Consumer<String> {
	private static final Logger LOG = LoggerFactory.getLogger(LcrDailyBillingService.class);
	public static final int ACCULYNKSWITCHFEE = 227;

	@Autowired
	private AcculynkBillingRepository acculynkBillingRepository;
	@Autowired
	private PartnerConfig partnerConfig;

	@Override
	public void accept(String loadFilename) {
		
		
		String billingJobStatus = null;
		try {
			LOG.info("Processing file : {} ", loadFilename);
			acculynkSettlementDTRDebitNetworkUpdateProcess(loadFilename);

			Map<String, DailyDetailFileICDesc> dailyDetailFileICDescList = acculynkBillingRepository.getDailyDetailFileICDescVpMp();
			LOG.info("Selected pricing records from DAILY_DETAIL_FILE_IC_DESC PRICING, DataCount {}  ", dailyDetailFileICDescList.size());

			Map<String, MbsPricing> merchantRawPricingList = acculynkBillingRepository.getMerchantRawPricingFromLoadfile(loadFilename);
			LOG.info("Selected pricing records from mbs_pricing, for file {} , DataCount {} ", loadFilename, merchantRawPricingList.size());

			List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRDataList = acculynkBillingRepository.getSettlementDataFromLoadfileName(loadFilename);
			LOG.info("Picked up data from ACCULYNK_SETTLEMENT_FILE_DTR , datacount {}", acclynkSettlementFileDTRDataList.size());

			List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseGenericList = ExpenseAcculynkDTRUtil.manupulateExpenseFromAcculynkDTR(acclynkSettlementFileDTRDataList);

			List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeList = populateIncome(mBSDailySummaryIncomeExpenseGenericList, merchantRawPricingList, dailyDetailFileICDescList);
			
			Map<Long,Double> partnerSwithFeeConfig = getPartnerMerchantSwitchFees(partnerConfig.getSwitchfeeconfig());

			List<MBSDailySummaryIncomeExpense> mBSDailySummaryExpenseList = populateExpense(mBSDailySummaryIncomeList, partnerSwithFeeConfig);

			acculynkBillingRepository.insertIncomeExpenseIntoMbsDailySummary(mBSDailySummaryExpenseList);
			LOG.info("Daily billing job mbs daily summary population completed, for the file {} ", loadFilename);

			Long loadFileId = acculynkBillingRepository.callLoadFileIndex(loadFilename);
			LOG.info("Loadfile name inserted in loadfile index , loadfile_id : {} ", loadFileId);

			billingJobStatus = "COMPLETED";

			LOG.info("Billing Service completed .....");
		}
		catch (Exception ex) {
			billingJobStatus = "FAILED";
			LOG.error("DAILY BILLING JOB FAILED , FOR FILE {} , Exception  ", loadFilename, ex);
		}

		finally {
			acculynkBillingRepository.updateBillingJobStatusForaFile(billingJobStatus, loadFilename);
		}
		
	}
	
	public Map<Long,Double> getPartnerMerchantSwitchFees(Map<Long,Double> partnerConfigInputMap){
		Map<Long,Double> merchatWithSwitchFee = new HashMap<>(); 
		for(Map.Entry<Long, Double> mapObj : partnerConfigInputMap.entrySet()) {
			List<Long> merchantList = acculynkBillingRepository.getParnterMerchants(mapObj.getKey());
			for(Long merchantObj : merchantList) {
				merchatWithSwitchFee.put(merchantObj, mapObj.getValue());
			}
		}
		return merchatWithSwitchFee;
	}

	private void acculynkSettlementDTRDebitNetworkUpdateProcess(String loadfileName) {
		List<PinlessDebitNetworkFees> pinlessDebitNetworkFeesList = this.acculynkBillingRepository.getPinlessDebitNetWrorkFees();
		LOG.info("Updating AcculynkSettlementFileDtr for zero debit network start... loadfile Name : {} ", loadfileName);

		List<AcclynkSettlementFileDTR> dailyDetailFileDtList = this.acculynkBillingRepository.getAcculynkSettlementDTRZeroDebitNetwork(loadfileName);
		if (dailyDetailFileDtList != null && !dailyDetailFileDtList.isEmpty()) {
			for (AcclynkSettlementFileDTR acclynkSettlementFileDTRObj : dailyDetailFileDtList) {
				double debitNetworkFee = -1 * (calculateDNfromPDNetworks(pinlessDebitNetworkFeesList, acclynkSettlementFileDTRObj.getNetwork(), acclynkSettlementFileDTRObj.getApprovalAmount()));
				LOG.debug("Network : {}, ApprovalAmount {}, CalculatedNetworkFees {}", acclynkSettlementFileDTRObj.getNetwork(), acclynkSettlementFileDTRObj.getApprovalAmount(), debitNetworkFee);
				acclynkSettlementFileDTRObj.setNetworkfee(debitNetworkFee);
			}
		}
		this.acculynkBillingRepository.updateSettlementDTRZeroDebitNetwork(dailyDetailFileDtList);
		LOG.info("Updating AcculynkSettlementFileDtr for zero debit network completed ");
	}

	private static double calculateDNfromPDNetworks(List<PinlessDebitNetworkFees> pinlessDebitNetworkFees, String network, double approvalAmount) {
		double debitNetworkFee = 0;
		for (PinlessDebitNetworkFees pinlessDebitNetworkFeesObj : pinlessDebitNetworkFees) {
			if (pinlessDebitNetworkFeesObj.getNetwork().equals(network)) {
				debitNetworkFee = ((approvalAmount * pinlessDebitNetworkFeesObj.getRate()) / 100) + pinlessDebitNetworkFeesObj.getPerItem();
				LOG.debug("Setting Network Fees  CalculatedNetwork {}, Rate {}, Per Item {}, Approval Amount {}", debitNetworkFee, pinlessDebitNetworkFeesObj.getRate(), pinlessDebitNetworkFeesObj.getPerItem(), approvalAmount);
			}
		}
		return debitNetworkFee;
	}

	private List<MBSDailySummaryIncomeExpense> populateIncome(List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseList, Map<String, MbsPricing> merchantRawPricingList, Map<String, DailyDetailFileICDesc> dailyDetailFileICDescList) {
		if (mBSDailySummaryIncomeExpenseList == null) {
			LOG.info("Income processing  MBSDailySummaryIncomeExpenseList is null");
			return new ArrayList<>();
		}

		for (MBSDailySummaryIncomeExpense mbsDailySummaryIncomeExpenseOBJ : mBSDailySummaryIncomeExpenseList) {
			// pricing should not check for item type 1
			if (mbsDailySummaryIncomeExpenseOBJ.getItemType() == 1) {
				continue;
			}

			if (mbsDailySummaryIncomeExpenseOBJ.getItemType() == 111) {
				// rate,per_item,fees_paid and fess_due would be 0 for interchange
				LOG.debug("Calling Interchange 111 checkCode {}  ", mbsDailySummaryIncomeExpenseOBJ.getItemSubclass() + mbsDailySummaryIncomeExpenseOBJ.getNetwork() + mbsDailySummaryIncomeExpenseOBJ.getRegulatedIndicator());
				if (dailyDetailFileICDescList != null && !dailyDetailFileICDescList.isEmpty()) {
					DailyDetailFileICDesc dailyDetailFileICDescObj = BillingUtil.getDailyDetailICDesPricingFromCode(dailyDetailFileICDescList, mbsDailySummaryIncomeExpenseOBJ.getItemSubclass() + mbsDailySummaryIncomeExpenseOBJ.getNetwork() + mbsDailySummaryIncomeExpenseOBJ.getRegulatedIndicator());
					if (dailyDetailFileICDescObj != null) {
						LOG.debug("Received  Interchange Object dailyDetailFileICDescObj {}  ", dailyDetailFileICDescObj);
						mbsDailySummaryIncomeExpenseOBJ.setPerItem(0);
						mbsDailySummaryIncomeExpenseOBJ.setRate(0);
						mbsDailySummaryIncomeExpenseOBJ.setFeesDue(0);
						mbsDailySummaryIncomeExpenseOBJ.setIcCat(dailyDetailFileICDescObj.getIcCode());
					}
					else {
						LOG.info("Received  Interchange Object dailyDetailFileICDescObj null value  ");
					}
				}
				else {
					LOG.info("DAILY_DETAIL_FILE_IC_DESC data not found for VP and MP ");
				}

			}
			else {
				LOG.debug("Calling getMbsPricingFromMerchantNumber with CheckCode {} ", mbsDailySummaryIncomeExpenseOBJ.getMerchantNumber() + "-" + mbsDailySummaryIncomeExpenseOBJ.getItemSubclass() + "-" + mbsDailySummaryIncomeExpenseOBJ.getItemType());
				MbsPricing mbsPricing = BillingUtil.getMbsPricingFromCode(merchantRawPricingList, mbsDailySummaryIncomeExpenseOBJ.getMerchantNumber() + "-" + mbsDailySummaryIncomeExpenseOBJ.getItemSubclass() + "-" + mbsDailySummaryIncomeExpenseOBJ.getItemType());

				if (mbsPricing != null) {
					LOG.debug("Recieive pricing for Merchant: {}, CardTpe: {}, Item Type: {}, Rate {} , PerItem {} ", mbsPricing.getMerchantNumber(), mbsPricing.getItemSubclass(), mbsPricing.getItemType(), mbsPricing.getRate(), mbsPricing.getPerItem());
					mbsDailySummaryIncomeExpenseOBJ.setPerItem(mbsPricing.getPerItem());
					mbsDailySummaryIncomeExpenseOBJ.setRate(mbsPricing.getRate());
					mbsDailySummaryIncomeExpenseOBJ.setFeesDue((mbsDailySummaryIncomeExpenseOBJ.getSalesCount() * mbsPricing.getPerItem()) + (mbsDailySummaryIncomeExpenseOBJ.getItemAmount() * (mbsPricing.getRate() / 100)));
					LOG.debug("Calculating Rate and Per Item for Merchant {}, Fees Type {}, CardType {}, SaleCount {} , PerItem  {}, Rate {}, item Amount {} ", mbsDailySummaryIncomeExpenseOBJ.getMerchantNumber(), mbsDailySummaryIncomeExpenseOBJ.getItemType(), mbsDailySummaryIncomeExpenseOBJ.getItemSubclass(), mbsDailySummaryIncomeExpenseOBJ.getSalesCount(), mbsDailySummaryIncomeExpenseOBJ.getPerItem(), mbsDailySummaryIncomeExpenseOBJ.getRate(), mbsDailySummaryIncomeExpenseOBJ.getItemAmount());
					mbsDailySummaryIncomeExpenseOBJ.setIcCat(null);
				}
				else {
					LOG.info("No pricing found four merchant {}, card_type {}, item_type {}", mbsDailySummaryIncomeExpenseOBJ.getMerchantNumber(), mbsDailySummaryIncomeExpenseOBJ.getItemSubclass(), mbsDailySummaryIncomeExpenseOBJ.getItemType());
				}
			}
		}
		LOG.info("Income processing completed Datacount {}", mBSDailySummaryIncomeExpenseList.size());

		return mBSDailySummaryIncomeExpenseList;
	}

	private List<MBSDailySummaryIncomeExpense> populateExpense(List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseList, Map<Long,Double> partnerSwithFeeConfig) {
		if (mBSDailySummaryIncomeExpenseList == null || mBSDailySummaryIncomeExpenseList.isEmpty()) {
			return new ArrayList<>();
		}

		for (MBSDailySummaryIncomeExpense mbsDailySummaryIncomeExpenseObj : mBSDailySummaryIncomeExpenseList) {
			LOG.debug("Expense calculating for Merchant {} , card {} , item {} ", mbsDailySummaryIncomeExpenseObj.getMerchantNumber(), mbsDailySummaryIncomeExpenseObj.getItemSubclass(), mbsDailySummaryIncomeExpenseObj.getItemType());
			// Partner Merchant SwitchFee(227) Calculation, As billing tree merchant don't have switch fee, It will be sale count * 0.9
			if (mbsDailySummaryIncomeExpenseObj.getItemType() == ACCULYNKSWITCHFEE) {
				double partnerSwitchFee = BillingUtil.getSwitchfeeFromPartnerMerchant(partnerSwithFeeConfig, mbsDailySummaryIncomeExpenseObj.getMerchantNumber());
				if (partnerSwitchFee!=0.0) {
					LOG.debug("Switch Fee (227) Expnese Processing for Partner Merchant {}", mbsDailySummaryIncomeExpenseObj.getMerchantNumber());
					double feesPaid = (mbsDailySummaryIncomeExpenseObj.getSalesCount() * partnerSwitchFee);
					mbsDailySummaryIncomeExpenseObj.setFeesPaid(feesPaid);
					mbsDailySummaryIncomeExpenseObj.setExpense(feesPaid);
					mbsDailySummaryIncomeExpenseObj.setExpenseActual(feesPaid);
					LOG.debug("Partner Merchant {}, Fees Paid for SwitchFee {}, SaleCount {} , FeesPaid {} ", mbsDailySummaryIncomeExpenseObj.getMerchantNumber(), ACCULYNKSWITCHFEE, mbsDailySummaryIncomeExpenseObj.getSalesCount(), feesPaid);
				}
			}
		}
		LOG.info("Expense processing completed Datacount {}, Starting insert process into mbs_daily_summary", mBSDailySummaryIncomeExpenseList.size());
		return mBSDailySummaryIncomeExpenseList;
	}
}
