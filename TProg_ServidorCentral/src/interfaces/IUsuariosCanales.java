package interfaces;

import java.util.Date;
import java.util.List;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

public interface IUsuariosCanales {

  public void altaUsuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String imagenPath, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible, String pass) throws NotFoundException, DuplicateClassException;

  public boolean existeUsuario(int nick);

  public boolean existeUsuarioMail(String mail) throws NotFoundException;
  
  public boolean existeUsuarioNick(String nick) throws NotFoundException;
  
  public void modificarUsuario(DtUsuario usuarioModificado, DtUsuario usuarioOriginal) throws NotFoundException, DuplicateClassException ;
  
  public DtUsuario getDt(int nick) throws NotFoundException;

  public List<DtUsuario> listarDtUsuarios();
  
  public boolean checkLogin(int idUsuario, String pass) throws NotFoundException;
  
  public boolean isCanalPublico(int idUsuario) throws NotFoundException;

 // public List<DtVideo> listarDtVideosLista(int idUsuario, String lista, boolean defecto) throws NotFoundException; se pasa  al controlador listas

  public List<DtVideo> listarVideosCanal(int idUsuario) throws NotFoundException;

  public List<DtVideo> getListaPublicoDtVideo();

  void comentarVideo(String texto, Date fecha, int nombreUsuario, int idVideo,
      int idOwnerVideo) throws NotFoundException;

  void responderComentario(String texto, Date fecha, int nombreUsuario, int nombreVideo,
      String nombreDuenoVideo, Integer idComentarioPadre) throws NotFoundException;
  
  void valorarVideo(int idUsuario, boolean like, int nombreVideo) throws NotFoundException;

  public boolean yaCalificacdo(int nombreUsuario, boolean like, int nombreVideo,
      int nombreDuenoVideo) throws NotFoundException;

  void modificarValoracion(boolean like, int idUsuario, int idVideo) throws NotFoundException;
  
  public void seguir(int idUsuarioSeguidor, int idUsuarioSeguido) throws NotFoundException;
  
  public List<String> getSeguidores(int idUsuario) throws NotFoundException;

  public List<String> getSeguidos(int idUsuario) throws NotFoundException;

  public boolean isSeguidor(int seguidor, int seguido) throws NotFoundException;

  public void dejarSeguir(int idSeguidor, int idSeguido) throws NotFoundException;

}
