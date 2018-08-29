package dataTypes;

import java.time.Duration;
import java.util.Date;

import clases.Categoria;

public class DtVideo {
	private String nombre, URL, descripcion, categoria;
	private Date fecha;
	private Duration duracion;
	private boolean visible;
	// TODO comentarios
	
	public DtVideo(String nombre, String descripcion, String url, Categoria categoria, Date fecha, Duration duracion, boolean visibile) {
		this.nombre = nombre;
		this.URL = url;
		this.descripcion = descripcion;
		this.categoria = categoria.getNombre();
		this.duracion = duracion;
		this.fecha = fecha;
		// comentarios
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getURL() {
		return URL;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public boolean isVisible() {
		return visible;
	}

}
