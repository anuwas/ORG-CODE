
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
 *         &lt;element name="GetHistoricalEventWithTransactionDetailReportResult" type="{https://ssl.selectpayment.com/PV}ArrayOfWSEventWithTransactionDetailReport" minOccurs="0"/>
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
    "getHistoricalEventWithTransactionDetailReportResult"
})
@XmlRootElement(name = "GetHistoricalEventWithTransactionDetailReportResponse")
public class GetHistoricalEventWithTransactionDetailReportResponse {

    @XmlElement(name = "GetHistoricalEventWithTransactionDetailReportResult")
    protected ArrayOfWSEventWithTransactionDetailReport getHistoricalEventWithTransactionDetailReportResult;

    /**
     * Gets the value of the getHistoricalEventWithTransactionDetailReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSEventWithTransactionDetailReport }
     *     
     */
    public ArrayOfWSEventWithTransactionDetailReport getGetHistoricalEventWithTransactionDetailReportResult() {
        return getHistoricalEventWithTransactionDetailReportResult;
    }

    /**
     * Sets the value of the getHistoricalEventWithTransactionDetailReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSEventWithTransactionDetailReport }
     *     
     */
    public void setGetHistoricalEventWithTransactionDetailReportResult(ArrayOfWSEventWithTransactionDetailReport value) {
        this.getHistoricalEventWithTransactionDetailReportResult = value;
    }

}
