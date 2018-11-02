package interfaces;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;

public interface IVideos {
  public void altaVideo(int idUsuario, String nombre, String descripcion, Duration duracion,
      String url, String categoria, Date fecha, boolean visibilidad)
      throws DuplicateClassException, NotFoundException;

  public DtVideo getDtVideo(int idVideo) throws NotFoundException;

  public Map<Integer, DtVideo> getDtVideos();

  public List<DtVideo> listarVideos(int idUsuario) throws NotFoundException;

  public DtVideo[] listarTodosLosVideos(int idUsuario);
  
  public void modificarVideo(int idUsuario, int nombreOld, String nombre, String descripcion,
      String url, String categoria, Duration duracion, boolean visible, Date fecha)
      throws InvalidDataException, DuplicateClassException, NotFoundException;

  public List<DtVideo> getDtVideosPublicos();

  public int getIdVideoNombre(String nombreVideo) throws NotFoundException;
}
