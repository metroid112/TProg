
public class Categoria {

	private String nombre;

	private Lista[] listas;
	private Canal[] canales;
	private Video[] videos;

	public Categoria() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Categoria(String nombre, Lista[] listas, Canal[] canales, Video[] videos) {
		this.nombre = nombre;
		this.listas = listas;
		this.canales = canales;
		this.videos = videos;
	}

	public String getNombre() {
		return nombre;
	}

	public Lista[] getListas() {
		return listas;
	}

	public Canal[] getCanales() {
		return canales;
	}

	public Video[] getVideos() {
		return videos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setListas(Lista[] listas) {
		this.listas = listas;
	}

	public void setCanales(Canal[] canales) {
		this.canales = canales;
	}

	public void setVideos(Video[] videos) {
		this.videos = videos;
	}
}
