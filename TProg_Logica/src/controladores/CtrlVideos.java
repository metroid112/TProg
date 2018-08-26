package controladores;

import java.time.Duration;
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

	@Override
	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url, String catString) {
		Categoria categoria = mCat.get(catString);
		mUsu.get(nick).getCanal().altaVideo(nombre, descripcion, duracion, url, categoria);		// TODO canal altaVideo()
	}
}
