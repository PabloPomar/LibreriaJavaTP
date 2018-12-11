package entidades;

public class Libro {
	private int idLibro;
	private String titulo;
	private int nroEdicion;
	private String isbn;
	private String descripcion;
	private float precio;
	private String editorial;
	private String genero;
	private Autor autor;
	private int cantidadPropia;
	private int cantidadConsignada;
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNroEdicion() {
		return nroEdicion;
	}
	public void setNroEdicion(int nroEdicion) {
		this.nroEdicion = nroEdicion;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public int getCantidadPropia() {
		return cantidadPropia;
	}
	public void setCantidadPropia(int cantidadPropia) {
		this.cantidadPropia = cantidadPropia;
	}
	public int getCantidadConsignada() {
		return cantidadConsignada;
	}
	public void setCantidadConsignada(int cantidadConsignada) {
		this.cantidadConsignada = cantidadConsignada;
	}
	
	public Libro(int idLibro, String titulo, int nroEdicion, String isbn, String descripcion, float precio,
			String editorial, String genero, Autor autor, int cantidadPropia, int cantidadConsignada) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.nroEdicion = nroEdicion;
		this.isbn = isbn;
		this.descripcion = descripcion;
		this.precio = precio;
		this.editorial = editorial;
		this.genero = genero;
		this.autor = autor;
		this.cantidadPropia = cantidadPropia;
		this.cantidadConsignada = cantidadConsignada;
	}
	
	public Libro() {}


	
}
