package excepciones;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {

  public NotFoundException(String notFound) {
    super("No se ha encontrado " + notFound);
  }
}
