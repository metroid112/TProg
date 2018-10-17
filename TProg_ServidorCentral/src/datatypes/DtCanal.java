package datatypes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DtCanal {
  private String descripcionCanal;
  private String categoria;
  private boolean privado;
  private Date ultimaActividad;
  private Map<Integer, DtVideo> videos = new HashMap<Integer, DtVideo>();
}
