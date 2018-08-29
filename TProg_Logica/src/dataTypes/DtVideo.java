package dataTypes;

import java.time.Duration;
import java.util.Date;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import clases.Categoria;
import clases.Comentario;


public class DtVideo {
	private String nombre, URL, descripcion, categoria;
	private Date fecha;
	private Duration duracion;
	private boolean visible;

	private LinkedHashMap<Integer, DtComentario> comentarios = new LinkedHashMap<Integer, DtComentario>();
	
	public DtVideo(String nombre, String descripcion, String url, Categoria categoria, Date fecha, Duration duracion,
			boolean visibile, LinkedHashMap<Integer, Comentario> comentarios) {

		this.nombre = nombre;
		this.URL = url;
		this.descripcion = descripcion;
		this.categoria = categoria.getNombre();
		this.duracion = duracion;
		this.fecha = fecha;

		for (Comentario com : comentarios.values()) {
			DtComentario dtCom = com.getDT();		// Creo Dt
			this.comentarios.put(dtCom.getId(), dtCom); 		// Lo agrego a la coleccion
		}
		

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

	
	public LinkedHashMap<Integer, DtComentario> getComents() {
		return this.comentarios;
	}


}
