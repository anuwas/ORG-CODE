
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
 *         &lt;element name="CreditsandDebitsTransactionDetailReportResult" type="{https://ssl.selectpayment.com/PV}ArrayOfWSSettlementBatch" minOccurs="0"/>
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
    "creditsandDebitsTransactionDetailReportResult"
})
@XmlRootElement(name = "CreditsandDebitsTransactionDetailReportResponse")
public class CreditsandDebitsTransactionDetailReportResponse {

    @XmlElement(name = "CreditsandDebitsTransactionDetailReportResult")
    protected ArrayOfWSSettlementBatch creditsandDebitsTransactionDetailReportResult;

    /**
     * Gets the value of the creditsandDebitsTransactionDetailReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWSSettlementBatch }
     *     
     */
    public ArrayOfWSSettlementBatch getCreditsandDebitsTransactionDetailReportResult() {
        return creditsandDebitsTransactionDetailReportResult;
    }

    /**
     * Sets the value of the creditsandDebitsTransactionDetailReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWSSettlementBatch }
     *     
     */
    public void setCreditsandDebitsTransactionDetailReportResult(ArrayOfWSSettlementBatch value) {
        this.creditsandDebitsTransactionDetailReportResult = value;
    }

}
