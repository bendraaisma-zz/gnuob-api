package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for address complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="address">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type">
 *       &lt;sequence>
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="complement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internationalStateAndCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internationalStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stateOrProvince" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="street1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="street2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = { "cityName", "complement", "country", "countryName", "district", "internationalStateAndCity", "internationalStreet", "number", "phone", "postalCode", "stateOrProvince", "street1", "street2" })
public class Address extends Type implements Serializable {

    private static final long serialVersionUID = 6926594235185558246L;
    @XmlElement(required = true)
    protected String cityName;
    protected String complement;
    @XmlElement(required = true)
    protected String country;
    protected String countryName;
    protected String district;
    protected String internationalStateAndCity;
    protected String internationalStreet;
    @XmlElement(required = true)
    protected String number;
    protected String phone;
    @XmlElement(required = true)
    protected String postalCode;
    @XmlElement(required = true)
    protected String stateOrProvince;
    @XmlElement(required = true)
    protected String street1;
    protected String street2;

    /**
     * Gets the value of the cityName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the complement property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getComplement() {
        return complement;
    }

    /**
     * Sets the value of the complement property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setComplement(String value) {
        this.complement = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the countryName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the internationalStateAndCity property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getInternationalStateAndCity() {
        return internationalStateAndCity;
    }

    /**
     * Sets the value of the internationalStateAndCity property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setInternationalStateAndCity(String value) {
        this.internationalStateAndCity = value;
    }

    /**
     * Gets the value of the internationalStreet property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getInternationalStreet() {
        return internationalStreet;
    }

    /**
     * Sets the value of the internationalStreet property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setInternationalStreet(String value) {
        this.internationalStreet = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the stateOrProvince property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    /**
     * Sets the value of the stateOrProvince property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setStateOrProvince(String value) {
        this.stateOrProvince = value;
    }

    /**
     * Gets the value of the street1 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * Sets the value of the street1 property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setStreet1(String value) {
        this.street1 = value;
    }

    /**
     * Gets the value of the street2 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Sets the value of the street2 property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setStreet2(String value) {
        this.street2 = value;
    }

}
