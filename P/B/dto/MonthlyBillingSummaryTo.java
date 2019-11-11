package com.mes.ps.billing.dto;

/**
 * MonthlyBillingSummaryTo Bean
 */
public class MonthlyBillingSummaryTo {

  protected long storeId;
  protected String storeKey;
  protected int entityId;
  protected int locationId;
  protected String beginDate;
  protected String endDate;

  public MonthlyBillingSummaryTo(){

  }

  public MonthlyBillingSummaryTo(long storeId, String storeKey, int entityId, int locationId, String beginDate, String endDate){
    this.storeId = storeId;
    this.storeKey = storeKey;
    this.entityId = entityId;
    this.beginDate = beginDate;
    this.endDate = endDate;

  }
  public long getStoreId() {
    return storeId;
  }
  public void setStoreId(long storeId) {
    this.storeId = storeId;
  }
  public String getStoreKey() {
    return storeKey;
  }
  public void setStoreKey(String storeKey) {
    this.storeKey = storeKey;
  }
  public int getEntityId() {
    return entityId;
  }
  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }

  public int getLocationId() {
    return locationId;
  }

  public void setLocationId(int locationId) {
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
    return "SettlementSummaryTo [storeId=" + "xxxx" + ", storeKey=" + "xxxx" + ", entityId=" + "xxxx"
        + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
  }
}