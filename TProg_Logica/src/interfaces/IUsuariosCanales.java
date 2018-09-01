package interfaces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

import clases.Calificacion;
import clases.Canal;
import clases.Usuario;
import clases.Comentario;

public interface IUsuariosCanales {
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaDeNacimiento, BufferedImage imagen, 
			String nombreCanal, boolean privado, String descripcion, Comentario[] comentarios, Calificacion[] calificaciones, Usuario[] seguidores,
			Usuario[] seguidos) throws Exception;
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String nombreCanal, boolean visible);
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String path, String nombreCanal, String descripcionCanal, boolean visible) throws IOException;
  
	public String[] listarUsuarios();
	
	public String[] listarSeguidos(String nick);
	
	public String[] listarSeguidores(String nick) ;
	
	public String[] listarVideos(String nick);
	
	public String[] listarListasDeReproduccion(String nick);
	
	public boolean existeUsuario(String nick);
	
	public int cantidadUsuarios();

	public String getNombre(String nick);

	public String getApellido(String nick);

	public String getCorreo(String nick);

	public Date getNacimiento(String nick);

	public Image getImagen(String nick);
	
	public String getNombreCanal(String nick);

	public boolean getPrivado(String nick);
	
	public String getDescripcionCanal(String nick);
	
	public boolean isEmailUnique(String email);
	
	public boolean isCanalPublico(String usuario);
	
	public void seguir(String seguidor, String seguido);
}
