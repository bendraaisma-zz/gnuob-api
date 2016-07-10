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

package br.com.netbrasoft.gnuob.api.product;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PRODUCT_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.product.ProductWebServiceWrapperHelper.wrapToCountProduc;
import static br.com.netbrasoft.gnuob.api.product.ProductWebServiceWrapperHelper.wrapToFindProduct;
import static br.com.netbrasoft.gnuob.api.product.ProductWebServiceWrapperHelper.wrapToFindProductById;
import static br.com.netbrasoft.gnuob.api.product.ProductWebServiceWrapperHelper.wrapToMergeProduct;
import static br.com.netbrasoft.gnuob.api.product.ProductWebServiceWrapperHelper.wrapToPersistProduct;
import static br.com.netbrasoft.gnuob.api.product.ProductWebServiceWrapperHelper.wrapToRefreshProduct;
import static br.com.netbrasoft.gnuob.api.product.ProductWebServiceWrapperHelper.wrapToRemoveProduct;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.Product;
import br.com.netbrasoft.gnuob.api.ProductWebServiceImpl;
import br.com.netbrasoft.gnuob.api.ProductWebServiceImplService;

import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(PRODUCT_WEB_SERVICE_REPOSITORY_NAME)
public class ProductWebServiceRepository<P extends Product> implements IGenericTypeWebServiceRepository<P> {

  private transient ProductWebServiceImpl productWebServiceImpl;

  private ProductWebServiceImpl getProductWebServiceImpl() {
    if (productWebServiceImpl == null) {
      productWebServiceImpl = new ProductWebServiceImplService().getProductWebServiceImplPort();
    }
    return productWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final P productExample) {
    return getProductWebServiceImpl().countProduct(wrapToCountProduc(productExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<P> find(final MetaData credentials, final P productExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<P>) getProductWebServiceImpl()
        .findProduct(wrapToFindProduct(productExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P find(final MetaData credentials, final P productExample) {
    return (P) getProductWebServiceImpl().findProductById(wrapToFindProductById(productExample), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P persist(final MetaData credentials, final P product) {
    return (P) getProductWebServiceImpl().persistProduct(wrapToPersistProduct(product), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P merge(final MetaData credentials, final P product) {
    return (P) getProductWebServiceImpl().mergeProduct(wrapToMergeProduct(product), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P refresh(final MetaData credentials, final P product) {
    return (P) getProductWebServiceImpl().refreshProduct(wrapToRefreshProduct(product), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final P product) {
    getProductWebServiceImpl().removeProduct(wrapToRemoveProduct(product), credentials);
  }
}
