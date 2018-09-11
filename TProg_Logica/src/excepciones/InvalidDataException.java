package excepciones;

@SuppressWarnings("serial")
public class InvalidDataException extends Exception {

  public InvalidDataException(String data) {
    super("Dato invalido: " + data);
  }
}
