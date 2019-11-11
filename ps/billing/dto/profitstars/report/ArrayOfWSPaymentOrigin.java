
package com.mes.ps.billing.dto.profitstars.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWSPaymentOrigin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWSPaymentOrigin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSPaymentOrigin" type="{https://ssl.selectpayment.com/PV}WSPaymentOrigin" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWSPaymentOrigin", propOrder = {
    "wsPaymentOrigin"
})
public class ArrayOfWSPaymentOrigin {

    @XmlElement(name = "WSPaymentOrigin")
    @XmlSchemaType(name = "string")
    protected List<WSPaymentOrigin> wsPaymentOrigin;

    /**
     * Gets the value of the wsPaymentOrigin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsPaymentOrigin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSPaymentOrigin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSPaymentOrigin }
     * 
     * 
     */
    public List<WSPaymentOrigin> getWSPaymentOrigin() {
        if (wsPaymentOrigin == null) {
            wsPaymentOrigin = new ArrayList<>();
        }
        return this.wsPaymentOrigin;
    }

}
