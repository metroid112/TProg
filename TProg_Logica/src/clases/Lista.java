package clases;

import java.util.HashMap;
import java.util.LinkedList;

import dataTypes.DtLista;

public abstract class Lista {

	private String nombre;

	private Canal canal;
	private LinkedList<Video> videos;
	

	public Lista() {
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos
	public Lista(String nombre, Canal canal, LinkedList<Video> videos) {
		this.nombre = nombre;
		this.canal = canal;
		this.videos = videos;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public LinkedList<Video> getVideos() {
		return videos;
	}

	public void setVideos(LinkedList<Video> videos) {
		this.videos = videos;
	}

	public abstract DtLista getDtLista();

	public boolean existeVideo(Video video){
		return videos.contains(video);
	}

	public void insertarVideo(Video video){
		videos.add(video);
	}
	
	public void quitarVideo(Video video){
		
		videos.remove(video);
	}
	
	public String[] getArrayVideos(){
		String[] result = new String[videos.size()];
		int i = 0;
		for(Video v: videos){
			result[i] = v.getNombre();
			i++;
		}
		return result;
	}

	public Video getVid(String nombreVid) throws Exception {
		boolean encontrado = false;
		Video video = null;
		for (Video vid : videos) {
			if (vid.getNombre().equals(nombreVid)) {
				encontrado = true;
				video = vid;
			}
		}
		if (!encontrado) {
			throw new Exception("Video no existe");
		}
		return video;
	}
}
