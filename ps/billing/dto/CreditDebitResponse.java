package com.mes.ps.billing.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CreditDebitResponse Bean
 */
public class CreditDebitResponse {
  private Integer entityId;
  private String batchStatus;
  private Date effectiveDate;
  private Long batchId;
  private String description;
  private BigDecimal amount;

  public CreditDebitResponse() {
  }

  public CreditDebitResponse(Integer entityId, String batchStatus, Date effectiveDate, Long batchId, String description,
      BigDecimal amount) {
    this.entityId = entityId;
    this.batchStatus = batchStatus;
    this.effectiveDate = effectiveDate;
    this.batchId = batchId;
    this.description = description;
    this.amount = amount;
  }

  public Integer getEntityId() {
    return entityId;
  }

  public void setEntityId(Integer entityId) {
    this.entityId = entityId;
  }

  public String getBatchStatus() {
    return batchStatus;
  }

  public void setBatchStatus(String batchStatus) {
    this.batchStatus = batchStatus;
  }

  public Date getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public Long getBatchId() {
    return batchId;
  }

  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "CreditDebitResponse [entityId=" + "xxxx" + ", batchStatus=" + batchStatus + ", effectiveDate="
        + effectiveDate + ", batchId=" + batchId + ", description=" + description + ", amount=" + amount + "]";
  }
}
