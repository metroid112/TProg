package manejadores;

import java.util.HashMap;

import clases.Categoria;

public class ManejadorCategorias {

	private static ManejadorCategorias manejador = null;

	public static ManejadorCategorias getManejadorCategorias() {
		if (manejador == null) {
			manejador = new ManejadorCategorias();
		}
		return manejador;
	}

	private HashMap<String, Categoria> categorias = new HashMap<String, Categoria>();

	private ManejadorCategorias() {

	}

	public void add(Object o) {
		Categoria cat = (Categoria) o;
		categorias.put(cat.getNombre(), (Categoria) o);
	}

	public Object get(Object key) {
		return categorias.get(key);
	}

	public boolean isEmpty() {
		return categorias.isEmpty();
	}

	public boolean isMember(Object o) {
		return categorias.containsValue(o);
	}

	public boolean isMemberKey(Object key) {
		return categorias.containsKey(key);
	}

	public void remove(Object o) {
		Categoria cat = (Categoria) o;
		categorias.remove(cat.getNombre(), cat);
	}

	public int size() {
		return categorias.size();
	}

	public String[] toArray() {
		return categorias.keySet().toArray(new String[categorias.size()]);
	}

	public Object getCollection() {
		return categorias;
	}
}
