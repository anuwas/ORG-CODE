package com.mes.ps.billing.entity;

import java.math.BigDecimal;

/**
 * MbsDailySummary Entity Bean
 */
public class MbsDailySummary {
  private long merchantNumber;
  private String activityDate;
  private int itemType;
  private String itemSubclass;
  private int itemCount;
  private BigDecimal itemAmount;
  private int salesCount;
  private BigDecimal salesAmount;
  private int creditCount;
  private BigDecimal creditAmount;
  private BigDecimal perItem;
  private BigDecimal rate;
  private String dataSource;
  private String dataSourceId;
  private BigDecimal feeDue;

  public BigDecimal getFeeDue() {
    return feeDue;
  }

  public void setFeeDue(BigDecimal feeDue) {
    this.feeDue = feeDue;
  }

  public String getDataSource() {
    return dataSource;
  }

  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
  }

  public String getDataSourceId() {
    return dataSourceId;
  }

  public void setDataSourceId(String dataSourceId) {
    this.dataSourceId = dataSourceId;
  }

  public long getMerchantNumber() {
    return merchantNumber;
  }

  public void setMerchantNumber(long merchantNumber) {
    this.merchantNumber = merchantNumber;
  }

  public String getActivityDate() {
    return activityDate;
  }

  public void setActivityDate(String activityDate) {
    this.activityDate = activityDate;
  }

  public int getItemType() {
    return itemType;
  }

  public void setItemType(int itemType) {
    this.itemType = itemType;
  }

  public String getItemSubclass() {
    return itemSubclass;
  }

  public void setItemSubclass(String itemSubclass) {
    this.itemSubclass = itemSubclass;
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

  public BigDecimal getPerItem() {
    return perItem;
  }

  public void setPerItem(BigDecimal perItem) {
    this.perItem = perItem;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

}
