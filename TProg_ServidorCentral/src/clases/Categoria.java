package clases;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import datatypes.DtCategoria;
import datatypes.DtListasParticulares;
import datatypes.DtVideos;

public class Categoria {

  private int idCategoria;
  private String nombre;
  private Map<Integer, Video> videos = new HashMap<Integer, Video>();
  private Map<Integer, ListaParticular> listas = new HashMap<Integer, ListaParticular>();
  private static int idCounter = 0;

  public Categoria(String nombre) {
    this.nombre = nombre;
    Categoria.idCounter++;
    this.idCategoria = Categoria.idCounter;
  }

  public DtCategoria getDt(){
    return new DtCategoria(this.idCategoria, this.nombre, new DtVideos(this.videos), new DtListasParticulares(this.listas));
  }

  public int getId() {
    return this.idCategoria;
  }

  public String getNombre() {
    return nombre;
  }

  public Map<Integer, ListaParticular> getListas() {
    return listas;
  }

  public Map<Integer, Video> getVideos() {
    return videos;
  }

  public void addVideo(Video video) {
    videos.put(video.getId(), video);
  }

  public void addLista(ListaParticular listaParticular) {
    listas.put(listaParticular.getId(), listaParticular);
  }

  public void removeVideo(int idVideo) {
    this.videos.remove(idVideo);
  }

  @Override
  public boolean equals(Object object) {
    Categoria categoria = (Categoria) object;
    return this.nombre.equals(categoria.nombre) || this.idCategoria == categoria.idCategoria;
  }
}
