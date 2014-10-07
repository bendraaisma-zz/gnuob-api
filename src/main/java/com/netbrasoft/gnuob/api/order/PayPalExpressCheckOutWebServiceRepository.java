package com.netbrasoft.gnuob.api.order;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.DoCheckout;
import com.netbrasoft.gnuob.api.DoCheckoutDetails;
import com.netbrasoft.gnuob.api.DoCheckoutDetailsResponse;
import com.netbrasoft.gnuob.api.DoCheckoutPayment;
import com.netbrasoft.gnuob.api.DoCheckoutPaymentResponse;
import com.netbrasoft.gnuob.api.DoCheckoutResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.PayPalExpressCheckOutWebServiceImpl;
import com.netbrasoft.gnuob.api.PayPalExpressCheckOutWebServiceImplService;

@Repository("PayPalExpressCheckOutWebServiceRepository")
public class PayPalExpressCheckOutWebServiceRepository {

    private PayPalExpressCheckOutWebServiceImpl payPalExpressCheckOutWebServiceImpl = null;

    public PayPalExpressCheckOutWebServiceRepository() {
    }

    public Order doCheckout(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
        DoCheckout paramDoCheckout = new DoCheckout();
        paramDoCheckout.setOrder(paramOrder);
        DoCheckoutResponse doCheckoutResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckout(paramDoCheckout, paramMetaData);
        return doCheckoutResponse.getReturn();
    }

    public Order doCheckoutDetails(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
        DoCheckoutDetails paramDoCheckoutDetails = new DoCheckoutDetails();
        paramDoCheckoutDetails.setOrder(paramOrder);
        DoCheckoutDetailsResponse doCheckoutDetailsResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckoutDetails(paramDoCheckoutDetails, paramMetaData);
        return doCheckoutDetailsResponse.getReturn();
    }

    public Order doCheckoutPayment(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
        DoCheckoutPayment paramDoCheckoutPayment = new DoCheckoutPayment();
        paramDoCheckoutPayment.setOrder(paramOrder);
        DoCheckoutPaymentResponse doCheckoutPaymentResponse = getPayPalExpressCheckOutWebServiceImpl().doCheckoutPayment(paramDoCheckoutPayment, paramMetaData);
        return doCheckoutPaymentResponse.getReturn();
    }

    private PayPalExpressCheckOutWebServiceImpl getPayPalExpressCheckOutWebServiceImpl() {
        if (payPalExpressCheckOutWebServiceImpl == null) {
            PayPalExpressCheckOutWebServiceImplService payPalExpressCheckOutWebServiceImplService = new PayPalExpressCheckOutWebServiceImplService(PayPalExpressCheckOutWebServiceImplService.WSDL_LOCATION);
            payPalExpressCheckOutWebServiceImpl = payPalExpressCheckOutWebServiceImplService.getPayPalExpressCheckOutWebServiceImplPort();
        }

        return payPalExpressCheckOutWebServiceImpl;
    }
}
