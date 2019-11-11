
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSSettlementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSSettlementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACH"/>
 *     &lt;enumeration value="Check_Image"/>
 *     &lt;enumeration value="Card_Transfer"/>
 *     &lt;enumeration value="None"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSSettlementType")
@XmlEnum
public enum WSSettlementType {

    ACH("ACH"),
    @XmlEnumValue("Check_Image")
    CHECK_IMAGE("Check_Image"),
    @XmlEnumValue("Card_Transfer")
    CARD_TRANSFER("Card_Transfer"),
    @XmlEnumValue("None")
    NONE("None");
    private final String value;

    WSSettlementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSSettlementType fromValue(String v) {
        for (WSSettlementType c: WSSettlementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
