package com.netbrasoft.gnuob.api.order;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.DoCheckout;
import com.netbrasoft.gnuob.api.DoCheckoutDetails;
import com.netbrasoft.gnuob.api.DoCheckoutDetailsResponse;
import com.netbrasoft.gnuob.api.DoCheckoutPayment;
import com.netbrasoft.gnuob.api.DoCheckoutPaymentResponse;
import com.netbrasoft.gnuob.api.DoCheckoutResponse;
import com.netbrasoft.gnuob.api.DoNotification;
import com.netbrasoft.gnuob.api.DoNotificationResponse;
import com.netbrasoft.gnuob.api.DoRefundTransaction;
import com.netbrasoft.gnuob.api.DoRefundTransactionResponse;
import com.netbrasoft.gnuob.api.DoTransactionDetails;
import com.netbrasoft.gnuob.api.DoTransactionDetailsResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImpl;
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImplService;

@Monitored
@Repository(PagseguroCheckOutWebServiceRepository.PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY)
public class PagseguroCheckOutWebServiceRepository<O extends Order> implements CheckoutWebServiceRepository<O> {

  protected static final String PAGSEGURO_CHECK_OUT_WEB_SERVICE_REPOSITORY = "PagseguroCheckOutWebServiceRepository";

  private PagseguroCheckOutWebServiceImpl pagseguroCheckOutWebServiceImpl = null;

  public PagseguroCheckOutWebServiceRepository() {
    // Empty constructor.
  }

  @SuppressWarnings("unchecked")
  @Override
  public O doCheckout(final MetaData metaData, final O order) {
    final DoCheckout paramDoCheckout = new DoCheckout();
    paramDoCheckout.setOrder(order);
    final DoCheckoutResponse doCheckoutResponse = getPagseguroCheckOutWebServiceImpl().doCheckout(paramDoCheckout, metaData);
    return (O) doCheckoutResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O doCheckoutDetails(final MetaData metaData, final O order) {
    final DoCheckoutDetails paramDoCheckoutDetails = new DoCheckoutDetails();
    paramDoCheckoutDetails.setOrder(order);
    final DoCheckoutDetailsResponse doCheckoutDetailsResponse = getPagseguroCheckOutWebServiceImpl().doCheckoutDetails(paramDoCheckoutDetails, metaData);
    return (O) doCheckoutDetailsResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O doCheckoutPayment(final MetaData metaData, final O order) {
    final DoCheckoutPayment paramDoCheckoutPayment = new DoCheckoutPayment();
    paramDoCheckoutPayment.setOrder(order);
    final DoCheckoutPaymentResponse doCheckoutPaymentResponse = getPagseguroCheckOutWebServiceImpl().doCheckoutPayment(paramDoCheckoutPayment, metaData);
    return (O) doCheckoutPaymentResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O doNotification(final MetaData metaData, final O order) {
    final DoNotification paramDoNotification = new DoNotification();
    paramDoNotification.setOrder(order);
    final DoNotificationResponse doNotificationResponse = getPagseguroCheckOutWebServiceImpl().doNotification(paramDoNotification, metaData);
    return (O) doNotificationResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O doRefundTransaction(final MetaData metaData, final O order) {
    final DoRefundTransaction paramRefundTransaction = new DoRefundTransaction();
    paramRefundTransaction.setOrder(order);
    final DoRefundTransactionResponse doRefundTransactionResponse = getPagseguroCheckOutWebServiceImpl().doRefundTransaction(paramRefundTransaction, metaData);
    return (O) doRefundTransactionResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O doTransactionDetails(final MetaData metaData, final O order) {
    final DoTransactionDetails paramDoTransactionDetails = new DoTransactionDetails();
    paramDoTransactionDetails.setOrder(order);
    final DoTransactionDetailsResponse doTransactionDetailsResponse = getPagseguroCheckOutWebServiceImpl().doTransactionDetails(paramDoTransactionDetails, metaData);
    return (O) doTransactionDetailsResponse.getReturn();
  }

  private PagseguroCheckOutWebServiceImpl getPagseguroCheckOutWebServiceImpl() {
    if (pagseguroCheckOutWebServiceImpl == null) {
      final PagseguroCheckOutWebServiceImplService pagseguroCheckOutWebServiceImplService =
          new PagseguroCheckOutWebServiceImplService(PagseguroCheckOutWebServiceImplService.WSDL_LOCATION);
      pagseguroCheckOutWebServiceImpl = pagseguroCheckOutWebServiceImplService.getPagseguroCheckOutWebServiceImplPort();
    }

    return pagseguroCheckOutWebServiceImpl;
  }
}
