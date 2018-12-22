package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Autor;
import entidades.Libro;
import entidades.Mail;
import entidades.Usuario;
import util.AppDataException;

public class DataMail {
			
	public ArrayList<Mail> getAllByIdAutor( int id ) throws Exception {		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Mail> mails = new ArrayList<Mail>();	
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from mail where idAutor=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Mail m= new Mail();
					Autor a= new Autor();
					Usuario u=new Usuario();
					m.setIdMail(rs.getInt("idMail"));
					u.setIdUsuario(rs.getInt("idUsuario"));
					a.setIdAutor(rs.getInt("idAutor"));
					m.setMail(rs.getString("mail"));
					m.setAutor(a);
					m.setUsuario(u);
					mails.add(m);	
				}	
			}
		
		}catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mails;
	
	}
	
	
	
}
