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
 * &lt;complexType name="order">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access">
 *       &lt;sequence>
 *         &lt;element name="billingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkoutStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contract" type="{http://gnuob.netbrasoft.com/}contract"/>
 *         &lt;element name="custom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discountTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="extraAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="giftMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giftMessageEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="giftReceiptEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="giftWrapAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="giftWrapEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="giftWrapName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="handlingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="insuranceOptionOffered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="insuranceTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="invoice" type="{http://gnuob.netbrasoft.com/}invoice"/>
 *         &lt;element name="itemTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noteText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orderTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="records" type="{http://gnuob.netbrasoft.com/}orderRecord" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shipment" type="{http://gnuob.netbrasoft.com/}shipment"/>
 *         &lt;element name="shippingDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="shippingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="taxTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = { "billingAgreementId", "checkoutStatus", "contract", "custom", "discountTotal", "extraAmount", "giftMessage", "giftMessageEnable", "giftReceiptEnable", "giftWrapAmount", "giftWrapEnable", "giftWrapName",
        "handlingTotal", "insuranceOptionOffered", "insuranceTotal", "invoice", "itemTotal", "note", "noteText", "orderDescription", "orderId", "orderTotal", "records", "shipment", "shippingDiscount", "shippingTotal", "taxTotal", "token", "transactionId" })
public class Order extends Access implements Serializable {

    private static final long serialVersionUID = 1031985133967723299L;
    protected String billingAgreementId;
    protected String checkoutStatus;
    @XmlElement(required = true)
    protected Contract contract;
    protected String custom;
    @XmlElement(required = true)
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
    protected String note;
    protected String noteText;
    protected String orderDescription;
    @XmlElement(required = true)
    protected String orderId;
    protected BigDecimal orderTotal;
    @XmlElement(nillable = true)
    protected List<OrderRecord> records;
    @XmlElement(required = true)
    protected Shipment shipment;
    @XmlElement(required = true)
    protected BigDecimal shippingDiscount;
    @XmlElement(required = true)
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
     * Sets the value of the billingAgreementId property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBillingAgreementId(String value) {
        this.billingAgreementId = value;
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
     * Sets the value of the checkoutStatus property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCheckoutStatus(String value) {
        this.checkoutStatus = value;
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
     * Sets the value of the contract property.
     * 
     * @param value
     *            allowed object is {@link Contract }
     * 
     */
    public void setContract(Contract value) {
        this.contract = value;
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
     * Sets the value of the custom property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCustom(String value) {
        this.custom = value;
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
     * Sets the value of the discountTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setDiscountTotal(BigDecimal value) {
        this.discountTotal = value;
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
     * Sets the value of the extraAmount property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setExtraAmount(BigDecimal value) {
        this.extraAmount = value;
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
     * Sets the value of the giftMessage property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setGiftMessage(String value) {
        this.giftMessage = value;
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
     * Sets the value of the giftMessageEnable property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setGiftMessageEnable(Boolean value) {
        this.giftMessageEnable = value;
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
     * Sets the value of the giftReceiptEnable property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setGiftReceiptEnable(Boolean value) {
        this.giftReceiptEnable = value;
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
     * Sets the value of the giftWrapAmount property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setGiftWrapAmount(BigDecimal value) {
        this.giftWrapAmount = value;
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
     * Sets the value of the giftWrapEnable property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setGiftWrapEnable(Boolean value) {
        this.giftWrapEnable = value;
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
     * Sets the value of the giftWrapName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setGiftWrapName(String value) {
        this.giftWrapName = value;
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
     * Sets the value of the handlingTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setHandlingTotal(BigDecimal value) {
        this.handlingTotal = value;
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
     * Sets the value of the insuranceOptionOffered property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setInsuranceOptionOffered(Boolean value) {
        this.insuranceOptionOffered = value;
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
     * Sets the value of the insuranceTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setInsuranceTotal(BigDecimal value) {
        this.insuranceTotal = value;
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
     * Sets the value of the invoice property.
     * 
     * @param value
     *            allowed object is {@link Invoice }
     * 
     */
    public void setInvoice(Invoice value) {
        this.invoice = value;
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
     * Sets the value of the itemTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setItemTotal(BigDecimal value) {
        this.itemTotal = value;
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
     * Sets the value of the note property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setNote(String value) {
        this.note = value;
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
     * Sets the value of the noteText property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setNoteText(String value) {
        this.noteText = value;
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
     * Sets the value of the orderDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setOrderDescription(String value) {
        this.orderDescription = value;
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
     * Sets the value of the orderId property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setOrderId(String value) {
        this.orderId = value;
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
     * Sets the value of the orderTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setOrderTotal(BigDecimal value) {
        this.orderTotal = value;
    }

    /**
     * Gets the value of the records property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the records property.
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
     * Sets the value of the shipment property.
     * 
     * @param value
     *            allowed object is {@link Shipment }
     * 
     */
    public void setShipment(Shipment value) {
        this.shipment = value;
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
     * Sets the value of the shippingDiscount property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setShippingDiscount(BigDecimal value) {
        this.shippingDiscount = value;
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
     * Sets the value of the shippingTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setShippingTotal(BigDecimal value) {
        this.shippingTotal = value;
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
     * Sets the value of the taxTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setTaxTotal(BigDecimal value) {
        this.taxTotal = value;
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
     * Sets the value of the token property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setToken(String value) {
        this.token = value;
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
     * Sets the value of the transactionId property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

}
