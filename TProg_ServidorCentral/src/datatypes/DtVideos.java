package datatypes;

import java.util.HashMap;
import java.util.Map;

import clases.Video;

public class DtVideos extends DtUniversal {
  
  private Map<Integer, DtVideo> videos = new HashMap<Integer, DtVideo>();

  public DtVideos(Map<Integer, Video> videos) {
    for(Video video : videos.values()) {
      this.videos.put(video.getId(), video.getDt());
    }
  }

  public Map<Integer, DtVideo> getVideos() {
    return this.videos;
  }

  public void setVideos(Map<Integer, DtVideo> videos) {
    this.videos = videos;
  }
}
