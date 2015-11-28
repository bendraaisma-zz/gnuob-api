
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for abstractAccess complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="abstractAccess"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}abstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="permission" type="{http://gnuob.netbrasoft.com/}permission" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abstractAccess", propOrder = {"active", "permission"})
@XmlSeeAlso({Content.class})
public abstract class AbstractAccess extends AbstractType implements Serializable {

  private static final long serialVersionUID = 5192655864396740341L;
  @XmlElement(defaultValue = "true")
  protected boolean active;
  protected Permission permission;

  /**
   * Gets the value of the permission property.
   * 
   * @return possible object is {@link Permission }
   * 
   */
  public Permission getPermission() {
    return permission;
  }

  /**
   * Gets the value of the active property.
   * 
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets the value of the active property.
   * 
   */
  public void setActive(final boolean value) {
    this.active = value;
  }

  /**
   * Sets the value of the permission property.
   * 
   * @param value allowed object is {@link Permission }
   * 
   */
  public void setPermission(final Permission value) {
    this.permission = value;
  }

}
