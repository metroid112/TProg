package clases;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.LinkedHashMap;
>>>>>>> origin/AltaVideo-Fran

public class Comentario {

	private String texto;
	private LocalDate fecha;
<<<<<<< HEAD

=======
>>>>>>> origin/AltaVideo-Fran
	private Usuario usuario;
	private Video video;
	private Comentario padre;
	private LinkedHashMap<Integer,Comentario> respuestas;
	private long id;	// id de comentario para uso interno

	public Comentario() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
<<<<<<< HEAD
	public Comentario(String texto, LocalDate fecha, Usuario usuario, Video video, Comentario padre,
			Comentario[] respuestas) {
=======
	public Comentario(String texto, Usuario usuario, Video video, Comentario padre) {
>>>>>>> origin/AltaVideo-Fran
		this.texto = texto;
		this.fecha = LocalDate.now();
		this.usuario = usuario;
		this.video = video;
		this.padre = padre;
		this.respuestas = null;
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

	public LinkedHashMap<Integer, Comentario> getRespuestas() {
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

	public void setRespuestas(LinkedHashMap<Integer, Comentario> respuestas) {
		this.respuestas = respuestas;
	}
}
