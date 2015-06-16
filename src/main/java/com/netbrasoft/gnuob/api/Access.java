
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for access complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="access"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="permission" type="{http://gnuob.netbrasoft.com/}permission" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "access", propOrder = {
    "active",
    "permission"
})
@XmlSeeAlso({
    Content.class
})
public abstract class Access
    extends Type
    implements Serializable
{

    protected boolean active;
    protected Permission permission;

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the permission property.
     * 
     * @return
     *     possible object is
     *     {@link Permission }
     *     
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * Sets the value of the permission property.
     * 
     * @param value
     *     allowed object is
     *     {@link Permission }
     *     
     */
    public void setPermission(Permission value) {
        this.permission = value;
    }

}
