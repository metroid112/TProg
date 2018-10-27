/**
 * 
 */
package complejoservidor.publicar;

/**
 * @author efviodo
 *
 */

import complejoservidor.Logica;
import complejoservidor.types.DataMaestro;
import complejoservidor.types.DataPersona;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServices {

    private Endpoint endpoint = null;
    //Constructor
    public WebServices(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/webservices", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    @WebMethod
    public String obtenerApellido(DataPersona dp){
        Logica l = new Logica();
        return l.obtenerApellido(dp);
    }
    @WebMethod
    public DataMaestro obtenerConvocados(String apellido){
        Logica l = new Logica();
        return l.obtenerConvocados(apellido);
    }
    @WebMethod
    public byte[] getFile(@WebParam(name = "fileName") String name)
                    throws  IOException {
        byte[] byteArray = null;
        try {
                File f = new File("files/" + name);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
        } catch (IOException e) {
                throw e;
        }
        return byteArray;
    }
}

