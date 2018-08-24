package clases;

public class ListaDefecto extends Lista {
	
	private String nombre;
	
	
	
	public ListaDefecto(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	
}
