
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
 *         &lt;element name="CloseAllOpenBatchesResult" type="{https://ssl.selectpayment.com/PV}WSUpdateResult" minOccurs="0"/>
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
    "closeAllOpenBatchesResult"
})
@XmlRootElement(name = "CloseAllOpenBatchesResponse")
public class CloseAllOpenBatchesResponse {

    @XmlElement(name = "CloseAllOpenBatchesResult")
    protected WSUpdateResult closeAllOpenBatchesResult;

    /**
     * Gets the value of the closeAllOpenBatchesResult property.
     * 
     * @return
     *     possible object is
     *     {@link WSUpdateResult }
     *     
     */
    public WSUpdateResult getCloseAllOpenBatchesResult() {
        return closeAllOpenBatchesResult;
    }

    /**
     * Sets the value of the closeAllOpenBatchesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSUpdateResult }
     *     
     */
    public void setCloseAllOpenBatchesResult(WSUpdateResult value) {
        this.closeAllOpenBatchesResult = value;
    }

}
