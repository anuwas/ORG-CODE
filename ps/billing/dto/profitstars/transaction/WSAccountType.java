
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSAccountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Checking"/>
 *     &lt;enumeration value="Savings"/>
 *     &lt;enumeration value="Treasury_Check"/>
 *     &lt;enumeration value="Money_Order"/>
 *     &lt;enumeration value="Travelers_Check"/>
 *     &lt;enumeration value="Convenience_Check"/>
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
 *     &lt;enumeration value="Cashiers_Check"/>
 *     &lt;enumeration value="__NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSAccountType")
@XmlEnum
public enum WSAccountType {

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
    @XmlEnumValue("Cashiers_Check")
    CASHIERS_CHECK("Cashiers_Check"),
    @XmlEnumValue("__NONE")
    NONE("__NONE");
    private final String value;

    WSAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSAccountType fromValue(String v) {
        for (WSAccountType c: WSAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
