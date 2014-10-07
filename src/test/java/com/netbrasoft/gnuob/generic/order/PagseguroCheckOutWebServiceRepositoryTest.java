package com.netbrasoft.gnuob.generic.order;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.netbrasoft.gnuob.api.Address;
import com.netbrasoft.gnuob.api.Contract;
import com.netbrasoft.gnuob.api.Customer;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.Invoice;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.OrderRecord;
import com.netbrasoft.gnuob.api.Product;
import com.netbrasoft.gnuob.api.Stock;
import com.netbrasoft.gnuob.api.SubCategory;
import com.netbrasoft.gnuob.api.order.OrderWebServiceRepository;
import com.netbrasoft.gnuob.api.product.ProductWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

public class PagseguroCheckOutWebServiceRepositoryTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return Utils.createDeployment();
    }

    private ProductWebServiceRepository productWebServiceRepository = new ProductWebServiceRepository();
    private OrderWebServiceRepository orderWebServiceRepository = new OrderWebServiceRepository();
    private MetaData metaData = null;
    private Customer customer = null;
    private Contract contract = null;
    private Address address = null;
    private Product product = null;
    private Order order = null;
    private Invoice invoice = null;

    @Before
    public void testBefore() {
        Random randomGenerator = new Random();

        metaData = new MetaData();
        customer = new Customer();
        address = new Address();
        contract = new Contract();
        product = new Product();
        order = new Order();
        invoice = new Invoice();

        metaData.setUser("administrator");
        metaData.setPassword("administrator");
        metaData.setSite("www.netbrasoft.com");

        address.setCityName(UUID.randomUUID().toString());
        address.setStreet1(UUID.randomUUID().toString());

        customer.setFirstName(UUID.randomUUID().toString());
        customer.setLastName(UUID.randomUUID().toString());
        customer.setBuyerEmail(UUID.randomUUID().toString());
        customer.setAdress(address);
        customer.setDateOfBirth("2014-12-31");

        contract.setCustomer(customer);

        product.setName(UUID.randomUUID().toString());
        product.setDescription(UUID.randomUUID().toString());
        product.setNumber(UUID.randomUUID().toString());
        product.setAmount(BigDecimal.valueOf(randomGenerator.nextInt()));
        product.setTax(BigDecimal.valueOf(randomGenerator.nextInt()));
        product.setDiscount(BigDecimal.valueOf(randomGenerator.nextInt()));
        product.setRecommended(randomGenerator.nextBoolean());
        product.setRating(randomGenerator.nextInt());
        product.setBestsellers(randomGenerator.nextBoolean());
        product.setShippingCost(BigDecimal.valueOf(randomGenerator.nextInt()));

        Stock stock = new Stock();
        stock.setMaxQuantity(BigInteger.valueOf(100));
        stock.setMinQuantity(BigInteger.ZERO);
        stock.setQuantity(BigInteger.valueOf(30));

        product.setStock(stock);

        SubCategory subCategory = new SubCategory();
        subCategory.setName(UUID.randomUUID().toString());
        subCategory.setDescription(UUID.randomUUID().toString());

        product.getSubCategories().add(subCategory);

        invoice.setAddress(address);

        order.setContract(contract);
        order.setInvoice(invoice);
    }

    @Test
    public void testPersistOrder() throws GNUOpenBusinessServiceException_Exception {
        String productName = product.getName();
        String productDescription = product.getDescription();

        Product persistProduct = productWebServiceRepository.persist(metaData, product);

        Assert.assertTrue("Product id has no value bigger than zero.", persistProduct.getId() > 0);
        Assert.assertEquals("Product name is not equal.", productName, persistProduct.getName());
        Assert.assertEquals("Product description is not equal.", productDescription, persistProduct.getDescription());

        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setProduct(product);
        orderRecord.setQuantity(BigInteger.ONE);
        orderRecord.setProduct(persistProduct);

        order.getRecords().add(orderRecord);

        Order persistOrder = orderWebServiceRepository.persist(metaData, order);

        Assert.assertTrue("Order id has no value bigger than zero.", persistOrder.getId() > 0);
    }
}
