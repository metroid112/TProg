package dataTypes;

import java.time.Duration;
import java.util.Date;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import clases.Calificacion;
import clases.Categoria;
import clases.Comentario;


public class DtVideo {
	public String nombre, URL, descripcion, categoria;
	public Date fecha;
	public Duration duracion;
	public boolean visible;

	public LinkedHashMap<Integer, DtComentario> comentarios = new LinkedHashMap<Integer, DtComentario>();
	public LinkedList<DtCalificacion> calificaciones = new LinkedList<DtCalificacion>();
	
	public DtVideo(String nombre, String descripcion, String url, Categoria categoria, Date fecha, Duration duracion,
			boolean visible, LinkedHashMap<Integer, Comentario> comentarios, LinkedList<Calificacion> calificaciones) {

		this.nombre = nombre;
		this.URL = url;
		this.descripcion = descripcion;
		if (categoria != null) {
			this.categoria = categoria.getNombre();
		} else {
			this.categoria = "Sin Categoria";
		}
		this.duracion = duracion;
		this.fecha = fecha;

		for (Comentario com : comentarios.values()) {
			DtComentario dtCom = com.getDT();		// Creo Dt
			this.comentarios.put(dtCom.id, dtCom); 		// Lo agrego a la coleccion
		}
		this.visible = visible;
		for (Calificacion cal : calificaciones) {
			this.calificaciones.add(cal.getDt());
		}
		

	}

}
