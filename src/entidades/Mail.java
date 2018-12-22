package entidades;

public class Mail {
	int idMail;
	Usuario usuario;
	Autor autor;
	String mail;
	
		
	public int getIdMail() {
		return idMail;
	}
	public void setIdMail(int idMail) {
		this.idMail = idMail;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


	public Mail(int idMail, Usuario usuario, Autor autor, String mail) {
		super();
		this.idMail = idMail;
		this.usuario = usuario;
		this.autor = autor;
		this.mail = mail;
	}
	
	
	public Mail() {}
	

}
