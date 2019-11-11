
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSCollectionDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCollectionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CollectionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameOnAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WsCollectionItems" type="{https://ssl.selectpayment.com/PV}ArrayOfWSCollectionItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCollectionDetail", propOrder = {
    "returnDate",
    "collectionAmount",
    "referenceNumber",
    "transactionNumber",
    "originalAmount",
    "nameOnAccount",
    "effectiveDate",
    "field1",
    "field2",
    "field3",
    "wsCollectionItems"
})
public class WSCollectionDetail {

    @XmlElement(name = "ReturnDate")
    protected String returnDate;
    @XmlElement(name = "CollectionAmount")
    protected String collectionAmount;
    @XmlElement(name = "ReferenceNumber")
    protected String referenceNumber;
    @XmlElement(name = "TransactionNumber")
    protected String transactionNumber;
    @XmlElement(name = "OriginalAmount")
    protected String originalAmount;
    @XmlElement(name = "NameOnAccount")
    protected String nameOnAccount;
    @XmlElement(name = "EffectiveDate")
    protected String effectiveDate;
    @XmlElement(name = "Field1")
    protected String field1;
    @XmlElement(name = "Field2")
    protected String field2;
    @XmlElement(name = "Field3")
    protected String field3;
    @XmlElement(name = "WsCollectionItems")
    protected ArrayOfWSCollectionItem wsCollectionItems;

    /**
     * Gets the value of the returnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the value of the returnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnDate(String value) {
        this.returnDate = value;
    }

    /**
     * Gets the value of the collectionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionAmount() {
        return collectionAmount;
    }

    /**
     * Sets the value of the collectionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionAmount(String value) {
        this.collectionAmount = value;
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
     * Gets the value of the originalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the value of the originalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalAmount(String value) {
        this.originalAmount = value;
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
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
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
     * Gets the value of the wsCollectionItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSCollectionItem }
     *     
     */
    public ArrayOfWSCollectionItem getWsCollectionItems() {
        return wsCollectionItems;
    }

    /**
     * Sets the value of the wsCollectionItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSCollectionItem }
     *     
     */
    public void setWsCollectionItems(ArrayOfWSCollectionItem value) {
        this.wsCollectionItems = value;
    }

}
