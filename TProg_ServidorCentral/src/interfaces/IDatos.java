package interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import datatypes.DtBusqueda;

public interface IDatos {
  public void cargaDatos() throws ParseException, IOException;
  public DtBusqueda busquedaGeneral(String txtBusqueda);
  DtBusqueda busquedaVideo(String txtBusqueda);
  DtBusqueda busquedaLista(String txtBusqueda);
  DtBusqueda busquedaCanales(String txtBusqueda);
}
