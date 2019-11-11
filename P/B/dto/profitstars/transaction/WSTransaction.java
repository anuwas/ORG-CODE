
package com.mes.ps.billing.dto.profitstars.transaction;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WSTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LocationId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PaymentOrigin" type="{https://ssl.selectpayment.com/PV}WSPaymentOrigin"/>
 *         &lt;element name="AccountType" type="{https://ssl.selectpayment.com/PV}WSAccountType"/>
 *         &lt;element name="OperationType" type="{https://ssl.selectpayment.com/PV}WSOperationType"/>
 *         &lt;element name="SettlementType" type="{https://ssl.selectpayment.com/PV}WSSettlementType"/>
 *         &lt;element name="TransactionStatus" type="{https://ssl.selectpayment.com/PV}WSTransactionStatus"/>
 *         &lt;element name="SettlementStatus" type="{https://ssl.selectpayment.com/PV}WSSettlementStatus"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TaxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ShippingAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Sale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConvenienceFeeAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerminalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckMICRLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckMICRSymbolSet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwipeTrack1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwipeTrack2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SwipeTrack3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardExpiresMonth" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="CardExpiresYear" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="CVVNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsBusinessPayment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NameOnAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingStateRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingPostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IpAddressOfOriginator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DLState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DLNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NotificationMethod" type="{https://ssl.selectpayment.com/PV}WSNotificationMethod"/>
 *         &lt;element name="FaceFeeType" type="{https://ssl.selectpayment.com/PV}WSFaceFeeType"/>
 *         &lt;element name="CheckFrontImageBytes_TiffG4" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="CheckRearImageBytes_TiffG4" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="OptionalThirdImageBytes_TiffG4" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="OptionalThirdImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PresentmentNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSTransaction", propOrder = {
    "entityId",
    "locationId",
    "paymentOrigin",
    "accountType",
    "operationType",
    "settlementType",
    "transactionStatus",
    "settlementStatus",
    "effectiveDate",
    "description",
    "totalAmount",
    "taxAmount",
    "shippingAmount",
    "sale",
    "convenienceFeeAmount",
    "batchNumber",
    "terminalNumber",
    "transactionNumber",
    "field1",
    "field2",
    "field3",
    "checkMICRLine",
    "checkMICRSymbolSet",
    "routingNumber",
    "accountNumber",
    "checkNumber",
    "swipeTrack1",
    "swipeTrack2",
    "swipeTrack3",
    "cardExpiresMonth",
    "cardExpiresYear",
    "cvvNumber",
    "isBusinessPayment",
    "nameOnAccount",
    "billingAddress1",
    "billingAddress2",
    "billingCity",
    "billingStateRegion",
    "billingPostalCode",
    "billingCountry",
    "billingPhone",
    "ipAddressOfOriginator",
    "emailAddress",
    "ssn",
    "dlState",
    "dlNumber",
    "notificationMethod",
    "faceFeeType",
    "checkFrontImageBytesTiffG4",
    "checkRearImageBytesTiffG4",
    "optionalThirdImageBytesTiffG4",
    "optionalThirdImageDescription",
    "presentmentNumber"
})
@XmlSeeAlso({
    WSTransaction2 .class
})
public class WSTransaction {

    @XmlElement(name = "EntityId")
    protected int entityId;
    @XmlElement(name = "LocationId")
    protected int locationId;
    @XmlElement(name = "PaymentOrigin", required = true)
    @XmlSchemaType(name = "string")
    protected WSPaymentOrigin paymentOrigin;
    @XmlElement(name = "AccountType", required = true)
    @XmlSchemaType(name = "string")
    protected WSAccountType accountType;
    @XmlElement(name = "OperationType", required = true)
    @XmlSchemaType(name = "string")
    protected WSOperationType operationType;
    @XmlElement(name = "SettlementType", required = true)
    @XmlSchemaType(name = "string")
    protected WSSettlementType settlementType;
    @XmlElement(name = "TransactionStatus", required = true)
    @XmlSchemaType(name = "string")
    protected WSTransactionStatus transactionStatus;
    @XmlElement(name = "SettlementStatus", required = true)
    @XmlSchemaType(name = "string")
    protected WSSettlementStatus settlementStatus;
    @XmlElement(name = "EffectiveDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "TotalAmount", required = true)
    protected BigDecimal totalAmount;
    @XmlElement(name = "TaxAmount", required = true)
    protected BigDecimal taxAmount;
    @XmlElement(name = "ShippingAmount", required = true)
    protected BigDecimal shippingAmount;
    @XmlElement(name = "Sale")
    protected String sale;
    @XmlElement(name = "ConvenienceFeeAmount")
    protected String convenienceFeeAmount;
    @XmlElement(name = "BatchNumber")
    protected String batchNumber;
    @XmlElement(name = "TerminalNumber")
    protected String terminalNumber;
    @XmlElement(name = "TransactionNumber")
    protected String transactionNumber;
    @XmlElement(name = "Field1")
    protected String field1;
    @XmlElement(name = "Field2")
    protected String field2;
    @XmlElement(name = "Field3")
    protected String field3;
    @XmlElement(name = "CheckMICRLine")
    protected String checkMICRLine;
    @XmlElement(name = "CheckMICRSymbolSet")
    protected String checkMICRSymbolSet;
    @XmlElement(name = "RoutingNumber")
    protected String routingNumber;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "CheckNumber")
    protected String checkNumber;
    @XmlElement(name = "SwipeTrack1")
    protected String swipeTrack1;
    @XmlElement(name = "SwipeTrack2")
    protected String swipeTrack2;
    @XmlElement(name = "SwipeTrack3")
    protected String swipeTrack3;
    @XmlElement(name = "CardExpiresMonth")
    @XmlSchemaType(name = "unsignedByte")
    protected short cardExpiresMonth;
    @XmlElement(name = "CardExpiresYear")
    protected short cardExpiresYear;
    @XmlElement(name = "CVVNumber")
    protected int cvvNumber;
    @XmlElement(name = "IsBusinessPayment")
    protected boolean isBusinessPayment;
    @XmlElement(name = "NameOnAccount")
    protected String nameOnAccount;
    @XmlElement(name = "BillingAddress1")
    protected String billingAddress1;
    @XmlElement(name = "BillingAddress2")
    protected String billingAddress2;
    @XmlElement(name = "BillingCity")
    protected String billingCity;
    @XmlElement(name = "BillingStateRegion")
    protected String billingStateRegion;
    @XmlElement(name = "BillingPostalCode")
    protected String billingPostalCode;
    @XmlElement(name = "BillingCountry")
    protected String billingCountry;
    @XmlElement(name = "BillingPhone")
    protected String billingPhone;
    @XmlElement(name = "IpAddressOfOriginator")
    protected String ipAddressOfOriginator;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "SSN")
    protected String ssn;
    @XmlElement(name = "DLState")
    protected String dlState;
    @XmlElement(name = "DLNumber")
    protected String dlNumber;
    @XmlElement(name = "NotificationMethod", required = true)
    @XmlSchemaType(name = "string")
    protected WSNotificationMethod notificationMethod;
    @XmlElement(name = "FaceFeeType", required = true)
    @XmlSchemaType(name = "string")
    protected WSFaceFeeType faceFeeType;
    @XmlElement(name = "CheckFrontImageBytes_TiffG4")
    protected byte[] checkFrontImageBytesTiffG4;
    @XmlElement(name = "CheckRearImageBytes_TiffG4")
    protected byte[] checkRearImageBytesTiffG4;
    @XmlElement(name = "OptionalThirdImageBytes_TiffG4")
    protected byte[] optionalThirdImageBytesTiffG4;
    @XmlElement(name = "OptionalThirdImageDescription")
    protected String optionalThirdImageDescription;
    @XmlElement(name = "PresentmentNumber")
    protected int presentmentNumber;

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
     *     {@link WSOperationType }
     *     
     */
    public WSOperationType getOperationType() {
        return operationType;
    }

    /**
     * Sets the value of the operationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSOperationType }
     *     
     */
    public void setOperationType(WSOperationType value) {
        this.operationType = value;
    }

    /**
     * Gets the value of the settlementType property.
     * 
     * @return
     *     possible object is
     *     {@link WSSettlementType }
     *     
     */
    public WSSettlementType getSettlementType() {
        return settlementType;
    }

    /**
     * Sets the value of the settlementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSSettlementType }
     *     
     */
    public void setSettlementType(WSSettlementType value) {
        this.settlementType = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link WSTransactionStatus }
     *     
     */
    public WSTransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSTransactionStatus }
     *     
     */
    public void setTransactionStatus(WSTransactionStatus value) {
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
     * Gets the value of the taxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the value of the taxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxAmount(BigDecimal value) {
        this.taxAmount = value;
    }

    /**
     * Gets the value of the shippingAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    /**
     * Sets the value of the shippingAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShippingAmount(BigDecimal value) {
        this.shippingAmount = value;
    }

    /**
     * Gets the value of the sale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSale() {
        return sale;
    }

    /**
     * Sets the value of the sale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSale(String value) {
        this.sale = value;
    }

    /**
     * Gets the value of the convenienceFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvenienceFeeAmount() {
        return convenienceFeeAmount;
    }

    /**
     * Sets the value of the convenienceFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvenienceFeeAmount(String value) {
        this.convenienceFeeAmount = value;
    }

    /**
     * Gets the value of the batchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchNumber(String value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the terminalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalNumber() {
        return terminalNumber;
    }

    /**
     * Sets the value of the terminalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalNumber(String value) {
        this.terminalNumber = value;
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
     * Gets the value of the checkMICRLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckMICRLine() {
        return checkMICRLine;
    }

    /**
     * Sets the value of the checkMICRLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckMICRLine(String value) {
        this.checkMICRLine = value;
    }

    /**
     * Gets the value of the checkMICRSymbolSet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckMICRSymbolSet() {
        return checkMICRSymbolSet;
    }

    /**
     * Sets the value of the checkMICRSymbolSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckMICRSymbolSet(String value) {
        this.checkMICRSymbolSet = value;
    }

    /**
     * Gets the value of the routingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutingNumber() {
        return routingNumber;
    }

    /**
     * Sets the value of the routingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutingNumber(String value) {
        this.routingNumber = value;
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
     * Gets the value of the swipeTrack1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwipeTrack1() {
        return swipeTrack1;
    }

    /**
     * Sets the value of the swipeTrack1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwipeTrack1(String value) {
        this.swipeTrack1 = value;
    }

    /**
     * Gets the value of the swipeTrack2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwipeTrack2() {
        return swipeTrack2;
    }

    /**
     * Sets the value of the swipeTrack2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwipeTrack2(String value) {
        this.swipeTrack2 = value;
    }

    /**
     * Gets the value of the swipeTrack3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwipeTrack3() {
        return swipeTrack3;
    }

    /**
     * Sets the value of the swipeTrack3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwipeTrack3(String value) {
        this.swipeTrack3 = value;
    }

    /**
     * Gets the value of the cardExpiresMonth property.
     * 
     */
    public short getCardExpiresMonth() {
        return cardExpiresMonth;
    }

    /**
     * Sets the value of the cardExpiresMonth property.
     * 
     */
    public void setCardExpiresMonth(short value) {
        this.cardExpiresMonth = value;
    }

    /**
     * Gets the value of the cardExpiresYear property.
     * 
     */
    public short getCardExpiresYear() {
        return cardExpiresYear;
    }

    /**
     * Sets the value of the cardExpiresYear property.
     * 
     */
    public void setCardExpiresYear(short value) {
        this.cardExpiresYear = value;
    }

    /**
     * Gets the value of the cvvNumber property.
     * 
     */
    public int getCVVNumber() {
        return cvvNumber;
    }

    /**
     * Sets the value of the cvvNumber property.
     * 
     */
    public void setCVVNumber(int value) {
        this.cvvNumber = value;
    }

    /**
     * Gets the value of the isBusinessPayment property.
     * 
     */
    public boolean isIsBusinessPayment() {
        return isBusinessPayment;
    }

    /**
     * Sets the value of the isBusinessPayment property.
     * 
     */
    public void setIsBusinessPayment(boolean value) {
        this.isBusinessPayment = value;
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
     * Gets the value of the billingAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingAddress1() {
        return billingAddress1;
    }

    /**
     * Sets the value of the billingAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingAddress1(String value) {
        this.billingAddress1 = value;
    }

    /**
     * Gets the value of the billingAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingAddress2() {
        return billingAddress2;
    }

    /**
     * Sets the value of the billingAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingAddress2(String value) {
        this.billingAddress2 = value;
    }

    /**
     * Gets the value of the billingCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     * Sets the value of the billingCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingCity(String value) {
        this.billingCity = value;
    }

    /**
     * Gets the value of the billingStateRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingStateRegion() {
        return billingStateRegion;
    }

    /**
     * Sets the value of the billingStateRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingStateRegion(String value) {
        this.billingStateRegion = value;
    }

    /**
     * Gets the value of the billingPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    /**
     * Sets the value of the billingPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingPostalCode(String value) {
        this.billingPostalCode = value;
    }

    /**
     * Gets the value of the billingCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingCountry() {
        return billingCountry;
    }

    /**
     * Sets the value of the billingCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingCountry(String value) {
        this.billingCountry = value;
    }

    /**
     * Gets the value of the billingPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingPhone() {
        return billingPhone;
    }

    /**
     * Sets the value of the billingPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingPhone(String value) {
        this.billingPhone = value;
    }

    /**
     * Gets the value of the ipAddressOfOriginator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddressOfOriginator() {
        return ipAddressOfOriginator;
    }

    /**
     * Sets the value of the ipAddressOfOriginator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddressOfOriginator(String value) {
        this.ipAddressOfOriginator = value;
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
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the dlState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLState() {
        return dlState;
    }

    /**
     * Sets the value of the dlState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLState(String value) {
        this.dlState = value;
    }

    /**
     * Gets the value of the dlNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLNumber() {
        return dlNumber;
    }

    /**
     * Sets the value of the dlNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLNumber(String value) {
        this.dlNumber = value;
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

    /**
     * Gets the value of the checkFrontImageBytesTiffG4 property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCheckFrontImageBytesTiffG4() {
        return checkFrontImageBytesTiffG4;
    }

    /**
     * Sets the value of the checkFrontImageBytesTiffG4 property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCheckFrontImageBytesTiffG4(byte[] value) {
        this.checkFrontImageBytesTiffG4 = value;
    }

    /**
     * Gets the value of the checkRearImageBytesTiffG4 property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCheckRearImageBytesTiffG4() {
        return checkRearImageBytesTiffG4;
    }

    /**
     * Sets the value of the checkRearImageBytesTiffG4 property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCheckRearImageBytesTiffG4(byte[] value) {
        this.checkRearImageBytesTiffG4 = value;
    }

    /**
     * Gets the value of the optionalThirdImageBytesTiffG4 property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOptionalThirdImageBytesTiffG4() {
        return optionalThirdImageBytesTiffG4;
    }

    /**
     * Sets the value of the optionalThirdImageBytesTiffG4 property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOptionalThirdImageBytesTiffG4(byte[] value) {
        this.optionalThirdImageBytesTiffG4 = value;
    }

    /**
     * Gets the value of the optionalThirdImageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionalThirdImageDescription() {
        return optionalThirdImageDescription;
    }

    /**
     * Sets the value of the optionalThirdImageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionalThirdImageDescription(String value) {
        this.optionalThirdImageDescription = value;
    }

    /**
     * Gets the value of the presentmentNumber property.
     * 
     */
    public int getPresentmentNumber() {
        return presentmentNumber;
    }

    /**
     * Sets the value of the presentmentNumber property.
     * 
     */
    public void setPresentmentNumber(int value) {
        this.presentmentNumber = value;
    }

}
