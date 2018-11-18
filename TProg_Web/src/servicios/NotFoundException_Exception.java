
package servicios;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-18T19:30:30.543-03:00
 * Generated source version: 3.2.6
 */

@WebFault(name = "NotFoundException", targetNamespace = "http://servicios/")
public class NotFoundException_Exception extends Exception {

    private servicios.NotFoundException notFoundException;

    public NotFoundException_Exception() {
        super();
    }

    public NotFoundException_Exception(String message) {
        super(message);
    }

    public NotFoundException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public NotFoundException_Exception(String message, servicios.NotFoundException notFoundException) {
        super(message);
        this.notFoundException = notFoundException;
    }

    public NotFoundException_Exception(String message, servicios.NotFoundException notFoundException, java.lang.Throwable cause) {
        super(message, cause);
        this.notFoundException = notFoundException;
    }

    public servicios.NotFoundException getFaultInfo() {
        return this.notFoundException;
    }
}
