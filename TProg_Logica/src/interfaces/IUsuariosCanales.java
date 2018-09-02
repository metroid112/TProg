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
import dataTypes.DtUsuario;
import clases.Comentario;

public interface IUsuariosCanales {
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, BufferedImage imagen, String nombreCanal, String descripcionCanal, boolean visible) throws IOException;
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String path, String nombreCanal, String descripcionCanal, boolean visible) throws IOException;
  
	public String[] listarUsuarios();
	
	public String[] listarSeguidos(String nick);
	
	public String[] listarSeguidores(String nick) ;
	
	public String[] listarVideos(String nick);
	
	public String[] listarListasDeReproduccion(String nick);
	
	public boolean existeUsuario(String nick);
	
	public DtUsuario getDt(String nick);
	
	public boolean isEmailUnique(String email);
	
	public boolean isCanalPublico(String usuario);
	
	public String[] listarVideosLista(String usuario,String lista,boolean defecto);
	
	public void seguir(String seguidor, String seguido);
}
