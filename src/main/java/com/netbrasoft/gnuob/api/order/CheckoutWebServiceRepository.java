package com.netbrasoft.gnuob.api.order;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;

public interface CheckoutWebServiceRepository<O extends Order> {

  O doCheckout(MetaData metaData, O order);

  O doCheckoutDetails(MetaData metaData, O order);

  O doCheckoutPayment(MetaData metaData, O order);

  O doNotification(MetaData metaData, O order);

  O doRefundTransaction(MetaData metaData, O order);

  O doTransactionDetails(MetaData metaData, O order);
}
