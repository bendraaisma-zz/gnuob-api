
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for mergeUser complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="mergeUser"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user" type="{http://gnuob.netbrasoft.com/}user" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mergeUser", propOrder = {"user"})
public class MergeUser implements Serializable {

  private static final long serialVersionUID = 2507283055549974770L;
  protected User user;

  /**
   * Gets the value of the user property.
   * 
   * @return possible object is {@link User }
   * 
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets the value of the user property.
   * 
   * @param value allowed object is {@link User }
   * 
   */
  public void setUser(final User value) {
    this.user = value;
  }

}
