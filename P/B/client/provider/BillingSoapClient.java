package com.mes.ps.billing.client.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.mes.ps.billing.dto.profitstars.report.ArrayOfWSEventReport;
import com.mes.ps.billing.dto.profitstars.report.CreditsandDebitsTransactionDetailReport;
import com.mes.ps.billing.dto.profitstars.report.CreditsandDebitsTransactionDetailReportResponse;
import com.mes.ps.billing.dto.profitstars.report.GetCreditandDebitReports;
import com.mes.ps.billing.dto.profitstars.report.GetCreditandDebitReportsResponse;
import com.mes.ps.billing.dto.profitstars.report.GetHistoricalEvents;
import com.mes.ps.billing.dto.profitstars.report.GetHistoricalEventsResponse;

/**
 * Soap client class for SOAP communication with Profitstars Web Service API
 */
public class BillingSoapClient extends WebServiceGatewaySupport {
  private static final Logger log = LoggerFactory.getLogger(BillingSoapClient.class);
  @Value("${ps.webservice.baseurl}")
  private String psServiceEndpoint;

  /**
   * SOAP communication method for CreditsandDebitsTransactionDetailReport API
   * @param input
   * @return
   */
  public CreditsandDebitsTransactionDetailReportResponse getReport(CreditsandDebitsTransactionDetailReport input) {
    CreditsandDebitsTransactionDetailReport request = new CreditsandDebitsTransactionDetailReport();
    request.setStoreId(input.getStoreId());
    request.setStoreKey(input.getStoreKey());
    request.setEntityId(input.getEntityId());
    request.setBatchId(input.getBatchId());

    log.info("Invoking PS Scheduled [API: {} CreditsandDebitsTransactionDetailReport]", psServiceEndpoint);

    return  (CreditsandDebitsTransactionDetailReportResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request, new SoapActionCallback(psServiceEndpoint + "CreditsandDebitsTransactionDetailReport"));
  }

  /**
   * SOAP communication method for GetCreditandDebitReports API
   * @param input
   * @return
   */
  public GetCreditandDebitReportsResponse getCreditandDebitReports(GetCreditandDebitReports input)  {
    log.info("Invoking PS Scheduled [API: {} GetCreditandDebitReports]", psServiceEndpoint);
    GetCreditandDebitReports request = new GetCreditandDebitReports();
    request.setEntityId(input.getEntityId());
    request.setStoreId(input.getStoreId());
    request.setStoreKey(input.getStoreKey());
    request.setEndDate(input.getEndDate());
    request.setBeginDate(input.getBeginDate());
    request.setLocationIds(input.getLocationIds());

    return (GetCreditandDebitReportsResponse)getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(psServiceEndpoint + "GetCreditandDebitReports"));
  }

  /**
   * SOAP communication method for GetHistoricalEvents API
   * @param input
   * @return
   */
  public GetHistoricalEventsResponse getMonthlyBillingSummary(GetHistoricalEvents input)  {
    int numberOfRecord = 0;
    log.info("Invoking GetHistoricalEvents API, entityId:{}, locationId:{}"
        , "xxxx", "xxxx");

    GetHistoricalEventsResponse response = (GetHistoricalEventsResponse) getWebServiceTemplate().marshalSendAndReceive(input, new
        SoapActionCallback(psServiceEndpoint + "GetHistoricalEvents"));
    ArrayOfWSEventReport report = response.getGetHistoricalEventsResult();
    //check if there is any
    if(report != null) {
      numberOfRecord = report.getWSEventReport().size();
    }
    log.info("Retrieved record count: {}", numberOfRecord);

    return response;
  }
}
