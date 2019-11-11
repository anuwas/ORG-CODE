
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
 *         &lt;element name="GetCreditandDebitReportsResult" type="{https://ssl.selectpayment.com/PV}ArrayOfWSCreditDebitReport" minOccurs="0"/>
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
    "getCreditandDebitReportsResult"
})
@XmlRootElement(name = "GetCreditandDebitReportsResponse")
public class GetCreditandDebitReportsResponse {

    @XmlElement(name = "GetCreditandDebitReportsResult")
    protected ArrayOfWSCreditDebitReport getCreditandDebitReportsResult;

    /**
     * Gets the value of the getCreditandDebitReportsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSCreditDebitReport }
     *     
     */
    public ArrayOfWSCreditDebitReport getGetCreditandDebitReportsResult() {
        return getCreditandDebitReportsResult;
    }

    /**
     * Sets the value of the getCreditandDebitReportsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSCreditDebitReport }
     *     
     */
    public void setGetCreditandDebitReportsResult(ArrayOfWSCreditDebitReport value) {
        this.getCreditandDebitReportsResult = value;
    }

}
