package com.mes.lcr.billing.dao;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class MbsPricing {

	private long recId;
	private long merchantNumber;
	private int itemType;
	private String itemSubclass;
	private double rate;
	private double perItem;
	private long volumeType;
	private String billingMonths;
	private Date validDateBegin;

	public long getRecId() {
		return this.recId;
	}

	public void setRecId(long recId) {
		this.recId = recId;
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

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getPerItem() {
		return this.perItem;
	}

	public void setPerItem(double perItem) {
		this.perItem = perItem;
	}

	public long getVolumeType() {
		return this.volumeType;
	}

	public void setVolumeType(long volumeType) {
		this.volumeType = volumeType;
	}

	public String getBillingMonths() {
		return this.billingMonths;
	}

	public void setBillingMonths(String billingMonths) {
		this.billingMonths = billingMonths;
	}

	public Date getValidDateBegin() {
		return this.validDateBegin;
	}

	public void setValidDateBegin(Date validDateBegin) {
		this.validDateBegin = validDateBegin;
	}

	@Override
	public String toString() {
		return "MbsPricing [recId=" + recId + ", merchantNumber=" + merchantNumber + ", itemType=" + itemType + ", itemSubclass=" + itemSubclass + ", rate=" + rate + ", perItem=" + perItem + ", volumeType=" + volumeType + ", billingMonths=" + billingMonths + ", validDateBegin=" + validDateBegin + "]";
	}

}
