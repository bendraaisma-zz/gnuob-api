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

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_DATA_PROVIDER_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_WEB_SERVICE_REPOSITORY_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PAY_PAL_EXPRESS_CHECK_OUT_WEB_SERVICE_REPOSITORY_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Controller(ORDER_DATA_PROVIDER_NAME)
public class OrderDataProvider<O extends Order> extends AbstractGenericTypeDataProvider<O>
    implements IGenericOrderCheckoutDataProvider<O> {

  public enum PaymentProviderEnum {
    PAY_PAL, PAGSEGURO;
  }

  private static final long serialVersionUID = 1434788743241708993L;

  @Resource(name = ORDER_WEB_SERVICE_REPOSITORY_NAME)
  private transient IGenericTypeWebServiceRepository<O> orderWebServiceRepository;

  @Resource(name = PAY_PAL_EXPRESS_CHECK_OUT_WEB_SERVICE_REPOSITORY_NAME)
  private transient ICheckoutWebServiceRepository<O> payPalExpressCheckoutWebServiceRepository;

  @Resource(name = PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY)
  private transient ICheckoutWebServiceRepository<O> pagseguroCheckoutWebServiceRepository;

  private PaymentProviderEnum paymentProvider;

  @SuppressWarnings(UNCHECKED_VALUE)
  public OrderDataProvider() {
    super((O) new Order());
    paymentProvider = PaymentProviderEnum.PAY_PAL;
  }

  @Override
  public O doCheckout(final O orderType) {
    if (PaymentProviderEnum.PAGSEGURO == paymentProvider) {
      return pagseguroCheckoutWebServiceRepository.doCheckout(getCredentials(), orderType);
    }
    return payPalExpressCheckoutWebServiceRepository.doCheckout(getCredentials(), orderType);
  }

  @Override
  public O doCheckoutDetails(final O orderType) {
    if (PaymentProviderEnum.PAGSEGURO == paymentProvider) {
      return pagseguroCheckoutWebServiceRepository.doCheckoutDetails(getCredentials(), orderType);
    }
    return payPalExpressCheckoutWebServiceRepository.doCheckoutDetails(getCredentials(), orderType);
  }

  @Override
  public O doCheckoutPayment(final O orderType) {
    if (PaymentProviderEnum.PAGSEGURO == paymentProvider) {
      return pagseguroCheckoutWebServiceRepository.doCheckoutPayment(getCredentials(), orderType);
    }
    return payPalExpressCheckoutWebServiceRepository.doCheckoutPayment(getCredentials(), orderType);
  }

  @Override
  public O doNotification(final O orderType) {
    if (PaymentProviderEnum.PAGSEGURO == paymentProvider) {
      return pagseguroCheckoutWebServiceRepository.doNotification(getCredentials(), orderType);
    }
    return payPalExpressCheckoutWebServiceRepository.doNotification(getCredentials(), orderType);
  }

  @Override
  public O doRefundTransaction(final O orderType) {
    if (PaymentProviderEnum.PAGSEGURO == paymentProvider) {
      return pagseguroCheckoutWebServiceRepository.doRefundTransaction(getCredentials(), orderType);
    }
    return payPalExpressCheckoutWebServiceRepository.doRefundTransaction(getCredentials(), orderType);
  }

  @Override
  public O doTransactionDetails(final O orderType) {
    if (PaymentProviderEnum.PAGSEGURO == paymentProvider) {
      return pagseguroCheckoutWebServiceRepository.doTransactionDetails(getCredentials(), orderType);
    }
    return payPalExpressCheckoutWebServiceRepository.doTransactionDetails(getCredentials(), orderType);
  }

  @Override
  public PaymentProviderEnum getPaymentProvider() {
    return paymentProvider;
  }

  @Override
  public void setPaymentProvider(final PaymentProviderEnum paymentProvider) {
    this.paymentProvider = paymentProvider;
  }

  @Override
  public IGenericTypeWebServiceRepository<O> getGenericTypeWebServiceRepository() {
    return orderWebServiceRepository;
  }
}
