
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sale"/>
 *     &lt;enumeration value="Auth"/>
 *     &lt;enumeration value="Auth_Only"/>
 *     &lt;enumeration value="Credit"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Refund"/>
 *     &lt;enumeration value="SDCredit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSOperationType")
@XmlEnum
public enum WSOperationType {

    @XmlEnumValue("Sale")
    SALE("Sale"),
    @XmlEnumValue("Auth")
    AUTH("Auth"),
    @XmlEnumValue("Auth_Only")
    AUTH_ONLY("Auth_Only"),
    @XmlEnumValue("Credit")
    CREDIT("Credit"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("SDCredit")
    SD_CREDIT("SDCredit");
    private final String value;

    WSOperationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSOperationType fromValue(String v) {
        for (WSOperationType c: WSOperationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
