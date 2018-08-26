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

	public void add(Usuario user) {
		usuarios.put(user.getNick(), user);
	}

	public Usuario get(String nick) {
		return usuarios.get(nick);
	}

	public boolean isEmpty() {
		return usuarios.isEmpty();
	}

	public boolean isMember(Usuario user) {
		return usuarios.containsValue(user);
	}

	public boolean isMemberKey(String nick) {
		return usuarios.containsKey(nick);
	}

	public void remove(Usuario user) {
		usuarios.remove(user.getNick(), user);
	}

	public int size() {
		return usuarios.size();
	}

	public String[] toArray() {
		return usuarios.keySet().toArray(new String[usuarios.size()]);
	}
}
