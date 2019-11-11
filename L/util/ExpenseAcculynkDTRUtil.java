package com.mes.lcr.util;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mes.lcr.billing.dao.AcclynkSettlementFileDTR;
import com.mes.lcr.billing.dao.MBSDailySummaryIncomeExpense;

public class ExpenseAcculynkDTRUtil {

	private static final Logger LOG = LoggerFactory.getLogger(ExpenseAcculynkDTRUtil.class);
	public static final String CARD_TYPE_VP = "VP";
	public static final String CARD_TYPE_MP = "MP";

	@SuppressWarnings("nls")
	private ExpenseAcculynkDTRUtil() {
		throw new IllegalStateException("ExpenseAcculynkDTRUtil Utility class");
	}

	public static List<MBSDailySummaryIncomeExpense> manupulateExpenseFromAcculynkDTR(List<AcclynkSettlementFileDTR> acclynkSettlementFileDTR) {
		List<MBSDailySummaryIncomeExpense> mbsDailySummaryExpenseList = new ArrayList<>();
		if (acclynkSettlementFileDTR != null) {
			for (AcclynkSettlementFileDTR AcclynkSettlementFileDTRObj : acclynkSettlementFileDTR) {
				LOG.debug("Summarized Data Merchant Number {}, Card Type {}, TransactionDateTime {}, ACCULYNKSWITCHFEE {} , DEBITNETWORKINTERCHANGE {} ,DEBITNETWORKFEE {} ", AcclynkSettlementFileDTRObj.getMerchantNumber(), AcclynkSettlementFileDTRObj.getCardtype(), AcclynkSettlementFileDTRObj.getTransactionDateTime(), AcclynkSettlementFileDTRObj.getSwitchfee(), AcclynkSettlementFileDTRObj.getInterchangeFee(), AcclynkSettlementFileDTRObj.getNetworkfee());
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP227 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP227 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP111 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP111 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP229 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP229 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP101 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP101 = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryAuthVP = new MBSDailySummaryIncomeExpense();
				MBSDailySummaryIncomeExpense mbsDailySummaryAuthMP = new MBSDailySummaryIncomeExpense();

				if (AcclynkSettlementFileDTRObj.getCardtype().equals(CARD_TYPE_VP)) {

					mbsDailySummaryExpenseObjVP227.setExpense(Math.abs(AcclynkSettlementFileDTRObj.getSwitchfee()));
					mbsDailySummaryExpenseObjVP227.setExpenseActual(Math.abs(AcclynkSettlementFileDTRObj.getSwitchfee()));
					mbsDailySummaryExpenseObjVP227.setItemType(227);
					mbsDailySummaryExpenseObjVP227.setItemSubclass(CARD_TYPE_VP);
					mbsDailySummaryExpenseObjVP227.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjVP227.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjVP227.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjVP227.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjVP227.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjVP227.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjVP227.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjVP227.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjVP227.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjVP227.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjVP227.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjVP227.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseObjVP111.setExpense(Math.abs(AcclynkSettlementFileDTRObj.getInterchangeFee()));
					mbsDailySummaryExpenseObjVP111.setExpenseActual(Math.abs(AcclynkSettlementFileDTRObj.getInterchangeFee()));
					mbsDailySummaryExpenseObjVP111.setItemType(111);
					mbsDailySummaryExpenseObjVP111.setItemSubclass(CARD_TYPE_VP);
					mbsDailySummaryExpenseObjVP111.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjVP111.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjVP111.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjVP111.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjVP111.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjVP111.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjVP111.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjVP111.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjVP111.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjVP111.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjVP111.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjVP111.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseObjVP229.setExpense(Math.abs(AcclynkSettlementFileDTRObj.getNetworkfee()));
					mbsDailySummaryExpenseObjVP229.setExpenseActual(Math.abs(AcclynkSettlementFileDTRObj.getNetworkfee()));
					mbsDailySummaryExpenseObjVP229.setItemType(229);
					mbsDailySummaryExpenseObjVP229.setItemSubclass(CARD_TYPE_VP);
					mbsDailySummaryExpenseObjVP229.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjVP229.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjVP229.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjVP229.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjVP229.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjVP229.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjVP229.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjVP229.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjVP229.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjVP229.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjVP229.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjVP229.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseObjVP101.setExpense(0);
					mbsDailySummaryExpenseObjVP101.setExpenseActual(0);
					mbsDailySummaryExpenseObjVP101.setItemType(101);
					mbsDailySummaryExpenseObjVP101.setItemSubclass(CARD_TYPE_VP);
					mbsDailySummaryExpenseObjVP101.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjVP101.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjVP101.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjVP101.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjVP101.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjVP101.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjVP101.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjVP101.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjVP101.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjVP101.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjVP101.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjVP101.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryAuthVP.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryAuthVP.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryAuthVP.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryAuthVP.setItemSubclass(CARD_TYPE_VP);
					mbsDailySummaryAuthVP.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryAuthVP.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryAuthVP.setItemType(1);
					mbsDailySummaryAuthVP.setRate(0.0);
					mbsDailySummaryAuthVP.setPerItem(0);
					mbsDailySummaryAuthVP.setSalesCount(0);
					mbsDailySummaryAuthVP.setSalesAmount(0);
					mbsDailySummaryAuthVP.setCreditAmount(0);
					mbsDailySummaryAuthVP.setCreditCount(0);
					mbsDailySummaryAuthVP.setFeesDue(0);
					mbsDailySummaryAuthVP.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryAuthVP.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryAuthVP.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjVP227);
					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjVP111);
					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjVP229);
					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjVP101);
					mbsDailySummaryExpenseList.add(mbsDailySummaryAuthVP);
				}
				if (AcclynkSettlementFileDTRObj.getCardtype().equals(CARD_TYPE_MP)) {

					mbsDailySummaryExpenseObjMP227.setExpense(Math.abs(AcclynkSettlementFileDTRObj.getSwitchfee()));
					mbsDailySummaryExpenseObjMP227.setExpenseActual(Math.abs(AcclynkSettlementFileDTRObj.getSwitchfee()));
					mbsDailySummaryExpenseObjMP227.setItemType(227);
					mbsDailySummaryExpenseObjMP227.setItemSubclass(CARD_TYPE_MP);
					mbsDailySummaryExpenseObjMP227.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjMP227.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjMP227.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjMP227.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjMP227.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjMP227.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjMP227.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjMP227.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjMP227.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjMP227.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjMP227.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjMP227.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseObjMP111.setExpense(Math.abs(AcclynkSettlementFileDTRObj.getInterchangeFee()));
					mbsDailySummaryExpenseObjMP111.setExpenseActual(Math.abs(AcclynkSettlementFileDTRObj.getInterchangeFee()));
					mbsDailySummaryExpenseObjMP111.setItemType(111);
					mbsDailySummaryExpenseObjMP111.setItemSubclass(CARD_TYPE_MP);
					mbsDailySummaryExpenseObjMP111.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjMP111.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjMP111.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjMP111.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjMP111.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjMP111.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjMP111.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjMP111.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjMP111.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjMP111.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjMP111.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjMP111.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseObjMP229.setExpense(Math.abs(AcclynkSettlementFileDTRObj.getNetworkfee()));
					mbsDailySummaryExpenseObjMP229.setExpenseActual(Math.abs(AcclynkSettlementFileDTRObj.getNetworkfee()));
					mbsDailySummaryExpenseObjMP229.setItemType(229);
					mbsDailySummaryExpenseObjMP229.setItemSubclass(CARD_TYPE_MP);
					mbsDailySummaryExpenseObjMP229.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjMP229.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjMP229.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjMP229.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjMP229.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjMP229.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjMP229.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjMP229.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjMP229.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjMP229.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjMP229.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjMP229.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseObjMP101.setExpense(0);
					mbsDailySummaryExpenseObjMP101.setExpenseActual(0);
					mbsDailySummaryExpenseObjMP101.setItemType(101);
					mbsDailySummaryExpenseObjMP101.setItemSubclass(CARD_TYPE_MP);
					mbsDailySummaryExpenseObjMP101.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryExpenseObjMP101.setSalesCount(AcclynkSettlementFileDTRObj.getSalesCount());
					mbsDailySummaryExpenseObjMP101.setSalesAmount(AcclynkSettlementFileDTRObj.getSalesAmount());
					mbsDailySummaryExpenseObjMP101.setCreditCount(AcclynkSettlementFileDTRObj.getCreditCount());
					mbsDailySummaryExpenseObjMP101.setCreditAmount(AcclynkSettlementFileDTRObj.getCreditAmount());
					mbsDailySummaryExpenseObjMP101.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryExpenseObjMP101.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryExpenseObjMP101.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryExpenseObjMP101.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryExpenseObjMP101.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryExpenseObjMP101.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryExpenseObjMP101.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryAuthMP.setMerchantNumber(AcclynkSettlementFileDTRObj.getMerchantNumber());
					mbsDailySummaryAuthMP.setDataSourceName(AcclynkSettlementFileDTRObj.getLoadFilename());
					mbsDailySummaryAuthMP.setDataSourceId(AcclynkSettlementFileDTRObj.getLoadFileId());
					mbsDailySummaryAuthMP.setItemSubclass(CARD_TYPE_MP);
					mbsDailySummaryAuthMP.setItemCount(AcclynkSettlementFileDTRObj.getItemCount());
					mbsDailySummaryAuthMP.setItemAmount(AcclynkSettlementFileDTRObj.getItemAmount());
					mbsDailySummaryAuthMP.setItemType(1);
					mbsDailySummaryAuthMP.setRate(0.0);
					mbsDailySummaryAuthMP.setPerItem(0);
					mbsDailySummaryAuthMP.setSalesCount(0);
					mbsDailySummaryAuthMP.setSalesAmount(0);
					mbsDailySummaryAuthMP.setCreditAmount(0);
					mbsDailySummaryAuthMP.setCreditCount(0);
					mbsDailySummaryAuthMP.setFeesDue(0);
					mbsDailySummaryAuthMP.setActivityDate(AcclynkSettlementFileDTRObj.getBatchDate());
					mbsDailySummaryAuthMP.setNetwork(AcclynkSettlementFileDTRObj.getNetwork());
					mbsDailySummaryAuthMP.setRegulatedIndicator(AcclynkSettlementFileDTRObj.getRegulatedIndicator());

					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjMP227);
					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjMP111);
					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjMP229);
					mbsDailySummaryExpenseList.add(mbsDailySummaryExpenseObjMP101);
					mbsDailySummaryExpenseList.add(mbsDailySummaryAuthMP);
				}
			}
		}
		LOG.info("acculynk settlement data manupulating for VP , MP and Fees, Datacount {}", mbsDailySummaryExpenseList.size());
		return mbsDailySummaryExpenseList;
	}

}
