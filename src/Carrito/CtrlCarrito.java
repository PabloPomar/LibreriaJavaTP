package Carrito;

import java.util.ArrayList;

import data.DataAutor;
import data.DataFacturaVenta;
import data.DataLibreria;
import data.DataLibro;
import data.DataLinea;
import data.DataMail;
import entidades.FacturaVenta;
import entidades.Libreria;
import entidades.Libro;
import entidades.LineaVenta;
import entidades.Mail;

public class CtrlCarrito {
	
	private DataLibro dataLib;
	private DataLibreria dataLibre;
	private DataFacturaVenta dataFV;
	private DataLinea dataLin;
	private DataMail dataM;
	
	
	public CtrlCarrito() {
		dataLib = new DataLibro();
		dataLibre = new DataLibreria();
		dataFV = new DataFacturaVenta();
		dataLin = new DataLinea();
		dataM = new DataMail();
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
	
	
	public void updateCantPropia(Libro l, int cantidad) throws Exception{ 
		dataLib.updateCantPropia(l, cantidad);	
	}
	
	
	public void updateCantConsignada(Libro l, int cantidad) throws Exception{ 
		dataLib.updateCantConsignada(l, cantidad);	
	}
	
	public int addmasClave(FacturaVenta fv) throws Exception{
		return dataFV.addmasClave(fv);	
	}
	
	public void addLV(LineaVenta lv) throws Exception{ 
		dataLin.addLV(lv);
	}
	
	public void addMail(Mail m) throws Exception{
		dataM.add(m);
	}
	
	

}
