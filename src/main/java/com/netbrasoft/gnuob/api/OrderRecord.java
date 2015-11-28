
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>
 * Java class for orderRecord complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="orderRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}abstractType"&gt;
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
 *         &lt;element name="options" type="{http://gnuob.netbrasoft.com/}option" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "orderRecord", propOrder = {"amount", "deliveryDate", "description", "discount", "itemHeight", "itemHeightUnit", "itemLength", "itemLengthUnit", "itemUrl",
    "itemWeight", "itemWeightUnit", "itemWidth", "itemWidthUnit", "name", "option", "options", "orderRecordId", "product", "productNumber", "quantity", "shippingCost", "tax"})
public class OrderRecord extends AbstractType implements Serializable {

  private static final long serialVersionUID = -190204486628324389L;
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
  @XmlElement(nillable = true)
  protected List<Option> options;
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
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getAmount() {
    return amount;
  }

  /**
   * Gets the value of the deliveryDate property.
   * 
   * @return possible object is {@link XMLGregorianCalendar }
   * 
   */
  public XMLGregorianCalendar getDeliveryDate() {
    return deliveryDate;
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
   * Gets the value of the discount property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getDiscount() {
    return discount;
  }

  /**
   * Gets the value of the itemHeight property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getItemHeight() {
    return itemHeight;
  }

  /**
   * Gets the value of the itemHeightUnit property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getItemHeightUnit() {
    return itemHeightUnit;
  }

  /**
   * Gets the value of the itemLength property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getItemLength() {
    return itemLength;
  }

  /**
   * Gets the value of the itemLengthUnit property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getItemLengthUnit() {
    return itemLengthUnit;
  }

  /**
   * Gets the value of the itemUrl property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getItemUrl() {
    return itemUrl;
  }

  /**
   * Gets the value of the itemWeight property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getItemWeight() {
    return itemWeight;
  }

  /**
   * Gets the value of the itemWeightUnit property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getItemWeightUnit() {
    return itemWeightUnit;
  }

  /**
   * Gets the value of the itemWidth property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getItemWidth() {
    return itemWidth;
  }

  /**
   * Gets the value of the itemWidthUnit property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getItemWidthUnit() {
    return itemWidthUnit;
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
   * Gets the value of the option property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getOption() {
    return option;
  }

  /**
   * Gets the value of the options property.
   * 
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the options property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getOptions().add(newItem);
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list {@link Option }
   * 
   * 
   */
  public List<Option> getOptions() {
    if (options == null) {
      options = new ArrayList<Option>();
    }
    return this.options;
  }

  /**
   * Gets the value of the orderRecordId property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getOrderRecordId() {
    return orderRecordId;
  }

  /**
   * Gets the value of the product property.
   * 
   * @return possible object is {@link Product }
   * 
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Gets the value of the productNumber property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getProductNumber() {
    return productNumber;
  }

  /**
   * Gets the value of the quantity property.
   * 
   * @return possible object is {@link BigInteger }
   * 
   */
  public BigInteger getQuantity() {
    return quantity;
  }

  /**
   * Gets the value of the shippingCost property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getShippingCost() {
    return shippingCost;
  }

  /**
   * Gets the value of the tax property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getTax() {
    return tax;
  }

  /**
   * Sets the value of the amount property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setAmount(final BigDecimal value) {
    this.amount = value;
  }

  /**
   * Sets the value of the deliveryDate property.
   * 
   * @param value allowed object is {@link XMLGregorianCalendar }
   * 
   */
  public void setDeliveryDate(final XMLGregorianCalendar value) {
    this.deliveryDate = value;
  }

  /**
   * Sets the value of the description property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setDescription(final String value) {
    this.description = value;
  }

  /**
   * Sets the value of the discount property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setDiscount(final BigDecimal value) {
    this.discount = value;
  }

  /**
   * Sets the value of the itemHeight property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setItemHeight(final BigDecimal value) {
    this.itemHeight = value;
  }

  /**
   * Sets the value of the itemHeightUnit property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setItemHeightUnit(final String value) {
    this.itemHeightUnit = value;
  }

  /**
   * Sets the value of the itemLength property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setItemLength(final BigDecimal value) {
    this.itemLength = value;
  }

  /**
   * Sets the value of the itemLengthUnit property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setItemLengthUnit(final String value) {
    this.itemLengthUnit = value;
  }

  /**
   * Sets the value of the itemUrl property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setItemUrl(final String value) {
    this.itemUrl = value;
  }

  /**
   * Sets the value of the itemWeight property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setItemWeight(final BigDecimal value) {
    this.itemWeight = value;
  }

  /**
   * Sets the value of the itemWeightUnit property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setItemWeightUnit(final String value) {
    this.itemWeightUnit = value;
  }

  /**
   * Sets the value of the itemWidth property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setItemWidth(final BigDecimal value) {
    this.itemWidth = value;
  }

  /**
   * Sets the value of the itemWidthUnit property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setItemWidthUnit(final String value) {
    this.itemWidthUnit = value;
  }

  /**
   * Sets the value of the name property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setName(final String value) {
    this.name = value;
  }

  /**
   * Sets the value of the option property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setOption(final String value) {
    this.option = value;
  }

  /**
   * Sets the value of the orderRecordId property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setOrderRecordId(final String value) {
    this.orderRecordId = value;
  }

  /**
   * Sets the value of the product property.
   * 
   * @param value allowed object is {@link Product }
   * 
   */
  public void setProduct(final Product value) {
    this.product = value;
  }

  /**
   * Sets the value of the productNumber property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setProductNumber(final String value) {
    this.productNumber = value;
  }

  /**
   * Sets the value of the quantity property.
   * 
   * @param value allowed object is {@link BigInteger }
   * 
   */
  public void setQuantity(final BigInteger value) {
    this.quantity = value;
  }

  /**
   * Sets the value of the shippingCost property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setShippingCost(final BigDecimal value) {
    this.shippingCost = value;
  }

  /**
   * Sets the value of the tax property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setTax(final BigDecimal value) {
    this.tax = value;
  }

}
