package interfaces;
import java.lang.Exception;
import clases.Categoria;
public interface ICategorias {
	
	public void altaCategoria(String nombreCategoria) throws Exception;	
	
	public String[] listarCategorias();
	
	public String[] getInfoVideos(String s);
}
