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
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;
import interfaces.IListas;
import manejadores.ManejadorListasDefecto;
import manejadores.ManejadorListasParticulares;
import manejadores.ManejadorUsuarios;
import manejadores.ManejadorVideos;

public class CtrlListas implements IListas {

  private ManejadorListasParticulares manejadorListasParticulares = ManejadorListasParticulares.getManejadorListasParticulares();
  private ManejadorListasDefecto manejadorListasDefecto = ManejadorListasDefecto.getManejadorListasDefecto();
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
  public List<DtVideo> listarDtVideosLista(int idLista, boolean defecto) throws NotFoundException{
    ListaParticular lista = manejadorListasParticulares.getListaParticular(idLista);
    return lista.getListVideos();
  }

  @Override
  public void altaListaDefecto(String nombreListaDefecto) throws DuplicateClassException {
    manejadorListasDefecto.addListaDefecto(nombreListaDefecto);
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
  public void modificarDatos(String nomLis, int idLista, boolean visible) throws NotFoundException {   
    ListaParticular lista = manejadorListasParticulares.getListaParticular(idLista);
    lista.modificarDatos(nomLis,visible);
  }

  @Override
  public Map<Integer, ListaDefecto> listarListasDefectoUsuario(int idUsuario) throws NotFoundException {

    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListasDefecto();

  }

  @Override
  public Map<Integer, ListaParticular> listarListasParticularUsuario(int idUsuario) throws NotFoundException {

    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();

    return canalObjetivo.getListasParticulares();

  }

  @Override
  public void quitarVideoLista(int idUsuario, int idVideo, int idLista,
      boolean defecto) throws NotFoundException  {
    Usuario usuarioObj = manejadorUsuarios.getUsuario(idUsuario);

    if (defecto) {
      usuarioObj.getCanal().quitarVideoListaDefecto(idVideo, idLista);
    } else {
      usuarioObj.getCanal().quitarVideoListaParticular(idVideo, idLista);
    }
  }

  @Override
  public DtLista getDt(int idLista) throws NotFoundException {
    return ManejadorListasParticulares.getManejadorListasParticulares().getListaParticular(idLista)
        .getDtLista();
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
  public List<DtLista> getDtListasParticularesUsuario(int idUsuario) throws NotFoundException {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<Integer, ListaParticular> listasParticulares = canalObjetivo.getListasParticulares();
    for (ListaParticular lista : listasParticulares.values()) {
      listas.add(lista.getDtLista());
    }
    return listas;
  }

  @Override
  public List<DtLista> getDtListasPrivadasUsuario(int idUsuario) throws NotFoundException {
    Usuario usuarioObjetivo = manejadorUsuarios.getUsuario(idUsuario);
    Canal canalObjetivo = usuarioObjetivo.getCanal();
    List<DtLista> listas = new LinkedList<DtLista>();
    Map<Integer, ListaParticular> listasParticulares = canalObjetivo.getListasParticulares();
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
  public List<DtLista> getDtListasDefectoUsuario(int idUsuario) throws NotFoundException {
    List<DtLista> listasDefecto = new LinkedList<DtLista>();
    for (ListaDefecto lista : manejadorUsuarios.getUsuario(idUsuario).getCanal()
        .getListasDefecto().values()) {
      listasDefecto.add(lista.getDtLista());
    }
    return listasDefecto;
  }
}
