package controladores;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import clases.Canal;
import clases.ListaDefecto;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import datatypes.DtLista;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
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
      boolean defecto) throws DuplicateClassException, InvalidDataException {
    Usuario usuarioInicial = manejadorUsuarios.getUsuario(usuario);
    Usuario userObjetivo = manejadorUsuarios.getUsuario(usuarioObjetivo);
    Video videoObj = usuarioInicial.getCanal().getVideoCanal(video);

    if (videoObj != null) {
      if (defecto) {
        userObjetivo.getCanal().agregarVideoListaDefecto(videoObj, lista);
      } else {
        userObjetivo.getCanal().agregarVideoListaParticular(videoObj, lista);
      }
    } else
      throw new InvalidDataException("Video null");

  }

  @Override
  public void altaListaDefecto(String nombreListaDefecto) throws DuplicateClassException {
    manejadorListas.addListaDefecto(nombreListaDefecto);
    manejadorUsuarios.agregarListaDefecto(nombreListaDefecto);
  }

  @Override
  public void altaListaParticular(String nombre, String usuario, boolean visibilidad)
      throws DuplicateClassException {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
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
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    usuarioObjetivo.getCanal().guardarCambios(nomLis, visible);
  }

  @Override
  public String[] listarListasDefectoUsuario(String usuario) {

    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListaDefectoUsuario();

  }

  @Override
  public String[] listarListasParticularUsuario(String usuario) {

    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListaParticularUsuario();

  }

  @Override
  public void quitarVideoLista(String usuario, String video, String ownerVideo, String lista,
      boolean defecto) {
    Usuario usuarioObj = manejadorUsuarios.getUsuario(usuario);
    Usuario owner = manejadorUsuarios.getUsuario(ownerVideo);

    if (defecto) {
      usuarioObj.getCanal().quitarVideoListaDefecto(video, lista, owner);
    } else {
      usuarioObj.getCanal().quitarVideoListaParticular(video, lista, owner);
    }
  }

  @Override
  public DtLista getDt(int idLista) throws NotFoundException {
    return ManejadorListasParticulares.getManejadorListasParticulares().getListaParticular(idLista)
        .getDtLista();
  }

  @Override
  public DtLista getDtDefecto(String usuario, String nombreListaDefecto) {
    return ManejadorUsuarios.getManejadorUsuarios().getUsuario(usuario).getCanal()
        .getDtListaDefecto(nombreListaDefecto);
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
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<String, ListaParticular> listasParticulares = canalObjetivo.getListasParticulares();
    for (ListaParticular lista : listasParticulares.values()) {
      listas.add(lista.getDtLista());
    }
    return listas;
  }

  public List<DtLista> getDtListasPrivadasUsuario(String usuario) {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(usuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<String, ListaParticular> listasParticulares = canalObjetivo.getListasParticulares();
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
    for (ListaParticular lista : ManejadorUsuarios.getManejadorUsuarios().getUsuario(usuario).getCanal()
        .getListasParticulares().values()) {
      if (lista.isVisible()) {
        listas.add(lista.getDtLista());
      }
    }
    return listas;
  }

  @Override
  public List<DtLista> getDtListasDefectoUsuario(String usuario) {
    List<DtLista> listasDefecto = new LinkedList<DtLista>();
    for (ListaDefecto lista : ManejadorUsuarios.getManejadorUsuarios().getUsuario(usuario).getCanal()
        .getListasDefecto().values()) {
      listasDefecto.add(lista.getDtLista());
    }
    return listasDefecto;
  }
}
