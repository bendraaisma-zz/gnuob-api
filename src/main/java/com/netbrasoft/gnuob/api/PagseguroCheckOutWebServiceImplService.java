package com.netbrasoft.gnuob.api;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.5
 * 2015-07-18T13:51:40.689+02:00
 * Generated source version: 3.0.5
 * 
 */
@WebServiceClient(name = "PagseguroCheckOutWebServiceImplService", 
                  wsdlLocation = "http://localhost:8080/gnuob-soap/PagseguroCheckOutWebServiceImpl?wsdl",
                  targetNamespace = "http://gnuob.netbrasoft.com/") 
public class PagseguroCheckOutWebServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://gnuob.netbrasoft.com/", "PagseguroCheckOutWebServiceImplService");
    public final static QName PagseguroCheckOutWebServiceImplPort = new QName("http://gnuob.netbrasoft.com/", "PagseguroCheckOutWebServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/gnuob-soap/PagseguroCheckOutWebServiceImpl?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PagseguroCheckOutWebServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/gnuob-soap/PagseguroCheckOutWebServiceImpl?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PagseguroCheckOutWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PagseguroCheckOutWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PagseguroCheckOutWebServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PagseguroCheckOutWebServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PagseguroCheckOutWebServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PagseguroCheckOutWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns PagseguroCheckOutWebServiceImpl
     */
    @WebEndpoint(name = "PagseguroCheckOutWebServiceImplPort")
    public PagseguroCheckOutWebServiceImpl getPagseguroCheckOutWebServiceImplPort() {
        return super.getPort(PagseguroCheckOutWebServiceImplPort, PagseguroCheckOutWebServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PagseguroCheckOutWebServiceImpl
     */
    @WebEndpoint(name = "PagseguroCheckOutWebServiceImplPort")
    public PagseguroCheckOutWebServiceImpl getPagseguroCheckOutWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(PagseguroCheckOutWebServiceImplPort, PagseguroCheckOutWebServiceImpl.class, features);
    }

}
