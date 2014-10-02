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
import com.netbrasoft.gnuob.api.product.ProductWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
public class ProductWebServiceRepositoryTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return Utils.createDeployment();
	}

	private ProductWebServiceRepository productWebServiceRepository = new ProductWebServiceRepository();
	private MetaData metaData = null;
	private Product product = null;

	@Before
	public void init() throws GNUOpenBusinessServiceException_Exception {

	}

	@Before
	public void testBefore() {
		Random randomGenerator = new Random();

		metaData = new MetaData();

		metaData.setUser("administrator");
		metaData.setPassword("administrator");
		metaData.setSite("www.netbrasoft.com");

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

		Stock stock = new Stock();
		stock.setMaxQuantity(BigInteger.valueOf(100));
		stock.setMinQuantity(BigInteger.ZERO);
		stock.setQuantity(BigInteger.valueOf(30));

		product.setStock(stock);
	}

	@Test
	public void testFindProduct() throws GNUOpenBusinessServiceException_Exception {
		Product persistProduct = productWebServiceRepository.persist(metaData, product);

		Paging paging = new Paging();

		paging.setFirst(-1);
		paging.setMax(-1);

		List<Product> products = productWebServiceRepository.find(metaData, persistProduct, paging, OrderBy.NONE);

		Assert.assertTrue("Find products has no value bigger than 1.", products.size() == 1);
	}

	@Test
	public void testPersistProduct() throws GNUOpenBusinessServiceException_Exception {
		String productName = product.getName();
		String productDescription = product.getDescription();

		Product persistProduct = productWebServiceRepository.persist(metaData, product);

		Assert.assertTrue("Product id has no value bigger than zero.", persistProduct.getId() > 0);
		Assert.assertEquals("Product name is not equal.", productName, persistProduct.getName());
		Assert.assertEquals("Product description is not equal.", productDescription, persistProduct.getDescription());
	}
}
