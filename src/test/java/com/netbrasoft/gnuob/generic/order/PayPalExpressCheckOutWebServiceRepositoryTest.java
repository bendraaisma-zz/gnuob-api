package com.netbrasoft.gnuob.generic.order;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.netbrasoft.gnuob.api.Address;
import com.netbrasoft.gnuob.api.Contract;
import com.netbrasoft.gnuob.api.Customer;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.Invoice;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.OrderRecord;
import com.netbrasoft.gnuob.api.Product;
import com.netbrasoft.gnuob.api.Shipment;
import com.netbrasoft.gnuob.api.Stock;
import com.netbrasoft.gnuob.api.SubCategory;
import com.netbrasoft.gnuob.api.order.OrderWebServiceRepository;
import com.netbrasoft.gnuob.api.order.PayPalExpressCheckOutWebServiceRepository;
import com.netbrasoft.gnuob.api.product.ProductWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
public class PayPalExpressCheckOutWebServiceRepositoryTest {

  @Deployment(testable = false)
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  @Drone
  private WebDriver driver;

  private final ProductWebServiceRepository<Product> productWebServiceRepository = new ProductWebServiceRepository<Product>();
  private final OrderWebServiceRepository<Order> orderWebServiceRepository = new OrderWebServiceRepository<Order>();
  private final PayPalExpressCheckOutWebServiceRepository<Order> payPalExpressCheckOutWebServiceRepository = new PayPalExpressCheckOutWebServiceRepository<Order>();
  private MetaData metaData = null;
  private Customer customer = null;
  private Contract contract = null;
  private Address address = null;
  private Product product = null;
  private Order order = null;
  private Invoice invoice = null;
  private Shipment shipment = null;

  @Before
  public void testBefore() throws DatatypeConfigurationException {
    final Random randomGenerator = new Random();

    metaData = new MetaData();
    customer = new Customer();
    address = new Address();
    contract = new Contract();
    product = new Product();
    order = new Order();
    invoice = new Invoice();
    shipment = new Shipment();

    metaData.setUser("administrator");
    metaData.setPassword("administrator");
    metaData.setSite("www.netbrasoft.com");

    address.setCityName(UUID.randomUUID().toString());
    address.setStreet1(UUID.randomUUID().toString());
    address.setNumber("815");
    address.setCountry("BR");
    address.setStateOrProvince("Espirito Santo");
    address.setPostalCode("29072-230");

    customer.setActive(true);
    customer.setFirstName("Bernard Arjan");
    customer.setLastName("Draaisma");
    customer.setBuyerEmail("MRzEPsqD@netbrasoft.com");
    customer.setAddress(address);

    final GregorianCalendar c = new GregorianCalendar();
    c.setTime(new Date());
    customer.setDateOfBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));

    contract.setActive(true);
    contract.setCustomer(customer);

    product.setActive(true);
    product.setName(UUID.randomUUID().toString());
    product.setDescription(UUID.randomUUID().toString());
    product.setNumber(UUID.randomUUID().toString());
    product.setAmount(BigDecimal.valueOf(10.00));
    product.setTax(BigDecimal.valueOf(2.75));
    product.setDiscount(BigDecimal.ONE);
    product.setRecommended(randomGenerator.nextBoolean());
    product.setRating(randomGenerator.nextInt());
    product.setBestsellers(randomGenerator.nextBoolean());
    product.setShippingCost(BigDecimal.valueOf(7.95));
    product.setItemWeight(BigDecimal.ONE);
    product.setItemWeightUnit("Kg");

    final Stock stock = new Stock();
    stock.setMaxQuantity(BigInteger.valueOf(100));
    stock.setMinQuantity(BigInteger.ZERO);
    stock.setQuantity(BigInteger.valueOf(30));

    product.setStock(stock);

    final SubCategory subCategory = new SubCategory();
    subCategory.setName(UUID.randomUUID().toString());
    subCategory.setDescription(UUID.randomUUID().toString());

    product.getSubCategories().add(subCategory);

    invoice.setAddress(address);

    shipment.setShipmentType("NOT_SPECIFIED");
    shipment.setAddress(address);

    order.setActive(true);
    order.setInsuranceTotal(BigDecimal.valueOf(3.99));
    order.setHandlingTotal(BigDecimal.valueOf(0.63));
    order.setShippingDiscount(BigDecimal.ONE);
    order.setContract(contract);
    order.setInvoice(invoice);
    order.setShipment(shipment);
  }

  @Test
  public void testPersistOrderAndDoCheckOut() throws GNUOpenBusinessServiceException_Exception, InterruptedException {
    final String productName = product.getName();
    final String productDescription = product.getDescription();

    final Product persistProduct = productWebServiceRepository.persist(metaData, product);

    Assert.assertTrue("Product id has no value bigger than zero.", persistProduct.getId() > 0);
    Assert.assertEquals("Product name is not equal.", productName, persistProduct.getName());
    Assert.assertEquals("Product description is not equal.", productDescription, persistProduct.getDescription());

    final OrderRecord orderRecord = new OrderRecord();
    orderRecord.setQuantity(BigInteger.ONE);
    orderRecord.setProduct(persistProduct);

    order.getRecords().add(orderRecord);
    final Order persistOrder = orderWebServiceRepository.persist(metaData, order);

    Assert.assertTrue("Order id has no value bigger than zero.", persistOrder.getId() > 0);

    Order checkoutOrder = payPalExpressCheckOutWebServiceRepository.doCheckout(metaData, persistOrder);
    checkoutOrder = orderWebServiceRepository.find(metaData, checkoutOrder);

    Assert.assertNotNull("Order token has no value.", checkoutOrder.getToken());

    final WebDriverWait webDriverWait = new WebDriverWait(driver, 60);

    driver.get("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=" + checkoutOrder.getToken());
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loadLogin")));
    driver.findElement(By.id("loadLogin")).click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
    driver.findElement(By.id("login_password")).sendKeys("MRzEPsqD");
    driver.findElement(By.id("submitLogin")).click();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue_abovefold")));
    driver.findElement(By.id("continue_abovefold")).click();

    Thread.sleep(10000);

    checkoutOrder.getContract().getCustomer().setPayerId(driver.getTitle().split("PayerID=")[1].split(" ")[0]);
    Assert.assertNotNull("Customer payer id has no value.", checkoutOrder.getContract().getCustomer().getPayerId());

    driver.close();

    Order checkoutDetailsOrder = payPalExpressCheckOutWebServiceRepository.doCheckoutDetails(metaData, checkoutOrder);
    checkoutDetailsOrder = orderWebServiceRepository.find(metaData, checkoutDetailsOrder);

    Order checkoutPaymentOrder = payPalExpressCheckOutWebServiceRepository.doCheckoutPayment(metaData, checkoutDetailsOrder);
    checkoutPaymentOrder = orderWebServiceRepository.find(metaData, checkoutPaymentOrder);

    Assert.assertNotNull("Order transaction id has no value.", checkoutPaymentOrder.getTransactionId());
    Assert.assertEquals(BigDecimal.valueOf(23.32), checkoutPaymentOrder.getOrderTotal());
  }

}
