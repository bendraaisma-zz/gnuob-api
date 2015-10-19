
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for content complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="content"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "content", propOrder = {"content", "format", "name"})
public class Content extends Access implements Serializable {

  private static final long serialVersionUID = -5806711934105531574L;
  @XmlElement(required = true)
  protected byte[] content;
  @XmlElement(required = true)
  protected String format;
  @XmlElement(required = true)
  protected String name;

  /**
   * Gets the value of the content property.
   * 
   * @return possible object is {@link DataHandler }
   * 
   */
  public byte[] getContent() {
    return content;
  }

  /**
   * Gets the value of the format property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getFormat() {
    return format;
  }

  /**
   * Gets the value of the name property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the content property.
   * 
   * @param value allowed object is {@link DataHandler }
   * 
   */
  public void setContent(byte[] value) {
    this.content = value;
  }

  /**
   * Sets the value of the format property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setFormat(String value) {
    this.format = value;
  }

  /**
   * Sets the value of the name property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setName(String value) {
    this.name = value;
  }

}
