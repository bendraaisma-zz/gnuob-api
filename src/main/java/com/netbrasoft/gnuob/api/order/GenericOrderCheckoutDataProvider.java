package com.netbrasoft.gnuob.api.order;

import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.generic.GenericTypeDataProvider;
import com.netbrasoft.gnuob.api.order.OrderDataProvider.CheckOut;

public interface GenericOrderCheckoutDataProvider<O extends Order> extends GenericTypeDataProvider<O> {

  O doCheckout(O paramOrder);

  O doCheckoutDetails(O paramOrder);

  O doCheckoutPayment(O paramOrder);

  O doNotification(O paramOrder);

  O doRefundTransaction(O paramOrder);

  O doTransactionDetails(O paramOrder);

  CheckOut getCheckOut();

  void setCheckOut(CheckOut checkOut);
}
