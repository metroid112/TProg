package interfaces;
import java.lang.Exception;
import java.util.*;

public interface ICategorias {
	
	public abstract void altaCategoria(String s) throws Exception;	
	
	public abstract Set<String> listarCategorias();

}
