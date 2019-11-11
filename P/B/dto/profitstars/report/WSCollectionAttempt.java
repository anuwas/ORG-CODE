
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSCollectionAttempt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCollectionAttempt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Attempt" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="CollectionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginallyScheduled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCollectionAttempt", propOrder = {
    "attempt",
    "collectionStatus",
    "originallyScheduled",
    "referenceNumber"
})
public class WSCollectionAttempt {

    @XmlElement(name = "Attempt")
    @XmlSchemaType(name = "unsignedByte")
    protected short attempt;
    @XmlElement(name = "CollectionStatus")
    protected String collectionStatus;
    @XmlElement(name = "OriginallyScheduled")
    protected String originallyScheduled;
    @XmlElement(name = "ReferenceNumber")
    protected String referenceNumber;

    /**
     * Gets the value of the attempt property.
     * 
     */
    public short getAttempt() {
        return attempt;
    }

    /**
     * Sets the value of the attempt property.
     * 
     */
    public void setAttempt(short value) {
        this.attempt = value;
    }

    /**
     * Gets the value of the collectionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionStatus() {
        return collectionStatus;
    }

    /**
     * Sets the value of the collectionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionStatus(String value) {
        this.collectionStatus = value;
    }

    /**
     * Gets the value of the originallyScheduled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginallyScheduled() {
        return originallyScheduled;
    }

    /**
     * Sets the value of the originallyScheduled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginallyScheduled(String value) {
        this.originallyScheduled = value;
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

}
