package com.netbrasoft.gnuob.api;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2014-08-07T14:31:42.870+02:00
 * Generated source version: 2.7.11
 * 
 */
@WebServiceClient(name = "ContractWebServiceImplService", 
                  wsdlLocation = "http://localhost:8080/gnuob-soap/ContractWebServiceImpl?wsdl",
                  targetNamespace = "http://gnuob.netbrasoft.com/") 
public class ContractWebServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://gnuob.netbrasoft.com/", "ContractWebServiceImplService");
    public final static QName ContractWebServiceImplPort = new QName("http://gnuob.netbrasoft.com/", "ContractWebServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/gnuob-soap/ContractWebServiceImpl?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ContractWebServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/gnuob-soap/ContractWebServiceImpl?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ContractWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ContractWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ContractWebServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ContractWebServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ContractWebServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ContractWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ContractWebServiceImpl
     */
    @WebEndpoint(name = "ContractWebServiceImplPort")
    public ContractWebServiceImpl getContractWebServiceImplPort() {
        return super.getPort(ContractWebServiceImplPort, ContractWebServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ContractWebServiceImpl
     */
    @WebEndpoint(name = "ContractWebServiceImplPort")
    public ContractWebServiceImpl getContractWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(ContractWebServiceImplPort, ContractWebServiceImpl.class, features);
    }

}