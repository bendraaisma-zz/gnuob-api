
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for persistPostalCode complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="persistPostalCode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="postalCode" type="{http://gnuob.netbrasoft.com/}postalCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persistPostalCode", propOrder = {"postalCode"})
public class PersistPostalCode implements Serializable {

  private static final long serialVersionUID = 4789359704539949422L;
  protected PostalCode postalCode;

  /**
   * Gets the value of the postalCode property.
   * 
   * @return possible object is {@link PostalCode }
   * 
   */
  public PostalCode getPostalCode() {
    return postalCode;
  }

  /**
   * Sets the value of the postalCode property.
   * 
   * @param value allowed object is {@link PostalCode }
   * 
   */
  public void setPostalCode(final PostalCode value) {
    this.postalCode = value;
  }

}
