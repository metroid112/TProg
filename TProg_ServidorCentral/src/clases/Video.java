package clases;

import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import datatypes.DtVideo;
import excepciones.InvalidDataException;

public class Video {

  private LinkedList<Calificacion> calificaciones = new LinkedList<Calificacion>();
  private Canal canal;
  private Categoria categoria;
  private LinkedHashMap<Integer, Comentario> comentarios = new LinkedHashMap<Integer, Comentario>();
  // LinkedHashMap mantiene el orden a diferencia del HashMap
  private String descripcion;
  private Duration duracion;
  private Date fecha;
  private String nombre;
  private String url;
  private boolean visible;

  public Video(String nombre, String descripcion, Duration duracion, String url,
      Categoria categoria, Canal canal, Date fecha) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.duracion = duracion;
    this.fecha = fecha; // Chequear fecha?
    this.url = url;
    this.visible = false; // Arranca privado
    this.categoria = categoria;
    this.canal = canal;
    if (this.categoria != null) {
      categoria.addVideo(this);
    }
  }

  public Video(String nombre, String descripcion, Duration duracion, String url,
      Categoria categoria, Date fecha, boolean visible, Canal canal) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.duracion = duracion;
    this.url = url;
    this.categoria = categoria;
    this.fecha = fecha;
    this.visible = visible;
    this.canal = canal;
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
        this.duracion, this.canal, this.visible, this.comentarios, this.calificaciones);

  }

  public String getNombre() {
    return nombre;
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

  @Override
  public boolean equals(Object o) {
    Video video = (Video) o;
    return (this.nombre.equals(video.nombre) && this.fecha.equals(video.fecha)
        && this.duracion.equals(video.duracion) && this.visible == video.visible
        && this.url.equals(video.url) && this.descripcion.equals(video.descripcion));
  }
}
