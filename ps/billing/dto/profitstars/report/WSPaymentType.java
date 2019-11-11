
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSPaymentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSPaymentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Checking"/>
 *     &lt;enumeration value="Savings"/>
 *     &lt;enumeration value="Treasury_Check"/>
 *     &lt;enumeration value="Money_Order"/>
 *     &lt;enumeration value="Travelers_Check"/>
 *     &lt;enumeration value="Convenience_Check"/>
 *     &lt;enumeration value="Cashiers_Check"/>
 *     &lt;enumeration value="CC_Checking"/>
 *     &lt;enumeration value="CC_Savings"/>
 *     &lt;enumeration value="CC_GL"/>
 *     &lt;enumeration value="Visa"/>
 *     &lt;enumeration value="MasterCard"/>
 *     &lt;enumeration value="Discover__Novus"/>
 *     &lt;enumeration value="American_Express"/>
 *     &lt;enumeration value="Diners__Carte_Blanche"/>
 *     &lt;enumeration value="enRoute"/>
 *     &lt;enumeration value="JCB"/>
 *     &lt;enumeration value="Bank_Card"/>
 *     &lt;enumeration value="Gift_Card"/>
 *     &lt;enumeration value="On_Us_Card"/>
 *     &lt;enumeration value="Payroll_Card"/>
 *     &lt;enumeration value="Pay_Pal"/>
 *     &lt;enumeration value="Cash"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSPaymentType")
@XmlEnum
public enum WSPaymentType {

    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Checking")
    CHECKING("Checking"),
    @XmlEnumValue("Savings")
    SAVINGS("Savings"),
    @XmlEnumValue("Treasury_Check")
    TREASURY_CHECK("Treasury_Check"),
    @XmlEnumValue("Money_Order")
    MONEY_ORDER("Money_Order"),
    @XmlEnumValue("Travelers_Check")
    TRAVELERS_CHECK("Travelers_Check"),
    @XmlEnumValue("Convenience_Check")
    CONVENIENCE_CHECK("Convenience_Check"),
    @XmlEnumValue("Cashiers_Check")
    CASHIERS_CHECK("Cashiers_Check"),
    @XmlEnumValue("CC_Checking")
    CC_CHECKING("CC_Checking"),
    @XmlEnumValue("CC_Savings")
    CC_SAVINGS("CC_Savings"),
    CC_GL("CC_GL"),
    @XmlEnumValue("Visa")
    VISA("Visa"),
    @XmlEnumValue("MasterCard")
    MASTER_CARD("MasterCard"),
    @XmlEnumValue("Discover__Novus")
    DISCOVER_NOVUS("Discover__Novus"),
    @XmlEnumValue("American_Express")
    AMERICAN_EXPRESS("American_Express"),
    @XmlEnumValue("Diners__Carte_Blanche")
    DINERS_CARTE_BLANCHE("Diners__Carte_Blanche"),
    @XmlEnumValue("enRoute")
    EN_ROUTE("enRoute"),
    JCB("JCB"),
    @XmlEnumValue("Bank_Card")
    BANK_CARD("Bank_Card"),
    @XmlEnumValue("Gift_Card")
    GIFT_CARD("Gift_Card"),
    @XmlEnumValue("On_Us_Card")
    ON_US_CARD("On_Us_Card"),
    @XmlEnumValue("Payroll_Card")
    PAYROLL_CARD("Payroll_Card"),
    @XmlEnumValue("Pay_Pal")
    PAY_PAL("Pay_Pal"),
    @XmlEnumValue("Cash")
    CASH("Cash");
    private final String value;

    WSPaymentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSPaymentType fromValue(String v) {
        for (WSPaymentType c: WSPaymentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
