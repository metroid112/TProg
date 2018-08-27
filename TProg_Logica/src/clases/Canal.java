package clases;

public class Canal {

	private String nombre;
	private String descripcion;
	private boolean visible;

	private Usuario usuario;
	private Video[] videos;
	private ListaDefecto[] listaDefecto;
	private ListaParticular[] listaParticulares;
	private Categoria categoria;

	public Canal() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Canal(String nombre, String descripcion, boolean visible, Usuario usuario, Video[] videos,
			ListaDefecto[] listaDefecto, ListaParticular[] listaParticulares, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.visible = visible;
		this.usuario = usuario;
		this.videos = videos;
		this.listaDefecto = listaDefecto;
		this.listaParticulares = listaParticulares;
		this.categoria = categoria;
	}

	public Canal(String nombreCanal, boolean visible, Usuario user) {
		this.nombre = nombreCanal;
		this.visible = visible;
		this.usuario = user;
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

	public Lista[] getListaDefecto() {
		return listaDefecto;
	}

	public Lista[] getListaParticulares() {
		return listaParticulares;
	}

	public Video[] getVideos() {
		return videos;
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

	public void setListaDefecto(ListaDefecto[] listaDefecto) {
		this.listaDefecto = listaDefecto;
	}

	public void setListaParticulares(ListaParticular[] listaParticulares) {
		this.listaParticulares = listaParticulares;
	}

	public void setVideos(Video[] videos) {
		this.videos = videos;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void ingresarListaParticular(String nombre, boolean visibilidad){
		ListaParticular nuevaLista = new ListaParticular(nombre,this,null,null,visibilidad);
		listaParticulares[listaParticulares.length] = nuevaLista;	//puede cambiar la implementacion
	}
	
	public void ingresarListaDefecto(String nombre){
		ListaDefecto nuevaLista = new ListaDefecto(nombre);
		listaDefecto[listaDefecto.length] = nuevaLista; //puede cambiar la implementacion
	}
}
