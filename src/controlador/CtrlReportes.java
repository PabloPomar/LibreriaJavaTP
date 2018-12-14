package controlador;
import java.sql.Date;
import java.util.ArrayList;
import data.*;
import entidades.*;


public class CtrlReportes {
	
	private DataLinea dataLin ; 
	
	public CtrlReportes() {
		dataLin = new DataLinea();	
	}
	
	/* metodo para llamar a las lineas de compras */ 
	
	public  ArrayList<LineaCompra> getLineasCompra(Date fini, Date ffin) throws Exception {
		return dataLin.getLineasCompra(fini, ffin);	
	}
	
	
	public  ArrayList<LineaRemito> getLineasRemito(Date fini, Date ffin) throws Exception {
		return dataLin.getLineasRemito(fini, ffin);
	}
	
	
	public  ArrayList<LineaVenta> getLineasVenta(Date fini, Date ffin) throws Exception  {
		return dataLin.getLineasVenta(fini, ffin);	
	}
	

}
