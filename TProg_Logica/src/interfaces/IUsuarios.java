package interfaces;

import java.awt.Image;
import java.util.Date;

import clases.Calificacion;
import clases.Canal;
import clases.Usuario;
import clases.Comentario;

public interface IUsuarios {
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaDeNacimiento, Image imagen, 
			String nombreCanal, boolean privado, String descripcion, Comentario[] comentarios, Calificacion[] calificaciones, Usuario[] seguidores,
			Usuario[] seguidos) throws Exception;
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String nombreCanal, boolean visible);
  
	public String[] listarUsuarios();
	
	public String[] listarSeguidos();
	
	public String[] listarSeguidores() ;
	
	public String[] listarVideos(String nick);
	
	public String[] listarListasDeReproduccion(String nick);
	
	public boolean existeUsuario(String nick);
	
	public int cantidadUsuarios();
	//getters de datos de ususario.
	public String getNombre(String nick);

	public String getApellido(String nick);

	public String getCorreo(String nick);

	public Date getNacimiento(String nick);

	public Image getImagen(String nick);

	public Canal getCanal(String nick);
	
	public String getNombreCanal(String nick);

	public Comentario[] getComentarios(String nick);

	public Calificacion[] getCalificaciones(String nick);

	public Usuario[] getSeguidores(String nick);

	public Usuario[] getSeguidos(String nick);
	
	public boolean getPrivado(String nick);
	
	public String getDescripcionCanal(String nick);
	
	public boolean isEmailUnique(String email);
	
	//fin getters usuarios.
	
}
