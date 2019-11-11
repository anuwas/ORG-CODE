package com.mes.lcr.billing.dao;

import java.util.Date;

public class DailyDetailFileICDesc {

	private String cardType;
	private String icCode;
	private String icDesc;
	private double icRate;
	private double icRatePerItem;
	private Date validDateBegin;
	private Date validDateEnd;
	private int betSegmentId;
	private long recId;
	private String regIcCode;
	private double baseRate;
	private double basePerItem;
	private String customCheckCode;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getIcCode() {
		return icCode;
	}

	public void setIcCode(String icCode) {
		this.icCode = icCode;
	}

	public String getIcDesc() {
		return icDesc;
	}

	public void setIcDesc(String icDesc) {
		this.icDesc = icDesc;
	}

	public double getIcRate() {
		return icRate;
	}

	public void setIcRate(double icRate) {
		this.icRate = icRate;
	}

	public double getIcRatePerItem() {
		return icRatePerItem;
	}

	public void setIcRatePerItem(double icRatePerItem) {
		this.icRatePerItem = icRatePerItem;
	}

	public Date getValidDateBegin() {
		return validDateBegin;
	}

	public void setValidDateBegin(Date validDateBegin) {
		this.validDateBegin = validDateBegin;
	}

	public Date getValidDateEnd() {
		return validDateEnd;
	}

	public void setValidDateEnd(Date validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	public int getBetSegmentId() {
		return betSegmentId;
	}

	public void setBetSegmentId(int betSegmentId) {
		this.betSegmentId = betSegmentId;
	}

	public long getRecId() {
		return recId;
	}

	public void setRecId(long recId) {
		this.recId = recId;
	}

	public String getRegIcCode() {
		return regIcCode;
	}

	public void setRegIcCode(String regIcCode) {
		this.regIcCode = regIcCode;
	}

	public double getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}

	public double getBasePerItem() {
		return basePerItem;
	}

	public void setBasePerItem(double basePerItem) {
		this.basePerItem = basePerItem;
	}

	public String getCustomCheckCode() {
		return customCheckCode;
	}

	public void setCustomCheckCode(String customCheckCode) {
		this.customCheckCode = customCheckCode;
	}

	@Override
	public String toString() {
		return "DailyDetailFileICDesc [cardType=" + cardType + ", icCode=" + icCode + ", icDesc=" + icDesc + ", icRate=" + icRate + ", icRatePerItem=" + icRatePerItem + ", validDateBegin=" + validDateBegin + ", validDateEnd=" + validDateEnd + ", betSegmentId=" + betSegmentId + ", recId=" + recId + ", regIcCode=" + regIcCode + ", baseRate=" + baseRate + ", basePerItem=" + basePerItem + ", customCheckCode=" + customCheckCode + "]";
	}

}
