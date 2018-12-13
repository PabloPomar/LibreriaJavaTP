package entidades;

public class LineaRemito {
	
	private int idLineaRemito;
	private int cantidad;
	private Libro libro;
	private Remito remito;
	
	public int getIdLineaRemito() {
		return idLineaRemito;
	}
	public void setIdLineaRemito(int idLineaRemito) {
		this.idLineaRemito = idLineaRemito;
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
	public Remito getRemito() {
		return remito;
	}
	public void setRemito(Remito remito) {
		this.remito = remito;
	}
	
	public LineaRemito(int idLineaRemito, int cantidad, Libro libro, Remito remito) {
		super();
		this.idLineaRemito = idLineaRemito;
		this.cantidad = cantidad;
		this.libro = libro;
		this.remito = remito;
	}
	
	public  LineaRemito() {}

	
}
