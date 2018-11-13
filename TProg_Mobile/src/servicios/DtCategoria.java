
package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtCategoria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtCategoria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servicios/}dtUniversal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="categoriaId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="videos" type="{http://servicios/}dtVideo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="listas" type="{http://servicios/}dtLista" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtCategoria", propOrder = {
    "nombre",
    "categoriaId",
    "videos",
    "listas"
})
public class DtCategoria
    extends DtUniversal
{

    protected String nombre;
    protected int categoriaId;
    @XmlElement(nillable = true)
    protected List<DtVideo> videos;
    @XmlElement(nillable = true)
    protected List<DtLista> listas;

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the categoriaId property.
     * 
     */
    public int getCategoriaId() {
        return categoriaId;
    }

    /**
     * Sets the value of the categoriaId property.
     * 
     */
    public void setCategoriaId(int value) {
        this.categoriaId = value;
    }

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

}
