package datatypes;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import clases.Lista;
import clases.ListaParticular;
import clases.Video;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategoria extends DtUniversal {
  private String nombre;
  private int categoriaId;
  private List<DtVideo> videos = new LinkedList<DtVideo>();
  private List<DtLista> listas = new LinkedList<DtLista>();

  public DtCategoria() {}

  public DtCategoria(String nombre, int categoriaId, List<Video> videos, List<ListaParticular> listas) {
    this.nombre = nombre;
    this.categoriaId = categoriaId;
    for (Video vid : videos) {
      this.videos.add(vid.getDt());
    }
    
    for (Lista lst : listas) {
      this.listas.add(lst.getDtLista());
    }

  }

  public int getCategoriaId() {
    return categoriaId;
  }

  public void setCategoriaId(int categoriaId) {
    this.categoriaId = categoriaId;
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
