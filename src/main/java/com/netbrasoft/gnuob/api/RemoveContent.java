
package com.netbrasoft.gnuob.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for removeContent complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="removeContent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="content" type="{http://gnuob.netbrasoft.com/}content" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeContent", propOrder = {"content"})
public class RemoveContent implements Serializable {

  private static final long serialVersionUID = -4681208930861277555L;
  protected Content content;

  /**
   * Gets the value of the content property.
   * 
   * @return possible object is {@link Content }
   * 
   */
  public Content getContent() {
    return content;
  }

  /**
   * Sets the value of the content property.
   * 
   * @param value allowed object is {@link Content }
   * 
   */
  public void setContent(final Content value) {
    this.content = value;
  }

}
