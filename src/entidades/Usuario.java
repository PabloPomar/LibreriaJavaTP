package entidades;

public class Usuario {
	
	private int idUsuario;
	private String tipo;
	private String usuario;
	private String contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
	
	
	public Usuario(int idUsuario, String tipo, String usuario, String contrase�a, String nombreYapellido, int dni,
			String direccion, int telefono, String mail) {
		super();
		this.idUsuario = idUsuario;
		this.tipo = tipo;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.nombreYapellido = nombreYapellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	
	public Usuario() {}
	

}
