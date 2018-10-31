package servicios;
import java.io.IOException;
import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypes.DtBusqueda;
import datatypes.DtPaquete;
import interfaces.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
  
  private Endpoint endpoint = null;
  public Publicador() {}
  
  @WebMethod(exclude = true)
  public void publicar(){
       endpoint = Endpoint.publish("http://localhost:10135/publicador", this);
  }
  
  @WebMethod(exclude = true)
  public Endpoint getEndpoint() {
          return endpoint;
  }
  
  @WebMethod
  public String prueba(String texto) {
    return "Tevmhvmnvnm mnhmxto: " + texto;
  }
  
  @WebMethod
  public String prueba2() {
    return "prueba 2";
  }
  @WebMethod
  public void cargarDatos() {
    try {
      Fabrica.getIDatos().cargaDatos();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
//  @WebMethod
//  public DtBusqueda busquedaGeneral(String txtBusqueda) {
//    return Fabrica.getIDatos().busquedaGeneral(txtBusqueda);
//  }
//  
//  @WebMethod
//  public DtBusqueda busquedaVideo(String txtBusqueda) {
//    return Fabrica.getIDatos().busquedaVideo(txtBusqueda);
//  }
//  
//  @WebMethod
//  public DtBusqueda busquedaLista(String txtBusqueda) {
//    return Fabrica.getIDatos().busquedaLista(txtBusqueda);
//  }
//  
//  @WebMethod
//  public DtBusqueda busquedaCanales(String txtBusqueda) {
//    return Fabrica.getIDatos().busquedaCanales(txtBusqueda);
//  }
  
    @WebMethod
    public DtPaquete getPaquete(String txtBusqueda) {
      DtPaquete pack = new DtPaquete();
      pack.setContenido(Fabrica.getIDatos().busquedaGeneral(txtBusqueda));
      return pack;
    }
}
