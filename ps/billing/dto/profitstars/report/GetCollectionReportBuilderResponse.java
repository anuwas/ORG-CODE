
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
 *         &lt;element name="GetCollectionReportBuilderResult" type="{https://ssl.selectpayment.com/PV}ArrayOfWSCollection" minOccurs="0"/>
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
    "getCollectionReportBuilderResult"
})
@XmlRootElement(name = "GetCollectionReportBuilderResponse")
public class GetCollectionReportBuilderResponse {

    @XmlElement(name = "GetCollectionReportBuilderResult")
    protected ArrayOfWSCollection getCollectionReportBuilderResult;

    /**
     * Gets the value of the getCollectionReportBuilderResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSCollection }
     *     
     */
    public ArrayOfWSCollection getGetCollectionReportBuilderResult() {
        return getCollectionReportBuilderResult;
    }

    /**
     * Sets the value of the getCollectionReportBuilderResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSCollection }
     *     
     */
    public void setGetCollectionReportBuilderResult(ArrayOfWSCollection value) {
        this.getCollectionReportBuilderResult = value;
    }

}
