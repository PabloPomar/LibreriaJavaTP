package controlador;
import java.util.ArrayList;

import data.DataMail;
import data.DataUsuario;
import entidades.Mail;

public class CtrlMail {
	
	private DataMail dataMail;
	
	public CtrlMail() {
		dataMail = new DataMail();
		
	}
	
	public ArrayList<Mail> getAllByIdAutor( int id ) throws Exception {	
		return dataMail.getAllByIdAutor(id);	
	}
	

}
