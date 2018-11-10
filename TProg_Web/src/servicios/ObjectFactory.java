
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

    private final static QName _Exception_QNAME = new QName("http://servicios/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
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
<<<<<<< HEAD
     * Create an instance of {@link DtVideo.Comentarios }
     * 
     */
    public DtVideo.Comentarios createDtVideoComentarios() {
        return new DtVideo.Comentarios();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
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
=======
     * Create an instance of {@link DtCalificacion }
>>>>>>> master
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

<<<<<<< HEAD
    /**
     * Create an instance of {@link DtComentario.Hijos.Entry }
     * 
     */
    public DtComentario.Hijos.Entry createDtComentarioHijosEntry() {
        return new DtComentario.Hijos.Entry();
    }

    /**
     * Create an instance of {@link DtVideo.Comentarios.Entry }
     * 
     */
    public DtVideo.Comentarios.Entry createDtVideoComentariosEntry() {
        return new DtVideo.Comentarios.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

=======
>>>>>>> master
}
