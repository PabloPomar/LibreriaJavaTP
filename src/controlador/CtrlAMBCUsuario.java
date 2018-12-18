package controlador;

import data.DataUsuario;
import entidades.Usuario;

public class CtrlAMBCUsuario {

	private DataUsuario dataUsuario;		
	
	public CtrlAMBCUsuario() {
		dataUsuario = new DataUsuario();
	}

	public Usuario login(Usuario usuario) throws Exception {
		return dataUsuario.getLogedUser(usuario);
	}
	
	
	public void add(Usuario u) throws Exception {
		dataUsuario.add(u);
	}
	
	public String validarUsuario (String usuario) throws Exception {
		return dataUsuario.ValidarUsuario(usuario);	
	}
	
	
	
	
}
