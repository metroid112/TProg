package dataTypes;

public class DtCalificacion {
	private  boolean like;
	private String usuario;
	private String video;
	
	public DtCalificacion (boolean like, String usuario, String video) {
		this.like = like;
		this.usuario = usuario;
		this.video = video;
	}
	
	public boolean isLike() {
		return this.like;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getVideo() {
		return this.video;
	}
	
	public String getLikeParsed() {
		if (this.like) {
			return "Me gusta";
		} else {
			return "No me gusta";
		}
	}
	
}
