package com.mes.lcr.billing.service;

public interface AcculynkService {
	String dailyBillingJob(String loadfileDate);

	void acculynkFundingJob();

	String clearDailyBillingDataByDateAPI(String loadfileDate);
}
