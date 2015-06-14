
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for order complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="order"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="checkoutStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contract" type="{http://gnuob.netbrasoft.com/}contract"/&gt;
 *         &lt;element name="custom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="discountTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="extraAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="giftMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="giftMessageEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="giftReceiptEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="giftWrapAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="giftWrapEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="giftWrapName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="handlingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="insuranceOptionOffered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="insuranceTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="invoice" type="{http://gnuob.netbrasoft.com/}invoice"/&gt;
 *         &lt;element name="itemTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="maxTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="orderTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="records" type="{http://gnuob.netbrasoft.com/}orderRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="shipment" type="{http://gnuob.netbrasoft.com/}shipment" minOccurs="0"/&gt;
 *         &lt;element name="shippingDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="shippingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="taxTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = { "billingAgreementId", "checkoutStatus", "contract", "custom", "discountTotal", "extraAmount", "giftMessage", "giftMessageEnable", "giftReceiptEnable", "giftWrapAmount", "giftWrapEnable", "giftWrapName",
      "handlingTotal", "insuranceOptionOffered", "insuranceTotal", "invoice", "itemTotal", "maxTotal", "note", "noteText", "orderDescription", "orderId", "orderTotal", "records", "shipment", "shippingDiscount", "shippingTotal", "taxTotal", "token",
      "transactionId" })
public class Order extends Access implements Serializable {

   protected String billingAgreementId;
   protected String checkoutStatus;
   @XmlElement(required = true)
   protected Contract contract;
   protected String custom;
   protected BigDecimal discountTotal;
   @XmlElement(required = true)
   protected BigDecimal extraAmount;
   protected String giftMessage;
   protected Boolean giftMessageEnable;
   protected Boolean giftReceiptEnable;
   protected BigDecimal giftWrapAmount;
   protected Boolean giftWrapEnable;
   protected String giftWrapName;
   @XmlElement(required = true)
   protected BigDecimal handlingTotal;
   protected Boolean insuranceOptionOffered;
   @XmlElement(required = true)
   protected BigDecimal insuranceTotal;
   @XmlElement(required = true)
   protected Invoice invoice;
   protected BigDecimal itemTotal;
   protected BigDecimal maxTotal;
   protected String note;
   protected String noteText;
   protected String orderDescription;
   @XmlElement(required = true)
   protected String orderId;
   protected BigDecimal orderTotal;
   @XmlElement(nillable = true)
   protected List<OrderRecord> records;
   protected Shipment shipment;
   @XmlElement(required = true)
   protected BigDecimal shippingDiscount;
   protected BigDecimal shippingTotal;
   protected BigDecimal taxTotal;
   protected String token;
   protected String transactionId;

   /**
    * Gets the value of the billingAgreementId property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getBillingAgreementId() {
      return billingAgreementId;
   }

   /**
    * Gets the value of the checkoutStatus property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getCheckoutStatus() {
      return checkoutStatus;
   }

   /**
    * Gets the value of the contract property.
    * 
    * @return possible object is {@link Contract }
    * 
    */
   public Contract getContract() {
      return contract;
   }

   /**
    * Gets the value of the custom property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getCustom() {
      return custom;
   }

   /**
    * Gets the value of the discountTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getDiscountTotal() {
      return discountTotal;
   }

   /**
    * Gets the value of the extraAmount property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getExtraAmount() {
      return extraAmount;
   }

   /**
    * Gets the value of the giftMessage property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getGiftMessage() {
      return giftMessage;
   }

   /**
    * Gets the value of the giftWrapAmount property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getGiftWrapAmount() {
      return giftWrapAmount;
   }

   /**
    * Gets the value of the giftWrapName property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getGiftWrapName() {
      return giftWrapName;
   }

   /**
    * Gets the value of the handlingTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getHandlingTotal() {
      return handlingTotal;
   }

   /**
    * Gets the value of the insuranceTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getInsuranceTotal() {
      return insuranceTotal;
   }

   /**
    * Gets the value of the invoice property.
    * 
    * @return possible object is {@link Invoice }
    * 
    */
   public Invoice getInvoice() {
      return invoice;
   }

   /**
    * Gets the value of the itemTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getItemTotal() {
      return itemTotal;
   }

   /**
    * Gets the value of the maxTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getMaxTotal() {
      return maxTotal;
   }

   /**
    * Gets the value of the note property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getNote() {
      return note;
   }

   /**
    * Gets the value of the noteText property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getNoteText() {
      return noteText;
   }

   /**
    * Gets the value of the orderDescription property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getOrderDescription() {
      return orderDescription;
   }

   /**
    * Gets the value of the orderId property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getOrderId() {
      return orderId;
   }

   /**
    * Gets the value of the orderTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getOrderTotal() {
      return orderTotal;
   }

   /**
    * Gets the value of the records property.
    * 
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot.
    * Therefore any modification you make to the returned list will be present
    * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
    * for the records property.
    * 
    * <p>
    * For example, to add a new item, do as follows:
    * 
    * <pre>
    * getRecords().add(newItem);
    * </pre>
    * 
    * 
    * <p>
    * Objects of the following type(s) are allowed in the list
    * {@link OrderRecord }
    * 
    * 
    */
   public List<OrderRecord> getRecords() {
      if (records == null) {
         records = new ArrayList<OrderRecord>();
      }
      return this.records;
   }

   /**
    * Gets the value of the shipment property.
    * 
    * @return possible object is {@link Shipment }
    * 
    */
   public Shipment getShipment() {
      return shipment;
   }

   /**
    * Gets the value of the shippingDiscount property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getShippingDiscount() {
      return shippingDiscount;
   }

   /**
    * Gets the value of the shippingTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getShippingTotal() {
      return shippingTotal;
   }

   /**
    * Gets the value of the taxTotal property.
    * 
    * @return possible object is {@link BigDecimal }
    * 
    */
   public BigDecimal getTaxTotal() {
      return taxTotal;
   }

   /**
    * Gets the value of the token property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getToken() {
      return token;
   }

   /**
    * Gets the value of the transactionId property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getTransactionId() {
      return transactionId;
   }

   /**
    * Gets the value of the giftMessageEnable property.
    * 
    * @return possible object is {@link Boolean }
    * 
    */
   public Boolean isGiftMessageEnable() {
      return giftMessageEnable;
   }

   /**
    * Gets the value of the giftReceiptEnable property.
    * 
    * @return possible object is {@link Boolean }
    * 
    */
   public Boolean isGiftReceiptEnable() {
      return giftReceiptEnable;
   }

   /**
    * Gets the value of the giftWrapEnable property.
    * 
    * @return possible object is {@link Boolean }
    * 
    */
   public Boolean isGiftWrapEnable() {
      return giftWrapEnable;
   }

   /**
    * Gets the value of the insuranceOptionOffered property.
    * 
    * @return possible object is {@link Boolean }
    * 
    */
   public Boolean isInsuranceOptionOffered() {
      return insuranceOptionOffered;
   }

   /**
    * Sets the value of the billingAgreementId property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setBillingAgreementId(String value) {
      this.billingAgreementId = value;
   }

   /**
    * Sets the value of the checkoutStatus property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setCheckoutStatus(String value) {
      this.checkoutStatus = value;
   }

   /**
    * Sets the value of the contract property.
    * 
    * @param value
    *           allowed object is {@link Contract }
    * 
    */
   public void setContract(Contract value) {
      this.contract = value;
   }

   /**
    * Sets the value of the custom property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setCustom(String value) {
      this.custom = value;
   }

   /**
    * Sets the value of the discountTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setDiscountTotal(BigDecimal value) {
      this.discountTotal = value;
   }

   /**
    * Sets the value of the extraAmount property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setExtraAmount(BigDecimal value) {
      this.extraAmount = value;
   }

   /**
    * Sets the value of the giftMessage property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setGiftMessage(String value) {
      this.giftMessage = value;
   }

   /**
    * Sets the value of the giftMessageEnable property.
    * 
    * @param value
    *           allowed object is {@link Boolean }
    * 
    */
   public void setGiftMessageEnable(Boolean value) {
      this.giftMessageEnable = value;
   }

   /**
    * Sets the value of the giftReceiptEnable property.
    * 
    * @param value
    *           allowed object is {@link Boolean }
    * 
    */
   public void setGiftReceiptEnable(Boolean value) {
      this.giftReceiptEnable = value;
   }

   /**
    * Sets the value of the giftWrapAmount property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setGiftWrapAmount(BigDecimal value) {
      this.giftWrapAmount = value;
   }

   /**
    * Sets the value of the giftWrapEnable property.
    * 
    * @param value
    *           allowed object is {@link Boolean }
    * 
    */
   public void setGiftWrapEnable(Boolean value) {
      this.giftWrapEnable = value;
   }

   /**
    * Sets the value of the giftWrapName property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setGiftWrapName(String value) {
      this.giftWrapName = value;
   }

   /**
    * Sets the value of the handlingTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setHandlingTotal(BigDecimal value) {
      this.handlingTotal = value;
   }

   /**
    * Sets the value of the insuranceOptionOffered property.
    * 
    * @param value
    *           allowed object is {@link Boolean }
    * 
    */
   public void setInsuranceOptionOffered(Boolean value) {
      this.insuranceOptionOffered = value;
   }

   /**
    * Sets the value of the insuranceTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setInsuranceTotal(BigDecimal value) {
      this.insuranceTotal = value;
   }

   /**
    * Sets the value of the invoice property.
    * 
    * @param value
    *           allowed object is {@link Invoice }
    * 
    */
   public void setInvoice(Invoice value) {
      this.invoice = value;
   }

   /**
    * Sets the value of the itemTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setItemTotal(BigDecimal value) {
      this.itemTotal = value;
   }

   /**
    * Sets the value of the maxTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setMaxTotal(BigDecimal value) {
      this.maxTotal = value;
   }

   /**
    * Sets the value of the note property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setNote(String value) {
      this.note = value;
   }

   /**
    * Sets the value of the noteText property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setNoteText(String value) {
      this.noteText = value;
   }

   /**
    * Sets the value of the orderDescription property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setOrderDescription(String value) {
      this.orderDescription = value;
   }

   /**
    * Sets the value of the orderId property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setOrderId(String value) {
      this.orderId = value;
   }

   /**
    * Sets the value of the orderTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setOrderTotal(BigDecimal value) {
      this.orderTotal = value;
   }

   /**
    * Sets the value of the shipment property.
    * 
    * @param value
    *           allowed object is {@link Shipment }
    * 
    */
   public void setShipment(Shipment value) {
      this.shipment = value;
   }

   /**
    * Sets the value of the shippingDiscount property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setShippingDiscount(BigDecimal value) {
      this.shippingDiscount = value;
   }

   /**
    * Sets the value of the shippingTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setShippingTotal(BigDecimal value) {
      this.shippingTotal = value;
   }

   /**
    * Sets the value of the taxTotal property.
    * 
    * @param value
    *           allowed object is {@link BigDecimal }
    * 
    */
   public void setTaxTotal(BigDecimal value) {
      this.taxTotal = value;
   }

   /**
    * Sets the value of the token property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setToken(String value) {
      this.token = value;
   }

   /**
    * Sets the value of the transactionId property.
    * 
    * @param value
    *           allowed object is {@link String }
    * 
    */
   public void setTransactionId(String value) {
      this.transactionId = value;
   }

}
