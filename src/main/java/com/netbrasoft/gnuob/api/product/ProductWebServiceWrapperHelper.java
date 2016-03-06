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

package com.netbrasoft.gnuob.api.product;

import com.netbrasoft.gnuob.api.CountProduct;
import com.netbrasoft.gnuob.api.FindProduct;
import com.netbrasoft.gnuob.api.FindProductById;
import com.netbrasoft.gnuob.api.MergeProduct;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistProduct;
import com.netbrasoft.gnuob.api.Product;
import com.netbrasoft.gnuob.api.RefreshProduct;
import com.netbrasoft.gnuob.api.RemoveProduct;

final class ProductWebServiceWrapperHelper {

  private ProductWebServiceWrapperHelper() {}

  static CountProduct wrapToCountProduc(final Product product) {
    final CountProduct paramCountProduct = new CountProduct();
    paramCountProduct.setProduct(product);
    return paramCountProduct;
  }

  static FindProductById wrapToFindProductById(final Product product) {
    final FindProductById paramFindProductById = new FindProductById();
    paramFindProductById.setProduct(product);
    return paramFindProductById;
  }

  static FindProduct wrapToFindProduct(final Product product, final Paging paging, final OrderBy orderingProperty) {
    final FindProduct paramFindProduct = new FindProduct();
    paramFindProduct.setProduct(product);
    paramFindProduct.setPaging(paging);
    paramFindProduct.setOrderBy(orderingProperty);
    return paramFindProduct;
  }

  static MergeProduct wrapToMergeProduct(final Product product) {
    final MergeProduct paramMergeProduct = new MergeProduct();
    paramMergeProduct.setProduct(product);
    return paramMergeProduct;
  }

  static PersistProduct wrapToPersistProduct(final Product product) {
    final PersistProduct paramPersistProduct = new PersistProduct();
    paramPersistProduct.setProduct(product);
    return paramPersistProduct;
  }

  static RefreshProduct wrapToRefreshProduct(final Product product) {
    final RefreshProduct paramRefresProduct = new RefreshProduct();
    paramRefresProduct.setProduct(product);
    return paramRefresProduct;
  }

  static RemoveProduct wrapToRemoveProduct(final Product product) {
    final RemoveProduct paramRemoveProduct = new RemoveProduct();
    paramRemoveProduct.setProduct(product);
    return paramRemoveProduct;
  }
}
