
package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtBusqueda complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtBusqueda"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servicios/}dtUniversal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="videos" type="{http://servicios/}dtVideo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="listas" type="{http://servicios/}dtLista" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usuarios" type="{http://servicios/}dtUsuario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtBusqueda", propOrder = {
    "videos",
    "listas",
    "usuarios"
})
public class DtBusqueda
    extends DtUniversal
{

    @XmlElement(nillable = true)
    protected List<DtVideo> videos;
    @XmlElement(nillable = true)
    protected List<DtLista> listas;
    @XmlElement(nillable = true)
    protected List<DtUsuario> usuarios;

    /**
     * Gets the value of the videos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the videos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtVideo }
     * 
     * 
     */
    public List<DtVideo> getVideos() {
        if (videos == null) {
            videos = new ArrayList<DtVideo>();
        }
        return this.videos;
    }

    /**
     * Gets the value of the listas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtLista }
     * 
     * 
     */
    public List<DtLista> getListas() {
        if (listas == null) {
            listas = new ArrayList<DtLista>();
        }
        return this.listas;
    }

    /**
     * Gets the value of the usuarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtUsuario }
     * 
     * 
     */
    public List<DtUsuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = new ArrayList<DtUsuario>();
        }
        return this.usuarios;
    }

}
