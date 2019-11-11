
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
 *         &lt;element name="GetTransactionByTransactionNumberResult" type="{https://ssl.selectpayment.com/PV}WSTransaction" minOccurs="0"/>
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
    "getTransactionByTransactionNumberResult"
})
@XmlRootElement(name = "GetTransactionByTransactionNumberResponse")
public class GetTransactionByTransactionNumberResponse {

    @XmlElement(name = "GetTransactionByTransactionNumberResult")
    protected WSTransaction getTransactionByTransactionNumberResult;

    /**
     * Gets the value of the getTransactionByTransactionNumberResult property.
     * 
     * @return
     *     possible object is
     *     {@link WSTransaction }
     *     
     */
    public WSTransaction getGetTransactionByTransactionNumberResult() {
        return getTransactionByTransactionNumberResult;
    }

    /**
     * Sets the value of the getTransactionByTransactionNumberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSTransaction }
     *     
     */
    public void setGetTransactionByTransactionNumberResult(WSTransaction value) {
        this.getTransactionByTransactionNumberResult = value;
    }

}
