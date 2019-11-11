package com.mes.lcr.billing.dto;

import java.util.Date;

public class MbsDailySummary {
private long recId;
private long merchantNumber;
private Date activityDate;
private int itemType;
private String itemSubclass;
private int itemCount;
private double itemAmount;
private int saleCount;
private double saleAmount;
private int creditCount;
private double creditAmount;
private double feesDue;
private double feesPaid;
private double expense;
private double expenseActual;
private String dataSource;
private long dataSourceId;
private double rate;
private double perItem;


public long getRecId() {
	return recId;
}
public void setRecId(long recId) {
	this.recId = recId;
}
public long getMerchantNumber() {
	return merchantNumber;
}
public void setMerchantNumber(long merchantNumber) {
	this.merchantNumber = merchantNumber;
}
public Date getActivityDate() {
	return activityDate;
}
public void setActivityDate(Date activityDate) {
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
public double getItemAmount() {
	return itemAmount;
}
public void setItemAmount(double itemAmount) {
	this.itemAmount = itemAmount;
}
public int getSaleCount() {
	return saleCount;
}
public void setSaleCount(int saleCount) {
	this.saleCount = saleCount;
}
public double getSaleAmount() {
	return saleAmount;
}
public void setSaleAmount(double saleAmount) {
	this.saleAmount = saleAmount;
}
public int getCreditCount() {
	return creditCount;
}
public void setCreditCount(int creditCount) {
	this.creditCount = creditCount;
}
public double getCreditAmount() {
	return creditAmount;
}
public void setCreditAmount(double creditAmount) {
	this.creditAmount = creditAmount;
}
public double getFeesDue() {
	return feesDue;
}
public void setFeesDue(double feesDue) {
	this.feesDue = feesDue;
}
public double getFeesPaid() {
	return feesPaid;
}
public void setFeesPaid(double feesPaid) {
	this.feesPaid = feesPaid;
}
public double getExpense() {
	return expense;
}
public void setExpense(double expense) {
	this.expense = expense;
}
public double getExpenseActual() {
	return expenseActual;
}
public void setExpenseActual(double expenseActual) {
	this.expenseActual = expenseActual;
}
public String getDataSource() {
	return dataSource;
}
public void setDataSource(String dataSource) {
	this.dataSource = dataSource;
}
public long getDataSourceId() {
	return dataSourceId;
}
public void setDataSourceId(long dataSourceId) {
	this.dataSourceId = dataSourceId;
}
public double getRate() {
	return rate;
}
public void setRate(double rate) {
	this.rate = rate;
}
public double getPerItem() {
	return perItem;
}
public void setPerItem(double perItem) {
	this.perItem = perItem;
}


}
