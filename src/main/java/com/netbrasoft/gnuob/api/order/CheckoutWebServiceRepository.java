package com.netbrasoft.gnuob.api.order;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;

public interface CheckoutWebServiceRepository<O extends Order> {

   O doCheckout(MetaData paramMetaData, O paramOrder);

   O doCheckoutDetails(MetaData paramMetaData, O paramOrder);

   O doCheckoutPayment(MetaData paramMetaData, O paramOrder);
}
