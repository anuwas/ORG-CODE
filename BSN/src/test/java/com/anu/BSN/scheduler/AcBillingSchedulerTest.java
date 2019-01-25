package com.anu.BSN.scheduler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mes.lc.billing.service.AcculynkService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcBillingSchedulerTest {
	
	@Mock
	private AcculynkService acculynkService;
	
	@InjectMocks
	 private AcculynkBillingScheduler acculynkBillingScheduler;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void dailyBillingJobSchedularTest() {
		acculynkBillingScheduler.dailyBillingJobSchedular();
	}
	
	@Test
	public void acculynkFundingJobTest() {
		acculynkBillingScheduler.acculynkFundingJob();
	}

}
