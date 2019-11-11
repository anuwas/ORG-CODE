
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
 *         &lt;element name="GetBatchResult" type="{https://ssl.selectpayment.com/PV}WSBatch" minOccurs="0"/>
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
    "getBatchResult"
})
@XmlRootElement(name = "GetBatchResponse")
public class GetBatchResponse {

    @XmlElement(name = "GetBatchResult")
    protected WSBatch getBatchResult;

    /**
     * Gets the value of the getBatchResult property.
     * 
     * @return
     *     possible object is
     *     {@link WSBatch }
     *     
     */
    public WSBatch getGetBatchResult() {
        return getBatchResult;
    }

    /**
     * Sets the value of the getBatchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSBatch }
     *     
     */
    public void setGetBatchResult(WSBatch value) {
        this.getBatchResult = value;
    }

}
