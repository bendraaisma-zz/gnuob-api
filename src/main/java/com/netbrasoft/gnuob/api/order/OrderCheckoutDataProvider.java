package com.netbrasoft.gnuob.api.order;

import com.netbrasoft.gnuob.api.Order;

public interface OrderCheckoutDataProvider<O extends Order> {

   O doCheckout(O paramOrder);

   O doCheckoutDetails(O paramOrder);

   O doCheckoutPayment(O paramOrder);
}
