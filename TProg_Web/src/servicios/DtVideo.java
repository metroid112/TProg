
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
 * <p>Clase Java para dtVideo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtVideo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servicios/}dtUniversal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="calificaciones" type="{http://servicios/}dtCalificacion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="calificacionesPositivas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="calificacionesNegativas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="comentarios" type="{http://servicios/}dtComentario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="duracion" type="{http://servicios/}duration" minOccurs="0"/&gt;
 *         &lt;element name="duracionSegundos" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="urlVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="youtubeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="urlThumbnail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="idVideo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtVideo", propOrder = {
    "calificaciones",
    "calificacionesPositivas",
    "calificacionesNegativas",
    "comentarios",
    "duracion",
    "duracionSegundos",
    "fecha",
    "usuario",
    "nombre",
    "urlVideo",
    "youtubeId",
    "urlThumbnail",
    "descripcion",
    "categoria",
    "visible",
    "idVideo"
})
public class DtVideo
    extends DtUniversal
{

    @XmlElement(nillable = true)
    protected List<DtCalificacion> calificaciones;
    @XmlElement(nillable = true)
    protected List<String> calificacionesPositivas;
    @XmlElement(nillable = true)
    protected List<String> calificacionesNegativas;
    @XmlElement(nillable = true)
    protected List<DtComentario> comentarios;
    protected Duration duracion;
    protected long duracionSegundos;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected String usuario;
    protected String nombre;
    protected String urlVideo;
    protected String youtubeId;
    protected String urlThumbnail;
    protected String descripcion;
    protected String categoria;
    protected boolean visible;
    protected int idVideo;

    /**
     * Gets the value of the calificaciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calificaciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalificaciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtCalificacion }
     * 
     * 
     */
    public List<DtCalificacion> getCalificaciones() {
        if (calificaciones == null) {
            calificaciones = new ArrayList<DtCalificacion>();
        }
        return this.calificaciones;
    }

    /**
     * Gets the value of the calificacionesPositivas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calificacionesPositivas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalificacionesPositivas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCalificacionesPositivas() {
        if (calificacionesPositivas == null) {
            calificacionesPositivas = new ArrayList<String>();
        }
        return this.calificacionesPositivas;
    }

    /**
     * Gets the value of the calificacionesNegativas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calificacionesNegativas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalificacionesNegativas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCalificacionesNegativas() {
        if (calificacionesNegativas == null) {
            calificacionesNegativas = new ArrayList<String>();
        }
        return this.calificacionesNegativas;
    }

    /**
     * Gets the value of the comentarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comentarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComentarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtComentario }
     * 
     * 
     */
    public List<DtComentario> getComentarios() {
        if (comentarios == null) {
            comentarios = new ArrayList<DtComentario>();
        }
        return this.comentarios;
    }

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuracion(Duration value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad duracionSegundos.
     * 
     */
    public long getDuracionSegundos() {
        return duracionSegundos;
    }

    /**
     * Define el valor de la propiedad duracionSegundos.
     * 
     */
    public void setDuracionSegundos(long value) {
        this.duracionSegundos = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
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
     * Obtiene el valor de la propiedad urlVideo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Define el valor de la propiedad urlVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlVideo(String value) {
        this.urlVideo = value;
    }

    /**
     * Obtiene el valor de la propiedad youtubeId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYoutubeId() {
        return youtubeId;
    }

    /**
     * Define el valor de la propiedad youtubeId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYoutubeId(String value) {
        this.youtubeId = value;
    }

    /**
     * Obtiene el valor de la propiedad urlThumbnail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlThumbnail() {
        return urlThumbnail;
    }

    /**
     * Define el valor de la propiedad urlThumbnail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlThumbnail(String value) {
        this.urlThumbnail = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad categoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define el valor de la propiedad categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoria(String value) {
        this.categoria = value;
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
     * Obtiene el valor de la propiedad idVideo.
     * 
     */
    public int getIdVideo() {
        return idVideo;
    }

    /**
     * Define el valor de la propiedad idVideo.
     * 
     */
    public void setIdVideo(int value) {
        this.idVideo = value;
    }

}
