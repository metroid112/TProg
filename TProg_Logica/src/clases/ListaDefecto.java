package clases;

import java.util.LinkedList;

import dataTypes.DtLista;

public class ListaDefecto extends Lista {


	public ListaDefecto(String nombre, Canal canal) {
		super(nombre, canal);
	}

	@Override
	public DtLista getDtLista() {
		LinkedList<String> videos = new LinkedList<String>();
		for (Video vid : this.getVideos()) {
			videos.add(vid.getNombre());
		}
		return new DtLista(this.getNombre(), "Defecto", false, videos, null);
	}
}
