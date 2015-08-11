
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for shipment complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="shipment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="address" type="{http://gnuob.netbrasoft.com/}address"/&gt;
 *         &lt;element name="shipmentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipment", propOrder = { "address", "shipmentType" })
public class Shipment extends Type implements Serializable {

   @XmlElement(required = true)
   protected Address address;
   protected String shipmentType;

   /**
    * Gets the value of the address property.
    * 
    * @return possible object is {@link Address }
    * 
    */
   public Address getAddress() {
      return address;
   }

   /**
    * Sets the value of the address property.
    * 
    * @param value
    *           allowed object is {@link Address }
    * 
    */
   public void setAddress(Address value) {
      this.address = value;
   }

   /**
    * Gets the value of the shipmentType property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getShipmentType() {
      return shipmentType;
   }

   /**
    * Sets the value of the shipmentType property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setShipmentType(String value) {
      this.shipmentType = value;
   }

}
