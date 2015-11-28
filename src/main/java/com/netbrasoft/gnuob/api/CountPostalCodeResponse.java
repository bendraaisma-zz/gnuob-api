
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for countPostalCodeResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="countPostalCodeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countPostalCodeResponse", propOrder = {"_return"})
public class CountPostalCodeResponse implements Serializable {

  private static final long serialVersionUID = 9191767955448527221L;
  @XmlElement(name = "return")
  protected long _return;

  /**
   * Gets the value of the return property.
   * 
   */
  public long getReturn() {
    return _return;
  }

  /**
   * Sets the value of the return property.
   * 
   */
  public void setReturn(final long value) {
    this._return = value;
  }

}