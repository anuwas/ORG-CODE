package com.anu.BSN.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.me.lc.billing.scheduler.AcBillingScheduler;
import com.me.lc.billing.service.AcService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcBillingControllerImplTest {

	@Mock
	private AcBillingScheduler AcBillingScheduler;

	@Mock
	private AcService AcService;
	
	@InjectMocks
	private AcBillingControllerImpl AcBillingControllerImpl;
	
	 @Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	 
	 @Test
	 public void dailyBillingTest() {
		 String returnStatus = "";
		 Mockito.when(AcService.dailyBillingJob("2018-10-10")).thenReturn("success");
		 returnStatus = AcBillingControllerImpl.dailyBilling("2018-10-10");
		 Assert.assertEquals("success", returnStatus);
	 }
	
	 @Test
	 public void testApiTest() {
		 String returnStatus = "";
		 returnStatus = AcBillingControllerImpl.testApi();
		 Assert.assertEquals("Successfully Running", returnStatus);
	 }
	 
	 @Test
	 public void AcMerchantFundingTest() {
		 String status = AcBillingControllerImpl.AcMerchantFunding();
		 Assert.assertEquals("completed", status);
	 }
	 
	 @Test
	 public void clearDailyBillingDataByDateTest() {
		 String returnStatus = "";
		 
		 Mockito.when(AcService.clearDailyBillingDataByDateAPI("2018-10-10")).thenReturn("success");
		 returnStatus = AcBillingControllerImpl.clearDailyBillingDataByDate("2018-10-12");
		 Assert.assertEquals(null, returnStatus);
		 
		 Mockito.when(AcService.clearDailyBillingDataByDateAPI("2018-10-12")).thenReturn("success");
		 returnStatus = AcBillingControllerImpl.clearDailyBillingDataByDate("2018-10-12");
		 Assert.assertEquals("success", returnStatus);
	 }
}
