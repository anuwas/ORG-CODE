package com.mes.ps.billing.transaction.adapter;

import java.util.List;

import com.mes.ps.billing.dto.DailyJobStatusDto;
import com.mes.ps.billing.dto.CreditDebitDetailsTo;
import com.mes.ps.billing.dto.CreditDebitResponse;
import com.mes.ps.billing.dto.CreditDebitTo;
import com.mes.ps.billing.dto.EventReport;
import com.mes.ps.billing.dto.MonthlyBillingSummaryTo;
import com.mes.ps.billing.entity.CreditDebitTransaction;

/**
 * This is main API interface for batch
 * invocation of Profitstars web service APIs
 * based on MES business logic
 */
public interface ProfitStarsAdapter {
	
	/**
	 * API method interface for concurrent batch invocation 
	 * of Profitstars getCreditAndDebitReports API
	 * based on MES business logic
	 * @param creditDebitRequests
	 * @param jobDto
	 * @return
	 */
	public List<CreditDebitResponse> getCreditAndDebitReports(List<CreditDebitTo> creditDebitRequests, DailyJobStatusDto jobDto);
	
	/**
	 * API method interface for concurrent batch invocation 
	 * of Profitstars getCreditsandDebitsTransactionDetailReport API
	 * based on MES business logic
	 * @param creditDebitDetailsRequests
	 * @param jobDto
	 * @return
	 */
	public List<CreditDebitTransaction> getCreditAndDebitTxnDtlsReports(List<CreditDebitDetailsTo> creditDebitDetailsRequests, DailyJobStatusDto jobDto);
	
	/**
	 * API method interface for concurrent batch invocation 
	 * of Profitstars GetHistoricalEvents API
	 * based on MES business logic
	 * @param billingSummaryTo
	 * @return
	 */
	public List<EventReport> getMonthlyBillingSummary(MonthlyBillingSummaryTo billingSummaryTo);
}


