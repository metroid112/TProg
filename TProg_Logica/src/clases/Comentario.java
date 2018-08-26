package clases;

import java.time.LocalDate;

public class Comentario {

	private String texto;
	private LocalDate fecha;

	private Usuario usuario;
	private Video video;
	private Comentario padre;
	private Comentario[] respuestas;

	public Comentario() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Comentario(String texto, LocalDate fecha, Usuario usuario, Video video, Comentario padre,
			Comentario[] respuestas) {
		this.texto = texto;
		this.fecha = fecha;
		this.usuario = usuario;
		this.video = video;
		this.padre = padre;
		this.respuestas = respuestas;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Video getVideo() {
		return video;
	}

	public Comentario getPadre() {
		return padre;
	}

	public Comentario[] getRespuestas() {
		return respuestas;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public void setPadre(Comentario padre) {
		this.padre = padre;
	}

	public void setRespuestas(Comentario[] respuestas) {
		this.respuestas = respuestas;
	}
}
