package interfaces;

import java.time.Duration;
import java.util.Date;

public interface IVideos {
	public String[] listarUsuarios();
	
	public String[] listarCategorias();

	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String categoria, Date fecha);

	public String[] listarVideos(String nickname);

	public void getDtVideo(String video, String usuario);
}
