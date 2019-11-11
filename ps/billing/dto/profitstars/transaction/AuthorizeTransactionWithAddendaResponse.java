
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
 *         &lt;element name="AuthorizeTransactionWithAddendaResult" type="{https://ssl.selectpayment.com/PV}WSResponseMessage" minOccurs="0"/>
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
    "authorizeTransactionWithAddendaResult"
})
@XmlRootElement(name = "AuthorizeTransactionWithAddendaResponse")
public class AuthorizeTransactionWithAddendaResponse {

    @XmlElement(name = "AuthorizeTransactionWithAddendaResult")
    protected WSResponseMessage authorizeTransactionWithAddendaResult;

    /**
     * Gets the value of the authorizeTransactionWithAddendaResult property.
     * 
     * @return
     *     possible object is
     *     {@link WSResponseMessage }
     *     
     */
    public WSResponseMessage getAuthorizeTransactionWithAddendaResult() {
        return authorizeTransactionWithAddendaResult;
    }

    /**
     * Sets the value of the authorizeTransactionWithAddendaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSResponseMessage }
     *     
     */
    public void setAuthorizeTransactionWithAddendaResult(WSResponseMessage value) {
        this.authorizeTransactionWithAddendaResult = value;
    }

}
