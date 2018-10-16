package logica;

/**
 * Datatype para transportar la información de un usuario entre capa lógica y de presentación.
 * En Java los datatypes se definen con setters y getters, y se denominan JavaBean.
 * @author TProg2017
 *
 */
public class DataUsuario {

    private String nombre;
    private String apellido;
    private String cedulaIdentidad;

    public DataUsuario() {
        this.setNombre(new String());
        this.setApellido(new String());
        this.setCedulaIdentidad(new String());
    }

    public DataUsuario(String nombre, String apellido, String cedulaIdentidad) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCedulaIdentidad(cedulaIdentidad);
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

    /* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
     */
    public String toString() {
        return getCedulaIdentidad() + " (" + getNombre() + " " + getApellido() + ")";
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private void setCedulaIdentidad(String cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

}
