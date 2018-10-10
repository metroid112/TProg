package clases;

import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import manejadores.ManejadorVideos;

public class Video {

  private List<Calificacion> calificaciones = new LinkedList<Calificacion>();
  private Canal canal;
  private Categoria categoria;
  private Map<Integer, Comentario> comentarios = new LinkedHashMap<Integer, Comentario>();
  private String descripcion;
  private Duration duracion;
  private Date fecha;
  private String nombre;
  private String url;
  private boolean visible;
  private int idVideo;
  private static int idCounter = 0;

  public Video(String nombre, String descripcion, Duration duracion, String url,
      Categoria categoria, Canal canal, Date fecha, boolean visible)
      throws DuplicateClassException {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.duracion = duracion;
    this.fecha = fecha;
    this.url = url;
    this.visible = visible;
    this.categoria = categoria;
    this.canal = canal;
    Video.idCounter++;
    this.idVideo = Video.idCounter;
    ManejadorVideos.getManejadorVideos().add(this);
  }

  public int getId() {
    return this.idVideo;
  }

  public void addCalificacion(Calificacion cal) {
    this.calificaciones.add(cal);
  }

  public void addComentarioPadre(Comentario com) {
    this.comentarios.put(com.getId(), com);
  }

  public Canal getCanal() {
    return canal;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Comentario getComentario(Integer idComentarioPadre) {
    Comentario com;
    Comentario encontrado = null;
    for (Comentario comentario : this.comentarios.values()) {
      com = comentario.getCom(idComentarioPadre);
      if (com != null) {
        encontrado = com;
      }
    }
    return encontrado;
  }

  public Comentario getComentario(int id) {
    return this.comentarios.get(id);
  }

  public DtVideo getDt() {

    return new DtVideo(this.nombre, this.descripcion, this.url, this.categoria, this.fecha,
        this.duracion, this.visible, this.comentarios, this.calificaciones, this.idVideo, this.canal.getUsuario().getNick());

  }

  public String getNombre() {
    return nombre;
  }
  
  public boolean getVisible(){
    return visible;
  }

  public void modificarDatos(String nombre, String descripcion, String url, Categoria categoria,
      Duration duracion, Boolean visible, Date fecha) throws InvalidDataException {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.url = url;
    if (this.categoria != null) {
      this.categoria.remove(this);
    }
    this.categoria = categoria;
    this.categoria.addVideo(this);
    this.duracion = duracion;
    if (!this.visible && visible) {
      if (this.canal.isVisible()) {
        this.visible = visible;
      } else {
        throw new InvalidDataException("privacidad del video");
      }
    } else {
      this.visible = visible;
    }
    this.fecha = fecha;
  }
  
  public boolean isVisible() {
    return this.visible;
  }

  @Override
  public boolean equals(Object o) {
    Video video = (Video) o;
    return (this.idVideo == video.getId());
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public Date getFecha() {
    return this.fecha;
  }
}
