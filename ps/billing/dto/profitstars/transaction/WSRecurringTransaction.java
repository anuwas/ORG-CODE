
package com.mes.ps.billing.dto.profitstars.transaction;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WSRecurringTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSRecurringTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LocationId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RecurringPaymentOrigin" type="{https://ssl.selectpayment.com/PV}WSRecurringPaymentOrigin"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="BatchNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsBusinessPayment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NameOnAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IpAddressOfOriginator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "WSRecurringTransaction", propOrder = {
    "entityId",
    "locationId",
    "recurringPaymentOrigin",
    "effectiveDate",
    "description",
    "totalAmount",
    "batchNumber",
    "transactionNumber",
    "field1",
    "field2",
    "field3",
    "routingNumber",
    "accountNumber",
    "checkNumber",
    "isBusinessPayment",
    "nameOnAccount",
    "ipAddressOfOriginator",
    "faceFeeType"
})
public class WSRecurringTransaction {

    @XmlElement(name = "EntityId")
    protected int entityId;
    @XmlElement(name = "LocationId")
    protected int locationId;
    @XmlElement(name = "RecurringPaymentOrigin", required = true)
    @XmlSchemaType(name = "string")
    protected WSRecurringPaymentOrigin recurringPaymentOrigin;
    @XmlElement(name = "EffectiveDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "TotalAmount", required = true)
    protected BigDecimal totalAmount;
    @XmlElement(name = "BatchNumber")
    protected String batchNumber;
    @XmlElement(name = "TransactionNumber")
    protected String transactionNumber;
    @XmlElement(name = "Field1")
    protected String field1;
    @XmlElement(name = "Field2")
    protected String field2;
    @XmlElement(name = "Field3")
    protected String field3;
    @XmlElement(name = "RoutingNumber")
    protected String routingNumber;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "CheckNumber")
    protected String checkNumber;
    @XmlElement(name = "IsBusinessPayment")
    protected boolean isBusinessPayment;
    @XmlElement(name = "NameOnAccount")
    protected String nameOnAccount;
    @XmlElement(name = "IpAddressOfOriginator")
    protected String ipAddressOfOriginator;
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
     * Gets the value of the recurringPaymentOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link WSRecurringPaymentOrigin }
     *     
     */
    public WSRecurringPaymentOrigin getRecurringPaymentOrigin() {
        return recurringPaymentOrigin;
    }

    /**
     * Sets the value of the recurringPaymentOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSRecurringPaymentOrigin }
     *     
     */
    public void setRecurringPaymentOrigin(WSRecurringPaymentOrigin value) {
        this.recurringPaymentOrigin = value;
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
