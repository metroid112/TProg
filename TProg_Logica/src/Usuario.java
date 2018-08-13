import java.awt.Image;

public class Usuario {

	private String nick;
	private String nombre;
	private String apellido;
	private String correo;
	private DtTiempo nacimiento;
	private Image imagen;
	
	public Usuario(String nick, String nombre, String apellido, String correo, DtTiempo nacimiento, Image imagen) {
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.nacimiento = nacimiento;
		this.imagen = imagen;
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
}
