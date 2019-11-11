
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSReportEntryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSReportEntryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sale"/>
 *     &lt;enumeration value="Refund"/>
 *     &lt;enumeration value="Reserve"/>
 *     &lt;enumeration value="Discount_Rate"/>
 *     &lt;enumeration value="Billing"/>
 *     &lt;enumeration value="Adjustment"/>
 *     &lt;enumeration value="Return"/>
 *     &lt;enumeration value="Sweep"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSReportEntryType")
@XmlEnum
public enum WSReportEntryType {

    @XmlEnumValue("Sale")
    SALE("Sale"),
    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("Reserve")
    RESERVE("Reserve"),
    @XmlEnumValue("Discount_Rate")
    DISCOUNT_RATE("Discount_Rate"),
    @XmlEnumValue("Billing")
    BILLING("Billing"),
    @XmlEnumValue("Adjustment")
    ADJUSTMENT("Adjustment"),
    @XmlEnumValue("Return")
    RETURN("Return"),
    @XmlEnumValue("Sweep")
    SWEEP("Sweep");
    private final String value;

    WSReportEntryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSReportEntryType fromValue(String v) {
        for (WSReportEntryType c: WSReportEntryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
