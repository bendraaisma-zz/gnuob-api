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
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImpl;
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImplService;

@Monitored
@Repository("PagseguroCheckOutWebServiceRepository")
public class PagseguroCheckOutWebServiceRepository<O extends Order> implements CheckoutWebServiceRepository<O> {

   private PagseguroCheckOutWebServiceImpl pagseguroCheckOutWebServiceImpl = null;

   public PagseguroCheckOutWebServiceRepository() {
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckout(MetaData paramMetaData, O paramOrder) {
      DoCheckout paramDoCheckout = new DoCheckout();
      paramDoCheckout.setOrder(paramOrder);
      DoCheckoutResponse doCheckoutResponse = getPagseguroCheckOutWebServiceImpl().doCheckout(paramDoCheckout, paramMetaData);
      return (O) doCheckoutResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckoutDetails(MetaData paramMetaData, O paramOrder) {
      DoCheckoutDetails paramDoCheckoutDetails = new DoCheckoutDetails();
      paramDoCheckoutDetails.setOrder(paramOrder);
      DoCheckoutDetailsResponse doCheckoutDetailsResponse = getPagseguroCheckOutWebServiceImpl().doCheckoutDetails(paramDoCheckoutDetails, paramMetaData);
      return (O) doCheckoutDetailsResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O doCheckoutPayment(MetaData paramMetaData, O paramOrder) {
      DoCheckoutPayment paramDoCheckoutPayment = new DoCheckoutPayment();
      paramDoCheckoutPayment.setOrder(paramOrder);
      DoCheckoutPaymentResponse doCheckoutPaymentResponse = getPagseguroCheckOutWebServiceImpl().doCheckoutPayment(paramDoCheckoutPayment, paramMetaData);
      return (O) doCheckoutPaymentResponse.getReturn();
   }

   private PagseguroCheckOutWebServiceImpl getPagseguroCheckOutWebServiceImpl() {
      if (pagseguroCheckOutWebServiceImpl == null) {
         PagseguroCheckOutWebServiceImplService pagseguroCheckOutWebServiceImplService = new PagseguroCheckOutWebServiceImplService(PagseguroCheckOutWebServiceImplService.WSDL_LOCATION);
         pagseguroCheckOutWebServiceImpl = pagseguroCheckOutWebServiceImplService.getPagseguroCheckOutWebServiceImplPort();
      }

      return pagseguroCheckOutWebServiceImpl;
   }
}
