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
  private List<DtLista> listas;
  private String nombre;
  private List<DtVideo> videos;
  private List<String> categorias;
  
  public List<String> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<String> categorias) {
    this.categorias = categorias;
  }
  
  public DtCategoria() {}
  
  public DtCategoria(List<String> categorias) {
    this.categorias = categorias;
  }
  
  public DtCategoria(String nombre, List<DtVideo> videos, List<DtLista> listas) {
    this.nombre = nombre;
    this.videos = videos;
    this.listas = listas;
  }
  
  public List<DtLista> getListas() {
    return listas;
  }

  public void setListas(List<DtLista> listas) {
    this.listas = listas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<DtVideo> getVideos() {
    return videos;
  }

  public void setVideos(List<DtVideo> videos) {
    this.videos = videos;
  }
  
  
  
}
