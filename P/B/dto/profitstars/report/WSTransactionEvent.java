
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSTransactionEvent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSTransactionEvent">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Processing_Error"/>
 *     &lt;enumeration value="Voided"/>
 *     &lt;enumeration value="Captured"/>
 *     &lt;enumeration value="Refunded"/>
 *     &lt;enumeration value="Reversed"/>
 *     &lt;enumeration value="Edited"/>
 *     &lt;enumeration value="Processed"/>
 *     &lt;enumeration value="Cleared"/>
 *     &lt;enumeration value="Collected"/>
 *     &lt;enumeration value="Collection_Failed"/>
 *     &lt;enumeration value="Originated"/>
 *     &lt;enumeration value="Settled"/>
 *     &lt;enumeration value="Represented"/>
 *     &lt;enumeration value="Held_For_Approval"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="Sent_To_Collection"/>
 *     &lt;enumeration value="Research_Complete"/>
 *     &lt;enumeration value="Research_Failed"/>
 *     &lt;enumeration value="Disputed"/>
 *     &lt;enumeration value="Returned_NSF"/>
 *     &lt;enumeration value="Returned_Bad_Account"/>
 *     &lt;enumeration value="Other_Check21_Returns"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Notice_Of_Change"/>
 *     &lt;enumeration value="Resolved"/>
 *     &lt;enumeration value="Unauthorized"/>
 *     &lt;enumeration value="Originated_SDACH"/>
 *     &lt;enumeration value="Settled_SDACH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSTransactionEvent")
@XmlEnum
public enum WSTransactionEvent {

    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Processing_Error")
    PROCESSING_ERROR("Processing_Error"),
    @XmlEnumValue("Voided")
    VOIDED("Voided"),
    @XmlEnumValue("Captured")
    CAPTURED("Captured"),
    @XmlEnumValue("Refunded")
    REFUNDED("Refunded"),
    @XmlEnumValue("Reversed")
    REVERSED("Reversed"),
    @XmlEnumValue("Edited")
    EDITED("Edited"),
    @XmlEnumValue("Processed")
    PROCESSED("Processed"),
    @XmlEnumValue("Cleared")
    CLEARED("Cleared"),
    @XmlEnumValue("Collected")
    COLLECTED("Collected"),
    @XmlEnumValue("Collection_Failed")
    COLLECTION_FAILED("Collection_Failed"),
    @XmlEnumValue("Originated")
    ORIGINATED("Originated"),
    @XmlEnumValue("Settled")
    SETTLED("Settled"),
    @XmlEnumValue("Represented")
    REPRESENTED("Represented"),
    @XmlEnumValue("Held_For_Approval")
    HELD_FOR_APPROVAL("Held_For_Approval"),
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended"),
    @XmlEnumValue("Sent_To_Collection")
    SENT_TO_COLLECTION("Sent_To_Collection"),
    @XmlEnumValue("Research_Complete")
    RESEARCH_COMPLETE("Research_Complete"),
    @XmlEnumValue("Research_Failed")
    RESEARCH_FAILED("Research_Failed"),
    @XmlEnumValue("Disputed")
    DISPUTED("Disputed"),
    @XmlEnumValue("Returned_NSF")
    RETURNED_NSF("Returned_NSF"),
    @XmlEnumValue("Returned_Bad_Account")
    RETURNED_BAD_ACCOUNT("Returned_Bad_Account"),
    @XmlEnumValue("Other_Check21_Returns")
    OTHER_CHECK_21_RETURNS("Other_Check21_Returns"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Notice_Of_Change")
    NOTICE_OF_CHANGE("Notice_Of_Change"),
    @XmlEnumValue("Resolved")
    RESOLVED("Resolved"),
    @XmlEnumValue("Unauthorized")
    UNAUTHORIZED("Unauthorized"),
    @XmlEnumValue("Originated_SDACH")
    ORIGINATED_SDACH("Originated_SDACH"),
    @XmlEnumValue("Settled_SDACH")
    SETTLED_SDACH("Settled_SDACH");
    private final String value;

    WSTransactionEvent(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSTransactionEvent fromValue(String v) {
        for (WSTransactionEvent c: WSTransactionEvent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
