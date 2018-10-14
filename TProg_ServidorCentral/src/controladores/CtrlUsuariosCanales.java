package controladores;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import clases.Canal;
import clases.Usuario;
import clases.Video;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.IUsuariosCanales;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlUsuariosCanales implements IUsuariosCanales {

  private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();

  public CtrlUsuariosCanales() {

  }

  @Override
  public void altaUsuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String imagenPath, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible, String pass) {
    Usuario user =
        new Usuario(nickname, nombre, apellido, correo, fechaNacimiento, imagenPath, pass);
    Canal canal = new Canal(nombreCanal, descripcionCanal,
        ManejadorCategorias.getManejadorCategorias().get(categoria), visible, user);
    user.setCanal(canal);
    manejadorUsuarios.add(user);
  }

  @Override
  public void comentarVideo(String texto, Date fecha, String nombreUsuario, String nombreVideo,
      String ownerVideo) {
    Usuario usuario = manejadorUsuarios.get(nombreUsuario);
    Usuario owner = manejadorUsuarios.get(ownerVideo);
    Video vid = owner.getCanal().getVideoCanal(nombreVideo);
    usuario.comentar(texto, fecha, vid);
  }

  @Override
  public void responderComentario(String texto, Date fecha, String nombreUsuario,
      String nombreVideo, String nombreDuenoVideo, Integer idComentarioPadre) {
    Usuario usuario = manejadorUsuarios.get(nombreUsuario);
    Usuario dueno = manejadorUsuarios.get(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    usuario.responder(texto, fecha, idComentarioPadre, vid);
  }

  @Override
  public boolean existeUsuario(String nick) {
    return manejadorUsuarios.isMemberKey(nick);
  }

  @Override
  public boolean existeUsuarioMail(String mail) {
    if (manejadorUsuarios.mailGet(mail) != null) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public DtUsuario getDt(String nick) {
    if (manejadorUsuarios.get(nick) != null) {
      return manejadorUsuarios.get(nick).getDt();
    } else {
      return manejadorUsuarios.mailGet(nick).getDt();
    }
  }

  @Override
  public boolean isCanalPublico(String usuario) {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    return usuarioObjetivo.getCanal().isVisible();
  }

  @Override
  public void valorarVideo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo) {
    Usuario usuario = manejadorUsuarios.get(nombreUsuario);
    Usuario dueno = manejadorUsuarios.get(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    usuario.valorarVideo(like, vid);
  }

  @Override
  public boolean yaCalificacdo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo) {
    Usuario usuario = manejadorUsuarios.get(nombreUsuario);
    Usuario dueno = manejadorUsuarios.get(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    return usuario.yaCalificado(like, vid);
  }

  @Override
  public void modificarValoracion(boolean like, String nombreUsuario, String nombreVideo,
      String nombreDuenoVideo) {
    Usuario usuario = manejadorUsuarios.get(nombreUsuario);
    Usuario dueno = manejadorUsuarios.get(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    usuario.modificarValoracion(like, vid);
  }

  @Override
  public void seguir(String seguidor, String seguido) {
    manejadorUsuarios.get(seguidor).seguir(manejadorUsuarios.get(seguido));
  }

  @Override
  public void dejarSeguir(String seguidor, String seguido) {
    manejadorUsuarios.get(seguidor).dejarSeguir(manejadorUsuarios.get(seguido));
  }

  @Override
  public String[] listarVideosDuenosLista(String usuario, String lista, boolean defecto) {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    return usuarioObjetivo.getCanal().listarVideosDuenosLista(lista, defecto);
  }

  public List<DtVideo> listarDtVideosDuenosLista(String usuario, String lista, boolean defecto) {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    return usuarioObjetivo.getCanal().listarDtVideosDuenosLista(lista, defecto);
  }

  public List<DtVideo> getListaDtVideo(String usuario) { // CUANDO SE BORRA EL LISTAR VIDEOS.JSP SE
                                                         // PUEDE BORRAR ESTA FUNCION, YA HAY OTRA
                                                         // IGUAL EN EL CONTROLADOR VIDEO

    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    return canalObjetivo.listaDtVideo();
  }

  public List<DtVideo> getListaPublicoDtVideo() {

    return manejadorUsuarios.getListaPublicoDtVideo();
  }

  @Override
  public boolean checkLogin(String usr, String pass) {

    if (manejadorUsuarios.get(usr) != null) {
      return manejadorUsuarios.get(usr).checkPass(pass);
    } else {
      return manejadorUsuarios.mailGet(usr).checkPass(pass);
    }

  }

  @Override
  public List<String> listarNombresUsuarios() {
    List<String> resultado = new LinkedList<String>();
    for (Usuario usuario : manejadorUsuarios.getMap().values()) {
      resultado.add(usuario.getNick());
    }
    return resultado;
  }

  @Override
  public List<String> getSeguidores(String nombreUsuario) {
    List<String> seguidores = new LinkedList<String>();
    for (Usuario seguidor : ManejadorUsuarios.getManejadorUsuarios().get(nombreUsuario)
        .getSeguidores().values()) {
      seguidores.add(seguidor.getNick());
    }
    return seguidores;
  }

  @Override
  public List<String> getSeguidos(String nombreUsuario) {
    List<String> seguidos = new LinkedList<String>();
    for (Usuario seguido : ManejadorUsuarios.getManejadorUsuarios().get(nombreUsuario)
        .getSeguidos().values()) {
      seguidos.add(seguido.getNick());
    }
    return seguidos;
  }

  @Override
  public boolean isSeguidor(String seguidor, String seguido) {
    Usuario userSeguidor = ManejadorUsuarios.getManejadorUsuarios().get(seguidor);
    Usuario userSeguido = ManejadorUsuarios.getManejadorUsuarios().get(seguido);
    return (userSeguidor.getSeguidos().containsKey(seguido) && userSeguido.getSeguidores().containsKey(seguidor));
  }
}
