package clases;

import java.util.LinkedList;
import java.util.List;

public class Categoria {

  private int idCategoria;
  private String nombre;
  private List<Video> videos = new LinkedList<Video>();
  private List<ListaParticular> listas = new LinkedList<ListaParticular>();

  private static int idCounter = 0;

  public Categoria(String nombre) {
    this.nombre = nombre;
    Categoria.idCounter++;
    this.idCategoria = Categoria.idCounter;
  }

  public void addVideo(Video video) {
    videos.add(video);
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

  @Override
  public boolean equals(Object object) {
    Categoria categoria = (Categoria) object;
    return this.nombre.equals(categoria.nombre) || this.idCategoria == categoria.idCategoria;
  }
}
