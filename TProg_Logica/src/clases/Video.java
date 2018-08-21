package clases;
public class Video {

	private String nombre;
	private String descripcion;
	private int duracion;
	private DtTiempo fecha;
	private String url;
	private boolean visible;

	private Categoria categoria;
	private Lista[] listas;
	private Canal canal;
	private Calificacion[] calificaciones;
	private Comentario[] comentarios;

	public Video() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Video(String nombre, String descripcion, int duracion, DtTiempo fecha, String url, boolean visible,
			Categoria categoria, Lista[] listas, Canal canal, Calificacion[] calificaciones, Comentario[] comentarios) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.fecha = fecha;
		this.url = url;
		this.visible = visible;
		this.categoria = categoria;
		this.listas = listas;
		this.canal = canal;
		this.calificaciones = calificaciones;
		this.comentarios = comentarios;
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

	public boolean isVisible() {
		return visible;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Lista[] getListas() {
		return listas;
	}

	public Canal getCanal() {
		return canal;
	}

	public Calificacion[] getCalificaciones() {
		return calificaciones;
	}

	public Comentario[] getComentarios() {
		return comentarios;
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

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setListas(Lista[] listas) {
		this.listas = listas;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public void setCalificaciones(Calificacion[] calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}
}
