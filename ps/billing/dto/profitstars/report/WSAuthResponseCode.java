
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSAuthResponseCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSAuthResponseCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="Account_Validated"/>
 *     &lt;enumeration value="Funds_Available"/>
 *     &lt;enumeration value="Duplicate_Transaction"/>
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="Data_Not_Valid"/>
 *     &lt;enumeration value="NSF"/>
 *     &lt;enumeration value="Uncollected"/>
 *     &lt;enumeration value="Fraud_Multiple"/>
 *     &lt;enumeration value="Fraud_Single"/>
 *     &lt;enumeration value="Stop_Payment"/>
 *     &lt;enumeration value="Non_Participant"/>
 *     &lt;enumeration value="Velocity_Count"/>
 *     &lt;enumeration value="Velocity_Amount"/>
 *     &lt;enumeration value="Law_Prohibits"/>
 *     &lt;enumeration value="Customer_Opt_Out_All"/>
 *     &lt;enumeration value="Customer_Opt_Out_Conversion"/>
 *     &lt;enumeration value="Merchant_Opt_Out_Customer"/>
 *     &lt;enumeration value="AVS_Declined"/>
 *     &lt;enumeration value="CCVS_Declined"/>
 *     &lt;enumeration value="Expired"/>
 *     &lt;enumeration value="Authorizer_Supressed_Data"/>
 *     &lt;enumeration value="Account_Closed"/>
 *     &lt;enumeration value="Account_Invalid"/>
 *     &lt;enumeration value="Account_Not_ACHable"/>
 *     &lt;enumeration value="Account_Holder_Deceased"/>
 *     &lt;enumeration value="Account_Frozen"/>
 *     &lt;enumeration value="Account_Not_DDA"/>
 *     &lt;enumeration value="Account_Invalid_Routing"/>
 *     &lt;enumeration value="Account_New"/>
 *     &lt;enumeration value="Account_Unknown"/>
 *     &lt;enumeration value="Account_No_Debits"/>
 *     &lt;enumeration value="Manager_Approval_Required"/>
 *     &lt;enumeration value="Processor_Approval_Required"/>
 *     &lt;enumeration value="Error_Invalid_Format"/>
 *     &lt;enumeration value="Error_Timeout"/>
 *     &lt;enumeration value="Error_Internal"/>
 *     &lt;enumeration value="Error_Connection"/>
 *     &lt;enumeration value="Error_Not_Supported"/>
 *     &lt;enumeration value="Error_Not_Subscribed"/>
 *     &lt;enumeration value="Error_Batch_Closed"/>
 *     &lt;enumeration value="Error_Invalid_Batch"/>
 *     &lt;enumeration value="Error_Invalid_Terminal"/>
 *     &lt;enumeration value="Error_Transaction_Not_Found"/>
 *     &lt;enumeration value="Error_Terminal_Disabled"/>
 *     &lt;enumeration value="Error_Invalid_State"/>
 *     &lt;enumeration value="Error_Unspecified"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="Error_MaxData_Exceeded"/>
 *     &lt;enumeration value="__ERROR_BEGIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSAuthResponseCode")
@XmlEnum
public enum WSAuthResponseCode {

    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("Account_Validated")
    ACCOUNT_VALIDATED("Account_Validated"),
    @XmlEnumValue("Funds_Available")
    FUNDS_AVAILABLE("Funds_Available"),
    @XmlEnumValue("Duplicate_Transaction")
    DUPLICATE_TRANSACTION("Duplicate_Transaction"),
    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("Data_Not_Valid")
    DATA_NOT_VALID("Data_Not_Valid"),
    NSF("NSF"),
    @XmlEnumValue("Uncollected")
    UNCOLLECTED("Uncollected"),
    @XmlEnumValue("Fraud_Multiple")
    FRAUD_MULTIPLE("Fraud_Multiple"),
    @XmlEnumValue("Fraud_Single")
    FRAUD_SINGLE("Fraud_Single"),
    @XmlEnumValue("Stop_Payment")
    STOP_PAYMENT("Stop_Payment"),
    @XmlEnumValue("Non_Participant")
    NON_PARTICIPANT("Non_Participant"),
    @XmlEnumValue("Velocity_Count")
    VELOCITY_COUNT("Velocity_Count"),
    @XmlEnumValue("Velocity_Amount")
    VELOCITY_AMOUNT("Velocity_Amount"),
    @XmlEnumValue("Law_Prohibits")
    LAW_PROHIBITS("Law_Prohibits"),
    @XmlEnumValue("Customer_Opt_Out_All")
    CUSTOMER_OPT_OUT_ALL("Customer_Opt_Out_All"),
    @XmlEnumValue("Customer_Opt_Out_Conversion")
    CUSTOMER_OPT_OUT_CONVERSION("Customer_Opt_Out_Conversion"),
    @XmlEnumValue("Merchant_Opt_Out_Customer")
    MERCHANT_OPT_OUT_CUSTOMER("Merchant_Opt_Out_Customer"),
    @XmlEnumValue("AVS_Declined")
    AVS_DECLINED("AVS_Declined"),
    @XmlEnumValue("CCVS_Declined")
    CCVS_DECLINED("CCVS_Declined"),
    @XmlEnumValue("Expired")
    EXPIRED("Expired"),
    @XmlEnumValue("Authorizer_Supressed_Data")
    AUTHORIZER_SUPRESSED_DATA("Authorizer_Supressed_Data"),
    @XmlEnumValue("Account_Closed")
    ACCOUNT_CLOSED("Account_Closed"),
    @XmlEnumValue("Account_Invalid")
    ACCOUNT_INVALID("Account_Invalid"),
    @XmlEnumValue("Account_Not_ACHable")
    ACCOUNT_NOT_AC_HABLE("Account_Not_ACHable"),
    @XmlEnumValue("Account_Holder_Deceased")
    ACCOUNT_HOLDER_DECEASED("Account_Holder_Deceased"),
    @XmlEnumValue("Account_Frozen")
    ACCOUNT_FROZEN("Account_Frozen"),
    @XmlEnumValue("Account_Not_DDA")
    ACCOUNT_NOT_DDA("Account_Not_DDA"),
    @XmlEnumValue("Account_Invalid_Routing")
    ACCOUNT_INVALID_ROUTING("Account_Invalid_Routing"),
    @XmlEnumValue("Account_New")
    ACCOUNT_NEW("Account_New"),
    @XmlEnumValue("Account_Unknown")
    ACCOUNT_UNKNOWN("Account_Unknown"),
    @XmlEnumValue("Account_No_Debits")
    ACCOUNT_NO_DEBITS("Account_No_Debits"),
    @XmlEnumValue("Manager_Approval_Required")
    MANAGER_APPROVAL_REQUIRED("Manager_Approval_Required"),
    @XmlEnumValue("Processor_Approval_Required")
    PROCESSOR_APPROVAL_REQUIRED("Processor_Approval_Required"),
    @XmlEnumValue("Error_Invalid_Format")
    ERROR_INVALID_FORMAT("Error_Invalid_Format"),
    @XmlEnumValue("Error_Timeout")
    ERROR_TIMEOUT("Error_Timeout"),
    @XmlEnumValue("Error_Internal")
    ERROR_INTERNAL("Error_Internal"),
    @XmlEnumValue("Error_Connection")
    ERROR_CONNECTION("Error_Connection"),
    @XmlEnumValue("Error_Not_Supported")
    ERROR_NOT_SUPPORTED("Error_Not_Supported"),
    @XmlEnumValue("Error_Not_Subscribed")
    ERROR_NOT_SUBSCRIBED("Error_Not_Subscribed"),
    @XmlEnumValue("Error_Batch_Closed")
    ERROR_BATCH_CLOSED("Error_Batch_Closed"),
    @XmlEnumValue("Error_Invalid_Batch")
    ERROR_INVALID_BATCH("Error_Invalid_Batch"),
    @XmlEnumValue("Error_Invalid_Terminal")
    ERROR_INVALID_TERMINAL("Error_Invalid_Terminal"),
    @XmlEnumValue("Error_Transaction_Not_Found")
    ERROR_TRANSACTION_NOT_FOUND("Error_Transaction_Not_Found"),
    @XmlEnumValue("Error_Terminal_Disabled")
    ERROR_TERMINAL_DISABLED("Error_Terminal_Disabled"),
    @XmlEnumValue("Error_Invalid_State")
    ERROR_INVALID_STATE("Error_Invalid_State"),
    @XmlEnumValue("Error_Unspecified")
    ERROR_UNSPECIFIED("Error_Unspecified"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("Error_MaxData_Exceeded")
    ERROR_MAX_DATA_EXCEEDED("Error_MaxData_Exceeded"),
    @XmlEnumValue("__ERROR_BEGIN")
    ERROR_BEGIN("__ERROR_BEGIN");
    private final String value;

    WSAuthResponseCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSAuthResponseCode fromValue(String v) {
        for (WSAuthResponseCode c: WSAuthResponseCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
