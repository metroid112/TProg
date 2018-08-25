package manejadores;

import java.util.HashMap;
import java.lang.Exception;
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

	public void add(Categoria categoria) {
		categorias.put(categoria.getNombre(), categoria);
	}

	public Object get(String nombreCategoria) {
		return categorias.get(nombreCategoria);
	}

	public boolean isEmpty() {
		return categorias.isEmpty();
	}

	public boolean isMember(Categoria categoria) {
		return categorias.containsValue(categoria);
	}

	public boolean isMemberKey(String nombreCategoria) {
		return categorias.containsKey(nombreCategoria);
	}

	public void remove(Categoria categoria) {
		categorias.remove(categoria.getNombre(), categoria);
	}

	public int size() {
		return categorias.size();
	}

	public String[] toArray() {
		return categorias.keySet().toArray(new String[categorias.size()]);
	}
	
	public void altaCategoria(String nombreCategoria) throws Exception {		
		if (!categorias.containsKey(nombreCategoria))	{
			add(new Categoria(nombreCategoria));		
		} else {
			throw new Exception("La categoria ya existe");
		}
	}
}
