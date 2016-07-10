/*
 * Copyright 2016 Netbrasoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package br.com.netbrasoft.gnuob.api.generic.utils;

import static br.com.netbrasoft.gnuob.api.Rule.DELETE_ACCESS;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.netbrasoft.gnuob.api.Address;
import br.com.netbrasoft.gnuob.api.Contract;
import br.com.netbrasoft.gnuob.api.Customer;
import br.com.netbrasoft.gnuob.api.Invoice;
import br.com.netbrasoft.gnuob.api.Order;
import br.com.netbrasoft.gnuob.api.OrderRecord;
import br.com.netbrasoft.gnuob.api.Permission;
import br.com.netbrasoft.gnuob.api.Shipment;

import br.com.netbrasoft.gnuob.api.order.OrderDataProvider.PaymentProviderEnum;

public final class PagseguroInstanceHelper {

  public static Order getOrderInstance() {
    final Order order = new Order();
    order.setActive(true);
    order.setId(0L);
    order.setVersion(0);
    order.setBillingAgreementId(null);
    order.setCheckout(PaymentProviderEnum.PAGSEGURO.name());
    order.setCheckoutStatus(null);
    order.setContract(getContractInstance());
    order.setCustom(null);
    order.setDiscountTotal(BigDecimal.valueOf(10.00));
    order.setExtraAmount(BigDecimal.valueOf(1.00));
    order.setGiftMessage(null);
    order.setGiftMessageEnable(null);
    order.setGiftReceiptEnable(null);
    order.setGiftWrapAmount(null);
    order.setGiftWrapName(null);
    order.setGiftWrapEnable(null);
    order.setHandlingTotal(null);
    order.setInsuranceOptionOffered(null);
    order.setInsuranceTotal(null);
    order.setInvoice(getInvoiceInstance());
    order.setItemTotal(null);
    order.setMaxTotal(null);
    order.setNote(null);
    order.setNoteText(null);
    order.setNotificationId(null);
    final GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.setTime(new Date());
    // FIXME: Fix criteria find by example to find also by date properties.
    // order.setOrderDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
    order.setOrderDescription(null);
    order.setOrderId(null);
    order.setOrderTotal(BigDecimal.valueOf(91.00));
    order.setPermission(getPermissionInstance());
    order.setShipment(getShipmentInstance());
    order.setShippingDiscount(BigDecimal.valueOf(5.00));
    order.setShippingTotal(BigDecimal.valueOf(10.00));
    order.setTaxTotal(null);
    order.setToken(null);
    order.setTransactionId(null);
    order.getRecords().add(getOrderRecordInstance());
    return order;
  }

  public static Contract getContractInstance() {
    final Contract contract = new Contract();
    contract.setActive(true);
    contract.setId(0L);
    contract.setVersion(0);
    contract.setContractId("info@example.com");
    contract.setCustomer(getCustomerInstance());
    contract.setPermission(getPermissionInstance());
    return contract;
  }

  public static Customer getCustomerInstance() {
    final Customer customer = new Customer();
    customer.setActive(true);
    customer.setId(0L);
    customer.setVersion(0);
    customer.setAddress(getAddressInstance());
    customer.setBuyerEmail("c77487489899036884556@sandbox.pagseguro.com.br");
    customer.setBuyerMarketingEmail("kauadiascastro@dayrep.com");
    customer.setContactPhone("(31) 6429-4426");
    final GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.setTime(new Date());
    // FIXME: Fix criteria find by example to find also by date properties.
    // customer.setDateOfBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
    customer.setFirstName("Kaua");
    customer.setFriendlyName("Kaua Dias Castro");
    customer.setLastName("Dias Castro");
    customer.setMiddleName(null);
    customer.setPayer("kauadiascastro@dayrep.com");
    customer.setPayerBusiness("kauadiascastro@dayrep.com");
    customer.setPayerId(null);
    customer.setPayerStatus(null);
    customer.setPermission(getPermissionInstance());
    customer.setSalutation(null);
    customer.setSuffix(null);
    customer.setTaxId(null);
    customer.setTaxIdType(null);
    return customer;
  }

  public static Address getAddressInstance() {
    final Address address = new Address();
    address.setId(0L);
    address.setVersion(0);
    address.setCityName("Ribeirão das Neves");
    address.setComplement(null);
    address.setCountry("BR");
    address.setCountryName(null);
    address.setDistrict(null);
    address.setInternationalStateAndCity(null);
    address.setInternationalStreet(null);
    address.setNumber("1007");
    address.setPhone("(31) 6429-4426");
    address.setPostalCode("33823-580");
    address.setStateOrProvince("MG");
    address.setStreet1("Rua Dois");
    address.setStreet2(null);
    return address;
  }

  public static Invoice getInvoiceInstance() {
    final Invoice invoice = new Invoice();
    invoice.setId(0L);
    invoice.setVersion(0);
    invoice.setAddress(getAddressInstance());
    invoice.setInvoiceId(null);
    invoice.getPayments();
    return invoice;
  }

  public static Permission getPermissionInstance() {
    final Permission permission = new Permission();
    permission.setId(0L);
    permission.setVersion(0);
    permission.setOwner(DELETE_ACCESS);
    permission.setGroup(DELETE_ACCESS);
    permission.setOthers(DELETE_ACCESS);
    return permission;
  }

  public static Shipment getShipmentInstance() {
    final Shipment shipment = new Shipment();
    shipment.setId(0L);
    shipment.setVersion(0);
    shipment.setShipmentType(null);
    shipment.setAddress(getAddressInstance());
    return shipment;
  }

  public static OrderRecord getOrderRecordInstance() {
    final OrderRecord orderRecord = new OrderRecord();
    orderRecord.setId(0L);
    orderRecord.setVersion(0);
    orderRecord.setAmount(BigDecimal.valueOf(10.0));
    // FIXME: Fix criteria find by example to find also by date properties.
    // orderRecord.setDeliveryDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
    orderRecord.setDescription("Konk Hotzap shotgun");
    orderRecord.setDiscount(BigDecimal.valueOf(10.00));
    orderRecord.setItemHeight(null);
    orderRecord.setItemHeightUnit(null);
    orderRecord.setItemLength(null);
    orderRecord.setItemLengthUnit(null);
    orderRecord.setItemUrl(null);
    orderRecord.setItemWeight(BigDecimal.valueOf(0.50));
    orderRecord.setItemWeightUnit("KG");
    orderRecord.setItemWidth(null);
    orderRecord.setItemWidthUnit(null);
    orderRecord.setName("Konk Hotzap");
    orderRecord.setOption(null);
    orderRecord.setOrderRecordId(null);
    orderRecord.setProduct(null);
    orderRecord.setProductNumber("2133132321328");
    orderRecord.setQuantity(BigInteger.valueOf(2));
    orderRecord.setShippingCost(BigDecimal.valueOf(10.00));
    orderRecord.setTax(BigDecimal.valueOf(1.18));
    return orderRecord;
  }
}
