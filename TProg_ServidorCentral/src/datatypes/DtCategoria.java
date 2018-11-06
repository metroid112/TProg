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
  private DtVideos videos;
  private DtListasParticulares listas;

  public DtCategoria() {}

  public DtCategoria(int idCategoria, String nombre, DtVideos videos, DtListasParticulares listas) {
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

  public DtVideos getVideos() {
    return this.videos;
  }

  public DtListasParticulares getListas() {
    return this.listas;
  }

  public void setVideos(DtVideos videos) {
    this.videos = videos;
  }

  public void setListas(DtListasParticulares listas) {
    this.listas = listas;
  }
  
}
