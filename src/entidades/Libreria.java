package entidades;

public class Libreria {
	
	private int cuit;
	private String razonSocial;
	private int telefonoLibreria;
	private String mailLibreria;
	private String direccionLibreria;
	
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public int getTelefonoLibreria() {
		return telefonoLibreria;
	}
	public void setTelefonoLibreria(int telefonoLibreria) {
		this.telefonoLibreria = telefonoLibreria;
	}
	public String getMailLibreria() {
		return mailLibreria;
	}
	public void setMailLibreria(String mailLibreria) {
		this.mailLibreria = mailLibreria;
	}
	public String getDireccionLibreria() {
		return direccionLibreria;
	}
	public void setDireccionLibreria(String direccionLibreria) {
		this.direccionLibreria = direccionLibreria;
	}
	
	public Libreria(int cuit, String razonSocial, int telefonoLibreria, String mailLibreria, String direccionLibreria) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.telefonoLibreria = telefonoLibreria;
		this.mailLibreria = mailLibreria;
		this.direccionLibreria = direccionLibreria;
	}
	
	public Libreria() {};
	

}
