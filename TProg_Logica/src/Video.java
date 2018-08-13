
public class Video {
	
	private String nombre;
	private String descripcion;
	private int duracion;
	private DtTiempo fecha;
	private String url;
	private Categoria categoria;
	
	public Video(String nombre, String descripcion, int duracion, DtTiempo fecha, String url, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.fecha = fecha;
		this.url = url;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public DtTiempo getFecha() {
		return fecha;
	}

	public String getUrl() {
		return url;
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

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setFecha(DtTiempo fecha) {
		this.fecha = fecha;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
