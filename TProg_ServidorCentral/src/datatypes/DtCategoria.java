package datatypes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import clases.ListaParticular;
import clases.Video;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategoria extends DtUniversal {

  private int idCategoria;
  private String nombre;
  private List<DtVideo> videos;
  private List<DtLista> listas;

  public DtCategoria() {}

  public DtCategoria(int idCategoria, String nombre, List<DtVideo> videos, List<DtLista> listas) {
    this.idCategoria = idCategoria;
    this.nombre = nombre;
    this.videos = videos;
    this.listas = listas;
  }

  public int getId() {
    return this.idCategoria;
  }

  public void setId(int idCategoria) {
    this.idCategoria = idCategoria;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<DtLista> getListas() {
    return listas;
  }

  public void setListas(List<DtLista> listas) {
    this.listas = listas;
  }

  public List<DtVideo> getVideos() {
    return videos;
  }

  public void setVideos(List<DtVideo> videos) {
    this.videos = videos;
  }
}
