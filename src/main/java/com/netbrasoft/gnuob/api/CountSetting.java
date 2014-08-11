
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="countSetting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Setting" type="{http://gnuob.netbrasoft.com/}Setting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countSetting", propOrder = {
    "setting"
})
public class CountSetting
    implements Serializable
{

    private static final long serialVersionUID = -4217275746340413895L;
	@XmlElement(name = "Setting")
    protected Setting setting;

    /**
     * Gets the value of the setting property.
     * 
     * @return
     *     possible object is
     *     {@link Setting }
     *     
     */
    public Setting getSetting() {
        return setting;
    }

    /**
     * Sets the value of the setting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Setting }
     *     
     */
    public void setSetting(Setting value) {
        this.setting = value;
    }

}
