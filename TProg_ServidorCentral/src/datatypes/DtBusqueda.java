package datatypes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtBusqueda {

  private List<DtVideo> videos;
  private List<DtLista> listas;
  private List<DtUsuario> usuarios;

  public DtBusqueda(List<DtVideo> videos, List<DtLista> listas, List<DtUsuario> usuarios) {
    this.videos = videos;
    this.listas = listas;
    this.usuarios = usuarios;
  }

  public List<DtVideo> getVideos() {
    return videos;
  }

  public void setVideos(List<DtVideo> videos) {
    this.videos = videos;
  }

  public List<DtLista> getListas() {
    return listas;
  }

  public void setListas(List<DtLista> listas) {
    this.listas = listas;
  }

  public List<DtUsuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<DtUsuario> usuarios) {
    this.usuarios = usuarios;
  }
  
  

}
