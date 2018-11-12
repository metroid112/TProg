package clases;

import java.util.LinkedList;
import java.util.List;

import datatypes.DtCategoria;

public class Categoria {

  private List<ListaParticular> listas = new LinkedList<ListaParticular>();
  private static int contadorID = 0;
  private int idCategoria;
  private String nombre;
  private List<Video> videos = new LinkedList<Video>();

  public Categoria(String nombre) {
    this.nombre = nombre;
    this.idCategoria = Categoria.contadorID;
    Categoria.contadorID++;
  }

  public DtCategoria getDt() {
    return new DtCategoria(this.nombre, this.idCategoria, this.videos, this.listas);
  }
  
  public int getIdCategoria() {
    return idCategoria;
  }

  public void addVideo(Video video) {
    videos.add(video);
  }

  @Override
  public boolean equals(Object categoria) {
    return (this.nombre.equals(((Categoria) categoria).getNombre()));
  }

  public List<ListaParticular> getListas() {
    return listas;
  }

  public void setListas(List<ListaParticular> listas) {
    this.listas = listas;
  }

  public List<Video> getVideos() {
    return videos;
  }

  public void setVideos(List<Video> videos) {
    this.videos = videos;
  }

  public String[] getInfoListas() {
    String[] infoListas = new String[listas.size()];
    if (!listas.isEmpty()) {
      int contador = 0;
      for (Lista lista : listas) {
        String nomLista = lista.getCanal().getUsuario().getNick();
        infoListas[contador] = "(" + lista.getNombre() + " - " + nomLista + ")";
        contador++;
      }
    }
    return infoListas;
  }

  public String[] getInfoListasPublicas() {
    String[] infoListas = new String[listas.size()];
    if (!listas.isEmpty()) {
      int contador = 0;
      for (ListaParticular lista : listas) {
        if (lista.isVisible()) {
          String nomLista = lista.getCanal().getUsuario().getNick();
          infoListas[contador] = "(" + lista.getNombre() + " - " + nomLista + ")";
          contador++;
        }
      }
    }
    return infoListas;
  }

  public String[] getInfoVideos() {
    String[] infoVideos = new String[videos.size()];
    if (!videos.isEmpty()) {
      int contador = 0;
      for (Video video : videos) {
        String nomVideo = video.getCanal().getUsuario().getNick();
        infoVideos[contador] = "(" + video.getNombre() + " - " + nomVideo + ")";
        contador++;
      }
    }
    return infoVideos;
  }

  public String[] getInfoVideosPublicos() {
    String[] infoVideos = new String[videos.size()];
    if (!videos.isEmpty()) {
      int contador = 0;
      for (Video video : videos) {
        if (video.isVisible()) {
          String nomVideo = video.getCanal().getUsuario().getNick();
          infoVideos[contador] = "(" + video.getNombre() + " - " + nomVideo + ")";
          contador++;
        }
      }
    }
    return infoVideos;
  }

  public String getNombre() {
    return nombre;
  }

  public void addLista(ListaParticular listaParticular) {
    listas.add(listaParticular);
  }

  public void remove(Video video) {
    this.videos.remove(video);

  }
}
