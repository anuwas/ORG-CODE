package com.mes.lcr.billing.dto;

public class PinlessDebitNetworkFees {

	private int recId;
	private String network;
	private double rate;
	private double perItem;
	
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
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
