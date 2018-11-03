package clases;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import datatypes.DtLista;
import datatypes.DtVideo;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;

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
    return videos.containsKey(idVideo);
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

  public List<DtVideo> getListVideos(){
    List<DtVideo> resultado = new LinkedList<DtVideo>();
    for(Video video : videos.values()){
      resultado.add(video.getDt());
    }
    return resultado;
  }
  
  public Video getVideo(int idVideo) throws NotFoundException {
    if (this.videos.containsKey(idVideo)) {
      return this.videos.get(idVideo);
    } else {
      throw new NotFoundException("");
    }
  }

  public void agregarVideo(Video video) throws InvalidDataException {
    if (video != null) {
      videos.put(video.getId(), video);
    } else {
      throw new InvalidDataException("");
    }
  }

  public void quitarVideo(int idVideo) {
    videos.remove(idVideo);
  }
}
