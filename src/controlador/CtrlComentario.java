package controlador;

import java.util.ArrayList;

import data.DataComentario;
import entidades.Comentario;
import entidades.Libro;

public class CtrlComentario {
	
	private DataComentario dataComentario;

	public CtrlComentario() {
		super();
		dataComentario = new DataComentario();
	}

	public ArrayList<Comentario> getByLibro(Libro libro) throws Exception {
		return dataComentario.getByLibro(libro);
	}
	
	public void addComentario(Comentario comentario) throws Exception {
		dataComentario.addComentario(comentario);
	}
	
	public void delete(Comentario comentario) throws Exception {
		dataComentario.remove(comentario);
	}
	
	
}
