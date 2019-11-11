
package com.mes.ps.billing.dto.profitstars.transaction;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWSBatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWSBatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSBatch" type="{https://ssl.selectpayment.com/PV}WSBatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWSBatch", propOrder = {
    "wsBatch"
})
public class ArrayOfWSBatch {

    @XmlElement(name = "WSBatch", nillable = true)
    protected List<WSBatch> wsBatch;

    /**
     * Gets the value of the wsBatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsBatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSBatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSBatch }
     * 
     * 
     */
    public List<WSBatch> getWSBatch() {
        if (wsBatch == null) {
            wsBatch = new ArrayList<>();
        }
        return this.wsBatch;
    }

}
