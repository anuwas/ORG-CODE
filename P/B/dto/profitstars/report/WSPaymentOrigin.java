
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSPaymentOrigin.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSPaymentOrigin">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Internet"/>
 *     &lt;enumeration value="Telephone_IVR"/>
 *     &lt;enumeration value="Telephone_Operator"/>
 *     &lt;enumeration value="Mailed_In"/>
 *     &lt;enumeration value="Drop_Box"/>
 *     &lt;enumeration value="Signature_Faxed"/>
 *     &lt;enumeration value="Signature_Original"/>
 *     &lt;enumeration value="Bounced_Check"/>
 *     &lt;enumeration value="Back_Office"/>
 *     &lt;enumeration value="Retail__POS"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Represented_Check"/>
 *     &lt;enumeration value="Corporate_Trade_Exchange"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSPaymentOrigin")
@XmlEnum
public enum WSPaymentOrigin {

    @XmlEnumValue("Internet")
    INTERNET("Internet"),
    @XmlEnumValue("Telephone_IVR")
    TELEPHONE_IVR("Telephone_IVR"),
    @XmlEnumValue("Telephone_Operator")
    TELEPHONE_OPERATOR("Telephone_Operator"),
    @XmlEnumValue("Mailed_In")
    MAILED_IN("Mailed_In"),
    @XmlEnumValue("Drop_Box")
    DROP_BOX("Drop_Box"),
    @XmlEnumValue("Signature_Faxed")
    SIGNATURE_FAXED("Signature_Faxed"),
    @XmlEnumValue("Signature_Original")
    SIGNATURE_ORIGINAL("Signature_Original"),
    @XmlEnumValue("Bounced_Check")
    BOUNCED_CHECK("Bounced_Check"),
    @XmlEnumValue("Back_Office")
    BACK_OFFICE("Back_Office"),
    @XmlEnumValue("Retail__POS")
    RETAIL_POS("Retail__POS"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Represented_Check")
    REPRESENTED_CHECK("Represented_Check"),
    @XmlEnumValue("Corporate_Trade_Exchange")
    CORPORATE_TRADE_EXCHANGE("Corporate_Trade_Exchange");
    private final String value;

    WSPaymentOrigin(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSPaymentOrigin fromValue(String v) {
        for (WSPaymentOrigin c: WSPaymentOrigin.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
