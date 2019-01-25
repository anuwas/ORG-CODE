package com.anu.BSN.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mes.lcr.billing.dao.AcculynkBillingRepository;
import com.mes.lcr.billing.dao.DailyDetailFileDTF;
import com.mes.ps.billing.util.DateTimeUtils;


@RunWith(SpringJUnit4ClassRunner.class)
public class AcServiceImplTest {
	
	 @Mock
	 private AcculynkBillingRepository acculynkBillingRepository;

	 @Mock
	 private LcrDailyBillingService lcrDailyBillingService;
	 
	 @InjectMocks
	 private AcculynkServiceImpl acculynkServiceImpl;

	 @Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	 
	 @Test
	 public void dailyBillingJobTest() {
		 List<String> fileNameList = new ArrayList<>();
		 fileNameList.add("TEST_ACCULYNK2018010101");
		 fileNameList.add("TEST_ACCULYNK2018010102");
		 Mockito.when(acculynkBillingRepository.getListofSettlementFilesnotBilled("2018-10-10")).thenReturn(fileNameList);
		 String status = acculynkServiceImpl.dailyBillingJob("2018-10-10");
		 Assert.assertEquals("success", status);
		 
		 List<String> fileNameList2 = new ArrayList<>();
		 Mockito.when(acculynkBillingRepository.getListofSettlementFilesnotBilled("2018-10-10")).thenReturn(fileNameList2);
		 String status2 = acculynkServiceImpl.dailyBillingJob("2018-10-10");
		 Assert.assertEquals("success", status2);
		 
		 List<String> fileNameList3 = null;
		 Mockito.when(acculynkBillingRepository.getListofSettlementFilesnotBilled("2018-10-10")).thenReturn(fileNameList3);
		 String status3 = acculynkServiceImpl.dailyBillingJob("2018-10-10");
		 Assert.assertEquals("success", status3);
	 }
	 
	@Test
	  public void updateMonthlyBillingSummary() throws ParseException {
		String loadFileName = this.generateLoadFileName(3941);
	    Assert.assertEquals("lcr3941_020118_001.dat", loadFileName);
	  }
	
	private String generateLoadFileName(long bankNumber) throws ParseException{
		String sDate1="10/02/2018";  
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    String firstDayOfMonth = new SimpleDateFormat("MMddyy").format(DateTimeUtils.getDate(date1, -1, 0));
	    String loadFilename = "lcr" + bankNumber + "_" + firstDayOfMonth + "_001.dat";
	    return loadFilename;
	  }
	
	public static List<DailyDetailFileDTF> getDailyDetailFundingList() {
		List<DailyDetailFileDTF> dailyDetailFileDTFList = new ArrayList<>();
		DailyDetailFileDTF dailyDetailFileDTFObj1 = new DailyDetailFileDTF();
		DailyDetailFileDTF dailyDetailFileDTFObj2 = new DailyDetailFileDTF();
		DailyDetailFileDTF dailyDetailFileDTFObj3 = new DailyDetailFileDTF();
		DailyDetailFileDTF dailyDetailFileDTFObj4 = new DailyDetailFileDTF();
		
		dailyDetailFileDTFObj1.setBankNumber(3941);
		dailyDetailFileDTFObj1.setBatchDate(new java.sql.Date(new Date().getTime()));
		dailyDetailFileDTFObj1.setMerchantName("THOMAS MULLER");
		dailyDetailFileDTFObj1.setMerchantAccountNumber(941000121829L);
		dailyDetailFileDTFObj1.setMifTransitRoutngNum(941000121829L);
		dailyDetailFileDTFObj1.setMifDdaNum("XXX");
		dailyDetailFileDTFObj1.setTransactionAmount(12.30);
		dailyDetailFileDTFObj1.setBatchNumber("11");
		dailyDetailFileDTFObj1.setReferenceNumber("REF1");
		
		
		dailyDetailFileDTFObj2.setBankNumber(3941);
		dailyDetailFileDTFObj2.setBatchDate(new java.sql.Date(new Date().getTime()));
		dailyDetailFileDTFObj2.setMerchantName("ADISION ARANTOS DO NASIMENTO");
		dailyDetailFileDTFObj2.setMerchantAccountNumber(941000121820L);
		dailyDetailFileDTFObj2.setMifTransitRoutngNum(941000121820L);
		dailyDetailFileDTFObj2.setMifDdaNum("YYY");
		dailyDetailFileDTFObj2.setTransactionAmount(14.20);
		dailyDetailFileDTFObj2.setBatchNumber("12");
		dailyDetailFileDTFObj2.setReferenceNumber("REF1");
		
		dailyDetailFileDTFObj3.setBankNumber(3941);
		dailyDetailFileDTFObj3.setBatchDate(new java.sql.Date(new Date().getTime()));
		dailyDetailFileDTFObj3.setMerchantName(null);
		dailyDetailFileDTFObj3.setMerchantAccountNumber(0);
		dailyDetailFileDTFObj3.setMifTransitRoutngNum(941000121820L);
		dailyDetailFileDTFObj3.setMifDdaNum("YYY");
		dailyDetailFileDTFObj3.setTransactionAmount(14.20);
		dailyDetailFileDTFObj3.setBatchNumber("12");
		dailyDetailFileDTFObj3.setReferenceNumber("REF1");
		
		dailyDetailFileDTFObj4.setBankNumber(3941);
		dailyDetailFileDTFObj4.setBatchDate(new java.sql.Date(new Date().getTime()));
		dailyDetailFileDTFObj4.setMerchantName("");
		dailyDetailFileDTFObj4.setMerchantAccountNumber(941000121820L);
		dailyDetailFileDTFObj4.setMifTransitRoutngNum(941000121820L);
		dailyDetailFileDTFObj4.setMifDdaNum("YYY");
		dailyDetailFileDTFObj4.setTransactionAmount(14.20);
		dailyDetailFileDTFObj4.setBatchNumber("12");
		dailyDetailFileDTFObj4.setReferenceNumber("REF1");
		

		dailyDetailFileDTFList.add(dailyDetailFileDTFObj1);
		dailyDetailFileDTFList.add(dailyDetailFileDTFObj2);
		dailyDetailFileDTFList.add(dailyDetailFileDTFObj3);
		dailyDetailFileDTFList.add(dailyDetailFileDTFObj4);
		
		return dailyDetailFileDTFList;
	}
	
	public static List<DailyDetailFileDTF> getDailyDetailFundingList1() {
		List<DailyDetailFileDTF> dailyDetailFileDTFList = new ArrayList<>();
		DailyDetailFileDTF dailyDetailFileDTFObj1 = new DailyDetailFileDTF();
		
		dailyDetailFileDTFObj1.setBankNumber(3941);
		dailyDetailFileDTFObj1.setBatchDate(null);
		dailyDetailFileDTFObj1.setMerchantName("THOMAS MULLER");
		dailyDetailFileDTFObj1.setMerchantAccountNumber(941000121829L);
		dailyDetailFileDTFObj1.setMifTransitRoutngNum(941000121829L);
		dailyDetailFileDTFObj1.setMifDdaNum("XXX");
		dailyDetailFileDTFObj1.setTransactionAmount(12.30);
		dailyDetailFileDTFObj1.setBatchNumber("11");
		dailyDetailFileDTFObj1.setReferenceNumber("REF1");
		
		dailyDetailFileDTFList.add(dailyDetailFileDTFObj1);
		
		return dailyDetailFileDTFList;
	}
	
	
	 @Test
	 public void acculynkFundingJobTest(){
		acculynkServiceImpl.acculynkFundingJob();
		
		Mockito.when(acculynkBillingRepository.getDailyDetailFundingList()).thenReturn(new ArrayList<DailyDetailFileDTF>());
		acculynkServiceImpl.acculynkFundingJob();
		
		Mockito.when(acculynkBillingRepository.getDailyDetailFundingList()).thenReturn(getDailyDetailFundingList());
		acculynkServiceImpl.acculynkFundingJob();
		
		Mockito.when(acculynkBillingRepository.getDailyDetailFundingList()).thenReturn(null);
		try {
			acculynkServiceImpl.acculynkFundingJob();
		}catch(Exception ex) {
			System.out.println("ArrayList<DailyDetailFileDTF>() null");
		}
		
		Mockito.when(acculynkBillingRepository.getDailyDetailFundingList()).thenReturn(getDailyDetailFundingList());
		acculynkServiceImpl.acculynkFundingJob(); 
		
		Mockito.when(acculynkBillingRepository.getDailyDetailFundingList()).thenReturn(getDailyDetailFundingList1());
		acculynkServiceImpl.acculynkFundingJob(); 
	 }
	 
	 @Test
	 public void clearDailyBillingDataByDateAPITest() {
		 String returnStatus = "";
		 List<String> loadfileNames = Arrays.asList(new String("TEXT.ACCULYNL1.dat"),new String("TEXT.ACCULYNL2.dat"));
		 
		 
		 Mockito.when(acculynkBillingRepository.cleanAcculynkDailyBillingDataByLoadfileDate("2018-01-01",loadfileNames)).thenReturn(true);
		 returnStatus = acculynkServiceImpl.clearDailyBillingDataByDateAPI("2018-01-01");
		 
		 Assert.assertEquals("fail", returnStatus);
		 Mockito.when(acculynkBillingRepository.cleanAcculynkDailyBillingDataByLoadfileDate("2018-01-01",new ArrayList<>())).thenReturn(false);
		 returnStatus =  acculynkServiceImpl.clearDailyBillingDataByDateAPI("2018-01-01");
		 Assert.assertEquals("fail", returnStatus);
		 
		 Mockito.when(acculynkBillingRepository.cleanAcculynkDailyBillingDataByLoadfileDate("",loadfileNames)).thenReturn(false);
		 returnStatus = acculynkServiceImpl.clearDailyBillingDataByDateAPI("2018-01-01");
		 
		 Assert.assertEquals("fail", returnStatus);
		 Mockito.when(acculynkBillingRepository.getListofSettlementFilesToClear("2018-01-01")).thenReturn(loadfileNames);
		 Mockito.when(acculynkBillingRepository.cleanAcculynkDailyBillingDataByLoadfileDate("2018-01-01",loadfileNames)).thenReturn(true);
		 returnStatus = acculynkServiceImpl.clearDailyBillingDataByDateAPI("2018-01-01");
		 
		 
		 Assert.assertEquals("success", returnStatus);
	 }
}
