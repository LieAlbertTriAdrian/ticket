
package transactionservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TransactionService", targetNamespace = "http://TransactionService/", wsdlLocation = "file:/F:/KULIAH/SEMESTER%207/PPLS/PayRequest/src/conf/xml-resources/web-services/NewWebServiceFromWSDL/wsdl/TransactionService.wsdl")
public class TransactionService_Service
    extends Service
{

    private final static URL TRANSACTIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException TRANSACTIONSERVICE_EXCEPTION;
    private final static QName TRANSACTIONSERVICE_QNAME = new QName("http://TransactionService/", "TransactionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/F:/KULIAH/SEMESTER%207/PPLS/PayRequest/src/conf/xml-resources/web-services/NewWebServiceFromWSDL/wsdl/TransactionService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRANSACTIONSERVICE_WSDL_LOCATION = url;
        TRANSACTIONSERVICE_EXCEPTION = e;
    }

    public TransactionService_Service() {
        super(__getWsdlLocation(), TRANSACTIONSERVICE_QNAME);
    }

    public TransactionService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRANSACTIONSERVICE_QNAME, features);
    }

    public TransactionService_Service(URL wsdlLocation) {
        super(wsdlLocation, TRANSACTIONSERVICE_QNAME);
    }

    public TransactionService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRANSACTIONSERVICE_QNAME, features);
    }

    public TransactionService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TransactionService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TransactionService
     */
    @WebEndpoint(name = "TransactionServicePort")
    public TransactionService getTransactionServicePort() {
        return super.getPort(new QName("http://TransactionService/", "TransactionServicePort"), TransactionService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TransactionService
     */
    @WebEndpoint(name = "TransactionServicePort")
    public TransactionService getTransactionServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://TransactionService/", "TransactionServicePort"), TransactionService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRANSACTIONSERVICE_EXCEPTION!= null) {
            throw TRANSACTIONSERVICE_EXCEPTION;
        }
        return TRANSACTIONSERVICE_WSDL_LOCATION;
    }

}