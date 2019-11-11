
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
 *         &lt;element name="GetTransactionResult" type="{https://ssl.selectpayment.com/PV}WSTransaction" minOccurs="0"/>
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
    "getTransactionResult"
})
@XmlRootElement(name = "GetTransactionResponse")
public class GetTransactionResponse {

    @XmlElement(name = "GetTransactionResult")
    protected WSTransaction getTransactionResult;

    /**
     * Gets the value of the getTransactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link WSTransaction }
     *     
     */
    public WSTransaction getGetTransactionResult() {
        return getTransactionResult;
    }

    /**
     * Sets the value of the getTransactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSTransaction }
     *     
     */
    public void setGetTransactionResult(WSTransaction value) {
        this.getTransactionResult = value;
    }

}
