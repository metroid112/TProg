package dataTypes;

import java.util.LinkedList;

public class DtLista {
	private LinkedList<String> categorias = new LinkedList<String>();
	private String nombre;
	private String tipo;
	private LinkedList<String> videos = new LinkedList<String>();
	private boolean visible;

	public DtLista(String nombre, String tipo, boolean visible, LinkedList<String> videos,
			LinkedList<String> categorias) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.visible = visible;
		this.videos = videos;
		this.categorias = categorias;
	}

	public LinkedList<String> getCategorias() {
		return categorias;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public LinkedList<String> getVideos() {
		return videos;
	}

	public boolean isVisible() {
		return visible;
	}
}
