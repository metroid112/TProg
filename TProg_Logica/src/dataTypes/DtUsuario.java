package dataTypes;

import java.awt.image.BufferedImage;
import java.util.Date;

public class DtUsuario {

	public Date fechaNacimiento;
	public BufferedImage imagen;
	public String nombre, apellido, canal, correo, descripcionCanal;
	public boolean privado;

	public DtUsuario(String nombre, String apellido, String canal, String correo, String descripcionCanal,
			Date fechaNacimiento, BufferedImage imagen, boolean privado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.canal = canal;
		this.correo = correo;
		this.descripcionCanal = descripcionCanal;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = imagen;
		this.privado = privado;
	}
}