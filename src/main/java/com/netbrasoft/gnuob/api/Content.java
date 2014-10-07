package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for content complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="content">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}access">
 *       &lt;sequence>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "content", propOrder = { "content", "format", "name" })
public class Content extends Access implements Serializable {

    private static final long serialVersionUID = -8594647005451740908L;
    @XmlElement(required = true)
    @XmlMimeType("application/octet-stream")
    protected DataHandler content;
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
    public DataHandler getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *            allowed object is {@link DataHandler }
     * 
     */
    public void setContent(DataHandler value) {
        this.content = value;
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
     * Sets the value of the format property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setFormat(String value) {
        this.format = value;
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
     * Sets the value of the name property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

}
