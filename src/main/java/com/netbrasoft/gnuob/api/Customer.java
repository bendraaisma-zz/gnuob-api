
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for customer complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="customer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="address" type="{http://gnuob.netbrasoft.com/}address"/&gt;
 *         &lt;element name="buyerEmail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="buyerMarketingEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="friendlyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="middleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payerBusiness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payerStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="salutation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxIdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = { "address", "buyerEmail", "buyerMarketingEmail", "contactPhone", "dateOfBirth", "firstName", "friendlyName", "lastName", "middleName", "payer", "payerBusiness", "payerId", "payerStatus", "salutation", "suffix",
      "taxId", "taxIdType" })
public class Customer extends Access implements Serializable {

   private static final long serialVersionUID = -6386912469945326531L;
   @XmlElement(required = true)
   protected Address address;
   @XmlElement(required = true)
   protected String buyerEmail;
   protected String buyerMarketingEmail;
   protected String contactPhone;
   @XmlElement(required = true)
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar dateOfBirth;
   @XmlElement(required = true)
   protected String firstName;
   protected String friendlyName;
   @XmlElement(required = true)
   protected String lastName;
   protected String middleName;
   protected String payer;
   protected String payerBusiness;
   protected String payerId;
   protected String payerStatus;
   protected String salutation;
   protected String suffix;
   protected String taxId;
   protected String taxIdType;

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
    * Gets the value of the buyerEmail property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getBuyerEmail() {
      return buyerEmail;
   }

   /**
    * Sets the value of the buyerEmail property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setBuyerEmail(String value) {
      this.buyerEmail = value;
   }

   /**
    * Gets the value of the buyerMarketingEmail property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getBuyerMarketingEmail() {
      return buyerMarketingEmail;
   }

   /**
    * Sets the value of the buyerMarketingEmail property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setBuyerMarketingEmail(String value) {
      this.buyerMarketingEmail = value;
   }

   /**
    * Gets the value of the contactPhone property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getContactPhone() {
      return contactPhone;
   }

   /**
    * Sets the value of the contactPhone property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setContactPhone(String value) {
      this.contactPhone = value;
   }

   /**
    * Gets the value of the dateOfBirth property.
    * 
    * @return possible object is {@link XMLGregorianCalendar }
    * 
    */
   public XMLGregorianCalendar getDateOfBirth() {
      return dateOfBirth;
   }

   /**
    * Sets the value of the dateOfBirth property.
    * 
    * @param value
    *           allowed object is {@link XMLGregorianCalendar }
    * 
    */
   public void setDateOfBirth(XMLGregorianCalendar value) {
      this.dateOfBirth = value;
   }

   /**
    * Gets the value of the firstName property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * Sets the value of the firstName property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setFirstName(String value) {
      this.firstName = value;
   }

   /**
    * Gets the value of the friendlyName property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getFriendlyName() {
      return friendlyName;
   }

   /**
    * Sets the value of the friendlyName property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setFriendlyName(String value) {
      this.friendlyName = value;
   }

   /**
    * Gets the value of the lastName property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * Sets the value of the lastName property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setLastName(String value) {
      this.lastName = value;
   }

   /**
    * Gets the value of the middleName property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getMiddleName() {
      return middleName;
   }

   /**
    * Sets the value of the middleName property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setMiddleName(String value) {
      this.middleName = value;
   }

   /**
    * Gets the value of the payer property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getPayer() {
      return payer;
   }

   /**
    * Sets the value of the payer property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setPayer(String value) {
      this.payer = value;
   }

   /**
    * Gets the value of the payerBusiness property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getPayerBusiness() {
      return payerBusiness;
   }

   /**
    * Sets the value of the payerBusiness property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setPayerBusiness(String value) {
      this.payerBusiness = value;
   }

   /**
    * Gets the value of the payerId property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getPayerId() {
      return payerId;
   }

   /**
    * Sets the value of the payerId property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setPayerId(String value) {
      this.payerId = value;
   }

   /**
    * Gets the value of the payerStatus property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getPayerStatus() {
      return payerStatus;
   }

   /**
    * Sets the value of the payerStatus property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setPayerStatus(String value) {
      this.payerStatus = value;
   }

   /**
    * Gets the value of the salutation property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getSalutation() {
      return salutation;
   }

   /**
    * Sets the value of the salutation property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setSalutation(String value) {
      this.salutation = value;
   }

   /**
    * Gets the value of the suffix property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getSuffix() {
      return suffix;
   }

   /**
    * Sets the value of the suffix property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setSuffix(String value) {
      this.suffix = value;
   }

   /**
    * Gets the value of the taxId property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getTaxId() {
      return taxId;
   }

   /**
    * Sets the value of the taxId property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setTaxId(String value) {
      this.taxId = value;
   }

   /**
    * Gets the value of the taxIdType property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getTaxIdType() {
      return taxIdType;
   }

   /**
    * Sets the value of the taxIdType property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setTaxIdType(String value) {
      this.taxIdType = value;
   }

}
