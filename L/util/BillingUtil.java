package com.mes.lcr.util;

import java.util.Date;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mes.lcr.billing.dao.DailyDetailFileICDesc;
import com.mes.lcr.billing.dao.MbsPricing;

public class BillingUtil {

	private static final Logger LOG = LoggerFactory.getLogger(BillingUtil.class);

	@SuppressWarnings("nls")
	private BillingUtil() {
		throw new IllegalStateException("Utility class");
	}

	@SuppressWarnings("nls")
	public static String generateReferenceNumber(String binNum, int usage, boolean cashAdvance, String debitCreditInd, Date settlementDate, long acqRefNum) {
		String retVal = "2"; // default to fmt code '2'

		try {
			// credits, re-presentments and cash advances all use fmt code '7'
			if ("C".equals(debitCreditInd) || (usage > 1) || cashAdvance) {
				retVal = "7";
			}
			retVal += binNum;
			retVal += DateTimeUtil.getFormattedDate(settlementDate, DateTimeUtil.DATE_FORMAT_YYDDD).substring(1);
			retVal += NumberUtil.getPaddedLong(acqRefNum, 11);
			retVal += String.valueOf(NumberUtil.calcMod10CheckDigit(retVal));
		}
		catch (Exception e) {
			LOG.error("Error in generateReferenceNumber()", e);
		}
		return retVal;
	}

	public static MbsPricing getMbsPricingFromCode(Map<String, MbsPricing> merchantRawPricingList, String checkCode) {
		try {
			LOG.info("MbsPricing Search , checkCode {}", checkCode);
			return merchantRawPricingList.get(checkCode);
		}
		catch (Exception ex) {
			LOG.error("Unable to processing util function getMbsPricingFromCode, Exception {} ", ex);
		}
		return null;
	}

	public static DailyDetailFileICDesc getDailyDetailICDesPricingFromCode(Map<String, DailyDetailFileICDesc> dailyDetailFileICDescList, String checkCode) {
		try {
			LOG.info("Matching  DailyDetailFileICDesc checkCode {} ", checkCode);
			String otherCheckCode = null;
			DailyDetailFileICDesc dailyDetailFileICDescObj = null;
			dailyDetailFileICDescObj = dailyDetailFileICDescList.get(checkCode);
			if (dailyDetailFileICDescObj == null) {
				otherCheckCode = checkCode.substring(0, 2) + "OTHER" + checkCode.substring(checkCode.length() - 1, checkCode.length());
				dailyDetailFileICDescObj = dailyDetailFileICDescList.get(otherCheckCode);
			}
			LOG.info("Returning  dailyDetailFileICDescObj, icCode {} , Rate {}, PerItem {} ", dailyDetailFileICDescObj.getIcCode(), dailyDetailFileICDescObj.getIcRate(), dailyDetailFileICDescObj.getIcRatePerItem());
			return dailyDetailFileICDescObj;
		}
		catch (Exception ex) {
			LOG.error("Unable to processing util function getDailyDetailICDesPricingFromCode, Exception {} ", ex);
		}
		return null;
	}

	public static String generateCheckCodeFromPricingObj(long merchantNumber, String cardType, int itemType) {
		return merchantNumber + "-" + cardType + "-" + itemType;
	}

	public static String generateCheckCodeFromDailyDetailFileICDescObj(String cardType, String icDesc) {
		try {
			String[] splitDesc = icDesc.split("-");
			String network = splitDesc[0].trim().toUpperCase();
			String returnKey = null;
			if (network.equals("PULSE")) {
				returnKey = cardType + splitDesc[0].trim().substring(0, 4).toUpperCase() + (splitDesc[1].trim()).substring(0, 1).toUpperCase();
			}
			else {
				returnKey = cardType + splitDesc[0].trim().toUpperCase() + (splitDesc[1].trim()).substring(0, 1).toUpperCase();
			}
			return returnKey;
		}
		catch (Exception ex) {
			LOG.error("Unable to processing util function generareCheckCodeFromDailyDetailFileICDescObj, Exception {} ", ex);
		}
		return null;
	}
	
	public static double getSwitchfeeFromPartnerMerchant(Map<Long,Double> partnerMerchantConfig,long merchantNumber) {
		if(partnerMerchantConfig.get(merchantNumber)!=null) {
			return partnerMerchantConfig.get(merchantNumber);
		}
		return 0.0;
	}
}
