package datatypes;

import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import clases.Calificacion;
import clases.Categoria;
import clases.Comentario;

public class DtVideo {
  public List<DtCalificacion> calificaciones = new LinkedList<DtCalificacion>();
  public Map<Integer, DtComentario> comentarios =
      new LinkedHashMap<Integer, DtComentario>();
  public Duration duracion;
  public Date fecha;
  public String usuario;
  public String nombre;
  public String urlVideo;
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
    this.fecha = fecha;
    this.usuario = usuario;

    for (Comentario com : comentarios.values()) {
      DtComentario dtCom = com.getDt(); // Creo Dt
      this.comentarios.put(dtCom.id, dtCom); // Lo agrego a la coleccion
    }
    this.visible = visible;
    for (Calificacion cal : calificaciones) {
      this.calificaciones.add(cal.getDt());
    }
    this.idVideo = idVideo;
    if (this.urlVideo != null) {
      this.urlThumbnail = "https://img.youtube.com/vi/";
      this.urlThumbnail += this.urlVideo.substring(17, 28);
      this.urlThumbnail += "/0.jpg";
    }
  }

  public int getCantidadCalificacionesPositivas() {
    int sum = 0;
    for (DtCalificacion calif : calificaciones) {
      if (calif.like) {
        sum++;
      }
    }
    return sum;
  }

  public int getCantidadCalificacionesNegativas() {
    int sum = 0;
    for (DtCalificacion calif : calificaciones) {
      if (!calif.like) {
        sum++;
      }
    }
    return sum;
  }

  public List<String> getCalificacionesPositivas() {
    List<String> positivos = new LinkedList<String>();
    String usuarioObjetivo;

    for (DtCalificacion calif : calificaciones) {
      if (calif.like) {
        usuarioObjetivo = calif.usuario;
        positivos.add(usuarioObjetivo);
      }
    }
    return positivos;
  }

  public List<String> getCalificacionesNegativas() {
    List<String> negativos = new LinkedList<String>();
    String usuarioObjetivo;

    for (DtCalificacion calif : calificaciones) {
      if (!calif.like) {
        usuarioObjetivo = calif.usuario;
        negativos.add(usuarioObjetivo);
      }
    }
    return negativos;
  }

<<<<<<< HEAD
  public String duracionPrintFormat() {
    String resultado = this.duracion.toString();

    resultado = resultado.substring(2);

    resultado = resultado.replace("M", ":");
    resultado = resultado.replace("S", "");

    return resultado;
  }

  public String urlWatchtFormat() {
    String resultado = this.urlVideo;

    if (resultado.substring(0, 16).equals("https://youtu.be")) {

      resultado = resultado.substring(16);
      resultado = "https://www.youtube.com/embed" + resultado;
    } else if (resultado.substring(0, 23).equals("https://www.youtube.com")) {
      resultado = resultado.substring(23);
      resultado = "https://www.youtube.com/embed" + resultado;
=======
  public String duracionPrintFormat(){
    long seconds = duracion.getSeconds();
    long absSeconds = Math.abs(seconds);
    String positive = String.format(
        "%d:%02d:%02d",
        absSeconds / 3600,
        (absSeconds % 3600) / 60,
        absSeconds % 60);
    return seconds < 0 ? "-" + positive : positive;
  }

  public String urlWatchtFormat(){
    String resultado = this.Url;
    if(resultado.substring(0, 17).equals("https://youtu.be/")){
    resultado = resultado.substring(17);
    resultado = "https://www.youtube.com/embed/" + resultado;
    }
    else if(resultado.substring(0,32).equals("https://www.youtube.com/watch?v=")){
      resultado = resultado.substring(32);
      resultado = "https://www.youtube.com/embed/" + resultado;
    }
    else if(resultado.substring(0,24).equals("https://www.youtube.com/")){
      resultado = resultado.substring(24);
      resultado = "https://www.youtube.com/embed/" + resultado;
    }
    else if(resultado.substring(0,16).equals("www.youtube.com/")){
      resultado = resultado.substring(16);
      resultado = "https://www.youtube.com/embed/" + resultado;
>>>>>>> categoriaUsuario-agustin
    }
    return resultado;
  }

  public List<DtCalificacion> getCalificaciones() {
    return calificaciones;
  }

  public void setCalificaciones(List<DtCalificacion> calificaciones) {
    this.calificaciones = calificaciones;
  }

  public Map<Integer, DtComentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(Map<Integer, DtComentario> comentarios) {
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

  @Override
  public boolean equals(Object o) {
    DtVideo dt = (DtVideo) o;
    return (this.nombre.equals(dt.nombre) && this.descripcion.equals(dt.descripcion)
        && this.visible == dt.visible && this.urlVideo.equals(dt.urlVideo)
        && this.fecha.equals(dt.fecha));
  }

}
