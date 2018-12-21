package controlador;
import java.util.ArrayList;
import entidades.*;
import data.*;


public class CtrlFacturas {
	 
	private DataProveedor dataProv;
	private DataLibreria dataLibre;
	private DataFacturaCompra dataFacCom;
	private DataLibro dataLib ;
	private DataLinea dataLin;
	
	public CtrlFacturas() {
		dataProv = new DataProveedor();
		dataLibre = new DataLibreria();
		dataFacCom = new DataFacturaCompra();
		dataLib = new DataLibro();
		dataLin = new DataLinea();
	}
	
	/* metodos de proveedor */
	
	public ArrayList<Proveedor> getAllProveedor()throws Exception{
		return dataProv.getAll();
	}
	
	public Proveedor getProveedorById(int id) throws Exception {
		return dataProv.getById(id);	
	}
	
	/* metodos de libreria */
	
	public ArrayList<Libreria> getAllLibreria()throws Exception{
		return dataLibre.getAll();
	}
	
	public Libreria getLibreriaByCuit(int cuit) throws Exception {
		return dataLibre.getByCuit(cuit);	
	}
	
	public ArrayList<Proveedor> sortByRazonSocial(ArrayList<Proveedor> proveedores ) throws Exception{
		dataProv.SortByRazonSocial(proveedores);
		return proveedores;
	}
	
	/* metodos de factura de compra */
	
	public void add(FacturaCompra fc) throws Exception{
		dataFacCom.add(fc);	
	}
	
	
	/* Metodo de obtencion de libros */
	
	public ArrayList<Libro> getAll()throws Exception{
		return dataLib.getAll();
	}
	
	public void updateCantPropia(Libro l, int cantidad) throws Exception{ 
		dataLib.updateCantPropia(l, cantidad);
		
	}
	
	
	/* Metodo de agregado de linea */
	
		
	public void addLC(LineaCompra lc) throws Exception{ 
		dataLin.addLC(lc);
	}
	
	
}


