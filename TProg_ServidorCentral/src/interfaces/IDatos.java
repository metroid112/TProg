package interfaces;

import java.io.IOException;
import java.text.ParseException;

import datatypes.DtBusqueda;

public interface IDatos {
  public void cargaDatos() throws ParseException, IOException, Exception;

  public DtBusqueda busquedaGeneral(String txtBusqueda, int orden);

  public DtBusqueda busquedaVideo(String txtBusqueda, int orden);

  public DtBusqueda busquedaLista(String txtBusqueda, int orden);

  public DtBusqueda busquedaCanales(String txtBusqueda, int orden);
}
