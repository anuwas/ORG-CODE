
package com.mes.ps.billing.dto.profitstars.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WSTransactionDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSTransactionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LocationId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentOrigin" type="{https://ssl.selectpayment.com/PV}WSPaymentOrigin"/>
 *         &lt;element name="AccountType" type="{https://ssl.selectpayment.com/PV}WSAccountType"/>
 *         &lt;element name="OperationType" type="{https://ssl.selectpayment.com/PV}WSReportOperationType"/>
 *         &lt;element name="TransactionStatus" type="{https://ssl.selectpayment.com/PV}WSReportTransactionStatus"/>
 *         &lt;element name="SettlementStatus" type="{https://ssl.selectpayment.com/PV}WSSettlementStatus"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TransactionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceApplication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginatingAs" type="{https://ssl.selectpayment.com/PV}WSReportSettlementType"/>
 *         &lt;element name="AuthResponse" type="{https://ssl.selectpayment.com/PV}WSAuthResponseCode"/>
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DisplayAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NotificationMethod" type="{https://ssl.selectpayment.com/PV}WSNotificationMethod"/>
 *         &lt;element name="FaceFeeType" type="{https://ssl.selectpayment.com/PV}WSFaceFeeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSTransactionDetail", propOrder = {
    "entityId",
    "locationId",
    "customerNumber",
    "paymentOrigin",
    "accountType",
    "operationType",
    "transactionStatus",
    "settlementStatus",
    "effectiveDate",
    "transactionDate",
    "description",
    "sourceApplication",
    "originatingAs",
    "authResponse",
    "totalAmount",
    "referenceNumber",
    "transactionNumber",
    "field1",
    "field2",
    "field3",
    "displayAccountNumber",
    "emailAddress",
    "notificationMethod",
    "faceFeeType"
})
public class WSTransactionDetail {

    @XmlElement(name = "EntityId")
    protected int entityId;
    @XmlElement(name = "LocationId")
    protected int locationId;
    @XmlElement(name = "CustomerNumber")
    protected String customerNumber;
    @XmlElement(name = "PaymentOrigin", required = true)
    @XmlSchemaType(name = "string")
    protected WSPaymentOrigin paymentOrigin;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected WSAccountType accountType;
    @XmlElement(name = "OperationType", required = true)
    @XmlSchemaType(name = "string")
    protected WSReportOperationType operationType;
    @XmlElement(name = "TransactionStatus", required = true)
    @XmlSchemaType(name = "string")
    protected WSReportTransactionStatus transactionStatus;
    @XmlElement(name = "SettlementStatus", required = true)
    @XmlSchemaType(name = "string")
    protected WSSettlementStatus settlementStatus;
    @XmlElement(name = "EffectiveDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    @XmlElement(name = "TransactionDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionDate;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "SourceApplication")
    protected String sourceApplication;
    @XmlElement(name = "OriginatingAs", required = true)
    protected String originatingAs;
    @XmlElement(name = "AuthResponse", required = true)
    @XmlSchemaType(name = "string")
    protected WSAuthResponseCode authResponse;
    @XmlElement(name = "TotalAmount", required = true)
    protected BigDecimal totalAmount;
    @XmlElement(name = "ReferenceNumber")
    protected String referenceNumber;
    @XmlElement(name = "TransactionNumber")
    protected String transactionNumber;
    @XmlElement(name = "Field1")
    protected String field1;
    @XmlElement(name = "Field2")
    protected String field2;
    @XmlElement(name = "Field3")
    protected String field3;
    @XmlElement(name = "DisplayAccountNumber")
    protected String displayAccountNumber;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "NotificationMethod", required = true)
    @XmlSchemaType(name = "string")
    protected WSNotificationMethod notificationMethod;
    @XmlElement(name = "FaceFeeType", required = true)
    @XmlSchemaType(name = "string")
    protected WSFaceFeeType faceFeeType;

    /**
     * Gets the value of the entityId property.
     * 
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     * 
     */
    public void setEntityId(int value) {
        this.entityId = value;
    }

    /**
     * Gets the value of the locationId property.
     * 
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     */
    public void setLocationId(int value) {
        this.locationId = value;
    }

    /**
     * Gets the value of the customerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the paymentOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link WSPaymentOrigin }
     *     
     */
    public WSPaymentOrigin getPaymentOrigin() {
        return paymentOrigin;
    }

    /**
     * Sets the value of the paymentOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSPaymentOrigin }
     *     
     */
    public void setPaymentOrigin(WSPaymentOrigin value) {
        this.paymentOrigin = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link WSAccountType }
     *     
     */
    public WSAccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSAccountType }
     *     
     */
    public void setAccountType(WSAccountType value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the operationType property.
     * 
     * @return
     *     possible object is
     *     {@link WSReportOperationType }
     *     
     */
    public WSReportOperationType getOperationType() {
        return operationType;
    }

    /**
     * Sets the value of the operationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSReportOperationType }
     *     
     */
    public void setOperationType(WSReportOperationType value) {
        this.operationType = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link WSReportTransactionStatus }
     *     
     */
    public WSReportTransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSReportTransactionStatus }
     *     
     */
    public void setTransactionStatus(WSReportTransactionStatus value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the settlementStatus property.
     * 
     * @return
     *     possible object is
     *     {@link WSSettlementStatus }
     *     
     */
    public WSSettlementStatus getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * Sets the value of the settlementStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSSettlementStatus }
     *     
     */
    public void setSettlementStatus(WSSettlementStatus value) {
        this.settlementStatus = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the transactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionDate(XMLGregorianCalendar value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the sourceApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceApplication() {
        return sourceApplication;
    }

    /**
     * Sets the value of the sourceApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceApplication(String value) {
        this.sourceApplication = value;
    }

    /**
     * Gets the value of the originatingAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatingAs() {
        return originatingAs;
    }

    /**
     * Sets the value of the originatingAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatingAs(String value) {
        this.originatingAs = value;
    }

    /**
     * Gets the value of the authResponse property.
     * 
     * @return
     *     possible object is
     *     {@link WSAuthResponseCode }
     *     
     */
    public WSAuthResponseCode getAuthResponse() {
        return authResponse;
    }

    /**
     * Sets the value of the authResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSAuthResponseCode }
     *     
     */
    public void setAuthResponse(WSAuthResponseCode value) {
        this.authResponse = value;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the transactionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * Sets the value of the transactionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionNumber(String value) {
        this.transactionNumber = value;
    }

    /**
     * Gets the value of the field1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField1() {
        return field1;
    }

    /**
     * Sets the value of the field1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField1(String value) {
        this.field1 = value;
    }

    /**
     * Gets the value of the field2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField2() {
        return field2;
    }

    /**
     * Sets the value of the field2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField2(String value) {
        this.field2 = value;
    }

    /**
     * Gets the value of the field3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField3() {
        return field3;
    }

    /**
     * Sets the value of the field3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField3(String value) {
        this.field3 = value;
    }

    /**
     * Gets the value of the displayAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayAccountNumber() {
        return displayAccountNumber;
    }

    /**
     * Sets the value of the displayAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayAccountNumber(String value) {
        this.displayAccountNumber = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the notificationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link WSNotificationMethod }
     *     
     */
    public WSNotificationMethod getNotificationMethod() {
        return notificationMethod;
    }

    /**
     * Sets the value of the notificationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSNotificationMethod }
     *     
     */
    public void setNotificationMethod(WSNotificationMethod value) {
        this.notificationMethod = value;
    }

    /**
     * Gets the value of the faceFeeType property.
     * 
     * @return
     *     possible object is
     *     {@link WSFaceFeeType }
     *     
     */
    public WSFaceFeeType getFaceFeeType() {
        return faceFeeType;
    }

    /**
     * Sets the value of the faceFeeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSFaceFeeType }
     *     
     */
    public void setFaceFeeType(WSFaceFeeType value) {
        this.faceFeeType = value;
    }

}
