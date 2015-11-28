
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for findGroupByIdResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="findGroupByIdResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://gnuob.netbrasoft.com/}group" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findGroupByIdResponse", propOrder = {"_return"})
public class FindGroupByIdResponse implements Serializable {

  private static final long serialVersionUID = 4677446218396128190L;
  @XmlElement(name = "return")
  protected Group _return;

  /**
   * Gets the value of the return property.
   * 
   * @return possible object is {@link Group }
   * 
   */
  public Group getReturn() {
    return _return;
  }

  /**
   * Sets the value of the return property.
   * 
   * @param value allowed object is {@link Group }
   * 
   */
  public void setReturn(final Group value) {
    this._return = value;
  }

}
