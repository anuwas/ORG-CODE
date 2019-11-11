package com.mes.lcr.billing.dao;

import java.util.Date;

public class MBSDailySummaryIncomeExpense {

	private long merchantNumber;
	private int itemType;
	private String itemSubclass;
	private Date activityDate;
	private double expense;
	private double expenseActual;
	private int salesCount;
	private double salesAmount;
	private int creditCount;
	private double creditAmount;
	private int itemCount;
	private double itemAmount;
	private String dataSourceName;
	private long dataSourceId;
	private double rate;
	private double perItem;
	private double feesPaid;
	private double feesDue;
	private String network;
	private String regulatedIndicator;
	private String icCat;

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

	public double getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(double feesPaid) {
		this.feesPaid = feesPaid;
	}

	public double getFeesDue() {
		return feesDue;
	}

	public void setFeesDue(double feesDue) {
		this.feesDue = feesDue;
	}

	public long getMerchantNumber() {
		return this.merchantNumber;
	}

	public void setMerchantNumber(long merchantNumber) {
		this.merchantNumber = merchantNumber;
	}

	public int getItemType() {
		return this.itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public String getItemSubclass() {
		return this.itemSubclass;
	}

	public void setItemSubclass(String itemSubclass) {
		this.itemSubclass = itemSubclass;
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

	public int getSalesCount() {
		return salesCount;
	}

	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
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

	public Date getActivityDate() {
		return this.activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public long getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(long dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getRegulatedIndicator() {
		return regulatedIndicator;
	}

	public void setRegulatedIndicator(String regulatedIndicator) {
		this.regulatedIndicator = regulatedIndicator;
	}

	public String getIcCat() {
		return icCat;
	}

	public void setIcCat(String icCat) {
		this.icCat = icCat;
	}

	@Override
	public String toString() {
		return "MBSDailySummaryIncomeExpense [merchantNumber=" + merchantNumber + ", itemType=" + itemType + ", itemSubclass=" + itemSubclass + ", activityDate=" + activityDate + ", expense=" + expense + ", expenseActual=" + expenseActual + ", salesCount=" + salesCount + ", salesAmount=" + salesAmount + ", creditCount=" + creditCount + ", creditAmount=" + creditAmount + ", itemCount=" + itemCount + ", itemAmount=" + itemAmount + ", dataSourceName=" + dataSourceName + ", dataSourceId=" + dataSourceId + ", rate=" + rate + ", perItem=" + perItem + ", feesPaid=" + feesPaid + ", feesDue=" + feesDue + ", network=" + network + ", regulatedIndicator=" + regulatedIndicator + ", icCat=" + icCat + "]";
	}

}
