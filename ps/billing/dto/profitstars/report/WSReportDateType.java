
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSReportDateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSReportDateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Transactions_Created"/>
 *     &lt;enumeration value="Effective_Dates"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSReportDateType")
@XmlEnum
public enum WSReportDateType {

    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Transactions_Created")
    TRANSACTIONS_CREATED("Transactions_Created"),
    @XmlEnumValue("Effective_Dates")
    EFFECTIVE_DATES("Effective_Dates");
    private final String value;

    WSReportDateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSReportDateType fromValue(String v) {
        for (WSReportDateType c: WSReportDateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
