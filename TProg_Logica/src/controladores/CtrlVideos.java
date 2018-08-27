package controladores;

import java.time.Duration;
import java.util.Date;

import clases.*;
import interfaces.IVideos;

import manejadores.*;

public class CtrlVideos implements IVideos {
	private ManejadorCategorias mCat = ManejadorCategorias.getManejadorCategorias();
	private ManejadorUsuarios mUsu = ManejadorUsuarios.getManejadorUsuarios();
	
	public CtrlVideos() {
		
	}
	
	public String[] listarUsuarios() {
		return mUsu.toArray();
	}
	
	public String[] listarCategorias() {
		return mCat.toArray(); 
	}

	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url, String catString, Date fecha) {
		Categoria categoria = mCat.get(catString);
		mUsu.get(nick).getCanal().altaVideo(nombre, descripcion, duracion, url, categoria, fecha);
	}
	
	public String[] listarVideos(String nick) {
		Usuario usuario = mUsu.get(nick);
		return usuario.getCanal().getArrayVideos();		// TODO agregar funcion al canal
	}
}
