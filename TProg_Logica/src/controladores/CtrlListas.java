package controladores;

import clases.Canal;
import clases.Lista;
import clases.Usuario;
import clases.Video;
import dataTypes.DtLista;
import interfaces.IListas;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;

public class CtrlListas implements IListas {

  private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();
  private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();

  @Override
  public void agregarVideoLista(String usuario, String video, String usuarioObjetivo, String lista,
      boolean defecto) {
    Usuario uInicial = manejadorUsuarios.get(usuario);
    Usuario uObjetivo = manejadorUsuarios.get(usuarioObjetivo);
    Video videoObj = uInicial.getCanal().getVideoCanal(video);

    if (defecto) {
      uObjetivo.getCanal().agregarVideoListaDefecto(videoObj, lista);
    } else {
      uObjetivo.getCanal().agregarVideoListaParticular(videoObj, lista);
    }

  }

  @Override
  public void altaListaDefecto(String nombreListaDefecto) throws Exception { // Itera en todos los
                                                                             // usuarios y convoca
    // ingresarListaDefecto(String nombre)
    // sobre su canal

    if (!manejadorListas.existeLista(nombreListaDefecto)) {
      manejadorListas.add(nombreListaDefecto);
      manejadorUsuarios.agregarListaDefecto(nombreListaDefecto);
    } else {
      throw new Exception("Ya existe una lista por defecto con nombre " + nombreListaDefecto);
    }
  }

  @Override
  public void altaListaParticular(String nombre, String usuario, boolean visibilidad)
      throws Exception { // busco el
    // usuario y
    // le pido a
    // su canal
    // que haga
    // el resto

    Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
    if (!usuarioObjetivo.getCanal().getListaParticulares().containsKey(nombre)) {
      usuarioObjetivo.getCanal().ingresarListaParticular(nombre, visibilidad);
    } else {
      throw new Exception(
          "El usuario " + usuario + " ya posee una lista por defecto con nombre: " + nombre);
    }

  }

  @Override
  public DtLista getDt(String lista, String usuario) throws Exception {
    Lista list = manejadorUsuarios.get(usuario).getCanal().getLista(lista);

    return list.getDtLista();
  }

  /*
   * @Override public String getDueñoVideo(String dueñoLista, String nombreLista, String nombreVid)
   * throws Exception {
   * 
   * return manejadorUsuarios.get(dueñoLista).getCanal().getLista(nombreLista).getVideo(
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

}
