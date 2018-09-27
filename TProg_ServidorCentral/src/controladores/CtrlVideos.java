package controladores;

import java.time.Duration;
import java.util.Date;

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

public class CtrlVideos implements IVideos {
  private ManejadorCategorias manejadorCategoria = ManejadorCategorias.getManejadorCategorias();
  private ManejadorUsuarios manejadorUsuario = ManejadorUsuarios.getManejadorUsuarios();

  public CtrlVideos() {

  }

  @Override
  public void altaVideo(String nick, String nombre, String descripcion, Duration duracion,
      String url, String nombreCategoria, Date fecha, boolean visibilidad)
      throws DuplicateClassException, NotFoundException {
    Categoria categoria = manejadorCategoria.get(nombreCategoria);
    if (categoria == null) {
      throw new NotFoundException("Categoría " + nombreCategoria);
    }
    Usuario user = manejadorUsuario.get(nick);
    if (user == null) {
      throw new NotFoundException("Usuario " + nick);
    }
    Video video = user.getCanal().altaVideo(nombre, descripcion, duracion, url, categoria,
        fecha, visibilidad);
    categoria.addVideo(video);
  }

  @Override
  public DtVideo getDtVideo(String video, String usuario) {

    Video vid = manejadorUsuario.get(usuario).getCanal().getVideoCanal(video);
    return vid.getDt();
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
    Usuario usuario = manejadorUsuario.get(nick);
    if (usuario != null) {
      return usuario.getCanal().getArrayVideos();
    } else {
      return null;
    }
  }

  @Override
  public void modificarVideo(String nick, String nombreOld, String nombre, String descripcion,
      String url, String categoriaString, Duration duracion, Boolean visible, Date fecha)
      throws InvalidDataException {
    Video vid = manejadorUsuario.get(nick).getCanal().getVideoCanal(nombreOld);
    vid.getCanal().modVideo(nombreOld, nombre);
    Categoria categoria;
    if (categoriaString != null) {
      categoria = manejadorCategoria.get(categoriaString);
    } else {
      categoria = null;
    }
    vid.modificarDatos(nombre, descripcion, url, categoria, duracion, visible, fecha);

  }
}
