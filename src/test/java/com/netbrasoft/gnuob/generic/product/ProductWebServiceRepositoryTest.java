package com.netbrasoft.gnuob.generic.product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.Product;
import com.netbrasoft.gnuob.api.Stock;
import com.netbrasoft.gnuob.api.SubCategory;
import com.netbrasoft.gnuob.api.product.ProductWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
public class ProductWebServiceRepositoryTest {

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  private final ProductWebServiceRepository<Product> productWebServiceRepository = new ProductWebServiceRepository<Product>();
  private MetaData metaData = null;
  private Product product = null;

  @Before
  public void testBefore() {
    final Random randomGenerator = new Random();

    metaData = new MetaData();

    metaData.setUser("administrator");
    metaData.setPassword("administrator");
    metaData.setSite("localhost");

    product = new Product();

    product.setName(UUID.randomUUID().toString());
    product.setDescription(UUID.randomUUID().toString());
    product.setNumber(UUID.randomUUID().toString());
    product.setAmount(BigDecimal.valueOf(randomGenerator.nextInt()));
    product.setTax(BigDecimal.valueOf(randomGenerator.nextInt()));
    product.setDiscount(BigDecimal.valueOf(randomGenerator.nextInt()));
    product.setRecommended(randomGenerator.nextBoolean());
    product.setRating(randomGenerator.nextInt());
    product.setBestsellers(randomGenerator.nextBoolean());
    product.setShippingCost(BigDecimal.ZERO);
    product.setItemWeight(BigDecimal.ZERO);

    final Stock stock = new Stock();
    stock.setMaxQuantity(BigInteger.valueOf(100));
    stock.setMinQuantity(BigInteger.ZERO);
    stock.setQuantity(BigInteger.valueOf(30));

    product.setStock(stock);

    final SubCategory subCategory = new SubCategory();

    subCategory.setName(UUID.randomUUID().toString());
    subCategory.setDescription(UUID.randomUUID().toString());

    product.getSubCategories().add(subCategory);
  }

  @Test
  public void testFindProductBySubCategoryName() throws GNUOpenBusinessServiceException_Exception {
    final String productName = product.getName();
    final String productDescription = product.getDescription();

    productWebServiceRepository.persist(metaData, product);

    final Paging paging = new Paging();

    paging.setFirst(-1);
    paging.setMax(-1);

    final SubCategory subCategory = new SubCategory();
    subCategory.setName(product.getSubCategories().iterator().next().getName());

    final Product product = new Product();
    product.getSubCategories().add(subCategory);

    final List<Product> findProducts = productWebServiceRepository.find(metaData, product, paging, OrderBy.NONE);

    Assert.assertTrue("Find products has no value bigger than 1.", findProducts.size() == 1);

    final Product findProduct = findProducts.iterator().next();

    Assert.assertTrue("Product id has no value bigger than zero.", findProduct.getId() > 0);
    Assert.assertEquals("Product name is not equal.", productName, findProduct.getName());
    Assert.assertEquals("Product description is not equal.", productDescription, findProduct.getDescription());
  }

  @Test
  public void testMergeProduct() throws GNUOpenBusinessServiceException_Exception {
    final String productName = UUID.randomUUID().toString();
    final String productDescription = UUID.randomUUID().toString();

    final Product persistProduct = productWebServiceRepository.persist(metaData, product);

    persistProduct.setName(productName);
    persistProduct.setDescription(productDescription);

    final Product mergeProduct = productWebServiceRepository.merge(metaData, persistProduct);

    Assert.assertTrue("Product id has no value bigger than zero.", mergeProduct.getId() > 0);
    Assert.assertEquals("Product name is not equal.", productName, mergeProduct.getName());
    Assert.assertEquals("Product description is not equal.", productDescription, mergeProduct.getDescription());
  }

  @Test
  public void testPersistProduct() throws GNUOpenBusinessServiceException_Exception {
    final String productName = product.getName();
    final String productDescription = product.getDescription();

    final Product persistProduct = productWebServiceRepository.persist(metaData, product);

    Assert.assertTrue("Product id has no value bigger than zero.", persistProduct.getId() > 0);
    Assert.assertEquals("Product name is not equal.", productName, persistProduct.getName());
    Assert.assertEquals("Product description is not equal.", productDescription, persistProduct.getDescription());
  }

  @Test
  public void testRemoveProduct() throws GNUOpenBusinessServiceException_Exception {
    final Product persistProduct = productWebServiceRepository.persist(metaData, product);
    productWebServiceRepository.remove(metaData, persistProduct);

    final Product findProduct = productWebServiceRepository.find(metaData, product);

    Assert.assertNull("Product is found.", findProduct);
  }
}
