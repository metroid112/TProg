package clases;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;

import dataTypes.DtComentario;


public class Comentario {

	private String texto;
	private Date fecha;
	private Usuario usuario;
	private Video video;
	private Comentario padre;
	private LinkedHashMap<Integer,Comentario> respuestas = new LinkedHashMap<Integer, Comentario>();
	private int id;	// id de comentario para uso interno
	private static int idCounter = 0;

	/**
	 * comentario respuesta sin fecha
	 */
	public Comentario(String texto, Usuario usuario, Video video, Comentario padre) {
		this.texto = texto;
		this.usuario = usuario;
		this.video = video;
		this.padre = padre;
		this.fecha = new Date();
		this.id = Comentario.idCounter;
		Comentario.idCounter++;
		padre.addHijo(this);
	}
	/**
	 * comentario respuesta con fecha
	 */
	public Comentario(String texto, Usuario usuario, Video video, Comentario padre, Date fecha) {

		this.texto = texto;
		this.usuario = usuario;
		this.video = video;
		this.padre = padre;
		this.fecha = fecha;
		this.id = Comentario.idCounter;
		Comentario.idCounter++;
		padre.addHijo(this);
	}
	
	/**
	 * comentario padre
	 */
	public Comentario(String texto, Usuario usuario, Video video, Date fecha) {
		this.texto = texto;
		this.usuario = usuario;
		this.video = video;
		this.fecha = fecha;
		this.padre = null;
		this.id = Comentario.idCounter;
		Comentario.idCounter++;
	}
	
	/**
	 * comentario padre sin fecha
	 */
	public Comentario(String texto, Usuario usuario, Video video) {
		this.texto = texto;
		this.usuario = usuario;
		this.video = video;
		this.fecha = new Date();
		this.padre = null;
		this.id = Comentario.idCounter;
		Comentario.idCounter++;
	}
	
	public void addHijo(Comentario hijo) {
		this.respuestas.put(hijo.getID(), hijo);
	}
	
	public Integer getID() {
		return this.id;
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
	
	public boolean tieneRespuestas() {
		return !(this.respuestas.isEmpty());
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
	
	public DtComentario getDT() {
		return new DtComentario(this);
	}
	public Comentario getCom(Integer idComentario) {
		if (this.id == idComentario) {
			return this;
		} else if (!this.respuestas.isEmpty()) {
			Comentario encontrado = null;
			for (Comentario hijo : this.respuestas.values()) {
				Comentario retornado = hijo.getCom(idComentario);
				if (retornado != null) {
					encontrado = retornado;
				}
			}
			return encontrado;
		} else return null;
	}
}
