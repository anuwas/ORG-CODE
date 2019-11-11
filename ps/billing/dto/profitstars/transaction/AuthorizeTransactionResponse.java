
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
 *         &lt;element name="AuthorizeTransactionResult" type="{https://ssl.selectpayment.com/PV}WSResponseMessage" minOccurs="0"/>
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
    "authorizeTransactionResult"
})
@XmlRootElement(name = "AuthorizeTransactionResponse")
public class AuthorizeTransactionResponse {

    @XmlElement(name = "AuthorizeTransactionResult")
    protected WSResponseMessage authorizeTransactionResult;

    /**
     * Gets the value of the authorizeTransactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link WSResponseMessage }
     *     
     */
    public WSResponseMessage getAuthorizeTransactionResult() {
        return authorizeTransactionResult;
    }

    /**
     * Sets the value of the authorizeTransactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSResponseMessage }
     *     
     */
    public void setAuthorizeTransactionResult(WSResponseMessage value) {
        this.authorizeTransactionResult = value;
    }

}
