
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSTransactionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSTransactionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Voided"/>
 *     &lt;enumeration value="Processed"/>
 *     &lt;enumeration value="Collected"/>
 *     &lt;enumeration value="Awaiting_Capture"/>
 *     &lt;enumeration value="Awaiting_Approval"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="In_Collection"/>
 *     &lt;enumeration value="In_Research"/>
 *     &lt;enumeration value="Disputed"/>
 *     &lt;enumeration value="Uncollected_NSF"/>
 *     &lt;enumeration value="Invalid__Closed_Account"/>
 *     &lt;enumeration value="Other_Check21_Returns"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Resolved"/>
 *     &lt;enumeration value="Unauthorized"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSTransactionStatus")
@XmlEnum
public enum WSTransactionStatus {

    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Voided")
    VOIDED("Voided"),
    @XmlEnumValue("Processed")
    PROCESSED("Processed"),
    @XmlEnumValue("Collected")
    COLLECTED("Collected"),
    @XmlEnumValue("Awaiting_Capture")
    AWAITING_CAPTURE("Awaiting_Capture"),
    @XmlEnumValue("Awaiting_Approval")
    AWAITING_APPROVAL("Awaiting_Approval"),
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended"),
    @XmlEnumValue("In_Collection")
    IN_COLLECTION("In_Collection"),
    @XmlEnumValue("In_Research")
    IN_RESEARCH("In_Research"),
    @XmlEnumValue("Disputed")
    DISPUTED("Disputed"),
    @XmlEnumValue("Uncollected_NSF")
    UNCOLLECTED_NSF("Uncollected_NSF"),
    @XmlEnumValue("Invalid__Closed_Account")
    INVALID_CLOSED_ACCOUNT("Invalid__Closed_Account"),
    @XmlEnumValue("Other_Check21_Returns")
    OTHER_CHECK_21_RETURNS("Other_Check21_Returns"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Resolved")
    RESOLVED("Resolved"),
    @XmlEnumValue("Unauthorized")
    UNAUTHORIZED("Unauthorized");
    private final String value;

    WSTransactionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSTransactionStatus fromValue(String v) {
        for (WSTransactionStatus c: WSTransactionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
