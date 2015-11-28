
package com.netbrasoft.gnuob.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>
 * Java class for payment complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="payment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://gnuob.netbrasoft.com/}abstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="feeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="grossAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="holdDecision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="installmentCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="paymentRequestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pendingReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="protectionEligibilityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="settleAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="storeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="terminalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transactionType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payment", propOrder = {"exchangeRate", "feeAmount", "grossAmount", "holdDecision", "installmentCount", "paymentDate", "paymentRequestId", "paymentStatus",
    "paymentType", "pendingReason", "protectionEligibilityType", "reasonCode", "settleAmount", "storeId", "taxAmount", "terminalId", "transactionId", "transactionType"})
public class Payment extends AbstractType implements Serializable {

  private static final long serialVersionUID = 2340662684512087852L;
  protected String exchangeRate;
  protected BigDecimal feeAmount;
  @XmlElement(required = true)
  protected BigDecimal grossAmount;
  protected String holdDecision;
  protected BigInteger installmentCount;
  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar paymentDate;
  protected String paymentRequestId;
  @XmlElement(required = true)
  protected String paymentStatus;
  @XmlElement(required = true)
  protected String paymentType;
  protected String pendingReason;
  protected String protectionEligibilityType;
  protected String reasonCode;
  protected BigDecimal settleAmount;
  protected String storeId;
  protected BigDecimal taxAmount;
  protected String terminalId;
  @XmlElement(required = true)
  protected String transactionId;
  @XmlElement(required = true)
  protected String transactionType;

  /**
   * Gets the value of the exchangeRate property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getExchangeRate() {
    return exchangeRate;
  }

  /**
   * Gets the value of the feeAmount property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getFeeAmount() {
    return feeAmount;
  }

  /**
   * Gets the value of the grossAmount property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getGrossAmount() {
    return grossAmount;
  }

  /**
   * Gets the value of the holdDecision property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getHoldDecision() {
    return holdDecision;
  }

  /**
   * Gets the value of the installmentCount property.
   * 
   * @return possible object is {@link BigInteger }
   * 
   */
  public BigInteger getInstallmentCount() {
    return installmentCount;
  }

  /**
   * Gets the value of the paymentDate property.
   * 
   * @return possible object is {@link XMLGregorianCalendar }
   * 
   */
  public XMLGregorianCalendar getPaymentDate() {
    return paymentDate;
  }

  /**
   * Gets the value of the paymentRequestId property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getPaymentRequestId() {
    return paymentRequestId;
  }

  /**
   * Gets the value of the paymentStatus property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getPaymentStatus() {
    return paymentStatus;
  }

  /**
   * Gets the value of the paymentType property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getPaymentType() {
    return paymentType;
  }

  /**
   * Gets the value of the pendingReason property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getPendingReason() {
    return pendingReason;
  }

  /**
   * Gets the value of the protectionEligibilityType property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getProtectionEligibilityType() {
    return protectionEligibilityType;
  }

  /**
   * Gets the value of the reasonCode property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getReasonCode() {
    return reasonCode;
  }

  /**
   * Gets the value of the settleAmount property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getSettleAmount() {
    return settleAmount;
  }

  /**
   * Gets the value of the storeId property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getStoreId() {
    return storeId;
  }

  /**
   * Gets the value of the taxAmount property.
   * 
   * @return possible object is {@link BigDecimal }
   * 
   */
  public BigDecimal getTaxAmount() {
    return taxAmount;
  }

  /**
   * Gets the value of the terminalId property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getTerminalId() {
    return terminalId;
  }

  /**
   * Gets the value of the transactionId property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getTransactionId() {
    return transactionId;
  }

  /**
   * Gets the value of the transactionType property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getTransactionType() {
    return transactionType;
  }

  /**
   * Sets the value of the exchangeRate property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setExchangeRate(final String value) {
    this.exchangeRate = value;
  }

  /**
   * Sets the value of the feeAmount property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setFeeAmount(final BigDecimal value) {
    this.feeAmount = value;
  }

  /**
   * Sets the value of the grossAmount property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setGrossAmount(final BigDecimal value) {
    this.grossAmount = value;
  }

  /**
   * Sets the value of the holdDecision property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setHoldDecision(final String value) {
    this.holdDecision = value;
  }

  /**
   * Sets the value of the installmentCount property.
   * 
   * @param value allowed object is {@link BigInteger }
   * 
   */
  public void setInstallmentCount(final BigInteger value) {
    this.installmentCount = value;
  }

  /**
   * Sets the value of the paymentDate property.
   * 
   * @param value allowed object is {@link XMLGregorianCalendar }
   * 
   */
  public void setPaymentDate(final XMLGregorianCalendar value) {
    this.paymentDate = value;
  }

  /**
   * Sets the value of the paymentRequestId property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPaymentRequestId(final String value) {
    this.paymentRequestId = value;
  }

  /**
   * Sets the value of the paymentStatus property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPaymentStatus(final String value) {
    this.paymentStatus = value;
  }

  /**
   * Sets the value of the paymentType property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPaymentType(final String value) {
    this.paymentType = value;
  }

  /**
   * Sets the value of the pendingReason property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPendingReason(final String value) {
    this.pendingReason = value;
  }

  /**
   * Sets the value of the protectionEligibilityType property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setProtectionEligibilityType(final String value) {
    this.protectionEligibilityType = value;
  }

  /**
   * Sets the value of the reasonCode property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setReasonCode(final String value) {
    this.reasonCode = value;
  }

  /**
   * Sets the value of the settleAmount property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setSettleAmount(final BigDecimal value) {
    this.settleAmount = value;
  }

  /**
   * Sets the value of the storeId property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setStoreId(final String value) {
    this.storeId = value;
  }

  /**
   * Sets the value of the taxAmount property.
   * 
   * @param value allowed object is {@link BigDecimal }
   * 
   */
  public void setTaxAmount(final BigDecimal value) {
    this.taxAmount = value;
  }

  /**
   * Sets the value of the terminalId property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setTerminalId(final String value) {
    this.terminalId = value;
  }

  /**
   * Sets the value of the transactionId property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setTransactionId(final String value) {
    this.transactionId = value;
  }

  /**
   * Sets the value of the transactionType property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setTransactionType(final String value) {
    this.transactionType = value;
  }

}
