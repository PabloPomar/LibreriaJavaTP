package entidades;

import java.util.Date;

public class Comentario {
	
	private int idComentario;
	private String descripcion;
	private Date fecha_creacion;
	private Usuario usuario;
	private Libro libro;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public Comentario(int idComentario, String descripcion, Date fecha_creacion, Usuario usuario, Libro libro) {
		super();
		this.idComentario = idComentario;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.usuario = usuario;
		this.libro = libro;
	}
	
	public Comentario() {}
	
	

}
