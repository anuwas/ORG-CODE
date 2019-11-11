package com.mes.ps.billing.dto;

import java.math.BigDecimal;

/**
 * EventReport Bean
 */
public class EventReport {
    private String transactionNumber;
    private String locationId;
    private String operationType;
    private String eventType;
    private String eventDate;
    private BigDecimal amount;

    public EventReport() {
    }

    public EventReport(String transactionNumber, String locationId, String operationType, String eventType, String eventDate, BigDecimal amount) {
        this.transactionNumber = transactionNumber;
        this.locationId = locationId;
        this.operationType = operationType;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.amount = amount;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
