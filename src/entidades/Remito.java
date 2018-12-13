package entidades;
import java.util.Date;

public class Remito {
	
	private int nroRemito;
	private Date fechaEmision;
	private Proveedor proveedor;
	private Libreria libreria;
	
	
	public int getNroRemito() {
		return nroRemito;
	}
	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Libreria getLibreria() {
		return libreria;
	}
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	
	public Remito(int nroRemito, Date fechaEmision, Proveedor proveedor, Libreria libreria) {
		super();
		this.nroRemito = nroRemito;
		this.fechaEmision = fechaEmision;
		this.proveedor = proveedor;
		this.libreria = libreria;
	}
	
	public Remito() {}
	
	
	

}
