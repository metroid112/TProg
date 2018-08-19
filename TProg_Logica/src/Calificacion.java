
public class Calificacion {

	private boolean like;

	private Usuario usuario;
	private Video video;

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Calificacion(boolean like, Usuario user, Video video) {
		this.like = like;
		this.usuario = user;
		this.video = video;
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
