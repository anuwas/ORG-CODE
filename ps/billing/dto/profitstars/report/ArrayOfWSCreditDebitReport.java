
package com.mes.ps.billing.dto.profitstars.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWSCreditDebitReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWSCreditDebitReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSCreditDebitReport" type="{https://ssl.selectpayment.com/PV}WSCreditDebitReport" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWSCreditDebitReport", propOrder = {
    "wsCreditDebitReport"
})
public class ArrayOfWSCreditDebitReport {

    @XmlElement(name = "WSCreditDebitReport", nillable = true)
    protected List<WSCreditDebitReport> wsCreditDebitReport;

    /**
     * Gets the value of the wsCreditDebitReport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsCreditDebitReport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSCreditDebitReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSCreditDebitReport }
     * 
     * 
     */
    public List<WSCreditDebitReport> getWSCreditDebitReport() {
        if (wsCreditDebitReport == null) {
            wsCreditDebitReport = new ArrayList<>();
        }
        return this.wsCreditDebitReport;
    }

}
