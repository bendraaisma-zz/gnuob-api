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

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PAY_PAL_EXPRESS_CHECK_OUT_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckout;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckoutDetails;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckoutPayment;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoNotification;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoRefundTransaction;
import static br.com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoTransactionDetails;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.Order;
import br.com.netbrasoft.gnuob.api.PayPalExpressCheckOutWebServiceImpl;
import br.com.netbrasoft.gnuob.api.PayPalExpressCheckOutWebServiceImplService;

@Monitored
@Repository(PAY_PAL_EXPRESS_CHECK_OUT_WEB_SERVICE_REPOSITORY_NAME)
public class PayPalExpressCheckOutWebServiceRepository<O extends Order> implements ICheckoutWebServiceRepository<O> {

  private transient PayPalExpressCheckOutWebServiceImpl payPalExpressCheckOutWebServiceImpl = null;

  private PayPalExpressCheckOutWebServiceImpl getPayPalExpressCheckOutWebServiceImpl() {
    if (payPalExpressCheckOutWebServiceImpl == null) {
      payPalExpressCheckOutWebServiceImpl =
          new PayPalExpressCheckOutWebServiceImplService().getPayPalExpressCheckOutWebServiceImplPort();
    }
    return payPalExpressCheckOutWebServiceImpl;
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doCheckout(final MetaData credentials, final O orderType) {
    return (O) getPayPalExpressCheckOutWebServiceImpl().doCheckout(wrapToDoCheckout(orderType), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doCheckoutDetails(final MetaData credentials, final O orderType) {
    return (O) getPayPalExpressCheckOutWebServiceImpl()
        .doCheckoutDetails(wrapToDoCheckoutDetails(orderType), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doCheckoutPayment(final MetaData credentials, final O orderType) {
    return (O) getPayPalExpressCheckOutWebServiceImpl()
        .doCheckoutPayment(wrapToDoCheckoutPayment(orderType), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doNotification(final MetaData credentials, final O orderType) {
    return (O) getPayPalExpressCheckOutWebServiceImpl().doNotification(wrapToDoNotification(orderType), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doRefundTransaction(final MetaData credentials, final O orderType) {
    return (O) getPayPalExpressCheckOutWebServiceImpl()
        .doRefundTransaction(wrapToDoRefundTransaction(orderType), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O doTransactionDetails(final MetaData credentials, final O orderType) {
    return (O) getPayPalExpressCheckOutWebServiceImpl()
        .doTransactionDetails(wrapToDoTransactionDetails(orderType), credentials).getReturn();
  }
}
