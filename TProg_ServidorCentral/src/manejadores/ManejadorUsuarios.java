package manejadores;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import clases.Canal;
import clases.Usuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

public class ManejadorUsuarios {

  private static ManejadorUsuarios manejador = null;
  private Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();

  private ManejadorUsuarios() {

  }
  
  public static ManejadorUsuarios getManejadorUsuarios() {
    if (manejador == null) {
      manejador = new ManejadorUsuarios();
    }
    return manejador;
  }  

  public void addUsuario(Usuario usuario) throws DuplicateClassException {
    if (existeUsuario(usuario)) {
      throw new DuplicateClassException("Usuario", usuario.getId().toString());
    } else {
      this.usuarios.put(usuario.getId(), usuario);
    }    
  }
  
  public Usuario getUsuario(int idUsuario) throws NotFoundException {
    if (this.usuarios.containsKey(idUsuario)) {
      return usuarios.get(idUsuario); 
    } else {
      throw new NotFoundException("Usuario id: " + idUsuario);
    }
  }
  
  public Usuario getUsuarioNick(String nick) throws NotFoundException {
    for (Usuario usuario : this.usuarios.values()) {
      if (usuario.getNick().equals(nick)) {
        return usuario;
      }
    }
    throw new NotFoundException("Usuario nick: " + nick);
  }
  
  public Usuario getUsuarioCorreo(String correo) throws NotFoundException {
    for (Usuario usuario : this.usuarios.values()) {
      if (usuario.getCorreo().equals(correo)) {
        return usuario;
      }
    }
    throw new NotFoundException("Usuario correo: " + correo);
  }

  public boolean existeUsuarioId(int idUsuario) {
    return this.usuarios.containsKey(idUsuario);
  }
  
  private boolean existeUsuario(Usuario usuario) {
    if (this.usuarios.containsKey(usuario.getId())) {
      return true;
    } else {
      for (Usuario usuarioTemp : this.usuarios.values()) {
        if (usuarioTemp.getNick().equals(usuario.getNick())) {
          return true;
        }
        if (usuarioTemp.getCorreo().equals(usuario.getCorreo())) {
          return true;
        }
      }
      return false;
    }
  }
  
  public Map<Integer, Usuario> getUsuarios() {
    return this.usuarios;
  }

  // TODO: Repensar lista defecto
  public void agregarListaDefecto(String nombreListaDefecto) {
    for (Usuario usuario : usuarios.values()) {
      usuario.getCanal().ingresarListaDefecto(nombreListaDefecto);
    }
  }

  // TODO: Repensar esta funcion en controlador
  public List<DtVideo> getListaPublicoDtVideo() {
    List<DtVideo> result = new LinkedList<DtVideo>();
    List<DtVideo> listaUsuario = null;

    for (Usuario usuarioObjetivo : usuarios.values()) {

      Canal canalObjetivo = usuarioObjetivo.getCanal();
      listaUsuario = canalObjetivo.listaPublicoDtVideo();

      for (DtVideo v : listaUsuario) {
        result.add(v);
      }

    }
    return result;
  }
}
