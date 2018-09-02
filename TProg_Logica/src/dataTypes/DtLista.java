package dataTypes;

import java.util.LinkedList;

public class DtLista {
	private LinkedList<String> videos = new LinkedList<String>();
	private LinkedList<String> categorias = new LinkedList<String>();
	private String nombre;
	private String tipo;
	private boolean visible;
	
	public LinkedList<String> getVideos() {
		return videos;
	}

	public String getNombre() {
		return nombre;
	}


	public String getTipo() {
		return tipo;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public LinkedList<String> getCategorias() {
		return categorias;
	}

	public DtLista(String nombre, String tipo, boolean visible, LinkedList<String> videos, LinkedList<String> categorias) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.visible = visible;
		this.videos = videos;
		this.categorias = categorias;
	}
}
