
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for removeProduct complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="removeProduct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="product" type="{http://gnuob.netbrasoft.com/}product" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeProduct", propOrder = {"product"})
public class RemoveProduct implements Serializable {

  private static final long serialVersionUID = -2733938979578882743L;
  protected Product product;

  /**
   * Gets the value of the product property.
   * 
   * @return possible object is {@link Product }
   * 
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Sets the value of the product property.
   * 
   * @param value allowed object is {@link Product }
   * 
   */
  public void setProduct(final Product value) {
    this.product = value;
  }

}
