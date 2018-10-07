package datatypes;

import java.util.Date;
import java.util.LinkedList;

public class DtLista {
  private LinkedList<String> categorias = new LinkedList<String>();
  private String nombre;
  private String tipo;
  private LinkedList<String> videos = new LinkedList<String>();
  private boolean visible;
  private Date ultimaActividad;

  public DtLista(String nombre, String tipo, boolean visible, LinkedList<String> videos,
      LinkedList<String> categorias) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.visible = visible;
    this.videos = videos;
    this.categorias = categorias;
  }

  public DtLista(String nombre, String tipo, boolean visible, LinkedList<String> videos,
      LinkedList<String> categorias, Date ultimaActividad) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.visible = visible;
    this.videos = videos;
    this.categorias = categorias;
    this.ultimaActividad = ultimaActividad;
  }

  public Date getUltimaActividad() {
    return this.ultimaActividad;
  }

  public LinkedList<String> getCategorias() {
    return categorias;
  }

  public String getNombre() {
    return nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public LinkedList<String> getVideos() {
    return videos;
  }

  public boolean isVisible() {
    return visible;
  }

  @Override
  public boolean equals(Object o) {
    DtLista dt = (DtLista) o;
    return (this.visible == dt.visible && this.nombre.equals(dt.nombre)
        && this.tipo.equals(dt.tipo));
  }
}
