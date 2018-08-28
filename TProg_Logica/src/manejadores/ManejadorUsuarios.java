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
	private HashMap<String, Usuario> usuariosMail = new HashMap<String, Usuario>();

	private ManejadorUsuarios() {

	}

	public void add(Usuario user) {
		usuarios.put(user.getNick(), user);
		usuariosMail.put(user.getCorreo(), user);
	}

	public Usuario get(String key) {
		return usuarios.get(key);
	}

	public boolean isEmpty() {
		return usuarios.isEmpty();
	}

	public boolean isMember(Usuario user) {
		return usuarios.containsValue(user) && usuariosMail.containsValue(user);
	}

	public boolean isMemberKey(String key) {
		return usuarios.containsKey(key) || usuariosMail.containsKey(key);
	}

	public void remove(Usuario user) {
		usuarios.remove(user.getNick(), user);
		usuariosMail.remove(user.getCorreo(), user);
	}

	public int size() {
		return usuarios.size();
	}

	public String[] toArray() {
		return usuarios.keySet().toArray(new String[usuarios.size()]);
	}
}
