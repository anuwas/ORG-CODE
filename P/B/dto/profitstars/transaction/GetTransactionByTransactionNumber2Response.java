
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
 *         &lt;element name="GetTransactionByTransactionNumber2Result" type="{https://ssl.selectpayment.com/PV}WSTransaction2" minOccurs="0"/>
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
    "getTransactionByTransactionNumber2Result"
})
@XmlRootElement(name = "GetTransactionByTransactionNumber2Response")
public class GetTransactionByTransactionNumber2Response {

    @XmlElement(name = "GetTransactionByTransactionNumber2Result")
    protected WSTransaction2 getTransactionByTransactionNumber2Result;

    /**
     * Gets the value of the getTransactionByTransactionNumber2Result property.
     * 
     * @return
     *     possible object is
     *     {@link WSTransaction2 }
     *     
     */
    public WSTransaction2 getGetTransactionByTransactionNumber2Result() {
        return getTransactionByTransactionNumber2Result;
    }

    /**
     * Sets the value of the getTransactionByTransactionNumber2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSTransaction2 }
     *     
     */
    public void setGetTransactionByTransactionNumber2Result(WSTransaction2 value) {
        this.getTransactionByTransactionNumber2Result = value;
    }

}
