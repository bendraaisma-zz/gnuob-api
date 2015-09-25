
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
 * Java class for category complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="category"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contents" type="{http://gnuob.netbrasoft.com/}content" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="subCategories" type="{http://gnuob.netbrasoft.com/}subCategory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category", propOrder = { "contents", "description", "name", "position", "subCategories" })
public class Category extends Access implements Serializable {

   private static final long serialVersionUID = -2820813057083809036L;
   @XmlElement(nillable = true)
   protected List<Content> contents;
   protected String description;
   @XmlElement(required = true)
   protected String name;
   protected Integer position;
   @XmlElement(nillable = true)
   protected List<SubCategory> subCategories;

   /**
    * Gets the value of the contents property.
    * 
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot.
    * Therefore any modification you make to the returned list will be present
    * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
    * for the contents property.
    * 
    * <p>
    * For example, to add a new item, do as follows:
    * 
    * <pre>
    * getContents().add(newItem);
    * </pre>
    * 
    * 
    * <p>
    * Objects of the following type(s) are allowed in the list {@link Content }
    * 
    * 
    */
   public List<Content> getContents() {
      if (contents == null) {
         contents = new ArrayList<Content>();
      }
      return this.contents;
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

   /**
    * Gets the value of the name property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getName() {
      return name;
   }

   /**
    * Sets the value of the name property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setName(String value) {
      this.name = value;
   }

   /**
    * Gets the value of the position property.
    * 
    * @return possible object is {@link Integer }
    * 
    */
   public Integer getPosition() {
      return position;
   }

   /**
    * Sets the value of the position property.
    * 
    * @param value
    *           allowed object is {@link Integer }
    * 
    */
   public void setPosition(Integer value) {
      this.position = value;
   }

   /**
    * Gets the value of the subCategories property.
    * 
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot.
    * Therefore any modification you make to the returned list will be present
    * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
    * for the subCategories property.
    * 
    * <p>
    * For example, to add a new item, do as follows:
    * 
    * <pre>
    * getSubCategories().add(newItem);
    * </pre>
    * 
    * 
    * <p>
    * Objects of the following type(s) are allowed in the list
    * {@link SubCategory }
    * 
    * 
    */
   public List<SubCategory> getSubCategories() {
      if (subCategories == null) {
         subCategories = new ArrayList<SubCategory>();
      }
      return this.subCategories;
   }

}
