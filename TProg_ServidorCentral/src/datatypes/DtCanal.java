package datatypes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DtCanal {

  private DtUsuario usuario;
  private String nombreCanal;
  private String descripcionCanal;
  private DtCategoria categoria;
  private boolean visible;
  private Date ultimaActividad;

  private Map<Integer, DtVideo> videos = new HashMap<Integer, DtVideo>();
  private Map<Integer, DtLista> listas = new HashMap<Integer, DtLista>();

  public DtCanal(String nombreCanal, String descripcionCanal, boolean visibilidad,
      Date ultimaActividad) {
    this.nombreCanal = nombreCanal;
    this.descripcionCanal = descripcionCanal;
    this.visible = visibilidad;
    this.ultimaActividad = ultimaActividad;
  }

  public DtUsuario getUsuario() {
    return this.usuario;
  }

  public String getNombreCanal() {
    return this.nombreCanal;
  }

  public String getDescripcionCanal() {
    return this.descripcionCanal;
  }

  public DtCategoria getCategoria() {
    return this.categoria;
  }

  public boolean isVisible() {
    return this.visible;
  }

  public Date getUltimaActividad() {
    return this.ultimaActividad;
  }

  public Map<Integer, DtVideo> getVideos() {
    return this.videos;
  }

  public Map<Integer, DtLista> getListas() {
    return this.listas;
  }

  public void setUsuario(DtUsuario usuario) {
    this.usuario = usuario;
  }

  public void setNombreCanal(String nombreCanal) {
    this.nombreCanal = nombreCanal;
  }

  public void setDescripcionCanal(String descripcionCanal) {
    this.descripcionCanal = descripcionCanal;
  }

  public void setCategoria(DtCategoria categoria) {
    this.categoria = categoria;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void setUltimaActividad(Date ultimaActividad) {
    this.ultimaActividad = ultimaActividad;
  }

  public void setVideos(Map<Integer, DtVideo> videos) {
    this.videos = videos;
  }

  public void setListas(Map<Integer, DtLista> listas) {
    this.listas = listas;
  }
}
