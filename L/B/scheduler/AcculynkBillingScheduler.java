package com.mes.lcr.billing.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.mes.lcr.billing.service.AcculynkService;
import com.mes.lcr.util.DateTimeUtil;

@Component
public class AcculynkBillingScheduler {
	private static final Logger logger = LoggerFactory.getLogger(AcculynkBillingScheduler.class);
	public static final String DATEFORMAT = "dd/MM/yyyy";

	@Autowired
	private AcculynkService acculynkService;

	@SuppressWarnings("nls")
	@Scheduled(cron = "${lcrjob.daily.frequency}")
	public void dailyBillingJobSchedular() {
		try {
			String currentDate = DateTimeUtil.getCurrentDateTime(DATEFORMAT);
			logger.info("Daily billing job triggering from dailyBillingJobSchedular scheduler on ({}) {}", DATEFORMAT, currentDate);
			this.acculynkService.dailyBillingJob(currentDate);
			logger.info("Daily Billing Job Completed, dailyBillingJobSchedular ");
		}
		catch (Exception e) {
			logger.error("Error encountered during Daily billing data pull", e);
		}
	}

	@SuppressWarnings("nls")
	@Scheduled(cron = "${lcrjob.fundingdaily.frequency}")
	public void acculynkFundingJob() {
		logger.info("Executing Acculynk Funding job");
		try {
			this.acculynkService.acculynkFundingJob();
			logger.info("Acculynk funding  Job Completed");
		}
		catch (Exception e) {
			logger.error("Error encountered during LCR Merchant funding data pull", e);
		}
	}

}
