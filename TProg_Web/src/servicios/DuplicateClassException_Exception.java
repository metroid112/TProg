
package servicios;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-11-16T20:28:46.534-03:00
 * Generated source version: 3.2.6
 */

@WebFault(name = "DuplicateClassException", targetNamespace = "http://servicios/")
public class DuplicateClassException_Exception extends Exception {

    private servicios.DuplicateClassException duplicateClassException;

    public DuplicateClassException_Exception() {
        super();
    }

    public DuplicateClassException_Exception(String message) {
        super(message);
    }

    public DuplicateClassException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public DuplicateClassException_Exception(String message, servicios.DuplicateClassException duplicateClassException) {
        super(message);
        this.duplicateClassException = duplicateClassException;
    }

    public DuplicateClassException_Exception(String message, servicios.DuplicateClassException duplicateClassException, java.lang.Throwable cause) {
        super(message, cause);
        this.duplicateClassException = duplicateClassException;
    }

    public servicios.DuplicateClassException getFaultInfo() {
        return this.duplicateClassException;
    }
}
