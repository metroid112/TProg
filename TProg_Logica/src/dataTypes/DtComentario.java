package dataTypes;

import java.util.LinkedHashMap;

import clases.Comentario;

public class DtComentario {
	public LinkedHashMap<Integer, DtComentario> hijos = new LinkedHashMap<Integer, DtComentario>();
	public Integer id;
	public String texto, Usuario;

	public DtComentario(Comentario comentario) {
		this.id = comentario.getID();
		this.texto = comentario.getTexto();
		this.Usuario = comentario.getUsuario().getNick();
		if (comentario.tieneRespuestas()) {
			for (Comentario com : comentario.getRespuestas().values()) {
				this.hijos.put(com.getID(), new DtComentario(com));
			}
		}
	}

	public String getString() {
		return ("(" + this.Usuario + ") " + this.texto);
	}
}
