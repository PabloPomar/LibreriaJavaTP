package entidades;

public class Proveedor {
	
	private int idProveedor;
	private String razonSocial;
	private int telefono;
	private String mail;
	private String direccion;
	

	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	

	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public Proveedor(int idProveedor, String razonSocial, int telefono, String mail, String direccion) {
		super();
		this.idProveedor = idProveedor;
		this.razonSocial = razonSocial;
		this.telefono = telefono;
		this.mail = mail;
		this.direccion = direccion;
	}
	public Proveedor() {}
	
	

}
