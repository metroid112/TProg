package controladores;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import clases.Canal;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import datatypes.DtLista;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.IListas;
import manejadores.ManejadorListasDefecto;
import manejadores.ManejadorListasParticulares;
import manejadores.ManejadorUsuarios;

public class CtrlListas implements IListas {

  private ManejadorListasDefecto manejadorListas = ManejadorListasDefecto.getManejadorListas();
  private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();

  @Override
  public void agregarVideoLista(String usuario, String video, String usuarioObjetivo, String lista,
      boolean defecto) throws DuplicateClassException {
    Usuario usuarioInicial = manejadorUsuarios.get(usuario);
    Usuario userObjetivo = manejadorUsuarios.get(usuarioObjetivo);
    Video videoObj = usuarioInicial.getCanal().getVideoCanal(video);

    if (defecto) {
      userObjetivo.getCanal().agregarVideoListaDefecto(videoObj, lista);
    } else {
      userObjetivo.getCanal().agregarVideoListaParticular(videoObj, lista);
    }

  }

  @Override
  public void altaListaDefecto(String nombreListaDefecto) throws DuplicateClassException {
    manejadorListas.addListaDefecto(nombreListaDefecto);
    manejadorUsuarios.agregarListaDefecto(nombreListaDefecto);
  }

  @Override
  public void altaListaParticular(String nombre, String usuario, boolean visibilidad)
      throws DuplicateClassException {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    usuarioObjetivo.getCanal().altaListaParticular(nombre, visibilidad);
  }

  /*
   * @Override public String getDue�oVideo(String due�oLista, String nombreLista, String nombreVid)
   * throws Exception {
   * 
   * return manejadorUsuarios.get(due�oLista).getCanal().getLista(nombreLista).getVideo(
   * nombreVid).getCanal() .getUsuario().getNick(); }
   */

  @Override
  public void guardarCambios(String nomLis, String usuario, boolean visible) {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    usuarioObjetivo.getCanal().guardarCambios(nomLis, visible);
  }

  @Override
  public String[] listarListasDefectoUsuario(String usuario) {

    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListaDefectoUsuario();

  }

  @Override
  public String[] listarListasParticularUsuario(String usuario) {

    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListaParticularUsuario();

  }

  @Override
  public void quitarVideoLista(String usuario, String video, String ownerVideo, String lista,
      boolean defecto) {
    Usuario usuarioObj = manejadorUsuarios.get(usuario);
    Usuario owner = manejadorUsuarios.get(ownerVideo);

    if (defecto) {
      usuarioObj.getCanal().quitarVideoListaDefecto(video, lista, owner);
    } else {
      usuarioObj.getCanal().quitarVideoListaParticular(video, lista, owner);
    }
  }

  @Override
  public DtLista getDt(int id) throws NotFoundException {
    return ManejadorListasParticulares.getManejadorListasParticulares().getById(id).getDtLista();
  }

  @Override
  public Map<Integer, DtLista> getDtListas() {
    Map<Integer, DtLista> listas = new HashMap<Integer, DtLista>();
    for (Entry<Integer, ListaParticular> lista : ManejadorListasParticulares
        .getManejadorListasParticulares().getListasParticulares().entrySet()) {
      listas.put(lista.getKey(), lista.getValue().getDtLista());
    }
    return listas;
  }

  @Override
  public Map<Integer, ListaParticular> getListasPublicas() {
    Map<Integer, ListaParticular> listas = new HashMap<Integer, ListaParticular>();
    for (ListaParticular lista : ManejadorListasParticulares.getManejadorListasParticulares()
        .getListasParticulares().values()) {
      if (lista.isVisible()) {
        listas.put(lista.getId(), lista);
      }
    }
    return listas;
  }

  @Override
  public List<DtLista> getDtListasPublicas() {
    List<DtLista> listas = new LinkedList<DtLista>();
    for (ListaParticular lista : ManejadorListasParticulares.getManejadorListasParticulares()
        .getListasParticulares().values()) {
      if (lista.isVisible()) {
        listas.add(lista.getDtLista());
      }
    }
    return listas;
  }

  @Override
  public List<DtLista> getDtListasParticularesUsuario(String usuario) {
    // TODO Auto-generated method stub
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<String, ListaParticular> listasParticulares = canalObjetivo.getListaParticulares();
    for (ListaParticular lista : listasParticulares.values()) {
      listas.add(lista.getDtLista());
    }
    return listas;
  }

  public List<DtLista> getDtListasPrivadasUsuario(String usuario) {
    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<String, ListaParticular> listasParticulares = canalObjetivo.getListaParticulares();
    for (ListaParticular lista : listasParticulares.values()) {
      if (!lista.isVisible()) {
        listas.add(lista.getDtLista());
      }
    }
    return listas;
  }

  @Override
  public List<DtLista> getDtListasParticularesPublicasUsuario(String usuario) {
    List<DtLista> listas = new LinkedList<DtLista>();
    for (ListaParticular lista : ManejadorUsuarios.getManejadorUsuarios().get(usuario).getCanal()
        .getListaParticulares().values()) {
      if (lista.isVisible()) {
        listas.add(lista.getDtLista());
      }
    }
    return listas;
  }
}
