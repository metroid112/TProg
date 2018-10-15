package datatypes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DtLista {
  private List<String> categorias = new LinkedList<String>();
  private String nombre;
  private String tipo;
  private List<String> videos = new LinkedList<String>();
  private List<DtVideo> dtVideos = null;
  private boolean visible;
  private Date ultimaActividad;
  private int idLista;

  public DtLista(String nombre, String tipo, boolean visible, List<String> videos,
      List<String> categorias) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.visible = visible;
    this.videos = videos;
    this.categorias = categorias;
  }

  public DtLista(String nombre, String tipo, boolean visible, List<String> videos,
      List<DtVideo> dtVideos, List<String> categorias, Date ultimaActividad, int idLista) {
    this.nombre = nombre;
    this.idLista = idLista;
    this.tipo = tipo;
    this.dtVideos = dtVideos;
    this.visible = visible;
    this.videos = videos;
    this.categorias = categorias;
    this.ultimaActividad = ultimaActividad;
  }

  public Date getUltimaActividad() {
    return this.ultimaActividad;
  }

  public List<String> getCategorias() {
    return categorias;
  }

  public int getId() {
    return this.idLista;
  }

  public String getNombre() {
    return nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public List<String> getVideos() {
    return videos;
  }

  public List<DtVideo> getDtVideos() {
    return dtVideos;
  }

  public boolean isVisible() {
    return visible;
  }

  @Override
  public boolean equals(Object object) {
    DtLista dtLista = (DtLista) object;
    return (this.visible == dtLista.visible && this.nombre.equals(dtLista.nombre)
        && this.tipo.equals(dtLista.tipo));
  }
}
