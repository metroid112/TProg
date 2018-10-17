package manejadores;

import java.util.HashMap;
import java.util.Map;

import clases.Video;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

public class ManejadorVideos {

  private static ManejadorVideos manejador = null;
  private Map<Integer, Video> videos = new HashMap<Integer, Video>();

  private ManejadorVideos() {

  }

  public static ManejadorVideos getManejadorVideos() {
    if (manejador == null) {
      manejador = new ManejadorVideos();
    }
    return manejador;
  }

  public void addVideo(Video video) throws DuplicateClassException {
    if (videos.containsKey(video.getId())) {
      throw new DuplicateClassException("Video", video.getNombre());
    } else {
      this.videos.put(video.getId(), video);      
    }
  }

  public Video getVideo(int idVideo) throws NotFoundException {
    if (this.videos.get(idVideo) != null) {
      return this.videos.get(idVideo);
    } else {
      throw new NotFoundException("Video id: " + idVideo);
    }
  }
  
  public boolean existeVideo(int idVideo) {
    return this.videos.containsKey(idVideo);
  }

  public Map<Integer, Video> getVideos() {
    return this.videos;
  }
}
