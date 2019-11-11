
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReturnValue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="Error_DoesNotExist"/>
 *     &lt;enumeration value="Error_UniqueConstraint"/>
 *     &lt;enumeration value="Error_Unknown"/>
 *     &lt;enumeration value="Recurring_Due"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReturnValue")
@XmlEnum
public enum ReturnValue {

    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("Error_DoesNotExist")
    ERROR_DOES_NOT_EXIST("Error_DoesNotExist"),
    @XmlEnumValue("Error_UniqueConstraint")
    ERROR_UNIQUE_CONSTRAINT("Error_UniqueConstraint"),
    @XmlEnumValue("Error_Unknown")
    ERROR_UNKNOWN("Error_Unknown"),
    @XmlEnumValue("Recurring_Due")
    RECURRING_DUE("Recurring_Due");
    private final String value;

    ReturnValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReturnValue fromValue(String v) {
        for (ReturnValue c: ReturnValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
