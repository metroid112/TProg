package servicios;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypes.DtBusqueda;
import datatypes.DtPaquete;
import datatypes.DtUniversal;
import datatypes.DtVideo;
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
  
  @WebMethod
  public DtPaquete busquedaGeneral(String txtBusqueda, int orden) {
    return empaquetar(Fabrica.getIDatos().busquedaGeneral(txtBusqueda, orden));
  }
  
  @WebMethod
  public DtPaquete busquedaVideo(String txtBusqueda, int orden) {
    return empaquetar(Fabrica.getIDatos().busquedaVideo(txtBusqueda, orden));
  }
  
  @WebMethod
  public DtPaquete busquedaLista(String txtBusqueda, int orden) {
    return empaquetar(Fabrica.getIDatos().busquedaLista(txtBusqueda, orden));
  }
  
  @WebMethod
  public DtPaquete busquedaCanales(String txtBusqueda, int orden) {
    return empaquetar(Fabrica.getIDatos().busquedaCanales(txtBusqueda, orden));
  }
  
  @WebMethod
  public DtPaquete listarCategorias() {
    return empaquetar2(Fabrica.getICategorias().listarCategorias());
  }
  
  @WebMethod
  public DtPaquete consultaDeCategoria(String categoria) {
    return empaquetar(Fabrica.getICategorias().consultaDeCategoria(categoria));
  }
  
  @WebMethod
  public DtPaquete listarTodosLosVideos(String nick) throws Exception {
    List<?extends DtUniversal> lista = Fabrica.getIVideos().listarTodosLosVideos(nick);
    return empaquetar2(lista);
  }
  
  @WebMethod
  public DtPaquete listarListasDefectoUsuario(String nick) {
    List<String> listaDefecto = Fabrica.getIListas().listarListasDefectoUsuario(nick);
    return empaquetar(listaDefecto);
  }
  
  @WebMethod
  public DtPaquete listarListasParticularUsuario(String nick) {
    List<String> listaParticular = Fabrica.getIListas().listarListasParticularUsuario(nick);
    return empaquetar(listaParticular);
  }
  

  
  /**
   * Empaqueta un data type generico
   * @param contenido
   * Data type que extienda DtUniversal
   */
  @WebMethod(exclude = true)
  public DtPaquete empaquetar(DtUniversal contenido) {
    DtPaquete pack = new DtPaquete();
    pack.setContenido(contenido);
    return pack;
  }
  
  /**
   * Empaqueta una lista de string
   * @param lista
   * LinkedList de string a empaquetar
   */
  @WebMethod(exclude = true)
  public DtPaquete empaquetar(List<String> lista) {
    DtPaquete pack = new DtPaquete();
    pack.setListaAux(lista);
    return pack;
  }
  
  @WebMethod(exclude = true)
  public DtPaquete empaquetar2(List<? extends DtUniversal> lista) {
    DtPaquete pack = new DtPaquete();
    pack.setListaDt(lista);
    return pack;
  }
    
}
