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

	public Canal(String nombreCanal, String descripcionCanal, boolean visible, Usuario user) {
		this.nombre = nombreCanal;
		this.descripcion = descripcionCanal;
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


	public String[] getListaDefectoUsuario() {
		
		return listaDefecto.keySet().toArray(new String[listaDefecto.size()]);
		
	}
	
	public String[] getListaParticularUsuario() {
		
		return listaParticulares.keySet().toArray(new String[listaParticulares.size()]);
		
	}
	
	public void guardarCambios(String nomLis, boolean visible){
		ListaParticular listaObjetivo = listaParticulares.get(nomLis);
		listaObjetivo.setVisible(visible);
	}
	
	public String[] getArrayVideos(){ 

		return videos.keySet().toArray(new String[videos.size()]);
	}
	
	public Video getVideoCanal(String video){

		return videos.get(video);
	}
	
	public void agregarVideoListaDefecto(Video videoObj, String lista){
		ListaDefecto listaObj = listaDefecto.get(lista);
			if(!listaObj.existeVideo(videoObj)){
				listaObj.insertarVideo(videoObj);
			}

	}
  
	public Lista getLista(String lista) throws Exception {
		if (this.listaDefecto.containsKey(lista)) {
			return this.listaDefecto.get(lista);
		} else if (this.listaParticulares.containsKey(lista)) {
			return this.listaParticulares.get(lista); 
		} else {
			throw new Exception("No existe lista");
		}
		
	}
	
	public void agregarVideoListaParticular(Video videoObj, String lista){
		ListaParticular listaObj = listaParticulares.get(lista);
			if(!listaObj.existeVideo(videoObj)){
				listaObj.insertarVideo(videoObj);
				
				Categoria categoria = videoObj.getCategoria();
				if(!listaObj.existeCategoria(categoria)){
					listaObj.insertarCategoria(categoria);
				}
			}
			// disparar excepcion
	}
	
	public void quitarVideoListaDefecto(String video,String lista){
		ListaDefecto listaObj = listaDefecto.get(lista);
		Video videoObj = videos.get(video);
		listaObj.quitarVideo(videoObj);
		
	}
	
	public void quitarVideoListaParticular(String video,String lista){
		ListaParticular listaObj = listaParticulares.get(lista);
		Video videoObj = videos.get(video);
		listaObj.quitarVideo(videoObj);
		Categoria cat = videoObj.getCategoria();
		
		
		if(listaObj.esUnicaCategoria(cat)){
			listaObj.quitarCategoria(cat);
		}
		
	}
	
	public Video altaVideo(String nombre, String descripcion, Duration duracion, String url, Categoria categoria,
			Date fecha, boolean visible) {

		Video video = new Video(nombre, descripcion, duracion, url, categoria, fecha, visible, this);
		this.videos.put(nombre, video);		
		return video;

	}
	
	public String[] listarVideosLista(String lista,boolean defecto){
		if(defecto){
			ListaDefecto listaDef = listaDefecto.get(lista);
			return listaDef.getArrayVideos();
		}
		else{
			ListaParticular listaPar = listaParticulares.get(lista);
			return listaPar.getArrayVideos();
		}
	}

	public void modVideo(String nombreOld, String nombre) {
		Video vid = this.videos.remove(nombreOld);
		this.videos.put(nombre, vid);
		
	}
}
