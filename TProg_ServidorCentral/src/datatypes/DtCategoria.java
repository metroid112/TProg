package datatypes;

import java.util.HashMap;
import java.util.Map;

public class DtCategoria {
  
  private String nombreCategoria;
  private DtCanal canal;
  private Map<Integer, DtVideo> videos = new HashMap<Integer, DtVideo>();
  private Map<Integer, DtLista> listasParticulares = new HashMap<Integer, DtLista>();
  
  public DtCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
  }

  public String getNombreCategoria() {
    return this.nombreCategoria;
  }

  public DtCanal getCanal() {
    return this.canal;
  }

  public Map<Integer, DtVideo> getVideos() {
    return this.videos;
  }

  public Map<Integer, DtLista> getListasParticulares() {
    return this.listasParticulares;
  }

  public void setNombreCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
  }

  public void setCanal(DtCanal canal) {
    this.canal = canal;
  }

  public void setVideos(Map<Integer, DtVideo> videos) {
    this.videos = videos;
  }

  public void setListasParticulares(Map<Integer, DtLista> listasParticulares) {
    this.listasParticulares = listasParticulares;
  }
}
