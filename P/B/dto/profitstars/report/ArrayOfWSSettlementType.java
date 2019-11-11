
package com.mes.ps.billing.dto.profitstars.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWSSettlementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWSSettlementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSSettlementType" type="{https://ssl.selectpayment.com/PV}WSSettlementType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWSSettlementType", propOrder = {
    "wsSettlementType"
})
public class ArrayOfWSSettlementType {

    @XmlElement(name = "WSSettlementType")
    @XmlSchemaType(name = "string")
    protected List<WSSettlementType> wsSettlementType;

    /**
     * Gets the value of the wsSettlementType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsSettlementType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSSettlementType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSSettlementType }
     * 
     * 
     */
    public List<WSSettlementType> getWSSettlementType() {
        if (wsSettlementType == null) {
            wsSettlementType = new ArrayList<>();
        }
        return this.wsSettlementType;
    }

}
