
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="countOffer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="offer" type="{http://gnuob.netbrasoft.com/}offer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countOffer", propOrder = {
    "offer"
})
public class CountOffer
    implements Serializable
{

    private static final long serialVersionUID = -7574061563318886159L;
	protected Offer offer;

    /**
     * Gets the value of the offer property.
     * 
     * @return
     *     possible object is
     *     {@link Offer }
     *     
     */
    public Offer getOffer() {
        return offer;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offer }
     *     
     */
    public void setOffer(Offer value) {
        this.offer = value;
    }

}
