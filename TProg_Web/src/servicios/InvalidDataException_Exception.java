
package servicios;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-15T17:35:56.885-03:00
 * Generated source version: 3.2.6
 */

@WebFault(name = "InvalidDataException", targetNamespace = "http://servicios/")
public class InvalidDataException_Exception extends Exception {

    private servicios.InvalidDataException invalidDataException;

    public InvalidDataException_Exception() {
        super();
    }

    public InvalidDataException_Exception(String message) {
        super(message);
    }

    public InvalidDataException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public InvalidDataException_Exception(String message, servicios.InvalidDataException invalidDataException) {
        super(message);
        this.invalidDataException = invalidDataException;
    }

    public InvalidDataException_Exception(String message, servicios.InvalidDataException invalidDataException, java.lang.Throwable cause) {
        super(message, cause);
        this.invalidDataException = invalidDataException;
    }

    public servicios.InvalidDataException getFaultInfo() {
        return this.invalidDataException;
    }
}
