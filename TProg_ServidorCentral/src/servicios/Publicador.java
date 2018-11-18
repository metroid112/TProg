package servicios;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.Duration;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.Endpoint;

import org.apache.tika.io.IOUtils;

import datatypes.DtCategoria;
import datatypes.DtPaquete;
import datatypes.DtUniversal;
import datatypes.DtUsuario;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IUsuariosCanales;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
  
  private Endpoint endpoint = null;
  public Publicador() {}
  
  @WebMethod(exclude = true)
  public void publicar(){
     
      try {
        Properties prop = new Properties();
        InputStream in = new FileInputStream("config.properties");
        prop.load(in);
        endpoint = Endpoint.publish(prop.getProperty("wsdlURL"), this);
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
       
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
  public void AltaUsuario(String nickname, String nombre, String apellido, String correo,
      GregorianCalendar fechaNacimiento,
      @XmlElement(required = false, name = "imagen")
      @WebParam(name = "imagen", header = true) byte[] imgByte, String nombreCanal,
      String descripcionCanal, String categoria, boolean visible, String pass) {
    
    Fabrica.getIUsuariosCanales().altaUsuario(nickname, nombre, apellido, correo,
        fechaNacimiento.getTime(),
        imgByte, nombreCanal, descripcionCanal, categoria, visible, pass);
  }
  
  @WebMethod
  public void altaListaParticular(String nombreLista, String nickUsuario, Boolean visibilidad) throws DuplicateClassException {
    Fabrica.getIListas().altaListaParticular(nombreLista, nickUsuario, visibilidad);
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
    DtPaquete pack = new DtPaquete();
    List<String> listaCat = new LinkedList<String>();
    List<DtUniversal> listaCatDt = new LinkedList<DtUniversal>();
    for (DtCategoria dato : Fabrica.getICategorias().listarCategorias()) {
      listaCat.add(dato.getNombre());
      listaCatDt.add(dato);
    };
    pack.setListaDt(listaCatDt);
    pack.setListaAux(listaCat);
    return pack;
  }
  
  @WebMethod
  public DtPaquete consultaDeCategoria(String categoria) {
    return empaquetar(Fabrica.getICategorias().consultaDeCategoria(categoria));
  }
  
  @WebMethod
  public DtPaquete listarTodosLosVideos(String nick) {
    DtPaquete pack = new DtPaquete();
    List<DtUniversal> listaUniversal = new LinkedList<DtUniversal>(); 
    for (DtUniversal dato : Fabrica.getIVideos().listarTodosLosVideos(nick)) {
      listaUniversal.add(dato);
    };
    pack.setListaDt(listaUniversal);
    return pack;
  }
  
  @WebMethod
  public DtPaquete listarDtVideosDuenosLista(String usuario, String lista, boolean defecto) {
    DtPaquete pack = new DtPaquete();
    List<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dato : Fabrica.getIUsuariosCanales().listarDtVideosDuenosLista(usuario, lista, defecto)) {
      listaUniversal.add(dato);
    };
    pack.setListaDt(listaUniversal);
    return pack;
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
  

  @WebMethod  
  public boolean checkLogin(String nick, String pass) {
    IUsuariosCanales iUC = Fabrica.getIUsuariosCanales();
    if (iUC.existeUsuario(nick) || iUC.existeUsuarioMail(nick)) {
      return iUC.checkLogin(nick, pass);
    } else {
      return false;
    }
  }
  
  @WebMethod
  public DtPaquete getDtUsuario(String nick) {
    return empaquetar(Fabrica.getIUsuariosCanales().getDt(nick));
  }
  
  @WebMethod
  public DtPaquete getDtVideo(int idVideo) {
    try {
      return empaquetar(Fabrica.getIVideos().getDtVideo(idVideo));
    } catch (NotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }
  
  @WebMethod
  public DtPaquete getDtVideosPropietario(String usuario) {
    List<DtUniversal> listaUni = new LinkedList<DtUniversal>();
    for (DtUniversal dtUni : Fabrica.getIVideos().getDtVideosPropietario(usuario)) {
      listaUni.add(dtUni);
    }
    DtPaquete pack = new DtPaquete();
    pack.setListaDt(listaUni);
    return pack;
  }
  
  @WebMethod 
  public void modificarVideo(String nick, String nombreOld, String nombre, String descripcion, String url,
      String categoria, long duracionSeg, boolean visible, GregorianCalendar fechaCalendario) {
    try {
      Duration duracion = Duration.ofSeconds(duracionSeg);
      Fabrica.getIVideos().modificarVideo(nick, nombreOld, nombre, descripcion, url, categoria,
          duracion, visible, fechaCalendario.getTime());
    } catch (InvalidDataException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DuplicateClassException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @WebMethod
  public boolean yaCalificado(String nombreUsuario, boolean like, String nombreVideo, String nombreDuenoVideo) {
    return Fabrica.getIUsuariosCanales().yaCalificacdo(nombreUsuario, like, nombreVideo, nombreDuenoVideo);
  }
  
  @WebMethod
  public void valorarVideo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo) {
    Fabrica.getIUsuariosCanales().valorarVideo(nombreUsuario, like, nombreVideo, nombreDuenoVideo);
  }
  
  @WebMethod
  public void modificarValoracion(boolean like, String nombreUsuario, String nombreVideo,
      String nombreDuenoVideo) {
    Fabrica.getIUsuariosCanales().modificarValoracion(like, nombreUsuario, nombreVideo, nombreDuenoVideo);
  }
  
  @WebMethod
  public void comentarVideo(String texto, GregorianCalendar calendario, String nombreUsuario,
      String nombreVideo, String nombreDuenoVideo) {
    Date fecha = calendario.getTime();
    Fabrica.getIUsuariosCanales().comentarVideo(texto, fecha, nombreUsuario, nombreVideo, nombreDuenoVideo);
  }
  
  @WebMethod
  public void responderComentario(String texto, GregorianCalendar calendario, String nombreUsuario,
      String nombreVideo, String nombreDuenoVideo, int idComentarioPadre) {
    Fabrica.getIUsuariosCanales().responderComentario(texto, calendario.getTime(), nombreUsuario, nombreVideo, nombreDuenoVideo, idComentarioPadre);
  }
  
  @WebMethod
  public DtPaquete getListaPublicoDtVideo() {
    DtPaquete pack = new DtPaquete();
    List<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dato : Fabrica.getIUsuariosCanales().getListaPublicoDtVideo()) {
      listaUniversal.add(dato);      
    }
    pack.setListaDt(listaUniversal);
    return pack;
  }
  
  @WebMethod
  public DtPaquete getListaDtVideo(String nick) {
    DtPaquete pack = new DtPaquete();
    List<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dato : Fabrica.getIUsuariosCanales().getListaDtVideo(nick)) {
      listaUniversal.add(dato);      
    }
    pack.setListaDt(listaUniversal);
    return pack;
  }
  
  @WebMethod

  public DtPaquete getListasPublicas(){
    DtPaquete pack = new DtPaquete();
    LinkedList<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dato : Fabrica.getIListas().getDtListasPublicas()) {
      listaUniversal.add(dato);      
    }
    pack.setListaDt(listaUniversal);    
    return pack;
  }
  
  @WebMethod
  public DtPaquete getDtListasPrivadasUsuario(String nick){
    DtPaquete pack = new DtPaquete();
    LinkedList<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dato : Fabrica.getIListas().getDtListasPrivadasUsuario(nick)) {
      listaUniversal.add(dato);      
    }
    pack.setListaDt(listaUniversal);   
    return pack;
  }
  
  @WebMethod
  public DtPaquete getDtListasDefectoUsuario(String nick){
    DtPaquete pack = new DtPaquete();
    LinkedList<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dato : Fabrica.getIListas().getDtListasDefectoUsuario(nick)) {
      listaUniversal.add(dato);      
    }
    pack.setListaDt(listaUniversal);    
    return pack;
  }
  
  @WebMethod
  public DtPaquete getDtDefecto(String usuario, String nombreListaDefecto){
    DtPaquete pack = new DtPaquete();
    DtUniversal universal = Fabrica.getIListas().getDtDefecto(usuario, nombreListaDefecto);
    pack.setContenido(universal);
    return pack;
  }
  
  @WebMethod
  public DtPaquete getDtLista(int idLista){
    try{
    DtPaquete pack = new DtPaquete();
    DtUniversal universal = Fabrica.getIListas().getDt(idLista);
    pack.setContenido(universal);
    return pack;
    }
    catch(NotFoundException e){
      return null;
    }
  }
 
  @WebMethod


  public void agregarVideoLista(String nombreOwnerVideo, String nombreVideo, String usuario,
      String nombreLista, Boolean defecto) throws DuplicateClassException, InvalidDataException {

    Fabrica.getIListas().agregarVideoLista(nombreOwnerVideo, nombreVideo, usuario, nombreLista, defecto);
  }
  
  @WebMethod
  public byte[] getImagen(String id) {
    byte[] imagenByte = null;
    try {
      File imagen = new File("media/" + id);
      FileInputStream inStream = new FileInputStream(imagen);
      imagenByte = IOUtils.toByteArray(inStream);      
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Archivo no encontrado: " + id);
    }    
    return imagenByte;
  }
  
  @WebMethod
  public void borrarUsuario(String nickUsuario) throws NotFoundException {
    Fabrica.getIUsuariosCanales().bajaUsuario(nickUsuario);
  }
  
  @WebMethod
  public void quitarVideoLista(String usuario, String nombreVideo, String nombreOwnerVideo, String lista, Boolean defecto) {
    Fabrica.getIListas().quitarVideoLista(usuario, nombreVideo, nombreOwnerVideo, lista, defecto);
  }
  
  @WebMethod
  public void seguir(String seguidor, String seguido) {
    Fabrica.getIUsuariosCanales().seguir(seguidor, seguido);
  }
  
  @WebMethod
  public void dejarSeguir(String seguidor, String seguido) {
    Fabrica.getIUsuariosCanales().dejarSeguir(seguidor, seguido);
  }
  
  @WebMethod
  public DtPaquete listarNombresUsuarios() {
    DtPaquete pack = new DtPaquete();
    List<String> usuarios = Fabrica.getIUsuariosCanales().listarNombresUsuarios();
    pack.setListaAux(usuarios);

    return pack;
  }
  
  @WebMethod
  public DtPaquete getDtVideosPublicos(String nick) {
    DtPaquete pack = new DtPaquete();
    List<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dtUniversal : Fabrica.getIVideos().getDtVideosPublicos(nick)) {
      listaUniversal.add(dtUniversal);
    }
    pack.setListaDt(listaUniversal);
    return pack;
  }
  
  @WebMethod
  public DtPaquete getDtListasParticularesPublicasUsuario(String nick) {
    DtPaquete pack = new DtPaquete();
    List<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dtUniversal : Fabrica.getIListas().getDtListasParticularesPublicasUsuario(nick)) {
      listaUniversal.add(dtUniversal);
    }
    pack.setListaDt(listaUniversal);
    return pack;
  }
  
  @WebMethod
  public DtPaquete getDtListasParticularesUsuario(String nick) {
    DtPaquete pack = new DtPaquete();
    List<DtUniversal> listaUniversal = new LinkedList<DtUniversal>();
    for (DtUniversal dtUniversal : Fabrica.getIListas().getDtListasParticularesUsuario(nick)) {
      listaUniversal.add(dtUniversal);
    }
    pack.setListaDt(listaUniversal);
    return pack;
  }
  
  @WebMethod
  public DtPaquete getDt(int idLista) {
    try {
      return empaquetar(Fabrica.getIListas().getDt(idLista));
    } catch (NotFoundException e) {
      return null;
    }
  }
  
  @WebMethod
  public void guardarCambios(String nombreLista, String usuario, Boolean visibilidad) {
    Fabrica.getIListas().guardarCambios(nombreLista, usuario, visibilidad);
  }
  
  @WebMethod
  public DtPaquete getSeguidores(String usuario) {
    return empaquetar(Fabrica.getIUsuariosCanales().getSeguidores(usuario));
  }
  
  @WebMethod
  public DtPaquete getSeguidos(String usuario) {
    return empaquetar(Fabrica.getIUsuariosCanales().getSeguidos(usuario));
  }
  
  @WebMethod
  public boolean isSeguidor(String seguidor, String seguido) {
    return Fabrica.getIUsuariosCanales().isSeguidor(seguidor, seguido);
  }
  
  @WebMethod
  public void modificarUsuario(String nickUsuarioOriginal, DtUniversal usuarioModificado, @XmlElement(required = false, name = "imagen")
  @WebParam(name = "imagen", header = true) byte[] img) throws DuplicateClassException, NotFoundException {
    Fabrica.getIUsuariosCanales().modificarUsuario(nickUsuarioOriginal, (DtUsuario) usuarioModificado, img);
  }
  
  @WebMethod
  public boolean existeNick(String nick) {
    return Fabrica.getIUsuariosCanales().existeUsuario(nick);
  }
  
  @WebMethod
  public boolean existeCorreo(String correo) {
    return Fabrica.getIUsuariosCanales().existeUsuarioMail(correo);
  }
  
  @WebMethod
  public boolean existeVideo(String nombre, String nick) {
    return Fabrica.getIUsuariosCanales().existeVideo(nombre, nick);
  }
  
  @WebMethod
  public boolean existeLista(String nombre, String nick) {
   return Fabrica.getIListas().existeLista(nombre, nick);
  }
  
  @WebMethod
  public void altaVideo(String nick, String nombre, String descripcion, long segundos, String url,
      String categoria, GregorianCalendar calendario, boolean visibilidad) {
    try {
      Fabrica.getIVideos().altaVideo(nick, nombre, descripcion, Duration.ofSeconds(segundos), url,
          categoria, calendario.getTime(), visibilidad);
    } catch (DuplicateClassException | NotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
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
  
  /* 
   * No sirve mucho porque no se puede pasar una lista de dtAlgo como lista de DtUniversal
  @WebMethod(exclude = true)
  public DtPaquete empaquetar2(List<DtUniversal> lista) {
    DtPaquete pack = new DtPaquete();
    pack.setListaDt(lista);
    return pack;
  }
  */
    
}
