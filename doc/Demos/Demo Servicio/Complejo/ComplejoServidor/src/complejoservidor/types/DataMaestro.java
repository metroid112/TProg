/**
 * 
 */
package complejoservidor.types;

/**
 * @author efviodo
 *
 */

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataMaestro {
    private String nombre;
    private String apellido;
    private ArrayList<DataPersona> convocados = new ArrayList<DataPersona>();

    public DataMaestro() {
    }

    public DataMaestro(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<DataPersona> getConvocados() {
        return this.convocados;
    }

    public void setConvocados(ArrayList<DataPersona> dps ) {
         this.convocados=dps ;
    }

    public void addConvocado(DataPersona dp ) {
        this.convocados.add(dp);
    }
}