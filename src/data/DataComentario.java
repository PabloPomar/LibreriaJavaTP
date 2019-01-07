package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.*;
import util.AppDataException;

public class DataComentario {
	
	/* get all de comentarios de un libro */
	
	public ArrayList<Comentario> getByLibro(Libro libro) throws Exception {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Comentario> comentarios = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idComentario, descripcion, fecha_creacion, idUsuario, idLibro, usuario from comentarios where idLibro = ?");
			stmt.setInt(1, libro.getIdLibro());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()){
					comentarios = new ArrayList<Comentario>();
					while (rs.next()) {
						Comentario c = new Comentario();
						Usuario u = new Usuario();
						c.setIdComentario(rs.getInt("idComentario"));
						c.setDescripcion(rs.getString("descripcion"));
						c.setFecha_creacion(rs.getDate("fecha_creacion"));
						c.setLibro(libro);
						u.setIdUsuario(rs.getInt("idUsuario"));
						u.setUsuario(rs.getString("usuario"));
						c.setUsuario(u);
					}
			}	
		
		} catch(Exception e) {
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
		return comentarios;
	}
	
	/* agregar Comentario*/
	
	public void addComentario(Comentario c) throws Exception {
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into comentario (descripcion, fecha_creacion, idUsuario, idLibro, usuario) values (?,?,?,?,?)");
			stmt.setString(1, c.getDescripcion());
			stmt.setDate(2, (Date) c.getFecha_creacion());
			stmt.setInt(3, c.getUsuario().getIdUsuario());
			stmt.setInt(4, c.getLibro().getIdLibro());
			stmt.setString(5, c.getUsuario().getUsuario());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				c.setIdComentario(keyResultSet.getInt(1));
			}
			
		} catch (SQLException | AppDataException e) {
			throw e;
		} finally {
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
	
	/* borrar comentario */
	
	public void remove(Comentario c) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("delete from comnetario where idComentario = ?");
			stmt.setInt(1, c.getIdComentario());
			stmt.executeUpdate();
		}  catch (SQLException | AppDataException e) {
			throw e;
			}
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
	}	
	
}
