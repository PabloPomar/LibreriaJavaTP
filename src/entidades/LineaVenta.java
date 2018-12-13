package entidades;

public class LineaVenta {
	
	private int idLineaVenta;
	private int cantidad;
	private Libro libro;
	private FacturaVenta factura;
	
	public int getIdLineaVenta() {
		return idLineaVenta;
	}
	public void setIdLineaVenta(int idLineaVenta) {
		this.idLineaVenta = idLineaVenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public FacturaVenta getFactura() {
		return factura;
	}
	public void setFactura(FacturaVenta factura) {
		this.factura = factura;
	}
	
	public LineaVenta(int idLineaVenta, int cantidad, Libro libro, FacturaVenta factura) {
		super();
		this.idLineaVenta = idLineaVenta;
		this.cantidad = cantidad;
		this.libro = libro;
		this.factura = factura;
	}
	
	public LineaVenta() {}
	
	

}
