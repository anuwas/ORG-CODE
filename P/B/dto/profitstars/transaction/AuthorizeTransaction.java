
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="transaction" type="{https://ssl.selectpayment.com/PV}WSTransaction" minOccurs="0"/>
 *         &lt;element name="ownerApplication" type="{https://ssl.selectpayment.com/PV}WSOwnerApplication"/>
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
    "transaction",
    "ownerApplication"
})
@XmlRootElement(name = "AuthorizeTransaction")
public class AuthorizeTransaction {

    protected long storeId;
    protected String storeKey;
    protected WSTransaction transaction;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected WSOwnerApplication ownerApplication;

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
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link WSTransaction }
     *     
     */
    public WSTransaction getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSTransaction }
     *     
     */
    public void setTransaction(WSTransaction value) {
        this.transaction = value;
    }

    /**
     * Gets the value of the ownerApplication property.
     * 
     * @return
     *     possible object is
     *     {@link WSOwnerApplication }
     *     
     */
    public WSOwnerApplication getOwnerApplication() {
        return ownerApplication;
    }

    /**
     * Sets the value of the ownerApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSOwnerApplication }
     *     
     */
    public void setOwnerApplication(WSOwnerApplication value) {
        this.ownerApplication = value;
    }

}
