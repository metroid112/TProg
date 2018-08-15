
public abstract class Lista {

	private String nombre;
	private boolean visible;
	
	private Canal canal;
	private Video[] videos;
	private Categoria[] categorias;
	
	public Lista() {}
	
	// Pato: Constructor con todos los atributos, posiblemente se precise cortar algunos
	public Lista(String nombre, boolean visible, Canal canal, Video[] videos, Categoria[] categorias) {
		this.nombre = nombre;
		this.visible = visible;
		this.canal = canal;
		this.videos = videos;
		this.categorias = categorias;
	}
	
	public String getNombre() {
		return nombre;
	}
	public boolean isVisible() {
		return visible;
	}
	public Canal getCanal() {
		return canal;
	}
	public Video[] getVideos() {
		return videos;
	}
	public Categoria[] getCategorias() {
		return categorias;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	public void setVideos(Video[] videos) {
		this.videos = videos;
	}
	public void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}	
}
