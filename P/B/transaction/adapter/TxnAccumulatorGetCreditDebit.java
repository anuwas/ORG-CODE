package com.mes.ps.billing.transaction.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.xml.datatype.XMLGregorianCalendar;

import com.mes.ps.billing.client.provider.BillingSoapClient;
import com.mes.ps.billing.dto.CreditDebitResponse;
import com.mes.ps.billing.dto.CreditDebitTo;
import com.mes.ps.billing.dto.profitstars.report.ArrayOfInt;
import com.mes.ps.billing.dto.profitstars.report.GetCreditandDebitReports;
import com.mes.ps.billing.dto.profitstars.report.GetCreditandDebitReportsResponse;
import com.mes.ps.billing.dto.profitstars.report.WSCreditDebitReport;
import com.mes.ps.billing.util.DateTimeUtils;

/**
 * This class is concurrent class for invocation of
 * Profitstars GetCreditandDebitReports API
 */
public class TxnAccumulatorGetCreditDebit implements Callable<List<CreditDebitResponse>> {
  private CreditDebitTo creditDebitRequest;
  private BillingSoapClient billingClient;

  public TxnAccumulatorGetCreditDebit(CreditDebitTo creditDebitRequest, BillingSoapClient billingClient) {
    this.creditDebitRequest = creditDebitRequest;
    this.billingClient = billingClient;
  }
  
  @Override
  public List<CreditDebitResponse> call() {
    return process();
  }
  
  /**
   * Method for invocation of Profitstars GetCreditandDebitReports API
   * @return
   */
  public List<CreditDebitResponse> process() {
    GetCreditandDebitReports getCreditandDebitReports = new GetCreditandDebitReports();
    getCreditandDebitReports.setEntityId(creditDebitRequest.getEntityId());
    getCreditandDebitReports.setStoreId(creditDebitRequest.getStoreId());
    getCreditandDebitReports.setStoreKey(creditDebitRequest.getStoreKey());
    XMLGregorianCalendar[] dates = DateTimeUtils.parseDate(creditDebitRequest.getBeginDate(), creditDebitRequest.getEndDate());
    getCreditandDebitReports.setBeginDate(dates[0]);
    getCreditandDebitReports.setEndDate(dates[1]);

    ArrayOfInt locations = new ArrayOfInt();
    locations.getInt().add(creditDebitRequest.getLocationId());
    getCreditandDebitReports.setLocationIds(locations);
    GetCreditandDebitReportsResponse getCreditandDebitReportsResponse = billingClient.getCreditandDebitReports(getCreditandDebitReports);
    List<CreditDebitResponse> creditDebitResponses = null;
    List<WSCreditDebitReport> creditDebitReports = getCreditandDebitReportsResponse.getGetCreditandDebitReportsResult().getWSCreditDebitReport();
    if(creditDebitReports != null && !creditDebitReports.isEmpty()) {
      creditDebitResponses =  new ArrayList<>();
      for(WSCreditDebitReport creditDebitReport : creditDebitReports) {
        CreditDebitResponse response = new CreditDebitResponse(creditDebitRequest.getEntityId(), creditDebitReport.getBatchStatus(), 
            creditDebitReport.getEffectiveDate().toGregorianCalendar().getTime(), creditDebitReport.getBatchId(), 
            creditDebitReport.getDescription(), creditDebitReport.getAmount());
        creditDebitResponses.add(response);
      }
    }
    
    return creditDebitResponses;
  }
}