package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que conserva la colección global de los usuarios del sistema.
 * Los usuarios se identifican por su cédula de identidad.
 * Se implementa en base al patrón Singleton.
 * @author TProg2017
 *
 */
public class ManejadorUsuario {
    private Map<String, Usuario> usuariosCI;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuariosCI = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String ci = usu.getCedulaIdentidad();
        usuariosCI.put(ci, usu);
    }

    public Usuario obtenerUsuario(String ci) {
        return ((Usuario) usuariosCI.get(ci));
    }

    public Usuario[] getUsuarios() {
        if (usuariosCI.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuariosCI.values();
            Object[] o = usrs.toArray();
            Usuario[] usuarios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];
            }

            return usuarios;
        }
    }

}
