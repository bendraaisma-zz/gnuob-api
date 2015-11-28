
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for postalCode complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="postalCode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}abstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accuracy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminCode1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adminCode2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminCode3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminName1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adminName2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminName3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="placeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postalCode",
    propOrder = {"accuracy", "adminCode1", "adminCode2", "adminCode3", "adminName1", "adminName2", "adminName3", "countryCode", "latitude", "longitude", "placeName", "postalCode"})
public class PostalCode extends AbstractType implements Serializable {

  private static final long serialVersionUID = 2735630121060518112L;
  protected String accuracy;
  @XmlElement(required = true)
  protected String adminCode1;
  protected String adminCode2;
  protected String adminCode3;
  @XmlElement(required = true)
  protected String adminName1;
  protected String adminName2;
  protected String adminName3;
  @XmlElement(required = true)
  protected String countryCode;
  @XmlElement(required = true)
  protected BigDecimal latitude;
  @XmlElement(required = true)
  protected BigDecimal longitude;
  @XmlElement(required = true)
  protected String placeName;
  @XmlElement(required = true)
  protected String postalCode;

  /**
   * Gets the value of the accuracy property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAccuracy() {
    return accuracy;
  }

  /**
   * Gets the value of the adminCode1 property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAdminCode1() {
    return adminCode1;
  }

  /**
   * Gets the value of the adminCode2 property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAdminCode2() {
    return adminCode2;
  }

  /**
   * Gets the value of the adminCode3 property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAdminCode3() {
    return adminCode3;
  }

  /**
   * Gets the value of the adminName1 property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAdminName1() {
    return adminName1;
  }

  /**
   * Gets the value of the adminName2 property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAdminName2() {
    return adminName2;
  }

  /**
   * Gets the value of the adminName3 property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAdminName3() {
    return adminName3;
  }

  /**
   * Gets the value of the countryCode property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * Gets the value of the latitude property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getLatitude() {
    return latitude;
  }

  /**
   * Gets the value of the longitude property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getLongitude() {
    return longitude;
  }

  /**
   * Gets the value of the placeName property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getPlaceName() {
    return placeName;
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
   * Sets the value of the accuracy property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setAccuracy(final String value) {
    this.accuracy = value;
  }

  /**
   * Sets the value of the adminCode1 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setAdminCode1(final String value) {
    this.adminCode1 = value;
  }

  /**
   * Sets the value of the adminCode2 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setAdminCode2(final String value) {
    this.adminCode2 = value;
  }

  /**
   * Sets the value of the adminCode3 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setAdminCode3(final String value) {
    this.adminCode3 = value;
  }

  /**
   * Sets the value of the adminName1 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setAdminName1(final String value) {
    this.adminName1 = value;
  }

  /**
   * Sets the value of the adminName2 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setAdminName2(final String value) {
    this.adminName2 = value;
  }

  /**
   * Sets the value of the adminName3 property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setAdminName3(final String value) {
    this.adminName3 = value;
  }

  /**
   * Sets the value of the countryCode property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCountryCode(final String value) {
    this.countryCode = value;
  }

  /**
   * Sets the value of the latitude property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setLatitude(final BigDecimal value) {
    this.latitude = value;
  }

  /**
   * Sets the value of the longitude property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setLongitude(final BigDecimal value) {
    this.longitude = value;
  }

  /**
   * Sets the value of the placeName property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPlaceName(final String value) {
    this.placeName = value;
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

}
