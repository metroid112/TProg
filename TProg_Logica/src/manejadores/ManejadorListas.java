package manejadores;

import java.util.HashSet;

public class ManejadorListas {

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

	public void add(Object o) {
		listasDefecto.add((String) o);
	}

	public boolean isEmpty() {
		return listasDefecto.isEmpty();
	}

	public boolean isMember(Object o) {
		return listasDefecto.contains(o);
	}

	public void remove(Object o) {
		listasDefecto.remove((String) o);
	}

	public int size() {
		return listasDefecto.size();
	}

	public String[] toArray() {
		return listasDefecto.toArray(new String[listasDefecto.size()]);
	}

	public Object getCollection() {
		return listasDefecto;
	}
}
