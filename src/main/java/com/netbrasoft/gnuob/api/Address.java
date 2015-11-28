
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
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="address"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}abstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="complement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="internationalStateAndCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="internationalStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="stateOrProvince" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="street1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="street2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {"cityName", "complement", "country", "countryName", "district", "internationalStateAndCity", "internationalStreet", "number", "phone",
    "postalCode", "stateOrProvince", "street1", "street2"})
public class Address extends AbstractType implements Serializable {

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
   * Gets the value of the complement property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getComplement() {
    return complement;
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
   * Gets the value of the countryName property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCountryName() {
    return countryName;
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
   * Gets the value of the internationalStateAndCity property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getInternationalStateAndCity() {
    return internationalStateAndCity;
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
   * Gets the value of the number property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getNumber() {
    return number;
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
   * Gets the value of the postalCode property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getPostalCode() {
    return postalCode;
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
   * Gets the value of the street1 property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getStreet1() {
    return street1;
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
   * Sets the value of the cityName property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCityName(final String value) {
    this.cityName = value;
  }

  /**
   * Sets the value of the complement property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setComplement(final String value) {
    this.complement = value;
  }

  /**
   * Sets the value of the country property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCountry(final String value) {
    this.country = value;
  }

  /**
   * Sets the value of the countryName property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCountryName(final String value) {
    this.countryName = value;
  }

  /**
   * Sets the value of the district property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setDistrict(final String value) {
    this.district = value;
  }

  /**
   * Sets the value of the internationalStateAndCity property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setInternationalStateAndCity(final String value) {
    this.internationalStateAndCity = value;
  }

  /**
   * Sets the value of the internationalStreet property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setInternationalStreet(final String value) {
    this.internationalStreet = value;
  }

  /**
   * Sets the value of the number property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setNumber(final String value) {
    this.number = value;
  }

  /**
   * Sets the value of the phone property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPhone(final String value) {
    this.phone = value;
  }

  /**
   * Sets the value of the postalCode property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPostalCode(final String value) {
    this.postalCode = value;
  }

  /**
   * Sets the value of the stateOrProvince property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setStateOrProvince(final String value) {
    this.stateOrProvince = value;
  }

  /**
   * Sets the value of the street1 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setStreet1(final String value) {
    this.street1 = value;
  }

  /**
   * Sets the value of the street2 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setStreet2(final String value) {
    this.street2 = value;
  }

}
