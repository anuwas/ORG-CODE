
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSCollectionItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCollectionItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CollectionItemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentAttempt" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="AttemptsRemaining" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="WsCollectionAttempts" type="{https://ssl.selectpayment.com/PV}ArrayOfWSCollectionAttempt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCollectionItem", propOrder = {
    "collectionItemType",
    "amount",
    "status",
    "currentAttempt",
    "attemptsRemaining",
    "wsCollectionAttempts"
})
public class WSCollectionItem {

    @XmlElement(name = "CollectionItemType")
    protected String collectionItemType;
    @XmlElement(name = "Amount")
    protected String amount;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "CurrentAttempt")
    @XmlSchemaType(name = "unsignedByte")
    protected short currentAttempt;
    @XmlElement(name = "AttemptsRemaining")
    @XmlSchemaType(name = "unsignedByte")
    protected short attemptsRemaining;
    @XmlElement(name = "WsCollectionAttempts")
    protected ArrayOfWSCollectionAttempt wsCollectionAttempts;

    /**
     * Gets the value of the collectionItemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionItemType() {
        return collectionItemType;
    }

    /**
     * Sets the value of the collectionItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionItemType(String value) {
        this.collectionItemType = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the currentAttempt property.
     * 
     */
    public short getCurrentAttempt() {
        return currentAttempt;
    }

    /**
     * Sets the value of the currentAttempt property.
     * 
     */
    public void setCurrentAttempt(short value) {
        this.currentAttempt = value;
    }

    /**
     * Gets the value of the attemptsRemaining property.
     * 
     */
    public short getAttemptsRemaining() {
        return attemptsRemaining;
    }

    /**
     * Sets the value of the attemptsRemaining property.
     * 
     */
    public void setAttemptsRemaining(short value) {
        this.attemptsRemaining = value;
    }

    /**
     * Gets the value of the wsCollectionAttempts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSCollectionAttempt }
     *     
     */
    public ArrayOfWSCollectionAttempt getWsCollectionAttempts() {
        return wsCollectionAttempts;
    }

    /**
     * Sets the value of the wsCollectionAttempts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSCollectionAttempt }
     *     
     */
    public void setWsCollectionAttempts(ArrayOfWSCollectionAttempt value) {
        this.wsCollectionAttempts = value;
    }

}
