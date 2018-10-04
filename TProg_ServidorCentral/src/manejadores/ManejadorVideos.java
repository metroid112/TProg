package manejadores;

import java.util.HashMap;
import java.util.Map;
import clases.Video;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

public class ManejadorVideos {
  
  private static ManejadorVideos manejador = null;
  
  private ManejadorVideos() {
    
  }
  
  public static ManejadorVideos getManejadorVideos() {
    if (manejador == null) {
      return new ManejadorVideos();
    }
    return manejador;
  }
  
  private Map<Integer, Video> videos = new HashMap<Integer, Video>();
  
  public void add(Video video) throws DuplicateClassException {
    if (!videos.containsKey(video.getId())) {
      this.videos.put(video.getId(), video);
    } else {
      throw new DuplicateClassException("Video", video.getNombre());
    }    
  }
  
  public Video getById(int id) throws NotFoundException {
    if (this.videos.get(id) != null) {
      return this.videos.get(id);
    } else {
      throw new NotFoundException("la id: " + id);
    }    
  }
  
  public Map<Integer, Video> getVideos() {
    return this.videos;
  }
}
