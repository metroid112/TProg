
package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtLista complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtLista"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servicios/}dtUniversal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categorias" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="videos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dtVideos" type="{http://servicios/}dtVideo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ultimaActividad" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idLista" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreOwner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtLista", propOrder = {
    "categorias",
    "nombre",
    "tipo",
    "videos",
    "dtVideos",
    "visible",
    "ultimaActividad",
    "idLista",
    "nombreOwner"
})
public class DtLista
    extends DtUniversal
{

    @XmlElement(nillable = true)
    protected List<String> categorias;
    protected String nombre;
    protected String tipo;
    @XmlElement(nillable = true)
    protected List<String> videos;
    @XmlElement(nillable = true)
    protected List<DtVideo> dtVideos;
    protected boolean visible;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultimaActividad;
    protected int idLista;
    protected String nombreOwner;

    /**
     * Gets the value of the categorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCategorias() {
        if (categorias == null) {
            categorias = new ArrayList<String>();
        }
        return this.categorias;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
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
     * Define el valor de la propiedad nombre.
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
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getVideos() {
        if (videos == null) {
            videos = new ArrayList<String>();
        }
        return this.videos;
    }

    /**
     * Gets the value of the dtVideos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dtVideos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDtVideos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtVideo }
     * 
     * 
     */
    public List<DtVideo> getDtVideos() {
        if (dtVideos == null) {
            dtVideos = new ArrayList<DtVideo>();
        }
        return this.dtVideos;
    }

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

    /**
     * Obtiene el valor de la propiedad ultimaActividad.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUltimaActividad() {
        return ultimaActividad;
    }

    /**
     * Define el valor de la propiedad ultimaActividad.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUltimaActividad(XMLGregorianCalendar value) {
        this.ultimaActividad = value;
    }

    /**
     * Obtiene el valor de la propiedad idLista.
     * 
     */
    public int getIdLista() {
        return idLista;
    }

    /**
     * Define el valor de la propiedad idLista.
     * 
     */
    public void setIdLista(int value) {
        this.idLista = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreOwner.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreOwner() {
        return nombreOwner;
    }

    /**
     * Define el valor de la propiedad nombreOwner.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreOwner(String value) {
        this.nombreOwner = value;
    }

}
