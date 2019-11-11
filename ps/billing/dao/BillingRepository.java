package com.mes.ps.billing.dao;

import com.mes.ps.billing.dto.DailyJobStatusDto;
import com.mes.ps.billing.dto.MerchantPricing;
import com.mes.ps.billing.dto.MonthlyBillingProcess;
import com.mes.ps.billing.entity.CreditDebitTransaction;
import com.mes.ps.billing.entity.MbsDailySummary;

import java.util.List;
import java.util.Map;

/**
 * Repository layer for billing application
 */
public interface BillingRepository {
    /**
     * This method insert all information into ACHPS_TRANSACTION_DETAIL table from profit stars
     *
     * @param transactions
     * @param jobDto
     */
	DailyJobStatusDto insertUpdateCreditDebitTransaction(List<CreditDebitTransaction> transactions, DailyJobStatusDto jobDto);

    /**
     * This method insert a row into ACHPS_BILLING_JOB_DETAIL table for all the running job's status
     *
     * @param jobDto
     */
	DailyJobStatusDto insertUpdateJobDescription(DailyJobStatusDto jobDto);

    /**
     * This method returns profiles for all the merchant from achp_profiles table
     *
     * @return
     */
    List<Integer> getMerchants();

    /**
     * This method retrieve merchant profile and pricing data from achp_profiles and mbs_pricing and mbs_elements tables
     *
     * @return
     */
    Map<String, MerchantPricing> getMerchantProfile();
    
    
    /**
     * This method retrieve ach Elements from mbs_elements table
     * 
     * @return
     */
    Map<Integer, String> getAchElements();

    /**
     * This method inserted data into MBS_DAILY_SUMMARY table
     *
     * @param summaries
     * @param firstDayOfMonth
     */
    void insertIntoMbsDailySummary(List<MbsDailySummary> summaries, String firstDayOfMonth);

    /**
     * This method insert one into MONTHLY_BILLING_PROCESS table
     *
     * @param billingProcess
     */
    void updateJobTable(MonthlyBillingProcess billingProcess);

    /**
     * This method checks MONTHLY_BILLING_PROCESS if there is any for the current month. If no entry
     * is found the current month then it returns false else return true
     * @return
     */
    boolean monthlySummaryLoaded(String monthYear);

    /**
     * This method insert monthly billing job status into monthly_billing_summary table
     * @param billingProcess
     * @return
     */
    long insertIntoJobTable(MonthlyBillingProcess billingProcess);
    
    /**
     * This method checks ACHPS_BILLING_JOB_DETAIL if there is any for the current date. If no entry
     * is found the current date then it returns false else return true
     * @return
     */
	boolean dailyJobLoaded(String dateMonthYear);
}