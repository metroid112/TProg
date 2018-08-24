package manejadores;

import java.util.HashMap;

import clases.Usuario;
import interfaces.IManejador;

public class ManejadorUsuarios implements IManejador {

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

	@Override
	public void add(Object o) {
		Usuario usuario = (Usuario) o;
		usuarios.put(usuario.getNick(), usuario);
	}

	@Override
	public Object get(Object key) {
		return usuarios.get(key);
	}

	@Override
	public boolean isEmpty() {
		return usuarios.isEmpty();
	}

	@Override
	public boolean isMember(Object o) {
		return usuarios.containsValue(o);
	}

	public boolean isMemberKey(Object key) {
		return usuarios.containsKey(key);
	}

	@Override
	public void remove(Object o) {
		Usuario usuario = (Usuario) o;
		usuarios.remove(usuario.getNick(), usuario);
	}

	@Override
	public int size() {
		return usuarios.size();
	}

	@Override
	public String[] toArray() {
		return usuarios.keySet().toArray(new String[usuarios.size()]);
	}
}
