package entidades;
import java.util.Date;

public class Remito {
	
	private int idRemito;
	private Date fechaEmision;
	private Proveedor proveedor;
	private Libreria libreria;
	
	

	
	public int getIdRemito() {
		return idRemito;
	}
	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
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
	

	public Remito(int idRemito, Date fechaEmision, Proveedor proveedor, Libreria libreria) {
		super();
		this.idRemito = idRemito;
		this.fechaEmision = fechaEmision;
		this.proveedor = proveedor;
		this.libreria = libreria;
	}
	
	
	public Remito() {}
	
	
	

}
