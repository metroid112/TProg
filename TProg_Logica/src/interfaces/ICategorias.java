package interfaces;
import java.lang.Exception;

public interface ICategorias {
	
	public void altaCategoria(String nombreCategoria) throws Exception;	
	
	public String[] listarCategorias();
}
