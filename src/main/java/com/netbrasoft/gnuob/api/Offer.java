
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
 * <p>Java class for offer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="offer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access">
 *       &lt;sequence>
 *         &lt;element name="contract" type="{http://gnuob.netbrasoft.com/}contract"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="handlingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="insuranceTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="records" type="{http://gnuob.netbrasoft.com/}offerRecord" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shippingDiscount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="shippingTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offer", propOrder = {
    "contract",
    "description",
    "handlingTotal",
    "insuranceTotal",
    "records",
    "reference",
    "shippingDiscount",
    "shippingTotal"
})
public class Offer
    extends Access
    implements Serializable
{

    private static final long serialVersionUID = 9099667990766991119L;
	@XmlElement(required = true)
    protected Contract contract;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected BigDecimal handlingTotal;
    @XmlElement(required = true)
    protected BigDecimal insuranceTotal;
    @XmlElement(nillable = true)
    protected List<OfferRecord> records;
    @XmlElement(required = true)
    protected String reference;
    @XmlElement(required = true)
    protected BigDecimal shippingDiscount;
    @XmlElement(required = true)
    protected BigDecimal shippingTotal;

    /**
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link Contract }
     *     
     */
    public Contract getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contract }
     *     
     */
    public void setContract(Contract value) {
        this.contract = value;
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
     * Gets the value of the handlingTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHandlingTotal() {
        return handlingTotal;
    }

    /**
     * Sets the value of the handlingTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHandlingTotal(BigDecimal value) {
        this.handlingTotal = value;
    }

    /**
     * Gets the value of the insuranceTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInsuranceTotal() {
        return insuranceTotal;
    }

    /**
     * Sets the value of the insuranceTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInsuranceTotal(BigDecimal value) {
        this.insuranceTotal = value;
    }

    /**
     * Gets the value of the records property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the records property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecords().add(newItem);
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
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the shippingDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShippingDiscount() {
        return shippingDiscount;
    }

    /**
     * Sets the value of the shippingDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShippingDiscount(BigDecimal value) {
        this.shippingDiscount = value;
    }

    /**
     * Gets the value of the shippingTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShippingTotal() {
        return shippingTotal;
    }

    /**
     * Sets the value of the shippingTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShippingTotal(BigDecimal value) {
        this.shippingTotal = value;
    }

}
