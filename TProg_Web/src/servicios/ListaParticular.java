
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaParticular complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaParticular"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servicios/}lista"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaParticular", propOrder = {
    "visible"
})
public class ListaParticular
    extends Lista
{

    protected boolean visible;

    /**
     * Obtiene el valor de la propiedad visible.
     * 
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Define el valor de la propiedad visible.
     * 
     */
    public void setVisible(boolean value) {
        this.visible = value;
    }

}
