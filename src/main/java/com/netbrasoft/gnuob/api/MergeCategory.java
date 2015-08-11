
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for mergeCategory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="mergeCategory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="category" type="{http://gnuob.netbrasoft.com/}category" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mergeCategory", propOrder = { "category" })
public class MergeCategory implements Serializable {

   protected Category category;

   /**
    * Gets the value of the category property.
    * 
    * @return possible object is {@link Category }
    * 
    */
   public Category getCategory() {
      return category;
   }

   /**
    * Sets the value of the category property.
    * 
    * @param value
    *           allowed object is {@link Category }
    * 
    */
   public void setCategory(Category value) {
      this.category = value;
   }

}
