package manejadores;

import java.util.HashMap;
import java.util.*;
import java.lang.Exception;
import clases.Categoria;
import interfaces.IManejador;
import javax.swing.JOptionPane;

public class ManejadorCategorias implements IManejador {

	private static ManejadorCategorias manejador = null;

	private ManejadorCategorias() {

	}

	public static ManejadorCategorias getManejadorCategorias() {
		if (manejador == null) {
			manejador = new ManejadorCategorias();
		}
		return manejador;
	}

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
	
	public void altaCategoria(String s) throws Exception{
		
		{
			if (!categorias.containsKey(s))
			{
				Categoria cat = new Categoria(s,null,null,null);
				add(cat);
				
			}
			else
			{
				throw new Exception("La categoria ya existe");
			}
		}
	}
	
	public Set<String> getCategorias(){
		if (!categorias.isEmpty())
			Set<String> cats = new HashSet<String>();
		return cats
		
	}
}
