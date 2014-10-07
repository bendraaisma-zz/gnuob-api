package com.netbrasoft.gnuob.api.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountProduct;
import com.netbrasoft.gnuob.api.CountProductResponse;
import com.netbrasoft.gnuob.api.FindProduct;
import com.netbrasoft.gnuob.api.FindProductById;
import com.netbrasoft.gnuob.api.FindProductByIdResponse;
import com.netbrasoft.gnuob.api.FindProductResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MergeProduct;
import com.netbrasoft.gnuob.api.MergeProductResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistProduct;
import com.netbrasoft.gnuob.api.PersistProductResponse;
import com.netbrasoft.gnuob.api.Product;
import com.netbrasoft.gnuob.api.ProductWebServiceImpl;
import com.netbrasoft.gnuob.api.ProductWebServiceImplService;
import com.netbrasoft.gnuob.api.RefreshProduct;
import com.netbrasoft.gnuob.api.RefreshProductResponse;
import com.netbrasoft.gnuob.api.RemoveProduct;

@Repository("ProductWebServiceRepository")
public class ProductWebServiceRepository {

    private ProductWebServiceImpl productWebServiceImpl;

    public ProductWebServiceRepository() {
    }

    public long count(MetaData paramMetaData, Product paramProduct) throws GNUOpenBusinessServiceException_Exception {
        CountProduct paramCountProduct = new CountProduct();
        paramCountProduct.setProduct(paramProduct);
        CountProductResponse countProductResponse = getProductWebServiceImpl().countProduct(paramCountProduct, paramMetaData);
        return countProductResponse.getReturn();
    }

    public Product find(MetaData paramMetaData, Product paramProduct) throws GNUOpenBusinessServiceException_Exception {
        FindProductById paramFindProductById = new FindProductById();
        paramFindProductById.setProduct(paramProduct);
        FindProductByIdResponse findProductByIdResponse = getProductWebServiceImpl().findProductById(paramFindProductById, paramMetaData);
        return findProductByIdResponse.getReturn();

    }

    public List<Product> find(MetaData paramMetaData, Product paramProduct, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
        FindProduct paramFindProduct = new FindProduct();
        paramFindProduct.setProduct(paramProduct);
        paramFindProduct.setPaging(paramPaging);
        paramFindProduct.setOrderBy(paramOrderBy);
        FindProductResponse findProductResponse = getProductWebServiceImpl().findProduct(paramFindProduct, paramMetaData);

        return findProductResponse.getReturn();
    }

    private ProductWebServiceImpl getProductWebServiceImpl() {
        if (productWebServiceImpl == null) {
            ProductWebServiceImplService productWebServiceImplService = new ProductWebServiceImplService(ProductWebServiceImplService.WSDL_LOCATION);
            productWebServiceImpl = productWebServiceImplService.getProductWebServiceImplPort();
        }

        return productWebServiceImpl;
    }

    public Product merge(MetaData paramMetaData, Product paramProduct) throws GNUOpenBusinessServiceException_Exception {
        MergeProduct paramMergeProduct = new MergeProduct();
        paramMergeProduct.setProduct(paramProduct);
        MergeProductResponse mergeProductResponse = getProductWebServiceImpl().mergeProduct(paramMergeProduct, paramMetaData);
        return mergeProductResponse.getReturn();
    }

    public Product persist(MetaData paramMetaData, Product paramProduct) throws GNUOpenBusinessServiceException_Exception {
        PersistProduct paramPersistProduct = new PersistProduct();
        paramPersistProduct.setProduct(paramProduct);
        PersistProductResponse persistProductResponse = getProductWebServiceImpl().persistProduct(paramPersistProduct, paramMetaData);
        return persistProductResponse.getReturn();
    }

    public Product refresh(MetaData paramMetaData, Product paramProduct) throws GNUOpenBusinessServiceException_Exception {
        RefreshProduct paramRefresProduct = new RefreshProduct();
        paramRefresProduct.setProduct(paramProduct);
        RefreshProductResponse refresProductResponse = getProductWebServiceImpl().refreshProduct(paramRefresProduct, paramMetaData);
        return refresProductResponse.getReturn();
    }

    public void remove(MetaData paramMetaData, Product paramProduct) throws GNUOpenBusinessServiceException_Exception {
        RemoveProduct paramRemoveProduct = new RemoveProduct();
        paramRemoveProduct.setProduct(paramProduct);
        getProductWebServiceImpl().removeProduct(paramRemoveProduct, paramMetaData);
    }
}
