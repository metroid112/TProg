package datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

import clases.Historial;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({DtBusqueda.class, DtCategoria.class, Historial.class})
public abstract class DtUniversal {

}
