
package com.mes.ps.billing.dto.profitstars.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WSTransactionReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSTransactionReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameOnAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AuthResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentOrigin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettlementStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerField2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerField3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionField2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionField3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ThirdPartyReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuditUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OwnerApplication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceivingApplication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OwnerAppReferenceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSTransactionReport", propOrder = {
    "transactionStatus",
    "paymentType",
    "nameOnAccount",
    "transactionNumber",
    "referenceNumber",
    "customerNumber",
    "operationType",
    "locationName",
    "transactionDateTime",
    "totalAmount",
    "authResponse",
    "paymentOrigin",
    "settlementStatus",
    "accountNumber",
    "checkNumber",
    "customerField1",
    "customerField2",
    "customerField3",
    "transactionField1",
    "transactionField2",
    "transactionField3",
    "thirdPartyReferenceNumber",
    "auditUserName",
    "ownerApplication",
    "receivingApplication",
    "ownerAppReferenceId",
    "returnCode"
})
@XmlSeeAlso({
    WSEventReport.class
})
public class WSTransactionReport {

    @XmlElement(name = "TransactionStatus")
    protected String transactionStatus;
    @XmlElement(name = "PaymentType")
    protected String paymentType;
    @XmlElement(name = "NameOnAccount")
    protected String nameOnAccount;
    @XmlElement(name = "TransactionNumber")
    protected String transactionNumber;
    @XmlElement(name = "ReferenceNumber")
    protected String referenceNumber;
    @XmlElement(name = "CustomerNumber")
    protected String customerNumber;
    @XmlElement(name = "OperationType")
    protected String operationType;
    @XmlElement(name = "LocationName")
    protected String locationName;
    @XmlElement(name = "TransactionDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionDateTime;
    @XmlElement(name = "TotalAmount", required = true)
    protected BigDecimal totalAmount;
    @XmlElement(name = "AuthResponse")
    protected String authResponse;
    @XmlElement(name = "PaymentOrigin")
    protected String paymentOrigin;
    @XmlElement(name = "SettlementStatus")
    protected String settlementStatus;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "CheckNumber")
    protected String checkNumber;
    @XmlElement(name = "CustomerField1")
    protected String customerField1;
    @XmlElement(name = "CustomerField2")
    protected String customerField2;
    @XmlElement(name = "CustomerField3")
    protected String customerField3;
    @XmlElement(name = "TransactionField1")
    protected String transactionField1;
    @XmlElement(name = "TransactionField2")
    protected String transactionField2;
    @XmlElement(name = "TransactionField3")
    protected String transactionField3;
    @XmlElement(name = "ThirdPartyReferenceNumber")
    protected String thirdPartyReferenceNumber;
    @XmlElement(name = "AuditUserName")
    protected String auditUserName;
    @XmlElement(name = "OwnerApplication")
    protected String ownerApplication;
    @XmlElement(name = "ReceivingApplication")
    protected String receivingApplication;
    @XmlElement(name = "OwnerAppReferenceId")
    protected long ownerAppReferenceId;
    @XmlElement(name = "ReturnCode")
    protected String returnCode;

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionStatus(String value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the nameOnAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOnAccount() {
        return nameOnAccount;
    }

    /**
     * Sets the value of the nameOnAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOnAccount(String value) {
        this.nameOnAccount = value;
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
     * Gets the value of the operationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * Sets the value of the operationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationType(String value) {
        this.operationType = value;
    }

    /**
     * Gets the value of the locationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Sets the value of the locationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationName(String value) {
        this.locationName = value;
    }

    /**
     * Gets the value of the transactionDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionDateTime() {
        return transactionDateTime;
    }

    /**
     * Sets the value of the transactionDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionDateTime(XMLGregorianCalendar value) {
        this.transactionDateTime = value;
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
     * Gets the value of the authResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthResponse() {
        return authResponse;
    }

    /**
     * Sets the value of the authResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthResponse(String value) {
        this.authResponse = value;
    }

    /**
     * Gets the value of the paymentOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentOrigin() {
        return paymentOrigin;
    }

    /**
     * Sets the value of the paymentOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentOrigin(String value) {
        this.paymentOrigin = value;
    }

    /**
     * Gets the value of the settlementStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * Sets the value of the settlementStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementStatus(String value) {
        this.settlementStatus = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the checkNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    /**
     * Sets the value of the checkNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckNumber(String value) {
        this.checkNumber = value;
    }

    /**
     * Gets the value of the customerField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerField1() {
        return customerField1;
    }

    /**
     * Sets the value of the customerField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerField1(String value) {
        this.customerField1 = value;
    }

    /**
     * Gets the value of the customerField2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerField2() {
        return customerField2;
    }

    /**
     * Sets the value of the customerField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerField2(String value) {
        this.customerField2 = value;
    }

    /**
     * Gets the value of the customerField3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerField3() {
        return customerField3;
    }

    /**
     * Sets the value of the customerField3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerField3(String value) {
        this.customerField3 = value;
    }

    /**
     * Gets the value of the transactionField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionField1() {
        return transactionField1;
    }

    /**
     * Sets the value of the transactionField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionField1(String value) {
        this.transactionField1 = value;
    }

    /**
     * Gets the value of the transactionField2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionField2() {
        return transactionField2;
    }

    /**
     * Sets the value of the transactionField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionField2(String value) {
        this.transactionField2 = value;
    }

    /**
     * Gets the value of the transactionField3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionField3() {
        return transactionField3;
    }

    /**
     * Sets the value of the transactionField3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionField3(String value) {
        this.transactionField3 = value;
    }

    /**
     * Gets the value of the thirdPartyReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThirdPartyReferenceNumber() {
        return thirdPartyReferenceNumber;
    }

    /**
     * Sets the value of the thirdPartyReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThirdPartyReferenceNumber(String value) {
        this.thirdPartyReferenceNumber = value;
    }

    /**
     * Gets the value of the auditUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditUserName() {
        return auditUserName;
    }

    /**
     * Sets the value of the auditUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditUserName(String value) {
        this.auditUserName = value;
    }

    /**
     * Gets the value of the ownerApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerApplication() {
        return ownerApplication;
    }

    /**
     * Sets the value of the ownerApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerApplication(String value) {
        this.ownerApplication = value;
    }

    /**
     * Gets the value of the receivingApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceivingApplication() {
        return receivingApplication;
    }

    /**
     * Sets the value of the receivingApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceivingApplication(String value) {
        this.receivingApplication = value;
    }

    /**
     * Gets the value of the ownerAppReferenceId property.
     * 
     */
    public long getOwnerAppReferenceId() {
        return ownerAppReferenceId;
    }

    /**
     * Sets the value of the ownerAppReferenceId property.
     * 
     */
    public void setOwnerAppReferenceId(long value) {
        this.ownerAppReferenceId = value;
    }

    /**
     * Gets the value of the returnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnCode(String value) {
        this.returnCode = value;
    }

}
