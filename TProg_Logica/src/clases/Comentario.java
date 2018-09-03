package clases;

import java.util.Date;
import java.util.LinkedHashMap;

import dataTypes.DtComentario;

public class Comentario {

	private static int idCounter = 0;
	private Date fecha;
	private int id; // id de comentario para uso interno
	private Comentario padre;
	private LinkedHashMap<Integer, Comentario> respuestas = new LinkedHashMap<Integer, Comentario>();
	private String texto;
	private Usuario usuario;
	private Video video;

	public Comentario() {

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

	public void addHijo(Comentario hijo) {
		this.respuestas.put(hijo.getID(), hijo);
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
		} else
			return null;
	}

	public DtComentario getDT() {
		return new DtComentario(this);
	}

	public Date getFecha() {
		return fecha;
	}

	public Integer getID() {
		return this.id;
	}

	public Comentario getPadre() {
		return padre;
	}

	public LinkedHashMap<Integer, Comentario> getRespuestas() {
		return respuestas;
	}

	public String getTexto() {
		return texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Video getVideo() {
		return video;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setPadre(Comentario padre) {
		this.padre = padre;
	}

	public void setRespuestas(LinkedHashMap<Integer, Comentario> respuestas) {
		this.respuestas = respuestas;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public boolean tieneRespuestas() {
		return !(this.respuestas.isEmpty());
	}
}
