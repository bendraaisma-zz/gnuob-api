
package com.netbrasoft.gnuob.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for removeCustomer complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="removeCustomer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="customer" type="{http://gnuob.netbrasoft.com/}customer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeCustomer", propOrder = { "customer" })
public class RemoveCustomer {

   protected Customer customer;

   /**
    * Gets the value of the customer property.
    * 
    * @return possible object is {@link Customer }
    * 
    */
   public Customer getCustomer() {
      return customer;
   }

   /**
    * Sets the value of the customer property.
    * 
    * @param value
    *           allowed object is {@link Customer }
    * 
    */
   public void setCustomer(Customer value) {
      this.customer = value;
   }

}
