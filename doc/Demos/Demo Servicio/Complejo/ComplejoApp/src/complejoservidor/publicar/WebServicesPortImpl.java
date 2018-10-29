
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package complejoservidor.publicar;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-10-23T17:06:18.804-03:00
 * Generated source version: 3.2.0
 * 
 */

@javax.jws.WebService(
                      serviceName = "WebServicesService",
                      portName = "WebServicesPort",
                      targetNamespace = "http://publicar.complejoservidor/",
                      wsdlLocation = "http://localhost:9128/webservices?wsdl",
                      endpointInterface = "complejoservidor.publicar.WebServices")
                      
public class WebServicesPortImpl implements WebServices {

    private static final Logger LOG = Logger.getLogger(WebServicesPortImpl.class.getName());

    /* (non-Javadoc)
     * @see complejoservidor.publicar.WebServices#obtenerApellido(complejoservidor.publicar.DataPersona arg0)*
     */
    public java.lang.String obtenerApellido(DataPersona arg0) { 
        LOG.info("Executing operation obtenerApellido");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-405232193";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see complejoservidor.publicar.WebServices#getFile(java.lang.String fileName)*
     */
    public byte[] getFile(java.lang.String fileName) throws IOException_Exception   { 
        LOG.info("Executing operation getFile");
        System.out.println(fileName);
        try {
            byte[] _return = new byte[] {};
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new IOException_Exception("IOException...");
    }

    /* (non-Javadoc)
     * @see complejoservidor.publicar.WebServices#obtenerConvocados(java.lang.String arg0)*
     */
    public complejoservidor.publicar.DataMaestro obtenerConvocados(java.lang.String arg0) { 
        LOG.info("Executing operation obtenerConvocados");
        System.out.println(arg0);
        try {
            complejoservidor.publicar.DataMaestro _return = new complejoservidor.publicar.DataMaestro();
            _return.setNombre("Nombre-160630351");
            _return.setApellido("Apellido1618811993");
            java.util.List<complejoservidor.publicar.DataPersona> _returnConvocados = new java.util.ArrayList<complejoservidor.publicar.DataPersona>();
            complejoservidor.publicar.DataPersona _returnConvocadosVal1 = new complejoservidor.publicar.DataPersona();
            _returnConvocadosVal1.setNombre("Nombre-64749321");
            _returnConvocadosVal1.setApellido("Apellido-369819320");
            _returnConvocadosVal1.setImagen("Imagen563325863");
            _returnConvocados.add(_returnConvocadosVal1);
            _return.getConvocados().addAll(_returnConvocados);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}