package entidades;
import java.util.Date;

public class FacturaCompra {
	
	private int nroFacturaCompra;
	private Date fechaEmision;
	private Libreria libreria;
	private Proveedor proveedor;
	
	public int getNroFacturaCompra() {
		return nroFacturaCompra;
	}
	public void setNroFacturaCompra(int nroFacturaCompra) {
		this.nroFacturaCompra = nroFacturaCompra;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Libreria getLibreria() {
		return libreria;
	}
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public FacturaCompra(int nroFacturaCompra, Date fechaEmision, Libreria libreria, Proveedor proveedor) {
		super();
		this.nroFacturaCompra = nroFacturaCompra;
		this.fechaEmision = fechaEmision;
		this.libreria = libreria;
		this.proveedor = proveedor;
	}
	
	public FacturaCompra() {}
	
	
	

}
