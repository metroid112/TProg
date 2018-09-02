package excepciones;

@SuppressWarnings("serial")
public class DuplicateClassException extends Exception {
	public DuplicateClassException(Object clase, String nombre) {
		super(clase.getClass().getSimpleName() + " " + nombre + " ya existe.");
	}
}
