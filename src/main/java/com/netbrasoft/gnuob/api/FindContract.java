
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for findContract complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="findContract"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contract" type="{http://gnuob.netbrasoft.com/}contract" minOccurs="0"/&gt;
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
@XmlType(name = "findContract", propOrder = {"contract", "paging", "orderBy"})
public class FindContract implements Serializable {

  private static final long serialVersionUID = 3052083502150748371L;
  protected Contract contract;
  protected Paging paging;
  @XmlSchemaType(name = "string")
  protected OrderBy orderBy;

  /**
   * Gets the value of the contract property.
   * 
   * @return possible object is {@link Contract }
   * 
   */
  public Contract getContract() {
    return contract;
  }

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
   * Sets the value of the contract property.
   * 
   * @param value allowed object is {@link Contract }
   * 
   */
  public void setContract(final Contract value) {
    this.contract = value;
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

}
