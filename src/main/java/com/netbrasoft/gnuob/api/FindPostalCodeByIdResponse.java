
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for findPostalCodeByIdResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="findPostalCodeByIdResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://gnuob.netbrasoft.com/}postalCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findPostalCodeByIdResponse", propOrder = {"_return"})
public class FindPostalCodeByIdResponse implements Serializable {

  private static final long serialVersionUID = 4774630473119025611L;
  @XmlElement(name = "return")
  protected PostalCode _return;

  /**
   * Gets the value of the return property.
   * 
   * @return possible object is {@link PostalCode }
   * 
   */
  public PostalCode getReturn() {
    return _return;
  }

  /**
   * Sets the value of the return property.
   * 
   * @param value allowed object is {@link PostalCode }
   * 
   */
  public void setReturn(final PostalCode value) {
    this._return = value;
  }

}