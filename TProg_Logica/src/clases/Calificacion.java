package clases;

import dataTypes.DtCalificacion;

public class Calificacion {

	private boolean like;

	private Usuario usuario;
	private Video video;

	public Calificacion() {

	}

	public Calificacion(boolean like, Usuario user, Video video) {
		this.like = like;
		this.usuario = user;
		this.video = video;
	}

	public DtCalificacion getDt() {
		return new DtCalificacion(this.like, this.usuario.getNick(), this.video.getNombre());
	}

	public boolean getLike() {
		return this.like;
	}

	public Usuario getUser() {
		return usuario;
	}

	public Video getVideo() {
		return video;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public void setUser(Usuario user) {
		this.usuario = user;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
