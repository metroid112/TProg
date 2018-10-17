package excepciones;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {

  // TODO: Cambiar notFound a object y agregar el lugar donde no se encuentra.
  public NotFoundException(String notFound) {
    super("No se ha encontrado " + notFound);
  }
}
