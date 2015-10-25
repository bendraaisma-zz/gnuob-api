
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for option complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="option"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}type"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="disabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="subOptions" type="{http://gnuob.netbrasoft.com/}subOption" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "option", propOrder = {"description", "disabled", "position", "subOptions", "value"})
public class Option extends Type implements Serializable {

  private static final long serialVersionUID = 7319276393449800429L;
  @XmlElement(required = true)
  protected String description;
  protected boolean disabled;
  protected Integer position;
  @XmlElement(nillable = true)
  protected List<SubOption> subOptions;
  @XmlElement(required = true)
  protected String value;

  /**
   * Gets the value of the description property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the value of the description property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setDescription(String value) {
    this.description = value;
  }

  /**
   * Gets the value of the disabled property.
   * 
   */
  public boolean isDisabled() {
    return disabled;
  }

  /**
   * Sets the value of the disabled property.
   * 
   */
  public void setDisabled(boolean value) {
    this.disabled = value;
  }

  /**
   * Gets the value of the position property.
   * 
   * @return possible object is {@link Integer }
   * 
   */
  public Integer getPosition() {
    return position;
  }

  /**
   * Sets the value of the position property.
   * 
   * @param value allowed object is {@link Integer }
   * 
   */
  public void setPosition(Integer value) {
    this.position = value;
  }

  /**
   * Gets the value of the subOptions property.
   * 
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the subOptions property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getSubOptions().add(newItem);
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list {@link SubOption }
   * 
   * 
   */
  public List<SubOption> getSubOptions() {
    if (subOptions == null) {
      subOptions = new ArrayList<SubOption>();
    }
    return this.subOptions;
  }

  /**
   * Gets the value of the value property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setValue(String value) {
    this.value = value;
  }

}
