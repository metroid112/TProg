
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package servicios;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-01T16:20:44.002-03:00
 * Generated source version: 3.2.6
 *
 */

@javax.jws.WebService(
                      serviceName = "PublicadorService",
                      portName = "PublicadorPort",
                      targetNamespace = "http://servicios/",
                      wsdlLocation = "http://localhost:10135/publicador?wsdl",
                      endpointInterface = "servicios.Publicador")

public class PublicadorPortImpl implements Publicador {

    private static final Logger LOG = Logger.getLogger(PublicadorPortImpl.class.getName());

    /* (non-Javadoc)
     * @see servicios.Publicador#prueba(java.lang.String arg0)*
     */
    public java.lang.String prueba(java.lang.String arg0) {
        LOG.info("Executing operation prueba");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-2047930507";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaCanales(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaCanales(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaCanales");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaGeneral(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaGeneral(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaGeneral");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaVideo(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaVideo(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaVideo");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#cargarDatos()*
     */
    public void cargarDatos() {
        LOG.info("Executing operation cargarDatos");
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#prueba2()*
     */
    public java.lang.String prueba2() {
        LOG.info("Executing operation prueba2");
        try {
            java.lang.String _return = "_return256638186";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see servicios.Publicador#busquedaLista(java.lang.String arg0, int arg1)*
     */
    public servicios.DtPaquete busquedaLista(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation busquedaLista");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            servicios.DtPaquete _return = new servicios.DtPaquete();
            servicios.DtUniversal _returnContenido = null;
            _return.setContenido(_returnContenido);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
