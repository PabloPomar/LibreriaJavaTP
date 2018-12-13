package entidades;

public class Usuario {
	
	private int idUsuario;
	private String tipo;
	private String usuario;
	private String contraseña;
	private String nombreYapellido;
	private int dni;
	private String direccion;
	private int telefono;
	private String mail;
	
	

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombreYapellido() {
		return nombreYapellido;
	}
	public void setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	
	public Usuario(int idUsuario, String tipo, String usuario, String contraseña, String nombreYapellido, int dni,
			String direccion, int telefono, String mail) {
		super();
		this.idUsuario = idUsuario;
		this.tipo = tipo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombreYapellido = nombreYapellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	
	public Usuario() {}
	

}
