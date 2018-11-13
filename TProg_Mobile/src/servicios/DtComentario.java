
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
 * <p>Java class for dtComentario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtComentario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hijos" type="{http://servicios/}dtComentario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="idComentario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="texto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="tieneHijos" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtComentario", propOrder = {
    "hijos",
    "idComentario",
    "texto",
    "usuario",
    "fecha",
    "tieneHijos"
})
public class DtComentario {

    @XmlElement(nillable = true)
    protected List<DtComentario> hijos;
    protected int idComentario;
    protected String texto;
    protected String usuario;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected boolean tieneHijos;

    /**
     * Gets the value of the hijos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hijos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHijos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtComentario }
     * 
     * 
     */
    public List<DtComentario> getHijos() {
        if (hijos == null) {
            hijos = new ArrayList<DtComentario>();
        }
        return this.hijos;
    }

    /**
     * Gets the value of the idComentario property.
     * 
     */
    public int getIdComentario() {
        return idComentario;
    }

    /**
     * Sets the value of the idComentario property.
     * 
     */
    public void setIdComentario(int value) {
        this.idComentario = value;
    }

    /**
     * Gets the value of the texto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Sets the value of the texto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTexto(String value) {
        this.texto = value;
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
     * Gets the value of the tieneHijos property.
     * 
     */
    public boolean isTieneHijos() {
        return tieneHijos;
    }

    /**
     * Sets the value of the tieneHijos property.
     * 
     */
    public void setTieneHijos(boolean value) {
        this.tieneHijos = value;
    }

}
