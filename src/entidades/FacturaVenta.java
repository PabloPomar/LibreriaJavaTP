package entidades;
import java.util.Date;


public class FacturaVenta {
	
	private int nroFacturaVenta;
	private Date fechaEmision;
	private Usuario usuario;
	private Libreria libreria;
	
	public int getNroFacturaVenta() {
		return nroFacturaVenta;
	}
	public void setNroFacturaVenta(int nroFacturaVenta) {
		this.nroFacturaVenta = nroFacturaVenta;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Libreria getLibreria() {
		return libreria;
	}
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	
	public FacturaVenta(int nroFacturaVenta, Date fechaEmision, Usuario usuario, Libreria libreria) {
		super();
		this.nroFacturaVenta = nroFacturaVenta;
		this.fechaEmision = fechaEmision;
		this.usuario = usuario;
		this.libreria = libreria;
	}
	
	public FacturaVenta() {}
	
	
}
