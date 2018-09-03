package manejadores;

import java.util.HashMap;

import clases.Categoria;
import excepciones.DuplicateClassException;

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

	public void add(Categoria categoria) {
		categorias.put(categoria.getNombre(), categoria);
	}

	public void altaCategoria(String nombreCategoria) throws DuplicateClassException {
		if (!categorias.containsKey(nombreCategoria)) {
			add(new Categoria(nombreCategoria));
		} else {
			throw new DuplicateClassException(new Categoria(nombreCategoria), nombreCategoria);
		}
	}

	public Categoria get(String nombreCategoria) {
		return categorias.get(nombreCategoria);
	}
	
	public void removeAll() {
		this.categorias.clear();
	}

	public String[] toArray() {
		return categorias.keySet().toArray(new String[categorias.size()]);
	}
}
