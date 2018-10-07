package interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import datatypes.DtBusqueda;

public interface IDatos {
  public void cargaDatos() throws ParseException, IOException;

  public DtBusqueda busqueda(String txtBusqueda);
}
