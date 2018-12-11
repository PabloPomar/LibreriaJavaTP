package controlador;
import java.util.ArrayList;

import data.*;
import entidades.*;


//controlador de Libros 

public class CtrlAMBCLibro {

	private DataLibro dataLib;
	
	public CtrlAMBCLibro() {
		dataLib = new DataLibro();	
	}
	
	/* metodo para agregar Libros */
	
	public void add(Libro l) throws Exception {
		dataLib.add(l);
	}
	
	
	/* metodo para borrar Libros*/
	
	public void delete(Libro l) throws Exception {
		dataLib.remove(l);
	}
	
	/* metodo para actualizar Libros */
	
	public void update(Libro l) throws Exception {
		dataLib.update(l);
	}
	
	/*  metodo para consultar Libros   */
	
	public ArrayList<Libro> getAll()throws Exception{
		return dataLib.getAll();
	}
	
	public ArrayList<Libro> sortByTitulo(ArrayList<Libro> libros ) throws Exception{
		dataLib.SortByTitulo(libros);
		return libros;
	}
	
	public ArrayList<Libro> sortByNombreAutor(ArrayList<Libro> libros ) throws Exception{
		dataLib.SortByNombreAutor(libros);
		return libros;
	}
	
	public Libro getById(int id) throws Exception {
		Libro libro = new Libro();
		libro = dataLib.getById(id);
		return libro;	
		
	}
	
	
	
	
}
