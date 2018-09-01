package controladores;

import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import javax.imageio.ImageIO;

import clases.Calificacion;
import clases.Canal;
import clases.Comentario;
import clases.ListaDefecto;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;

public class CtrlUsuariosCanales implements IUsuariosCanales {


	public CtrlUsuariosCanales() {
		
	}
	
	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	
	@Override
	public void altaUsuario(String nick, String nombre, String apellido, String correo, Date nacimiento, BufferedImage imagen, 
			String nombreCanal, boolean privado, String descripcion, Comentario[] comentarios, Calificacion[] calificaciones, Usuario[] seguidores,
			Usuario[] seguidos) throws Exception {
		
			Canal canal = new Canal(nombreCanal, descripcion, privado, null, new HashMap<String, Video>(),
					new HashMap<String, ListaDefecto>(), new HashMap<String, ListaParticular>(), null);
			
			Usuario usu = new Usuario(nick, nombre, apellido, correo, nacimiento);
			canal.setUsuario(usu);
			usu.setCanal(canal);
			manejadorUsuarios.add(usu);
	}

	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			String nombreCanal, boolean visible) {
		Usuario user = new Usuario(nickname, nombre, apellido, correo, fechaNacimiento);
		Canal canal = new Canal(nombreCanal, visible, user);
		user.setCanal(canal);
		canal.setUsuario(user);
		manejadorUsuarios.add(user);
	};
	
	public String[] listarUsuarios() {
		return manejadorUsuarios.toArray();
	}
	
	public String[] listarSeguidos(String nick) {
		return manejadorUsuarios.get(nick).getSeguidos().keySet().toArray(new String[manejadorUsuarios.get(nick).getSeguidos().size()]);
	}
	
	public String[] listarSeguidores(String nick) {
		return manejadorUsuarios.get(nick).getSeguidores().keySet().toArray(new String[manejadorUsuarios.get(nick).getSeguidores().size()]);
	}
	
	public String[] listarVideos(String nick) {
		HashMap<String, Video> videos = manejadorUsuarios.get(nick).getCanal().getVideos();
		String[] res = videos.keySet().toArray(new String[videos.size()]);
		return res;
	}
	
	public String[] listarListasDeReproduccion(String nick)  {
		HashMap<String, ListaDefecto> listasDefecto = manejadorUsuarios.get(nick).getCanal().getListaDefecto();
		String[] listaDefecto = listasDefecto.keySet().toArray(new String[listasDefecto.size()]);
		HashMap<String, ListaParticular> ListasParticular = manejadorUsuarios.get(nick).getCanal().getListaParticulares();
		String[] listaParticulares = ListasParticular.keySet().toArray(new String[ListasParticular.size()]);
		int largo = listaDefecto.length + listaParticulares.length + 1;
		String[] res = new String[largo];
		for (int i = 0; i < listaDefecto.length; i++ ){
			res[i]=listaDefecto[i];
		}
		for (int i = listaDefecto.length + 1; i < largo; i++ ){
			res[i]=listaParticulares[i];
		}
		return null;
	}
	
	public boolean existeUsuario(String nick) {
		return manejadorUsuarios.isMemberKey(nick);
	}
	
	public int cantidadUsuarios() {
		return manejadorUsuarios.size();
	}

	//getters de datos de ususario.
	
	public String getNombre(String nick) {
		return manejadorUsuarios.get(nick).getNombre();
	}

	public String getApellido(String nick) {
		return manejadorUsuarios.get(nick).getApellido();
	}

	public String getCorreo(String nick) {
		return manejadorUsuarios.get(nick).getCorreo();
	}

	public Date getNacimiento(String nick) {
		return manejadorUsuarios.get(nick).getNacimiento();  //implementar este.
	}

	public Image getImagen(String nick) {
		return manejadorUsuarios.get(nick).getImagen();
	}

	public Canal getCanal(String nick) {
		return manejadorUsuarios.get(nick).getCanal();
	}

	public Comentario[] getComentarios(String nick) {
		return manejadorUsuarios.get(nick).getComentarios();
	}

	public Calificacion[] getCalificaciones(String nick) {
		return manejadorUsuarios.get(nick).getCalificaciones();
	}

	public HashMap<String, Usuario> getSeguidores(String nick) {
		return manejadorUsuarios.get(nick).getSeguidores();
	}

	public HashMap<String, Usuario> getSeguidos(String nick) {
		return manejadorUsuarios.get(nick).getSeguidos();
	}
	
	public boolean getPrivado(String nick) {
		return !manejadorUsuarios.get(nick).getCanal().isVisible();
	}
	
	public String getNombreCanal(String nick) {
		return manejadorUsuarios.get(nick).getCanal().getNombre();
	}
	
	public String getDescripcionCanal(String nick) {
		return manejadorUsuarios.get(nick).getCanal().getDescripcion();
	}
	//Fin getters usuario.

	@Override
	public boolean isEmailUnique(String email) {
		return manejadorUsuarios.isEmailUnique(email);
	}

	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			String path, String nombreCanal, String descripcionCanal, boolean visible) throws IOException {
		manejadorUsuarios.add(new Usuario(nickname, nombre, apellido, correo, fechaNacimiento, ImageIO.read(new File(path)), new Canal(nombreCanal, descripcionCanal, visible)));
	}

	@Override
	public void seguir(String seguidor, String seguido) {
		manejadorUsuarios.get(seguidor).seguir(manejadorUsuarios.get(seguido));
	}
}
