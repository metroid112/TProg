package clases;

import java.util.LinkedList;
import java.util.List;

import datatypes.DtCategoria;

public class Categoria {

  private int idCategoria;
  private String nombre;
  private List<ListaParticular> listas = new LinkedList<ListaParticular>();
  private List<Video> videos = new LinkedList<Video>();
  private static int idCounter = 0;

  public Categoria(String nombre) {
    this.nombre = nombre;
    Categoria.idCounter++;
    this.idCategoria = Categoria.idCounter;
  }

  public DtCategoria getDt(){
    return new DtCategoria(this.nombre);
  }

  public int getId() {
    return this.idCategoria;
  }

  public String getNombre() {
    return nombre;
  }

  public List<ListaParticular> getListas() {
    return listas;
  }

  public List<Video> getVideos() {
    return videos;
  }

  public void addVideo(Video video) {
    videos.add(video);
  }

  public void addLista(ListaParticular listaParticular) {
    listas.add(listaParticular);
  }

  public void removeVideo(Video video) {
    this.videos.remove(video);
  }

  @Override
  public boolean equals(Object object) {
    Categoria categoria = (Categoria) object;
    return this.nombre.equals(categoria.nombre) || this.idCategoria == categoria.idCategoria;
  }
}
