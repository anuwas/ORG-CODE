
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSCollectionSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCollectionSetting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessingSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CollectionSettingsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PrincipalAttempts" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="TimeFinalPresentment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeAttempts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateFeeOverrideAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MinDaysFirstPresentment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MinDaysLastPresentment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ManualRepresentment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DaysBeforeClear" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCollectionSetting", propOrder = {
    "processingSystem",
    "location",
    "collectionSettingsName",
    "enabled",
    "principalAttempts",
    "timeFinalPresentment",
    "feeAttempts",
    "stateFeeOverrideAmount",
    "minDaysFirstPresentment",
    "minDaysLastPresentment",
    "manualRepresentment",
    "daysBeforeClear"
})
public class WSCollectionSetting {

    @XmlElement(name = "ProcessingSystem")
    protected String processingSystem;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "CollectionSettingsName")
    protected String collectionSettingsName;
    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "PrincipalAttempts")
    @XmlSchemaType(name = "unsignedByte")
    protected short principalAttempts;
    @XmlElement(name = "TimeFinalPresentment")
    protected String timeFinalPresentment;
    @XmlElement(name = "FeeAttempts")
    protected String feeAttempts;
    @XmlElement(name = "StateFeeOverrideAmount")
    protected String stateFeeOverrideAmount;
    @XmlElement(name = "MinDaysFirstPresentment")
    protected String minDaysFirstPresentment;
    @XmlElement(name = "MinDaysLastPresentment")
    protected String minDaysLastPresentment;
    @XmlElement(name = "ManualRepresentment")
    protected String manualRepresentment;
    @XmlElement(name = "DaysBeforeClear")
    @XmlSchemaType(name = "unsignedByte")
    protected short daysBeforeClear;

    /**
     * Gets the value of the processingSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessingSystem() {
        return processingSystem;
    }

    /**
     * Sets the value of the processingSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessingSystem(String value) {
        this.processingSystem = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the collectionSettingsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionSettingsName() {
        return collectionSettingsName;
    }

    /**
     * Sets the value of the collectionSettingsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionSettingsName(String value) {
        this.collectionSettingsName = value;
    }

    /**
     * Gets the value of the enabled property.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the principalAttempts property.
     * 
     */
    public short getPrincipalAttempts() {
        return principalAttempts;
    }

    /**
     * Sets the value of the principalAttempts property.
     * 
     */
    public void setPrincipalAttempts(short value) {
        this.principalAttempts = value;
    }

    /**
     * Gets the value of the timeFinalPresentment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeFinalPresentment() {
        return timeFinalPresentment;
    }

    /**
     * Sets the value of the timeFinalPresentment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeFinalPresentment(String value) {
        this.timeFinalPresentment = value;
    }

    /**
     * Gets the value of the feeAttempts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAttempts() {
        return feeAttempts;
    }

    /**
     * Sets the value of the feeAttempts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAttempts(String value) {
        this.feeAttempts = value;
    }

    /**
     * Gets the value of the stateFeeOverrideAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateFeeOverrideAmount() {
        return stateFeeOverrideAmount;
    }

    /**
     * Sets the value of the stateFeeOverrideAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateFeeOverrideAmount(String value) {
        this.stateFeeOverrideAmount = value;
    }

    /**
     * Gets the value of the minDaysFirstPresentment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinDaysFirstPresentment() {
        return minDaysFirstPresentment;
    }

    /**
     * Sets the value of the minDaysFirstPresentment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinDaysFirstPresentment(String value) {
        this.minDaysFirstPresentment = value;
    }

    /**
     * Gets the value of the minDaysLastPresentment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinDaysLastPresentment() {
        return minDaysLastPresentment;
    }

    /**
     * Sets the value of the minDaysLastPresentment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinDaysLastPresentment(String value) {
        this.minDaysLastPresentment = value;
    }

    /**
     * Gets the value of the manualRepresentment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManualRepresentment() {
        return manualRepresentment;
    }

    /**
     * Sets the value of the manualRepresentment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManualRepresentment(String value) {
        this.manualRepresentment = value;
    }

    /**
     * Gets the value of the daysBeforeClear property.
     * 
     */
    public short getDaysBeforeClear() {
        return daysBeforeClear;
    }

    /**
     * Sets the value of the daysBeforeClear property.
     * 
     */
    public void setDaysBeforeClear(short value) {
        this.daysBeforeClear = value;
    }

}
