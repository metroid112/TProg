package controladores;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import clases.Calificacion;
import clases.Canal;
import clases.Comentario;
import clases.ListaDefecto;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import dataTypes.DtUsuario;
import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

public class CtrlUsuariosCanales implements IUsuariosCanales {

	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();

	public CtrlUsuariosCanales() {

	}

	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			BufferedImage imagen, String nombreCanal, String descripcionCanal, boolean visible) throws IOException {
		Usuario user = new Usuario(nickname, nombre, apellido, correo, fechaNacimiento, imagen);
		Canal canal = new Canal(nombreCanal, descripcionCanal, visible, user);
		user.setCanal(canal);
		manejadorUsuarios.add(user);
	}

	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			String path, String nombreCanal, String descripcionCanal, boolean visible) throws IOException {
		Usuario user = new Usuario(nickname, nombre, apellido, correo, fechaNacimiento, ImageIO.read(new File(path)));
		Canal canal = new Canal(nombreCanal, descripcionCanal, visible, user);
		user.setCanal(canal);
		manejadorUsuarios.add(user);
	}

	public int cantidadUsuarios() {
		return manejadorUsuarios.size();
	}

	public void comentarVideo(String texto, Date fecha, String nombreUsuario, String nombreVideo,
			String nombreDueñoVideo) {
		Usuario usuario = manejadorUsuarios.get(nombreUsuario);
		Usuario dueño = manejadorUsuarios.get(nombreDueñoVideo);
		Video vid = dueño.getCanal().getVideoCanal(nombreVideo);
		usuario.comentar(texto, fecha, vid);
	}

	@Override
	public boolean existeUsuario(String nick) {
		return manejadorUsuarios.isMemberKey(nick);
	}

	public String getApellido(String nick) {
		return manejadorUsuarios.get(nick).getApellido();
	}

	public LinkedList<Calificacion> getCalificaciones(String nick) {
		return manejadorUsuarios.get(nick).getCalificaciones();
	}

	public Canal getCanal(String nick) {
		return manejadorUsuarios.get(nick).getCanal();
	}

	public LinkedList<Comentario> getComentarios(String nick) {
		return manejadorUsuarios.get(nick).getComentarios();
	}

	// getters de datos de ususario.

	public String getCorreo(String nick) {
		return manejadorUsuarios.get(nick).getCorreo();
	}

	public String getDescripcionCanal(String nick) {
		return manejadorUsuarios.get(nick).getCanal().getDescripcion();
	}
	// Fin getters usuario.

	@Override
	public DtUsuario getDt(String nick) {
		return manejadorUsuarios.get(nick).getDt();
	}

	public Image getImagen(String nick) {
		return manejadorUsuarios.get(nick).getImagen();
	}

	public Date getNacimiento(String nick) {
		return manejadorUsuarios.get(nick).getNacimiento(); // implementar este.
	}

	public String getNombre(String nick) {
		return manejadorUsuarios.get(nick).getNombre();
	}

	public String getNombreCanal(String nick) {
		return manejadorUsuarios.get(nick).getCanal().getNombre();
	}

	public boolean getPrivado(String nick) {
		return !manejadorUsuarios.get(nick).getCanal().isVisible();
	}

	public HashMap<String, Usuario> getSeguidores(String nick) {
		return manejadorUsuarios.get(nick).getSeguidores();
	}

	public HashMap<String, Usuario> getSeguidos(String nick) {
		return manejadorUsuarios.get(nick).getSeguidos();
	}

	@Override
	public boolean isCanalPublico(String usuario) {
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		return usuarioObjetivo.getCanal().isVisible();
	}

	@Override
	public boolean isEmailUnique(String email) {
		return manejadorUsuarios.isEmailUnique(email);
	}

	@Override
	public String[] listarListasDeReproduccion(String nick) {
		HashMap<String, ListaDefecto> listasDefecto = manejadorUsuarios.get(nick).getCanal().getListaDefecto();
		String[] listaDefecto = listasDefecto.keySet().toArray(new String[listasDefecto.size()]);
		HashMap<String, ListaParticular> ListasParticular = manejadorUsuarios.get(nick).getCanal()
				.getListaParticulares();
		String[] listaParticulares = ListasParticular.keySet().toArray(new String[ListasParticular.size()]);
		int largo = listaDefecto.length + listaParticulares.length + 1;
		String[] res = new String[largo];
		for (int i = 0; i < listaDefecto.length; i++) {
			res[i] = listaDefecto[i];
		}
		for (int i = listaDefecto.length + 1; i < largo; i++) {
			res[i] = listaParticulares[i];
		}
		return null;
	}

	@Override
	public String[] listarSeguidores(String nick) {
		return manejadorUsuarios.get(nick).getSeguidores().keySet()
				.toArray(new String[manejadorUsuarios.get(nick).getSeguidores().size()]);
	}

	@Override
	public String[] listarSeguidos(String nick) {
		return manejadorUsuarios.get(nick).getSeguidos().keySet()
				.toArray(new String[manejadorUsuarios.get(nick).getSeguidos().size()]);
	}

	@Override
	public String[] listarUsuarios() {
		return manejadorUsuarios.toArray();
	}

	@Override
	public String[] listarVideos(String nick) {
		HashMap<String, Video> videos = manejadorUsuarios.get(nick).getCanal().getVideos();
		String[] res = videos.keySet().toArray(new String[videos.size()]);
		return res;
	}

	@Override
	public String[] listarVideosLista(String usuario, String lista, boolean defecto) {
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		return usuarioObjetivo.getCanal().listarVideosLista(lista, defecto);
	}

	public void modificarValoracion(boolean like, String nombreUsuario, String nombreVideo, String nombreDueñoVideo) {
		Usuario usuario = manejadorUsuarios.get(nombreUsuario);
		Usuario dueño = manejadorUsuarios.get(nombreDueñoVideo);
		Video vid = dueño.getCanal().getVideoCanal(nombreVideo);
		usuario.modificarValoracion(like, vid);
	}

	public void responderComentario(String texto, Date fecha, String nombreUsuario, String nombreVideo,
			String nombreDueñoVideo, Integer idComentarioPadre) {
		Usuario usuario = manejadorUsuarios.get(nombreUsuario);
		Usuario dueño = manejadorUsuarios.get(nombreDueñoVideo);
		Video vid = dueño.getCanal().getVideoCanal(nombreVideo);
		usuario.responder(texto, fecha, idComentarioPadre, vid);
	}

	@Override
	public void seguir(String seguidor, String seguido) {
		manejadorUsuarios.get(seguidor).seguir(manejadorUsuarios.get(seguido));
	}

	public void valorarVideo(String nombreUsuario, boolean like, String nombreVideo, String nombreDueñoVideo)
			throws Exception {
		Usuario usuario = manejadorUsuarios.get(nombreUsuario);
		Usuario dueño = manejadorUsuarios.get(nombreDueñoVideo); // Puede calificar su propio video?
		Video vid = dueño.getCanal().getVideoCanal(nombreVideo);
		usuario.valorarVideo(like, vid);
	}
}
