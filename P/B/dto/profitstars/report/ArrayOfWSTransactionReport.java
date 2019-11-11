
package com.mes.ps.billing.dto.profitstars.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWSTransactionReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWSTransactionReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSTransactionReport" type="{https://ssl.selectpayment.com/PV}WSTransactionReport" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWSTransactionReport", propOrder = {
    "wsTransactionReport"
})
public class ArrayOfWSTransactionReport {

    @XmlElement(name = "WSTransactionReport", nillable = true)
    protected List<WSTransactionReport> wsTransactionReport;

    /**
     * Gets the value of the wsTransactionReport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsTransactionReport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSTransactionReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSTransactionReport }
     * 
     * 
     */
    public List<WSTransactionReport> getWSTransactionReport() {
        if (wsTransactionReport == null) {
            wsTransactionReport = new ArrayList<>();
        }
        return this.wsTransactionReport;
    }

}
