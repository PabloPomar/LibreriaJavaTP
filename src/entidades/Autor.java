package entidades;

public class Autor {
	private int idAutor;
	private String nombre;
	
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Autor(int idAutor, String nombre) {
		super();
		this.idAutor = idAutor;
		this.nombre = nombre;
	} 
	
	public Autor() {} 	
	
	
}
