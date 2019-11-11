
package com.mes.ps.billing.dto.profitstars.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSDisplayFields.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSDisplayFields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Transaction_DateTime"/>
 *     &lt;enumeration value="Transaction_Status_Name"/>
 *     &lt;enumeration value="Payment_Type_Name"/>
 *     &lt;enumeration value="Name_On_Account"/>
 *     &lt;enumeration value="Transaction_Number"/>
 *     &lt;enumeration value="Reference_Number"/>
 *     &lt;enumeration value="Customer_Number"/>
 *     &lt;enumeration value="Operation_Type_Name"/>
 *     &lt;enumeration value="Location_Display_Name"/>
 *     &lt;enumeration value="Total_Amount"/>
 *     &lt;enumeration value="Auth_Response_Type_Name"/>
 *     &lt;enumeration value="Payment_Origin_Name"/>
 *     &lt;enumeration value="Settlement_Status_Name"/>
 *     &lt;enumeration value="Display_Account_Number"/>
 *     &lt;enumeration value="Check_Number"/>
 *     &lt;enumeration value="Cust_Field_1"/>
 *     &lt;enumeration value="Cust_Field_2"/>
 *     &lt;enumeration value="Cust_Field_3"/>
 *     &lt;enumeration value="Field_1"/>
 *     &lt;enumeration value="Field_2"/>
 *     &lt;enumeration value="Field_3"/>
 *     &lt;enumeration value="Third_Party_Reference_Number"/>
 *     &lt;enumeration value="Audit_User_Name"/>
 *     &lt;enumeration value="Event_DateTime"/>
 *     &lt;enumeration value="Event_Type_Name"/>
 *     &lt;enumeration value="Event_Datastring"/>
 *     &lt;enumeration value="__NONE"/>
 *     &lt;enumeration value="OwnerApplication"/>
 *     &lt;enumeration value="ReceivingApplication"/>
 *     &lt;enumeration value="OwnerAppReferenceId"/>
 *     &lt;enumeration value="ReturnCode"/>
 *     &lt;enumeration value="Notice_Of_Change"/>
 *     &lt;enumeration value="SequenceId"/>
 *     &lt;enumeration value="BatchNumber"/>
 *     &lt;enumeration value="OriginatedAs"/>
 *     &lt;enumeration value="IsDuplicate"/>
 *     &lt;enumeration value="EffectiveDate"/>
 *     &lt;enumeration value="FaceFeeType"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSDisplayFields")
@XmlEnum
public enum WSDisplayFields {

    @XmlEnumValue("Transaction_DateTime")
    TRANSACTION_DATE_TIME("Transaction_DateTime"),
    @XmlEnumValue("Transaction_Status_Name")
    TRANSACTION_STATUS_NAME("Transaction_Status_Name"),
    @XmlEnumValue("Payment_Type_Name")
    PAYMENT_TYPE_NAME("Payment_Type_Name"),
    @XmlEnumValue("Name_On_Account")
    NAME_ON_ACCOUNT("Name_On_Account"),
    @XmlEnumValue("Transaction_Number")
    TRANSACTION_NUMBER("Transaction_Number"),
    @XmlEnumValue("Reference_Number")
    REFERENCE_NUMBER("Reference_Number"),
    @XmlEnumValue("Customer_Number")
    CUSTOMER_NUMBER("Customer_Number"),
    @XmlEnumValue("Operation_Type_Name")
    OPERATION_TYPE_NAME("Operation_Type_Name"),
    @XmlEnumValue("Location_Display_Name")
    LOCATION_DISPLAY_NAME("Location_Display_Name"),
    @XmlEnumValue("Total_Amount")
    TOTAL_AMOUNT("Total_Amount"),
    @XmlEnumValue("Auth_Response_Type_Name")
    AUTH_RESPONSE_TYPE_NAME("Auth_Response_Type_Name"),
    @XmlEnumValue("Payment_Origin_Name")
    PAYMENT_ORIGIN_NAME("Payment_Origin_Name"),
    @XmlEnumValue("Settlement_Status_Name")
    SETTLEMENT_STATUS_NAME("Settlement_Status_Name"),
    @XmlEnumValue("Display_Account_Number")
    DISPLAY_ACCOUNT_NUMBER("Display_Account_Number"),
    @XmlEnumValue("Check_Number")
    CHECK_NUMBER("Check_Number"),
    @XmlEnumValue("Cust_Field_1")
    CUST_FIELD_1("Cust_Field_1"),
    @XmlEnumValue("Cust_Field_2")
    CUST_FIELD_2("Cust_Field_2"),
    @XmlEnumValue("Cust_Field_3")
    CUST_FIELD_3("Cust_Field_3"),
    @XmlEnumValue("Field_1")
    FIELD_1("Field_1"),
    @XmlEnumValue("Field_2")
    FIELD_2("Field_2"),
    @XmlEnumValue("Field_3")
    FIELD_3("Field_3"),
    @XmlEnumValue("Third_Party_Reference_Number")
    THIRD_PARTY_REFERENCE_NUMBER("Third_Party_Reference_Number"),
    @XmlEnumValue("Audit_User_Name")
    AUDIT_USER_NAME("Audit_User_Name"),
    @XmlEnumValue("Event_DateTime")
    EVENT_DATE_TIME("Event_DateTime"),
    @XmlEnumValue("Event_Type_Name")
    EVENT_TYPE_NAME("Event_Type_Name"),
    @XmlEnumValue("Event_Datastring")
    EVENT_DATASTRING("Event_Datastring"),
    @XmlEnumValue("__NONE")
    NONE("__NONE"),
    @XmlEnumValue("OwnerApplication")
    OWNER_APPLICATION("OwnerApplication"),
    @XmlEnumValue("ReceivingApplication")
    RECEIVING_APPLICATION("ReceivingApplication"),
    @XmlEnumValue("OwnerAppReferenceId")
    OWNER_APP_REFERENCE_ID("OwnerAppReferenceId"),
    @XmlEnumValue("ReturnCode")
    RETURN_CODE("ReturnCode"),
    @XmlEnumValue("Notice_Of_Change")
    NOTICE_OF_CHANGE("Notice_Of_Change"),
    @XmlEnumValue("SequenceId")
    SEQUENCE_ID("SequenceId"),
    @XmlEnumValue("BatchNumber")
    BATCH_NUMBER("BatchNumber"),
    @XmlEnumValue("OriginatedAs")
    ORIGINATED_AS("OriginatedAs"),
    @XmlEnumValue("IsDuplicate")
    IS_DUPLICATE("IsDuplicate"),
    @XmlEnumValue("EffectiveDate")
    EFFECTIVE_DATE("EffectiveDate"),
    @XmlEnumValue("FaceFeeType")
    FACE_FEE_TYPE("FaceFeeType");
    private final String value;

    WSDisplayFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSDisplayFields fromValue(String v) {
        for (WSDisplayFields c: WSDisplayFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
