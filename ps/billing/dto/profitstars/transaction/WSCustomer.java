
package com.mes.ps.billing.dto.profitstars.transaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSCustomer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCustomer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsCompany" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Field3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OtherEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EveningPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EveningExt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DaytimePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DaytimeExt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DLState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DLNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCustomer", propOrder = {
    "entityId",
    "isCompany",
    "customerNumber",
    "field1",
    "field2",
    "field3",
    "firstName",
    "lastName",
    "email",
    "otherEmail",
    "address1",
    "address2",
    "city",
    "stateRegion",
    "postalCode",
    "country",
    "eveningPhone",
    "eveningExt",
    "daytimePhone",
    "daytimeExt",
    "fax",
    "ssn",
    "dlState",
    "dlNumber"
})
public class WSCustomer {

    @XmlElement(name = "EntityId")
    protected int entityId;
    @XmlElement(name = "IsCompany")
    protected boolean isCompany;
    @XmlElement(name = "CustomerNumber")
    protected String customerNumber;
    @XmlElement(name = "Field1")
    protected String field1;
    @XmlElement(name = "Field2")
    protected String field2;
    @XmlElement(name = "Field3")
    protected String field3;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "OtherEmail")
    protected String otherEmail;
    @XmlElement(name = "Address1")
    protected String address1;
    @XmlElement(name = "Address2")
    protected String address2;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "StateRegion")
    protected String stateRegion;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "EveningPhone")
    protected String eveningPhone;
    @XmlElement(name = "EveningExt")
    protected String eveningExt;
    @XmlElement(name = "DaytimePhone")
    protected String daytimePhone;
    @XmlElement(name = "DaytimeExt")
    protected String daytimeExt;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "SSN")
    protected String ssn;
    @XmlElement(name = "DLState")
    protected String dlState;
    @XmlElement(name = "DLNumber")
    protected String dlNumber;

    /**
     * Gets the value of the entityId property.
     * 
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     * 
     */
    public void setEntityId(int value) {
        this.entityId = value;
    }

    /**
     * Gets the value of the isCompany property.
     * 
     */
    public boolean isIsCompany() {
        return isCompany;
    }

    /**
     * Sets the value of the isCompany property.
     * 
     */
    public void setIsCompany(boolean value) {
        this.isCompany = value;
    }

    /**
     * Gets the value of the customerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the field1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField1() {
        return field1;
    }

    /**
     * Sets the value of the field1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField1(String value) {
        this.field1 = value;
    }

    /**
     * Gets the value of the field2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField2() {
        return field2;
    }

    /**
     * Sets the value of the field2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField2(String value) {
        this.field2 = value;
    }

    /**
     * Gets the value of the field3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField3() {
        return field3;
    }

    /**
     * Sets the value of the field3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField3(String value) {
        this.field3 = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the otherEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherEmail() {
        return otherEmail;
    }

    /**
     * Sets the value of the otherEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherEmail(String value) {
        this.otherEmail = value;
    }

    /**
     * Gets the value of the address1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress1(String value) {
        this.address1 = value;
    }

    /**
     * Gets the value of the address2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Sets the value of the address2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress2(String value) {
        this.address2 = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the stateRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateRegion() {
        return stateRegion;
    }

    /**
     * Sets the value of the stateRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateRegion(String value) {
        this.stateRegion = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the eveningPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEveningPhone() {
        return eveningPhone;
    }

    /**
     * Sets the value of the eveningPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEveningPhone(String value) {
        this.eveningPhone = value;
    }

    /**
     * Gets the value of the eveningExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEveningExt() {
        return eveningExt;
    }

    /**
     * Sets the value of the eveningExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEveningExt(String value) {
        this.eveningExt = value;
    }

    /**
     * Gets the value of the daytimePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaytimePhone() {
        return daytimePhone;
    }

    /**
     * Sets the value of the daytimePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaytimePhone(String value) {
        this.daytimePhone = value;
    }

    /**
     * Gets the value of the daytimeExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaytimeExt() {
        return daytimeExt;
    }

    /**
     * Sets the value of the daytimeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaytimeExt(String value) {
        this.daytimeExt = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the dlState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLState() {
        return dlState;
    }

    /**
     * Sets the value of the dlState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLState(String value) {
        this.dlState = value;
    }

    /**
     * Gets the value of the dlNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLNumber() {
        return dlNumber;
    }

    /**
     * Sets the value of the dlNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLNumber(String value) {
        this.dlNumber = value;
    }

}
