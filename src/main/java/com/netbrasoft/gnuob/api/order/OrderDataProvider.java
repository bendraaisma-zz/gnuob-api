package com.netbrasoft.gnuob.api.order;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller(OrderDataProvider.ORDER_DATA_PROVIDER_NAME)
public class OrderDataProvider<O extends Order> extends AbstractGenericTypeDataProvider<O> implements GenericOrderCheckoutDataProvider<O> {

  public enum CheckOut {
    PAY_PAL, PAGSEGURO;

    public static CheckOut fromValue(final String value) {
      return valueOf(value);
    }

    public String value() {
      return name();
    }
  }

  public static final String ORDER_DATA_PROVIDER_NAME = "OrderDataProvider";

  private static final long serialVersionUID = 1434788743241708993L;

  @Resource(name = OrderWebServiceRepository.ORDER_WEB_SERVICE_REPOSITORY_NAME)
  private transient GenericTypeWebServiceRepository<O> orderWebServiceRepository;

  @Resource(name = PayPalExpressCheckOutWebServiceRepository.PAY_PAL_EXPRESS_CHECK_OUT_WEB_SERVICE_REPOSITORY_NAME)
  private transient CheckoutWebServiceRepository<O> payPalExpressCheckoutWebServiceRepository;

  @Resource(name = PagseguroCheckOutWebServiceRepository.PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY)
  private transient CheckoutWebServiceRepository<O> pagseguroCheckoutWebServiceRepository;

  private CheckOut checkOut;

  @SuppressWarnings("unchecked")
  public OrderDataProvider() {
    super((O) new Order());
    checkOut = CheckOut.PAY_PAL;
  }

  @Override
  public O doCheckout(final O paramOrder) {
    if (checkOut == CheckOut.PAGSEGURO) {
      return pagseguroCheckoutWebServiceRepository.doCheckout(metaData, paramOrder);
    }
    return payPalExpressCheckoutWebServiceRepository.doCheckout(metaData, paramOrder);
  }

  @Override
  public O doCheckoutDetails(final O paramOrder) {
    if (checkOut == CheckOut.PAGSEGURO) {
      return pagseguroCheckoutWebServiceRepository.doCheckoutDetails(metaData, paramOrder);
    }
    return payPalExpressCheckoutWebServiceRepository.doCheckoutDetails(metaData, paramOrder);
  }

  @Override
  public O doCheckoutPayment(final O paramOrder) {
    if (checkOut == CheckOut.PAGSEGURO) {
      return pagseguroCheckoutWebServiceRepository.doCheckoutPayment(metaData, paramOrder);
    }
    return payPalExpressCheckoutWebServiceRepository.doCheckoutPayment(metaData, paramOrder);
  }

  @Override
  public O doNotification(final O paramOrder) {
    if (checkOut == CheckOut.PAGSEGURO) {
      return pagseguroCheckoutWebServiceRepository.doNotification(metaData, paramOrder);
    }
    return payPalExpressCheckoutWebServiceRepository.doNotification(metaData, paramOrder);
  }

  @Override
  public O doRefundTransaction(final O paramOrder) {
    if (checkOut == CheckOut.PAGSEGURO) {
      return pagseguroCheckoutWebServiceRepository.doRefundTransaction(metaData, paramOrder);
    }
    return payPalExpressCheckoutWebServiceRepository.doRefundTransaction(metaData, paramOrder);
  }

  @Override
  public O doTransactionDetails(final O paramOrder) {
    if (checkOut == CheckOut.PAGSEGURO) {
      return pagseguroCheckoutWebServiceRepository.doTransactionDetails(metaData, paramOrder);
    }
    return payPalExpressCheckoutWebServiceRepository.doTransactionDetails(metaData, paramOrder);
  }

  @Override
  public CheckOut getCheckOut() {
    return checkOut;
  }

  @Override
  public GenericTypeWebServiceRepository<O> getGenericTypeWebServiceRepository() {
    return orderWebServiceRepository;
  }

  @Override
  public void setCheckOut(final CheckOut checkOut) {
    this.checkOut = checkOut;
  }
}
