package controlador;

import java.util.ArrayList;

import data.DataAutor;
import entidades.Autor;

// controlador de Autores 

public class CtrlAMBCAutor {
	
	private DataAutor dataAu;
	
	public CtrlAMBCAutor() {
		dataAu = new DataAutor();	
	}
	
	/* metodo para agregar autores */
	
	public void add(Autor a) throws Exception {
		dataAu.add(a);
	}
	
	/* metodo para borrar autores */
	public void delete(Autor a) throws Exception {
		dataAu.remove(a);
	}
	
	/* metodo para actualiazar autores */
	
	public void update(Autor a) throws Exception{
		dataAu.update(a);
		
	}
	
	/* metodo para consultar autores */
	
	public ArrayList<Autor> getAll()throws Exception{
		return dataAu.getAll();
	}
	
	public String validarId(int id) throws Exception{
		return dataAu.ValidarId(id);	
	}
	
	public ArrayList<Autor> getAllSortedByName()throws Exception{
		return dataAu.getAllSortedByNombre();
	}
	
	public Autor getById(int id) throws Exception{
		return dataAu.getById(id);
	}
	

}
