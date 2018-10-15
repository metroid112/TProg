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
      manejador = new ManejadorListasParticulares();
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

  public ListaParticular getById(int idLista) throws NotFoundException {
    if (this.listasParticulares.get(idLista) != null) {
      return this.listasParticulares.get(idLista);
    } else {
      throw new NotFoundException("la id: " + idLista);
    }
  }

  public Map<Integer, ListaParticular> getListasParticulares() {
    return this.listasParticulares;
  }

}
