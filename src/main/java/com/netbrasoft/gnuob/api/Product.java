
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
 * <p>Java class for product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="product"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="bestsellers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="contents" type="{http://gnuob.netbrasoft.com/}content" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="itemHeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemHeightUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemLength" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemLengthUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemWeight" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="itemWeightUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemWidth" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemWidthUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="latestCollection" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="options" type="{http://gnuob.netbrasoft.com/}option" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="recommended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="shippingCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="stock" type="{http://gnuob.netbrasoft.com/}stock"/&gt;
 *         &lt;element name="subCategories" type="{http://gnuob.netbrasoft.com/}subCategory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "amount",
    "bestsellers",
    "contents",
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
    "latestCollection",
    "name",
    "number",
    "options",
    "rating",
    "recommended",
    "shippingCost",
    "stock",
    "subCategories",
    "tax"
})
public class Product
    extends Access
    implements Serializable
{

    /**
    * 
    */
   private static final long serialVersionUID = -8465879898146696012L;
   @XmlElement(required = true)
    protected BigDecimal amount;
    protected Boolean bestsellers;
    @XmlElement(nillable = true)
    protected List<Content> contents;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected BigDecimal discount;
    protected BigDecimal itemHeight;
    protected String itemHeightUnit;
    protected BigDecimal itemLength;
    protected String itemLengthUnit;
    protected String itemUrl;
    @XmlElement(required = true)
    protected BigDecimal itemWeight;
    protected String itemWeightUnit;
    protected BigDecimal itemWidth;
    protected String itemWidthUnit;
    protected Boolean latestCollection;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String number;
    @XmlElement(nillable = true)
    protected List<Option> options;
    protected Integer rating;
    protected Boolean recommended;
    @XmlElement(required = true)
    protected BigDecimal shippingCost;
    @XmlElement(required = true)
    protected Stock stock;
    @XmlElement(nillable = true)
    protected List<SubCategory> subCategories;
    @XmlElement(required = true)
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
     * Gets the value of the bestsellers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBestsellers() {
        return bestsellers;
    }

    /**
     * Sets the value of the bestsellers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBestsellers(Boolean value) {
        this.bestsellers = value;
    }

    /**
     * Gets the value of the contents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Content }
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
     * Gets the value of the latestCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLatestCollection() {
        return latestCollection;
    }

    /**
     * Sets the value of the latestCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLatestCollection(Boolean value) {
        this.latestCollection = value;
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
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Option }
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
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRating(Integer value) {
        this.rating = value;
    }

    /**
     * Gets the value of the recommended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecommended() {
        return recommended;
    }

    /**
     * Sets the value of the recommended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecommended(Boolean value) {
        this.recommended = value;
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
     * Gets the value of the stock property.
     * 
     * @return
     *     possible object is
     *     {@link Stock }
     *     
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Sets the value of the stock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stock }
     *     
     */
    public void setStock(Stock value) {
        this.stock = value;
    }

    /**
     * Gets the value of the subCategories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subCategories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubCategories().add(newItem);
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
