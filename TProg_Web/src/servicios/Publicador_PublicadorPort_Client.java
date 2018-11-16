
package servicios;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-16T02:44:09.555-03:00
 * Generated source version: 3.2.6
 *
 */
public final class Publicador_PublicadorPort_Client {

    private static final QName SERVICE_NAME = new QName("http://servicios/", "PublicadorService");

    private Publicador_PublicadorPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = PublicadorService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        PublicadorService ss = new PublicadorService(wsdlURL, SERVICE_NAME);
        Publicador port = ss.getPublicadorPort();

        {
        System.out.println("Invoking getDtVideosPropietario...");
        java.lang.String _getDtVideosPropietario_arg0 = "_getDtVideosPropietario_arg0-119365383";
        servicios.DtPaquete _getDtVideosPropietario__return = port.getDtVideosPropietario(_getDtVideosPropietario_arg0);
        System.out.println("getDtVideosPropietario.result=" + _getDtVideosPropietario__return);


        }
        {
        System.out.println("Invoking getDtListasPrivadasUsuario...");
        java.lang.String _getDtListasPrivadasUsuario_arg0 = "_getDtListasPrivadasUsuario_arg0601525911";
        servicios.DtPaquete _getDtListasPrivadasUsuario__return = port.getDtListasPrivadasUsuario(_getDtListasPrivadasUsuario_arg0);
        System.out.println("getDtListasPrivadasUsuario.result=" + _getDtListasPrivadasUsuario__return);


        }
        {
        System.out.println("Invoking getDtVideo...");
        int _getDtVideo_arg0 = -860735363;
        servicios.DtPaquete _getDtVideo__return = port.getDtVideo(_getDtVideo_arg0);
        System.out.println("getDtVideo.result=" + _getDtVideo__return);


        }
        {
        System.out.println("Invoking getDtListasParticularesPublicasUsuario...");
        java.lang.String _getDtListasParticularesPublicasUsuario_arg0 = "_getDtListasParticularesPublicasUsuario_arg01828846204";
        servicios.DtPaquete _getDtListasParticularesPublicasUsuario__return = port.getDtListasParticularesPublicasUsuario(_getDtListasParticularesPublicasUsuario_arg0);
        System.out.println("getDtListasParticularesPublicasUsuario.result=" + _getDtListasParticularesPublicasUsuario__return);


        }
        {
        System.out.println("Invoking listarNombresUsuarios...");
        servicios.DtPaquete _listarNombresUsuarios__return = port.listarNombresUsuarios();
        System.out.println("listarNombresUsuarios.result=" + _listarNombresUsuarios__return);


        }
        {
        System.out.println("Invoking getDtVideosPublicos...");
        java.lang.String _getDtVideosPublicos_arg0 = "_getDtVideosPublicos_arg0-111433347";
        servicios.DtPaquete _getDtVideosPublicos__return = port.getDtVideosPublicos(_getDtVideosPublicos_arg0);
        System.out.println("getDtVideosPublicos.result=" + _getDtVideosPublicos__return);


        }
        {
        System.out.println("Invoking altaListaParticular...");
        java.lang.String _altaListaParticular_arg0 = "_altaListaParticular_arg0659574402";
        java.lang.String _altaListaParticular_arg1 = "_altaListaParticular_arg1-79973117";
        boolean _altaListaParticular_arg2 = false;
        try {
            port.altaListaParticular(_altaListaParticular_arg0, _altaListaParticular_arg1, _altaListaParticular_arg2);

        } catch (DuplicateClassException_Exception e) {
            System.out.println("Expected exception: DuplicateClassException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking listarCategorias...");
        servicios.DtPaquete _listarCategorias__return = port.listarCategorias();
        System.out.println("listarCategorias.result=" + _listarCategorias__return);


        }
        {
        System.out.println("Invoking getImagen...");
        java.lang.String _getImagen_arg0 = "_getImagen_arg0-372711549";
        byte[] _getImagen__return = port.getImagen(_getImagen_arg0);
        System.out.println("getImagen.result=" + _getImagen__return);


        }
        {
        System.out.println("Invoking getListasPublicas...");
        servicios.DtPaquete _getListasPublicas__return = port.getListasPublicas();
        System.out.println("getListasPublicas.result=" + _getListasPublicas__return);


        }
        {
        System.out.println("Invoking busquedaVideo...");
        java.lang.String _busquedaVideo_arg0 = "_busquedaVideo_arg01904696314";
        int _busquedaVideo_arg1 = 678329674;
        servicios.DtPaquete _busquedaVideo__return = port.busquedaVideo(_busquedaVideo_arg0, _busquedaVideo_arg1);
        System.out.println("busquedaVideo.result=" + _busquedaVideo__return);


        }
        {
        System.out.println("Invoking cargarDatos...");
        port.cargarDatos();


        }
        {
        System.out.println("Invoking getDtLista...");
        int _getDtLista_arg0 = 927083959;
        servicios.DtPaquete _getDtLista__return = port.getDtLista(_getDtLista_arg0);
        System.out.println("getDtLista.result=" + _getDtLista__return);


        }
        {
        System.out.println("Invoking seguir...");
        java.lang.String _seguir_arg0 = "_seguir_arg01014830005";
        java.lang.String _seguir_arg1 = "_seguir_arg1-976070499";
        port.seguir(_seguir_arg0, _seguir_arg1);


        }
        {
        System.out.println("Invoking busquedaGeneral...");
        java.lang.String _busquedaGeneral_arg0 = "_busquedaGeneral_arg0-846570796";
        int _busquedaGeneral_arg1 = 310007142;
        servicios.DtPaquete _busquedaGeneral__return = port.busquedaGeneral(_busquedaGeneral_arg0, _busquedaGeneral_arg1);
        System.out.println("busquedaGeneral.result=" + _busquedaGeneral__return);


        }
        {
        System.out.println("Invoking getListaPublicoDtVideo...");
        servicios.DtPaquete _getListaPublicoDtVideo__return = port.getListaPublicoDtVideo();
        System.out.println("getListaPublicoDtVideo.result=" + _getListaPublicoDtVideo__return);


        }
        {
        System.out.println("Invoking existeNick...");
        java.lang.String _existeNick_arg0 = "_existeNick_arg0138311539";
        boolean _existeNick__return = port.existeNick(_existeNick_arg0);
        System.out.println("existeNick.result=" + _existeNick__return);


        }
        {
        System.out.println("Invoking valorarVideo...");
        java.lang.String _valorarVideo_arg0 = "_valorarVideo_arg01261503564";
        boolean _valorarVideo_arg1 = false;
        java.lang.String _valorarVideo_arg2 = "_valorarVideo_arg2-1941280254";
        java.lang.String _valorarVideo_arg3 = "_valorarVideo_arg31226476501";
        port.valorarVideo(_valorarVideo_arg0, _valorarVideo_arg1, _valorarVideo_arg2, _valorarVideo_arg3);


        }
        {
        System.out.println("Invoking listarListasDefectoUsuario...");
        java.lang.String _listarListasDefectoUsuario_arg0 = "_listarListasDefectoUsuario_arg01593481686";
        servicios.DtPaquete _listarListasDefectoUsuario__return = port.listarListasDefectoUsuario(_listarListasDefectoUsuario_arg0);
        System.out.println("listarListasDefectoUsuario.result=" + _listarListasDefectoUsuario__return);


        }
        {
        System.out.println("Invoking altaUsuario...");
        java.lang.String _altaUsuario_arg0 = "_altaUsuario_arg0-2135412094";
        java.lang.String _altaUsuario_arg1 = "_altaUsuario_arg11459174550";
        java.lang.String _altaUsuario_arg2 = "_altaUsuario_arg2-992248592";
        java.lang.String _altaUsuario_arg3 = "_altaUsuario_arg31703199478";
        javax.xml.datatype.XMLGregorianCalendar _altaUsuario_arg4 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-16T02:44:09.664-03:00");
        byte[] _altaUsuario_imagen = new byte[] {};
        java.lang.String _altaUsuario_arg6 = "_altaUsuario_arg6-1874923872";
        java.lang.String _altaUsuario_arg7 = "_altaUsuario_arg7590750599";
        java.lang.String _altaUsuario_arg8 = "_altaUsuario_arg8258043224";
        boolean _altaUsuario_arg9 = true;
        java.lang.String _altaUsuario_arg10 = "_altaUsuario_arg10-723616773";
        port.altaUsuario(_altaUsuario_arg0, _altaUsuario_arg1, _altaUsuario_arg2, _altaUsuario_arg3, _altaUsuario_arg4, _altaUsuario_imagen, _altaUsuario_arg6, _altaUsuario_arg7, _altaUsuario_arg8, _altaUsuario_arg9, _altaUsuario_arg10);


        }
        {
        System.out.println("Invoking existeLista...");
        java.lang.String _existeLista_arg0 = "_existeLista_arg02016702181";
        java.lang.String _existeLista_arg1 = "_existeLista_arg11313240550";
        boolean _existeLista__return = port.existeLista(_existeLista_arg0, _existeLista_arg1);
        System.out.println("existeLista.result=" + _existeLista__return);


        }
        {
        System.out.println("Invoking busquedaCanales...");
        java.lang.String _busquedaCanales_arg0 = "_busquedaCanales_arg0876370901";
        int _busquedaCanales_arg1 = -86179035;
        servicios.DtPaquete _busquedaCanales__return = port.busquedaCanales(_busquedaCanales_arg0, _busquedaCanales_arg1);
        System.out.println("busquedaCanales.result=" + _busquedaCanales__return);


        }
        {
        System.out.println("Invoking modificarVideo...");
        java.lang.String _modificarVideo_arg0 = "_modificarVideo_arg01209617923";
        java.lang.String _modificarVideo_arg1 = "_modificarVideo_arg1610033083";
        java.lang.String _modificarVideo_arg2 = "_modificarVideo_arg2994505375";
        java.lang.String _modificarVideo_arg3 = "_modificarVideo_arg31597897424";
        java.lang.String _modificarVideo_arg4 = "_modificarVideo_arg4-722863544";
        java.lang.String _modificarVideo_arg5 = "_modificarVideo_arg52029997700";
        long _modificarVideo_arg6 = 6427540168134672309l;
        boolean _modificarVideo_arg7 = false;
        javax.xml.datatype.XMLGregorianCalendar _modificarVideo_arg8 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-16T02:44:09.664-03:00");
        port.modificarVideo(_modificarVideo_arg0, _modificarVideo_arg1, _modificarVideo_arg2, _modificarVideo_arg3, _modificarVideo_arg4, _modificarVideo_arg5, _modificarVideo_arg6, _modificarVideo_arg7, _modificarVideo_arg8);


        }
        {
        System.out.println("Invoking altaVideo...");
        java.lang.String _altaVideo_arg0 = "_altaVideo_arg0-47642369";
        java.lang.String _altaVideo_arg1 = "_altaVideo_arg1-424662416";
        java.lang.String _altaVideo_arg2 = "_altaVideo_arg2-1666824521";
        long _altaVideo_arg3 = 9183006819745029565l;
        java.lang.String _altaVideo_arg4 = "_altaVideo_arg41712604393";
        java.lang.String _altaVideo_arg5 = "_altaVideo_arg51855278408";
        javax.xml.datatype.XMLGregorianCalendar _altaVideo_arg6 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-16T02:44:09.664-03:00");
        boolean _altaVideo_arg7 = false;
        port.altaVideo(_altaVideo_arg0, _altaVideo_arg1, _altaVideo_arg2, _altaVideo_arg3, _altaVideo_arg4, _altaVideo_arg5, _altaVideo_arg6, _altaVideo_arg7);


        }
        {
        System.out.println("Invoking getListaDtVideo...");
        java.lang.String _getListaDtVideo_arg0 = "_getListaDtVideo_arg0-1351029208";
        servicios.DtPaquete _getListaDtVideo__return = port.getListaDtVideo(_getListaDtVideo_arg0);
        System.out.println("getListaDtVideo.result=" + _getListaDtVideo__return);


        }
        {
        System.out.println("Invoking existeVideo...");
        java.lang.String _existeVideo_arg0 = "_existeVideo_arg0-719835423";
        java.lang.String _existeVideo_arg1 = "_existeVideo_arg1-1639535605";
        boolean _existeVideo__return = port.existeVideo(_existeVideo_arg0, _existeVideo_arg1);
        System.out.println("existeVideo.result=" + _existeVideo__return);


        }
        {
        System.out.println("Invoking getDtUsuario...");
        java.lang.String _getDtUsuario_arg0 = "_getDtUsuario_arg01918518099";
        servicios.DtPaquete _getDtUsuario__return = port.getDtUsuario(_getDtUsuario_arg0);
        System.out.println("getDtUsuario.result=" + _getDtUsuario__return);


        }
        {
        System.out.println("Invoking prueba...");
        java.lang.String _prueba_arg0 = "_prueba_arg01470331335";
        java.lang.String _prueba__return = port.prueba(_prueba_arg0);
        System.out.println("prueba.result=" + _prueba__return);


        }
        {
        System.out.println("Invoking consultaDeCategoria...");
        java.lang.String _consultaDeCategoria_arg0 = "_consultaDeCategoria_arg01022018971";
        servicios.DtPaquete _consultaDeCategoria__return = port.consultaDeCategoria(_consultaDeCategoria_arg0);
        System.out.println("consultaDeCategoria.result=" + _consultaDeCategoria__return);


        }
        {
        System.out.println("Invoking checkLogin...");
        java.lang.String _checkLogin_arg0 = "_checkLogin_arg0-53891141";
        java.lang.String _checkLogin_arg1 = "_checkLogin_arg1-1570774314";
        boolean _checkLogin__return = port.checkLogin(_checkLogin_arg0, _checkLogin_arg1);
        System.out.println("checkLogin.result=" + _checkLogin__return);


        }
        {
        System.out.println("Invoking getSeguidos...");
        java.lang.String _getSeguidos_arg0 = "_getSeguidos_arg0-810599488";
        servicios.DtPaquete _getSeguidos__return = port.getSeguidos(_getSeguidos_arg0);
        System.out.println("getSeguidos.result=" + _getSeguidos__return);


        }
        {
        System.out.println("Invoking listarDtVideosDuenosLista...");
        java.lang.String _listarDtVideosDuenosLista_arg0 = "_listarDtVideosDuenosLista_arg0-1062042860";
        java.lang.String _listarDtVideosDuenosLista_arg1 = "_listarDtVideosDuenosLista_arg1-24470454";
        boolean _listarDtVideosDuenosLista_arg2 = true;
        servicios.DtPaquete _listarDtVideosDuenosLista__return = port.listarDtVideosDuenosLista(_listarDtVideosDuenosLista_arg0, _listarDtVideosDuenosLista_arg1, _listarDtVideosDuenosLista_arg2);
        System.out.println("listarDtVideosDuenosLista.result=" + _listarDtVideosDuenosLista__return);


        }
        {
        System.out.println("Invoking modificarValoracion...");
        boolean _modificarValoracion_arg0 = true;
        java.lang.String _modificarValoracion_arg1 = "_modificarValoracion_arg1-618674564";
        java.lang.String _modificarValoracion_arg2 = "_modificarValoracion_arg2-1029456307";
        java.lang.String _modificarValoracion_arg3 = "_modificarValoracion_arg3-1475458649";
        port.modificarValoracion(_modificarValoracion_arg0, _modificarValoracion_arg1, _modificarValoracion_arg2, _modificarValoracion_arg3);


        }
        {
        System.out.println("Invoking getDtDefecto...");
        java.lang.String _getDtDefecto_arg0 = "_getDtDefecto_arg0-47334316";
        java.lang.String _getDtDefecto_arg1 = "_getDtDefecto_arg1502706145";
        servicios.DtPaquete _getDtDefecto__return = port.getDtDefecto(_getDtDefecto_arg0, _getDtDefecto_arg1);
        System.out.println("getDtDefecto.result=" + _getDtDefecto__return);


        }
        {
        System.out.println("Invoking yaCalificado...");
        java.lang.String _yaCalificado_arg0 = "_yaCalificado_arg0501460630";
        boolean _yaCalificado_arg1 = true;
        java.lang.String _yaCalificado_arg2 = "_yaCalificado_arg21314887810";
        java.lang.String _yaCalificado_arg3 = "_yaCalificado_arg3-2119269587";
        boolean _yaCalificado__return = port.yaCalificado(_yaCalificado_arg0, _yaCalificado_arg1, _yaCalificado_arg2, _yaCalificado_arg3);
        System.out.println("yaCalificado.result=" + _yaCalificado__return);


        }
        {
        System.out.println("Invoking guardarCambios...");
        java.lang.String _guardarCambios_arg0 = "_guardarCambios_arg0-2055099358";
        java.lang.String _guardarCambios_arg1 = "_guardarCambios_arg1-217466545";
        boolean _guardarCambios_arg2 = false;
        port.guardarCambios(_guardarCambios_arg0, _guardarCambios_arg1, _guardarCambios_arg2);


        }
        {
        System.out.println("Invoking dejarSeguir...");
        java.lang.String _dejarSeguir_arg0 = "_dejarSeguir_arg01118815826";
        java.lang.String _dejarSeguir_arg1 = "_dejarSeguir_arg127471925";
        port.dejarSeguir(_dejarSeguir_arg0, _dejarSeguir_arg1);


        }
        {
        System.out.println("Invoking getDt...");
        int _getDt_arg0 = 1666537810;
        servicios.DtPaquete _getDt__return = port.getDt(_getDt_arg0);
        System.out.println("getDt.result=" + _getDt__return);


        }
        {
        System.out.println("Invoking getSeguidores...");
        java.lang.String _getSeguidores_arg0 = "_getSeguidores_arg0-1068475276";
        servicios.DtPaquete _getSeguidores__return = port.getSeguidores(_getSeguidores_arg0);
        System.out.println("getSeguidores.result=" + _getSeguidores__return);


        }
        {
        System.out.println("Invoking isSeguidor...");
        java.lang.String _isSeguidor_arg0 = "_isSeguidor_arg0-57045309";
        java.lang.String _isSeguidor_arg1 = "_isSeguidor_arg1207888579";
        boolean _isSeguidor__return = port.isSeguidor(_isSeguidor_arg0, _isSeguidor_arg1);
        System.out.println("isSeguidor.result=" + _isSeguidor__return);


        }
        {
        System.out.println("Invoking getDtListasDefectoUsuario...");
        java.lang.String _getDtListasDefectoUsuario_arg0 = "_getDtListasDefectoUsuario_arg0-228895868";
        servicios.DtPaquete _getDtListasDefectoUsuario__return = port.getDtListasDefectoUsuario(_getDtListasDefectoUsuario_arg0);
        System.out.println("getDtListasDefectoUsuario.result=" + _getDtListasDefectoUsuario__return);


        }
        {
        System.out.println("Invoking quitarVideoLista...");
        java.lang.String _quitarVideoLista_arg0 = "_quitarVideoLista_arg01349158842";
        java.lang.String _quitarVideoLista_arg1 = "_quitarVideoLista_arg11837740581";
        java.lang.String _quitarVideoLista_arg2 = "_quitarVideoLista_arg2-1857731310";
        java.lang.String _quitarVideoLista_arg3 = "_quitarVideoLista_arg3-446414361";
        boolean _quitarVideoLista_arg4 = true;
        port.quitarVideoLista(_quitarVideoLista_arg0, _quitarVideoLista_arg1, _quitarVideoLista_arg2, _quitarVideoLista_arg3, _quitarVideoLista_arg4);


        }
        {
        System.out.println("Invoking busquedaLista...");
        java.lang.String _busquedaLista_arg0 = "_busquedaLista_arg01122684486";
        int _busquedaLista_arg1 = 687530140;
        servicios.DtPaquete _busquedaLista__return = port.busquedaLista(_busquedaLista_arg0, _busquedaLista_arg1);
        System.out.println("busquedaLista.result=" + _busquedaLista__return);


        }
        {
        System.out.println("Invoking listarListasParticularUsuario...");
        java.lang.String _listarListasParticularUsuario_arg0 = "_listarListasParticularUsuario_arg01338007312";
        servicios.DtPaquete _listarListasParticularUsuario__return = port.listarListasParticularUsuario(_listarListasParticularUsuario_arg0);
        System.out.println("listarListasParticularUsuario.result=" + _listarListasParticularUsuario__return);


        }
        {
        System.out.println("Invoking listarTodosLosVideos...");
        java.lang.String _listarTodosLosVideos_arg0 = "_listarTodosLosVideos_arg0861185081";
        servicios.DtPaquete _listarTodosLosVideos__return = port.listarTodosLosVideos(_listarTodosLosVideos_arg0);
        System.out.println("listarTodosLosVideos.result=" + _listarTodosLosVideos__return);


        }
        {
        System.out.println("Invoking comentarVideo...");
        java.lang.String _comentarVideo_arg0 = "_comentarVideo_arg0-234464179";
        javax.xml.datatype.XMLGregorianCalendar _comentarVideo_arg1 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-16T02:44:09.680-03:00");
        java.lang.String _comentarVideo_arg2 = "_comentarVideo_arg21489999929";
        java.lang.String _comentarVideo_arg3 = "_comentarVideo_arg31592880775";
        java.lang.String _comentarVideo_arg4 = "_comentarVideo_arg4-1792535704";
        port.comentarVideo(_comentarVideo_arg0, _comentarVideo_arg1, _comentarVideo_arg2, _comentarVideo_arg3, _comentarVideo_arg4);


        }
        {
        System.out.println("Invoking existeCorreo...");
        java.lang.String _existeCorreo_arg0 = "_existeCorreo_arg0-943176909";
        boolean _existeCorreo__return = port.existeCorreo(_existeCorreo_arg0);
        System.out.println("existeCorreo.result=" + _existeCorreo__return);


        }
        {
        System.out.println("Invoking prueba2...");
        java.lang.String _prueba2__return = port.prueba2();
        System.out.println("prueba2.result=" + _prueba2__return);


        }
        {
        System.out.println("Invoking responderComentario...");
        java.lang.String _responderComentario_arg0 = "_responderComentario_arg0-1720842883";
        javax.xml.datatype.XMLGregorianCalendar _responderComentario_arg1 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-16T02:44:09.696-03:00");
        java.lang.String _responderComentario_arg2 = "_responderComentario_arg2-249932208";
        java.lang.String _responderComentario_arg3 = "_responderComentario_arg3-1436426224";
        java.lang.String _responderComentario_arg4 = "_responderComentario_arg4-1610310286";
        int _responderComentario_arg5 = 1764072542;
        port.responderComentario(_responderComentario_arg0, _responderComentario_arg1, _responderComentario_arg2, _responderComentario_arg3, _responderComentario_arg4, _responderComentario_arg5);


        }
        {
        System.out.println("Invoking getDtListasParticularesUsuario...");
        java.lang.String _getDtListasParticularesUsuario_arg0 = "_getDtListasParticularesUsuario_arg0769015241";
        servicios.DtPaquete _getDtListasParticularesUsuario__return = port.getDtListasParticularesUsuario(_getDtListasParticularesUsuario_arg0);
        System.out.println("getDtListasParticularesUsuario.result=" + _getDtListasParticularesUsuario__return);


        }
        {
        System.out.println("Invoking agregarVideoLista...");
        java.lang.String _agregarVideoLista_arg0 = "_agregarVideoLista_arg0-1007829821";
        java.lang.String _agregarVideoLista_arg1 = "_agregarVideoLista_arg1-1670928901";
        java.lang.String _agregarVideoLista_arg2 = "_agregarVideoLista_arg2-941242598";
        java.lang.String _agregarVideoLista_arg3 = "_agregarVideoLista_arg31499612598";
        boolean _agregarVideoLista_arg4 = false;
        try {
            port.agregarVideoLista(_agregarVideoLista_arg0, _agregarVideoLista_arg1, _agregarVideoLista_arg2, _agregarVideoLista_arg3, _agregarVideoLista_arg4);

        } catch (InvalidDataException_Exception e) {
            System.out.println("Expected exception: InvalidDataException has occurred.");
            System.out.println(e.toString());
        } catch (DuplicateClassException_Exception e) {
            System.out.println("Expected exception: DuplicateClassException has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
