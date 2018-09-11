package clases;

import java.util.LinkedList;

import datatypes.DtLista;

public abstract class Lista {

  private Canal canal;

  private String nombre;
  private LinkedList<Video> videos = new LinkedList<Video>();

  // Pato: Constructor con todos los atributos, posiblemente se precise cortar
  // algunos
  public Lista(String nombre, Canal canal) {
    this.nombre = nombre;
    this.canal = canal;
  }

  public boolean existeVideo(Video video) {
    return videos.contains(video);
  }

  public String[] getArrayVideos() {
    String[] result = new String[videos.size()];
    int i = 0;
    for (Video v : videos) {
      result[i] = v.getNombre();
      i++;
    }
    return result;
  }

  public String[] getArrayVideosDuenos() {
    String[] result = new String[videos.size()];
    int i = 0;
    for (Video v : videos) {
      result[i] = v.getCanal().getUsuario().getNick() + "-" + v.getNombre();
      i++;
    }
    return result;
  }

  public Canal getCanal() {
    return canal;
  }

  public abstract DtLista getDtLista();

  public String getNombre() {
    return nombre;
  }

  public Video getVideo(String nombreVid, Usuario ownerVideo) { // TODO FIX!
    boolean encontrado = false;
    Video video = null;
    for (Video vid : videos) {
      if (vid.getNombre().equals(nombreVid)
          && (vid.getCanal().getUsuario().getNick() == ownerVideo.getNick())) {
        encontrado = true;
        video = vid;
      }
    }
    /*
     * if (!encontrado) { throw new Exception("Video no existe"); }
     */
    return video;
  }

  public LinkedList<Video> getVideos() {
    return videos;
  }

  public void insertarVideo(Video video) {
    videos.add(video);
  }

  public void quitarVideo(Video video) {
    videos.remove(video);
  }
}
