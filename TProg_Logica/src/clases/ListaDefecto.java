package clases;

import java.util.HashMap;
import java.util.LinkedList;

public class ListaDefecto extends Lista {
	
	private String nombre;
	
	
	
	public ListaDefecto(String nombre, Canal canal,LinkedList<Video> videos, LinkedList<Categoria> categoria){
		super(nombre, canal,videos, categoria);	
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	
}
