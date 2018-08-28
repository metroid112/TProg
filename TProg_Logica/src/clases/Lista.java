package clases;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class Lista {

	private String nombre;

	private Canal canal;
	private LinkedList<Video> videos;
	private HashMap<String,Categoria> categorias;

	public Lista() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Lista(String nombre, Canal canal, LinkedList<Video> videos, HashMap<String,Categoria> categorias) {
		this.nombre = nombre;
		this.canal = canal;
		this.videos = videos;
		this.categorias = categorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public LinkedList<Video> getVideos() {
		return videos;
	}

	public void setVideos(LinkedList<Video> videos) {
		this.videos = videos;
	}

	public HashMap<String, Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(HashMap<String, Categoria> categorias) {
		this.categorias = categorias;
	}

}
