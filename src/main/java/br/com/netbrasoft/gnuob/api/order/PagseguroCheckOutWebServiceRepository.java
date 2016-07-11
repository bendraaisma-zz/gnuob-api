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

package br.com.netbrasoft.gnuob.api.order;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GNUOB_SOAP_ORDER_PAGSEGURO_WEBSERVICE_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.HTTP_LOCALHOST_8080_GNUOB_SOAP_ORDER_PAGSEGURO_WEB_SERVICE_IMPL_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckout;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckoutDetails;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckoutPayment;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoNotification;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoRefundTransaction;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoTransactionDetails;
import static java.lang.System.getProperty;
import static org.slf4j.LoggerFactory.getLogger;

import java.net.MalformedURLException;
import java.net.URL;

import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.Order;
import br.com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImpl;
import br.com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImplService;

@Monitored
@Repository(PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY)
public class PagseguroCheckOutWebServiceRepository<O extends Order> implements ICheckoutWebServiceRepository<O> {

  private static final Logger LOGGER = getLogger(PagseguroCheckOutWebServiceRepository.class);
  private static final URL WSDL_LOCATION;

  static {
    URL url = null;
    try {
      url = new URL(getProperty(GNUOB_SOAP_ORDER_PAGSEGURO_WEBSERVICE_WSDL,
          HTTP_LOCALHOST_8080_GNUOB_SOAP_ORDER_PAGSEGURO_WEB_SERVICE_IMPL_WSDL));
    } catch (final MalformedURLException e) {
      LOGGER.info(CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0, getProperty(GNUOB_SOAP_ORDER_PAGSEGURO_WEBSERVICE_WSDL,
          HTTP_LOCALHOST_8080_GNUOB_SOAP_ORDER_PAGSEGURO_WEB_SERVICE_IMPL_WSDL));
    }
    WSDL_LOCATION = url;
  }

  private transient PagseguroCheckOutWebServiceImpl pagseguroCheckOutWebServiceImpl = null;

  private PagseguroCheckOutWebServiceImpl getPagseguroCheckOutWebServiceImpl() {
    if (pagseguroCheckOutWebServiceImpl == null) {
      pagseguroCheckOutWebServiceImpl =
          new PagseguroCheckOutWebServiceImplService(WSDL_LOCATION).getPagseguroCheckOutWebServiceImplPort();
    }
    return pagseguroCheckOutWebServiceImpl;
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doCheckout(final MetaData credentials, final O orderType) {
    return (O) getPagseguroCheckOutWebServiceImpl().doCheckout(wrapToDoCheckout(orderType), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doCheckoutDetails(final MetaData credentials, final O orderType) {
    return (O) getPagseguroCheckOutWebServiceImpl().doCheckoutDetails(wrapToDoCheckoutDetails(orderType), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doCheckoutPayment(final MetaData credentials, final O orderType) {
    return (O) getPagseguroCheckOutWebServiceImpl().doCheckoutPayment(wrapToDoCheckoutPayment(orderType), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doNotification(final MetaData credentials, final O orderType) {
    return (O) getPagseguroCheckOutWebServiceImpl().doNotification(wrapToDoNotification(orderType), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doRefundTransaction(final MetaData credentials, final O orderType) {
    return (O) getPagseguroCheckOutWebServiceImpl()
        .doRefundTransaction(wrapToDoRefundTransaction(orderType), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doTransactionDetails(final MetaData credentials, final O orderType) {
    return (O) getPagseguroCheckOutWebServiceImpl()
        .doTransactionDetails(wrapToDoTransactionDetails(orderType), credentials).getReturn();
  }
}
