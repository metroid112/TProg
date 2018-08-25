package interfaces;

import java.time.Duration;

public interface IVideos {
	public String[] listarUsuarios();

	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String categoria);
}
