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
import com.me.lc.bil.scheduler.AcbilScheduler;
import com.me.lc.bil.service.AcService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcbilControllerImplTest {

	@Mock
	private AcbilScheduler AcbilScheduler;

	@Mock
	private AcService AcService;
	
	@InjectMocks
	private AcbilControllerImpl AcbilControllerImpl;
	
	 @Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	 
	 @Test
	 public void dailybilTest() {
		 String returnStatus = "";
		 Mockito.when(AcService.dailybilJob("2018-10-10")).thenReturn("success");
		 returnStatus = AcbilControllerImpl.dailybil("2018-10-10");
		 Assert.assertEquals("success", returnStatus);
	 }
	
	 @Test
	 public void testApiTest() {
		 String returnStatus = "";
		 returnStatus = AcbilControllerImpl.testApi();
		 Assert.assertEquals("Successfully Running", returnStatus);
	 }
	 
	 @Test
	 public void AcMerchantFundingTest() {
		 String status = AcbilControllerImpl.AcMerchantFunding();
		 Assert.assertEquals("completed", status);
	 }
	 
	 @Test
	 public void clearDailybilDataByDateTest() {
		 String returnStatus = "";
		 
		 Mockito.when(AcService.clearDailybilDataByDateAPI("2018-10-10")).thenReturn("success");
		 returnStatus = AcbilControllerImpl.clearDailybilDataByDate("2018-10-12");
		 Assert.assertEquals(null, returnStatus);
		 
		 Mockito.when(AcService.clearDailybilDataByDateAPI("2018-10-12")).thenReturn("success");
		 returnStatus = AcbilControllerImpl.clearDailybilDataByDate("2018-10-12");
		 Assert.assertEquals("success", returnStatus);
	 }
}
