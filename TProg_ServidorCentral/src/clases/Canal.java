package clases;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import datatypes.DtCanal;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
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
    this.categoria = categoria;

    for (String lista : ManejadorListasDefecto.getManejadorListasDefecto().getListasDefecto()) {
      ListaDefecto listaDefecto = new ListaDefecto(lista, this);
      this.listasDefecto.put(listaDefecto.getId(), listaDefecto);
    }
  }

  public DtCanal getDt() {
    return new DtCanal(this.nombreCanal, this.descripcionCanal, this.visible, this.ultimaActividad);
  }

  public String getNombre() {
    return nombreCanal;
  }

  public String getDescripcion() {
    return descripcionCanal;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public boolean isVisible() {
    return visible;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public Date getUltimaActividad() {
    return this.ultimaActividad;
  }

  // **** GENERAR SETTERS PARA NOMBRE, DESCRIPCION, VISIBILIDAD

  public void altaVideo(Video video) throws DuplicateClassException {
    if (videos.containsKey(video.getId())) {
      throw new DuplicateClassException("Video", video.getNombre());
    } else {
      this.videos.put(video.getId(), video);
      if (this.ultimaActividad == null || video.getFecha().after(this.ultimaActividad)) {
        this.ultimaActividad = video.getFecha();
      }
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

  public void agregarVideoListaDefecto(Video video, int idListaDefecto)
      throws DuplicateClassException, InvalidDataException {
    ListaDefecto lista = listasDefecto.get(idListaDefecto);
    if (!lista.existeVideo(video.getId())) {
      lista.agregarVideo(video);
    } else {
      throw new DuplicateClassException("Video", video.getNombre());
    }
  }

  public void agregarVideoListaParticular(Video video, int idListaParticular)
      throws DuplicateClassException, InvalidDataException {
    ListaParticular lista = listasParticulares.get(idListaParticular);
    if (!lista.existeVideo(video.getId())) {
      lista.agregarVideo(video);
      Categoria categoria = video.getCategoria();
      lista.agregarCategoria(categoria);
    } else {
      throw new DuplicateClassException("Video", video.getNombre());
    }
  }

  public Video getVideo(int idVideo) throws NotFoundException {
    if (videos.containsKey(idVideo)) {
      return videos.get(idVideo);
    } else {
      throw new NotFoundException("Video id: " + idVideo);
    }
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

  public Map<Integer, ListaDefecto> getListasDefecto() {
    return listasDefecto;
  }

  public Map<Integer, ListaParticular> getListasParticulares() {
    return listasParticulares;
  }

  public void quitarVideoListaDefecto(int idVideo, int idLista) throws NotFoundException {
    ListaDefecto listaDefecto = listasDefecto.get(idLista);
    listaDefecto.quitarVideo(idVideo);
  }


  public void quitarVideoListaParticular(int idVideo, int idLista) throws NotFoundException {
    ListaParticular listaParticular = listasParticulares.get(idLista);
    Video video = listaParticular.getVideo(idVideo);
    listaParticular.quitarVideo(idVideo);
    Categoria categoria = video.getCategoria();
    if (listaParticular.esUnicaCategoria(categoria)) {
      listaParticular.quitarCategoria(categoria);

    }
  }

  @Override
  public boolean equals(Object object) {
    Canal canal = (Canal) object;
    return this.usuario.equals(canal.usuario);
  }
}
