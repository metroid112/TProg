package interfaces;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import dataTypes.DtUsuario;

public interface IUsuariosCanales {

	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			BufferedImage imagen, String nombreCanal, String descripcionCanal, boolean visible) throws IOException;

	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			String path, String nombreCanal, String descripcionCanal, boolean visible) throws IOException;

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
}
