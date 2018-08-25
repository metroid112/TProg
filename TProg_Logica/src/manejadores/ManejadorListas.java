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

	public void add(String lista) {
		listasDefecto.add(lista);
	}

	public boolean isEmpty() {
		return listasDefecto.isEmpty();
	}

	public boolean isMember(String lista) {
		return listasDefecto.contains(lista);
	}

	public void remove(String lista) {
		listasDefecto.remove(lista);
	}

	public int size() {
		return listasDefecto.size();
	}

	public String[] toArray() {
		return listasDefecto.toArray(new String[listasDefecto.size()]);
	}
}
