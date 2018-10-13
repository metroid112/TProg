package datatypes;

import java.util.List;

public class DtBusqueda {

  public List<DtVideo> videos;
  public List<DtLista> listas;
  public List<DtUsuario> usuarios;

  public DtBusqueda(List<DtVideo> videos, List<DtLista> listas, List<DtUsuario> usuarios) {
    this.videos = videos;
    this.listas = listas;
    this.usuarios = usuarios;
  }

}
