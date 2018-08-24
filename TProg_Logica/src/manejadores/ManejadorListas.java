package manejadores;

import java.util.HashSet;

import interfaces.IManejador;

public class ManejadorListas implements IManejador {

	private static ManejadorListas manejador = null;

	public static ManejadorListas getManejadorListas() {
		if (manejador == null) {
			manejador = new ManejadorListas();
		}
		return manejador;
	}

	private HashSet<String> listasDefecto = new HashSet<String>();

	private ManejadorListas() {

	}

	@Override
	public void add(Object o) {
		listasDefecto.add((String) o);
	}

	@Override
	public Object get(Object key) {
		return key;
	}

	@Override
	public boolean isEmpty() {
		return listasDefecto.isEmpty();
	}

	@Override
	public boolean isMember(Object o) {
		return listasDefecto.contains(o);
	}

	@Override
	public void remove(Object o) {
		listasDefecto.remove((String) o);
	}

	@Override
	public int size() {
		return listasDefecto.size();
	}

	@Override
	public String[] toArray() {
		return listasDefecto.toArray(new String[listasDefecto.size()]);
	}
}
