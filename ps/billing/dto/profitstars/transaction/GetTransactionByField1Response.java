
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
 *         &lt;element name="GetTransactionByField1Result" type="{https://ssl.selectpayment.com/PV}ArrayOfWSTransaction" minOccurs="0"/>
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
    "getTransactionByField1Result"
})
@XmlRootElement(name = "GetTransactionByField1Response")
public class GetTransactionByField1Response {

    @XmlElement(name = "GetTransactionByField1Result")
    protected ArrayOfWSTransaction getTransactionByField1Result;

    /**
     * Gets the value of the getTransactionByField1Result property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSTransaction }
     *     
     */
    public ArrayOfWSTransaction getGetTransactionByField1Result() {
        return getTransactionByField1Result;
    }

    /**
     * Sets the value of the getTransactionByField1Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSTransaction }
     *     
     */
    public void setGetTransactionByField1Result(ArrayOfWSTransaction value) {
        this.getTransactionByField1Result = value;
    }

}
