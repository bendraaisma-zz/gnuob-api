package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for doCheckoutDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="doCheckoutDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="order" type="{http://gnuob.netbrasoft.com/}order" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doCheckoutDetails", propOrder = { "order" })
public class DoCheckoutDetails implements Serializable {

    private static final long serialVersionUID = -2497176618258148127L;
    protected Order order;

    /**
     * Gets the value of the order property.
     * 
     * @return possible object is {@link Order }
     * 
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *            allowed object is {@link Order }
     * 
     */
    public void setOrder(Order value) {
        this.order = value;
    }

}
