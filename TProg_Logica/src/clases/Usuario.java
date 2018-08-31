package clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.util.Date;
import java.util.HashSet;

public class Usuario {

	private String nick;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNacimiento;
	private BufferedImage imagen;
	private Canal canal;
	private Comentario[] comentarios;
	private Calificacion[] calificaciones;
	private HashSet<Usuario> seguidores = new HashSet<Usuario>();
	private HashSet<Usuario> seguidos = new HashSet<Usuario>();

	public Usuario() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Usuario(String nick, String nombre, String apellido, String correo, Date nacimiento, BufferedImage imagen,
			Canal canal, Comentario[] comentarios, Calificacion[] calificaciones, HashSet<Usuario> seguidores,
			HashSet<Usuario> seguidos) {
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = nacimiento;
		this.imagen = imagen;
		this.canal = canal;
		if (comentarios != null) {
			this.comentarios = comentarios;
		}
		else {
			this.comentarios = new Comentario[0];
		}
		if (calificaciones != null) {
			this.calificaciones = calificaciones;
		}
		else {
			this.calificaciones = new Calificacion[0];
		}		
		this.seguidores = seguidores;
		this.seguidos = seguidos;
}

	public Usuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento) {
		this.nick = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento,
			BufferedImage image, Canal canal) {
		this.nick = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = image;
		this.canal = canal;
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

	public Comentario[] getComentarios() {
		return comentarios;
	}

	public Calificacion[] getCalificaciones() {
		return calificaciones;
	}

	public HashSet<Usuario> getSeguidores() {
		return seguidores;
	}

	public HashSet<Usuario> getSeguidos() {
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

	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}

	public void setCalificaciones(Calificacion[] calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void setSeguidores(HashSet<Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	public void setSeguidos(HashSet<Usuario> seguidos) {
		this.seguidos = seguidos;
	}
	
	public void seguir(Usuario seguido) {
		this.seguidos.add(seguido);
	}
	
}
