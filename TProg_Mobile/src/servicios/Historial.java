
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para historial complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="historial"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servicios/}dtUniversal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reproducciones" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fechaUltimaReproduccion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "historial", propOrder = {
    "reproducciones",
    "fechaUltimaReproduccion"
})
public class Historial
    extends DtUniversal
{

    protected int reproducciones;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaUltimaReproduccion;

    /**
     * Obtiene el valor de la propiedad reproducciones.
     * 
     */
    public int getReproducciones() {
        return reproducciones;
    }

    /**
     * Define el valor de la propiedad reproducciones.
     * 
     */
    public void setReproducciones(int value) {
        this.reproducciones = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaUltimaReproduccion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaUltimaReproduccion() {
        return fechaUltimaReproduccion;
    }

    /**
     * Define el valor de la propiedad fechaUltimaReproduccion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaUltimaReproduccion(XMLGregorianCalendar value) {
        this.fechaUltimaReproduccion = value;
    }

}
