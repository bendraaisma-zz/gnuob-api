package com.netbrasoft.gnuob.api.order;

import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.order.OrderDataProvider.PaymentProviderEnum;

public abstract interface IGenericOrderCheckoutDataProvider<O extends Order> extends IGenericTypeDataProvider<O> {

  public abstract O doCheckout(O orderType);

  public abstract O doCheckoutDetails(O orderType);

  public abstract O doCheckoutPayment(O orderType);

  public abstract O doNotification(O orderType);

  public abstract O doRefundTransaction(O orderType);

  public abstract O doTransactionDetails(O orderType);

  public abstract PaymentProviderEnum getPaymentProvider();

  public abstract void setPaymentProvider(PaymentProviderEnum provider);
}
