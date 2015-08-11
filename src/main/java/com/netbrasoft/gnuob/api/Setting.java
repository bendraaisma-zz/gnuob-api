
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Setting complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Setting"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="property" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Setting", propOrder = { "property", "value", "description" })
public class Setting extends Access implements Serializable {

   @XmlElement(required = true)
   protected String property;
   @XmlElement(required = true)
   protected String value;
   protected String description;

   /**
    * Gets the value of the property property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getProperty() {
      return property;
   }

   /**
    * Sets the value of the property property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setProperty(String value) {
      this.property = value;
   }

   /**
    * Gets the value of the value property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getValue() {
      return value;
   }

   /**
    * Sets the value of the value property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setValue(String value) {
      this.value = value;
   }

   /**
    * Gets the value of the description property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getDescription() {
      return description;
   }

   /**
    * Sets the value of the description property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setDescription(String value) {
      this.description = value;
   }

}
