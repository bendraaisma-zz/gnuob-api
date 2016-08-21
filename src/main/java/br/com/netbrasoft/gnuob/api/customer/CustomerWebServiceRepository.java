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

package br.com.netbrasoft.gnuob.api.customer;

import static br.com.netbrasoft.gnuob.api.customer.CustomerWebserviceWrapperHelper.wrapToCountCustomer;
import static br.com.netbrasoft.gnuob.api.customer.CustomerWebserviceWrapperHelper.wrapToFindCustomer;
import static br.com.netbrasoft.gnuob.api.customer.CustomerWebserviceWrapperHelper.wrapToFindCustomerById;
import static br.com.netbrasoft.gnuob.api.customer.CustomerWebserviceWrapperHelper.wrapToMergeCustomer;
import static br.com.netbrasoft.gnuob.api.customer.CustomerWebserviceWrapperHelper.wrapToPersistCustomer;
import static br.com.netbrasoft.gnuob.api.customer.CustomerWebserviceWrapperHelper.wrapToRefreshCustomer;
import static br.com.netbrasoft.gnuob.api.customer.CustomerWebserviceWrapperHelper.wrapToRemoveCustomer;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CUSTOMER_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GNUOB_SOAP_CUSTOMER_WEBSERVICE_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.HTTP_LOCALHOST_8080_GNUOB_SOAP_CUSTOMER_WEB_SERVICE_IMPL_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static java.lang.System.getProperty;
import static org.slf4j.LoggerFactory.getLogger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.Customer;
import br.com.netbrasoft.gnuob.api.CustomerWebServiceImpl;
import br.com.netbrasoft.gnuob.api.CustomerWebServiceImplService;
import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(CUSTOMER_WEB_SERVICE_REPOSITORY_NAME)
public class CustomerWebServiceRepository<C extends Customer> implements IGenericTypeWebServiceRepository<C> {

  private static final Logger LOGGER = getLogger(CustomerWebServiceRepository.class);
  private static final URL WSDL_LOCATION;

  static {
    URL url = null;
    try {
      url = new URL(getProperty(GNUOB_SOAP_CUSTOMER_WEBSERVICE_WSDL,
          HTTP_LOCALHOST_8080_GNUOB_SOAP_CUSTOMER_WEB_SERVICE_IMPL_WSDL));
    } catch (final MalformedURLException e) {
      LOGGER.info(CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0, getProperty(GNUOB_SOAP_CUSTOMER_WEBSERVICE_WSDL,
          HTTP_LOCALHOST_8080_GNUOB_SOAP_CUSTOMER_WEB_SERVICE_IMPL_WSDL));
    }
    WSDL_LOCATION = url;
  }

  private transient CustomerWebServiceImpl customerWebServiceImpl;

  private CustomerWebServiceImpl getCustomerWebServiceImpl() {
    if (customerWebServiceImpl == null) {
      customerWebServiceImpl = new CustomerWebServiceImplService(WSDL_LOCATION).getCustomerWebServiceImplPort();
    }
    return customerWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final C customerExample) {
    return getCustomerWebServiceImpl().countCustomer(wrapToCountCustomer(customerExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<C> find(final MetaData credentials, final C customerExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<C>) getCustomerWebServiceImpl()
        .findCustomer(wrapToFindCustomer(customerExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C find(final MetaData credentials, final C customerExample) {
    return (C) getCustomerWebServiceImpl().findCustomerById(wrapToFindCustomerById(customerExample), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C persist(final MetaData credentials, final C customer) {
    return (C) getCustomerWebServiceImpl().persistCustomer(wrapToPersistCustomer(customer), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C merge(final MetaData credentials, final C customer) {
    return (C) getCustomerWebServiceImpl().mergeCustomer(wrapToMergeCustomer(customer), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C refresh(final MetaData credentials, final C customer) {
    return (C) getCustomerWebServiceImpl().refreshCustomer(wrapToRefreshCustomer(customer), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final C customer) {
    getCustomerWebServiceImpl().removeCustomer(wrapToRemoveCustomer(customer), credentials);
  }
}
