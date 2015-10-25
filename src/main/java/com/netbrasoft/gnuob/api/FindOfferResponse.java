
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for findOfferResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findOfferResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://gnuob.netbrasoft.com/}offer" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findOfferResponse", propOrder = {"_return"})
public class FindOfferResponse implements Serializable {

  private static final long serialVersionUID = 6496627361637763300L;
  @XmlElement(name = "return")
  protected List<Offer> _return;

  /**
   * Gets the value of the return property.
   * 
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the return property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getReturn().add(newItem);
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list {@link Offer }
   * 
   * 
   */
  public List<Offer> getReturn() {
    if (_return == null) {
      _return = new ArrayList<Offer>();
    }
    return this._return;
  }

}
