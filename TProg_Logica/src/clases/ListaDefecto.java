package clases;

import java.util.LinkedList;

import datatypes.DtLista;
import manejadores.ManejadorUsuarios;

public class ListaDefecto extends Lista {

  public ListaDefecto(String nombre, Canal canal) {
    super(nombre, canal);
    for (String nick : ManejadorUsuarios.getManejadorUsuarios().toArray()) {
      ManejadorUsuarios.getManejadorUsuarios().get(nick).getCanal()
          .agregarListaDefectoObserver(this);
    }
  }

  @Override
  public DtLista getDtLista() {
    LinkedList<String> videos = new LinkedList<String>();
    for (Video vid : this.getVideos()) {
      videos.add(vid.getCanal().getUsuario().getNick() + "-" + vid.getNombre());
    }
    return new DtLista(this.getNombre(), "Defecto", false, videos, new LinkedList<String>());
  }
}
