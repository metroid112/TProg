package clases;

import java.util.HashMap;
import java.util.LinkedList;

import dataTypes.DtLista;

public abstract class Lista {

	private String nombre;

	private Canal canal;
	private LinkedList<Video> videos;
	

	public Lista() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Lista(String nombre, Canal canal, LinkedList<Video> videos) {
		this.nombre = nombre;
		this.canal = canal;
		this.videos = videos;
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

	public abstract DtLista getDtLista();



}
