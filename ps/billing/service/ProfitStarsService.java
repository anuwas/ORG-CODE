package com.mes.ps.billing.service;

import java.util.Date;
import java.util.List;

import com.mes.ps.billing.dto.MonthlyBillingProcess;
import com.mes.ps.billing.entity.MbsDailySummary;

/**
 * Service layer for billing application
 */
public interface ProfitStarsService {
    
    /**
     * This method insert data into achps_transaction_details with the data that are pulled from profitstar
     * @param jobExecutionDate
     */
    String updateDailyTransactionDetailJob(Date jobExecutionDate);
    
    /**
     * This method determines whether daily job already executed or not
     * @param jobExecutionDate
     */
    void isDailyJobLoaded(Date jobExecutionDate);

    /**
     * This method insert data into mbs_daily_summary with the data that are pulled from profitstar
     * @param mbsDailySummaries
     * @param process
     */
    void updateMonthlyBillingSummary(List<MbsDailySummary> mbsDailySummaries, MonthlyBillingProcess process);

    /**
     * Process input data for monthly billing summary records.
     * @param billingMonth
     * @return
     */
    List<MbsDailySummary> processMonthlyBillingSummary(Date billingMonth);

    /**
     * Ensures process based locks on files for input date
     * @param date
     * @return
     */
    List<MonthlyBillingProcess> acquireDatabaseLock(Date date);

    /**
     * Release process based locks on files for input date
     * @param processes
     */
    void releaseDatabaseLock(List<MonthlyBillingProcess> processes);
}
