package clases;
import java.util.*;
import clases.ListaDefecto;
import java.time.Duration;
import java.util.Date;
import java.util.Arrays;
import java.util.stream.Stream;


public class Canal {

	private String nombre;
	private String descripcion;
	private boolean visible;

	private Usuario usuario;

	private HashMap<String, Video> videos = new HashMap<String, Video>();
	private HashMap<String, ListaDefecto> listaDefecto = new HashMap<String, ListaDefecto>();
	private HashMap<String, ListaParticular> listaParticulares = new HashMap<String, ListaParticular>();
	private Categoria categoria;

	public Canal() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Canal(String nombre, String descripcion, boolean visible, Usuario usuario, HashMap<String, Video> videos,
			HashMap<String, ListaDefecto> listaDefecto, HashMap<String, ListaParticular> listaParticulares, Categoria categoria) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.visible = visible;
		this.usuario = usuario;
/*		if (videos != null) {
			this.videos = videos;
		}
		else {
			this.videos = new Video[0];
		}
		if (listaDefecto != null) {
			this.listaDefecto = listaDefecto;
		}
		else {
			this.listaDefecto = new ListaDefecto[0];
		}
		if (listaParticulares != null) {
			this.listaParticulares = listaParticulares;
		}*/
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public HashMap<String, Video> getVideos() {
		return videos;
	}

	public void setVideos(HashMap<String, Video> videos) {
		this.videos = videos;
	}

	public HashMap<String, ListaDefecto> getListaDefecto() {
		return listaDefecto;
	}

	public void setListaDefecto(HashMap<String, ListaDefecto> listaDefecto) {
		this.listaDefecto = listaDefecto;
	}

	public HashMap<String, ListaParticular> getListaParticulares() {
		return listaParticulares;
	}

	public void setListaParticulares(HashMap<String, ListaParticular> listaParticulares) {
		this.listaParticulares = listaParticulares;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void ingresarListaDefecto(String nombre){
		ListaDefecto nuevaLista = new ListaDefecto(nombre,this,new LinkedList<Video>());
		listaDefecto.put(nombre, nuevaLista); //puede cambiar la implementacion
	}
	
	public void ingresarListaParticular(String nombre, boolean visibilidad){
		
		ListaParticular nuevaLista = new ListaParticular(nombre,this,new LinkedList<Video>(),new HashMap<String,Categoria>(),visibilidad);
		listaParticulares.put(nombre, nuevaLista);	//puede cambiar la implementacion

	}

	public void altaVideo(String nombre2, String descripcion2, Duration duracion, String url, Categoria categoria2, Date fecha) {
		
		videos.put(nombre2,new Video(nombre2, descripcion2, duracion, url, categoria2, this, fecha));
	}


	public String[] getListaUsuario() {
		

		String[] listasArrDefecto = listaDefecto.keySet().toArray(new String[listaDefecto.size()]);
		String[] listasArrParticular = listaParticulares.keySet().toArray(new String[listaParticulares.size()]);
		
		return Stream.concat(Arrays.stream(listasArrDefecto),Arrays.stream(listasArrParticular)).toArray(String[]::new);
	}
	
	public String[] getArrayVideos(){ 
		return videos.keySet().toArray(new String[videos.size()]);
	}
	
	public Video getVideoCanal(String video){
		return videos.get(video);
	}
}
