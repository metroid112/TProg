package manejadores;

import java.util.HashMap;

import clases.Usuario;

public class ManejadorUsuarios {

	private static ManejadorUsuarios manejador = null;

	public static ManejadorUsuarios getManejadorUsuarios() {
		if (manejador == null) {
			manejador = new ManejadorUsuarios();
		}
		return manejador;
	}

	private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

	private ManejadorUsuarios() {

	}

	public void add(Object o) {
		Usuario usuario = (Usuario) o;
		usuarios.put(usuario.getNick(), usuario);
	}

	public Object get(Object key) {
		return usuarios.get(key);
	}

	public boolean isEmpty() {
		return usuarios.isEmpty();
	}

	public boolean isMember(Object o) {
		return usuarios.containsValue(o);
	}

	public boolean isMemberKey(Object key) {
		return usuarios.containsKey(key);
	}

	public void remove(Object o) {
		Usuario usuario = (Usuario) o;
		usuarios.remove(usuario.getNick(), usuario);
	}

	public int size() {
		return usuarios.size();
	}

	public String[] toArray() {
		return usuarios.keySet().toArray(new String[usuarios.size()]);
	}

	public Object getCollection() {
		return usuarios;
	}
}
