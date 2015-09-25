
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for permission complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="permission"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="group" type="{http://gnuob.netbrasoft.com/}rule"/&gt;
 *         &lt;element name="others" type="{http://gnuob.netbrasoft.com/}rule"/&gt;
 *         &lt;element name="owner" type="{http://gnuob.netbrasoft.com/}rule"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permission", propOrder = { "group", "others", "owner" })
public class Permission extends Type implements Serializable {

   private static final long serialVersionUID = -4261671704221459886L;
   @XmlElement(required = true)
   @XmlSchemaType(name = "string")
   protected Rule group;
   @XmlElement(required = true)
   @XmlSchemaType(name = "string")
   protected Rule others;
   @XmlElement(required = true)
   @XmlSchemaType(name = "string")
   protected Rule owner;

   /**
    * Gets the value of the group property.
    * 
    * @return possible object is {@link Rule }
    * 
    */
   public Rule getGroup() {
      return group;
   }

   /**
    * Sets the value of the group property.
    * 
    * @param value
    *           allowed object is {@link Rule }
    * 
    */
   public void setGroup(Rule value) {
      this.group = value;
   }

   /**
    * Gets the value of the others property.
    * 
    * @return possible object is {@link Rule }
    * 
    */
   public Rule getOthers() {
      return others;
   }

   /**
    * Sets the value of the others property.
    * 
    * @param value
    *           allowed object is {@link Rule }
    * 
    */
   public void setOthers(Rule value) {
      this.others = value;
   }

   /**
    * Gets the value of the owner property.
    * 
    * @return possible object is {@link Rule }
    * 
    */
   public Rule getOwner() {
      return owner;
   }

   /**
    * Sets the value of the owner property.
    * 
    * @param value
    *           allowed object is {@link Rule }
    * 
    */
   public void setOwner(Rule value) {
      this.owner = value;
   }

}
