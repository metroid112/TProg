package manejadores;

import java.util.HashMap;

import clases.Usuario;
import interfaces.IManejador;

public class ManejadorUsuarios implements IManejador {

	private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

	@Override
	public void add(Object o) {
		Usuario usuario = (Usuario) o;
		usuarios.put(usuario.getNick(), usuario);
	}

	@Override
	public void remove(Object o) {
		Usuario usuario = (Usuario) o;
		usuarios.remove(usuario.getNick(), usuario);
	}

	@Override
	public boolean isMember(Object o) {
		return usuarios.containsValue(o);
	}

	@Override
	public boolean isMemberKey(Object o) {
		return usuarios.containsKey(o);
	}

	@Override
	public boolean isEmpty() {
		return usuarios.isEmpty();
	}

	@Override
	public int size() {
		return usuarios.size();
	}
}
