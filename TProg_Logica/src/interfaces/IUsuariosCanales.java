package interfaces;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import dataTypes.DtUsuario;

public interface IUsuariosCanales {
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			BufferedImage imagen, String nombreCanal, String descripcionCanal, String categoria, boolean visible) throws IOException;

	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			String path, String nombreCanal, String descripcionCanal, String categoria, boolean visible) throws IOException;

	public boolean existeUsuario(String nick);

	public DtUsuario getDt(String nick);

	public boolean isCanalPublico(String usuario);

	public boolean isEmailUnique(String email);

	public String[] listarListasDeReproduccion(String nick);

	public String[] listarSeguidores(String nick);

	public String[] listarSeguidos(String nick);

	public String[] listarUsuarios();

	public String[] listarVideos(String nick);

	public String[] listarVideosLista(String usuario, String lista, boolean defecto);

	public void seguir(String seguidor, String seguido);

	void valorarVideo(String nombreUsuario, boolean like, String nombreVideo, String nombreDuenioVideo) throws Exception;

	void modificarValoracion(boolean like, String nombreUsuario, String nombreVideo, String nombreDuenioVideo);

	void comentarVideo(String texto, Date fecha, String nombreUsuario, String nombreVideo, String nombreDuenioVideo);

	void responderComentario(String texto, Date fecha, String nombreUsuario, String nombreVideo,
			String nombreDuenioVideo, Integer idComentarioPadre);

	public String[] listarVideosDuenosLista(String usuario, String lista, boolean defecto);
}
