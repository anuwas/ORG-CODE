
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSNotificationMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSNotificationMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Merchant_Notify"/>
 *     &lt;enumeration value="Merchant_Recording"/>
 *     &lt;enumeration value="Postcard"/>
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="Fax"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSNotificationMethod")
@XmlEnum
public enum WSNotificationMethod {

    @XmlEnumValue("Merchant_Notify")
    MERCHANT_NOTIFY("Merchant_Notify"),
    @XmlEnumValue("Merchant_Recording")
    MERCHANT_RECORDING("Merchant_Recording"),
    @XmlEnumValue("Postcard")
    POSTCARD("Postcard"),
    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("Fax")
    FAX("Fax");
    private final String value;

    WSNotificationMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSNotificationMethod fromValue(String v) {
        for (WSNotificationMethod c: WSNotificationMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
