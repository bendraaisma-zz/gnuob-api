package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for findSite complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="findSite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="site" type="{http://gnuob.netbrasoft.com/}site" minOccurs="0"/>
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
@XmlType(name = "findSite", propOrder = { "site", "paging", "orderBy" })
public class FindSite implements Serializable {

    private static final long serialVersionUID = 3967066781040434197L;
    protected Site site;
    protected Paging paging;
    protected OrderBy orderBy;

    /**
     * Gets the value of the site property.
     * 
     * @return possible object is {@link Site }
     * 
     */
    public Site getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     * @param value
     *            allowed object is {@link Site }
     * 
     */
    public void setSite(Site value) {
        this.site = value;
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
