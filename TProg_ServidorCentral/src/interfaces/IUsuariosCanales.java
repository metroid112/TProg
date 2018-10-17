package interfaces;

import java.util.Date;
import java.util.List;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;

public interface IUsuariosCanales {

  public void altaUsuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String imagenPath, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible, String pass);

  public boolean existeUsuario(String nick);

  public DtUsuario getDt(String nick);

  public boolean isCanalPublico(String usuario);

  public List<String> listarNombresUsuarios();

  public void seguir(String seguidor, String seguido);

  void valorarVideo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo);

  public boolean yaCalificacdo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo);

  void modificarValoracion(boolean like, String nombreUsuario, String nombreVideo,
      String nombreDuenoVideo);

  void comentarVideo(String texto, Date fecha, String nombreUsuario, String nombreVideo,
      String nombreDuenoVideo);

  void responderComentario(String texto, Date fecha, String nombreUsuario, String nombreVideo,
      String nombreDuenoVideo, Integer idComentarioPadre);

  public String[] listarVideosDuenosLista(String usuario, String lista, boolean defecto);

  public List<DtVideo> listarDtVideosDuenosLista(String usuario, String lista, boolean defecto);

  public List<DtVideo> getListaDtVideo(String usuario);

  public List<DtVideo> getListaPublicoDtVideo();

  public boolean checkLogin(String usr, String pass);

  public boolean existeUsuarioMail(String mail);

  public List<String> getSeguidores(String nombreUsuario);

  public List<String> getSeguidos(String nombreUsuario);

  public boolean isSeguidor(String seguidor, String seguido);

  public void dejarSeguir(String seguidor, String seguido);

  public void modificarUsuario(DtUsuario usuarioModificado, DtUsuario usuarioOriginal)
      throws DuplicateClassException;
}
