package Carrito;

import java.util.ArrayList;

import data.DataAutor;
import data.DataFacturaVenta;
import data.DataLibreria;
import data.DataLibro;
import entidades.Libreria;
import entidades.Libro;

public class CtrlCarrito {
	
	private DataLibro dataLib;
	private DataLibreria dataLibre;
	private DataFacturaVenta dataFV;
	
	
	public CtrlCarrito() {
		dataLib = new DataLibro();
		dataLibre = new DataLibreria();
		dataFV = new DataFacturaVenta();
	}
	
	public Libro getById(int id) throws Exception {
		Libro libro = new Libro();
		libro = dataLib.getById(id);
		return libro;	
		
	}
	
	
	public ArrayList<Libreria> getAllLibreria()throws Exception{
		return dataLibre.getAll();
	}
	
	public int getNroMaxFactura() throws Exception {
		return dataFV.getNroMaxFactura();
	}
	
	

}
