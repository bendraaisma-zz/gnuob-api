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
import com.netbrasoft.gnuob.api.PayPalExpressCheckOutWebServiceImpl;
import com.netbrasoft.gnuob.api.PayPalExpressCheckOutWebServiceImplService;

@Monitored
@Repository("PayPalExpressCheckOutWebServiceRepository")
public class PayPalExpressCheckOutWebServiceRepository<O extends Order> implements CheckoutWebServiceRepository<O> {

   private PayPalExpressCheckOutWebServiceImpl payPalExpressCheckOutWebServiceImpl = null;

   public PayPalExpressCheckOutWebServiceRepository() {
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckout(MetaData paramMetaData, O paramOrder) {
      final DoCheckout paramDoCheckout = new DoCheckout();
      paramDoCheckout.setOrder(paramOrder);
      final DoCheckoutResponse doCheckoutResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckout(paramDoCheckout, paramMetaData);
      return (O) doCheckoutResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckoutDetails(MetaData paramMetaData, O paramOrder) {
      final DoCheckoutDetails paramDoCheckoutDetails = new DoCheckoutDetails();
      paramDoCheckoutDetails.setOrder(paramOrder);
      final DoCheckoutDetailsResponse doCheckoutDetailsResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckoutDetails(paramDoCheckoutDetails, paramMetaData);
      return (O) doCheckoutDetailsResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckoutPayment(MetaData paramMetaData, O paramOrder) {
      final DoCheckoutPayment paramDoCheckoutPayment = new DoCheckoutPayment();
      paramDoCheckoutPayment.setOrder(paramOrder);
      final DoCheckoutPaymentResponse doCheckoutPaymentResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckoutPayment(paramDoCheckoutPayment, paramMetaData);
      return (O) doCheckoutPaymentResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doNotification(MetaData paramMetaData, O paramOrder) {
      final DoNotification paramDoNotification = new DoNotification();
      paramDoNotification.setOrder(paramOrder);
      final DoNotificationResponse doNotificationResponse = getPayPalExpressCheckOutWebServiceImpl().doNotification(paramDoNotification, paramMetaData);
      return (O) doNotificationResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doRefundTransaction(MetaData paramMetaData, O paramOrder) {
      final DoRefundTransaction paramRefundTransaction = new DoRefundTransaction();
      paramRefundTransaction.setOrder(paramOrder);
      final DoRefundTransactionResponse doRefundTransactionResponse = getPayPalExpressCheckOutWebServiceImpl().doRefundTransaction(paramRefundTransaction, paramMetaData);
      return (O) doRefundTransactionResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doTransactionDetails(MetaData paramMetaData, O paramOrder) {
      final DoTransactionDetails paramDoTransactionDetails = new DoTransactionDetails();
      paramDoTransactionDetails.setOrder(paramOrder);
      final DoTransactionDetailsResponse doTransactionDetailsResponse = getPayPalExpressCheckOutWebServiceImpl().doTransactionDetails(paramDoTransactionDetails, paramMetaData);
      return (O) doTransactionDetailsResponse.getReturn();
   }

   private PayPalExpressCheckOutWebServiceImpl getPayPalExpressCheckOutWebServiceImpl() {
      if (payPalExpressCheckOutWebServiceImpl == null) {
         final PayPalExpressCheckOutWebServiceImplService payPalExpressCheckOutWebServiceImplService = new PayPalExpressCheckOutWebServiceImplService(PayPalExpressCheckOutWebServiceImplService.WSDL_LOCATION);
         payPalExpressCheckOutWebServiceImpl = payPalExpressCheckOutWebServiceImplService.getPayPalExpressCheckOutWebServiceImplPort();
      }

      return payPalExpressCheckOutWebServiceImpl;
   }
}
