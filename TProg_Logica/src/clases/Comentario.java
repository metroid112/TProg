package clases;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;


public class Comentario {

	private String texto;
	private Date fecha;
	private Usuario usuario;
	private Video video;
	private Comentario padre;
	private LinkedHashMap<Integer,Comentario> respuestas = new LinkedHashMap<Integer, Comentario>();
	private int id;	// id de comentario para uso interno
	private static int idCounter = 0;

	public Comentario() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Comentario(String texto, Usuario usuario, Video video, Comentario padre) {

		this.texto = texto;
		this.usuario = usuario;
		this.video = video;
		this.padre = padre;
		this.fecha = new Date();
		this.id = Comentario.idCounter;
		Comentario.idCounter++;
	}
	
	public Comentario(String texto, Usuario usuario, Video video, Comentario padre, Date fecha) {

		this.texto = texto;
		this.usuario = usuario;
		this.video = video;
		this.padre = padre;
		this.fecha = fecha;
		this.id = Comentario.idCounter;
		Comentario.idCounter++;
	}

	public String getTexto() {
		return texto;
	}

	public Date getFecha() {
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

	public void setFecha(Date fecha) {
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
