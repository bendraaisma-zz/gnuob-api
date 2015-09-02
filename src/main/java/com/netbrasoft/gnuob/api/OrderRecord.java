
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for orderRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemHeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemHeightUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemLength" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemLengthUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemWeightUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemWidth" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemWidthUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="option" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderRecordId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="product" type="{http://gnuob.netbrasoft.com/}product" minOccurs="0"/&gt;
 *         &lt;element name="productNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="shippingCost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderRecord", propOrder = {
    "amount",
    "deliveryDate",
    "description",
    "discount",
    "itemHeight",
    "itemHeightUnit",
    "itemLength",
    "itemLengthUnit",
    "itemUrl",
    "itemWeight",
    "itemWeightUnit",
    "itemWidth",
    "itemWidthUnit",
    "name",
    "option",
    "orderRecordId",
    "product",
    "productNumber",
    "quantity",
    "shippingCost",
    "tax"
})
public class OrderRecord
    extends Type
    implements Serializable
{

    /**
    * 
    */
   private static final long serialVersionUID = -4908413903187271022L;
   protected BigDecimal amount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryDate;
    protected String description;
    protected BigDecimal discount;
    protected BigDecimal itemHeight;
    protected String itemHeightUnit;
    protected BigDecimal itemLength;
    protected String itemLengthUnit;
    protected String itemUrl;
    protected BigDecimal itemWeight;
    protected String itemWeightUnit;
    protected BigDecimal itemWidth;
    protected String itemWidthUnit;
    protected String name;
    protected String option;
    protected String orderRecordId;
    protected Product product;
    protected String productNumber;
    @XmlElement(required = true)
    protected BigInteger quantity;
    protected BigDecimal shippingCost;
    protected BigDecimal tax;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDate(XMLGregorianCalendar value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDiscount(BigDecimal value) {
        this.discount = value;
    }

    /**
     * Gets the value of the itemHeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemHeight() {
        return itemHeight;
    }

    /**
     * Sets the value of the itemHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemHeight(BigDecimal value) {
        this.itemHeight = value;
    }

    /**
     * Gets the value of the itemHeightUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemHeightUnit() {
        return itemHeightUnit;
    }

    /**
     * Sets the value of the itemHeightUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemHeightUnit(String value) {
        this.itemHeightUnit = value;
    }

    /**
     * Gets the value of the itemLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemLength() {
        return itemLength;
    }

    /**
     * Sets the value of the itemLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemLength(BigDecimal value) {
        this.itemLength = value;
    }

    /**
     * Gets the value of the itemLengthUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemLengthUnit() {
        return itemLengthUnit;
    }

    /**
     * Sets the value of the itemLengthUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemLengthUnit(String value) {
        this.itemLengthUnit = value;
    }

    /**
     * Gets the value of the itemUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemUrl() {
        return itemUrl;
    }

    /**
     * Sets the value of the itemUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemUrl(String value) {
        this.itemUrl = value;
    }

    /**
     * Gets the value of the itemWeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemWeight() {
        return itemWeight;
    }

    /**
     * Sets the value of the itemWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemWeight(BigDecimal value) {
        this.itemWeight = value;
    }

    /**
     * Gets the value of the itemWeightUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemWeightUnit() {
        return itemWeightUnit;
    }

    /**
     * Sets the value of the itemWeightUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemWeightUnit(String value) {
        this.itemWeightUnit = value;
    }

    /**
     * Gets the value of the itemWidth property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemWidth() {
        return itemWidth;
    }

    /**
     * Sets the value of the itemWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemWidth(BigDecimal value) {
        this.itemWidth = value;
    }

    /**
     * Gets the value of the itemWidthUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemWidthUnit() {
        return itemWidthUnit;
    }

    /**
     * Sets the value of the itemWidthUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemWidthUnit(String value) {
        this.itemWidthUnit = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOption(String value) {
        this.option = value;
    }

    /**
     * Gets the value of the orderRecordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderRecordId() {
        return orderRecordId;
    }

    /**
     * Sets the value of the orderRecordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderRecordId(String value) {
        this.orderRecordId = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    /**
     * Gets the value of the productNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * Sets the value of the productNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductNumber(String value) {
        this.productNumber = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the shippingCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    /**
     * Sets the value of the shippingCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShippingCost(BigDecimal value) {
        this.shippingCost = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTax(BigDecimal value) {
        this.tax = value;
    }

}
