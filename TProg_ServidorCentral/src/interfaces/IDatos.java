package interfaces;

import java.io.IOException;
import java.text.ParseException;

import datatypes.DtBusqueda;

public interface IDatos {
  public void cargaDatos() throws ParseException, IOException;

  public DtBusqueda busquedaGeneral(String txtBusqueda);

  public DtBusqueda busquedaVideo(String txtBusqueda);

  public DtBusqueda busquedaLista(String txtBusqueda);

  public DtBusqueda busquedaCanales(String txtBusqueda);
}
