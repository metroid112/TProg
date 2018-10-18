package clases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import datatypes.DtCanal;
import datatypes.DtLista;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import manejadores.ManejadorListasDefecto;

public class Canal {

  private String nombreCanal;
  private String descripcionCanal;
  private Categoria categoria;
  private boolean visible;
  private Date ultimaActividad;
  private Usuario usuario;
  private Map<Integer, ListaDefecto> listasDefecto = new HashMap<Integer, ListaDefecto>();
  private Map<Integer, ListaParticular> listasParticulares =
      new HashMap<Integer, ListaParticular>();
  private Map<Integer, Video> videos = new HashMap<Integer, Video>();

  public Canal(String nombreCanal, String descripcionCanal, Categoria categoria, boolean visible,
      Usuario user) {
    this.nombreCanal = nombreCanal;
    this.descripcionCanal = descripcionCanal;
    this.visible = visible;
    this.usuario = user;
    for (String lista : ManejadorListasDefecto.getManejadorListasDefecto().getListasDefecto()) {
      ListaDefecto listaDefecto = new ListaDefecto(lista, this);
      this.listasDefecto.put(listaDefecto.getId(), listaDefecto);
    }
    this.categoria = categoria;
  }

  public void altaVideo(Video video) throws DuplicateClassException {
    if (videos.containsKey(video.getId())) {
      throw new DuplicateClassException("Video", video.getNombre());
    } else {
      this.videos.put(video.getId(), video);
    }
  }

  public void agregarVideoListaDefecto(Video video, int idListaDefecto)
      throws DuplicateClassException {
    ListaDefecto lista = listasDefecto.get(idListaDefecto);
    if (!lista.existeVideo(video)) {
      lista.agregarVideo(video);
    } else {
      throw new DuplicateClassException("Video", video.getNombre());
    }
  }

  public void agregarVideoListaParticular(Video video, int idListaParticular)
      throws DuplicateClassException {
    ListaParticular lista = listasParticulares.get(idListaParticular);
    if (!lista.existeVideo(video)) {
      lista.agregarVideo(video);
      Categoria categoria = video.getCategoria();
      lista.agregarCategoria(categoria);
    } else {
      throw new DuplicateClassException("Video", video.getNombre());
    }
  }

  public void agregarListaDefecto(ListaDefecto listaDefecto) throws DuplicateClassException {
    if (this.listasDefecto.containsKey(listaDefecto.getId())) {
      throw new DuplicateClassException("Lista", listaDefecto.getNombre());
    } else {
      this.listasDefecto.put(listaDefecto.getId(), listaDefecto);
    }
  }

  public void agregarListaParticular(ListaParticular listaParticular)
      throws DuplicateClassException {
    if (this.listasParticulares.containsKey(listaParticular.getId())) {
      throw new DuplicateClassException("Lista", listaParticular.getNombre());
    } else {
      this.listasParticulares.put(listaParticular.getId(), listaParticular);
    }
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

  public Map<Integer, Video> getVideos() {
    return this.videos;
  }

  public Map<Integer, Video> getVideosPublicos() {
    Map<Integer, Video> videos = new HashMap<Integer, Video>();
    for (Video video : this.videos.values()) {
      if (video.isVisible()) {
        videos.put(video.getId(), video);
      }
    }
    return videos;
  }

  public Map<Integer, Video> getVideosPrivados() {
    Map<Integer, Video> videos = new HashMap<Integer, Video>();
    for (Video video : this.videos.values()) {
      if (!video.isVisible()) {
        videos.put(video.getId(), video);
      }
    }
    return videos;
  }

  public Map<Integer, ListaDefecto> getListasDefecto() {
    return listasDefecto;
  }

  public Map<Integer, ListaParticular> getListasParticulares() {
    return listasParticulares;
  }

  public ListaDefecto getListaDefecto(int idListaDefecto) throws NotFoundException {
    if (this.listasDefecto.containsKey(idListaDefecto)) {
      return this.listasDefecto.get(idListaDefecto);
    } else {
      throw new NotFoundException("Lista Defecto id: " + idListaDefecto);
    }
  }

  public ListaParticular getListaParticular(int idListaParticular) throws NotFoundException {
    if (this.listasParticulares.containsKey(idListaParticular)) {
      return this.listasParticulares.get(idListaParticular);
    } else {
      throw new NotFoundException("Lista Particular id: " + idListaParticular);
    }
  }

  public String getNombre() {
    return nombreCanal;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public String getDescripcion() {
    return descripcionCanal;
  }

  public Video getVideo(int idVideo) {
    return videos.get(idVideo);
  }

  public boolean isVisible() {
    return visible;
  }

  public String[] listarVideosLista(String lista, boolean defecto) {
    if (defecto) {
      ListaDefecto listaDef = listasDefecto.get(lista);
      return listaDef.getArrayVideos();
    } else {
      ListaParticular listaPar = listasParticulares.get(lista);
      return listaPar.getArrayVideos();
    }
  }

  public String[] listarVideosDuenosLista(String lista, boolean defecto) {
    if (defecto) {
      ListaDefecto listaDef = listasDefecto.get(lista);
      return listaDef.getArrayVideosDuenos();
    } else {
      ListaParticular listaPar = listasParticulares.get(lista);
      return listaPar.getArrayVideosDuenos();
    }
  }

  public List<DtVideo> listarDtVideosDuenosLista(String lista, boolean defecto) {
    if (defecto) {
      ListaDefecto listaDef = listasDefecto.get(lista);
      return listaDef.getDtVideos();
    } else {
      ListaParticular listaPar = listasParticulares.get(lista);
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
    ListaDefecto listaObj = listasDefecto.get(lista);
    Video videoObj = listaObj.getVideo(video, ownerVideo);
    listaObj.quitarVideo(videoObj);

  }

  public void quitarVideoListaParticular(String video, String lista, Usuario ownerVideo) {
    ListaParticular listaObj = listasParticulares.get(lista);
    Video videoObj = listaObj.getVideo(video, ownerVideo);
    listaObj.quitarVideo(videoObj);
    Categoria cat = videoObj.getCategoria();

    if (listaObj.esUnicaCategoria(cat)) {
      listaObj.quitarCategoria(cat);
    }

  }

  public void agregarVideo(Video video) {
    this.videos.put(video.getId(), video);
  }

  public List<DtVideo> getDtVideos() {
    List<DtVideo> videos = new ArrayList<DtVideo>();
    for (Entry<int, Video> video : this.videos.entrySet()) {
      videos.add(video.getValue().getDt());
    }
    return videos;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public DtLista getDtListaDefecto(String nombreListaDefecto) {
    return this.listasDefecto.get(nombreListaDefecto).getDtLista();
  }

  public DtCanal getDt() {
    return new DtCanal(this.nombreCanal, this.descripcionCanal, this.visible, this.ultimaActividad);
  }

}
