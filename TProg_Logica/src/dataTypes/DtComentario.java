package dataTypes;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import clases.Comentario;

public class DtComentario {
	private LinkedHashMap<Integer, DtComentario> hijos = new LinkedHashMap<Integer, DtComentario>();
	private Integer id;
	
	public DtComentario(Comentario comentario) {
		this.id = comentario.getID();
		if (comentario.tieneRespuestas()) {
			for (Comentario com : comentario.getRespuestas().values()) {
				this.hijos.put(com.getID(), new DtComentario(com));
			}
		}
	}

	public Integer getId() {
		return this.id;
	}
}
