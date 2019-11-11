package com.mes.lcr.billing.dao;

import java.util.Date;

public class AcclynkSettlementFileDTR {

	private long dtrSeqNum;
	private long merchantNumber;
	private double switchfee;
	private double networkfee;
	private double interchangeFee;
	private double discountFee;
	private String cardtype;
	private Date transactionDateTime;
	private double approvalAmount;
	private double transactionAmount;
	private String network;
	private int salesCount;
	private double salesAmount;
	private int creditCount;
	private double creditAmount;
	private int itemCount;
	private double itemAmount;
	private String loadFilename;
	private long loadFileId;
	private Date settlementDate;
	private Date batchDate;
	private String regulatedIndicator;

	public long getDtrSeqNum() {
		return dtrSeqNum;
	}

	public void setDtrSeqNum(long dtrSeqNum) {
		this.dtrSeqNum = dtrSeqNum;
	}

	public long getMerchantNumber() {
		return this.merchantNumber;
	}

	public void setMerchantNumber(long merchantNumber) {
		this.merchantNumber = merchantNumber;
	}

	public double getSwitchfee() {
		return this.switchfee;
	}

	public void setSwitchfee(double switchfee) {
		this.switchfee = switchfee;
	}

	public double getNetworkfee() {
		return this.networkfee;
	}

	public void setNetworkfee(double networkfee) {
		this.networkfee = networkfee;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public Date getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public double getInterchangeFee() {
		return interchangeFee;
	}

	public void setInterchangeFee(double interchangeFee) {
		this.interchangeFee = interchangeFee;
	}

	public double getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(double discountFee) {
		this.discountFee = discountFee;
	}

	public double getApprovalAmount() {
		return approvalAmount;
	}

	public void setApprovalAmount(double approvalAmount) {
		this.approvalAmount = approvalAmount;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
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

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Date getBatchDate() {
		return batchDate;
	}

	public void setBatchDate(Date batchDate) {
		this.batchDate = batchDate;
	}

	public String getRegulatedIndicator() {
		return regulatedIndicator;
	}

	public void setRegulatedIndicator(String regulatedIndicator) {
		this.regulatedIndicator = regulatedIndicator;
	}

	@Override
	public String toString() {
		return "AcclynkSettlementFileDTR [dtrSeqNum=" + dtrSeqNum + ", merchantNumber=" + merchantNumber + ", switchfee=" + switchfee + ", networkfee=" + networkfee + ", interchangeFee=" + interchangeFee + ", discountFee=" + discountFee + ", cardtype=" + cardtype + ", transactionDateTime=" + transactionDateTime + ", approvalAmount=" + approvalAmount + ", transactionAmount=" + transactionAmount + ", network=" + network + ", salesCount=" + salesCount + ", salesAmount=" + salesAmount + ", creditCount=" + creditCount + ", creditAmount=" + creditAmount + ", itemCount=" + itemCount + ", itemAmount=" + itemAmount + ", loadFilename=" + loadFilename + ", loadFileId=" + loadFileId + ", settlementDate=" + settlementDate + ", batchDate=" + batchDate + ", regulatedIndicator=" + regulatedIndicator + "]";
	}

}
