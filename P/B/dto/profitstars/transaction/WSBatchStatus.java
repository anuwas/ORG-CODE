
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSBatchStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSBatchStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Open"/>
 *     &lt;enumeration value="Closing"/>
 *     &lt;enumeration value="Closed"/>
 *     &lt;enumeration value="Orphaned"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSBatchStatus")
@XmlEnum
public enum WSBatchStatus {

    @XmlEnumValue("Open")
    OPEN("Open"),
    @XmlEnumValue("Closing")
    CLOSING("Closing"),
    @XmlEnumValue("Closed")
    CLOSED("Closed"),
    @XmlEnumValue("Orphaned")
    ORPHANED("Orphaned");
    private final String value;

    WSBatchStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSBatchStatus fromValue(String v) {
        for (WSBatchStatus c: WSBatchStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
