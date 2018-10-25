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
import manejadores.ManejadorVideos;

public class CtrlListas implements IListas {

  private ManejadorListasDefecto manejadorListas = ManejadorListasDefecto.getManejadorListasDefecto();
  private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
  private ManejadorVideos manejadorVideos = ManejadorVideos.getManejadorVideos();

  @Override
  public void agregarVideoLista(int idVideo, int idUsuario, int idLista,
      boolean defecto) throws DuplicateClassException, InvalidDataException, NotFoundException {
    Usuario userObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Video videoObj = manejadorVideos.getVideo(idVideo);

    if (videoObj != null) {
      if (defecto) {
        userObjetivo.getCanal().agregarVideoListaDefecto(videoObj, idLista);
      } else {
        userObjetivo.getCanal().agregarVideoListaParticular(videoObj, idLista);
      }
    } else
      throw new InvalidDataException("Video null");

  }

  @Override
  public void altaListaDefecto(String nombreListaDefecto) throws DuplicateClassException {
    manejadorListas.addListaDefecto(nombreListaDefecto);
    for (Usuario usuario : manejadorUsuarios.getUsuarios().values()) {
      ListaDefecto listaDef = new ListaDefecto(nombreListaDefecto,usuario.getCanal());
      usuario.getCanal().agregarListaDefecto(listaDef);
    }
  }

  @Override
  public void altaListaParticular(String nombreLista, int idUsuario, boolean visibilidad)
      throws DuplicateClassException, NotFoundException{
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    ListaParticular listaPart = new ListaParticular(nombreLista,usuarioObjetivo.getCanal(),visibilidad);
    usuarioObjetivo.getCanal().agregarListaParticular(listaPart);
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
  public DtLista getDtDefecto(int idUsuario, String nombreListaDefecto)throws NotFoundException {
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
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<String, ListaParticular> listasParticulares = canalObjetivo.getListasParticulares();
    for (ListaParticular lista : listasParticulares.values()) {
      listas.add(lista.getDtLista());
    }
    return listas;
  }

  @Override
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
  public List<DtLista> getDtListasParticularesPublicasUsuario(int idUsuario)throws NotFoundException {
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
