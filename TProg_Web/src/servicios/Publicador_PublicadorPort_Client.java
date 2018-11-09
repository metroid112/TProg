
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

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-09T11:00:49.756-03:00
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
        java.lang.String _prueba_arg0 = "_prueba_arg0-557237035";
        java.lang.String _prueba__return = port.prueba(_prueba_arg0);
        System.out.println("prueba.result=" + _prueba__return);


        }
        {
        System.out.println("Invoking busquedaGeneral...");
        java.lang.String _busquedaGeneral_arg0 = "_busquedaGeneral_arg031305704";
        int _busquedaGeneral_arg1 = 1067031464;
        servicios.DtPaquete _busquedaGeneral__return = port.busquedaGeneral(_busquedaGeneral_arg0, _busquedaGeneral_arg1);
        System.out.println("busquedaGeneral.result=" + _busquedaGeneral__return);


        }
        {
        System.out.println("Invoking getListaPublicoDtVideo...");
        servicios.DtPaquete _getListaPublicoDtVideo__return = port.getListaPublicoDtVideo();
        System.out.println("getListaPublicoDtVideo.result=" + _getListaPublicoDtVideo__return);


        }
        {
        System.out.println("Invoking consultaDeCategoria...");
        java.lang.String _consultaDeCategoria_arg0 = "_consultaDeCategoria_arg0-878737278";
        servicios.DtPaquete _consultaDeCategoria__return = port.consultaDeCategoria(_consultaDeCategoria_arg0);
        System.out.println("consultaDeCategoria.result=" + _consultaDeCategoria__return);


        }
        {
        System.out.println("Invoking checkLogin...");
        java.lang.String _checkLogin_arg0 = "_checkLogin_arg0-503330820";
        java.lang.String _checkLogin_arg1 = "_checkLogin_arg1-634384376";
        boolean _checkLogin__return = port.checkLogin(_checkLogin_arg0, _checkLogin_arg1);
        System.out.println("checkLogin.result=" + _checkLogin__return);


        }
        {
        System.out.println("Invoking getDtVideo...");
        int _getDtVideo_arg0 = 1525864656;
        servicios.DtPaquete _getDtVideo__return = port.getDtVideo(_getDtVideo_arg0);
        System.out.println("getDtVideo.result=" + _getDtVideo__return);


        }
        {
        System.out.println("Invoking comentarVideo...");
        java.lang.String _comentarVideo_arg0 = "_comentarVideo_arg0-921249392";
        javax.xml.datatype.XMLGregorianCalendar _comentarVideo_arg1 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-09T11:00:49.822-03:00");
        java.lang.String _comentarVideo_arg2 = "_comentarVideo_arg21899854215";
        java.lang.String _comentarVideo_arg3 = "_comentarVideo_arg3-1417775342";
        java.lang.String _comentarVideo_arg4 = "_comentarVideo_arg4-1039042507";
        port.comentarVideo(_comentarVideo_arg0, _comentarVideo_arg1, _comentarVideo_arg2, _comentarVideo_arg3, _comentarVideo_arg4);


        }
        {
        System.out.println("Invoking valorarVideo...");
        java.lang.String _valorarVideo_arg0 = "_valorarVideo_arg0-579963721";
        boolean _valorarVideo_arg1 = false;
        java.lang.String _valorarVideo_arg2 = "_valorarVideo_arg2-857713485";
        java.lang.String _valorarVideo_arg3 = "_valorarVideo_arg31418803229";
        port.valorarVideo(_valorarVideo_arg0, _valorarVideo_arg1, _valorarVideo_arg2, _valorarVideo_arg3);


        }
        {
        System.out.println("Invoking modificarValoracion...");
        boolean _modificarValoracion_arg0 = false;
        java.lang.String _modificarValoracion_arg1 = "_modificarValoracion_arg11280285481";
        java.lang.String _modificarValoracion_arg2 = "_modificarValoracion_arg2778679119";
        java.lang.String _modificarValoracion_arg3 = "_modificarValoracion_arg3-199330838";
        port.modificarValoracion(_modificarValoracion_arg0, _modificarValoracion_arg1, _modificarValoracion_arg2, _modificarValoracion_arg3);


        }
        {
        System.out.println("Invoking prueba2...");
        java.lang.String _prueba2__return = port.prueba2();
        System.out.println("prueba2.result=" + _prueba2__return);


        }
        {
        System.out.println("Invoking listarCategorias...");
        servicios.DtPaquete _listarCategorias__return = port.listarCategorias();
        System.out.println("listarCategorias.result=" + _listarCategorias__return);


        }
        {
        System.out.println("Invoking altaUsuario...");
        java.lang.String _altaUsuario_arg0 = "_altaUsuario_arg02136569618";
        java.lang.String _altaUsuario_arg1 = "_altaUsuario_arg1-1452403260";
        java.lang.String _altaUsuario_arg2 = "_altaUsuario_arg2-1250851549";
        java.lang.String _altaUsuario_arg3 = "_altaUsuario_arg31289966695";
        javax.xml.datatype.XMLGregorianCalendar _altaUsuario_arg4 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-09T11:00:49.830-03:00");
        java.lang.String _altaUsuario_arg5 = "_altaUsuario_arg51846530315";
        java.lang.String _altaUsuario_arg6 = "_altaUsuario_arg6-195690122";
        java.lang.String _altaUsuario_arg7 = "_altaUsuario_arg71913462701";
        java.lang.String _altaUsuario_arg8 = "_altaUsuario_arg869677413";
        boolean _altaUsuario_arg9 = false;
        java.lang.String _altaUsuario_arg10 = "_altaUsuario_arg101849684930";
        port.altaUsuario(_altaUsuario_arg0, _altaUsuario_arg1, _altaUsuario_arg2, _altaUsuario_arg3, _altaUsuario_arg4, _altaUsuario_arg5, _altaUsuario_arg6, _altaUsuario_arg7, _altaUsuario_arg8, _altaUsuario_arg9, _altaUsuario_arg10);


        }
        {
        System.out.println("Invoking yaCalificado...");
        java.lang.String _yaCalificado_arg0 = "_yaCalificado_arg0-1338144438";
        boolean _yaCalificado_arg1 = true;
        java.lang.String _yaCalificado_arg2 = "_yaCalificado_arg272979065";
        java.lang.String _yaCalificado_arg3 = "_yaCalificado_arg3462179105";
        boolean _yaCalificado__return = port.yaCalificado(_yaCalificado_arg0, _yaCalificado_arg1, _yaCalificado_arg2, _yaCalificado_arg3);
        System.out.println("yaCalificado.result=" + _yaCalificado__return);


        }
        {
        System.out.println("Invoking responderComentario...");
        java.lang.String _responderComentario_arg0 = "_responderComentario_arg02146532641";
        javax.xml.datatype.XMLGregorianCalendar _responderComentario_arg1 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-11-09T11:00:49.832-03:00");
        java.lang.String _responderComentario_arg2 = "_responderComentario_arg2328117592";
        java.lang.String _responderComentario_arg3 = "_responderComentario_arg3-876250063";
        java.lang.String _responderComentario_arg4 = "_responderComentario_arg4-216891592";
        int _responderComentario_arg5 = 600394047;
        port.responderComentario(_responderComentario_arg0, _responderComentario_arg1, _responderComentario_arg2, _responderComentario_arg3, _responderComentario_arg4, _responderComentario_arg5);


        }
        {
        System.out.println("Invoking busquedaCanales...");
        java.lang.String _busquedaCanales_arg0 = "_busquedaCanales_arg0-674933083";
        int _busquedaCanales_arg1 = -1152728267;
        servicios.DtPaquete _busquedaCanales__return = port.busquedaCanales(_busquedaCanales_arg0, _busquedaCanales_arg1);
        System.out.println("busquedaCanales.result=" + _busquedaCanales__return);


        }
        {
        System.out.println("Invoking busquedaVideo...");
        java.lang.String _busquedaVideo_arg0 = "_busquedaVideo_arg01712898124";
        int _busquedaVideo_arg1 = 95939331;
        servicios.DtPaquete _busquedaVideo__return = port.busquedaVideo(_busquedaVideo_arg0, _busquedaVideo_arg1);
        System.out.println("busquedaVideo.result=" + _busquedaVideo__return);


        }
        {
        System.out.println("Invoking cargarDatos...");
        port.cargarDatos();


        }
        {
        System.out.println("Invoking getListaDtVideo...");
        java.lang.String _getListaDtVideo_arg0 = "_getListaDtVideo_arg0-1021973240";
        servicios.DtPaquete _getListaDtVideo__return = port.getListaDtVideo(_getListaDtVideo_arg0);
        System.out.println("getListaDtVideo.result=" + _getListaDtVideo__return);


        }
        {
        System.out.println("Invoking getDtUsuario...");
        java.lang.String _getDtUsuario_arg0 = "_getDtUsuario_arg0-221349701";
        servicios.DtPaquete _getDtUsuario__return = port.getDtUsuario(_getDtUsuario_arg0);
        System.out.println("getDtUsuario.result=" + _getDtUsuario__return);


        }
        {
        System.out.println("Invoking busquedaLista...");
        java.lang.String _busquedaLista_arg0 = "_busquedaLista_arg0-1612604939";
        int _busquedaLista_arg1 = 477040060;
        servicios.DtPaquete _busquedaLista__return = port.busquedaLista(_busquedaLista_arg0, _busquedaLista_arg1);
        System.out.println("busquedaLista.result=" + _busquedaLista__return);


        }

        System.exit(0);
    }

}
