package com.mes.ps.billing.dto;

/**
 * MerchantProfile Bean
 */
public class MerchantProfile {
  private int entityId;
  private int locationId;
  private long merchantNumber;

  public long getMerchantNumber() {
    return merchantNumber;
  }

  public void setMerchantNumber(long merchantNumber) {
    this.merchantNumber = merchantNumber;
  }

  public int getLocationId() {
    return locationId;
  }

  public void setLocationId(int locationId) {
    this.locationId = locationId;
  }

  public int getEntityId() {
    return entityId;
  }

  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }
}