
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
 *         &lt;element name="HistoricalEventReportResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
    "historicalEventReportResult"
})
@XmlRootElement(name = "HistoricalEventReportResponse")
public class HistoricalEventReportResponse {

    @XmlElement(name = "HistoricalEventReportResult")
    protected Object historicalEventReportResult;

    /**
     * Gets the value of the historicalEventReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getHistoricalEventReportResult() {
        return historicalEventReportResult;
    }

    /**
     * Sets the value of the historicalEventReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setHistoricalEventReportResult(Object value) {
        this.historicalEventReportResult = value;
    }

}
