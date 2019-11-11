package com.mes.lcr.billing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.mes.lcr.billing.scheduler.AcculynkBillingScheduler;
import com.mes.lcr.billing.service.AcculynkService;

/**
 *
 */
@RestController
public class AcculynkBillingControllerImpl implements AcculynkBillingController {

	private static final Logger logger = LoggerFactory.getLogger(AcculynkBillingControllerImpl.class);

	@Autowired
	private AcculynkBillingScheduler acculynkBillingScheduler;

	@Autowired
	private AcculynkService acculynkService;

	@Override
	public String dailyBilling(String loadfileDate) {
		logger.info("Executing Daily Billing Job manually with the date {}", loadfileDate);
		return this.acculynkService.dailyBillingJob(loadfileDate);
	}

	@SuppressWarnings("nls")
	@Override
	public String testApi() {
		logger.info("TestAPI is calling.......");
		return "Successfully Running";
	}

	@SuppressWarnings("nls")
	@Override
	public String acculynkMerchantFunding() {
		logger.info("Executing acculynkMerchantFunding Job Manually");
		this.acculynkBillingScheduler.acculynkFundingJob();
		return "completed";
	}

	@Override
	public String clearDailyBillingDataByDate(String loadfileDate) {
		logger.info("Executing clearDailyBillingDataByDate for loadfileDate {} ", loadfileDate);
		return this.acculynkService.clearDailyBillingDataByDateAPI(loadfileDate);
	}

}
