
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="entityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TransField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="includeImages" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "transField1",
    "includeImages"
})
@XmlRootElement(name = "GetTransactionByField1")
public class GetTransactionByField1 {

    protected long storeId;
    protected String storeKey;
    protected int entityId;
    @XmlElement(name = "TransField1")
    protected String transField1;
    protected boolean includeImages;

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
     * Gets the value of the transField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransField1() {
        return transField1;
    }

    /**
     * Sets the value of the transField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransField1(String value) {
        this.transField1 = value;
    }

    /**
     * Gets the value of the includeImages property.
     * 
     */
    public boolean isIncludeImages() {
        return includeImages;
    }

    /**
     * Sets the value of the includeImages property.
     * 
     */
    public void setIncludeImages(boolean value) {
        this.includeImages = value;
    }

}
