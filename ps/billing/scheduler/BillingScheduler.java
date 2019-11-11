package com.mes.ps.billing.scheduler;

import com.mes.ps.billing.dto.MonthlyBillingProcess;
import com.mes.ps.billing.email.MailManager;
import com.mes.ps.billing.email.MessageBody;
import com.mes.ps.billing.entity.MbsDailySummary;
import com.mes.ps.billing.exception.BillingException;
import com.mes.ps.billing.service.ProfitStarsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Scheduler layer for billing application jobs
 */
@Component
public class BillingScheduler {
	private static final Logger logger = LoggerFactory.getLogger(BillingScheduler.class);
	@Autowired
	private ProfitStarsService profitStarsService;
	@Autowired
	private MailManager mailManager;

	/**
	 * Trigger method for daily transaction job scheduled
	 */
	@Scheduled(cron = "${job.creditdebit.frequency}")
	public void executeUpdateDailyTransactionDetailJob() {
		this.executeUpdateDailyTransactionDetailJob(new Date());
	}
	
	/**
	 * Trigger method for monthly billing summary job scheduled
	 */
	@Scheduled(cron = "${job.monthly.frequency}")
	public void executeUpdateMonthlyBillingSummaryJob() {
		this.executeUpdateMonthlyBillingSummaryJob(new Date());
	}

	/**
	 * Method to process daily transaction job
	 * @param jobExecutionDate
	 * @return
	 */
	public String executeUpdateDailyTransactionDetailJob(Date jobExecutionDate) {
		logger.info("Executing Daily transaction deatil job");
		String jobStatus = null;
		try {
			//validate daily job executed for that day
			profitStarsService.isDailyJobLoaded(jobExecutionDate);
			jobStatus = profitStarsService.updateDailyTransactionDetailJob(jobExecutionDate);
			logger.info("Daily transaction detail job completed");
		} catch (BillingException e) {
			jobStatus = "Daily transaction data already loaded for that day";
			logger.warn(jobStatus);
		}catch (Exception e) {
			jobStatus = "Error encountered during Daily transaction detail data pull: " + e.getMessage();
			logger.error(jobStatus, e);
		}
		
		return jobStatus;
	}


	/**
	 * Method to process monthly billing summary job
	 * @param date
	 * @return
	 */
	public String executeUpdateMonthlyBillingSummaryJob(Date date) {
		logger.info("Executing monthly billing job");

		try {
			//acquire database lock
			List<MonthlyBillingProcess> processes = profitStarsService.acquireDatabaseLock(date);
			List<MbsDailySummary> summaries = profitStarsService.processMonthlyBillingSummary(date);

			if(summaries != null && !summaries.isEmpty()) {
				profitStarsService.updateMonthlyBillingSummary(summaries, processes.get(0));
				logger.info("Total record processed by the Monthly Billing Job :" + summaries.size());
			} else {
				logger.info("No data found to be processed by the Monthly Billing Job");
			}
			//release database lock
			processes.forEach((element)-> element.setProcessSequence(0));
			profitStarsService.releaseDatabaseLock(processes);
			logger.info("Monthly Billing Job Completed");
			mailManager.buildAndSendMessage(new MessageBody("success"), MailManager.MessageType.SUCCESS);
		} catch (BillingException e) {
			logger.warn("Monthly Billing job data already loaded for this month");
		} catch (Exception e) {
			logger.error("Error encountered during monthly billing data pull", e);
			mailManager.buildAndSendMessage(new MessageBody(e.getMessage()), MailManager.MessageType.FAILED);
		}

		return "success";
	}

}
