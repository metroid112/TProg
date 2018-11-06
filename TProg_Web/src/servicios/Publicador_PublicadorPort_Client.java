
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
 * 2018-11-04T20:00:34.101-03:00
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
        java.lang.String _prueba_arg0 = "_prueba_arg0-1339133920";
        java.lang.String _prueba__return = port.prueba(_prueba_arg0);
        System.out.println("prueba.result=" + _prueba__return);


        }
        {
        System.out.println("Invoking busquedaGeneral...");
        java.lang.String _busquedaGeneral_arg0 = "_busquedaGeneral_arg0-1146424420";
        int _busquedaGeneral_arg1 = 601642179;
        servicios.DtPaquete _busquedaGeneral__return = port.busquedaGeneral(_busquedaGeneral_arg0, _busquedaGeneral_arg1);
        System.out.println("busquedaGeneral.result=" + _busquedaGeneral__return);


        }
        {
        System.out.println("Invoking busquedaCanales...");
        java.lang.String _busquedaCanales_arg0 = "_busquedaCanales_arg0968076646";
        int _busquedaCanales_arg1 = -575399104;
        servicios.DtPaquete _busquedaCanales__return = port.busquedaCanales(_busquedaCanales_arg0, _busquedaCanales_arg1);
        System.out.println("busquedaCanales.result=" + _busquedaCanales__return);


        }
        {
        System.out.println("Invoking consultaDeCategoria...");
        java.lang.String _consultaDeCategoria_arg0 = "_consultaDeCategoria_arg0-961402725";
        servicios.DtPaquete _consultaDeCategoria__return = port.consultaDeCategoria(_consultaDeCategoria_arg0);
        System.out.println("consultaDeCategoria.result=" + _consultaDeCategoria__return);


        }
        {
        System.out.println("Invoking busquedaVideo...");
        java.lang.String _busquedaVideo_arg0 = "_busquedaVideo_arg0-2000267136";
        int _busquedaVideo_arg1 = -1135006686;
        servicios.DtPaquete _busquedaVideo__return = port.busquedaVideo(_busquedaVideo_arg0, _busquedaVideo_arg1);
        System.out.println("busquedaVideo.result=" + _busquedaVideo__return);


        }
        {
        System.out.println("Invoking cargarDatos...");
        port.cargarDatos();


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
        System.out.println("Invoking busquedaLista...");
        java.lang.String _busquedaLista_arg0 = "_busquedaLista_arg01813216337";
        int _busquedaLista_arg1 = 749716055;
        servicios.DtPaquete _busquedaLista__return = port.busquedaLista(_busquedaLista_arg0, _busquedaLista_arg1);
        System.out.println("busquedaLista.result=" + _busquedaLista__return);


        }

        System.exit(0);
    }

}