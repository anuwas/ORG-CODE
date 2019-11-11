
package com.mes.ps.billing.dto.profitstars.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWSEventReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWSEventReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSEventReport" type="{https://ssl.selectpayment.com/PV}WSEventReport" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWSEventReport", propOrder = {
    "wsEventReport"
})
public class ArrayOfWSEventReport {

    @XmlElement(name = "WSEventReport", nillable = true)
    protected List<WSEventReport> wsEventReport;

    /**
     * Gets the value of the wsEventReport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsEventReport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSEventReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSEventReport }
     * 
     * 
     */
    public List<WSEventReport> getWSEventReport() {
        if (wsEventReport == null) {
            wsEventReport = new ArrayList<>();
        }
        return this.wsEventReport;
    }

}
