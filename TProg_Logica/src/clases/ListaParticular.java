package clases;
import java.util.*;

public class ListaParticular extends Lista {
	private boolean visible;

	public ListaParticular() {
	}

	public ListaParticular(String nombre, Canal canal, LinkedList<Video> videos, HashMap<String,Categoria> categorias, boolean visible) {
		super(nombre, canal, videos, categorias);
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
