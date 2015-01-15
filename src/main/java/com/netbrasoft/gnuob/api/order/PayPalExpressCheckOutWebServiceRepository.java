package com.netbrasoft.gnuob.api.order;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.DoCheckout;
import com.netbrasoft.gnuob.api.DoCheckoutDetails;
import com.netbrasoft.gnuob.api.DoCheckoutDetailsResponse;
import com.netbrasoft.gnuob.api.DoCheckoutPayment;
import com.netbrasoft.gnuob.api.DoCheckoutPaymentResponse;
import com.netbrasoft.gnuob.api.DoCheckoutResponse;
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
      DoCheckout paramDoCheckout = new DoCheckout();
      paramDoCheckout.setOrder(paramOrder);
      DoCheckoutResponse doCheckoutResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckout(paramDoCheckout,
            paramMetaData);
      return (O) doCheckoutResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckoutDetails(MetaData paramMetaData, O paramOrder) {
      DoCheckoutDetails paramDoCheckoutDetails = new DoCheckoutDetails();
      paramDoCheckoutDetails.setOrder(paramOrder);
      DoCheckoutDetailsResponse doCheckoutDetailsResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckoutDetails(
            paramDoCheckoutDetails, paramMetaData);
      return (O) doCheckoutDetailsResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckoutPayment(MetaData paramMetaData, O paramOrder) {
      DoCheckoutPayment paramDoCheckoutPayment = new DoCheckoutPayment();
      paramDoCheckoutPayment.setOrder(paramOrder);
      DoCheckoutPaymentResponse doCheckoutPaymentResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckoutPayment(
            paramDoCheckoutPayment, paramMetaData);
      return (O) doCheckoutPaymentResponse.getReturn();
   }

   private PayPalExpressCheckOutWebServiceImpl getPayPalExpressCheckOutWebServiceImpl() {
      if (payPalExpressCheckOutWebServiceImpl == null) {
         PayPalExpressCheckOutWebServiceImplService payPalExpressCheckOutWebServiceImplService = new PayPalExpressCheckOutWebServiceImplService(
               PayPalExpressCheckOutWebServiceImplService.WSDL_LOCATION);
         payPalExpressCheckOutWebServiceImpl = payPalExpressCheckOutWebServiceImplService
               .getPayPalExpressCheckOutWebServiceImplPort();
      }

      return payPalExpressCheckOutWebServiceImpl;
   }
}
