package clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import dataTypes.DtUsuario;

public class Usuario {

	private String nick;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNacimiento;
	private BufferedImage imagen;
	private Canal canal;
	private LinkedList<Comentario> comentarios = new LinkedList<Comentario>();
	private LinkedList<Calificacion> calificaciones = new LinkedList<Calificacion>();
	private HashMap<String, Usuario> seguidores = new HashMap<String, Usuario>();
	private HashMap<String, Usuario> seguidos = new HashMap<String, Usuario>();

	public Usuario() {
		
	}
	
	public Usuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			BufferedImage image) {
		this.nick = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = image;
	}

	public String getNick() {
		return nick;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public Date getNacimiento() {
		return fechaNacimiento;
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public Canal getCanal() {
		return canal;
	}

	public LinkedList<Comentario> getComentarios() {
		return comentarios;
	}

	public LinkedList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public HashMap<String, Usuario> getSeguidores() {
		return seguidores;
	}

	public HashMap<String, Usuario> getSeguidos() {
		return seguidos;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setNacimiento(Date nacimiento) {
		this.fechaNacimiento = nacimiento;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public void setComentarios(LinkedList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void setCalificaciones(LinkedList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void setSeguidores(HashMap<String, Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	public void setSeguidos(HashMap<String, Usuario> seguidos) {
		this.seguidos = seguidos;
	}
	
	public void seguir(Usuario seguido) {
		this.seguidos.put(seguido.getNick(), seguido);
		seguido.addSeguidor(this);
	}
	
	public void addSeguidor(Usuario seguidor) {
		this.seguidores.put(seguidor.getNick(), seguidor);
	}
	
	public void addCalificacion(Calificacion cal) {
		this.calificaciones.add(cal);
	}

	public void valorarVideo(boolean like, Video vid) throws Exception {
		if (!yaCalificado(vid)) {
			Calificacion cal = new Calificacion(like, this, vid);
			vid.addCalificacion(cal);
			this.addCalificacion(cal);
		} else {
			throw new Exception("Video ya calificado");
		}
	}

	private boolean yaCalificado(Video vid) {
		boolean calificado = false;
		for (Calificacion cal : this.calificaciones) {
			if (cal.getVideo().equals(vid)) {
				calificado = true;
			}
		}
		return calificado;
	}

	public void modificarValoracion(boolean like, Video vid) {
		Calificacion calificacion = null;
		for (Calificacion cal : this.calificaciones) {
			if (cal.getVideo().equals(vid)) {
				calificacion = cal;
			}
		}
		calificacion.setLike(like);
		
	}
	
	/**
	 * Comentario padre
	 */
	public void comentar(String texto, Date fecha, Video vid) {
		Comentario comentario = new Comentario(texto, this, vid, fecha);
		this.comentarios.add(comentario);
		vid.addComentarioPadre(comentario);
	}

	public void responder(String texto, Date fecha, Integer idComentarioPadre, Video vid) {
		Comentario padre = vid.getComentario(idComentarioPadre);
		Comentario comentario = new Comentario(texto, this, vid, padre, fecha);
		this.comentarios.add(comentario);
		
	}
	
	public DtUsuario getDt() {
		return new DtUsuario(this.nombre, this.apellido, this.canal.getNombre(), this.correo, this.canal.getDescripcion(), this.fechaNacimiento, this.imagen, this.canal.isVisible());
	}
	
	
}
