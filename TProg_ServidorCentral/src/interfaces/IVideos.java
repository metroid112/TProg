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

  public String[] listarCategorias();

  public String[] listarUsuarios();

  public String[] listarVideos(int idUsuario);

  public void modificarVideo(int idUsuario, String nombreOld, String nombre, String descripcion,
      String url, String categoria, Duration duracion, boolean visible, Date fecha)
      throws InvalidDataException, DuplicateClassException;

  public DtVideo[] listarTodosLosVideos(String nick);

  public List<DtVideo> getDtVideosPublicos(int idUsuario);

  public List<DtVideo> getDtVideosPropietario(int idUsuario);
}
