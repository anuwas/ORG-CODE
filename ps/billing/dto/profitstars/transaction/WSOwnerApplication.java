
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSOwnerApplication.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSOwnerApplication">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Web_Service"/>
 *     &lt;enumeration value="RDN"/>
 *     &lt;enumeration value="RDX"/>
 *     &lt;enumeration value="Remit_Plus"/>
 *     &lt;enumeration value="iPay"/>
 *     &lt;enumeration value="Money_Center"/>
 *     &lt;enumeration value="AutoBooks"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSOwnerApplication")
@XmlEnum
public enum WSOwnerApplication {

    @XmlEnumValue("Web_Service")
    WEB_SERVICE("Web_Service"),
    RDN("RDN"),
    RDX("RDX"),
    @XmlEnumValue("Remit_Plus")
    REMIT_PLUS("Remit_Plus"),
    @XmlEnumValue("iPay")
    I_PAY("iPay"),
    @XmlEnumValue("Money_Center")
    MONEY_CENTER("Money_Center"),
    @XmlEnumValue("AutoBooks")
    AUTO_BOOKS("AutoBooks");
    private final String value;

    WSOwnerApplication(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSOwnerApplication fromValue(String v) {
        for (WSOwnerApplication c: WSOwnerApplication.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
