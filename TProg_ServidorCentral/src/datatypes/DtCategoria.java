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
<<<<<<< HEAD
<<<<<<< HEAD

  private int idCategoria;
  private String nombre;
  private DtVideos videos;
  private DtListasParticulares listas;

  public DtCategoria() {}

  public DtCategoria(int idCategoria, String nombre, DtVideos videos, DtListasParticulares listas) {
    this.idCategoria = idCategoria;
=======
  // *** VA A HABER UN ID ACA LUEGO ***
=======
>>>>>>> master
  private String nombre;
  private List<DtVideo> videos;
  private List<DtLista> listas;

  public DtCategoria() {}

  public DtCategoria(String nombre, List<DtVideo> videos, List<DtLista> listas) {
>>>>>>> master
    this.nombre = nombre;
    this.videos = videos;
    this.listas = listas;
  }
<<<<<<< HEAD

  public int getId() {
    return this.idCategoria;
  }

  public void setId(int idCategoria) {
    this.idCategoria = idCategoria;
  }
=======
>>>>>>> master

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

<<<<<<< HEAD
  public DtVideos getVideos() {
    return this.videos;
=======
  public List<DtLista> getListas() {
    return listas;
  }

  public void setListas(List<DtLista> listas) {
    this.listas = listas;
  }

  public List<DtVideo> getVideos() {
    return videos;
>>>>>>> master
  }

  public DtListasParticulares getListas() {
    return this.listas;
  }

  public void setVideos(DtVideos videos) {
    this.videos = videos;
  }
<<<<<<< HEAD

  public void setListas(DtListasParticulares listas) {
    this.listas = listas;
  }
  
=======
>>>>>>> master
}
