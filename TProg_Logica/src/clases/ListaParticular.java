package clases;
import java.util.*;

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
}
