
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for option complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="option"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="disabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "option", propOrder = { "description", "disabled", "value" })
public class Option extends Type implements Serializable {

   protected String description;
   protected boolean disabled;
   @XmlElement(required = true)
   protected String value;

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

   /**
    * Gets the value of the disabled property.
    * 
    */
   public boolean isDisabled() {
      return disabled;
   }

   /**
    * Sets the value of the disabled property.
    * 
    */
   public void setDisabled(boolean value) {
      this.disabled = value;
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

}
