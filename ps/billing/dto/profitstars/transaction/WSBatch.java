
package com.mes.ps.billing.dto.profitstars.transaction;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WSBatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSBatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BatchNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchStatus" type="{https://ssl.selectpayment.com/PV}WSBatchStatus"/>
 *         &lt;element name="CreateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ClosedDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DebitCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DebitAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CreditCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CreditAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AuthorizedCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DeclinedCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VoidCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CreatedByUserId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ClosedByUserId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AutoCloseDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSBatch", propOrder = {
    "entityId",
    "batchNumber",
    "batchStatus",
    "createDateTime",
    "closedDateTime",
    "debitCount",
    "debitAmount",
    "creditCount",
    "creditAmount",
    "authorizedCount",
    "declinedCount",
    "voidCount",
    "createdByUserId",
    "closedByUserId",
    "autoCloseDateTime"
})
public class WSBatch {

    @XmlElement(name = "EntityId")
    protected int entityId;
    @XmlElement(name = "BatchNumber")
    protected String batchNumber;
    @XmlElement(name = "BatchStatus", required = true)
    @XmlSchemaType(name = "string")
    protected WSBatchStatus batchStatus;
    @XmlElement(name = "CreateDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDateTime;
    @XmlElement(name = "ClosedDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar closedDateTime;
    @XmlElement(name = "DebitCount")
    protected int debitCount;
    @XmlElement(name = "DebitAmount", required = true)
    protected BigDecimal debitAmount;
    @XmlElement(name = "CreditCount")
    protected int creditCount;
    @XmlElement(name = "CreditAmount", required = true)
    protected BigDecimal creditAmount;
    @XmlElement(name = "AuthorizedCount")
    protected int authorizedCount;
    @XmlElement(name = "DeclinedCount")
    protected int declinedCount;
    @XmlElement(name = "VoidCount")
    protected int voidCount;
    @XmlElement(name = "CreatedByUserId")
    protected long createdByUserId;
    @XmlElement(name = "ClosedByUserId")
    protected long closedByUserId;
    @XmlElement(name = "AutoCloseDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar autoCloseDateTime;

    /**
     * Gets the value of the entityId property.
     * 
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     * 
     */
    public void setEntityId(int value) {
        this.entityId = value;
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
     * Gets the value of the batchStatus property.
     * 
     * @return
     *     possible object is
     *     {@link WSBatchStatus }
     *     
     */
    public WSBatchStatus getBatchStatus() {
        return batchStatus;
    }

    /**
     * Sets the value of the batchStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSBatchStatus }
     *     
     */
    public void setBatchStatus(WSBatchStatus value) {
        this.batchStatus = value;
    }

    /**
     * Gets the value of the createDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDateTime() {
        return createDateTime;
    }

    /**
     * Sets the value of the createDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDateTime(XMLGregorianCalendar value) {
        this.createDateTime = value;
    }

    /**
     * Gets the value of the closedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosedDateTime() {
        return closedDateTime;
    }

    /**
     * Sets the value of the closedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosedDateTime(XMLGregorianCalendar value) {
        this.closedDateTime = value;
    }

    /**
     * Gets the value of the debitCount property.
     * 
     */
    public int getDebitCount() {
        return debitCount;
    }

    /**
     * Sets the value of the debitCount property.
     * 
     */
    public void setDebitCount(int value) {
        this.debitCount = value;
    }

    /**
     * Gets the value of the debitAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    /**
     * Sets the value of the debitAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebitAmount(BigDecimal value) {
        this.debitAmount = value;
    }

    /**
     * Gets the value of the creditCount property.
     * 
     */
    public int getCreditCount() {
        return creditCount;
    }

    /**
     * Sets the value of the creditCount property.
     * 
     */
    public void setCreditCount(int value) {
        this.creditCount = value;
    }

    /**
     * Gets the value of the creditAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * Sets the value of the creditAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditAmount(BigDecimal value) {
        this.creditAmount = value;
    }

    /**
     * Gets the value of the authorizedCount property.
     * 
     */
    public int getAuthorizedCount() {
        return authorizedCount;
    }

    /**
     * Sets the value of the authorizedCount property.
     * 
     */
    public void setAuthorizedCount(int value) {
        this.authorizedCount = value;
    }

    /**
     * Gets the value of the declinedCount property.
     * 
     */
    public int getDeclinedCount() {
        return declinedCount;
    }

    /**
     * Sets the value of the declinedCount property.
     * 
     */
    public void setDeclinedCount(int value) {
        this.declinedCount = value;
    }

    /**
     * Gets the value of the voidCount property.
     * 
     */
    public int getVoidCount() {
        return voidCount;
    }

    /**
     * Sets the value of the voidCount property.
     * 
     */
    public void setVoidCount(int value) {
        this.voidCount = value;
    }

    /**
     * Gets the value of the createdByUserId property.
     * 
     */
    public long getCreatedByUserId() {
        return createdByUserId;
    }

    /**
     * Sets the value of the createdByUserId property.
     * 
     */
    public void setCreatedByUserId(long value) {
        this.createdByUserId = value;
    }

    /**
     * Gets the value of the closedByUserId property.
     * 
     */
    public long getClosedByUserId() {
        return closedByUserId;
    }

    /**
     * Sets the value of the closedByUserId property.
     * 
     */
    public void setClosedByUserId(long value) {
        this.closedByUserId = value;
    }

    /**
     * Gets the value of the autoCloseDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAutoCloseDateTime() {
        return autoCloseDateTime;
    }

    /**
     * Sets the value of the autoCloseDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAutoCloseDateTime(XMLGregorianCalendar value) {
        this.autoCloseDateTime = value;
    }

}
