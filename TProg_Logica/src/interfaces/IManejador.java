package interfaces;

public interface IManejador {

	public void add(Object o);

	public void remove(Object o);
	
	public Object get(Object key);

	public boolean isMember(Object o);

	public boolean isEmpty();

	public int size();

	public String[] toArray();
}
