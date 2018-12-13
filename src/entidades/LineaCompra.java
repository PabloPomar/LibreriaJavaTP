package entidades;

public class LineaCompra {
	
	private int idLineaCompra;
	private int cantidad;
	private Libro libro;
	private FacturaCompra factura;
	
	
	public int getIdLineaCompra() {
		return idLineaCompra;
	}
	public void setIdLineaCompra(int idLineaCompra) {
		this.idLineaCompra = idLineaCompra;
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
	public FacturaCompra getFactura() {
		return factura;
	}
	public void setFactura(FacturaCompra factura) {
		this.factura = factura;
	}
	
	public LineaCompra(int idLineaCompra, int cantidad, Libro libro, FacturaCompra factura) {
		super();
		this.idLineaCompra = idLineaCompra;
		this.cantidad = cantidad;
		this.libro = libro;
		this.factura = factura;
	}
	
	public LineaCompra() {}
	
	
	

}
