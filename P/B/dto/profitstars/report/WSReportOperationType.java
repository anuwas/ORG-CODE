
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSReportOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSReportOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sale"/>
 *     &lt;enumeration value="Auth"/>
 *     &lt;enumeration value="Auth_Only"/>
 *     &lt;enumeration value="Credit"/>
 *     &lt;enumeration value="ACH_Eligible"/>
 *     &lt;enumeration value="Capture"/>
 *     &lt;enumeration value="Void"/>
 *     &lt;enumeration value="Refund"/>
 *     &lt;enumeration value="Force"/>
 *     &lt;enumeration value="Reversal"/>
 *     &lt;enumeration value="Resolve"/>
 *     &lt;enumeration value="Edit"/>
 *     &lt;enumeration value="Batch_Close"/>
 *     &lt;enumeration value="Batch_Reconcile"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="SDCredit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSReportOperationType")
@XmlEnum
public enum WSReportOperationType {

    @XmlEnumValue("Sale")
    SALE("Sale"),
    @XmlEnumValue("Auth")
    AUTH("Auth"),
    @XmlEnumValue("Auth_Only")
    AUTH_ONLY("Auth_Only"),
    @XmlEnumValue("Credit")
    CREDIT("Credit"),
    @XmlEnumValue("ACH_Eligible")
    ACH_ELIGIBLE("ACH_Eligible"),
    @XmlEnumValue("Capture")
    CAPTURE("Capture"),
    @XmlEnumValue("Void")
    VOID("Void"),
    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("Force")
    FORCE("Force"),
    @XmlEnumValue("Reversal")
    REVERSAL("Reversal"),
    @XmlEnumValue("Resolve")
    RESOLVE("Resolve"),
    @XmlEnumValue("Edit")
    EDIT("Edit"),
    @XmlEnumValue("Batch_Close")
    BATCH_CLOSE("Batch_Close"),
    @XmlEnumValue("Batch_Reconcile")
    BATCH_RECONCILE("Batch_Reconcile"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("SDCredit")
    SD_CREDIT("SDCredit");
    private final String value;

    WSReportOperationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSReportOperationType fromValue(String v) {
        for (WSReportOperationType c: WSReportOperationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
