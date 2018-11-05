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
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;
import manejadores.ManejadorVideos;


public class CtrlUsuariosCanales implements IUsuariosCanales {

  private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
  private ManejadorVideos manejadorVideos = ManejadorVideos.getManejadorVideos();
  private IVideos controladorVideos = Fabrica.getIVideos();

  public CtrlUsuariosCanales() {
  }

  @Override
  public void altaUsuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String imagenPath, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible, String pass) throws NotFoundException, DuplicateClassException{
    Usuario user =
        new Usuario(nickname, nombre, apellido, correo, fechaNacimiento, imagenPath, pass);
    String descCanal = nombreCanal.equals("") || nombreCanal == null ? nickname : nombreCanal;
    Canal canal = new Canal(nombreCanal, descCanal,
    ManejadorCategorias.getManejadorCategorias().getCategoria(categoria), visible, user);
    user.setCanal(canal);
    manejadorUsuarios.addUsuario(user);
  }

  @Override
  public boolean existeUsuario(int idUsuario) { //Se usa en WorkStation
    return manejadorUsuarios.existeUsuarioId(idUsuario);
  }

  @Override
  public boolean existeUsuarioMail(String mail) throws NotFoundException { //Se usa en WorkStation
    if (manejadorUsuarios.getUsuarioCorreo(mail) != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public boolean existeUsuarioNick(String nick) throws NotFoundException{ //Se usa en WorkStation
    if(manejadorUsuarios.getUsuarioNick(nick) != null){
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public void modificarUsuario(DtUsuario usuarioModificado, DtUsuario usuarioOriginal) throws NotFoundException, DuplicateClassException{
    if (!usuarioModificado.getNick().equals(usuarioOriginal.getNick())
        && manejadorUsuarios.getUsuario(usuarioModificado.getIdUsuario()) != null) {
      throw new DuplicateClassException("Usuario", usuarioModificado.getNick());
    }
    if(!usuarioModificado.getCorreo().equals(usuarioOriginal.getCorreo()) && manejadorUsuarios.getUsuarioCorreo(usuarioModificado.getCorreo()) != null) {
      throw new DuplicateClassException("Usuario", usuarioModificado.getCorreo());
    }
    Usuario usuario = manejadorUsuarios.getUsuario(usuarioOriginal.getIdUsuario());
    usuario.modificarUsuario(usuarioModificado);
  }

  @Override
  public DtUsuario getDt(int idUsuario) throws NotFoundException{
    return manejadorUsuarios.getUsuario(idUsuario).getDt();
  }

  @Override
  public List<DtUsuario> listarDtUsuarios(){
    List<DtUsuario> resultado = new LinkedList<DtUsuario>();
    for (Usuario usuario : manejadorUsuarios.getUsuarios().values()) {
      
      resultado.add(usuario.getDt());
    }
    return resultado;
  }

  @Override
  public boolean checkLogin(int idUsuario, String pass) throws NotFoundException {
    return manejadorUsuarios.getUsuario(idUsuario).checkPass(pass);
  }

  @Override
  public boolean isCanalPublico(int idUsuario) throws NotFoundException{
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    return usuarioObjetivo.getCanal().isVisible();
  }

  @Override
  public List<DtVideo> listarDtVideosLista(int idUsuario, String lista, boolean defecto) throws NotFoundException{
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    return usuarioObjetivo.getCanal().listarVideosLista(lista, defecto);
  }

  @Override
  public List<DtVideo> listarVideosCanal(int idUsuario) throws NotFoundException {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    return canalObjetivo.listaDtVideo();
  }

  @Override
  public List<DtVideo> getListaPublicoDtVideo() {
    return controladorVideos.getDtVideosPublicos();
  }

  @Override
  public void comentarVideo(String texto, Date fecha, int idUsuario, int idVideo,
      int idOwnerVideo) throws NotFoundException{
    Usuario usuario = manejadorUsuarios.getUsuario(idUsuario);
    Video vid = manejadorVideos.getVideo(idVideo);
    usuario.comentar(texto, fecha, vid);
  }

  @Override
  public void responderComentario(String texto, Date fecha, int idUsuario,
      int idVideo, String nombreDuenoVideo, Integer idComentarioPadre) throws NotFoundException{

    Usuario usuario = manejadorUsuarios.getUsuario(idUsuario);
    Video vid = manejadorVideos.getVideo(idVideo);
    usuario.responder(texto, fecha, idComentarioPadre, vid);
  }

  @Override
  public void valorarVideo(int idUsuario, boolean like, int nombreVideo) throws NotFoundException {
    Usuario usuario = manejadorUsuarios.getUsuario(idUsuario);
    Video vid = manejadorVideos.getVideo(nombreVideo);
    usuario.valorarVideo(like, vid);
  }

  @Override
  public boolean yaCalificacdo(int nombreUsuario, boolean like, int idVideo,
      int nombreDuenoVideo) throws NotFoundException {
    Usuario usuario = manejadorUsuarios.getUsuario(nombreUsuario);
    Usuario dueno = manejadorUsuarios.getUsuario(nombreDuenoVideo);
    Video vid = manejadorVideos.getVideo(idVideo);
    return usuario.yaCalificado(like, vid);
  }

  @Override
  public void modificarValoracion(boolean like, int idUsuario, int idVideo) throws NotFoundException {
    Usuario usuario = manejadorUsuarios.getUsuario(idUsuario);
    Video vid = manejadorVideos.getVideo(idVideo);
    usuario.modificarValoracion(like, vid);
  }

  @Override
  public void seguir(int idUsuarioSeguidor, int idUsuarioSeguido) throws NotFoundException {
    manejadorUsuarios.getUsuario(idUsuarioSeguidor).seguir(manejadorUsuarios.getUsuario(idUsuarioSeguido));
  }

  @Override
  public void dejarSeguir(int idUsuarioSeguidor, int idUsuarioSeguido) throws NotFoundException {
    manejadorUsuarios.getUsuario(idUsuarioSeguidor).dejarSeguir(manejadorUsuarios.getUsuario(idUsuarioSeguido));
  }

  @Override
  public List<String> getSeguidores(int idUsuario) throws NotFoundException {
    List<String> seguidores = new LinkedList<String>();
    for (Usuario seguidor : manejadorUsuarios.getUsuario(idUsuario)
        .getSeguidores().values()) {
      seguidores.add(seguidor.getNick());
    }
    return seguidores;
  }

  @Override
  public List<String> getSeguidos(int idUsuario) throws NotFoundException {
    List<String> seguidos = new LinkedList<String>();
    for (Usuario seguido : manejadorUsuarios.getUsuario(idUsuario)
        .getSeguidos().values()) {
      seguidos.add(seguido.getNick());
    }
    return seguidos;
  }

  @Override
  public boolean isSeguidor(int seguidor, int seguido) throws NotFoundException {
    Usuario userSeguidor = manejadorUsuarios.getUsuario(seguidor);
    Usuario userSeguido = manejadorUsuarios.getUsuario(seguido);
    return (userSeguidor.getSeguidos().containsKey(seguido)
        && userSeguido.getSeguidores().containsKey(seguidor));
  }
}
