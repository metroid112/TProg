/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;
import logica.Logica;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
/**
 *
 * @author Pablo
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

    private Logica logica = new Logica();
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9129/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    @WebMethod
    public int suma(int i, int j){
        Logica log = new Logica();
        int ret = log.sumar(i,j);
        return ret;
    }

    @WebMethod
    public int restar(int i, int j){
        int ret = logica.restar(i,j);
        return ret;
    }

}
