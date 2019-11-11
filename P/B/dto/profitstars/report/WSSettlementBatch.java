
package com.mes.ps.billing.dto.profitstars.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSSettlementBatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSSettlementBatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntryType" type="{https://ssl.selectpayment.com/PV}WSReportEntryType"/>
 *         &lt;element name="BatchDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="transactionDetails" type="{https://ssl.selectpayment.com/PV}WSTransactionDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSSettlementBatch", propOrder = {
    "entryType",
    "batchDescription",
    "reason",
    "amount",
    "transactionDetails"
})
public class WSSettlementBatch {

    @XmlElement(name = "EntryType", required = true)
    @XmlSchemaType(name = "string")
    protected WSReportEntryType entryType;
    @XmlElement(name = "BatchDescription")
    protected String batchDescription;
    @XmlElement(name = "Reason")
    protected String reason;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    protected WSTransactionDetail transactionDetails;

    /**
     * Gets the value of the entryType property.
     * 
     * @return
     *     possible object is
     *     {@link WSReportEntryType }
     *     
     */
    public WSReportEntryType getEntryType() {
        return entryType;
    }

    /**
     * Sets the value of the entryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSReportEntryType }
     *     
     */
    public void setEntryType(WSReportEntryType value) {
        this.entryType = value;
    }

    /**
     * Gets the value of the batchDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchDescription() {
        return batchDescription;
    }

    /**
     * Sets the value of the batchDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchDescription(String value) {
        this.batchDescription = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the transactionDetails property.
     * 
     * @return
     *     possible object is
     *     {@link WSTransactionDetail }
     *     
     */
    public WSTransactionDetail getTransactionDetails() {
        return transactionDetails;
    }

    /**
     * Sets the value of the transactionDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSTransactionDetail }
     *     
     */
    public void setTransactionDetails(WSTransactionDetail value) {
        this.transactionDetails = value;
    }

}
