package manejadores;

import java.util.HashMap;
import java.util.Map;

import clases.ListaParticular;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

public class ManejadorListasParticulares {

  private static ManejadorListasParticulares manejador = null;

  private ManejadorListasParticulares() {

  }

  public static ManejadorListasParticulares getManejadorListasParticulares() {
    if (manejador == null) {
      return new ManejadorListasParticulares();
    }
    return manejador;
  }

  private Map<Integer, ListaParticular> listasParticulares =
      new HashMap<Integer, ListaParticular>();

  public void add(ListaParticular listaParticular) throws DuplicateClassException {
    if (!listasParticulares.containsKey(listaParticular.getId())) {
      this.listasParticulares.put(listaParticular.getId(), listaParticular);
    } else {
      throw new DuplicateClassException("ListaParticular", listaParticular.getNombre());
    }
  }

  public ListaParticular getById(int id) throws NotFoundException {
    if (this.listasParticulares.get(id) != null) {
      return this.listasParticulares.get(id);
    } else {
      throw new NotFoundException("la id: " + id);
    }
  }

  public Map<Integer, ListaParticular> getListaParticulars() {
    return this.listasParticulares;
  }
}
