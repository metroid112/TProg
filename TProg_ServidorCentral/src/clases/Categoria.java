package clases;

import java.util.LinkedList;

public class Categoria {

  private LinkedList<ListaParticular> listas = new LinkedList<ListaParticular>();

  private String nombre;
  private LinkedList<Video> videos = new LinkedList<Video>();

  public Categoria(String nombre) {
    this.nombre = nombre;
  }

  public void addVideo(Video v) {
    videos.add(v);
  }

  @Override
  public boolean equals(Object categoria) {
    return (this.nombre.equals(((Categoria) categoria).getNombre()));
  }

  public String[] getInfoListas() {
    String[] infoListas = new String[listas.size()];
    if (!listas.isEmpty()) {
      int i = 0;
      for (Lista lista : listas) {
        String nomLista = lista.getCanal().getUsuario().getNick();
        infoListas[i] = "(" + lista.getNombre() + " - " + nomLista + ")";
        i++;
      }
    }
    return infoListas;
  }

  public String[] getInfoVideos() {
    String[] infoVideos = new String[videos.size()];
    if (!videos.isEmpty()) {
      int i = 0;
      for (Video video : videos) {
        String nomVideo = video.getCanal().getUsuario().getNick();
        infoVideos[i] = "(" + video.getNombre() + " - " + nomVideo + ")";
        i++;
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
