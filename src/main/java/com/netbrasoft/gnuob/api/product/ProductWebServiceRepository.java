package com.netbrasoft.gnuob.api.product;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountProduct;
import com.netbrasoft.gnuob.api.CountProductResponse;
import com.netbrasoft.gnuob.api.FindProduct;
import com.netbrasoft.gnuob.api.FindProductById;
import com.netbrasoft.gnuob.api.FindProductByIdResponse;
import com.netbrasoft.gnuob.api.FindProductResponse;
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
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository("ProductWebServiceRepository")
public class ProductWebServiceRepository<P extends Product> implements GenericTypeWebServiceRepository<P> {

   private ProductWebServiceImpl productWebServiceImpl;

   public ProductWebServiceRepository() {
   }

   @Override
   public long count(MetaData paramMetaData, P paramProduct) {
      CountProduct paramCountProduct = new CountProduct();
      paramCountProduct.setProduct(paramProduct);
      CountProductResponse countProductResponse = getProductWebServiceImpl().countProduct(paramCountProduct, paramMetaData);
      return countProductResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public P find(MetaData paramMetaData, P paramProduct) {
      FindProductById paramFindProductById = new FindProductById();
      paramFindProductById.setProduct(paramProduct);
      FindProductByIdResponse findProductByIdResponse = getProductWebServiceImpl().findProductById(paramFindProductById, paramMetaData);
      return (P) findProductByIdResponse.getReturn();

   }

   @SuppressWarnings("unchecked")
   @Override
   public List<P> find(MetaData paramMetaData, P paramProduct, Paging paramPaging, OrderBy paramOrderBy) {
      FindProduct paramFindProduct = new FindProduct();
      paramFindProduct.setProduct(paramProduct);
      paramFindProduct.setPaging(paramPaging);
      paramFindProduct.setOrderBy(paramOrderBy);
      FindProductResponse findProductResponse = getProductWebServiceImpl().findProduct(paramFindProduct, paramMetaData);

      return (List<P>) findProductResponse.getReturn();
   }

   private ProductWebServiceImpl getProductWebServiceImpl() {
      if (productWebServiceImpl == null) {
         ProductWebServiceImplService productWebServiceImplService = new ProductWebServiceImplService(ProductWebServiceImplService.WSDL_LOCATION);
         productWebServiceImpl = productWebServiceImplService.getProductWebServiceImplPort();
      }

      return productWebServiceImpl;
   }

   @SuppressWarnings("unchecked")
   @Override
   public P merge(MetaData paramMetaData, P paramProduct) {
      MergeProduct paramMergeProduct = new MergeProduct();
      paramMergeProduct.setProduct(paramProduct);
      MergeProductResponse mergeProductResponse = getProductWebServiceImpl().mergeProduct(paramMergeProduct, paramMetaData);
      return (P) mergeProductResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public P persist(MetaData paramMetaData, P paramProduct) {
      PersistProduct paramPersistProduct = new PersistProduct();
      paramPersistProduct.setProduct(paramProduct);
      PersistProductResponse persistProductResponse = getProductWebServiceImpl().persistProduct(paramPersistProduct, paramMetaData);
      return (P) persistProductResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public P refresh(MetaData paramMetaData, P paramProduct) {
      RefreshProduct paramRefresProduct = new RefreshProduct();
      paramRefresProduct.setProduct(paramProduct);
      RefreshProductResponse refresProductResponse = getProductWebServiceImpl().refreshProduct(paramRefresProduct, paramMetaData);
      return (P) refresProductResponse.getReturn();
   }

   @Override
   public void remove(MetaData paramMetaData, P paramProduct) {
      RemoveProduct paramRemoveProduct = new RemoveProduct();
      paramRemoveProduct.setProduct(paramProduct);
      getProductWebServiceImpl().removeProduct(paramRemoveProduct, paramMetaData);
   }
}
