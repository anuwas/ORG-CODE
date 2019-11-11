package com.mes.ps.billing.dto;

/**
 * CreditDebitTo Bean
 */
public class CreditDebitTo {
  private Long storeId;
  private String storeKey;
  private Integer entityId;
  private Integer locationId;
  private String beginDate;
  private String endDate;

  public CreditDebitTo() {
  }

  public CreditDebitTo(Long storeId, String storeKey, Integer entityId, Integer locationId, String beginDate,
      String endDate) {
    this.storeId = storeId;
    this.storeKey = storeKey;
    this.entityId = entityId;
    this.locationId = locationId;
    this.beginDate = beginDate;
    this.endDate = endDate;
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

  public Integer getLocationId() {
    return locationId;
  }

  public void setLocationId(Integer locationId) {
    this.locationId = locationId;
  }

  public String getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(String beginDate) {
    this.beginDate = beginDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "CreditDebitTo [storeId=" + "xxxx" + ", storeKey=" + "xxxx" + ", entityId=" + "xxxx"
        + ", locationId=" + "xxxx" + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
  }
}