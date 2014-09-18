
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
 * &lt;complexType name="access">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type">
 *       &lt;sequence>
 *         &lt;element name="permission" type="{http://gnuob.netbrasoft.com/}permission" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "access", propOrder = {
    "permission"
})
@XmlSeeAlso({
    Setting.class
})
public abstract class Access
    extends Type
    implements Serializable
{

    private static final long serialVersionUID = 6977666207311097211L;
	protected Permission permission;

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
