package manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import clases.Usuario;

public class ManejadorUsuarios {

  private static ManejadorUsuarios manejador = null;

  public static ManejadorUsuarios getManejadorUsuarios() {
    if (manejador == null) {
      manejador = new ManejadorUsuarios();
    }
    return manejador;
  }

  private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

  private ManejadorUsuarios() {

  }

  public void add(Usuario user) {
    usuarios.put(user.getNick(), user);
  }

  public void agregarListaDefecto(String nombreListaDefecto) {

    for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
      entry.getValue().getCanal().ingresarListaDefecto(nombreListaDefecto);
    }
  }

  public Usuario get(String nick) {
    return usuarios.get(nick);
  }

  /**
   * Busca al usuario por su correo Si no es encontrado devuelve null
   */
  public Usuario mailGet(String mail) {
    Usuario usuario = null;
    for (Usuario usuarioTemp : usuarios.values()) {
      if (usuarioTemp.getCorreo().equals(mail)) {
        usuario = usuarioTemp;
      }
    }
    return usuario;
  }

  public boolean isEmailUnique(String email) {
    for (Entry<String, Usuario> user : usuarios.entrySet()) {
      if (user.getValue().getCorreo().equals(email)) {
        return false;
      }
    }
    return true;
  }
  
  public Map<String, Usuario> getMap() {
    return this.usuarios;
  }

  public boolean isMemberKey(String nick) {
    return usuarios.containsKey(nick);
  }

  public void removeAll() {
    this.usuarios.clear();
  }

  public String[] toArray() {
    return usuarios.keySet().toArray(new String[usuarios.size()]);
  }

  public void clear() {
    this.usuarios.clear();
  }
}
