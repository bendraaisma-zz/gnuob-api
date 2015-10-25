
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for countOrder complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="countOrder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="order" type="{http://gnuob.netbrasoft.com/}order" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countOrder", propOrder = {"order"})
public class CountOrder implements Serializable {

  private static final long serialVersionUID = -7962790981310848472L;
  protected Order order;

  /**
   * Gets the value of the order property.
   * 
   * @return possible object is {@link Order }
   * 
   */
  public Order getOrder() {
    return order;
  }

  /**
   * Sets the value of the order property.
   * 
   * @param value allowed object is {@link Order }
   * 
   */
  public void setOrder(Order value) {
    this.order = value;
  }

}
