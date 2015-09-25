
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for findCategoryByIdResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="findCategoryByIdResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://gnuob.netbrasoft.com/}category" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findCategoryByIdResponse", propOrder = { "_return" })
public class FindCategoryByIdResponse implements Serializable {

   private static final long serialVersionUID = 5091356672370905344L;
   @XmlElement(name = "return")
   protected Category _return;

   /**
    * Gets the value of the return property.
    * 
    * @return possible object is {@link Category }
    * 
    */
   public Category getReturn() {
      return _return;
   }

   /**
    * Sets the value of the return property.
    * 
    * @param value
    *           allowed object is {@link Category }
    * 
    */
   public void setReturn(Category value) {
      this._return = value;
   }

}
