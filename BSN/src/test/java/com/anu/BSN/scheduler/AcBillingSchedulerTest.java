package com.anu.BSN.scheduler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.me.lc.billing.service.AcService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcBillingSchedulerTest {
	
	@Mock
	private AcService AcService;
	
	@InjectMocks
	 private AcBillingScheduler AcBillingScheduler;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void dailyBillingJobSchedularTest() {
		AcBillingScheduler.dailyBillingJobSchedular();
	}
	
	@Test
	public void AcFundingJobTest() {
		AcBillingScheduler.AcFundingJob();
	}

}
