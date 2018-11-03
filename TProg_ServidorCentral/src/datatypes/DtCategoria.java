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
  private List<ListaParticular> listas = new LinkedList<ListaParticular>();
  private String nombre;
  private List<Video> videos = new LinkedList<Video>();
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

  public List<ListaParticular> getListas() {
    return listas;
  }

  public void setListas(List<ListaParticular> listas) {
    this.listas = listas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Video> getVideos() {
    return videos;
  }

  public void setVideos(List<Video> videos) {
    this.videos = videos;
  }
  
  
  
}
