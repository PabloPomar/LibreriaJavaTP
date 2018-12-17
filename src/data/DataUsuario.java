package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Usuario;
import util.AppDataException;

public class DataUsuario {

	public Usuario getLogedUser(Usuario usuario) {
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idUsuario, tipo, nombreYApellido, dni, direccion, telefono, mail from Usuario where usuario= ? and contraseña= ?");
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getContraseña());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				    u=new Usuario();
				    u.setIdUsuario(rs.getInt("idUsuario"));
				    u.setTipo(rs.getString("tipo"));
				    u.setNombreYapellido(rs.getString("nombreYApellido"));
				    u.setDni(rs.getInt("dni"));
				    u.setDireccion(rs.getString("direccion"));
				    u.setTelefono(rs.getInt("telefono"));
				    u.setMail(rs.getString("mail"));
			}
			
		} catch (SQLException | AppDataException e) {
			throw e;
			
		} finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (final SQLException e) {
				
				e.printStackTrace();
		}

		return u;
				}
	}

	
}
