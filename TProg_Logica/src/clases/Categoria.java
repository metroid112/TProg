package clases;
import java.util.*;

public class Categoria {

	private String nombre;

	private Lista[] listas;
	private Canal[] canales;
	private LinkedList<Video> videos = new LinkedList<Video>();

	public Categoria() {
	}
	
	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos

	public String getNombre() {
		return nombre;
	}

	public Lista[] getListas() {
		return listas;
	}

	public Canal[] getCanales() {
		return canales;
	}

	public LinkedList<Video> getVideos() {
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

	public void setVideos(LinkedList<Video> videos) {
		this.videos = videos;
	}
	
	public void addVideo(Video v){
		videos.add(v);
	}
}
