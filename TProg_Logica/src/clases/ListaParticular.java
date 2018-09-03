package clases;

import java.util.HashMap;
import java.util.LinkedList;

import dataTypes.DtLista;

public class ListaParticular extends Lista {

	private HashMap<String, Categoria> categorias;
	private boolean visible;

	public ListaParticular(String nombre, Canal canal, HashMap<String, Categoria> categorias,
			boolean visible) {
		super(nombre, canal);
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
			return categorias.containsKey(categoria.getNombre());
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
			videos.add(vid.getCanal().getUsuario().getNick() + "-" + vid.getNombre());
		}
		LinkedList<String> categorias = new LinkedList<String>();
		for (Categoria cat : this.getCategorias().values()) {
			categorias.add(cat.getNombre());
		}
		return new DtLista(this.getNombre(), "Particular", this.visible, videos, categorias);
	}

	public void insertarCategoria(Categoria categoria) {
		if (!categorias.containsKey(categoria.getNombre())) {
			categorias.put(categoria.getNombre(), categoria);
			categoria.addLista(this);
		}
	}

	public void quitarCategoria(Categoria categoria) {
		categorias.remove(categoria.getNombre());
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	@Override
	public boolean equals(Object o) {
		ListaParticular lis = (ListaParticular) o;
		return (this.visible == lis.visible && this.getCanal().equals(lis.getCanal()) && this.getNombre().equals(lis.getNombre()));
	}
}
