
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for findPostalCode complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="findPostalCode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="postalCode" type="{http://gnuob.netbrasoft.com/}postalCode" minOccurs="0"/&gt;
 *         &lt;element name="paging" type="{http://gnuob.netbrasoft.com/}paging" minOccurs="0"/&gt;
 *         &lt;element name="orderBy" type="{http://gnuob.netbrasoft.com/}orderBy" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findPostalCode", propOrder = {"postalCode", "paging", "orderBy"})
public class FindPostalCode implements Serializable {

  private static final long serialVersionUID = 297888118848426715L;
  protected PostalCode postalCode;
  protected Paging paging;
  @XmlSchemaType(name = "string")
  protected OrderBy orderBy;

  /**
   * Gets the value of the orderBy property.
   * 
   * @return possible object is {@link OrderBy }
   * 
   */
  public OrderBy getOrderBy() {
    return orderBy;
  }

  /**
   * Gets the value of the paging property.
   * 
   * @return possible object is {@link Paging }
   * 
   */
  public Paging getPaging() {
    return paging;
  }

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
   * Sets the value of the orderBy property.
   * 
   * @param value allowed object is {@link OrderBy }
   * 
   */
  public void setOrderBy(final OrderBy value) {
    this.orderBy = value;
  }

  /**
   * Sets the value of the paging property.
   * 
   * @param value allowed object is {@link Paging }
   * 
   */
  public void setPaging(final Paging value) {
    this.paging = value;
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
