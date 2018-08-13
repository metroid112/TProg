
public class Calificacion {
	
	private boolean like;
	private Usuario user;
	private Video video;
	
	public Calificacion(boolean like, Usuario user, Video video) {
		this.like  = like;
		this.user  = user;
		this.video = video;
	}
	
	public boolean getLike() {
		return this.like;
	}

	public Usuario getUser() {
		return user;
	}

	public Video getVideo() {
		return video;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
