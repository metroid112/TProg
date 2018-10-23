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
  public void agregarVideoLista(int usuario, String video, String usuarioObjetivo, String lista,
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
  public void altaListaParticular(String nombreLista, int idUsuario, boolean visibilidad)
      throws DuplicateClassException {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    usuarioObjetivo.getCanal().altaListaParticular(nombreLista, visibilidad);
  }

  @Override
  public void guardarCambios(String nomLis, int idUsuario, boolean visible) throws NotFoundException {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    usuarioObjetivo.getCanal().guardarCambios(nomLis, visible);
  }

  @Override
  public String[] listarListasDefectoUsuario(int idUsuario) throws NotFoundException {

    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListaDefectoUsuario();

  }

  @Override
  public String[] listarListasParticularUsuario(int idUsuario) throws NotFoundException {

    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListaParticularUsuario();

  }

  @Override
  public void quitarVideoLista(int idUsuario, String nombreVideo, int ownerVideo, String lista,
      boolean defecto) throws NotFoundException  {
    Usuario usuarioObj = manejadorUsuarios.getUsuario(idUsuario);
    Usuario owner = manejadorUsuarios.getUsuario(ownerVideo);

    if (defecto) {
      usuarioObj.getCanal().quitarVideoListaDefecto(nombreVideo, lista, owner);
    } else {
      usuarioObj.getCanal().quitarVideoListaParticular(nombreVideo, lista, owner);
    }
  }

  @Override
  public DtLista getDt(int idLista) throws NotFoundException {
    return ManejadorListasParticulares.getManejadorListasParticulares().getListaParticular(idLista)
        .getDtLista();
  }

  @Override
  public DtLista getDtDefecto(int idUsuario, String nombreListaDefecto) {
    return manejadorUsuarios.getUsuario(idUsuario).getCanal()
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
  public List<DtLista> getDtListasParticularesUsuario(int idUsuario) {
    // TODO Auto-generated method stub
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<String, ListaParticular> listasParticulares = canalObjetivo.getListasParticulares();
    for (ListaParticular lista : listasParticulares.values()) {
      listas.add(lista.getDtLista());
    }
    return listas;
  }

  public List<DtLista> getDtListasPrivadasUsuario(int idUsuario) {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
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
  public List<DtLista> getDtListasParticularesPublicasUsuario(int idUsuario) {
    List<DtLista> listas = new LinkedList<DtLista>();
    for (ListaParticular lista : manejadorUsuarios.getUsuario(idUsuario).getCanal()
        .getListasParticulares().values()) {
      if (lista.isVisible()) {
        listas.add(lista.getDtLista());
      }
    }
    return listas;
  }

  @Override
  public List<DtLista> getDtListasDefectoUsuario(int idUsuario) {
    List<DtLista> listasDefecto = new LinkedList<DtLista>();
    for (ListaDefecto lista : manejadorUsuarios.getUsuario(idUsuario).getCanal()
        .getListasDefecto().values()) {
      listasDefecto.add(lista.getDtLista());
    }
    return listasDefecto;
  }
}
