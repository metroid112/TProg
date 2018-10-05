package controladores;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import clases.Canal;
import clases.ListaDefecto;
import clases.ListaParticular;
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
      Date fechaNacimiento, BufferedImage imagen, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible) throws IOException {
    Usuario user = new Usuario(nickname, nombre, apellido, correo, fechaNacimiento, imagen);
    Canal canal = new Canal(nombreCanal, descripcionCanal,
        ManejadorCategorias.getManejadorCategorias().get(categoria), visible, user);
    user.setCanal(canal);
    manejadorUsuarios.add(user);
  }

  @Override
  public void altaUsuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String imagenPath, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible, String pass) {
    Usuario user =
        new Usuario(nickname, nombreCanal, apellido, correo, fechaNacimiento, imagenPath, pass);
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
  public boolean isEmailUnique(String email) {
    return manejadorUsuarios.isEmailUnique(email);
  }

  @Override
  public String[] listarListasDeReproduccion(String nick) {
    HashMap<String, ListaDefecto> listasDefecto = (HashMap<String, ListaDefecto>) manejadorUsuarios.get(nick).getCanal()
        .getListaDefecto();
    String[] listaDefecto = listasDefecto.keySet().toArray(new String[listasDefecto.size()]);
    HashMap<String, ListaParticular> listasParticular = (HashMap<String, ListaParticular>) manejadorUsuarios.get(nick).getCanal()
        .getListaParticulares();
    String[] listaParticulares = listasParticular.keySet()
        .toArray(new String[listasParticular.size()]);
    int largo = listaDefecto.length + listaParticulares.length;
    String[] res = new String[largo];
    for (int i = 0; i < listaDefecto.length; i++) {
      res[i] = listaDefecto[i];
    }
    int iter2 = 0;
    for (int i = listaDefecto.length; i < largo; i++) {
      res[i] = listaParticulares[iter2];
      iter2++;
    }
    return res;
  }

  @Override
  public String[] listarSeguidores(String nick) {
    return manejadorUsuarios.get(nick).getSeguidores().keySet()
        .toArray(new String[manejadorUsuarios.get(nick).getSeguidores().size()]);
  }

  @Override
  public void valorarVideo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo) throws Exception {
    Usuario usuario = manejadorUsuarios.get(nombreUsuario);
    Usuario dueno = manejadorUsuarios.get(nombreDuenoVideo); // Puede calificar su propio video?
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    usuario.valorarVideo(like, vid);
  }

  @Override
  public String[] listarSeguidos(String nick) {
    return manejadorUsuarios.get(nick).getSeguidos().keySet()
        .toArray(new String[manejadorUsuarios.get(nick).getSeguidos().size()]);
  }

  @Override
  public String[] listarUsuarios() {
    return manejadorUsuarios.toArray();
  }

  @Override
  public String[] listarVideos(String nick) {
    HashMap<String, Video> videos = (HashMap<String, Video>) manejadorUsuarios.get(nick).getCanal().getVideos();
    String[] res = videos.keySet().toArray(new String[videos.size()]);
    return res;
  }

  @Override
  public String[] listarVideosLista(String usuario, String lista, boolean defecto) {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    return usuarioObjetivo.getCanal().listarVideosLista(lista, defecto);
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
  public void responderComentario(String texto, Date fecha, String nombreUsuario,
      String nombreVideo, String nombreDuenoVideo, Integer idComentarioPadre) {
    Usuario usuario = manejadorUsuarios.get(nombreUsuario);
    Usuario dueno = manejadorUsuarios.get(nombreDuenoVideo);
    Video vid = dueno.getCanal().getVideoCanal(nombreVideo);
    usuario.responder(texto, fecha, idComentarioPadre, vid);
  }

  @Override
  public void seguir(String seguidor, String seguido) {
    manejadorUsuarios.get(seguidor).seguir(manejadorUsuarios.get(seguido));
  }

  @Override
  public String[] listarVideosDuenosLista(String usuario, String lista, boolean defecto) {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    return usuarioObjetivo.getCanal().listarVideosDuenosLista(lista, defecto);
  }
  
  public List<DtVideo> getListaDtVideo(String usuario){
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    return canalObjetivo.listaDtVideo();
  }
  
  public List<DtVideo> getListaPublicoDtVideo(){
    
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
}
