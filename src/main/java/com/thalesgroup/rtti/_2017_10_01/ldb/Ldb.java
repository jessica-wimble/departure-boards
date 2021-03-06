package com.thalesgroup.rtti._2017_10_01.ldb;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.0
 * 2022-01-29T11:34:30.046Z
 * Generated source version: 3.5.0
 *
 */
@WebServiceClient(name = "ldb",
                  wsdlLocation = "https://lite.realtime.nationalrail.co.uk/OpenLDBWS/wsdl.aspx?ver=2017-10-01",
                  targetNamespace = "http://thalesgroup.com/RTTI/2017-10-01/ldb/")
public class Ldb extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://thalesgroup.com/RTTI/2017-10-01/ldb/", "ldb");
    public final static QName LDBServiceSoap12 = new QName("http://thalesgroup.com/RTTI/2017-10-01/ldb/", "LDBServiceSoap12");
    public final static QName LDBServiceSoap = new QName("http://thalesgroup.com/RTTI/2017-10-01/ldb/", "LDBServiceSoap");
    static {
        URL url = null;
        try {
            url = new URL("https://lite.realtime.nationalrail.co.uk/OpenLDBWS/wsdl.aspx?ver=2017-10-01");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Ldb.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "https://lite.realtime.nationalrail.co.uk/OpenLDBWS/wsdl.aspx?ver=2017-10-01");
        }
        WSDL_LOCATION = url;
    }

    public Ldb(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Ldb(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Ldb() {
        super(WSDL_LOCATION, SERVICE);
    }

    public Ldb(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Ldb(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Ldb(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns LDBServiceSoap
     */
    @WebEndpoint(name = "LDBServiceSoap12")
    public LDBServiceSoap getLDBServiceSoap12() {
        return super.getPort(LDBServiceSoap12, LDBServiceSoap.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LDBServiceSoap
     */
    @WebEndpoint(name = "LDBServiceSoap12")
    public LDBServiceSoap getLDBServiceSoap12(WebServiceFeature... features) {
        return super.getPort(LDBServiceSoap12, LDBServiceSoap.class, features);
    }


    /**
     *
     * @return
     *     returns LDBServiceSoap
     */
    @WebEndpoint(name = "LDBServiceSoap")
    public LDBServiceSoap getLDBServiceSoap() {
        return super.getPort(LDBServiceSoap, LDBServiceSoap.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LDBServiceSoap
     */
    @WebEndpoint(name = "LDBServiceSoap")
    public LDBServiceSoap getLDBServiceSoap(WebServiceFeature... features) {
        return super.getPort(LDBServiceSoap, LDBServiceSoap.class, features);
    }

}
