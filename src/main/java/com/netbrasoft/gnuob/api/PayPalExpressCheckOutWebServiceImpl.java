package com.netbrasoft.gnuob.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2014-08-10T22:00:30.469+02:00
 * Generated source version: 2.7.11
 * 
 */
@WebService(targetNamespace = "http://gnuob.netbrasoft.com/", name = "PayPalExpressCheckOutWebServiceImpl")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PayPalExpressCheckOutWebServiceImpl {

    @WebResult(name = "doCheckoutDetailsResponse", targetNamespace = "http://gnuob.netbrasoft.com/", partName = "parameters")
    @WebMethod
    public DoCheckoutDetailsResponse doCheckoutDetails(
        @WebParam(partName = "parameters", name = "doCheckoutDetails", targetNamespace = "http://gnuob.netbrasoft.com/")
        DoCheckoutDetails parameters,
        @WebParam(partName = "metaData", name = "metaData", targetNamespace = "http://gnuob.netbrasoft.com/", header = true)
        MetaData metaData
    ) throws GNUOpenBusinessServiceException_Exception;

    @WebResult(name = "doCheckoutPaymentResponse", targetNamespace = "http://gnuob.netbrasoft.com/", partName = "parameters")
    @WebMethod
    public DoCheckoutPaymentResponse doCheckoutPayment(
        @WebParam(partName = "parameters", name = "doCheckoutPayment", targetNamespace = "http://gnuob.netbrasoft.com/")
        DoCheckoutPayment parameters,
        @WebParam(partName = "metaData", name = "metaData", targetNamespace = "http://gnuob.netbrasoft.com/", header = true)
        MetaData metaData
    ) throws GNUOpenBusinessServiceException_Exception;

    @WebResult(name = "doCheckoutResponse", targetNamespace = "http://gnuob.netbrasoft.com/", partName = "parameters")
    @WebMethod
    public DoCheckoutResponse doCheckout(
        @WebParam(partName = "parameters", name = "doCheckout", targetNamespace = "http://gnuob.netbrasoft.com/")
        DoCheckout parameters,
        @WebParam(partName = "metaData", name = "metaData", targetNamespace = "http://gnuob.netbrasoft.com/", header = true)
        MetaData metaData
    ) throws GNUOpenBusinessServiceException_Exception;
}
