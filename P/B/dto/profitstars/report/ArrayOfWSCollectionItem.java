
package com.mes.ps.billing.dto.profitstars.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWSCollectionItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWSCollectionItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSCollectionItem" type="{https://ssl.selectpayment.com/PV}WSCollectionItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWSCollectionItem", propOrder = {
    "wsCollectionItem"
})
public class ArrayOfWSCollectionItem {

    @XmlElement(name = "WSCollectionItem", nillable = true)
    protected List<WSCollectionItem> wsCollectionItem;

    /**
     * Gets the value of the wsCollectionItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsCollectionItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSCollectionItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSCollectionItem }
     * 
     * 
     */
    public List<WSCollectionItem> getWSCollectionItem() {
        if (wsCollectionItem == null) {
            wsCollectionItem = new ArrayList<>();
        }
        return this.wsCollectionItem;
    }

}
