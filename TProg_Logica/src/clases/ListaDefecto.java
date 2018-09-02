package clases;

import java.util.HashMap;
import java.util.LinkedList;

import dataTypes.DtLista;

public class ListaDefecto extends Lista {
	
	private String nombre;
	
	
	
	public ListaDefecto(String nombre, Canal canal,LinkedList<Video> videos){
		super(nombre, canal,videos);	
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	@Override
	public DtLista getDtLista() {
		LinkedList<String> videos = new LinkedList<String>();
		for (Video vid : this.getVideos()){
			videos.add(vid.getNombre());
		}
		return new DtLista(this.getNombre(), "Defecto", false, videos, new LinkedList<String>());		
	}
	
	
}
