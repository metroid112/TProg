import java.awt.Image;

public class Usuario {

	private String nick;
	private String nombre;
	private String apellido;
	private String correo;
	private DtTiempo nacimiento;
	private Image imagen;

	private Canal canal;
	private Comentario[] comentarios;
	private Calificacion[] calificaciones;
	private Usuario[] seguidores;
	private Usuario[] seguidos;

	public Usuario() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Usuario(String nick, String nombre, String apellido, String correo, DtTiempo nacimiento, Image imagen,
			Canal canal, Comentario[] comentarios, Calificacion[] calificaciones, Usuario[] seguidores,
			Usuario[] seguidos) {
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.nacimiento = nacimiento;
		this.imagen = imagen;
		this.canal = canal;
		this.comentarios = comentarios;
		this.calificaciones = calificaciones;
		this.seguidores = seguidores;
		this.seguidos = seguidos;
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

	public DtTiempo getNacimiento() {
		return nacimiento;
	}

	public Image getImagen() {
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

	public Usuario[] getSeguidores() {
		return seguidores;
	}

	public Usuario[] getSeguidos() {
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

	public void setNacimiento(DtTiempo nacimiento) {
		this.nacimiento = nacimiento;
	}

	public void setImagen(Image imagen) {
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

	public void setSeguidores(Usuario[] seguidores) {
		this.seguidores = seguidores;
	}

	public void setSeguidos(Usuario[] seguidos) {
		this.seguidos = seguidos;
	}
}
