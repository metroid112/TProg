package interfaces;

import java.awt.Image;
import java.util.Date;

import clases.Calificacion;
import clases.Usuario;
import clases.Comentario;

public interface IUsuariosCanales {
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaDeNacimiento, Image imagen, 
			String nombreCanal, boolean privado, String descripcion, Comentario[] comentarios, Calificacion[] calificaciones, Usuario[] seguidores,
			Usuario[] seguidos) throws Exception;
}
