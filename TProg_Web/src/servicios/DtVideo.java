
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
 * <p>Java class for dtVideo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtVideo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servicios/}dtUniversal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="calificaciones" type="{http://servicios/}dtCalificacion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="comentarios"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                             &lt;element name="value" type="{http://servicios/}dtComentario" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="duracion" type="{http://servicios/}duration" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="urlVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "comentarios",
    "duracion",
    "fecha",
    "usuario",
    "nombre",
    "urlVideo",
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
    @XmlElement(required = true)
    protected DtVideo.Comentarios comentarios;
    protected Duration duracion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected String usuario;
    protected String nombre;
    protected String urlVideo;
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
     * Gets the value of the comentarios property.
     * 
     * @return
     *     possible object is
     *     {@link DtVideo.Comentarios }
     *     
     */
    public DtVideo.Comentarios getComentarios() {
        return comentarios;
    }

    /**
     * Sets the value of the comentarios property.
     * 
     * @param value
     *     allowed object is
     *     {@link DtVideo.Comentarios }
     *     
     */
    public void setComentarios(DtVideo.Comentarios value) {
        this.comentarios = value;
    }

    /**
     * Gets the value of the duracion property.
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
     * Sets the value of the duracion property.
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
     * Gets the value of the fecha property.
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
     * Sets the value of the fecha property.
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
     * Gets the value of the usuario property.
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
     * Sets the value of the usuario property.
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
     * Gets the value of the urlVideo property.
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
     * Sets the value of the urlVideo property.
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
     * Gets the value of the urlThumbnail property.
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
     * Sets the value of the urlThumbnail property.
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
     * Gets the value of the descripcion property.
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
     * Sets the value of the descripcion property.
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
     * Gets the value of the categoria property.
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
     * Sets the value of the categoria property.
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
     * Gets the value of the visible property.
     * 
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets the value of the visible property.
     * 
     */
    public void setVisible(boolean value) {
        this.visible = value;
    }

    /**
     * Gets the value of the idVideo property.
     * 
     */
    public int getIdVideo() {
        return idVideo;
    }

    /**
     * Sets the value of the idVideo property.
     * 
     */
    public void setIdVideo(int value) {
        this.idVideo = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *                   &lt;element name="value" type="{http://servicios/}dtComentario" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class Comentarios {

        protected List<DtVideo.Comentarios.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DtVideo.Comentarios.Entry }
         * 
         * 
         */
        public List<DtVideo.Comentarios.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<DtVideo.Comentarios.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
         *         &lt;element name="value" type="{http://servicios/}dtComentario" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected Integer key;
            protected DtComentario value;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setKey(Integer value) {
                this.key = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link DtComentario }
             *     
             */
            public DtComentario getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link DtComentario }
             *     
             */
            public void setValue(DtComentario value) {
                this.value = value;
            }

        }

    }

}
