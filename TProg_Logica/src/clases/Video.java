package clases;


import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import dataTypes.DtVideo;


public class Video {

	private String nombre;
	private String descripcion;
	private Duration duracion;
	private String url;
	private boolean visible;
	private Date fecha;
	private Categoria categoria;
	private Canal canal;
	private LinkedList<Calificacion> calificaciones = new LinkedList<Calificacion>();
	private LinkedHashMap<Integer,Comentario> comentarios = new LinkedHashMap<Integer, Comentario>();
	// LinkedHashMap mantiene el orden a diferencia del HashMap

	public Video(String nombre, String descripcion, Duration duracion, String url, Categoria categoria, Canal canal, Date fecha) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.fecha = fecha;		// Chequear fecha?
		this.url = url;
		this.visible = false;		// Arranca privado
		this.categoria = categoria;
		this.canal = canal;
		if (this.categoria != null) {
			categoria.addVideo(this);
		}
		
	}

	public Video(String nombre, String descripcion, Duration duracion, String url, Categoria categoria, Date fecha,
			boolean visible, Canal canal) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.url = url;
		this.categoria = categoria;
		this.fecha = fecha;
		this.visible = visible;
		this.canal = canal;
	}

	public DtVideo getDT() {

		return new DtVideo(this.nombre, this.descripcion, this.url, this.categoria, this.fecha, this.duracion,
				this.visible, this.comentarios);

	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getUrl() {
		return url;
	}

	public boolean isVisible() {
		return visible;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Canal getCanal() {
		return canal;
	}

	public LinkedList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public LinkedHashMap<Integer,Comentario> getComentarios() {
		return comentarios;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}
	
	public void setDuracion(int hora, int minuto, int segundo) {
		this.duracion = Duration.ofHours(hora);
		this.duracion = duracion.plusMinutes(minuto);
		this.duracion = duracion.plusSeconds(segundo);
		
				
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public void setCalificaciones(LinkedList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void modificarDatos(String nombre, String descripcion, String url, Categoria categoria,
			Duration duracion, Boolean visible, Date fecha) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.categoria = categoria;
		this.duracion = duracion;
		this.visible = visible;
		this.fecha = fecha;
	}

}
