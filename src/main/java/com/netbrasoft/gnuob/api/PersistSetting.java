
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for persistSetting complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="persistSetting"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Setting" type="{http://gnuob.netbrasoft.com/}Setting" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persistSetting", propOrder = {"setting"})
public class PersistSetting implements Serializable {

  private static final long serialVersionUID = -1121795633722526405L;
  @XmlElement(name = "Setting")
  protected Setting setting;

  /**
   * Gets the value of the setting property.
   * 
   * @return possible object is {@link Setting }
   * 
   */
  public Setting getSetting() {
    return setting;
  }

  /**
   * Sets the value of the setting property.
   * 
   * @param value allowed object is {@link Setting }
   * 
   */
  public void setSetting(final Setting value) {
    this.setting = value;
  }

}
