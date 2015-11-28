
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for abstractType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="abstractType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abstractType")
@XmlSeeAlso({PostalCode.class})
public abstract class AbstractType implements Serializable {

  private static final long serialVersionUID = -4033595339462106336L;
  @XmlAttribute(name = "id", required = true)
  protected long id;
  @XmlAttribute(name = "version", required = true)
  protected int version;

  /**
   * Gets the value of the id property.
   * 
   */
  public long getId() {
    return id;
  }

  /**
   * Gets the value of the version property.
   * 
   */
  public int getVersion() {
    return version;
  }

  /**
   * Sets the value of the id property.
   * 
   */
  public void setId(final long value) {
    this.id = value;
  }

  /**
   * Sets the value of the version property.
   * 
   */
  public void setVersion(final int value) {
    this.version = value;
  }

}
