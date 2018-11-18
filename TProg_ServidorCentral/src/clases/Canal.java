package clases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import datatypes.DtLista;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import manejadores.ManejadorListasDefecto;
import manejadores.ManejadorVideos;

public class Canal {

  private Categoria categoria;
  private String descripcion;
  private Map<String, ListaDefecto> listaDefecto = new HashMap<String, ListaDefecto>();

  private Map<String, ListaParticular> listaParticulares =
      new HashMap<String, ListaParticular>();

  private String nombre;
  private Usuario usuario;
  private Map<String, Video> videos = new HashMap<String, Video>();
  private boolean visible;

  public Canal() {

  }

  public Canal(String nombreCanal, String descripcionCanal, Categoria categoria, boolean visible,
      Usuario user) {
    this.nombre = nombreCanal;
    this.descripcion = descripcionCanal;
    this.visible = visible;
    this.usuario = user;
    for (String lista : ManejadorListasDefecto.getManejadorListas().toArray()) {
      listaDefecto.put(lista, new ListaDefecto(lista, this));
    }
    this.categoria = categoria;
  }

  public void agregarVideoListaDefecto(Video videoObj, String lista)
      throws DuplicateClassException {
    ListaDefecto listaObj = listaDefecto.get(lista);
    if (!listaObj.existeVideo(videoObj)) {
      listaObj.insertarVideo(videoObj);
    } else {
      throw new DuplicateClassException("Video", videoObj.getNombre());
    }
  }

  public void agregarVideoListaParticular(Video videoObj, String lista)
      throws DuplicateClassException {
    ListaParticular listaObj = listaParticulares.get(lista);
    if (!listaObj.existeVideo(videoObj)) {
      listaObj.insertarVideo(videoObj);

      Categoria categoria = videoObj.getCategoria();
      if (!listaObj.existeCategoria(categoria)) {
        listaObj.insertarCategoria(categoria);
      }
    } else {
      throw new DuplicateClassException("Video", videoObj.getNombre());
    }
  }

  public Video altaVideo(String nombre, String descripcion, Duration duracion, String url,
      Categoria categoria, Date fecha, boolean visible) throws DuplicateClassException {

    if (videos.containsKey(nombre)) {
      throw new DuplicateClassException("Video", nombre);
    }
    Video video = new Video(nombre, descripcion, duracion, url, categoria, this, fecha, visible);
    this.videos.put(nombre, video);
    return video;
  }

  public Date getUltimaActividad() {
    Date ultimaActividad = new Date(0);
    for (Video vid : this.videos.values()) {
      if (ultimaActividad == null || vid.getFecha().after(ultimaActividad)) {
        ultimaActividad = vid.getFecha();
      }
    }

    return ultimaActividad;
  }

  public String[] getArrayVideos() {

    return videos.keySet().toArray(new String[videos.size()]);
  }

  public List<DtVideo> getVideosPublicos() {
    List<DtVideo> videos = new ArrayList<DtVideo>();
    for (Video video : this.videos.values()) {
      if (video.isVisible()) {
        videos.add(video.getDt());
      }
    }
    return videos;
  }

  public List<DtVideo> getVideosPrivados() {
    List<DtVideo> videos = new ArrayList<DtVideo>();
    for (Video video : this.videos.values()) {
      if (!video.isVisible()) {
        videos.add(video.getDt());
      }

    }
    return videos;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public Lista getLista(String lista) throws Exception {
    if (this.listaParticulares.containsKey(lista)) {
      return this.listaParticulares.get(lista);
    } else {
      throw new Exception("No existe lista");
    }
  }

  public Map<String, ListaDefecto> getListaDefecto() {
    return listaDefecto;
  }

  public List<String> getListaDefectoUsuario() {
    List<String> lista = new LinkedList<String>(listaDefecto.keySet());
    return lista;

  }

  public Map<String, ListaParticular> getListaParticulares() {
    return listaParticulares;
  }

  public List<String> getListaParticularUsuario() {
    List<String> lista = new LinkedList<String>(listaParticulares.keySet());
    return lista;

  }

  public String getNombre() {
    return nombre;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public Video getVideoCanal(String video) {

    return videos.get(video);
  }

  public Map<String, Video> getVideos() {
    return videos;
  }

  public void guardarCambios(String nomLis, boolean visible) {
    ListaParticular listaObjetivo = listaParticulares.get(nomLis);
    listaObjetivo.setVisible(visible);
  }

  public void ingresarListaDefecto(String nombre) {
    ListaDefecto nuevaLista = new ListaDefecto(nombre, this);
    listaDefecto.put(nombre, nuevaLista); // puede cambiar la implementacion
  }

  public void altaListaParticular(String nombre, boolean visibilidad)
      throws DuplicateClassException {
    if (!listaParticulares.containsKey(nombre)) {
      ListaParticular nuevaLista = new ListaParticular(nombre, this,
          visibilidad);
      listaParticulares.put(nombre, nuevaLista);
    } else {
      throw new DuplicateClassException("lista",nombre);
    }
  }

  public boolean isVisible() {
    return visible;
  }

  public String[] listarVideosLista(String lista, boolean defecto) {
    if (defecto) {
      ListaDefecto listaDef = listaDefecto.get(lista);
      return listaDef.getArrayVideos();
    } else {
      ListaParticular listaPar = listaParticulares.get(lista);
      return listaPar.getArrayVideos();
    }
  }

  public String[] listarVideosDuenosLista(String lista, boolean defecto) {
    if (defecto) {
      ListaDefecto listaDef = listaDefecto.get(lista);
      return listaDef.getArrayVideosDuenos();
    } else {
      ListaParticular listaPar = listaParticulares.get(lista);
      return listaPar.getArrayVideosDuenos();
    }
  }

  public List<DtVideo> listarDtVideosDuenosLista(String lista, boolean defecto) {
    if (defecto) {
      ListaDefecto listaDef = listaDefecto.get(lista);
      return listaDef.getDtVideos();
    } else {
      ListaParticular listaPar = listaParticulares.get(lista);
      return listaPar.getDtVideos();
    }
  }

  public void modVideo(String nombreOld, String nombre) throws DuplicateClassException {
    if (nombreOld.equals(nombre) || !this.videos.containsKey(nombre)) {
      Video vid = this.videos.remove(nombreOld);
      this.videos.put(nombre, vid);
    } else {
      throw new DuplicateClassException("Video", "El nombre seleccionado ya existe.");
    }
  }

  public List<DtVideo> listaDtVideo() {
    List<DtVideo> result = new LinkedList<DtVideo>();
    for (Video v : videos.values()) {
      DtVideo nuevo = v.getDt();
      result.add(nuevo);
    }
    return result;
  }

  public List<DtVideo> listaPublicoDtVideo() {
    List<DtVideo> result = new LinkedList<DtVideo>();
    for (Video v : videos.values()) {
      if (v.getVisible()) {
        DtVideo nuevo = v.getDt();
        result.add(nuevo);
      }
    }
    return result;
  }

  public void quitarVideoListaDefecto(String video, String lista, Usuario ownerVideo) {
    ListaDefecto listaObj = listaDefecto.get(lista);
    Video videoObj = listaObj.getVideo(video, ownerVideo);
    listaObj.quitarVideo(videoObj);

  }

  public void quitarVideoListaParticular(String video, String lista, Usuario ownerVideo) {
    ListaParticular listaObj = listaParticulares.get(lista);
    Video videoObj = listaObj.getVideo(video, ownerVideo);
    if (videoObj != null) {
      listaObj.quitarVideo(videoObj);
      Categoria cat = videoObj.getCategoria();

      if (listaObj.esUnicaCategoria(cat)) {
        listaObj.quitarCategoria(cat);
      } 
    }
  }

  public void agregarVideo(Video video) {
    this.videos.put(video.getNombre(), video);
  }

  public List<DtVideo> getDtVideos() {
    List<DtVideo> videos = new ArrayList<DtVideo>();
    for (Entry<String, Video> video : this.videos.entrySet()) {
      videos.add(video.getValue().getDt());
    }
    return videos;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public DtLista getDtListaDefecto(String nombreListaDefecto) {
    return this.listaDefecto.get(nombreListaDefecto).getDtLista();
  }
  
  public void consultaVideo(int idVideo) throws NotFoundException {
    Map<Integer, Historial> reproducciones = this.usuario.getReproducciones();
    if (reproducciones.get(idVideo) == null) {
      reproducciones.put(idVideo, new Historial(1, new Date()));
      this.usuario.getCanal().getListaDefecto().get("Historial").getVideos().add(ManejadorVideos.getManejadorVideos().getById(idVideo));
    } else {
      reproducciones.get(idVideo).aumentarReproduccion();
    }
  }
  
  public void consultarVideo(int idVideo, int consultas) {
    this.usuario.getReproducciones().put(idVideo, new Historial(consultas, new Date()));
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;    
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
