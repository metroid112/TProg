package clases;
import java.util.*;

import dataTypes.DtLista;

public class ListaParticular extends Lista {
	
	private boolean visible;
	private HashMap<String,Categoria> categorias;

	public ListaParticular() {
	}

	public ListaParticular(String nombre, Canal canal, LinkedList<Video> videos, HashMap<String,Categoria> categorias, boolean visible) {
		super(nombre, canal, videos);
		this.visible = visible;
		this.categorias = categorias;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public HashMap<String, Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(HashMap<String, Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public DtLista getDtLista() {
		LinkedList<String> videos = new LinkedList<String>();
		for (Video vid : this.getVideos()){
			videos.add(vid.getNombre());
		}
		return new DtLista(this.getNombre(), "Particular", this.visible, videos);		
	}
}
