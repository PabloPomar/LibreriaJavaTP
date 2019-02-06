package data;

import org.apache.logging.log4j.Level;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Libro;
import entidades.Usuario;
import util.AppDataException;

public class DataUsuario {

	public Usuario getLogedUser(Usuario usuario) throws Exception {
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from usuario where usuario=? and contraseña=?");
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getContraseña());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				    u=new Usuario();
				    u.setIdUsuario(rs.getInt("idUsuario"));
				    u.setTipo(rs.getString("tipo"));
				    u.setUsuario(rs.getString("usuario"));
				    u.setContraseña(rs.getString("contraseña"));
				    u.setNombreYapellido(rs.getString("nombreYApellido"));
				    u.setDni(rs.getInt("dni"));
				    u.setDireccion(rs.getString("direccion"));
				    u.setTelefono(rs.getInt("telefono"));
				    u.setMail(rs.getString("mail"));
			}			
		} 
		catch (Exception e) {
			throw e;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return u;
	}
	
	
	public void add(Usuario u) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;	
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("INSERT INTO usuario (tipo, usuario, contraseña, nombreYApellido, dni, direccion, telefono, mail) VALUES ('usuario', ?, ?, ?, ?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getUsuario());
			stmt.setString(2, u.getContraseña());
			stmt.setString(3, u.getNombreYapellido());
			stmt.setInt(4, u.getDni());
			stmt.setString(5, u.getDireccion());
			stmt.setInt(6, u.getTelefono());
			stmt.setString(7, u.getMail());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				u.setIdUsuario(keyResultSet.getInt(1));
			}
			
		}  catch (SQLException e) {
			AppDataException ade = new AppDataException(e, "Error al registrar el usuario.\n"+e.getSQLState()+":"+e.getMessage(), Level.WARN);
			throw ade;
		} catch (Exception e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public String ValidarUsuario (String usuario) throws Exception{
		String validacion="valido";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuario u where u.usuario= ?");
			stmt.setString(1, usuario);
			rs = stmt.executeQuery();
			if(rs.first()) {
				validacion="invalido";
			}
		
		}catch (SQLException e) {
			AppDataException ade = new AppDataException(e, "Error al validar el usuario.\n"+e.getSQLState()+":"+e.getMessage(), Level.WARN);
			throw ade;
		} catch (Exception e){
			throw e;
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return validacion;		
	}
	
}
