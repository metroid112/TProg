package datatypes;

import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import clases.Calificacion;
import clases.Categoria;
import clases.Comentario;

public class DtVideo {
  public LinkedList<DtCalificacion> calificaciones = new LinkedList<DtCalificacion>();
  public LinkedHashMap<Integer, DtComentario> comentarios =
      new LinkedHashMap<Integer, DtComentario>();
  public Duration duracion;
  public Date fecha;

  public String nombre;
  public String Url;
  public String descripcion;
  public String categoria;
  public boolean visible;

  public DtVideo(String nombre, String descripcion, String url, Categoria categoria, Date fecha,
      Duration duracion, boolean visible, LinkedHashMap<Integer, Comentario> comentarios,
      LinkedList<Calificacion> calificaciones) {

    this.nombre = nombre;
    this.Url = url;
    this.descripcion = descripcion;
    if (categoria != null) {
      this.categoria = categoria.getNombre();
    } else {
      this.categoria = "Sin Categoria";
    }
    this.duracion = duracion;
    this.fecha = fecha;

    for (Comentario com : comentarios.values()) {
      DtComentario dtCom = com.getDt(); // Creo Dt
      this.comentarios.put(dtCom.id, dtCom); // Lo agrego a la coleccion
    }
    this.visible = visible;
    for (Calificacion cal : calificaciones) {
      this.calificaciones.add(cal.getDt());
    }

  }

  public int getCalificacionesPositivas(){
    int sum = 0;
    for(DtCalificacion calif : calificaciones){
      if(calif.like)
        sum++;
    }
    return sum;
  }
  
  public int getCalificacionesNegativas(){
    int sum = 0;
    for(DtCalificacion calif : calificaciones){
      if(!calif.like)
        sum++;
    }
    return sum;
  }

  @Override
  public boolean equals(Object o) {
    DtVideo dt = (DtVideo) o;
    return (this.nombre.equals(dt.nombre) && this.descripcion.equals(dt.descripcion)
        && this.visible == dt.visible && this.Url.equals(dt.Url) && this.fecha.equals(dt.fecha));
  }

}
