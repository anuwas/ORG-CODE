
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="storeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="storeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="entityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="wsdisplayFields" type="{https://ssl.selectpayment.com/PV}ArrayOfWSDisplayFields" minOccurs="0"/>
 *         &lt;element name="locationIds" type="{https://ssl.selectpayment.com/PV}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="wstransEvent" type="{https://ssl.selectpayment.com/PV}WSTransactionEvent"/>
 *         &lt;element name="wstransStatus" type="{https://ssl.selectpayment.com/PV}ArrayOfWSTransactionStatus" minOccurs="0"/>
 *         &lt;element name="wssettlementType" type="{https://ssl.selectpayment.com/PV}ArrayOfWSSettlementType" minOccurs="0"/>
 *         &lt;element name="wspaymentType" type="{https://ssl.selectpayment.com/PV}WSPaymentType"/>
 *         &lt;element name="wspaymentOrigin" type="{https://ssl.selectpayment.com/PV}ArrayOfWSPaymentOrigin" minOccurs="0"/>
 *         &lt;element name="wssettlementStatus" type="{https://ssl.selectpayment.com/PV}ArrayOfWSSettlementStatus" minOccurs="0"/>
 *         &lt;element name="wsauthResponseCode" type="{https://ssl.selectpayment.com/PV}WSAuthResponseCode"/>
 *         &lt;element name="wsopType" type="{https://ssl.selectpayment.com/PV}WSOperationType"/>
 *         &lt;element name="beginTransDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endTransDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fromAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "storeId",
    "storeKey",
    "entityId",
    "wsdisplayFields",
    "locationIds",
    "wstransEvent",
    "wstransStatus",
    "wssettlementType",
    "wspaymentType",
    "wspaymentOrigin",
    "wssettlementStatus",
    "wsauthResponseCode",
    "wsopType",
    "beginTransDate",
    "endTransDate",
    "fromAmount",
    "toAmount"
})
@XmlRootElement(name = "HistoricalEventReport")
public class HistoricalEventReport {

    protected long storeId;
    protected String storeKey;
    protected int entityId;
    protected ArrayOfWSDisplayFields wsdisplayFields;
    protected ArrayOfInt locationIds;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected WSTransactionEvent wstransEvent;
    protected ArrayOfWSTransactionStatus wstransStatus;
    protected ArrayOfWSSettlementType wssettlementType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected WSPaymentType wspaymentType;
    protected ArrayOfWSPaymentOrigin wspaymentOrigin;
    protected ArrayOfWSSettlementStatus wssettlementStatus;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected WSAuthResponseCode wsauthResponseCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected WSOperationType wsopType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar beginTransDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTransDate;
    protected String fromAmount;
    protected String toAmount;

    /**
     * Gets the value of the storeId property.
     * 
     */
    public long getStoreId() {
        return storeId;
    }

    /**
     * Sets the value of the storeId property.
     * 
     */
    public void setStoreId(long value) {
        this.storeId = value;
    }

    /**
     * Gets the value of the storeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreKey() {
        return storeKey;
    }

    /**
     * Sets the value of the storeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreKey(String value) {
        this.storeKey = value;
    }

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
     * Gets the value of the wsdisplayFields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSDisplayFields }
     *     
     */
    public ArrayOfWSDisplayFields getWsdisplayFields() {
        return wsdisplayFields;
    }

    /**
     * Sets the value of the wsdisplayFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSDisplayFields }
     *     
     */
    public void setWsdisplayFields(ArrayOfWSDisplayFields value) {
        this.wsdisplayFields = value;
    }

    /**
     * Gets the value of the locationIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getLocationIds() {
        return locationIds;
    }

    /**
     * Sets the value of the locationIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setLocationIds(ArrayOfInt value) {
        this.locationIds = value;
    }

    /**
     * Gets the value of the wstransEvent property.
     * 
     * @return
     *     possible object is
     *     {@link WSTransactionEvent }
     *     
     */
    public WSTransactionEvent getWstransEvent() {
        return wstransEvent;
    }

    /**
     * Sets the value of the wstransEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSTransactionEvent }
     *     
     */
    public void setWstransEvent(WSTransactionEvent value) {
        this.wstransEvent = value;
    }

    /**
     * Gets the value of the wstransStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSTransactionStatus }
     *     
     */
    public ArrayOfWSTransactionStatus getWstransStatus() {
        return wstransStatus;
    }

    /**
     * Sets the value of the wstransStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSTransactionStatus }
     *     
     */
    public void setWstransStatus(ArrayOfWSTransactionStatus value) {
        this.wstransStatus = value;
    }

    /**
     * Gets the value of the wssettlementType property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSSettlementType }
     *     
     */
    public ArrayOfWSSettlementType getWssettlementType() {
        return wssettlementType;
    }

    /**
     * Sets the value of the wssettlementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSSettlementType }
     *     
     */
    public void setWssettlementType(ArrayOfWSSettlementType value) {
        this.wssettlementType = value;
    }

    /**
     * Gets the value of the wspaymentType property.
     * 
     * @return
     *     possible object is
     *     {@link WSPaymentType }
     *     
     */
    public WSPaymentType getWspaymentType() {
        return wspaymentType;
    }

    /**
     * Sets the value of the wspaymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSPaymentType }
     *     
     */
    public void setWspaymentType(WSPaymentType value) {
        this.wspaymentType = value;
    }

    /**
     * Gets the value of the wspaymentOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSPaymentOrigin }
     *     
     */
    public ArrayOfWSPaymentOrigin getWspaymentOrigin() {
        return wspaymentOrigin;
    }

    /**
     * Sets the value of the wspaymentOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSPaymentOrigin }
     *     
     */
    public void setWspaymentOrigin(ArrayOfWSPaymentOrigin value) {
        this.wspaymentOrigin = value;
    }

    /**
     * Gets the value of the wssettlementStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSSettlementStatus }
     *     
     */
    public ArrayOfWSSettlementStatus getWssettlementStatus() {
        return wssettlementStatus;
    }

    /**
     * Sets the value of the wssettlementStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSSettlementStatus }
     *     
     */
    public void setWssettlementStatus(ArrayOfWSSettlementStatus value) {
        this.wssettlementStatus = value;
    }

    /**
     * Gets the value of the wsauthResponseCode property.
     * 
     * @return
     *     possible object is
     *     {@link WSAuthResponseCode }
     *     
     */
    public WSAuthResponseCode getWsauthResponseCode() {
        return wsauthResponseCode;
    }

    /**
     * Sets the value of the wsauthResponseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSAuthResponseCode }
     *     
     */
    public void setWsauthResponseCode(WSAuthResponseCode value) {
        this.wsauthResponseCode = value;
    }

    /**
     * Gets the value of the wsopType property.
     * 
     * @return
     *     possible object is
     *     {@link WSOperationType }
     *     
     */
    public WSOperationType getWsopType() {
        return wsopType;
    }

    /**
     * Sets the value of the wsopType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSOperationType }
     *     
     */
    public void setWsopType(WSOperationType value) {
        this.wsopType = value;
    }

    /**
     * Gets the value of the beginTransDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginTransDate() {
        return beginTransDate;
    }

    /**
     * Sets the value of the beginTransDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginTransDate(XMLGregorianCalendar value) {
        this.beginTransDate = value;
    }

    /**
     * Gets the value of the endTransDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTransDate() {
        return endTransDate;
    }

    /**
     * Sets the value of the endTransDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndTransDate(XMLGregorianCalendar value) {
        this.endTransDate = value;
    }

    /**
     * Gets the value of the fromAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromAmount() {
        return fromAmount;
    }

    /**
     * Sets the value of the fromAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromAmount(String value) {
        this.fromAmount = value;
    }

    /**
     * Gets the value of the toAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToAmount() {
        return toAmount;
    }

    /**
     * Sets the value of the toAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToAmount(String value) {
        this.toAmount = value;
    }

}
