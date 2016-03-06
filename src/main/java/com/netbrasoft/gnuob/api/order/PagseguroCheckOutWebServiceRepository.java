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

package com.netbrasoft.gnuob.api.order;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckout;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckoutDetails;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoCheckoutPayment;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoNotification;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoRefundTransaction;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToDoTransactionDetails;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImpl;
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImplService;

@Monitored
@Repository(PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY)
public class PagseguroCheckOutWebServiceRepository<O extends Order> implements ICheckoutWebServiceRepository<O> {

  private transient PagseguroCheckOutWebServiceImpl pagseguroCheckOutWebServiceImpl = null;

  private PagseguroCheckOutWebServiceImpl getPagseguroCheckOutWebServiceImpl() {
    if (pagseguroCheckOutWebServiceImpl == null) {
      pagseguroCheckOutWebServiceImpl =
          new PagseguroCheckOutWebServiceImplService().getPagseguroCheckOutWebServiceImplPort();
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
