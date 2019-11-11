package com.mes.ps.billing.controller;

import com.mes.ps.billing.scheduler.BillingScheduler;
import com.mes.ps.billing.util.DateTimeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation class for APIs for manual invocation of billing services
 */
@RestController
public class ProfitStarsBillingControllerImpl implements ProfitStarsBillingController {
	private static final Logger logger = LoggerFactory.getLogger(ProfitStarsBillingControllerImpl.class);
	@Autowired
	private BillingScheduler billingScheduler;

	@Override
	public String executeMonthlyBillingJob(String monthYear) {
		logger.info("Executing Monthly Billing Job Manually");
		Date date;
		try {
			date = new SimpleDateFormat(DateTimeUtils.FORMAT_ddMMyy).parse("01" + monthYear);
		} catch (Exception e) {
			date = new Date();
		}
		return billingScheduler.executeUpdateMonthlyBillingSummaryJob(date);
	}

	@Override
	public String executeDailyTransactionDetailJob(String dayMonthYear) {
		logger.info("Executing Daily Transaction Details Job Manually");
		Date date;
		try {
			date = new SimpleDateFormat(DateTimeUtils.FORMAT_ddMMyy).parse(dayMonthYear);
		} catch (Exception e) {
			date = new Date();
		}
		return billingScheduler.executeUpdateDailyTransactionDetailJob(date);
	}
}
