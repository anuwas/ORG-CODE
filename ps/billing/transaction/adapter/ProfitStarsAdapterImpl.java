package com.mes.ps.billing.transaction.adapter;

import static com.mes.ps.billing.common.Constants.PS_SOAPCLIENT_PARALLEL_THREAD_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mes.ps.billing.client.provider.BillingSoapClient;
import com.mes.ps.billing.dto.CreditDebitDetailsTo;
import com.mes.ps.billing.dto.CreditDebitResponse;
import com.mes.ps.billing.dto.CreditDebitTo;
import com.mes.ps.billing.dto.DailyJobStatusDto;
import com.mes.ps.billing.dto.DailyJobStatusDto.JobStatus;
import com.mes.ps.billing.dto.EventReport;
import com.mes.ps.billing.dto.MonthlyBillingSummaryTo;
import com.mes.ps.billing.dto.profitstars.report.ArrayOfInt;
import com.mes.ps.billing.dto.profitstars.report.ArrayOfWSDisplayFields;
import com.mes.ps.billing.dto.profitstars.report.ArrayOfWSEventReport;
import com.mes.ps.billing.dto.profitstars.report.ArrayOfWSSettlementType;
import com.mes.ps.billing.dto.profitstars.report.ArrayOfWSTransactionEvent;
import com.mes.ps.billing.dto.profitstars.report.GetHistoricalEvents;
import com.mes.ps.billing.dto.profitstars.report.WSDisplayFields;
import com.mes.ps.billing.dto.profitstars.report.WSEventReport;
import com.mes.ps.billing.dto.profitstars.report.WSOperationType;
import com.mes.ps.billing.dto.profitstars.report.WSSettlementType;
import com.mes.ps.billing.dto.profitstars.report.WSTransactionEvent;
import com.mes.ps.billing.entity.CreditDebitTransaction;
import com.mes.ps.billing.util.DateTimeUtils;

/**
 * This class is main API implementation class for batch
 * invocation of Profitstars web service APIs
 * based on MES business logic
 */
@Component
public class ProfitStarsAdapterImpl implements ProfitStarsAdapter {
  private static final Logger LOG = LoggerFactory.getLogger(ProfitStarsAdapterImpl.class);
  @Autowired
  private BillingSoapClient billingClient;
  @Value("${" + PS_SOAPCLIENT_PARALLEL_THREAD_COUNT + "}")
  private int threadCount;

  @Override
  public List<CreditDebitResponse> getCreditAndDebitReports(List<CreditDebitTo> creditDebitRequests, DailyJobStatusDto jobDto) {
    List<CreditDebitResponse> creditDebitResponses = new ArrayList<>();
    List<Future<List<CreditDebitResponse>>> futures = new ArrayList<>();
    ExecutorService service = Executors.newFixedThreadPool(threadCount);

    try {
      for(CreditDebitTo creditDebitRequest : creditDebitRequests) {
        if(creditDebitRequest != null) {
          TxnAccumulatorGetCreditDebit accumulatorGetCreditDebit = new TxnAccumulatorGetCreditDebit(creditDebitRequest, billingClient);

          try {
            Future<List<CreditDebitResponse>> result = service.submit(accumulatorGetCreditDebit);
            futures.add(result);
          } catch (Exception e) {
            jobDto.setJobStatus(DailyJobStatusDto.JobStatus.COMP_ERROR);
            LOG.error(e.getMessage(), e);
          }
        }
      }

      for(Future<List<CreditDebitResponse>> future : futures) {
        try {
          List<CreditDebitResponse> creditDebitWSResponses = future.get();
          if(creditDebitWSResponses != null) {
            for (CreditDebitResponse creditDebitResponse : creditDebitWSResponses) {
              creditDebitResponses.add(creditDebitResponse);
              LOG.info(creditDebitResponse.toString());
            }
          }
        } catch (Exception e) {
          jobDto.setJobStatus(DailyJobStatusDto.JobStatus.COMP_ERROR);
          LOG.error(e.getMessage(), e);
        }
      }
    } finally {
      service.shutdown();
    }
    
    return creditDebitResponses;
  }
  
  @Override
  public List<CreditDebitTransaction> getCreditAndDebitTxnDtlsReports(List<CreditDebitDetailsTo> creditDebitDetailsRequests, DailyJobStatusDto jobDto) { 
    List<CreditDebitTransaction> creditDebitTransactions = new ArrayList<>();
    List<Future<List<CreditDebitTransaction>>> futures = new ArrayList<>();
    ExecutorService service = Executors.newFixedThreadPool(threadCount);
    JobStatus jobStatus = JobStatus.COMPLETED;
      
    try {
      for(CreditDebitDetailsTo creditDebitDetailsRequest : creditDebitDetailsRequests) {
        TxnAccumulatorCreditDebitDetails accumulatorCreditDebitDetails = new TxnAccumulatorCreditDebitDetails(creditDebitDetailsRequest, billingClient);
          
        try {
          Future<List<CreditDebitTransaction>> result = service.submit(accumulatorCreditDebitDetails);
          futures.add(result);
        } catch (Exception e) {
          jobStatus = JobStatus.COMP_ERROR;
          LOG.error(e.getMessage(), e);
        }
      }
        
      for(Future<List<CreditDebitTransaction>> future : futures) {
        try {
          List<CreditDebitTransaction> creditDebitWSTransactions = future.get();
          for (CreditDebitTransaction creditDebitWSTransaction : creditDebitWSTransactions) {
            creditDebitTransactions.add(creditDebitWSTransaction);
            LOG.info(creditDebitWSTransaction.toString());
          }
        } catch (Exception e) {
          jobStatus = JobStatus.COMP_ERROR;
          LOG.error("Error returned by ProfitStars : " + e.getMessage());
        }
      }
      
      jobDto.setJobStatus(jobStatus);
    } finally {
      service.shutdown();
    }

    return creditDebitTransactions;
  }
  
  @Override
  public List<EventReport> getMonthlyBillingSummary(MonthlyBillingSummaryTo billingSummaryTo) {
    GetHistoricalEvents historicalEvents = new GetHistoricalEvents();
    historicalEvents.setEntityId(billingSummaryTo.getEntityId());
    historicalEvents.setStoreId(billingSummaryTo.getStoreId());
    historicalEvents.setStoreKey(billingSummaryTo.getStoreKey());
    XMLGregorianCalendar cal[] = DateTimeUtils.parseDate(billingSummaryTo.getBeginDate(), billingSummaryTo.getEndDate());
    historicalEvents.setBeginTransDate(cal[0]);
    historicalEvents.setEndTransDate(cal[1]);
    ArrayOfInt locationIds = new ArrayOfInt();
    locationIds.getInt().add(billingSummaryTo.getLocationId());
    historicalEvents.setLocationIds(locationIds);

    ArrayOfWSDisplayFields displayFields = new ArrayOfWSDisplayFields();
    displayFields.getWSDisplayFields().add(WSDisplayFields.NONE);
    historicalEvents.setWsdisplayFields(displayFields);

    historicalEvents.setWsopType(WSOperationType.NONE);

    ArrayOfWSTransactionEvent wsTransactionEvent = new ArrayOfWSTransactionEvent();
    wsTransactionEvent.getWSTransactionEvent().add(WSTransactionEvent.ORIGINATED);//Originated
    wsTransactionEvent.getWSTransactionEvent().add(WSTransactionEvent.RETURNED_NSF);//Returned NSF
    wsTransactionEvent.getWSTransactionEvent().add(WSTransactionEvent.RETURNED_BAD_ACCOUNT);//Returned Bad Account
    wsTransactionEvent.getWSTransactionEvent().add(WSTransactionEvent.PROCESSING_ERROR);//processing error
    wsTransactionEvent.getWSTransactionEvent().add(WSTransactionEvent.COLLECTED);//collected
    wsTransactionEvent.getWSTransactionEvent().add(WSTransactionEvent.DISPUTED);//Charged Back
    wsTransactionEvent.getWSTransactionEvent().add(WSTransactionEvent.UNAUTHORIZED);//Unauthorized
    historicalEvents.setWstransEvents(wsTransactionEvent);

    ArrayOfWSSettlementType wsSettlementType = new ArrayOfWSSettlementType();
    wsSettlementType.getWSSettlementType().add(WSSettlementType.ACH);
    historicalEvents.setWssettlementType(wsSettlementType);

    ArrayOfWSEventReport response = billingClient.getMonthlyBillingSummary(historicalEvents).getGetHistoricalEventsResult();

    List<EventReport> eventReports = new ArrayList<>();
    for (WSEventReport report : response.getWSEventReport()) {
      EventReport eventReport = new EventReport(
          report.getTransactionNumber(), report.getLocationName(),
          report.getOperationType(), report.getEventType(),
          DateTimeUtils.getDateString(report.getEventDateTime()), report.getTotalAmount()
      );
      eventReports.add(eventReport);
    }

    return eventReports;
  }
}
