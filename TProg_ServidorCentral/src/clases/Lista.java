package clases;

import java.util.LinkedList;
import java.util.List;

import datatypes.DtLista;
import datatypes.DtVideo;

public abstract class Lista {

  private Canal canal;
  private String nombre;
  private Map<Integer, Video> videos = new HashMap<Integer, Video>();
  private int idLista;
  private static int idCounter = 0;

  public abstract DtLista getDtLista();

  public Lista(String nombre, Canal canal) {
    this.nombre = nombre;
    this.canal = canal;
    Lista.idCounter++;
    this.idLista = Lista.idCounter;
  }

  public int getId() {
    return this.idLista;
  }

  public boolean existeVideo(int idVideo) {
    return videos.contains(video);
  }

  public Map<Integer, Video> getVideos() {
    return this.videos;
  }

  public Canal getCanal() {
    return canal;
  }

  public String getNombre() {
    return nombre;
  }

  public Video getVideo(int idVideo) {
    return this.videos.get(idVideo);
  }

  public void agregarVideo(Video video) {
    videos.put(video.getId(), video);
  }

  public void quitarVideo(Video video) { // TODO: Cambiar a MAP
    videos.remove(video);
  }
}
