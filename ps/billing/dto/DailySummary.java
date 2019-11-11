package com.mes.ps.billing.dto;

import java.math.BigDecimal;

/**
 * DailySummary Bean
 */
public class DailySummary {
  private long entityId;
  private long locationId;
  private String activityDate;
  private String itemDesc;
  private int itemCount;
  private BigDecimal itemAmount;
  private int salesCount;
  private BigDecimal salesAmount = new BigDecimal(0);
  private int creditCount;
  private BigDecimal creditAmount = new BigDecimal(0);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DailySummary that = (DailySummary) o;

    if (entityId != that.entityId) return false;
    if (locationId != that.locationId) return false;
    if (!activityDate.equals(that.activityDate)) return false;
    return itemDesc.equals(that.itemDesc);
  }

  @Override
  public int hashCode() {
    int result = (int) (entityId ^ (entityId >>> 32));
    result = 31 * result + (int) (locationId ^ (locationId >>> 32));
    result = 31 * result + activityDate.hashCode();
    result = 31 * result + itemDesc.hashCode();
    return result;
  }

  public int getSalesCount() {
    return salesCount;
  }

  public void setSalesCount(int salesCount) {
    this.salesCount = salesCount;
  }

  public BigDecimal getSalesAmount() {
    return salesAmount;
  }

  public void setSalesAmount(BigDecimal salesAmount) {
    this.salesAmount = salesAmount;
  }

  public int getCreditCount() {
    return creditCount;
  }

  public void setCreditCount(int creditCount) {
    this.creditCount = creditCount;
  }

  public BigDecimal getCreditAmount() {
    return creditAmount;
  }

  public void setCreditAmount(BigDecimal creditAmount) {
    this.creditAmount = creditAmount;
  }

  public long getLocationId() {
    return locationId;
  }

  public void setLocationId(long locationId) {
    this.locationId = locationId;
  }

  public long getEntityId() {
    return entityId;
  }

  public void setEntityId(long entityId) {
    this.entityId = entityId;
  }

  public String getActivityDate() {
    return activityDate;
  }

  public void setActivityDate(String activityDate) {
    this.activityDate = activityDate;
  }

  public String getItemDesc() {
    return itemDesc;
  }

  public void setItemDesc(String itemDesc) {
    this.itemDesc = itemDesc;
  }

  public int getItemCount() {
    return itemCount;
  }

  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }

  public BigDecimal getItemAmount() {
    return itemAmount;
  }

  public void setItemAmount(BigDecimal itemAmount) {
    this.itemAmount = itemAmount;
  }

  @Override
  public String toString() {
    return "DailySummary{" +
        "entityId=" + "xxxx" +
        ", activityDate='" + activityDate + '\'' +
        ", itemDesc='" + itemDesc + '\'' +
        ", itemCount=" + itemCount +
        ", itemAmount=" + itemAmount +
        '}';
  }
}
