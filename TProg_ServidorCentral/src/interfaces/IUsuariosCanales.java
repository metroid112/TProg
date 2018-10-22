package interfaces;

import java.util.Date;
import java.util.List;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.NotFoundException;

public interface IUsuariosCanales {

  public void altaUsuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String imagenPath, String nombreCanal, String descripcionCanal,
      String categoria, boolean visible, String pass) throws NotFoundException;

  public boolean existeUsuario(int nick);

  public DtUsuario getDt(int nick);

  public boolean isCanalPublico(String usuario);

  public List<String> listarNombresUsuarios();

  public void seguir(String seguidor, String seguido) throws NotFoundException;

  void valorarVideo(String nombreUsuario, boolean like, String nombreVideo,
      String nombreDuenoVideo);

  public boolean yaCalificacdo(int nombreUsuario, boolean like, int nombreVideo,
      int nombreDuenoVideo) throws NotFoundException;

  void modificarValoracion(boolean like, int idUsuario, int nombreVideo,
      int idDuenoVideo) throws NotFoundException;

  void comentarVideo(String texto, Date fecha, int nombreUsuario, String nombreVideo,
      String nombreDuenoVideo) throws NotFoundException;

  void responderComentario(String texto, Date fecha, int nombreUsuario, int nombreVideo,
      String nombreDuenoVideo, Integer idComentarioPadre)throws NotFoundException;

  public String[] listarVideosDuenosLista(int usuario, String lista, boolean defecto) throws NotFoundException;

  public List<DtVideo> listarDtVideosDuenosLista(int usuario, String lista, boolean defecto) throws NotFoundException;

  public List<DtVideo> getListaDtVideo(String usuario);

  public List<DtVideo> getListaPublicoDtVideo();

  public boolean checkLogin(String usr, String pass);

  public boolean existeUsuarioMail(String mail);

  public List<String> getSeguidores(int idUsuario) throws NotFoundException;

  public List<String> getSeguidos(int idUsuario) throws NotFoundException;

  public boolean isSeguidor(int seguidor, int seguido) throws NotFoundException;

  public void dejarSeguir(int idSeguidor, int idSeguido) throws NotFoundException;

  public void modificarUsuario(DtUsuario usuarioModificado, DtUsuario usuarioOriginal);
}
