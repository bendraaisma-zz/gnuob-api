package com.netbrasoft.gnuob.api;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.5 2015-09-22T18:42:25.303+02:00
 * Generated source version: 3.0.5
 * 
 */
@WebServiceClient(name = "OrderWebServiceImplService", wsdlLocation = "http://localhost:8080/gnuob-soap/OrderWebServiceImpl?wsdl", targetNamespace = "http://gnuob.netbrasoft.com/")
public class OrderWebServiceImplService extends Service {

   public final static URL WSDL_LOCATION;

   public final static QName SERVICE = new QName("http://gnuob.netbrasoft.com/", "OrderWebServiceImplService");
   public final static QName OrderWebServiceImplPort = new QName("http://gnuob.netbrasoft.com/", "OrderWebServiceImplPort");

   static {
      URL url = null;
      try {
         url = new URL("http://localhost:8080/gnuob-soap/OrderWebServiceImpl?wsdl");
      } catch (MalformedURLException e) {
         java.util.logging.Logger.getLogger(OrderWebServiceImplService.class.getName()).log(java.util.logging.Level.INFO, "Can not initialize the default wsdl from {0}", "http://localhost:8080/gnuob-soap/OrderWebServiceImpl?wsdl");
      }
      WSDL_LOCATION = url;
   }

   public OrderWebServiceImplService(URL wsdlLocation) {
      super(wsdlLocation, SERVICE);
   }

   public OrderWebServiceImplService(URL wsdlLocation, QName serviceName) {
      super(wsdlLocation, serviceName);
   }

   public OrderWebServiceImplService() {
      super(WSDL_LOCATION, SERVICE);
   }

   // This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
   // API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS
   // 2.1
   // compliant code instead.
   public OrderWebServiceImplService(WebServiceFeature... features) {
      super(WSDL_LOCATION, SERVICE, features);
   }

   // This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
   // API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS
   // 2.1
   // compliant code instead.
   public OrderWebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
      super(wsdlLocation, SERVICE, features);
   }

   // This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
   // API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS
   // 2.1
   // compliant code instead.
   public OrderWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
      super(wsdlLocation, serviceName, features);
   }

   /**
    *
    * @return returns OrderWebServiceImpl
    */
   @WebEndpoint(name = "OrderWebServiceImplPort")
   public OrderWebServiceImpl getOrderWebServiceImplPort() {
      return super.getPort(OrderWebServiceImplPort, OrderWebServiceImpl.class);
   }

   /**
    * 
    * @param features
    *           A list of {@link javax.xml.ws.WebServiceFeature} to configure on
    *           the proxy. Supported features not in the <code>features</code>
    *           parameter will have their default values.
    * @return returns OrderWebServiceImpl
    */
   @WebEndpoint(name = "OrderWebServiceImplPort")
   public OrderWebServiceImpl getOrderWebServiceImplPort(WebServiceFeature... features) {
      return super.getPort(OrderWebServiceImplPort, OrderWebServiceImpl.class, features);
   }

}
