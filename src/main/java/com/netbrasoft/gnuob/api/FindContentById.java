package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for findContentById complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="findContentById">
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
@XmlType(name = "findContentById", propOrder = { "content" })
public class FindContentById implements Serializable {

    private static final long serialVersionUID = 1531671104927717108L;
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
