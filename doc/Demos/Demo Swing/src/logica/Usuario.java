package logica;

/**
 * Representa a un usuario en el sistema con nombre, apellido y cédula de identidad.
 * @author TProg2017
 *
 */
public class Usuario {

    private String nombre;
    private String apellido;
    private String cedulaIdentidad;

    public Usuario(String n, String ap, String ci) {
        this.nombre = n;
        this.apellido = ap;
        this.cedulaIdentidad = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setApellido(String ap) {
        apellido = ap;
    }

    public void setCedulaIdentidad(String ci) {
        cedulaIdentidad = ci;
    }

}
