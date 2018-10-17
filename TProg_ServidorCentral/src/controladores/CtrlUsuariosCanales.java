package controladores;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import clases.Canal;
import clases.Usuario;
import clases.Video;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
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
    String descCanal;
    if (descripcionCanal.equals("") || descripcionCanal == null) {
      descCanal = nickname;
    } else {
      descCanal = descripcionCanal;
    }
    Canal canal = new Canal(nombreCanal, descCanal,
        ManejadorCategorias.getManejadorCategorias().get(categoria), visible, user);
    user.setCanal(canal);
    manejadorUsuarios.addUsuario(user);
  }

  @Override
  public void comentarVideo(String texto, Date fecha, String nombreUsuario, String nombreVideo,
      String ownerVideo) {
    Usuario usuario = manejadorUsuarios.getUsuario(nombreUsuario);
    Usuario owner = manejadorUsuarios.getUsuario(ownerVideo);
    Video vid = owner.getCanal().getVideoCanal(nombreVideo);
    usuario.comentar(texto, fecha, vid);
  }

  @Override
  public void responderComentario(String texto, Date fecha, String nombreUsuario,
      String nombreVideo, String nombreDuenoVideo, Integer idComentarioPadre) {
    Usuario usuario = manejadorUsuarios.getUsuario(nombreUsuario);
    Usuario dueno = manejadorUsuarios.getUsuario(nombreDuenoVideo);
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
    if (manejadorUsuarios.getUsuario(nick) != null) {
      return manejadorUsuarios.getUsuario(nick).getDt();
    } else {
      return manejadorUsuarios.mailGet(nick).getDt();
    }
  }

  @Override
  public boolean isCanalPublico(String usuario) {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    return usuarioObjetivo.getCanal().isVisible();
  }

  @Override
  public void valorarVideo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo) {
    Usuario usuario = manejadorUsuarios.getUsuario(nombreUsuario);
    Usuario dueno = manejadorUsuarios.getUsuario(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    usuario.valorarVideo(like, vid);
  }

  @Override
  public boolean yaCalificacdo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo) {
    Usuario usuario = manejadorUsuarios.getUsuario(nombreUsuario);
    Usuario dueno = manejadorUsuarios.getUsuario(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    return usuario.yaCalificado(like, vid);
  }

  @Override
  public void modificarValoracion(boolean like, String nombreUsuario, String nombreVideo,
      String nombreDuenoVideo) {
    Usuario usuario = manejadorUsuarios.getUsuario(nombreUsuario);
    Usuario dueno = manejadorUsuarios.getUsuario(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    usuario.modificarValoracion(like, vid);
  }

  @Override
  public void seguir(String seguidor, String seguido) {
    manejadorUsuarios.getUsuario(seguidor).seguir(manejadorUsuarios.getUsuario(seguido));
  }

  @Override
  public void dejarSeguir(String seguidor, String seguido) {
    manejadorUsuarios.getUsuario(seguidor).dejarSeguir(manejadorUsuarios.getUsuario(seguido));
  }

  @Override
  public String[] listarVideosDuenosLista(String usuario, String lista, boolean defecto) {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    return usuarioObjetivo.getCanal().listarVideosDuenosLista(lista, defecto);
  }

  public List<DtVideo> listarDtVideosDuenosLista(String usuario, String lista, boolean defecto) {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    return usuarioObjetivo.getCanal().listarDtVideosDuenosLista(lista, defecto);
  }

  public List<DtVideo> getListaDtVideo(String usuario) {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    return canalObjetivo.listaDtVideo();
  }

  public List<DtVideo> getListaPublicoDtVideo() {

    return manejadorUsuarios.getListaPublicoDtVideo();
  }

  @Override
  public boolean checkLogin(String usr, String pass) {

    if (manejadorUsuarios.getUsuario(usr) != null) {
      return manejadorUsuarios.getUsuario(usr).checkPass(pass);
    } else {
      return manejadorUsuarios.mailGet(usr).checkPass(pass);
    }

  }

  @Override
  public List<String> listarNombresUsuarios() {
    List<String> resultado = new LinkedList<String>();
    for (Usuario usuario : manejadorUsuarios.getUsuarios().values()) {
      resultado.add(usuario.getNick());
    }
    return resultado;
  }

  @Override
  public List<String> getSeguidores(String nombreUsuario) {
    List<String> seguidores = new LinkedList<String>();
    for (Usuario seguidor : ManejadorUsuarios.getManejadorUsuarios().getUsuario(nombreUsuario)
        .getSeguidores().values()) {
      seguidores.add(seguidor.getNick());
    }
    return seguidores;
  }

  @Override
  public List<String> getSeguidos(String nombreUsuario) {
    List<String> seguidos = new LinkedList<String>();
    for (Usuario seguido : ManejadorUsuarios.getManejadorUsuarios().getUsuario(nombreUsuario)
        .getSeguidos().values()) {
      seguidos.add(seguido.getNick());
    }
    return seguidos;
  }

  @Override
  public boolean isSeguidor(String seguidor, String seguido) {
    Usuario userSeguidor = ManejadorUsuarios.getManejadorUsuarios().getUsuario(seguidor);
    Usuario userSeguido = ManejadorUsuarios.getManejadorUsuarios().getUsuario(seguido);
    return (userSeguidor.getSeguidos().containsKey(seguido)
        && userSeguido.getSeguidores().containsKey(seguidor));
  }

  @Override
  public void modificarUsuario(DtUsuario usuarioModificado, DtUsuario usuarioOriginal)
      throws DuplicateClassException {
    if (!usuarioModificado.nick.equals(usuarioOriginal.nick)
        && manejadorUsuarios.getUsuario(usuarioModificado.nick) != null) {
      throw new DuplicateClassException("Usuario", usuarioModificado.nick);
    }
    if (!usuarioModificado.correo.equals(usuarioOriginal.correo)
        && manejadorUsuarios.mailGet(usuarioModificado.correo) != null) {
      throw new DuplicateClassException("Usuario", usuarioModificado.correo);
    }
    Usuario usuario = manejadorUsuarios.getUsuario(usuarioOriginal.nick);
    usuario.modificarUsuario(usuarioModificado);
  }
}
