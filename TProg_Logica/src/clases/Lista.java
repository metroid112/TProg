package clases;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class Lista {

	private String nombre;

	private Canal canal;
	private LinkedList<Video> videos;
	private LinkedList<Categoria> categorias;
	

	public Lista() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Lista(String nombre, Canal canal, LinkedList<Video> videos, LinkedList<Categoria> categoria) {
		this.nombre = nombre;
		this.canal = canal;
		this.videos = videos;
		this.categorias = categoria;
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

	public boolean existeVideo(Video video){
		return videos.contains(video);
	}

	public void insertarVideo(Video video){
		videos.add(video);
	}
	
	public boolean existeCategoria(Categoria categoria){
		if(categoria != null){
				return categorias.contains(categoria);
		}
		return true;
	}

	public void insertarCategoria(Categoria categoria){
		categorias.add(categoria);
	}
}
