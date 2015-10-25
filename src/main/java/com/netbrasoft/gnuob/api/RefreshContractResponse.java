
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for refreshContractResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="refreshContractResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://gnuob.netbrasoft.com/}contract" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refreshContractResponse", propOrder = {"_return"})
public class RefreshContractResponse implements Serializable {

  private static final long serialVersionUID = 5556935188634293221L;
  @XmlElement(name = "return")
  protected Contract _return;

  /**
   * Gets the value of the return property.
   * 
   * @return possible object is {@link Contract }
   * 
   */
  public Contract getReturn() {
    return _return;
  }

  /**
   * Sets the value of the return property.
   * 
   * @param value allowed object is {@link Contract }
   * 
   */
  public void setReturn(Contract value) {
    this._return = value;
  }

}
