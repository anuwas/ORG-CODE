
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSRecurringPaymentOrigin.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSRecurringPaymentOrigin">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Internet"/>
 *     &lt;enumeration value="Telephone_IVR"/>
 *     &lt;enumeration value="Telephone_Operator"/>
 *     &lt;enumeration value="Signature_Faxed"/>
 *     &lt;enumeration value="Signature_Original"/>
 *     &lt;enumeration value="Corporate_Trade_Exchange"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSRecurringPaymentOrigin")
@XmlEnum
public enum WSRecurringPaymentOrigin {

    @XmlEnumValue("Internet")
    INTERNET("Internet"),
    @XmlEnumValue("Telephone_IVR")
    TELEPHONE_IVR("Telephone_IVR"),
    @XmlEnumValue("Telephone_Operator")
    TELEPHONE_OPERATOR("Telephone_Operator"),
    @XmlEnumValue("Signature_Faxed")
    SIGNATURE_FAXED("Signature_Faxed"),
    @XmlEnumValue("Signature_Original")
    SIGNATURE_ORIGINAL("Signature_Original"),
    @XmlEnumValue("Corporate_Trade_Exchange")
    CORPORATE_TRADE_EXCHANGE("Corporate_Trade_Exchange");
    private final String value;

    WSRecurringPaymentOrigin(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSRecurringPaymentOrigin fromValue(String v) {
        for (WSRecurringPaymentOrigin c: WSRecurringPaymentOrigin.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
