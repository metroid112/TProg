package clases;

import java.time.LocalDate;
import java.time.Duration;

public class Video {

	private String nombre;
	private String descripcion;
	private Duration duracion;
	private String url;
	private boolean visible;
	private LocalDate fecha = LocalDate.now();	/* Funciona esto? */
	private Categoria categoria;
	private Lista[] listas;		//array?
	private Canal canal;
	private Calificacion[] calificaciones;		// array?
	private Comentario[] comentarios;		// array?

	public Video() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Video(String nombre, String descripcion, Duration duracion, String url, 
			Categoria categoria, Lista[] listas, Canal canal, Calificacion[] calificaciones, Comentario[] comentarios) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		// this.fecha = LocalDate.now();		DEJO COMENTADO PARA PROBAR
		this.url = url;
		this.visible = false;		// Arranca privado
		this.categoria = categoria;
		this.listas = listas;
		this.canal = canal;
		this.calificaciones = calificaciones;
		this.comentarios = comentarios;
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

	public LocalDate getFecha() {
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

	public Lista[] getListas() {
		return listas;
	}

	public Canal getCanal() {
		return canal;
	}

	public Calificacion[] getCalificaciones() {
		return calificaciones;
	}

	public Comentario[] getComentarios() {
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

	public void setFecha(LocalDate fecha) {
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

	public void setListas(Lista[] listas) {
		this.listas = listas;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public void setCalificaciones(Calificacion[] calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}
}
