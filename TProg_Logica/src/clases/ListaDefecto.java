package clases;

import java.util.LinkedList;

import dataTypes.DtLista;

public class ListaDefecto extends Lista {

	private String nombre;

	public ListaDefecto(String nombre, Canal canal, LinkedList<Video> videos) {
		super(nombre, canal, videos);
	}

	@Override
	public DtLista getDtLista() {
		LinkedList<String> videos = new LinkedList<String>();
		for (Video vid : this.getVideos()) {
			videos.add(vid.getNombre());
		}
		return new DtLista(this.getNombre(), "Defecto", false, videos, null);
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
