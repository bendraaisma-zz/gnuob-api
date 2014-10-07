package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for persistCategory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="persistCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://gnuob.netbrasoft.com/}category" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persistCategory", propOrder = { "category" })
public class PersistCategory implements Serializable {

    private static final long serialVersionUID = -645053075150492066L;
    protected Category category;

    /**
     * Gets the value of the category property.
     * 
     * @return possible object is {@link Category }
     * 
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *            allowed object is {@link Category }
     * 
     */
    public void setCategory(Category value) {
        this.category = value;
    }

}
