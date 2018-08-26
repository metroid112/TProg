package controladores;

import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

import java.awt.Image;
import java.util.Date;

import clases.Calificacion;
import clases.Canal;
import clases.Comentario;
import clases.Usuario;

public class CtrlUsuariosCanales implements IUsuariosCanales {


	public CtrlUsuariosCanales() {
		
	}
	
	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	
	public void altaUsuario(String nick, String nombre, String apellido, String correo, Date nacimiento, Image imagen, 
			String nombreCanal, boolean privado, String descripcion, Comentario[] comentarios, Calificacion[] calificaciones, Usuario[] seguidores,
			Usuario[] seguidos) throws Exception {
		
			Canal canal = new Canal(nombreCanal, descripcion, privado, null, null,
					null, null, null);
			
			Usuario usu = new Usuario(nick, nombre, apellido, correo, nacimiento, imagen,
					canal, comentarios, calificaciones, seguidores,
					seguidos);
			canal.setUsuario(usu);
			manejadorUsuarios.add(usu);
	};
	
	public String[] listarUsuarios() {
		
		return manejadorUsuarios.toArray();
	
	}
	
	public boolean existeUsuario(String nick) {
		return manejadorUsuarios.isMemberKey(nick);
	}
	
	public Integer cantidadUsuarios() {
		return manejadorUsuarios.size();
	}

}
