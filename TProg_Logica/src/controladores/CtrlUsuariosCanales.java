package controladores;

import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

import java.awt.Image;
import java.util.Date;
import java.util.HashMap;

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
	public void altaUsuario(String nick, String nombre, String apellido, String correo, Date nacimiento, Image imagen, 
			String nombreCanal, boolean privado, String descripcion, Comentario[] comentarios, Calificacion[] calificaciones, Usuario[] seguidores,
			Usuario[] seguidos) throws Exception {
		
			Canal canal = new Canal(nombreCanal, descripcion, privado, null, new HashMap<String, Video>(),
					new HashMap<String, ListaDefecto>(), new HashMap<String, ListaParticular>(), null);
			
			Usuario usu = new Usuario(nick, nombre, apellido, correo, nacimiento, imagen,
					canal, comentarios, calificaciones, seguidores,
					seguidos);
			canal.setUsuario(usu);
			manejadorUsuarios.add(usu);
	}

	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			String nombreCanal, boolean visible) {
		Usuario user = new Usuario(nickname, nombre, apellido, correo, fechaNacimiento);
		Canal canal = new Canal(nombreCanal, visible, user);
		user.setCanal(canal);
		manejadorUsuarios.add(user);
	};
	
	public String[] listarUsuarios() {
		return manejadorUsuarios.toArray();
	}
	
	public String[] listarVideos(String nick) {
		//String[] res = usuarios.keySet().toArray(new String[usuarios.size()]);
		Video[] videos = manejadorUsuarios.get(nick).getCanal().getVideos();
		String[] res = new String[videos.length];
		int largo = videos.length;
		for (int i = 0; i < largo; i++ ){
			res[i]=videos[i].getNombre();
		}
		return res;
	}
	
	public String[] listarListasDeReproduccion(String nick) {
		ListaDefecto[] listaDefecto = (ListaDefecto[]) manejadorUsuarios.get(nick).getCanal().getListaDefecto();
		ListaParticular[] listaParticulares = (ListaParticular[]) manejadorUsuarios.get(nick).getCanal().getListaParticulares();
		int largo = listaDefecto.length + listaParticulares.length + 1;
		String[] res = new String[largo];
		for (int i = 0; i < listaDefecto.length; i++ ){
			res[i]=listaDefecto[i].getNombre();
		}
		for (int i = listaDefecto.length + 1; i < largo; i++ ){
			res[i]=listaParticulares[i].getNombre();
		}
		return res;
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

	public Usuario[] getSeguidores(String nick) {
		return manejadorUsuarios.get(nick).getSeguidores();
	}

	public Usuario[] getSeguidos(String nick) {
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
=======


