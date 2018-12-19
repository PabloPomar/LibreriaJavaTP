package controlador;
import java.util.ArrayList;
import entidades.*;
import data.*;


public class CtrlFacturas {
	 
	private DataProveedor dataProv;
	private DataLibreria dataLibre;
	
	public CtrlFacturas() {
		dataProv = new DataProveedor();
		dataLibre = new DataLibreria();
	}
	
	
	public ArrayList<Proveedor> getAllProveedor()throws Exception{
		return dataProv.getAll();
	}
	
	
	public Proveedor getProveedorById(int id) throws Exception {
		return dataProv.getById(id);	
	}
	
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
	
	
}
