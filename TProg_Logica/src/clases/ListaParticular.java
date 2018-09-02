package clases;

import java.util.HashMap;
import java.util.LinkedList;

import dataTypes.DtLista;

public class ListaParticular extends Lista {

	private HashMap<String, Categoria> categorias;
	private boolean visible;

	public ListaParticular() {
	}

	public ListaParticular(String nombre, Canal canal, LinkedList<Video> videos, HashMap<String, Categoria> categorias,
			boolean visible) {
		super(nombre, canal, videos);
		this.visible = visible;
		this.categorias = categorias;
	}

	public boolean esUnicaCategoria(Categoria categoria) {
		if (categoria != null) {
			for (Video v : super.getVideos()) {
				if (v.getCategoria() == categoria) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean existeCategoria(Categoria categoria) {
		if (categoria != null) {
			return categorias.containsKey(categoria);
		}
		return true;
	}

	public HashMap<String, Categoria> getCategorias() {
		return categorias;
	}

	@Override
	public DtLista getDtLista() {
		LinkedList<String> videos = new LinkedList<String>();
		for (Video vid : this.getVideos()) {
			videos.add(vid.getNombre());
		}
		LinkedList<String> categorias = new LinkedList<String>();
		for (Categoria cat : this.getCategorias().values()) {
			videos.add(cat.getNombre());
		}
		return new DtLista(this.getNombre(), "Particular", this.visible, videos, categorias);
	}

	public void insertarCategoria(Categoria categoria) {
		categorias.put(categoria.getNombre(), categoria);
	}

	public boolean isVisible() {
		return visible;
	}

	public void quitarCategoria(Categoria categoria) {
		categorias.remove(categoria);
	}

	public void setCategorias(HashMap<String, Categoria> categorias) {
		this.categorias = categorias;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
