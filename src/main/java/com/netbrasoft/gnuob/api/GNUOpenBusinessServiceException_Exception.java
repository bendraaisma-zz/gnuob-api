
package com.netbrasoft.gnuob.api;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.11
 * 2014-08-10T22:00:48.187+02:00
 * Generated source version: 2.7.11
 */

@WebFault(name = "GNUOpenBusinessServiceException", targetNamespace = "http://gnuob.netbrasoft.com/")
public class GNUOpenBusinessServiceException_Exception extends Exception {
    
    private static final long serialVersionUID = 3349375290773958808L;
	private com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException gnuOpenBusinessServiceException;

    public GNUOpenBusinessServiceException_Exception() {
        super();
    }
    
    public GNUOpenBusinessServiceException_Exception(String message) {
        super(message);
    }
    
    public GNUOpenBusinessServiceException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GNUOpenBusinessServiceException_Exception(String message, com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException gnuOpenBusinessServiceException) {
        super(message);
        this.gnuOpenBusinessServiceException = gnuOpenBusinessServiceException;
    }

    public GNUOpenBusinessServiceException_Exception(String message, com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException gnuOpenBusinessServiceException, Throwable cause) {
        super(message, cause);
        this.gnuOpenBusinessServiceException = gnuOpenBusinessServiceException;
    }

    public com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException getFaultInfo() {
        return this.gnuOpenBusinessServiceException;
    }
}
