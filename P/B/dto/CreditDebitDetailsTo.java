package com.mes.ps.billing.dto;

/**
 * CreditDebitDetailsTo Bean
 */
public class CreditDebitDetailsTo {
  private Long storeId;
  private String storeKey;
  private Integer entityId;
  private Long batchId;

  public CreditDebitDetailsTo() {
  }

  public CreditDebitDetailsTo(Long storeId, String storeKey, Integer entityId, Long batchId) {
    this.storeId = storeId;
    this.storeKey = storeKey;
    this.entityId = entityId;
    this.batchId = batchId;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public String getStoreKey() {
    return storeKey;
  }

  public void setStoreKey(String storeKey) {
    this.storeKey = storeKey;
  }

  public Integer getEntityId() {
    return entityId;
  }

  public void setEntityId(Integer entityId) {
    this.entityId = entityId;
  }

  public Long getBatchId() {
    return batchId;
  }

  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  @Override
  public String toString() {
    return "CreditDebitDetailsTo [storeId=" + "xxxx" + ", storeKey=" + "xxxx" + ", entityId=" + "xxxx"
        + ", batchId=" + batchId + "]";
  }

}
