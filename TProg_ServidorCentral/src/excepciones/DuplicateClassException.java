package excepciones;

@SuppressWarnings("serial")
public class DuplicateClassException extends Exception {

  public DuplicateClassException(String clase, String nombre) {
    super(clase + " " + nombre + " ya existe.");
  }
}
