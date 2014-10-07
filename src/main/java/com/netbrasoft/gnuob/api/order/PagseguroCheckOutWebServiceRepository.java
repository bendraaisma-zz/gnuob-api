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
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImpl;
import com.netbrasoft.gnuob.api.PagseguroCheckOutWebServiceImplService;

@Repository("PagseguroCheckOutWebServiceRepository")
public class PagseguroCheckOutWebServiceRepository {

    private PagseguroCheckOutWebServiceImpl pagseguroCheckOutWebServiceImpl = null;

    public PagseguroCheckOutWebServiceRepository() {
    }

    public Order doCheckout(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
        DoCheckout paramDoCheckout = new DoCheckout();
        paramDoCheckout.setOrder(paramOrder);
        DoCheckoutResponse doCheckoutResponse = getPagseguroCheckOutWebServiceImpl().doCheckout(paramDoCheckout, paramMetaData);
        return doCheckoutResponse.getReturn();
    }

    public Order doCheckoutDetails(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
        DoCheckoutDetails paramDoCheckoutDetails = new DoCheckoutDetails();
        paramDoCheckoutDetails.setOrder(paramOrder);
        DoCheckoutDetailsResponse doCheckoutDetailsResponse = getPagseguroCheckOutWebServiceImpl().doCheckoutDetails(paramDoCheckoutDetails, paramMetaData);
        return doCheckoutDetailsResponse.getReturn();
    }

    public Order doCheckoutPayment(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
        DoCheckoutPayment paramDoCheckoutPayment = new DoCheckoutPayment();
        paramDoCheckoutPayment.setOrder(paramOrder);
        DoCheckoutPaymentResponse doCheckoutPaymentResponse = getPagseguroCheckOutWebServiceImpl().doCheckoutPayment(paramDoCheckoutPayment, paramMetaData);
        return doCheckoutPaymentResponse.getReturn();
    }

    private PagseguroCheckOutWebServiceImpl getPagseguroCheckOutWebServiceImpl() {
        if (pagseguroCheckOutWebServiceImpl == null) {
            PagseguroCheckOutWebServiceImplService pagseguroCheckOutWebServiceImplService = new PagseguroCheckOutWebServiceImplService(PagseguroCheckOutWebServiceImplService.WSDL_LOCATION);
            pagseguroCheckOutWebServiceImpl = pagseguroCheckOutWebServiceImplService.getPagseguroCheckOutWebServiceImplPort();
        }

        return pagseguroCheckOutWebServiceImpl;
    }
}
