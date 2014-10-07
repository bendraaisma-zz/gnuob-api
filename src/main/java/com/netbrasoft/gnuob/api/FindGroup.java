package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for findGroup complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="findGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="group" type="{http://gnuob.netbrasoft.com/}group" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://gnuob.netbrasoft.com/}paging" minOccurs="0"/>
 *         &lt;element name="orderBy" type="{http://gnuob.netbrasoft.com/}orderBy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findGroup", propOrder = { "group", "paging", "orderBy" })
public class FindGroup implements Serializable {

    private static final long serialVersionUID = -4807358343614343972L;
    protected Group group;
    protected Paging paging;
    protected OrderBy orderBy;

    /**
     * Gets the value of the group property.
     * 
     * @return possible object is {@link Group }
     * 
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *            allowed object is {@link Group }
     * 
     */
    public void setGroup(Group value) {
        this.group = value;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return possible object is {@link Paging }
     * 
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *            allowed object is {@link Paging }
     * 
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * @return possible object is {@link OrderBy }
     * 
     */
    public OrderBy getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *            allowed object is {@link OrderBy }
     * 
     */
    public void setOrderBy(OrderBy value) {
        this.orderBy = value;
    }

}
