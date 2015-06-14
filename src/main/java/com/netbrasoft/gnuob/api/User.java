
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for user complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="user"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="access" type="{http://gnuob.netbrasoft.com/}rule" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="groups" type="{http://gnuob.netbrasoft.com/}group" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sites" type="{http://gnuob.netbrasoft.com/}site" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = { "access", "description", "groups", "name", "password", "role", "sites" })
public class User extends Access implements Serializable {

   @XmlSchemaType(name = "string")
   protected Rule access;
   protected String description;
   @XmlElement(nillable = true)
   protected List<Group> groups;
   @XmlElement(required = true)
   protected String name;
   @XmlElement(required = true)
   protected String password;
   @XmlElement(required = true)
   protected String role;
   @XmlElement(nillable = true)
   protected List<Site> sites;

   /**
    * Gets the value of the access property.
    * 
    * @return possible object is {@link Rule }
    * 
    */
   public Rule getAccess() {
      return access;
   }

   /**
    * Sets the value of the access property.
    * 
    * @param value
    *           allowed object is {@link Rule }
    * 
    */
   public void setAccess(Rule value) {
      this.access = value;
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
    * Gets the value of the groups property.
    * 
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot.
    * Therefore any modification you make to the returned list will be present
    * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
    * for the groups property.
    * 
    * <p>
    * For example, to add a new item, do as follows:
    * 
    * <pre>
    * getGroups().add(newItem);
    * </pre>
    * 
    * 
    * <p>
    * Objects of the following type(s) are allowed in the list {@link Group }
    * 
    * 
    */
   public List<Group> getGroups() {
      if (groups == null) {
         groups = new ArrayList<Group>();
      }
      return this.groups;
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
    * Gets the value of the password property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getPassword() {
      return password;
   }

   /**
    * Sets the value of the password property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setPassword(String value) {
      this.password = value;
   }

   /**
    * Gets the value of the role property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getRole() {
      return role;
   }

   /**
    * Sets the value of the role property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setRole(String value) {
      this.role = value;
   }

   /**
    * Gets the value of the sites property.
    * 
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot.
    * Therefore any modification you make to the returned list will be present
    * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
    * for the sites property.
    * 
    * <p>
    * For example, to add a new item, do as follows:
    * 
    * <pre>
    * getSites().add(newItem);
    * </pre>
    * 
    * 
    * <p>
    * Objects of the following type(s) are allowed in the list {@link Site }
    * 
    * 
    */
   public List<Site> getSites() {
      if (sites == null) {
         sites = new ArrayList<Site>();
      }
      return this.sites;
   }

}
