package controladores;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import clases.Calificacion;
import clases.Canal;
import clases.Categoria;
import clases.Comentario;
import clases.Imagen;
import clases.ListaDefecto;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IUsuariosCanales;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlUsuariosCanales implements IUsuariosCanales {

  private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();

  public CtrlUsuariosCanales() {

  }

  @Override
  public void altaUsuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, byte[] imgByte, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible, String pass) {
    Imagen img = null;
    if (imgByte != null) {
      img = new Imagen(imgByte); 
    }
    Usuario user =
        new Usuario(nickname, nombre, apellido, correo, fechaNacimiento, img, pass);
    String descCanal;
    if (descripcionCanal.equals("") || descripcionCanal == null) {
      descCanal = nickname;
    } else {
      descCanal = descripcionCanal;
    }
    Canal canal = new Canal(nombreCanal, descCanal,
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
    return (userSeguidor.getSeguidos().containsKey(seguido)
        && userSeguido.getSeguidores().containsKey(seguidor));
  }

  @Override
  public void modificarUsuario(DtUsuario usuarioModificado, DtUsuario usuarioOriginal) throws DuplicateClassException {
    if(!usuarioModificado.nick.equals(usuarioOriginal.nick) && manejadorUsuarios.get(usuarioModificado.nick) != null) {
      throw new DuplicateClassException("Usuario", usuarioModificado.nick);
    }
    if(!usuarioModificado.correo.equals(usuarioOriginal.correo) && manejadorUsuarios.mailGet(usuarioModificado.correo) != null) {
      throw new DuplicateClassException("Usuario", usuarioModificado.correo);
    }
    Usuario usuario = manejadorUsuarios.get(usuarioOriginal.nick);
    
  }

  @Override
  public void bajaUsuario(String nickUsuario) throws NotFoundException {
    Usuario user = manejadorUsuarios.get(nickUsuario);
    if (user == null) {
      throw new NotFoundException(nickUsuario);
    } else {
      // ** CALIFICACIONES **
      List<Calificacion> calificaciones = user.getCalificaciones();
      for (Calificacion calificacion : calificaciones) {
        
        // Remuevo link video -> calificacion
        List<Calificacion> calificacionesVideo = calificacion.getVideo().getCalificaciones();
        for (Calificacion calificacionVideo : calificacionesVideo) {
          if (calificacionVideo.getUsuario().getId() == user.getId()) {
            calificacionesVideo.remove(calificacionVideo);
            break;
          }
        }
        
        // Remuevo link calificacion -> video
        calificacion.setVideo(null); 
        
        // Remuevo link calificacion -> usuario
        calificacion.setUsuario(null);
        
        // Ya esta desreferenciado asi que no se si es necesario este paso
        calificacion = null;
      }
      calificaciones.clear();
      calificaciones = null;
      
      // ** VIDEOS **
      Map<String, Video> videos = user.getCanal().getVideos();
      for (Video video : videos.values()) {
        // ** COMENTARIOS **
        video.getComentarios().clear();
        video.setComentarios(null);
        
        // ** CALIFICACIONES **        
        List<Calificacion> calificacionesVideo = video.getCalificaciones();
        for(Calificacion calificacionVideo : calificacionesVideo) {
          calificacionVideo.getUsuario().getCalificaciones().remove(calificacionVideo);
          calificacionVideo.setUsuario(null);
          
          calificacionVideo.setVideo(null);
          
          calificacionVideo = null;
        }        
        calificacionesVideo.clear();
        calificacionesVideo = null;
        
        // ** LISTAS PARTICULARES Y DEFECTO **
        for (Usuario usuarioVideoLista : ManejadorUsuarios.getManejadorUsuarios().getMap().values()) {
          for(ListaDefecto listaDefectoVideo : usuarioVideoLista.getCanal().getListaDefecto().values()) {
            listaDefectoVideo.getVideos().remove(video);
          }
          for(ListaParticular listaParticularVideo : usuarioVideoLista.getCanal().getListaParticulares().values()) {
            user.getCanal().quitarVideoListaParticular(video.getNombre(), listaParticularVideo.getNombre(), user);
          }
        }      
        
        // ** CATEGORIA **
        video.getCategoria().getVideos().remove(video);
        video.setCategoria(null);
        
        // ** CANAL **
        video.setCanal(null);
        user.getCanal().getVideos().remove(video.getNombre());
        
        video = null;
      }
      videos.clear();
      videos = null;
      
      // ** LISTAS PARTICULARES **
      Map<String, ListaParticular> listasParticulares = user.getCanal().getListaParticulares();
      for (ListaParticular listaParticular : listasParticulares.values()) {
        listaParticular.getCategorias().clear();
        listaParticular.setCategorias(null);
        
        listaParticular.getVideos().clear();
        listaParticular.setVideos(null);
        
        listaParticular.setCanal(null);
        
        listaParticular = null;
      }
      listasParticulares.clear();
      listasParticulares = null;
      
      
      // ** LISTAS DEFECTO ** 
      Map<String, ListaDefecto> listasDefecto = user.getCanal().getListaDefecto();
      for (ListaDefecto listaDefecto : listasDefecto.values()) {
        listaDefecto.getVideos().clear();
        listaDefecto.setVideos(null);
        
        listaDefecto.setCanal(null);        
        
        listaDefecto = null;
      }
      listasDefecto.clear();
      listasDefecto = null;
      
      // ** CATEGORIAS **
      user.getCanal().setCategoria(null);
      
      // ** SEGUIDORES **
      Map<String, Usuario> seguidores = user.getSeguidores();
      for (Usuario seguidor : seguidores.values()) {
        seguidor.dejarSeguir(user);        
      }
      seguidores.clear();
      seguidores = null;
      
      // ** SEGUIDOS **
      Map<String, Usuario> seguidos = user.getSeguidos();
      for (Usuario seguido : seguidos.values()) {
        user.dejarSeguir(seguido);        
      }
      seguidos.clear();
      seguidos = null;
      
      // ** COMENTARIOS **
      List<Comentario> comentarios = user.getComentarios();
      for (Comentario comentario : comentarios) {
        comentario.getRespuestas().clear(); // TODO: hijos tienen referencias?
        comentario.setRespuestas(null);
        
        comentario.getVideo().getComentarios().remove(comentario.getId());
        
        comentario = null;
      }
      comentarios.clear();
      comentarios = null;
      
      // ** CANAL ** 
      user.setCanal(null);
      
      // ** MANEJADOR **
      manejadorUsuarios.getMap().remove(nickUsuario);
      
      // ** IMAGEN **
      Imagen imagen = user.getImg();
      
      if (imagen != null) {
        Imagen.borrar(imagen.getId());
      }
      
      // ** USUARIO **
      user = null;
    }
  }
}
