
package servicios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DuplicateClassException_QNAME = new QName("http://servicios/", "DuplicateClassException");
    private final static QName _InvalidDataException_QNAME = new QName("http://servicios/", "InvalidDataException");
    private final static QName _NotFoundException_QNAME = new QName("http://servicios/", "NotFoundException");
    private final static QName _Imagen_QNAME = new QName("http://servicios/", "imagen");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DuplicateClassException }
     * 
     */
    public DuplicateClassException createDuplicateClassException() {
        return new DuplicateClassException();
    }

    /**
     * Create an instance of {@link InvalidDataException }
     * 
     */
    public InvalidDataException createInvalidDataException() {
        return new InvalidDataException();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link DtPaquete }
     * 
     */
    public DtPaquete createDtPaquete() {
        return new DtPaquete();
    }

    /**
     * Create an instance of {@link DtBusqueda }
     * 
     */
    public DtBusqueda createDtBusqueda() {
        return new DtBusqueda();
    }

    /**
     * Create an instance of {@link DtVideo }
     * 
     */
    public DtVideo createDtVideo() {
        return new DtVideo();
    }

    /**
     * Create an instance of {@link DtCalificacion }
     * 
     */
    public DtCalificacion createDtCalificacion() {
        return new DtCalificacion();
    }

    /**
     * Create an instance of {@link DtComentario }
     * 
     */
    public DtComentario createDtComentario() {
        return new DtComentario();
    }

    /**
     * Create an instance of {@link Duration }
     * 
     */
    public Duration createDuration() {
        return new Duration();
    }

    /**
     * Create an instance of {@link DtLista }
     * 
     */
    public DtLista createDtLista() {
        return new DtLista();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link DtCategoria }
     * 
     */
    public DtCategoria createDtCategoria() {
        return new DtCategoria();
    }

    /**
     * Create an instance of {@link Historial }
     * 
     */
    public Historial createHistorial() {
        return new Historial();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuplicateClassException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "DuplicateClassException")
    public JAXBElement<DuplicateClassException> createDuplicateClassException(DuplicateClassException value) {
        return new JAXBElement<DuplicateClassException>(_DuplicateClassException_QNAME, DuplicateClassException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidDataException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "InvalidDataException")
    public JAXBElement<InvalidDataException> createInvalidDataException(InvalidDataException value) {
        return new JAXBElement<InvalidDataException>(_InvalidDataException_QNAME, InvalidDataException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "imagen")
    public JAXBElement<byte[]> createImagen(byte[] value) {
        return new JAXBElement<byte[]>(_Imagen_QNAME, byte[].class, null, ((byte[]) value));
    }

}
