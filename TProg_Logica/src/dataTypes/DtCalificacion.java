package dataTypes;

public class DtCalificacion {
	public boolean like;
	public String usuario;
	public String video;
	
	public DtCalificacion (boolean like, String usuario, String video) {
		this.like = like;
		this.usuario = usuario;
		this.video = video;
	}
	
	public String getLikeParsed() {
		if (this.like) {
			return "Me gusta";
		} else {
			return "No me gusta";
		}
	}
	
}
