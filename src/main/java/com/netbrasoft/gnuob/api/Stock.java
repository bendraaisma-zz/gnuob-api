package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for stock complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="stock">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type">
 *       &lt;sequence>
 *         &lt;element name="maxQuantity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="minQuantity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stock", propOrder = { "maxQuantity", "minQuantity", "quantity" })
public class Stock extends Type implements Serializable {

    private static final long serialVersionUID = 1370554796617371872L;
    @XmlElement(required = true)
    protected BigInteger maxQuantity;
    @XmlElement(required = true)
    protected BigInteger minQuantity;
    @XmlElement(required = true)
    protected BigInteger quantity;

    /**
     * Gets the value of the maxQuantity property.
     * 
     * @return possible object is {@link BigInteger }
     * 
     */
    public BigInteger getMaxQuantity() {
        return maxQuantity;
    }

    /**
     * Sets the value of the maxQuantity property.
     * 
     * @param value
     *            allowed object is {@link BigInteger }
     * 
     */
    public void setMaxQuantity(BigInteger value) {
        this.maxQuantity = value;
    }

    /**
     * Gets the value of the minQuantity property.
     * 
     * @return possible object is {@link BigInteger }
     * 
     */
    public BigInteger getMinQuantity() {
        return minQuantity;
    }

    /**
     * Sets the value of the minQuantity property.
     * 
     * @param value
     *            allowed object is {@link BigInteger }
     * 
     */
    public void setMinQuantity(BigInteger value) {
        this.minQuantity = value;
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
     * Sets the value of the quantity property.
     * 
     * @param value
     *            allowed object is {@link BigInteger }
     * 
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

}
