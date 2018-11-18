package datatypes;

import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import clases.Calificacion;
import clases.Categoria;
import clases.Comentario;

@XmlAccessorType(XmlAccessType.FIELD)

public class DtVideo extends DtUniversal{

  public List<DtCalificacion> calificaciones = new LinkedList<DtCalificacion>();
  public List<String> calificacionesPositivas = new LinkedList<String>(); // Usuarios like
  public List<String> calificacionesNegativas = new LinkedList<String>(); // Usuarios dislike
  public List<DtComentario> comentarios = new LinkedList<DtComentario>();
  public Duration duracion;
  public long duracionSegundos;
  public Date fecha;
  public String usuario;
  public String nombre;
  public String urlVideo;
  public String youtubeId;
  public String urlThumbnail;
  public String descripcion;
  public String categoria;
  public boolean visible;
  public int idVideo;

  public DtVideo(String nombre, String descripcion, String url, Categoria categoria, Date fecha,

      Duration duracion, boolean visible, Map<Integer, Comentario> comentarios,
      List<Calificacion> calificaciones, int idVideo, String usuario) {

    this.nombre = nombre;
    this.urlVideo = url;
    this.descripcion = descripcion;

    if (categoria != null) {
      this.categoria = categoria.getNombre();
    } else {
      this.categoria = "Sin Categoria";
    }
    this.duracion = duracion;
    this.duracionSegundos = duracion.getSeconds();
    this.fecha = fecha;
    this.usuario = usuario;

    for (Comentario com : comentarios.values()) {
      DtComentario dtCom = com.getDt(); // Creo Dt
      this.comentarios.add(dtCom); // Lo agrego a la coleccion
    }
    this.visible = visible;
    for (Calificacion cal : calificaciones) {
      DtCalificacion dtCal = cal.getDt();
      if (cal.getlike()) {
        this.calificacionesPositivas.add(dtCal.usuario);
      } else {
        this.calificacionesNegativas.add(dtCal.usuario);
      }
      this.calificaciones.add(dtCal);
    }
    this.idVideo = idVideo;
    if (this.urlVideo != null) {
      this.urlThumbnail = "https://img.youtube.com/vi/";
      this.urlThumbnail += this.urlVideo.substring(17, urlVideo.length());
      this.youtubeId = this.urlVideo.substring(17, urlVideo.length());
      this.urlThumbnail += "/0.jpg";
    }
  }

  public int getCantidadCalificacionesPositivas() {
    return this.calificacionesPositivas.size();
  }

  public int getCantidadCalificacionesNegativas() {
    return this.calificacionesNegativas.size();
  }

  public List<String> getCalificacionesPositivas() {
    return this.calificacionesPositivas;
  }

  public List<String> getCalificacionesNegativas() {
    return this.calificacionesNegativas;
  }

  public String duracionPrintFormat() {
    long seconds = duracion.getSeconds();
    long absSeconds = Math.abs(seconds);
    String positive = String.format(
        "%d:%02d:%02d",
        absSeconds / 3600,
        (absSeconds % 3600) / 60,
        absSeconds % 60);
    return seconds < 0 ? "-" + positive : positive;
  }

  public String urlWatchtFormat() {
    String resultado = this.urlVideo;
    if (resultado.substring(0, 17).equals("https://youtu.be/")) {
      resultado = resultado.substring(17);
      resultado = "https://www.youtube.com/embed/" + resultado;
    } else if (resultado.substring(0, 32).equals("https://www.youtube.com/watch?v=")) {
      resultado = resultado.substring(32);
      resultado = "https://www.youtube.com/embed/" + resultado;
    } else if (resultado.substring(0, 24).equals("https://www.youtube.com/")) {
      resultado = resultado.substring(24);
      resultado = "https://www.youtube.com/embed/" + resultado;
    } else if (resultado.substring(0, 16).equals("www.youtube.com/")) {
      resultado = resultado.substring(16);
      resultado = "https://www.youtube.com/embed/" + resultado;

    }
    return resultado;
  }

  public List<DtCalificacion> getCalificaciones() {
    return calificaciones;
  }

  public void setCalificaciones(List<DtCalificacion> calificaciones) {
    this.calificaciones = calificaciones;
  }

  public List<DtComentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<DtComentario> comentarios) {
    this.comentarios = comentarios;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }
  
  public void setDuracion(Duration duracion) {
    this.duracion = duracion;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getUrlVideo() {
    return urlVideo;
  }

  public void setUrlVideo(String urlVideo) {
    this.urlVideo = urlVideo;
  }

  public String getUrlThumbnail() {
    return urlThumbnail;
  }

  public void setUrlThumbnail(String urlThumbnail) {
    this.urlThumbnail = urlThumbnail;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public int getIdVideo() {
    return idVideo;
  }

  public void setIdVideo(int idVideo) {
    this.idVideo = idVideo;
  }
  
  public Duration getDuracion() {
    return duracion;
  }

  public long getDuracionSegundos() {
    return duracionSegundos;
  }

  public void setDuracionSegundos(long duracionSegundos) {
    this.duracionSegundos = duracionSegundos;
  }

  public String getYoutubeId() {
    return youtubeId;
  }

  public void setYoutubeId(String youtubeId) {
    this.youtubeId = youtubeId;
  } 
  
}
