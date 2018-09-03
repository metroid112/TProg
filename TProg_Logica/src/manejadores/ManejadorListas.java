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

	public boolean existeLista(String nombre) {
		if (!listasDefecto.contains(nombre)) {
			return false;
		}
		return true;
	}

	public boolean isEmpty() {
		return listasDefecto.isEmpty();
	}

	public String[] toArray() {
		return listasDefecto.toArray(new String[listasDefecto.size()]);
	}
}
