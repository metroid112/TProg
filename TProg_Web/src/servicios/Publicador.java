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
 * 2018-11-07T17:38:05.614-03:00
 * Generated source version: 3.2.6
 *
 */
@WebService(targetNamespace = "http://servicios/", name = "Publicador")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Publicador {

    @WebMethod(operationName = "AltaUsuario")
    @Action(input = "http://servicios/Publicador/AltaUsuarioRequest", output = "http://servicios/Publicador/AltaUsuarioResponse")
    public void altaUsuario(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3,
        @WebParam(partName = "arg4", name = "arg4")
        javax.xml.datatype.XMLGregorianCalendar arg4,
        @WebParam(partName = "arg5", name = "arg5")
        java.lang.String arg5,
        @WebParam(partName = "arg6", name = "arg6")
        java.lang.String arg6,
        @WebParam(partName = "arg7", name = "arg7")
        java.lang.String arg7,
        @WebParam(partName = "arg8", name = "arg8")
        java.lang.String arg8,
        @WebParam(partName = "arg9", name = "arg9")
        boolean arg9,
        @WebParam(partName = "arg10", name = "arg10")
        java.lang.String arg10
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/pruebaRequest", output = "http://servicios/Publicador/pruebaResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public java.lang.String prueba(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/busquedaGeneralRequest", output = "http://servicios/Publicador/busquedaGeneralResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete busquedaGeneral(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        int arg1
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/busquedaCanalesRequest", output = "http://servicios/Publicador/busquedaCanalesResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete busquedaCanales(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        int arg1
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/consultaDeCategoriaRequest", output = "http://servicios/Publicador/consultaDeCategoriaResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete consultaDeCategoria(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/busquedaVideoRequest", output = "http://servicios/Publicador/busquedaVideoResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete busquedaVideo(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        int arg1
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/cargarDatosRequest", output = "http://servicios/Publicador/cargarDatosResponse")
    public void cargarDatos();

    @WebMethod
    @Action(input = "http://servicios/Publicador/prueba2Request", output = "http://servicios/Publicador/prueba2Response")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public java.lang.String prueba2();

    @WebMethod
    @Action(input = "http://servicios/Publicador/listarCategoriasRequest", output = "http://servicios/Publicador/listarCategoriasResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete listarCategorias();

    @WebMethod
    @Action(input = "http://servicios/Publicador/busquedaListaRequest", output = "http://servicios/Publicador/busquedaListaResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete busquedaLista(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        int arg1
    );
}
