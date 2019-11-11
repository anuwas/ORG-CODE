
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
 *         &lt;element name="GetCollectionDetailsResult" type="{https://ssl.selectpayment.com/PV}WSCollectionDetail" minOccurs="0"/>
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
    "getCollectionDetailsResult"
})
@XmlRootElement(name = "GetCollectionDetailsResponse")
public class GetCollectionDetailsResponse {

    @XmlElement(name = "GetCollectionDetailsResult")
    protected WSCollectionDetail getCollectionDetailsResult;

    /**
     * Gets the value of the getCollectionDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link WSCollectionDetail }
     *     
     */
    public WSCollectionDetail getGetCollectionDetailsResult() {
        return getCollectionDetailsResult;
    }

    /**
     * Sets the value of the getCollectionDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSCollectionDetail }
     *     
     */
    public void setGetCollectionDetailsResult(WSCollectionDetail value) {
        this.getCollectionDetailsResult = value;
    }

}
