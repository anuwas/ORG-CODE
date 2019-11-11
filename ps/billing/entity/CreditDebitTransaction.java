package com.mes.ps.billing.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CreditDebitTransaction Entity Bean
 */
public class CreditDebitTransaction {
    private String transactionNumber;
    private String referenceNumber;
    private String entityId;
    private long locationId;
    private Date effectiveDate;
    private Date transactionDate;
    private String operationType;
    private BigDecimal amount;
    private String profileId;

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

	@Override
	public String toString() {
		return "CreditDebitTransaction [transactionNumber=" + transactionNumber + ", referenceNumber=" + referenceNumber
				+ ", entityId=" + "xxxx" + ", locationId=" + "xxxx" + ", effectiveDate=" + effectiveDate
				+ ", transactionDate=" + transactionDate + ", operationType=" + operationType + ", amount=" + amount
				+ ", profileId=" + profileId + "]";
	}
}
