package controladores;

import java.time.Duration;
import java.util.Date;

import clases.Categoria;
import clases.Usuario;
import clases.Video;
import dataTypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlVideos implements IVideos {
	private ManejadorCategorias mCat = ManejadorCategorias.getManejadorCategorias();
	private ManejadorUsuarios mUsu = ManejadorUsuarios.getManejadorUsuarios();

	public CtrlVideos() {

	}

	@Override
	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String catString, Date fecha) throws DuplicateClassException {
		Categoria categoria = null;
		if (catString != null) {
			categoria = mCat.get(catString);
		}
		mUsu.get(nick).getCanal().altaVideo(nombre, descripcion, duracion, url, categoria, fecha);
	}

	@Override
	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String categoria, Date fecha, boolean visible) {
		Categoria category = mCat.get(categoria);
		Video video = mUsu.get(nick).getCanal().altaVideo(nombre, descripcion, duracion, url, category, fecha, visible);
		category.addVideo(video);
	}

	@Override
	public DtVideo getDtVideo(String video, String usuario) {

		Video vid = mUsu.get(usuario).getCanal().getVideoCanal(video);
		return vid.getDT();

	}

	@Override
	public String[] listarCategorias() {
		return mCat.toArray();
	}

	@Override
	public String[] listarUsuarios() {
		return mUsu.toArray();
	}

	@Override
	public String[] listarVideos(String nick) {
		Usuario usuario = mUsu.get(nick);
		if (usuario != null) {
			return usuario.getCanal().getArrayVideos();
		} else {
			return null;
		}
	}

	@Override
	public void modificarVideo(String nick, String nombreOld, String nombre, String descripcion, String url,
			String categoriaString, Duration duracion, Boolean visible, Date fecha) throws InvalidDataException {
		Video vid = mUsu.get(nick).getCanal().getVideoCanal(nombreOld);
		vid.getCanal().modVideo(nombreOld, nombre);
		Categoria categoria;
		if (categoriaString != null) {
			categoria = mCat.get(categoriaString);
		} else {
			categoria = null;
		}
		vid.modificarDatos(nombre, descripcion, url, categoria, duracion, visible, fecha);

	}
}
