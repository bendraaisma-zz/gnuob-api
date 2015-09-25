
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for persistGroup complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="persistGroup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="group" type="{http://gnuob.netbrasoft.com/}group" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persistGroup", propOrder = { "group" })
public class PersistGroup implements Serializable {

   private static final long serialVersionUID = 1778740985635548691L;
   protected Group group;

   /**
    * Gets the value of the group property.
    * 
    * @return possible object is {@link Group }
    * 
    */
   public Group getGroup() {
      return group;
   }

   /**
    * Sets the value of the group property.
    * 
    * @param value
    *           allowed object is {@link Group }
    * 
    */
   public void setGroup(Group value) {
      this.group = value;
   }

}
