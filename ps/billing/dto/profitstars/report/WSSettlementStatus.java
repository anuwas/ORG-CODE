
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSSettlementStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSSettlementStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No_Settlement_Needed"/>
 *     &lt;enumeration value="To_Be_Originated"/>
 *     &lt;enumeration value="Originating"/>
 *     &lt;enumeration value="Originated_Settlement_Pending"/>
 *     &lt;enumeration value="Settling"/>
 *     &lt;enumeration value="Settled"/>
 *     &lt;enumeration value="Charged_Back"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Originated_SDACH"/>
 *     &lt;enumeration value="Settled_SDACH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSSettlementStatus")
@XmlEnum
public enum WSSettlementStatus {

    @XmlEnumValue("No_Settlement_Needed")
    NO_SETTLEMENT_NEEDED("No_Settlement_Needed"),
    @XmlEnumValue("To_Be_Originated")
    TO_BE_ORIGINATED("To_Be_Originated"),
    @XmlEnumValue("Originating")
    ORIGINATING("Originating"),
    @XmlEnumValue("Originated_Settlement_Pending")
    ORIGINATED_SETTLEMENT_PENDING("Originated_Settlement_Pending"),
    @XmlEnumValue("Settling")
    SETTLING("Settling"),
    @XmlEnumValue("Settled")
    SETTLED("Settled"),
    @XmlEnumValue("Charged_Back")
    CHARGED_BACK("Charged_Back"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Originated_SDACH")
    ORIGINATED_SDACH("Originated_SDACH"),
    @XmlEnumValue("Settled_SDACH")
    SETTLED_SDACH("Settled_SDACH");
    private final String value;

    WSSettlementStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSSettlementStatus fromValue(String v) {
        for (WSSettlementStatus c: WSSettlementStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
