package manejadores;

import java.util.HashMap;

import clases.Categoria;
import interfaces.IManejador;

public class ManejadorCategorias implements IManejador {

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

	@Override
	public void add(Object o) {
		Categoria cat = (Categoria) o;
		categorias.put(cat.getNombre(), (Categoria) o);
	}

	@Override
	public Object get(Object key) {
		return categorias.get(key);
	}

	@Override
	public boolean isEmpty() {
		return categorias.isEmpty();
	}

	@Override
	public boolean isMember(Object o) {
		return categorias.containsValue(o);
	}

	public boolean isMemberKey(Object key) {
		return categorias.containsKey(key);
	}

	@Override
	public void remove(Object o) {
		Categoria cat = (Categoria) o;
		categorias.remove(cat.getNombre(), cat);
	}

	@Override
	public int size() {
		return categorias.size();
	}

	@Override
	public String[] toArray() {
		return categorias.keySet().toArray(new String[categorias.size()]);
	}
}
