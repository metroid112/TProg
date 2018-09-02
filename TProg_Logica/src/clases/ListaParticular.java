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
	
	public boolean existeCategoria(Categoria categoria){
		if(categoria != null){
				return categorias.containsKey(categoria);
		}
		return true;
	}

	public void insertarCategoria(Categoria categoria){
		categorias.put(categoria.getNombre(), categoria);
	}
	
	public void quitarCategoria(Categoria categoria){
		categorias.remove(categoria);
	}
	
	public boolean esUnicaCategoria(Categoria categoria){
		if(categoria != null){
			for(Video v: super.getVideos()){
				if(v.getCategoria() == categoria){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public DtLista getDtLista() {
		LinkedList<String> videos = new LinkedList<String>();
		for (Video vid : this.getVideos()){
			videos.add(vid.getNombre());
		}
		LinkedList<String> categorias = new LinkedList<String>();
		for (Categoria cat : this.getCategorias().values()){
			categorias.add(cat.getNombre());
		}
		return new DtLista(this.getNombre(), "Particular", this.visible, videos, categorias);		
	}
}
