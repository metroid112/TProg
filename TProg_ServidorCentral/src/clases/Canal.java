package clases;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import excepciones.DuplicateClassException;
import manejadores.ManejadorListasDefecto;

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
  }

  public void agregarVideoListaDefecto(Video videoObj, String lista) {
    ListaDefecto listaObj = listaDefecto.get(lista);
    if (!listaObj.existeVideo(videoObj)) {
      listaObj.insertarVideo(videoObj);
    }
  }

  public void agregarVideoListaParticular(Video videoObj, String lista) {
    ListaParticular listaObj = listaParticulares.get(lista);
    if (!listaObj.existeVideo(videoObj)) {
      listaObj.insertarVideo(videoObj);

      Categoria categoria = videoObj.getCategoria();
      if (!listaObj.existeCategoria(categoria)) {
        listaObj.insertarCategoria(categoria);
      }
    }
    // disparar excepcion
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

  public String[] getArrayVideos() {

    return videos.keySet().toArray(new String[videos.size()]);
  }

  public String getDescripcion() {
    return descripcion;
  }

  public Lista getLista(String lista) throws Exception {
    if (this.listaDefecto.containsKey(lista)) {
      return this.listaDefecto.get(lista);
    } else if (this.listaParticulares.containsKey(lista)) {
      return this.listaParticulares.get(lista);
    } else {
      throw new Exception("No existe lista");
    }
  }

  public Map<String, ListaDefecto> getListaDefecto() {
    return listaDefecto;
  }

  public String[] getListaDefectoUsuario() {

    return listaDefecto.keySet().toArray(new String[listaDefecto.size()]);

  }

  public Map<String, ListaParticular> getListaParticulares() {
    return listaParticulares;
  }

  public String[] getListaParticularUsuario() {

    return listaParticulares.keySet().toArray(new String[listaParticulares.size()]);

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

  public void agregarListaDefectoObserver(ListaDefecto listaDefecto) {
    this.listaDefecto.put(listaDefecto.getNombre(), listaDefecto);
  }

  public void altaListaParticular(String nombre, boolean visibilidad)
      throws DuplicateClassException {

    ListaParticular nuevaLista = new ListaParticular(nombre, this, new HashMap<String, Categoria>(),
        visibilidad);
    listaParticulares.put(nombre, nuevaLista);
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

  public void modVideo(String nombreOld, String nombre) {
    Video vid = this.videos.remove(nombreOld);
    this.videos.put(nombre, vid);

  }

  public void quitarVideoListaDefecto(String video, String lista, Usuario ownerVideo) {
    ListaDefecto listaObj = listaDefecto.get(lista);
    Video videoObj = listaObj.getVideo(video, ownerVideo);
    listaObj.quitarVideo(videoObj);

  }

  public void quitarVideoListaParticular(String video, String lista, Usuario ownerVideo) {
    ListaParticular listaObj = listaParticulares.get(lista);
    Video videoObj = listaObj.getVideo(video, ownerVideo);
    listaObj.quitarVideo(videoObj);
    Categoria cat = videoObj.getCategoria();

    if (listaObj.esUnicaCategoria(cat)) {
      listaObj.quitarCategoria(cat);
    }

  }

  public void agregarVideo(Video video) {
    this.videos.put(video.getNombre(), video);
  }
}
