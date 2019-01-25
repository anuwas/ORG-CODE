package com.anu.BSN.service;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mes.lcr.billing.config.PartnerConfig;
import com.mes.lcr.billing.dao.AcclynkSettlementFileDTR;
import com.mes.lcr.billing.dao.AcculynkBillingRepository;
import com.mes.lcr.billing.dao.DailyDetailFileICDesc;
import com.mes.lcr.billing.dao.MBSDailySummaryIncomeExpense;
import com.mes.lcr.billing.dao.MbsPricing;
import com.mes.lcr.billing.dto.PinlessDebitNetworkFees;
import com.mes.lcr.util.BillingUtil;
import com.mes.lcr.util.ExpenseAcculynkDTRUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class LcDailyBillingServiceTest {
	
	public static final String DATE_FORMAT_DD_MM_YY = "dd/MM/yyyy";
	public static final String CARD_TYPE_VP = "VP";
	public static final String CARD_TYPE_MP = "MP";
	public static final int ACCULYNKSWITCHFEE = 227;
	public static final int DEBITNETWORKINTERCHANGE = 111;
	public static final int DEBITNETWORKFEE = 229;
	public static final int DEBITDISCOUNTFEE = 101;
	public static final int AUTHFEE = 1;

	@Mock
	private AcculynkBillingRepository acculynkBillingRepository;
	
	@Mock
	private PartnerConfig partnerConfig;
	
	@InjectMocks
	private LcrDailyBillingService lcrDailyBillingService;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void acceptTest() {
		Mockito.when(acculynkBillingRepository.getDailyDetailFileICDescVpMp()).thenReturn(provideDailyDetailFileICDescVpMp());
		Mockito.when(acculynkBillingRepository.getMerchantRawPricingFromLoadfile("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideMerchantRawPricingFromLoadfile());
		Mockito.when(acculynkBillingRepository.getSettlementDataFromLoadfileName("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideSettlementDataFromLoadfileName());
		Mockito.when(partnerConfig.getSwitchfeeconfig()).thenReturn(provideSwitchfeeconfig());
		Mockito.when(acculynkBillingRepository.callLoadFileIndex("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(1234567L);
		lcrDailyBillingService.accept("TEST.ACCULYNK.MeS.20181023.dat");
		
		Mockito.when(acculynkBillingRepository.getAcculynkSettlementDTRZeroDebitNetwork("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideAcculynkSettlementDTRZeroDebitNetwork1());
		Mockito.when(acculynkBillingRepository.getDailyDetailFileICDescVpMp()).thenReturn(provideDailyDetailFileICDescVpMp());
		Mockito.when(acculynkBillingRepository.getMerchantRawPricingFromLoadfile("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideMerchantRawPricingFromLoadfile());
		Mockito.when(acculynkBillingRepository.getSettlementDataFromLoadfileName("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideSettlementDataFromLoadfileName());
		Mockito.when(partnerConfig.getSwitchfeeconfig()).thenReturn(provideSwitchfeeconfig());
		Mockito.when(acculynkBillingRepository.callLoadFileIndex("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(1234567L);
		lcrDailyBillingService.accept("TEST.ACCULYNK.MeS.20181023.dat");
		
		Mockito.when(acculynkBillingRepository.getAcculynkSettlementDTRZeroDebitNetwork("TEST_ACCULYNK2018010101.txt")).thenReturn(provideAcculynkSettlementDTRZeroDebitNetwork1());
		Mockito.when(acculynkBillingRepository.getDailyDetailFileICDescVpMp()).thenReturn(provideDailyDetailFileICDescVpMp());
		Mockito.when(acculynkBillingRepository.getMerchantRawPricingFromLoadfile("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideMerchantRawPricingFromLoadfile());
		Mockito.when(acculynkBillingRepository.getSettlementDataFromLoadfileName("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideSettlementDataFromLoadfileName());
		Mockito.when(partnerConfig.getSwitchfeeconfig()).thenReturn(provideSwitchfeeconfig());
		Mockito.when(acculynkBillingRepository.callLoadFileIndex("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(1234567L);
		lcrDailyBillingService.accept("TEST.ACCULYNK.MeS.20181023.dat");
		
		Mockito.when(acculynkBillingRepository.getAcculynkSettlementDTRZeroDebitNetwork("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(null);
		Mockito.when(acculynkBillingRepository.getDailyDetailFileICDescVpMp()).thenReturn(provideDailyDetailFileICDescVpMp());
		Mockito.when(acculynkBillingRepository.getMerchantRawPricingFromLoadfile("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideMerchantRawPricingFromLoadfile());
		Mockito.when(acculynkBillingRepository.getSettlementDataFromLoadfileName("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(provideSettlementDataFromLoadfileName());
		Mockito.when(partnerConfig.getSwitchfeeconfig()).thenReturn(provideSwitchfeeconfig());
		Mockito.when(acculynkBillingRepository.callLoadFileIndex("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(1234567L);
		lcrDailyBillingService.accept("TEST.ACCULYNK.MeS.20181023.dat");
		
		Mockito.when(acculynkBillingRepository.getAcculynkSettlementDTRZeroDebitNetwork("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(null);
		Mockito.when(acculynkBillingRepository.getDailyDetailFileICDescVpMp()).thenReturn(null);
		Mockito.when(acculynkBillingRepository.getMerchantRawPricingFromLoadfile("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(null);
		Mockito.when(acculynkBillingRepository.getSettlementDataFromLoadfileName("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(null);
		Mockito.when(partnerConfig.getSwitchfeeconfig()).thenReturn(null);
		Mockito.when(acculynkBillingRepository.callLoadFileIndex("TEST.ACCULYNK.MeS.20181023.dat")).thenReturn(null);
		lcrDailyBillingService.accept("TEST.ACCULYNK.MeS.20181023.dat");
		
	}
	
	@Test
	public void populateIncomeTest() throws Exception {
		Class<LcrDailyBillingService> clazz1 = LcrDailyBillingService.class;
		Method met1 = clazz1.getDeclaredMethod("populateIncome", List.class,Map.class,Map.class);
		met1.setAccessible(true);
		
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList1 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), provideMBSDailySummaryIncomeExpense1(),provideMerchantRawPricingFromLoadfile(),provideDailyDetailFileICDescVpMp1());
		
		Assert.assertEquals(941000122088L, mbsDailySummaryIncomeExpenseList1.get(0).getMerchantNumber());
		Assert.assertEquals(227, mbsDailySummaryIncomeExpenseList1.get(0).getItemType());
		Assert.assertEquals("VP", mbsDailySummaryIncomeExpenseList1.get(0).getItemSubclass());
		Assert.assertEquals(3.2, mbsDailySummaryIncomeExpenseList1.get(0).getExpense(),0);
		Assert.assertEquals("STAR", mbsDailySummaryIncomeExpenseList1.get(0).getNetwork());
		
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList2 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), null,provideMerchantRawPricingFromLoadfile(),provideDailyDetailFileICDescVpMp());
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList3 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), provideMBSDailySummaryIncomeExpense1(),provideMerchantRawPricingFromLoadfile(),null);
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList4 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), provideMBSDailySummaryIncomeExpense1(),provideMerchantRawPricingFromLoadfile(),new HashMap<>());
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList5 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), provideMBSDailySummaryIncomeExpense2(),provideMerchantRawPricingFromLoadfile2(),provideDailyDetailFileICDescVpMp2());
	}
	
	@Test
	public void populateExpenseTest() throws Exception {
		Class<LcrDailyBillingService> clazz1 = LcrDailyBillingService.class;
		Method met1 = clazz1.getDeclaredMethod("populateExpense", List.class,Map.class);
		met1.setAccessible(true);
		
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList1 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), null,providePartnerSwithFeeConfig());
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList2 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), new ArrayList<>(),providePartnerSwithFeeConfig());
		List<MBSDailySummaryIncomeExpense>  mbsDailySummaryIncomeExpenseList3 = (List<MBSDailySummaryIncomeExpense>) met1.invoke(new LcrDailyBillingService(), provideMBSDailySummaryIncomeExpense2(),providePartnerSwithFeeConfig2());
		
		Assert.assertEquals(941000922495L, mbsDailySummaryIncomeExpenseList3.get(0).getMerchantNumber());
		Assert.assertEquals("VP", mbsDailySummaryIncomeExpenseList3.get(0).getItemSubclass());
		Assert.assertEquals(227, mbsDailySummaryIncomeExpenseList3.get(0).getItemType());
		Assert.assertEquals(36.599999999999994, mbsDailySummaryIncomeExpenseList3.get(0).getExpense(),0);
		Assert.assertEquals("STAR", mbsDailySummaryIncomeExpenseList3.get(0).getNetwork());
	}
	
	public Map<Long,Double> providePartnerSwithFeeConfig(){
		Map<Long,Double> partner = new HashMap<>();
		return partner;
	}
	public Map<Long,Double> providePartnerSwithFeeConfig2(){
		Map<Long,Double> partner = new HashMap<>();
		partner.put(941000922495L, 12.20);
		return partner;
	}
	
	
	public static List<MBSDailySummaryIncomeExpense> provideMBSDailySummaryIncomeExpense1() throws ParseException {
		AcclynkSettlementFileDTR acclynkSettlementFileDTR_VP = new AcclynkSettlementFileDTR();
		long merchantNumber = 941000122088L;
		acclynkSettlementFileDTR_VP.setDtrSeqNum(111);
		acclynkSettlementFileDTR_VP.setMerchantNumber(merchantNumber);
		acclynkSettlementFileDTR_VP.setDtrSeqNum(112);
		acclynkSettlementFileDTR_VP.setSwitchfee(-0.20);
		acclynkSettlementFileDTR_VP.setNetworkfee(-0.02);
		acclynkSettlementFileDTR_VP.setInterchangeFee(0.0);
		acclynkSettlementFileDTR_VP.setCardtype(CARD_TYPE_VP);
		acclynkSettlementFileDTR_VP.setTransactionDateTime(new SimpleDateFormat(DATE_FORMAT_DD_MM_YY).parse("02/02/2018"));
		acclynkSettlementFileDTR_VP.setApprovalAmount(10);
		acclynkSettlementFileDTR_VP.setTransactionAmount(10);
		acclynkSettlementFileDTR_VP.setNetwork("STAR");
		acclynkSettlementFileDTR_VP.setSalesCount(3);
		acclynkSettlementFileDTR_VP.setSalesAmount(10);
		acclynkSettlementFileDTR_VP.setCreditCount(0);
		acclynkSettlementFileDTR_VP.setCreditAmount(0);
		acclynkSettlementFileDTR_VP.setItemCount(10);
		acclynkSettlementFileDTR_VP.setItemAmount(10);
		acclynkSettlementFileDTR_VP.setSwitchfee(3.20);
		acclynkSettlementFileDTR_VP.setInterchangeFee(2.20);
		acclynkSettlementFileDTR_VP.setNetworkfee(1.20);
		acclynkSettlementFileDTR_VP.setRegulatedIndicator("R");

		List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRList = new ArrayList<>();
		acclynkSettlementFileDTRList.add(acclynkSettlementFileDTR_VP);
		
		List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseGenericList = ExpenseAcculynkDTRUtil.manupulateExpenseFromAcculynkDTR(acclynkSettlementFileDTRList);
				
		return mBSDailySummaryIncomeExpenseGenericList;
	}
	
	public static List<MBSDailySummaryIncomeExpense> provideMBSDailySummaryIncomeExpense2() throws ParseException {
		AcclynkSettlementFileDTR acclynkSettlementFileDTR_VP = new AcclynkSettlementFileDTR();
		long merchantNumber = 941000922495L;
		acclynkSettlementFileDTR_VP.setDtrSeqNum(227);
		acclynkSettlementFileDTR_VP.setMerchantNumber(merchantNumber);
		acclynkSettlementFileDTR_VP.setDtrSeqNum(112);
		acclynkSettlementFileDTR_VP.setSwitchfee(-0.20);
		acclynkSettlementFileDTR_VP.setNetworkfee(-0.02);
		acclynkSettlementFileDTR_VP.setInterchangeFee(0.0);
		acclynkSettlementFileDTR_VP.setCardtype(CARD_TYPE_VP);
		acclynkSettlementFileDTR_VP.setTransactionDateTime(new SimpleDateFormat(DATE_FORMAT_DD_MM_YY).parse("02/02/2018"));
		acclynkSettlementFileDTR_VP.setApprovalAmount(10);
		acclynkSettlementFileDTR_VP.setTransactionAmount(10);
		acclynkSettlementFileDTR_VP.setNetwork("STAR");
		acclynkSettlementFileDTR_VP.setSalesCount(3);
		acclynkSettlementFileDTR_VP.setSalesAmount(10);
		acclynkSettlementFileDTR_VP.setCreditCount(0);
		acclynkSettlementFileDTR_VP.setCreditAmount(0);
		acclynkSettlementFileDTR_VP.setItemCount(10);
		acclynkSettlementFileDTR_VP.setItemAmount(10);
		acclynkSettlementFileDTR_VP.setSwitchfee(3.20);
		acclynkSettlementFileDTR_VP.setInterchangeFee(2.20);
		acclynkSettlementFileDTR_VP.setNetworkfee(1.20);
		acclynkSettlementFileDTR_VP.setRegulatedIndicator("R");

		List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRList = new ArrayList<>();
		acclynkSettlementFileDTRList.add(acclynkSettlementFileDTR_VP);
		
		List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseGenericList = ExpenseAcculynkDTRUtil.manupulateExpenseFromAcculynkDTR(acclynkSettlementFileDTRList);
				
		return mBSDailySummaryIncomeExpenseGenericList;
	}
	
	public Map<Long,Double> provideSwitchfeeconfig(){
		Map<Long,Double> partnerConfig = new HashMap<>();
		partnerConfig.put(3941400184L, 0.09);
		return partnerConfig;
	}
	
	public List<AcclynkSettlementFileDTR> provideSettlementDataFromLoadfileName(){
		AcclynkSettlementFileDTR acclynkSettlementFileDTR = new AcclynkSettlementFileDTR();
		List<AcclynkSettlementFileDTR> lst = new ArrayList<>();
		acclynkSettlementFileDTR.setMerchantNumber(941000119439L);
	    acclynkSettlementFileDTR.setSwitchfee(-0.059);
	    acclynkSettlementFileDTR.setNetworkfee(-0.04);
	    acclynkSettlementFileDTR.setCardtype("VP");
	    acclynkSettlementFileDTR.setTransactionDateTime(new Date());
	    acclynkSettlementFileDTR.setInterchangeFee(-0.23);
	    acclynkSettlementFileDTR.setDiscountFee(0);
	    acclynkSettlementFileDTR.setSalesCount(1);
	    acclynkSettlementFileDTR.setSalesAmount(20);
	    acclynkSettlementFileDTR.setCreditCount(0);
	    acclynkSettlementFileDTR.setCreditAmount(0);
	    acclynkSettlementFileDTR.setItemCount(1);
	    acclynkSettlementFileDTR.setItemAmount(20);
	    acclynkSettlementFileDTR.setLoadFilename("lcr3941_102518_002.dat");
	    acclynkSettlementFileDTR.setLoadFileId(49211959);
	    acclynkSettlementFileDTR.setBatchDate(new Date());
	    acclynkSettlementFileDTR.setNetwork("STAR");
	    acclynkSettlementFileDTR.setRegulatedIndicator("R");
	    
	    lst.add(acclynkSettlementFileDTR);
	    return lst;
	}
	
	public Map<String, MbsPricing> provideMerchantRawPricingFromLoadfile(){
		Map<String, MbsPricing> merchantRawPricingMap = new HashMap<>();
		MbsPricing mbsPricing = new MbsPricing();
		mbsPricing.setMerchantNumber(941000922495L);
		mbsPricing.setItemSubclass("MP");
		mbsPricing.setRate(0.1);
		mbsPricing.setPerItem(1.1);
		mbsPricing.setItemType(227);
		final String checkCode = BillingUtil.generateCheckCodeFromPricingObj(941000922495L, "MP", 227);
		merchantRawPricingMap.put(checkCode, mbsPricing);
		return merchantRawPricingMap;
	}
	
	public Map<String, MbsPricing> provideMerchantRawPricingFromLoadfile2(){
		Map<String, MbsPricing> merchantRawPricingMap = new HashMap<>();
		MbsPricing mbsPricing = new MbsPricing();
		mbsPricing.setMerchantNumber(941000922495L);
		mbsPricing.setItemSubclass("VP");
		mbsPricing.setRate(0.1);
		mbsPricing.setPerItem(1.1);
		mbsPricing.setItemType(227);
		final String checkCode = BillingUtil.generateCheckCodeFromPricingObj(941000922495L, "VP", 227);
		merchantRawPricingMap.put(checkCode, mbsPricing);
		return merchantRawPricingMap;
	}
	
	public Map<String, MbsPricing> provideMerchantRawPricingFromLoadfile1(){
		Map<String, MbsPricing> merchantRawPricingMap = new HashMap<>();
		MbsPricing mbsPricing = new MbsPricing();
		mbsPricing.setMerchantNumber(941000922495L);
		mbsPricing.setItemSubclass("MP");
		mbsPricing.setRate(0.1);
		mbsPricing.setPerItem(1.1);
		mbsPricing.setItemType(227);
		final String checkCode = BillingUtil.generateCheckCodeFromPricingObj(941000922495L, "MP", 227);
		merchantRawPricingMap.put(checkCode, mbsPricing);
		return merchantRawPricingMap;
	}
	
	public Map<String, DailyDetailFileICDesc> provideDailyDetailFileICDescVpMp(){
		Map<String, DailyDetailFileICDesc> dailyDetailFileICDescMap = new HashMap<>();
		DailyDetailFileICDesc dailyDetailFileICDesc = new DailyDetailFileICDesc();
		dailyDetailFileICDesc.setRecId(5115128);
		dailyDetailFileICDesc.setCardType("MP");
		dailyDetailFileICDesc.setIcCode("02A");
		dailyDetailFileICDesc.setIcDesc("Pulse - Regulated");
		dailyDetailFileICDesc.setIcRate(0.05);
		dailyDetailFileICDesc.setIcRatePerItem(0.315);
		dailyDetailFileICDesc.setValidDateBegin(new Date());
		dailyDetailFileICDesc.setValidDateEnd(new Date());
		dailyDetailFileICDesc.setRegIcCode("02A");
		dailyDetailFileICDesc.setBaseRate(0.05);
		dailyDetailFileICDesc.setBasePerItem(0.315);
		final String generateCustomCheckCode = BillingUtil.generateCheckCodeFromDailyDetailFileICDescObj("MP", "Pulse - Regulated");
		
		dailyDetailFileICDesc.setCustomCheckCode(generateCustomCheckCode);
		dailyDetailFileICDescMap.put(generateCustomCheckCode, dailyDetailFileICDesc);
		
		return dailyDetailFileICDescMap;
	}
	
	public Map<String, DailyDetailFileICDesc> provideDailyDetailFileICDescVpMp1(){
		Map<String, DailyDetailFileICDesc> dailyDetailFileICDescMap = new HashMap<>();
		DailyDetailFileICDesc dailyDetailFileICDesc = new DailyDetailFileICDesc();
		dailyDetailFileICDesc.setRecId(5115128);
		dailyDetailFileICDesc.setCardType("VP");
		dailyDetailFileICDesc.setIcCode("02A");
		dailyDetailFileICDesc.setIcDesc("Star - Regulated");
		dailyDetailFileICDesc.setIcRate(0.05);
		dailyDetailFileICDesc.setIcRatePerItem(0.315);
		dailyDetailFileICDesc.setValidDateBegin(new Date());
		dailyDetailFileICDesc.setValidDateEnd(new Date());
		dailyDetailFileICDesc.setRegIcCode("02A");
		dailyDetailFileICDesc.setBaseRate(0.05);
		dailyDetailFileICDesc.setBasePerItem(0.315);
		final String generateCustomCheckCode = BillingUtil.generateCheckCodeFromDailyDetailFileICDescObj("VP", "Star - Regulated");
		
		dailyDetailFileICDesc.setCustomCheckCode(generateCustomCheckCode);
		dailyDetailFileICDescMap.put(generateCustomCheckCode, dailyDetailFileICDesc);
		
		return dailyDetailFileICDescMap;
	}
	
	public Map<String, DailyDetailFileICDesc> provideDailyDetailFileICDescVpMp2(){
		Map<String, DailyDetailFileICDesc> dailyDetailFileICDescMap = new HashMap<>();
		DailyDetailFileICDesc dailyDetailFileICDesc = new DailyDetailFileICDesc();
		dailyDetailFileICDesc.setRecId(5115128);
		dailyDetailFileICDesc.setCardType("VP");
		dailyDetailFileICDesc.setIcCode("02A");
		dailyDetailFileICDesc.setIcDesc("Star - Regulated");
		dailyDetailFileICDesc.setIcRate(0.05);
		dailyDetailFileICDesc.setIcRatePerItem(0.315);
		dailyDetailFileICDesc.setValidDateBegin(new Date());
		dailyDetailFileICDesc.setValidDateEnd(new Date());
		dailyDetailFileICDesc.setRegIcCode("02A");
		dailyDetailFileICDesc.setBaseRate(0.05);
		dailyDetailFileICDesc.setBasePerItem(0.315);
		final String generateCustomCheckCode = BillingUtil.generateCheckCodeFromDailyDetailFileICDescObj("VP", "Star - Regulated");
		
		dailyDetailFileICDesc.setCustomCheckCode(generateCustomCheckCode);
		dailyDetailFileICDescMap.put(generateCustomCheckCode, dailyDetailFileICDesc);
		
		return dailyDetailFileICDescMap;
	}
	
	public List<AcclynkSettlementFileDTR> provideDailyDetailFileDtList(){
		List<AcclynkSettlementFileDTR> pinlessDebitNetworkFeesList = new ArrayList<>();
		AcclynkSettlementFileDTR acclynkSettlementFileDTRObj1 = new AcclynkSettlementFileDTR();
		acclynkSettlementFileDTRObj1.setNetwork("STAR");
		acclynkSettlementFileDTRObj1.setApprovalAmount(112.00);
		acclynkSettlementFileDTRObj1.setNetworkfee(12.00);
		pinlessDebitNetworkFeesList.add(acclynkSettlementFileDTRObj1);
		return pinlessDebitNetworkFeesList;
	}
	
	private static double calculateDNfromPDNetworks(List<PinlessDebitNetworkFees> pinlessDebitNetworkFees, String network, double approvalAmount) throws Exception {
		double debitNetworkFee = 0;
		Class<LcrDailyBillingService> clazz1 = LcrDailyBillingService.class;
		Method met1 = clazz1.getDeclaredMethod("calculateDNfromPDNetworks", List.class,String.class,double.class);
		met1.setAccessible(true);
		debitNetworkFee = (double) met1.invoke(new LcrDailyBillingService(), pinlessDebitNetworkFees,network,approvalAmount);
		return debitNetworkFee;
	}
	

	
	public List<Long> provideMerchantNumber(){
		List<Long> merchantLIst = new ArrayList<>();
		merchantLIst.add(941000922584L);
		merchantLIst.add(941000922580L);
		merchantLIst.add(941000922581L);
		return merchantLIst;
	}
	
	@Test
	public void getPartnerMerchantSwitchFeesTest() {
		
		Mockito.when(acculynkBillingRepository.getParnterMerchants(3941400180L)).thenReturn(provideMerchantNumber());
		Map<Long,Double> partnerConfig1 = new HashMap<>();
		partnerConfig1.put(3941400180L, 0.07);
		Map<Long,Double> merchatWithSwitchFee = lcrDailyBillingService.getPartnerMerchantSwitchFees(partnerConfig1);
		
		Assert.assertEquals(0.07,merchatWithSwitchFee.get(941000922584L),0);
		Assert.assertEquals(0.07,merchatWithSwitchFee.get(941000922580L),0);
		Assert.assertEquals(0.07,merchatWithSwitchFee.get(941000922581L),0);
	}
	
	public Map<Long,Double> matchMerchatWithPartner(Map<Long,Double> partnerConfig,List<Long> merchantList){
		Map<Long,Double> merchatWithSwitchFee = new HashMap<>();
		for(Map.Entry<Long, Double> confObj : partnerConfig.entrySet()) {
			for(Long merchantObj : merchantList) {
				merchatWithSwitchFee.put(merchantObj, confObj.getValue());
			}
		}
		return merchatWithSwitchFee;
	}
	
	
	@Test
	public void calculateDNfromPDNetworksTest() throws Exception {
		double approvalAmount = 0;
		double debitNetworkFee = 0;
		DecimalFormat df2 = new DecimalFormat(".##");
		List<PinlessDebitNetworkFees> pinlessDebitNetworkFees = providePinlessDebitNetworkFees();
		String network="STAR";
		approvalAmount=110.00;
		debitNetworkFee = 0;
		
		Class<LcrDailyBillingService> clazz1 = LcrDailyBillingService.class;
		Method met1 = clazz1.getDeclaredMethod("calculateDNfromPDNetworks", List.class,String.class,double.class);
		met1.setAccessible(true);
		
		debitNetworkFee = (double) met1.invoke(new LcrDailyBillingService(), pinlessDebitNetworkFees,network,approvalAmount);
		String formatedDebitNetworkFee1 = df2.format(debitNetworkFee);
		Assert.assertEquals("3.64",formatedDebitNetworkFee1);
		
		network="PULS";
		approvalAmount=120.00;
		debitNetworkFee = (double) met1.invoke(new LcrDailyBillingService(), pinlessDebitNetworkFees,network,approvalAmount);
		String formatedDebitNetworkFee2 = df2.format(debitNetworkFee);
		Assert.assertEquals("4.75",formatedDebitNetworkFee2);
	}
	
	public static List<PinlessDebitNetworkFees> providePinlessDebitNetworkFees(){
		List<PinlessDebitNetworkFees> pinlessDebitNetworkFeesList = new ArrayList<>();
		PinlessDebitNetworkFees pinlessDebitNetworkFeesObj1 = new PinlessDebitNetworkFees();
		PinlessDebitNetworkFees pinlessDebitNetworkFeesObj2 = new PinlessDebitNetworkFees();
		pinlessDebitNetworkFeesObj1.setNetwork("STAR");
		pinlessDebitNetworkFeesObj1.setPerItem(1.22);
		pinlessDebitNetworkFeesObj1.setRate(2.2);
		pinlessDebitNetworkFeesObj1.setRecId(10000);
		
		pinlessDebitNetworkFeesObj2.setNetwork("PULS");
		pinlessDebitNetworkFeesObj2.setPerItem(2.11);
		pinlessDebitNetworkFeesObj2.setRate(2.2);
		pinlessDebitNetworkFeesObj2.setRecId(11000);
		
		pinlessDebitNetworkFeesList.add(pinlessDebitNetworkFeesObj1);
		pinlessDebitNetworkFeesList.add(pinlessDebitNetworkFeesObj2);
		
		return pinlessDebitNetworkFeesList;
	}
	
	public static List<AcclynkSettlementFileDTR> provideAcculynkSettlementDTRZeroDebitNetwork1(){
		List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRList = new ArrayList<>();
		
		AcclynkSettlementFileDTR acclynkSettlementFileDTRObj1 = new AcclynkSettlementFileDTR();
		AcclynkSettlementFileDTR acclynkSettlementFileDTRObj2 = new AcclynkSettlementFileDTR();
		
		acclynkSettlementFileDTRObj1.setDtrSeqNum(1234);
		acclynkSettlementFileDTRObj1.setSwitchfee(-0.059);
		acclynkSettlementFileDTRObj1.setNetworkfee(-0.04);
		acclynkSettlementFileDTRObj1.setCardtype("VP");
		acclynkSettlementFileDTRObj1.setTransactionDateTime(new Date());
		acclynkSettlementFileDTRObj1.setInterchangeFee(-0.23);
		acclynkSettlementFileDTRObj1.setTransactionAmount(12.00);
		acclynkSettlementFileDTRObj1.setApprovalAmount(12.00);
		acclynkSettlementFileDTRObj1.setNetwork("STAR");
		
		acclynkSettlementFileDTRObj2.setDtrSeqNum(1234);
		acclynkSettlementFileDTRObj2.setSwitchfee(-0.059);
		acclynkSettlementFileDTRObj2.setNetworkfee(-0.04);
		acclynkSettlementFileDTRObj2.setCardtype("VP");
		acclynkSettlementFileDTRObj2.setTransactionDateTime(new Date());
		acclynkSettlementFileDTRObj2.setInterchangeFee(-0.23);
		acclynkSettlementFileDTRObj2.setTransactionAmount(12.00);
		acclynkSettlementFileDTRObj2.setApprovalAmount(12.00);
		acclynkSettlementFileDTRObj2.setNetwork("STAR");
		
		acclynkSettlementFileDTRList.add(acclynkSettlementFileDTRObj1);
		acclynkSettlementFileDTRList.add(acclynkSettlementFileDTRObj2);
		
		return acclynkSettlementFileDTRList;
	}
}
