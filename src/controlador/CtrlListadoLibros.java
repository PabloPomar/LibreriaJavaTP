package controlador;

import java.util.ArrayList;

import data.DataLibro;
import entidades.Libro;

public class CtrlListadoLibros {
	
	
	private DataLibro dataLib;
	
	public CtrlListadoLibros() {
		dataLib = new DataLibro();	
	}

	
	public ArrayList<Libro> getAll()throws Exception{
		return dataLib.getAll();
	}
	
	
	public ArrayList<Libro> getByTitulo(String titulo)throws Exception{
		return dataLib.getByTitulo(titulo);
	}
	
	public ArrayList<Libro> sortByTitulo(ArrayList<Libro> libros ) throws Exception{
		dataLib.SortByTitulo(libros);
		return libros;
	}
	
	
	
}
