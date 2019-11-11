
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSReportTransactionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSReportTransactionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Voided"/>
 *     &lt;enumeration value="__Queued"/>
 *     &lt;enumeration value="__Batched"/>
 *     &lt;enumeration value="Processed"/>
 *     &lt;enumeration value="Collected"/>
 *     &lt;enumeration value="Awaiting_Capture"/>
 *     &lt;enumeration value="Awaiting_Approval"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="In_Collection"/>
 *     &lt;enumeration value="In_Research"/>
 *     &lt;enumeration value="__CHARGEBACKS"/>
 *     &lt;enumeration value="Disputed"/>
 *     &lt;enumeration value="Uncollected_NSF"/>
 *     &lt;enumeration value="Invalid__Closed_Account"/>
 *     &lt;enumeration value="Resolved"/>
 *     &lt;enumeration value="Other_Check21_Returns"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Unauthorized"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSReportTransactionStatus")
@XmlEnum
public enum WSReportTransactionStatus {

    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Voided")
    VOIDED("Voided"),
    @XmlEnumValue("__Queued")
    QUEUED("__Queued"),
    @XmlEnumValue("__Batched")
    BATCHED("__Batched"),
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
    @XmlEnumValue("__CHARGEBACKS")
    CHARGEBACKS("__CHARGEBACKS"),
    @XmlEnumValue("Disputed")
    DISPUTED("Disputed"),
    @XmlEnumValue("Uncollected_NSF")
    UNCOLLECTED_NSF("Uncollected_NSF"),
    @XmlEnumValue("Invalid__Closed_Account")
    INVALID_CLOSED_ACCOUNT("Invalid__Closed_Account"),
    @XmlEnumValue("Resolved")
    RESOLVED("Resolved"),
    @XmlEnumValue("Other_Check21_Returns")
    OTHER_CHECK_21_RETURNS("Other_Check21_Returns"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Unauthorized")
    UNAUTHORIZED("Unauthorized");
    private final String value;

    WSReportTransactionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSReportTransactionStatus fromValue(String v) {
        for (WSReportTransactionStatus c: WSReportTransactionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
