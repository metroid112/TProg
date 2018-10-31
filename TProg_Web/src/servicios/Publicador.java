package servicios;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-10-31T19:19:57.837-03:00
 * Generated source version: 3.2.6
 *
 */
@WebService(targetNamespace = "http://servicios/", name = "Publicador")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Publicador {

    @WebMethod
    @Action(input = "http://servicios/Publicador/pruebaRequest", output = "http://servicios/Publicador/pruebaResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public java.lang.String prueba(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/prueba2Request", output = "http://servicios/Publicador/prueba2Response")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public java.lang.String prueba2();

    @WebMethod
    @Action(input = "http://servicios/Publicador/cargarDatosRequest", output = "http://servicios/Publicador/cargarDatosResponse")
    public void cargarDatos();

    @WebMethod
    @Action(input = "http://servicios/Publicador/getPaqueteRequest", output = "http://servicios/Publicador/getPaqueteResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getPaquete(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );
}
