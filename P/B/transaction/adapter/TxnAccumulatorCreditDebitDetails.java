package com.mes.ps.billing.transaction.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.mes.ps.billing.client.provider.BillingSoapClient;
import com.mes.ps.billing.dto.CreditDebitDetailsTo;
import com.mes.ps.billing.dto.profitstars.report.ArrayOfWSSettlementBatch;
import com.mes.ps.billing.dto.profitstars.report.CreditsandDebitsTransactionDetailReport;
import com.mes.ps.billing.dto.profitstars.report.CreditsandDebitsTransactionDetailReportResponse;
import com.mes.ps.billing.dto.profitstars.report.WSOperationType;
import com.mes.ps.billing.dto.profitstars.report.WSSettlementBatch;
import com.mes.ps.billing.dto.profitstars.report.WSSettlementStatus;
import com.mes.ps.billing.entity.CreditDebitTransaction;

/**
 * This class is concurrent class for invocation of
 * Profitstars getCreditsandDebitsTransactionDetailReport API
 * with MES business logic for required transactions
 */
public class TxnAccumulatorCreditDebitDetails implements Callable<List<CreditDebitTransaction>> {
  private CreditDebitDetailsTo creditDebitDetailsRequest;
  private BillingSoapClient billingClient;

  public TxnAccumulatorCreditDebitDetails(CreditDebitDetailsTo creditDebitDetailsRequest, BillingSoapClient billingClient) {
    this.creditDebitDetailsRequest = creditDebitDetailsRequest;
    this.billingClient = billingClient;
  }

  @Override
  public List<CreditDebitTransaction> call() throws Exception {
    return process();
  }
  
  /**
   * Method for invocation of Profitstars getCreditsandDebitsTransactionDetailReport API
   * with MES business logic for required transactions
   * @return
   */
  public List<CreditDebitTransaction> process() {
    CreditsandDebitsTransactionDetailReport detailReport = new CreditsandDebitsTransactionDetailReport();
    detailReport.setBatchId(creditDebitDetailsRequest.getBatchId());
    detailReport.setEntityId(creditDebitDetailsRequest.getEntityId());
    detailReport.setStoreId(creditDebitDetailsRequest.getStoreId());
    detailReport.setStoreKey(creditDebitDetailsRequest.getStoreKey());
    
    CreditsandDebitsTransactionDetailReportResponse detailReportResponse = billingClient.getReport(detailReport);
    ArrayOfWSSettlementBatch deposit = detailReportResponse.getCreditsandDebitsTransactionDetailReportResult();
        List<WSSettlementBatch> wsSettlementBatchs = deposit.getWSSettlementBatch();
        List<CreditDebitTransaction> transactions = new ArrayList<>();
        
        for(WSSettlementBatch wsSettlementBatch : wsSettlementBatchs) {
          String settlementStatus = wsSettlementBatch.getTransactionDetails().getSettlementStatus().value();
            String operationType = wsSettlementBatch.getTransactionDetails().getOperationType().value();
            // Business logic for filtering transactions
            boolean transactionForConsideration = false;
            if(settlementStatus.equalsIgnoreCase(WSSettlementStatus.CHARGED_BACK.value())) {
              transactionForConsideration = true;
            } else if(settlementStatus.equalsIgnoreCase(WSSettlementStatus.SETTLED.value())) {
              if (operationType.equalsIgnoreCase(WSOperationType.SALE.value())
            || operationType.equalsIgnoreCase(WSOperationType.CREDIT.value()) || operationType.equalsIgnoreCase(WSOperationType.REFUND.value())) {
                transactionForConsideration = true;
                }
            } else if(settlementStatus.equalsIgnoreCase(WSSettlementStatus.ORIGINATED_SETTLEMENT_PENDING.value())) {
              if (operationType.equalsIgnoreCase(WSOperationType.CREDIT.value()) || operationType.equalsIgnoreCase(WSOperationType.REFUND.value())) {
                  transactionForConsideration = true;
                }
            }
            
            if(transactionForConsideration) {
              Integer locationId = wsSettlementBatch.getTransactionDetails().getLocationId();
              CreditDebitTransaction transaction = new CreditDebitTransaction();
              transaction.setEntityId(creditDebitDetailsRequest.getEntityId() != null ? String.valueOf(creditDebitDetailsRequest.getEntityId()) : "");
              transaction.setLocationId(locationId);
              transaction.setAmount(wsSettlementBatch.getAmount());
              transaction.setOperationType(wsSettlementBatch.getTransactionDetails().getOperationType().value());
              transaction.setEffectiveDate(wsSettlementBatch.getTransactionDetails().getEffectiveDate().toGregorianCalendar().getTime());
              transaction.setTransactionDate(wsSettlementBatch.getTransactionDetails().getTransactionDate().toGregorianCalendar().getTime());
              transaction.setTransactionNumber(wsSettlementBatch.getTransactionDetails().getTransactionNumber());
              transaction.setReferenceNumber(wsSettlementBatch.getTransactionDetails().getReferenceNumber());
              transaction.setProfileId(wsSettlementBatch.getTransactionDetails().getField1());
              transactions.add(transaction);
            }
        }
        
        return transactions;
  }
}
