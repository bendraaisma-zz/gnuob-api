
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for mergeSite complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="mergeSite"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="site" type="{http://gnuob.netbrasoft.com/}site" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mergeSite", propOrder = { "site" })
public class MergeSite implements Serializable {

   protected Site site;

   /**
    * Gets the value of the site property.
    * 
    * @return possible object is {@link Site }
    * 
    */
   public Site getSite() {
      return site;
   }

   /**
    * Sets the value of the site property.
    * 
    * @param value
    *           allowed object is {@link Site }
    * 
    */
   public void setSite(Site value) {
      this.site = value;
   }

}
