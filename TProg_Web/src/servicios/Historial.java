
package servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for historial complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the reproducciones property.
     * 
     */
    public int getReproducciones() {
        return reproducciones;
    }

    /**
     * Sets the value of the reproducciones property.
     * 
     */
    public void setReproducciones(int value) {
        this.reproducciones = value;
    }

    /**
     * Gets the value of the fechaUltimaReproduccion property.
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
     * Sets the value of the fechaUltimaReproduccion property.
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
