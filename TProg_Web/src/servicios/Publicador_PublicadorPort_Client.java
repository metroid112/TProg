
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
 * 2018-11-13T21:45:24.024-03:00
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
        System.out.println("Invoking prueba...");
        java.lang.String _prueba_arg0 = "_prueba_arg0139361007";
        java.lang.String _prueba__return = port.prueba(_prueba_arg0);
        System.out.println("prueba.result=" + _prueba__return);


        }
        {
        System.out.println("Invoking consultaDeCategoria...");
        java.lang.String _consultaDeCategoria_arg0 = "_consultaDeCategoria_arg0-364607349";
        servicios.DtPaquete _consultaDeCategoria__return = port.consultaDeCategoria(_consultaDeCategoria_arg0);
        System.out.println("consultaDeCategoria.result=" + _consultaDeCategoria__return);


        }
        {
        System.out.println("Invoking checkLogin...");
        java.lang.String _checkLogin_arg0 = "_checkLogin_arg0-1550349024";
        java.lang.String _checkLogin_arg1 = "_checkLogin_arg1541701021";
        boolean _checkLogin__return = port.checkLogin(_checkLogin_arg0, _checkLogin_arg1);
        System.out.println("checkLogin.result=" + _checkLogin__return);


        }
        {
        System.out.println("Invoking getDtVideo...");
        int _getDtVideo_arg0 = 3188753;
        servicios.DtPaquete _getDtVideo__return = port.getDtVideo(_getDtVideo_arg0);
        System.out.println("getDtVideo.result=" + _getDtVideo__return);


        }
        {
        System.out.println("Invoking getSeguidos...");
        java.lang.String _getSeguidos_arg0 = "_getSeguidos_arg0587479274";
        servicios.DtPaquete _getSeguidos__return = port.getSeguidos(_getSeguidos_arg0);
        System.out.println("getSeguidos.result=" + _getSeguidos__return);


        }
        {
        System.out.println("Invoking getDtListasPrivadasUsuario...");
        java.lang.String _getDtListasPrivadasUsuario_arg0 = "_getDtListasPrivadasUsuario_arg0428304331";
        servicios.DtPaquete _getDtListasPrivadasUsuario__return = port.getDtListasPrivadasUsuario(_getDtListasPrivadasUsuario_arg0);
        System.out.println("getDtListasPrivadasUsuario.result=" + _getDtListasPrivadasUsuario__return);


        }
        {
        System.out.println("Invoking listarDtVideosDuenosLista...");
        java.lang.String _listarDtVideosDuenosLista_arg0 = "_listarDtVideosDuenosLista_arg0-308181321";
        java.lang.String _listarDtVideosDuenosLista_arg1 = "_listarDtVideosDuenosLista_arg1-591474606";
        boolean _listarDtVideosDuenosLista_arg2 = true;
        servicios.DtPaquete _listarDtVideosDuenosLista__return = port.listarDtVideosDuenosLista(_listarDtVideosDuenosLista_arg0, _listarDtVideosDuenosLista_arg1, _listarDtVideosDuenosLista_arg2);
        System.out.println("listarDtVideosDuenosLista.result=" + _listarDtVideosDuenosLista__return);


        }
        {
        System.out.println("Invoking getDtListasParticularesPublicasUsuario...");
        java.lang.String _getDtListasParticularesPublicasUsuario_arg0 = "_getDtListasParticularesPublicasUsuario_arg01512105841";
        servicios.DtPaquete _getDtListasParticularesPublicasUsuario__return = port.getDtListasParticularesPublicasUsuario(_getDtListasParticularesPublicasUsuario_arg0);
        System.out.println("getDtListasParticularesPublicasUsuario.result=" + _getDtListasParticularesPublicasUsuario__return);


        }
        {
        System.out.println("Invoking modificarValoracion...");
        boolean _modificarValoracion_arg0 = true;
        java.lang.String _modificarValoracion_arg1 = "_modificarValoracion_arg11191488994";
        java.lang.String _modificarValoracion_arg2 = "_modificarValoracion_arg2739984853";
        java.lang.String _modificarValoracion_arg3 = "_modificarValoracion_arg3839440278";
        port.modificarValoracion(_modificarValoracion_arg0, _modificarValoracion_arg1, _modificarValoracion_arg2, _modificarValoracion_arg3);


        }
        {
        System.out.println("Invoking listarNombresUsuarios...");
        servicios.DtPaquete _listarNombresUsuarios__return = port.listarNombresUsuarios();
        System.out.println("listarNombresUsuarios.result=" + _listarNombresUsuarios__return);


        }
        {
        System.out.println("Invoking getDtVideosPublicos...");
        java.lang.String _getDtVideosPublicos_arg0 = "_getDtVideosPublicos_arg01536384851";
        servicios.DtPaquete _getDtVideosPublicos__return = port.getDtVideosPublicos(_getDtVideosPublicos_arg0);
        System.out.println("getDtVideosPublicos.result=" + _getDtVideosPublicos__return);


        }
        {
        System.out.println("Invoking altaListaParticular...");
        java.lang.String _altaListaParticular_arg0 = "_altaListaParticular_arg0-580363212";
        java.lang.String _altaListaParticular_arg1 = "_altaListaParticular_arg11277541276";
        boolean _altaListaParticular_arg2 = true;
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
        System.out.println("Invoking getDtDefecto...");
        java.lang.String _getDtDefecto_arg0 = "_getDtDefecto_arg0-1041629351";
        java.lang.String _getDtDefecto_arg1 = "_getDtDefecto_arg1-547446064";
        servicios.DtPaquete _getDtDefecto__return = port.getDtDefecto(_getDtDefecto_arg0, _getDtDefecto_arg1);
        System.out.println("getDtDefecto.result=" + _getDtDefecto__return);


        }
        {
        System.out.println("Invoking yaCalificado...");
        java.lang.String _yaCalificado_arg0 = "_yaCalificado_arg0-509983792";
        boolean _yaCalificado_arg1 = false;
        java.lang.String _yaCalificado_arg2 = "_yaCalificado_arg2312611746";
        java.lang.String _yaCalificado_arg3 = "_yaCalificado_arg3-459761305";
        boolean _yaCalificado__return = port.yaCalificado(_yaCalificado_arg0, _yaCalificado_arg1, _yaCalificado_arg2, _yaCalificado_arg3);
        System.out.println("yaCalificado.result=" + _yaCalificado__return);


        }
        {
        System.out.println("Invoking getImagen...");
        java.lang.String _getImagen_arg0 = "_getImagen_arg01757379792";
        byte[] _getImagen__return = port.getImagen(_getImagen_arg0);
        System.out.println("getImagen.result=" + _getImagen__return);


        }
        {
        System.out.println("Invoking getListasPublicas...");
        servicios.DtPaquete _getListasPublicas__return = port.getListasPublicas();
        System.out.println("getListasPublicas.result=" + _getListasPublicas__return);


        }
        {
        System.out.println("Invoking dejarSeguir...");
        java.lang.String _dejarSeguir_arg0 = "_dejarSeguir_arg01821623050";
        java.lang.String _dejarSeguir_arg1 = "_dejarSeguir_arg1-1396459597";
        port.dejarSeguir(_dejarSeguir_arg0, _dejarSeguir_arg1);


        }
        {
        System.out.println("Invoking busquedaVideo...");
        java.lang.String _busquedaVideo_arg0 = "_busquedaVideo_arg01985935655";
        int _busquedaVideo_arg1 = 863588046;
        servicios.DtPaquete _busquedaVideo__return = port.busquedaVideo(_busquedaVideo_arg0, _busquedaVideo_arg1);
        System.out.println("busquedaVideo.result=" + _busquedaVideo__return);


        }
        {
        System.out.println("Invoking cargarDatos...");
        port.cargarDatos();


        }
        {
        System.out.println("Invoking getSeguidores...");
        java.lang.String _getSeguidores_arg0 = "_getSeguidores_arg0-633218213";
        servicios.DtPaquete _getSeguidores__return = port.getSeguidores(_getSeguidores_arg0);
        System.out.println("getSeguidores.result=" + _getSeguidores__return);


        }
        {
        System.out.println("Invoking isSeguidor...");
        java.lang.String _isSeguidor_arg0 = "_isSeguidor_arg0-1638622819";
        java.lang.String _isSeguidor_arg1 = "_isSeguidor_arg1675327825";
        boolean _isSeguidor__return = port.isSeguidor(_isSeguidor_arg0, _isSeguidor_arg1);
        System.out.println("isSeguidor.result=" + _isSeguidor__return);


        }
        {
        System.out.println("Invoking quitarVideoLista...");
        java.lang.String _quitarVideoLista_arg0 = "_quitarVideoLista_arg01002327251";
        java.lang.String _quitarVideoLista_arg1 = "_quitarVideoLista_arg1-1841564292";
        java.lang.String _quitarVideoLista_arg2 = "_quitarVideoLista_arg2-1111036765";
        java.lang.String _quitarVideoLista_arg3 = "_quitarVideoLista_arg325134343";
        boolean _quitarVideoLista_arg4 = false;
        port.quitarVideoLista(_quitarVideoLista_arg0, _quitarVideoLista_arg1, _quitarVideoLista_arg2, _quitarVideoLista_arg3, _quitarVideoLista_arg4);


        }
        {
        System.out.println("Invoking getDtLista...");
        int _getDtLista_arg0 = -214400559;
        servicios.DtPaquete _getDtLista__return = port.getDtLista(_getDtLista_arg0);
        System.out.println("getDtLista.result=" + _getDtLista__return);


        }
        {
        System.out.println("Invoking getDtListasDefectoUsuario...");
        java.lang.String _getDtListasDefectoUsuario_arg0 = "_getDtListasDefectoUsuario_arg01989304863";
        servicios.DtPaquete _getDtListasDefectoUsuario__return = port.getDtListasDefectoUsuario(_getDtListasDefectoUsuario_arg0);
        System.out.println("getDtListasDefectoUsuario.result=" + _getDtListasDefectoUsuario__return);


        }
        {
        System.out.println("Invoking seguir...");
        java.lang.String _seguir_arg0 = "_seguir_arg0872345706";
        java.lang.String _seguir_arg1 = "_seguir_arg1377753388";
        port.seguir(_seguir_arg0, _seguir_arg1);


        }
        {
        System.out.println("Invoking listarListasParticularUsuario...");
        java.lang.String _listarListasParticularUsuario_arg0 = "_listarListasParticularUsuario_arg01199021943";
        servicios.DtPaquete _listarListasParticularUsuario__return = port.listarListasParticularUsuario(_listarListasParticularUsuario_arg0);
        System.out.println("listarListasParticularUsuario.result=" + _listarListasParticularUsuario__return);


        }
        {
        System.out.println("Invoking busquedaLista...");
        java.lang.String _busquedaLista_arg0 = "_busquedaLista_arg0-420918107";
        int _busquedaLista_arg1 = 489054948;
        servicios.DtPaquete _busquedaLista__return = port.busquedaLista(_busquedaLista_arg0, _busquedaLista_arg1);
        System.out.println("busquedaLista.result=" + _busquedaLista__return);


        }
        {
        System.out.println("Invoking listarTodosLosVideos...");
        java.lang.String _listarTodosLosVideos_arg0 = "_listarTodosLosVideos_arg0-624247694";
        servicios.DtPaquete _listarTodosLosVideos__return = port.listarTodosLosVideos(_listarTodosLosVideos_arg0);
        System.out.println("listarTodosLosVideos.result=" + _listarTodosLosVideos__return);


        }
        {
        System.out.println("Invoking busquedaGeneral...");
        java.lang.String _busquedaGeneral_arg0 = "_busquedaGeneral_arg01747223742";
        int _busquedaGeneral_arg1 = -688238232;
        servicios.DtPaquete _busquedaGeneral__return = port.busquedaGeneral(_busquedaGeneral_arg0, _busquedaGeneral_arg1);
        System.out.println("busquedaGeneral.result=" + _busquedaGeneral__return);


        }
        {
        System.out.println("Invoking getListaPublicoDtVideo...");
        servicios.DtPaquete _getListaPublicoDtVideo__return = port.getListaPublicoDtVideo();
        System.out.println("getListaPublicoDtVideo.result=" + _getListaPublicoDtVideo__return);


        }
        {
        System.out.println("Invoking comentarVideo...");
        java.lang.String _comentarVideo_arg0 = "_comentarVideo_arg0-764827455";
        javax.xml.datatype.XMLGregorianCalendar _comentarVideo_arg1 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-13T21:45:24.102-03:00");
        java.lang.String _comentarVideo_arg2 = "_comentarVideo_arg21353900906";
        java.lang.String _comentarVideo_arg3 = "_comentarVideo_arg3-1669301547";
        java.lang.String _comentarVideo_arg4 = "_comentarVideo_arg42119257052";
        port.comentarVideo(_comentarVideo_arg0, _comentarVideo_arg1, _comentarVideo_arg2, _comentarVideo_arg3, _comentarVideo_arg4);


        }
        {
        System.out.println("Invoking valorarVideo...");
        java.lang.String _valorarVideo_arg0 = "_valorarVideo_arg01262431748";
        boolean _valorarVideo_arg1 = true;
        java.lang.String _valorarVideo_arg2 = "_valorarVideo_arg21310023875";
        java.lang.String _valorarVideo_arg3 = "_valorarVideo_arg3-269465699";
        port.valorarVideo(_valorarVideo_arg0, _valorarVideo_arg1, _valorarVideo_arg2, _valorarVideo_arg3);


        }
        {
        System.out.println("Invoking listarListasDefectoUsuario...");
        java.lang.String _listarListasDefectoUsuario_arg0 = "_listarListasDefectoUsuario_arg0-294306696";
        servicios.DtPaquete _listarListasDefectoUsuario__return = port.listarListasDefectoUsuario(_listarListasDefectoUsuario_arg0);
        System.out.println("listarListasDefectoUsuario.result=" + _listarListasDefectoUsuario__return);


        }
        {
        System.out.println("Invoking prueba2...");
        java.lang.String _prueba2__return = port.prueba2();
        System.out.println("prueba2.result=" + _prueba2__return);


        }
        {
        System.out.println("Invoking altaUsuario...");
        java.lang.String _altaUsuario_arg0 = "_altaUsuario_arg0504308124";
        java.lang.String _altaUsuario_arg1 = "_altaUsuario_arg1-1399264866";
        java.lang.String _altaUsuario_arg2 = "_altaUsuario_arg22078520462";
        java.lang.String _altaUsuario_arg3 = "_altaUsuario_arg3-1907063036";
        javax.xml.datatype.XMLGregorianCalendar _altaUsuario_arg4 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-13T21:45:24.118-03:00");
        byte[] _altaUsuario_imagen = new byte[] {};
        java.lang.String _altaUsuario_arg6 = "_altaUsuario_arg6-51781461";
        java.lang.String _altaUsuario_arg7 = "_altaUsuario_arg7-1056372234";
        java.lang.String _altaUsuario_arg8 = "_altaUsuario_arg8-610059963";
        boolean _altaUsuario_arg9 = true;
        java.lang.String _altaUsuario_arg10 = "_altaUsuario_arg102062837465";
        port.altaUsuario(_altaUsuario_arg0, _altaUsuario_arg1, _altaUsuario_arg2, _altaUsuario_arg3, _altaUsuario_arg4, _altaUsuario_imagen, _altaUsuario_arg6, _altaUsuario_arg7, _altaUsuario_arg8, _altaUsuario_arg9, _altaUsuario_arg10);


        }
        {
        System.out.println("Invoking responderComentario...");
        java.lang.String _responderComentario_arg0 = "_responderComentario_arg0-81966959";
        javax.xml.datatype.XMLGregorianCalendar _responderComentario_arg1 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-13T21:45:24.118-03:00");
        java.lang.String _responderComentario_arg2 = "_responderComentario_arg2-1211971674";
        java.lang.String _responderComentario_arg3 = "_responderComentario_arg3853797460";
        java.lang.String _responderComentario_arg4 = "_responderComentario_arg4834495425";
        int _responderComentario_arg5 = 766502493;
        port.responderComentario(_responderComentario_arg0, _responderComentario_arg1, _responderComentario_arg2, _responderComentario_arg3, _responderComentario_arg4, _responderComentario_arg5);


        }
        {
        System.out.println("Invoking busquedaCanales...");
        java.lang.String _busquedaCanales_arg0 = "_busquedaCanales_arg0126736333";
        int _busquedaCanales_arg1 = -1203051026;
        servicios.DtPaquete _busquedaCanales__return = port.busquedaCanales(_busquedaCanales_arg0, _busquedaCanales_arg1);
        System.out.println("busquedaCanales.result=" + _busquedaCanales__return);


        }
        {
        System.out.println("Invoking agregarVideoLista...");
        java.lang.String _agregarVideoLista_arg0 = "_agregarVideoLista_arg0-1464880710";
        java.lang.String _agregarVideoLista_arg1 = "_agregarVideoLista_arg1-1585639006";
        java.lang.String _agregarVideoLista_arg2 = "_agregarVideoLista_arg2543223089";
        java.lang.String _agregarVideoLista_arg3 = "_agregarVideoLista_arg31441126070";
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
        {
        System.out.println("Invoking getListaDtVideo...");
        java.lang.String _getListaDtVideo_arg0 = "_getListaDtVideo_arg01086691446";
        servicios.DtPaquete _getListaDtVideo__return = port.getListaDtVideo(_getListaDtVideo_arg0);
        System.out.println("getListaDtVideo.result=" + _getListaDtVideo__return);


        }
        {
        System.out.println("Invoking getDtUsuario...");
        java.lang.String _getDtUsuario_arg0 = "_getDtUsuario_arg0-1858876923";
        servicios.DtPaquete _getDtUsuario__return = port.getDtUsuario(_getDtUsuario_arg0);
        System.out.println("getDtUsuario.result=" + _getDtUsuario__return);


        }

        System.exit(0);
    }

}
