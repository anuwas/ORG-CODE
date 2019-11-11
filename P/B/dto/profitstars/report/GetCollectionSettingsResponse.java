
package com.mes.ps.billing.dto.profitstars.report;

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
 *         &lt;element name="GetCollectionSettingsResult" type="{https://ssl.selectpayment.com/PV}ArrayOfWSCollectionSetting" minOccurs="0"/>
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
    "getCollectionSettingsResult"
})
@XmlRootElement(name = "GetCollectionSettingsResponse")
public class GetCollectionSettingsResponse {

    @XmlElement(name = "GetCollectionSettingsResult")
    protected ArrayOfWSCollectionSetting getCollectionSettingsResult;

    /**
     * Gets the value of the getCollectionSettingsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSCollectionSetting }
     *     
     */
    public ArrayOfWSCollectionSetting getGetCollectionSettingsResult() {
        return getCollectionSettingsResult;
    }

    /**
     * Sets the value of the getCollectionSettingsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSCollectionSetting }
     *     
     */
    public void setGetCollectionSettingsResult(ArrayOfWSCollectionSetting value) {
        this.getCollectionSettingsResult = value;
    }

}
