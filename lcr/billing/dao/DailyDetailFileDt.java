package com.mes.lcr.billing.dao;

import java.sql.Date;

public class DailyDetailFileDt {

  private Date activityDate = null;
  private double creditsAmount = 0.0;
  private int creditsCount = 0;
  private String dataSource = null;
  private long dataSourceId = 0L;
  private double perItem = 0.0;
  private double rate = 0.0;
  private double feesDue = 0.0;
  private double feesPaid = 0.0;
  private double expense = 0.0;
  private double expenseActual = 0.0;
  private String icCat = null;
  private double itemAmount = 0.0;
  private int itemCount = 0;
  private String itemSubclass = null;
  private int itemType = -1;
  private String loadFilename = null;
  private long loadFileId = 0L;
  private long merchantNumber = 0L;
  private long recId = 0L;
  private double salesAmount = 0.0;
  private int salesCount = 0;
  private int volumeType = -1;
  private Date transactionDate = null;

  public Date getActivityDate() {
    return this.activityDate;
  }
  public void setActivityDate(Date activityDate) {
    this.activityDate = activityDate;
  }
  public double getCreditsAmount() {
    return this.creditsAmount;
  }
  public void setCreditsAmount(double creditsAmount) {
    this.creditsAmount = creditsAmount;
  }
  public int getCreditsCount() {
    return this.creditsCount;
  }
  public void setCreditsCount(int creditsCount) {
    this.creditsCount = creditsCount;
  }
  public String getDataSource() {
    return this.dataSource;
  }
  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
  }
  public long getDataSourceId() {
    return this.dataSourceId;
  }
  public void setDataSourceId(long dataSourceId) {
    this.dataSourceId = dataSourceId;
  }
  public double getPerItem() {
    return this.perItem;
  }
  public void setPerItem(double perItem) {
    this.perItem = perItem;
  }
  public double getRate() {
    return this.rate;
  }
  public void setRate(double rate) {
    this.rate = rate;
  }
  public double getFeesDue() {
    return this.feesDue;
  }
  public void setFeesDue(double feesDue) {
    this.feesDue = feesDue;
  }
  public double getFeesPaid() {
    return this.feesPaid;
  }
  public void setFeesPaid(double feesPaid) {
    this.feesPaid = feesPaid;
  }
  public double getExpense() {
    return this.expense;
  }
  public void setExpense(double expense) {
    this.expense = expense;
  }
  public double getExpenseActual() {
    return this.expenseActual;
  }
  public void setExpenseActual(double expenseActual) {
    this.expenseActual = expenseActual;
  }
  public String getIcCat() {
    return this.icCat;
  }
  public void setIcCat(String icCat) {
    this.icCat = icCat;
  }
  public double getItemAmount() {
    return this.itemAmount;
  }
  public void setItemAmount(double itemAmount) {
    this.itemAmount = itemAmount;
  }
  public int getItemCount() {
    return this.itemCount;
  }
  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }
  public String getItemSubclass() {
    return this.itemSubclass;
  }
  public void setItemSubclass(String itemSubclass) {
    this.itemSubclass = itemSubclass;
  }
  public int getItemType() {
    return this.itemType;
  }
  public void setItemType(int itemType) {
    this.itemType = itemType;
  }
  public long getMerchantNumber() {
    return this.merchantNumber;
  }
  public void setMerchantNumber(long merchantId) {
    this.merchantNumber = merchantId;
  }
  public long getRecId() {
    return this.recId;
  }
  public void setRecId(long recId) {
    this.recId = recId;
  }
  public double getSalesAmount() {
    return this.salesAmount;
  }
  public void setSalesAmount(double salesAmount) {
    this.salesAmount = salesAmount;
  }
  public int getSalesCount() {
    return this.salesCount;
  }
  public void setSalesCount(int salesCount) {
    this.salesCount = salesCount;
  }
  public int getVolumeType() {
    return this.volumeType;
  }
  public void setVolumeType(int volumeType) {
    this.volumeType = volumeType;
  }
  public Date getTransactionDate() {
    return this.transactionDate;
  }
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public String getLoadFilename() {
		return loadFilename;
	}
	public void setLoadFilename(String loadFilename) {
		this.loadFilename = loadFilename;
	}
	public long getLoadFileId() {
		return loadFileId;
	}
	public void setLoadFileId(long loadFileId) {
		this.loadFileId = loadFileId;
	}


}
