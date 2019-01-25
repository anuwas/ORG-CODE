package com.anu.BSN.scheduler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.me.lc.bil.service.AcService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcbilSchedulerTest {
	
	@Mock
	private AcService AcService;
	
	@InjectMocks
	 private AcbilScheduler AcbilScheduler;
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void dailybilJobSchedularTest() {
		AcbilScheduler.dailybilJobSchedular();
	}
	
	@Test
	public void AcFundingJobTest() {
		AcbilScheduler.AcFundingJob();
	}

}
