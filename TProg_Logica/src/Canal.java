
public class Canal {

	private String nombre;
	private String descripcion;
	private boolean visible;
	
	private Usuario usuario;
	private Video[] videos;
	private Lista[] listas;
	private Categoria categoria;
	
	public Canal() {}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar algunos
	public Canal(String nombre, String descripcion, boolean visible, Usuario usuario, Video[] videos, Lista[] listas,
			Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.visible = visible;
		this.usuario = usuario;
		this.videos = videos;
		this.listas = listas;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isVisible() {
		return visible;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Video[] getVideos() {
		return videos;
	}

	public Lista[] getListas() {
		return listas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setVideos(Video[] videos) {
		this.videos = videos;
	}

	public void setListas(Lista[] listas) {
		this.listas = listas;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
}
