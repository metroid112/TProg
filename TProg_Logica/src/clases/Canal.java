package clases;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

import excepciones.DuplicateClassException;
import manejadores.ManejadorListas;

public class Canal {

	private Categoria categoria;
	private String descripcion;
	private HashMap<String, ListaDefecto> listaDefecto = new HashMap<String, ListaDefecto>();

	private HashMap<String, ListaParticular> listaParticulares = new HashMap<String, ListaParticular>();

	private String nombre;
	private Usuario usuario;
	private HashMap<String, Video> videos = new HashMap<String, Video>();
	private boolean visible;

	public Canal() {

	}

	public Canal(String nombreCanal, String descripcionCanal, Categoria categoria, boolean visible, Usuario user) {
		this.nombre = nombreCanal;
		this.descripcion = descripcionCanal;
		this.visible = visible;
		this.usuario = user;
		for (String lista : ManejadorListas.getManejadorListas().toArray()) {
			listaDefecto.put(lista, new ListaDefecto(lista, this));
		}
	}

	public void agregarVideoListaDefecto(Video videoObj, String lista) {
		ListaDefecto listaObj = listaDefecto.get(lista);
		if (!listaObj.existeVideo(videoObj)) {
			listaObj.insertarVideo(videoObj);
		}
	}

	public void agregarVideoListaParticular(Video videoObj, String lista) {
		ListaParticular listaObj = listaParticulares.get(lista);
		if (!listaObj.existeVideo(videoObj)) {
			listaObj.insertarVideo(videoObj);

			Categoria categoria = videoObj.getCategoria();
			if (!listaObj.existeCategoria(categoria)) {
				listaObj.insertarCategoria(categoria);
			}
		}
		// disparar excepcion
	}

	public void altaVideo(String nombre2, String descripcion2, Duration duracion, String url, Categoria categoria2,
			Date fecha) throws DuplicateClassException {
		if (!videos.containsKey(nombre2)) {
			videos.put(nombre2, new Video(nombre2, descripcion2, duracion, url, categoria2, this, fecha));
		} else {
			throw new DuplicateClassException(new Video(nombre2, descripcion2, duracion, url, categoria2, this, fecha), nombre2);
		}
	}

	public Video altaVideo(String nombre, String descripcion, Duration duracion, String url, Categoria categoria,
			Date fecha, boolean visible) {

		Video video = new Video(nombre, descripcion, duracion, url, categoria, fecha, visible, this);
		this.videos.put(nombre, video);
		return video;

	}

	public String[] getArrayVideos() {

		return videos.keySet().toArray(new String[videos.size()]);
	}

	public String getDescripcion() {
		return descripcion;
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

	public HashMap<String, ListaDefecto> getListaDefecto() {
		return listaDefecto;
	}

	public String[] getListaDefectoUsuario() {

		return listaDefecto.keySet().toArray(new String[listaDefecto.size()]);

	}

	public HashMap<String, ListaParticular> getListaParticulares() {
		return listaParticulares;
	}

	public String[] getListaParticularUsuario() {

		return listaParticulares.keySet().toArray(new String[listaParticulares.size()]);

	}

	public String getNombre() {
		return nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Video getVideoCanal(String video) {

		return videos.get(video);
	}

	public HashMap<String, Video> getVideos() {
		return videos;
	}

	public void guardarCambios(String nomLis, boolean visible) {
		ListaParticular listaObjetivo = listaParticulares.get(nomLis);
		listaObjetivo.setVisible(visible);
	}

	public void ingresarListaDefecto(String nombre) {
		ListaDefecto nuevaLista = new ListaDefecto(nombre, this);
		listaDefecto.put(nombre, nuevaLista); // puede cambiar la implementacion
	}
	
	public void agregarListaDefectoObserver(ListaDefecto listaDefecto) {
		this.listaDefecto.put(listaDefecto.getNombre(), listaDefecto);
	}

	public void ingresarListaParticular(String nombre, boolean visibilidad) {

		ListaParticular nuevaLista = new ListaParticular(nombre, this,
				new HashMap<String, Categoria>(), visibilidad);
		listaParticulares.put(nombre, nuevaLista); // puede cambiar la implementacion

	}

	public boolean isVisible() {
		return visible;
	}

	public String[] listarVideosLista(String lista, boolean defecto) {
		if (defecto) {
			ListaDefecto listaDef = listaDefecto.get(lista);
			return listaDef.getArrayVideos();
		} else {
			ListaParticular listaPar = listaParticulares.get(lista);
			return listaPar.getArrayVideos();
		}
	}

	public void modVideo(String nombreOld, String nombre) {
		Video vid = this.videos.remove(nombreOld);
		this.videos.put(nombre, vid);

	}

	public void quitarVideoListaDefecto(String video, String lista) {
		ListaDefecto listaObj = listaDefecto.get(lista);
		Video videoObj = videos.get(video);
		listaObj.quitarVideo(videoObj);

	}

	public void quitarVideoListaParticular(String video, String lista) {
		ListaParticular listaObj = listaParticulares.get(lista);
		Video videoObj = videos.get(video);
		listaObj.quitarVideo(videoObj);
		Categoria cat = videoObj.getCategoria();

		if (listaObj.esUnicaCategoria(cat)) {
			listaObj.quitarCategoria(cat);
		}

	}
	
	public void agregarVideo(Video video) {
		this.videos.put(video.getNombre(), video);
	}
}
