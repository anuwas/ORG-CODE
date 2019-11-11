
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
 *         &lt;element name="GetHistoricalEventReportResult" type="{https://ssl.selectpayment.com/PV}ArrayOfWSEventReport" minOccurs="0"/>
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
    "getHistoricalEventReportResult"
})
@XmlRootElement(name = "GetHistoricalEventReportResponse")
public class GetHistoricalEventReportResponse {

    @XmlElement(name = "GetHistoricalEventReportResult")
    protected ArrayOfWSEventReport getHistoricalEventReportResult;

    /**
     * Gets the value of the getHistoricalEventReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSEventReport }
     *     
     */
    public ArrayOfWSEventReport getGetHistoricalEventReportResult() {
        return getHistoricalEventReportResult;
    }

    /**
     * Sets the value of the getHistoricalEventReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSEventReport }
     *     
     */
    public void setGetHistoricalEventReportResult(ArrayOfWSEventReport value) {
        this.getHistoricalEventReportResult = value;
    }

}
