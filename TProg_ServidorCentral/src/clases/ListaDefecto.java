package clases;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import datatypes.DtLista;
import datatypes.DtVideo;
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
    List<DtVideo> dtVideos = new LinkedList<DtVideo>();
    for (Video vid : this.getVideos()) {
      videos.add(vid.getCanal().getUsuario().getNick() + "-" + vid.getNombre());
      dtVideos.add(vid.getDt());
    }
    return new DtLista(this.getNombre(), "Defecto", false, videos, dtVideos, new LinkedList<String>(), new Date(), this.getId());
  }
}
