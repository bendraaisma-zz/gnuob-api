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

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PRODUCT_DATA_PROVIDER_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PRODUCT_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import br.com.netbrasoft.gnuob.api.Product;

import br.com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Controller(PRODUCT_DATA_PROVIDER_NAME)
public class ProductDataProvider<P extends Product> extends AbstractGenericTypeDataProvider<P> {

  private static final long serialVersionUID = -8167982674192813819L;

  @Resource(name = PRODUCT_WEB_SERVICE_REPOSITORY_NAME)
  private transient IGenericTypeWebServiceRepository<P> productWebServiceRepository;

  @SuppressWarnings(UNCHECKED_VALUE)
  public ProductDataProvider() {
    super((P) new Product());
  }

  @Override
  public IGenericTypeWebServiceRepository<P> getGenericTypeWebServiceRepository() {
    return productWebServiceRepository;
  }
}
