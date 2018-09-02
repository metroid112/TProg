package interfaces;

import java.time.Duration;
import java.util.Date;

import dataTypes.DtVideo;
import excepciones.DuplicateClassException;

public interface IVideos {
	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String categoria, Date fecha) throws DuplicateClassException;

	public void altaVideo(String nick, String nombre, String descripcion, Duration duracion, String url,
			String categoria, Date fecha, boolean visible);

	public DtVideo getDtVideo(String video, String usuario);

	public String[] listarCategorias();

	public String[] listarUsuarios();

	public String[] listarVideos(String nickname);

	public void modificarVideo(String nick, String nombreOld, String nombre, String descripcion, String url,
			String categoria, Duration duracion, Boolean visible, Date fecha);
}
