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
 * Java class for offer complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="offer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access">
 *       &lt;sequence>
 *         &lt;element name="contract" type="{http://gnuob.netbrasoft.com/}contract"/>
 *         &lt;element name="discountTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="extraAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="handlingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="insuranceTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="itemTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="offerDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="offerTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="records" type="{http://gnuob.netbrasoft.com/}offerRecord" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shippingDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="shippingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="taxTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offer", propOrder = { "contract", "discountTotal", "extraAmount", "handlingTotal", "insuranceTotal", "itemTotal", "offerDescription", "offerId", "offerTotal", "records", "shippingDiscount", "shippingTotal", "taxTotal" })
public class Offer extends Access implements Serializable {

    private static final long serialVersionUID = 8096103625270800523L;
    @XmlElement(required = true)
    protected Contract contract;
    protected BigDecimal discountTotal;
    @XmlElement(required = true)
    protected BigDecimal extraAmount;
    @XmlElement(required = true)
    protected BigDecimal handlingTotal;
    @XmlElement(required = true)
    protected BigDecimal insuranceTotal;
    protected BigDecimal itemTotal;
    protected String offerDescription;
    @XmlElement(required = true)
    protected String offerId;
    protected BigDecimal offerTotal;
    @XmlElement(nillable = true)
    protected List<OfferRecord> records;
    @XmlElement(required = true)
    protected BigDecimal shippingDiscount;
    protected BigDecimal shippingTotal;
    protected BigDecimal taxTotal;

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
     * Gets the value of the offerDescription property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOfferDescription() {
        return offerDescription;
    }

    /**
     * Sets the value of the offerDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setOfferDescription(String value) {
        this.offerDescription = value;
    }

    /**
     * Gets the value of the offerId property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOfferId() {
        return offerId;
    }

    /**
     * Sets the value of the offerId property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setOfferId(String value) {
        this.offerId = value;
    }

    /**
     * Gets the value of the offerTotal property.
     * 
     * @return possible object is {@link BigDecimal }
     * 
     */
    public BigDecimal getOfferTotal() {
        return offerTotal;
    }

    /**
     * Sets the value of the offerTotal property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setOfferTotal(BigDecimal value) {
        this.offerTotal = value;
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
     * {@link OfferRecord }
     * 
     * 
     */
    public List<OfferRecord> getRecords() {
        if (records == null) {
            records = new ArrayList<OfferRecord>();
        }
        return this.records;
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

}
