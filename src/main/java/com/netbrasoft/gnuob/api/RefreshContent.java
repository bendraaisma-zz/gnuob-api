package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for refreshContent complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="refreshContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="content" type="{http://gnuob.netbrasoft.com/}content" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refreshContent", propOrder = { "content" })
public class RefreshContent implements Serializable {

    private static final long serialVersionUID = 5850758375275705792L;
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
     * @param value
     *            allowed object is {@link Content }
     * 
     */
    public void setContent(Content value) {
        this.content = value;
    }

}
