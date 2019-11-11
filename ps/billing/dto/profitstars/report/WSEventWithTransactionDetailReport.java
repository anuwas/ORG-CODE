
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WSEventWithTransactionDetailReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSEventWithTransactionDetailReport">
 *   &lt;complexContent>
 *     &lt;extension base="{https://ssl.selectpayment.com/PV}WSEventReport">
 *       &lt;sequence>
 *         &lt;element name="SequenceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginatedAs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsDuplicate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FaceFeeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSEventWithTransactionDetailReport", propOrder = {
    "sequenceId",
    "batchNumber",
    "originatedAs",
    "isDuplicate",
    "effectiveDate",
    "faceFeeType"
})
public class WSEventWithTransactionDetailReport
    extends WSEventReport
{

    @XmlElement(name = "SequenceId")
    protected String sequenceId;
    @XmlElement(name = "BatchNumber")
    protected String batchNumber;
    @XmlElement(name = "OriginatedAs")
    protected String originatedAs;
    @XmlElement(name = "IsDuplicate")
    protected String isDuplicate;
    @XmlElement(name = "EffectiveDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    @XmlElement(name = "FaceFeeType")
    protected String faceFeeType;

    /**
     * Gets the value of the sequenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceId() {
        return sequenceId;
    }

    /**
     * Sets the value of the sequenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceId(String value) {
        this.sequenceId = value;
    }

    /**
     * Gets the value of the batchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchNumber(String value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the originatedAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatedAs() {
        return originatedAs;
    }

    /**
     * Sets the value of the originatedAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatedAs(String value) {
        this.originatedAs = value;
    }

    /**
     * Gets the value of the isDuplicate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDuplicate() {
        return isDuplicate;
    }

    /**
     * Sets the value of the isDuplicate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDuplicate(String value) {
        this.isDuplicate = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the faceFeeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaceFeeType() {
        return faceFeeType;
    }

    /**
     * Sets the value of the faceFeeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaceFeeType(String value) {
        this.faceFeeType = value;
    }

}
