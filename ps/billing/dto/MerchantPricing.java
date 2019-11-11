package com.mes.ps.billing.dto;

import java.math.BigDecimal;

/**
 * MerchantPricing Bean
 */
public class MerchantPricing {
  private long merchNum;
  private int entityId;
  private int locationId;
  private BigDecimal perItem;
  private BigDecimal rate;
  private String itemDesc;
  private long itemType;

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public long getItemType() {
    return itemType;
  }

  public void setItemType(long itemType) {
    this.itemType = itemType;
  }

  public long getMerchNum() {
    return merchNum;
  }

  public void setMerchNum(long merchNum) {
    this.merchNum = merchNum;
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

  public BigDecimal getPerItem() {
    return perItem;
  }

  public void setPerItem(BigDecimal perItem) {
    this.perItem = perItem;
  }

  public String getItemDesc() {
    return itemDesc;
  }

  public void setItemDesc(String itemDesc) {
    this.itemDesc = itemDesc;
  }
}
