
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for findContractById complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="findContractById"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contract" type="{http://gnuob.netbrasoft.com/}contract" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findContractById", propOrder = { "contract" })
public class FindContractById implements Serializable {

   protected Contract contract;

   /**
    * Gets the value of the contract property.
    * 
    * @return possible object is {@link Contract }
    * 
    */
   public Contract getContract() {
      return contract;
   }

   /**
    * Sets the value of the contract property.
    * 
    * @param value
    *           allowed object is {@link Contract }
    * 
    */
   public void setContract(Contract value) {
      this.contract = value;
   }

}
