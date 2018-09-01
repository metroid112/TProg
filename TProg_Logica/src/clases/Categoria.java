package clases;
import java.util.*;
import clases.ListaParticular;

public class Categoria {

	private String nombre;

	private LinkedList<ListaParticular> listas = new LinkedList<ListaParticular>();
	private LinkedList<Video> videos = new LinkedList<Video>();

	public Categoria() {
	}
	
	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	// Pato: Constructor con todos los atributos, posiblemente se precise cortar
	// algunos

	public String getNombre() {
		return nombre;
	}

	public LinkedList<ListaParticular> getListas() {
		return listas;
	}


	public LinkedList<Video> getVideos() {
		return videos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setListas(LinkedList<ListaParticular> listas) {
		this.listas = listas;
	}


	public void setVideos(LinkedList<Video> videos) {
		this.videos = videos;
	}
	
	public void addVideo(Video v){
		videos.add(v);
	}
	
	public String[] getInfoVideos(){
		String[] infoVideos = new String[videos.size()];
		if (!videos.isEmpty()){
			int i = 0;
			for (Video video: videos) {
				String nomVideo = video.getCanal().getUsuario().getNick();
				infoVideos[i] = "(" + nomVideo + "," + video.getNombre() + ")";
				i++;
			}
		}
		return infoVideos;
	}
	
	public int size(){
		return videos.size();
	}
	
	public String[] getInfoListas(){
		String[] infoListas = new String[listas.size()];
		if (!listas.isEmpty()){
			int i = 0;
			for (Lista lista: listas) {
				String nomLista = lista.getCanal().getUsuario().getNick();
				infoListas[i] = "(" + nomLista + "," + lista.getNombre() + ")";
				i++;
			}
		}
		return infoListas;		
	}
	
	
	public boolean equals(Object categoria) {
		return (this.nombre.equals(((Categoria) categoria).getNombre()));
	}
}
