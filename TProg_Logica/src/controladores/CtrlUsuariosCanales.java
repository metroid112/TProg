package controladores;

import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

import java.awt.Image;
import java.util.Date;

import clases.Calificacion;
import clases.Canal;
import clases.Categoria;
import clases.Comentario;
import clases.ListaDefecto;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;

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

}
