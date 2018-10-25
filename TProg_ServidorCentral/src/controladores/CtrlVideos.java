package controladores;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import clases.Canal;
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
  private ManejadorVideos  manejadorVideo = ManejadorVideos.getManejadorVideos();

  public CtrlVideos() {

  }

  @Override
  public void altaVideo(int idUsuario, String nombreVideo, String descripcion, Duration duracion,
      String url, String nombreCategoria, Date fecha, boolean visibilidad)
      throws DuplicateClassException, NotFoundException {
    Categoria categoria = manejadorCategoria.getCategoria(nombreCategoria);
    if (categoria == null) {
      throw new NotFoundException("Categor�a " + nombreCategoria);
    }
    Usuario user = manejadorUsuario.getUsuario(idUsuario);
    if (user == null) {
      throw new NotFoundException("Usuario no encontrado"); 
    }
    Video video = new Video(nombreVideo, descripcion, duracion, url, categoria,user.getCanal(), fecha, visibilidad);
    user.getCanal().altaVideo(video);
    categoria.addVideo(video);
  }

  @Override
  public DtVideo getDtVideo(int idVideo) throws NotFoundException {
    Video video = ManejadorVideos.getManejadorVideos().getVideo(idVideo);
    return video.getDt();
  }
/*
  @Override
  public String[] listarCategorias() {
    return manejadorCategoria.toArray();
  }

  @Override
  public String[] listarUsuarios() {
    return manejadorUsuario.toArray();
  }
*/
  @Override
  public String[] listarVideos(int idUsuario) {
    Usuario usuario = manejadorUsuario.getUsuario(idUsuario);
    if (usuario != null) {
      return usuario.getCanal().getArrayVideos();
    } else {
      return null;
    }
  }

  @Override
  public List<DtVideo> getDtVideosPropietario(int idUsuario) throws NotFoundException{
    Usuario usuario = manejadorUsuario.getUsuario(idUsuario);
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
      List<DtVideo> lista = usuario.getCanal().listaPublicoDtVideo();
      listaVideos.addAll(lista);
    }
    Usuario user = manejadorUsuario.getUsuario(idUsuario);
    List<DtVideo> lista = user.getCanal().getDtVideosPrivados();
    listaVideos.addAll(lista);
    return listaVideos.toArray(new DtVideo[listaVideos.size()]);
  }

  @Override
  public void modificarVideo(int idUsuario, int idVideo, String nombre, String descripcion,
      String url, String categoriaString, Duration duracion, boolean visible, Date fecha)
      throws InvalidDataException, DuplicateClassException, NotFoundException {
    Video vid = manejadorVideo.getVideo(idVideo);
    vid.getCanal().modVideo(nombre,idVideo);
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
  public List<DtVideo> getDtVideosPublicos() {
    List<DtVideo> result = new LinkedList<DtVideo>();
    List<DtVideo> listaUsuario = null;

    for (Usuario usuarioObjetivo : manejadorUsuario.getUsuarios().values()) {

      Canal canalObjetivo = usuarioObjetivo.getCanal();
      listaUsuario = canalObjetivo.listaPublicoDtVideo();

      for (DtVideo v : listaUsuario) {
        result.add(v);
      }

    }
    return result;
  }
}
