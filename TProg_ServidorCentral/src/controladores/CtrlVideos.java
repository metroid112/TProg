package controladores;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import clases.Categoria;
import clases.Usuario;
import clases.Video;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;
import manejadores.ManejadorVideos;

public class CtrlVideos implements IVideos {
  private ManejadorCategorias manejadorCategoria = ManejadorCategorias.getManejadorCategorias();
  private ManejadorUsuarios manejadorUsuario = ManejadorUsuarios.getManejadorUsuarios();

  public CtrlVideos() {

  }

  @Override
  public void altaVideo(String nick, String nombre, String descripcion, Duration duracion,
      String url, String nombreCategoria, Date fecha, boolean visibilidad)
      throws DuplicateClassException, NotFoundException {
    Categoria categoria = manejadorCategoria.getCategoria(nombreCategoria);
    if (categoria == null) {
      throw new NotFoundException("Categor�a " + nombreCategoria);
    }
    Usuario user = manejadorUsuario.getUsuario(nick);
    if (user == null) {
      throw new NotFoundException("Usuario " + nick);
    }
    Video video = user.getCanal().altaVideo(nombre, descripcion, duracion, url, categoria,
        fecha, visibilidad);
    categoria.addVideo(video);
  }

  @Override
  public DtVideo getDtVideo(int idVideo) throws NotFoundException {
    Video video = ManejadorVideos.getManejadorVideos().getVideo(idVideo);
    return video.getDt();
  }

  @Override
  public String[] listarCategorias() {
    return manejadorCategoria.toArray();
  }

  @Override
  public String[] listarUsuarios() {
    return manejadorUsuario.toArray();
  }

  @Override
  public String[] listarVideos(String nick) {
    Usuario usuario = manejadorUsuario.getUsuario(nick);
    if (usuario != null) {
      return usuario.getCanal().getArrayVideos();
    } else {
      return null;
    }
  }

  @Override
  public List<DtVideo> getDtVideosPropietario(String nick) {
    Usuario usuario = manejadorUsuario.getUsuario(nick);
    if (usuario != null) {
      return usuario.getCanal().getDtVideos();
    } else {
      return null;
    }
  }

  @Override
  public DtVideo[] listarTodosLosVideos(int idUsuario) {
    List<DtVideo> listaVideos = new ArrayList<DtVideo>();
    for (Usuario usuario : manejadorUsuario.getUsuarios().values()) {
      List<DtVideo> lista = usuario.getCanal().getVideosPublicos();
      listaVideos.addAll(lista);
    }
    Usuario user = manejadorUsuario.getUsuario(idUsuario);
    List<DtVideo> lista = user.getCanal().getDtVideosPrivados();
    listaVideos.addAll(lista);
    return listaVideos.toArray(new DtVideo[listaVideos.size()]);
  }

  @Override
  public void modificarVideo(String nick, String nombreOld, String nombre, String descripcion,
      String url, String categoriaString, Duration duracion, boolean visible, Date fecha)
      throws InvalidDataException, DuplicateClassException {
    Video vid = manejadorUsuario.getUsuario(nick).getCanal().getVideoCanal(nombreOld);
    vid.getCanal().modVideo(nombreOld, nombre);
    Categoria categoria;
    if (categoriaString != null) {
      categoria = manejadorCategoria.getCategoria(categoriaString);
    } else {
      categoria = null;
    }
    vid.modificarDatos(nombre, descripcion, url, categoria, duracion, visible, fecha);

  }

  @Override
  public Map<Integer, DtVideo> getDtVideos() {
    Map<Integer, DtVideo> dtVideos = new HashMap<Integer, DtVideo>();
    for (Entry<Integer, Video> video : ManejadorVideos.getManejadorVideos().getVideos()
        .entrySet()) {
      dtVideos.put(video.getKey(), video.getValue().getDt());
    }
    return dtVideos;
  }

  @Override
  public List<DtVideo> getDtVideosPublicos(String nombreUsuario) {
    return ManejadorUsuarios.getManejadorUsuarios().getUsuario(nombreUsuario).getCanal()
        .getVideosPublicos();
  }
}
