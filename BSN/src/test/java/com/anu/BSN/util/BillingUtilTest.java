package com.me.lc.bil.util;

import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import com.me.lc.bil.dao.DailyDetailFileICDesc;
import com.me.lc.bil.dao.mbPricing;
import com.me.lc.util.bilUtil;

public class bilUtilTest {
	@Test
	public void getDailyDetailICDesPricingFromCodeTest() {
		DailyDetailFileICDesc ddficd1 = new DailyDetailFileICDesc();
		ddficd1.setCardType("MP");
		ddficd1.setIcCode("02A");
		ddficd1.setIcDesc("Pulse - Regulated");
		ddficd1.setIcRate(1.28);
		ddficd1.setIcRatePerItem(0.04);

		DailyDetailFileICDesc ddficd2 = new DailyDetailFileICDesc();
		ddficd2.setCardType("MP");
		ddficd2.setIcCode("02B");
		ddficd2.setIcDesc("Pulse - Unregulated");
		ddficd2.setIcRate(1.28);
		ddficd2.setIcRatePerItem(0.04);

		Map<String, DailyDetailFileICDesc> dailyDetailFileICDescMap = new HashMap<>();
		dailyDetailFileICDescMap.put("MPPULSER", ddficd1);
		dailyDetailFileICDescMap.put("MPPULSEU", ddficd2);

		DailyDetailFileICDesc recivedObj = bilUtil.getDailyDetailICDesPricingFromCode(dailyDetailFileICDescMap, "MPPULSER");
		Assert.assertEquals("MP", recivedObj.getCardType());
		Assert.assertEquals("02A", recivedObj.getIcCode());
		Assert.assertEquals("Pulse - Regulated", recivedObj.getIcDesc());
		Assert.assertEquals(1.28, recivedObj.getIcRate(), 0);
		Assert.assertEquals(0.04, recivedObj.getIcRatePerItem(), 0);

		DailyDetailFileICDesc recivedObj2 = bilUtil.getDailyDetailICDesPricingFromCode(dailyDetailFileICDescMap, "MPPULSEU");
		Assert.assertEquals("MP", recivedObj2.getCardType());
		Assert.assertEquals("02B", recivedObj2.getIcCode());
		Assert.assertEquals("Pulse - Unregulated", recivedObj2.getIcDesc());
		Assert.assertEquals(1.28, recivedObj2.getIcRate(), 0);
		Assert.assertEquals(0.04, recivedObj2.getIcRatePerItem(), 0);
		
		DailyDetailFileICDesc recivedObj3 = bilUtil.getDailyDetailICDesPricingFromCode(dailyDetailFileICDescMap, "MPPULSE");
		
		
	}

	@Test
	public void getmbPricingFromCodeTest() {
		mbPricing mp1 = new mbPricing();
		mp1.setMerchantNumber(941000122088L);
		mp1.setItemSubclass("VP");
		mp1.setItemType(227);
		mp1.setRate(1.02);
		mp1.setPerItem(0.12);

		mbPricing mp2 = new mbPricing();
		mp2.setMerchantNumber(941000122088L);
		mp2.setItemSubclass("MP");
		mp2.setItemType(228);
		mp2.setRate(1.02);
		mp2.setPerItem(0.12);

		Map<String, mbPricing> pricingMap = new HashMap<>();
		pricingMap.put("941000122088-VP-227", mp1);
		pricingMap.put("941000122088-MP-228", mp2);

		mbPricing mpobj1 = bilUtil.getmbPricingFromCode(pricingMap, "941000122088-VP-227");
		Assert.assertEquals(941000122088L, mpobj1.getMerchantNumber());
		Assert.assertEquals("VP", mpobj1.getItemSubclass());
		Assert.assertEquals(227, mpobj1.getItemType());
		Assert.assertEquals(1.02, mpobj1.getRate(), 0);
		Assert.assertEquals(0.12, mpobj1.getPerItem(), 0);

		mbPricing mpobj2 = bilUtil.getmbPricingFromCode(pricingMap, "941000122088-MP-228");
		Assert.assertEquals(941000122088L, mpobj2.getMerchantNumber());
		Assert.assertEquals("MP", mpobj2.getItemSubclass());
		Assert.assertEquals(228, mpobj2.getItemType());
		Assert.assertEquals(1.02, mpobj2.getRate(), 0);
		Assert.assertEquals(0.12, mpobj2.getPerItem(), 0);
		
		mbPricing mpobj4 = bilUtil.getmbPricingFromCode(pricingMap, null);
		Assert.assertEquals(null, mpobj4);
		mbPricing mpobj5 = bilUtil.getmbPricingFromCode(null, "941000122088-MP-228");
		Assert.assertEquals(null, mpobj5);
		mbPricing mpobj6 = bilUtil.getmbPricingFromCode(null, null);
		Assert.assertEquals(null, mpobj6);
	}

	@Test
	public void generareCheckCodeFromPricingObjTest() {
		long merchantNumber = 941000122088L;
		String cardType = "VP";
		int itemType = 227;

		String checkCode = bilUtil.generateCheckCodeFromPricingObj(merchantNumber, cardType, itemType);
		Assert.assertEquals("941000122088-VP-227", checkCode);

		long merchantNumber2 = 941000122080L;
		String cardType2 = "MP";
		int itemType2 = 228;

		String checkCode2 = bilUtil.generateCheckCodeFromPricingObj(merchantNumber2, cardType2, itemType2);
		Assert.assertEquals("941000122080-MP-228", checkCode2);
		
		bilUtil.generateCheckCodeFromPricingObj(merchantNumber2, null, itemType2);
		long merchantNumber3 = (long) 0.12;
		int itemType3 = -12;
		String chekCode3  = bilUtil.generateCheckCodeFromPricingObj(merchantNumber3, null, itemType3);
		Assert.assertEquals("0-null--12", chekCode3);
		
	}

	@Test
	public void generareCheckCodeFromDailyDetailFileICDescObjTest() {
		String cardType = "VP";
		String icDesc = "Pulse - Regulated";
		String checkCode = bilUtil.generateCheckCodeFromDailyDetailFileICDescObj(cardType, icDesc);
		Assert.assertEquals("VPPULSR", checkCode);

		String cardType2 = "MP";
		String icDesc2 = "XCEL - Unregulated";
		String checkCode2 = bilUtil.generateCheckCodeFromDailyDetailFileICDescObj(cardType2, icDesc2);
		Assert.assertEquals("MPXCELU", checkCode2);

		String cardType3 = "VP";
		String icDesc3 = "Other - Regulated";
		String checkCode3 = bilUtil.generateCheckCodeFromDailyDetailFileICDescObj(cardType3, icDesc3);
		Assert.assertEquals("VPOTHERR", checkCode3);

		String cardType4 = "MP";
		String icDesc4 = "Other - Unregulated";
		String checkCode4 = bilUtil.generateCheckCodeFromDailyDetailFileICDescObj(cardType4, icDesc4);
		Assert.assertEquals("MPOTHERU", checkCode4);

	}
	
	@Test
	public void getSwitchfeeFromPartnerMerchantTest() {
		Map<Long,Double> partnerMerchantConfig = new HashMap<>();
		partnerMerchantConfig.put(941000922584L, 0.09);
		partnerMerchantConfig.put(941000922580L, 0.01);
		double switchFee1 = bilUtil.getSwitchfeeFromPartnerMerchant(partnerMerchantConfig, 941000922584L);
		Assert.assertEquals(0.09, switchFee1,0);
		
		double switchFee2 = bilUtil.getSwitchfeeFromPartnerMerchant(partnerMerchantConfig, 941000922580L);
		Assert.assertEquals(0.01, switchFee2,0);
		
		double switchFee3 = bilUtil.getSwitchfeeFromPartnerMerchant(partnerMerchantConfig, 941000922581L);
		Assert.assertEquals(0.0, switchFee3,0);
	}
	
	@Test
	public void generateReferenceNumberTest() throws ParseException {
		Date myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14");
		Date myDate2 = null;
		String refNumber = bilUtil.generateReferenceNumber("12", 2, false, "C", myDate, 94);
		Assert.assertEquals("7124045000000000941", refNumber);
		
		String refNumber2 = bilUtil.generateReferenceNumber("12", 0, false, "D", myDate, 94);
		Assert.assertEquals("2124045000000000946", refNumber2);
		
		String refNumber3 = bilUtil.generateReferenceNumber("12", 0, true, "D", myDate, 94);
		Assert.assertEquals("7124045000000000941", refNumber3);
		
		String refNumber4 = bilUtil.generateReferenceNumber("12", 2, true, "C", myDate, 94);
		Assert.assertEquals("7124045000000000941", refNumber4);
		
		String refNumber5 = bilUtil.generateReferenceNumber("12", -2, true, "C", myDate, 94);
		Assert.assertEquals("7124045000000000941", refNumber5);
		
		String refNumber6 = bilUtil.generateReferenceNumber("12", -2, true, "C", myDate2, 94);
		Assert.assertEquals("712", refNumber6);
		
		String refNumber7 = bilUtil.generateReferenceNumber(null, 2, true, null, myDate, 94);
		Assert.assertEquals("7null4045000000000941", refNumber7);
	}
	
	@Test
	public void checkPrivateConstructor(){
		try {
			Constructor<bilUtil> c = bilUtil.class.getDeclaredConstructor();
			c.setAccessible(true); 
			bilUtil bu = c.newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
