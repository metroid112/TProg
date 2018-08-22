package manejadores;

import java.util.HashMap;

import clases.Categoria;
import interfaces.IManejador;

public class ManejadorCategorias implements IManejador {

	private HashMap<String, Categoria> categorias = new HashMap<String, Categoria>();

	@Override
	public void add(Object o) {
		Categoria cat = (Categoria) o;
		categorias.put(cat.getNombre(), (Categoria) o);
	}

	@Override
	public void remove(Object o) {
		Categoria cat = (Categoria) o;
		categorias.remove(cat.getNombre(), cat);
	}

	@Override
	public boolean isMember(Object o) {
		return categorias.containsValue(o);
	}

	@Override
	public boolean isMemberKey(Object o) {
		Categoria cat = (Categoria) o;
		return categorias.containsKey(cat.getNombre());
	}

	@Override
	public boolean isEmpty() {
		return categorias.isEmpty();
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
