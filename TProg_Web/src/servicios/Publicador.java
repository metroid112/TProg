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
 * 2018-11-13T01:46:38.813-03:00
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
    @Action(input = "http://servicios/Publicador/consultaDeCategoriaRequest", output = "http://servicios/Publicador/consultaDeCategoriaResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete consultaDeCategoria(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/checkLoginRequest", output = "http://servicios/Publicador/checkLoginResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public boolean checkLogin(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtVideoRequest", output = "http://servicios/Publicador/getDtVideoResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtVideo(
        @WebParam(partName = "arg0", name = "arg0")
        int arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtListasPrivadasUsuarioRequest", output = "http://servicios/Publicador/getDtListasPrivadasUsuarioResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtListasPrivadasUsuario(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getSeguidosRequest", output = "http://servicios/Publicador/getSeguidosResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getSeguidos(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtListasParticularesPublicasUsuarioRequest", output = "http://servicios/Publicador/getDtListasParticularesPublicasUsuarioResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtListasParticularesPublicasUsuario(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/modificarValoracionRequest", output = "http://servicios/Publicador/modificarValoracionResponse")
    public void modificarValoracion(
        @WebParam(partName = "arg0", name = "arg0")
        boolean arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/listarNombresUsuariosRequest", output = "http://servicios/Publicador/listarNombresUsuariosResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete listarNombresUsuarios();

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtVideosPublicosRequest", output = "http://servicios/Publicador/getDtVideosPublicosResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtVideosPublicos(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/listarCategoriasRequest", output = "http://servicios/Publicador/listarCategoriasResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete listarCategorias();

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtDefectoRequest", output = "http://servicios/Publicador/getDtDefectoResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtDefecto(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/yaCalificadoRequest", output = "http://servicios/Publicador/yaCalificadoResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public boolean yaCalificado(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        boolean arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getListasPublicasRequest", output = "http://servicios/Publicador/getListasPublicasResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getListasPublicas();

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
    @Action(input = "http://servicios/Publicador/getSeguidoresRequest", output = "http://servicios/Publicador/getSeguidoresResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getSeguidores(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/isSeguidorRequest", output = "http://servicios/Publicador/isSeguidorResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public boolean isSeguidor(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtListaRequest", output = "http://servicios/Publicador/getDtListaResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtLista(
        @WebParam(partName = "arg0", name = "arg0")
        int arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtListasDefectoUsuarioRequest", output = "http://servicios/Publicador/getDtListasDefectoUsuarioResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtListasDefectoUsuario(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/busquedaListaRequest", output = "http://servicios/Publicador/busquedaListaResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete busquedaLista(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        int arg1
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
    @Action(input = "http://servicios/Publicador/getListaPublicoDtVideoRequest", output = "http://servicios/Publicador/getListaPublicoDtVideoResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getListaPublicoDtVideo();

    @WebMethod
    @Action(input = "http://servicios/Publicador/comentarVideoRequest", output = "http://servicios/Publicador/comentarVideoResponse")
    public void comentarVideo(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        javax.xml.datatype.XMLGregorianCalendar arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3,
        @WebParam(partName = "arg4", name = "arg4")
        java.lang.String arg4
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/valorarVideoRequest", output = "http://servicios/Publicador/valorarVideoResponse")
    public void valorarVideo(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        boolean arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/prueba2Request", output = "http://servicios/Publicador/prueba2Response")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public java.lang.String prueba2();

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
        byte[] arg5,
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
    @Action(input = "http://servicios/Publicador/responderComentarioRequest", output = "http://servicios/Publicador/responderComentarioResponse")
    public void responderComentario(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        javax.xml.datatype.XMLGregorianCalendar arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3,
        @WebParam(partName = "arg4", name = "arg4")
        java.lang.String arg4,
        @WebParam(partName = "arg5", name = "arg5")
        int arg5
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
    @Action(input = "http://servicios/Publicador/getListaDtVideoRequest", output = "http://servicios/Publicador/getListaDtVideoResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getListaDtVideo(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://servicios/Publicador/getDtUsuarioRequest", output = "http://servicios/Publicador/getDtUsuarioResponse")
    @WebResult(name = "return", targetNamespace = "http://servicios/", partName = "return")
    public DtPaquete getDtUsuario(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );
}
