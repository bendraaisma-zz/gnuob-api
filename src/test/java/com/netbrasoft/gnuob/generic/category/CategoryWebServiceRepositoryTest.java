package com.netbrasoft.gnuob.generic.category;

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

import com.netbrasoft.gnuob.api.Category;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.SubCategory;
import com.netbrasoft.gnuob.api.category.CategoryWebServiceRepository;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
public class CategoryWebServiceRepositoryTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return Utils.createDeployment();
    }

    private CategoryWebServiceRepository categoryWebServiceRepository = new CategoryWebServiceRepository();
    private MetaData metaData = null;
    private Category category = null;
    private SubCategory subCategory = null;

    @Before
    public void testBefore() {
        new Random();

        metaData = new MetaData();
        category = new Category();
        subCategory = new SubCategory();

        metaData.setUser("administrator");
        metaData.setPassword("administrator");
        metaData.setSite("www.netbrasoft.com");

        category.setName(UUID.randomUUID().toString());
        category.setDescription(UUID.randomUUID().toString());

        subCategory.setName(UUID.randomUUID().toString());
        subCategory.setDescription(UUID.randomUUID().toString());

        category.getSubCategories().add(subCategory);
    }

    @Test
    public void testFindBySubCategoryName() throws GNUOpenBusinessServiceException_Exception {
        String categoryName = category.getName();
        String categoryDescription = category.getDescription();

        Category persistCategory = categoryWebServiceRepository.persist(metaData, category);

        Paging paging = new Paging();

        paging.setFirst(-1);
        paging.setMax(-1);

        SubCategory subCategory = new SubCategory();
        subCategory.setName(persistCategory.getSubCategories().iterator().next().getName());

        Category category = new Category();
        category.getSubCategories().add(subCategory);

        List<Category> findCategories = categoryWebServiceRepository.find(metaData, category, paging, OrderBy.NONE);

        Assert.assertTrue("Find categories has no value bigger than 1.", findCategories.size() == 1);

        Category findCategory = findCategories.iterator().next();

        Assert.assertTrue("Category id has no value bigger than zero.", findCategory.getId() > 0);
        Assert.assertEquals("Category name is not equal.", categoryName, findCategory.getName());
        Assert.assertEquals("Category description is not equal.", categoryDescription, findCategory.getDescription());
    }

    @Test
    public void testMergeProduct() throws GNUOpenBusinessServiceException_Exception {
        String categoryName = UUID.randomUUID().toString();
        String categoryDescription = UUID.randomUUID().toString();

        Category persistCategory = categoryWebServiceRepository.persist(metaData, category);

        persistCategory.setName(categoryName);
        persistCategory.setDescription(categoryDescription);

        Category mergeCategory = categoryWebServiceRepository.merge(metaData, persistCategory);

        Assert.assertTrue("Category id has no value bigger than zero.", mergeCategory.getId() > 0);
        Assert.assertEquals("Category name is not equal.", categoryName, mergeCategory.getName());
        Assert.assertEquals("Category description is not equal.", categoryDescription, mergeCategory.getDescription());

        Assert.assertTrue("Category contains 1 subCategory", category.getSubCategories().size() == 1);
    }

    @Test
    public void testPersistCategory() throws GNUOpenBusinessServiceException_Exception {
        String categoryName = category.getName();
        String categoryDescription = category.getDescription();

        Category persistCategory = categoryWebServiceRepository.persist(metaData, category);

        Assert.assertTrue("Category id has no value bigger than zero.", persistCategory.getId() > 0);
        Assert.assertEquals("Category name is not equal.", categoryName, persistCategory.getName());
        Assert.assertEquals("Category description is not equal.", categoryDescription, persistCategory.getDescription());

        Assert.assertTrue("Category contains 1 subCategory", category.getSubCategories().size() == 1);
    }

    @Test
    public void testRemoveProduct() throws GNUOpenBusinessServiceException_Exception {
        Category persistCategory = categoryWebServiceRepository.persist(metaData, category);
        categoryWebServiceRepository.remove(metaData, persistCategory);

        Category findCategory = categoryWebServiceRepository.find(metaData, category);

        Assert.assertNull("Category is found.", findCategory);
    }

    // @Test()
    public void testTotalNumberOfCategories() throws GNUOpenBusinessServiceException_Exception {
        Paging paging = new Paging();
        paging.setFirst(-1);
        paging.setMax(-1);

        List<Category> findCategories = categoryWebServiceRepository.find(metaData, new Category(), paging, OrderBy.NONE);

        Assert.assertTrue("Find categories has no value bigger than 3.", findCategories.size() == 3);
    }
}
