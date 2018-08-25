package controladores;

import java.time.Duration;

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

	@Override
	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String categoria) {
		/*
		 * TODO alta video
		 */
		
	}
}
