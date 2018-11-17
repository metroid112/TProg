package servicios;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-16T20:28:46.662-03:00
 * Generated source version: 3.2.6
 *
 */
@WebServiceClient(name = "PublicadorService",
                  wsdlLocation = "http://localhost:10135/publicador?wsdl",
                  targetNamespace = "http://servicios/")
public class PublicadorService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://servicios/", "PublicadorService");
    public final static QName PublicadorPort = new QName("http://servicios/", "PublicadorPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:10135/publicador?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PublicadorService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:10135/publicador?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PublicadorService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PublicadorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PublicadorService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public PublicadorService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PublicadorService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PublicadorService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns Publicador
     */
    @WebEndpoint(name = "PublicadorPort")
    public Publicador getPublicadorPort() {
        return super.getPort(PublicadorPort, Publicador.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Publicador
     */
    @WebEndpoint(name = "PublicadorPort")
    public Publicador getPublicadorPort(WebServiceFeature... features) {
        return super.getPort(PublicadorPort, Publicador.class, features);
    }

}
