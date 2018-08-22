package manejadores;

import java.util.HashSet;

import interfaces.IManejador;

public class ManejadorListas implements IManejador {

	private HashSet<String> listasDefecto  = new HashSet<String>();

	@Override
	public void add(Object o) {
		listasDefecto.add((String) o);
	}

	@Override
	public void remove(Object o) {
		listasDefecto.remove((String) o);
	}

	@Override
	public boolean isMember(Object o) {
		return listasDefecto.contains(o);
	}

	@Override
	public boolean isMemberKey(Object o) {
		return isMember(o);
	}

	@Override
	public boolean isEmpty() {
		return listasDefecto.isEmpty();
	}

	@Override
	public int size() {
		return listasDefecto.size();
	}

	@Override
	public String[] toArray() {
		return (String[]) listasDefecto.toArray();
	}
}
