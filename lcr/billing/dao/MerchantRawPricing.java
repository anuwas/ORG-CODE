package com.mes.lcr.billing.dao;

public class MerchantRawPricing {
	
	private long merchantNumber;
	private String itemSubclass;
	private double rate;
	private double perItem;
	private int itemType;
	

	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public long getMerchantNumber() {
		return merchantNumber;
	}
	public void setMerchantNumber(long merchantNumber) {
		this.merchantNumber = merchantNumber;
	}
	public String getItemSubclass() {
		return itemSubclass;
	}
	public void setItemSubclass(String itemSubclass) {
		this.itemSubclass = itemSubclass;
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
	
	@Override
	public String toString() {
		return "MerchantRawPricing [merchantNumber=" + merchantNumber + ", itemSubclass=" + itemSubclass + ", rate="
				+ rate + ", perItem=" + perItem + ", itemType=" + itemType + "]";
	}
}
