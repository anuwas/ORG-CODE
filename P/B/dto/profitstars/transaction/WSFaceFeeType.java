
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSFaceFeeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSFaceFeeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="__None"/>
 *     &lt;enumeration value="Face"/>
 *     &lt;enumeration value="Bill_Convenience_Face"/>
 *     &lt;enumeration value="Custom1"/>
 *     &lt;enumeration value="Custom2"/>
 *     &lt;enumeration value="Custom3"/>
 *     &lt;enumeration value="NSF_Fee"/>
 *     &lt;enumeration value="Convenience_Fee"/>
 *     &lt;enumeration value="Late_Fee"/>
 *     &lt;enumeration value="Bill_Convenience_Fee"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSFaceFeeType")
@XmlEnum
public enum WSFaceFeeType {

    @XmlEnumValue("__None")
    NONE("__None"),
    @XmlEnumValue("Face")
    FACE("Face"),
    @XmlEnumValue("Bill_Convenience_Face")
    BILL_CONVENIENCE_FACE("Bill_Convenience_Face"),
    @XmlEnumValue("Custom1")
    CUSTOM_1("Custom1"),
    @XmlEnumValue("Custom2")
    CUSTOM_2("Custom2"),
    @XmlEnumValue("Custom3")
    CUSTOM_3("Custom3"),
    @XmlEnumValue("NSF_Fee")
    NSF_FEE("NSF_Fee"),
    @XmlEnumValue("Convenience_Fee")
    CONVENIENCE_FEE("Convenience_Fee"),
    @XmlEnumValue("Late_Fee")
    LATE_FEE("Late_Fee"),
    @XmlEnumValue("Bill_Convenience_Fee")
    BILL_CONVENIENCE_FEE("Bill_Convenience_Fee");
    private final String value;

    WSFaceFeeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSFaceFeeType fromValue(String v) {
        for (WSFaceFeeType c: WSFaceFeeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
