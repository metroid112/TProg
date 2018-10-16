package logica;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

/**
 * Controlador de usuarios.
 * @author TProg2017
 *
 */
public class ControladorUsuario implements IControladorUsuario {

    public ControladorUsuario() {
    }

    public void registrarUsuario(String n, String ap, String ci) throws UsuarioRepetidoException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuario(ci);
        if (u != null)
            throw new UsuarioRepetidoException("El usuario " + ci + " ya esta registrado");

        u = new Usuario(n, ap, ci);
        mu.addUsuario(u);
    }

    public DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuario(ci);
        if (u != null)
            return new DataUsuario(u.getNombre(), u.getApellido(), u.getCedulaIdentidad());
        else
            throw new UsuarioNoExisteException("El usuario " + ci + " no existe");

    }

    public DataUsuario[] getUsuarios() throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario[] usrs = mu.getUsuarios();

        if (usrs != null) {
            DataUsuario[] du = new DataUsuario[usrs.length];
            Usuario usuario;

            // Para separar lógica de presentación, no se deben devolver los Usuario,
            // sino los DataUsuario
            for (int i = 0; i < usrs.length; i++) {
                usuario = usrs[i];
                du[i] = new DataUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCedulaIdentidad());
            }

            return du;
        } else
            throw new UsuarioNoExisteException("No existen usuarios registrados");

    }
}
