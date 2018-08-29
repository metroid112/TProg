package controladores;

import java.time.Duration;
import java.util.Date;

import clases.*;
import dataTypes.DtVideo;
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

	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, 
			String url, String catString, Date fecha) {
		Categoria categoria = null;
		if (catString != null) {
			categoria = mCat.get(catString);
		}
		mUsu.get(nick).getCanal().altaVideo(nombre, descripcion, duracion, url, categoria, fecha);
	}
	
	public String[] listarVideos(String nick) {
		Usuario usuario = mUsu.get(nick);
		if (usuario != null) {
			return usuario.getCanal().getArrayVideos();
		} else {
			return null;
		}
	}

	@Override
	public DtVideo getDtVideo(String video, String usuario) {
		Video vid = mUsu.get(usuario).getCanal().getVideoCanal(video);
		return vid.getDT();
	}
}
