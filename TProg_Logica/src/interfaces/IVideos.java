package interfaces;

import java.time.Duration;
import java.util.Date;

import dataTypes.DtVideo;

public interface IVideos {
	public String[] listarUsuarios();
	
	public String[] listarCategorias();

	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String categoria, Date fecha);

	public String[] listarVideos(String nickname);

	public DtVideo getDtVideo(String video, String usuario);
}
