
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WSEventReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSEventReport">
 *   &lt;complexContent>
 *     &lt;extension base="{https://ssl.selectpayment.com/PV}WSTransactionReport">
 *       &lt;sequence>
 *         &lt;element name="EventDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EventType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventDatastring" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoticeOfChange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSEventReport", propOrder = {
    "eventDateTime",
    "eventType",
    "eventDatastring",
    "noticeOfChange"
})
@XmlSeeAlso({
    WSEventWithTransactionDetailReport.class
})
public class WSEventReport
    extends WSTransactionReport
{

    @XmlElement(name = "EventDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eventDateTime;
    @XmlElement(name = "EventType")
    protected String eventType;
    @XmlElement(name = "EventDatastring")
    protected String eventDatastring;
    @XmlElement(name = "NoticeOfChange")
    protected String noticeOfChange;

    /**
     * Gets the value of the eventDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEventDateTime() {
        return eventDateTime;
    }

    /**
     * Sets the value of the eventDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEventDateTime(XMLGregorianCalendar value) {
        this.eventDateTime = value;
    }

    /**
     * Gets the value of the eventType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventType(String value) {
        this.eventType = value;
    }

    /**
     * Gets the value of the eventDatastring property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDatastring() {
        return eventDatastring;
    }

    /**
     * Sets the value of the eventDatastring property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDatastring(String value) {
        this.eventDatastring = value;
    }

    /**
     * Gets the value of the noticeOfChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticeOfChange() {
        return noticeOfChange;
    }

    /**
     * Sets the value of the noticeOfChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticeOfChange(String value) {
        this.noticeOfChange = value;
    }

}
