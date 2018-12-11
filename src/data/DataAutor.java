package data;

import java.util.ArrayList;
import java.util.Collections;

import entidades.*;
import util.AppDataException;

import java.sql.*;
/* Data de Autor */

public class DataAutor {
	
	/* Get All para la Consulta */
	
	public ArrayList<Autor> getAll() throws Exception {		
		Statement stmt=null;
		ResultSet rs=null;	
		ArrayList<Autor> autores = new ArrayList<Autor>();	
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from autor ");
			if(rs!=null) {
				while(rs.next()) {
					Autor a = new Autor();
					a.setIdAutor(rs.getInt("idAutor"));
					a.setNombre(rs.getString("nombreAutor"));
					autores.add(a);		
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
		
		return autores;
	
	}
	
	
	/* Add para agregar nuevos autores  */
	
	public void add(Autor a) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;	
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("insert into autor(nombreAutor) values (?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, a.getNombre());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				a.setIdAutor(keyResultSet.getInt(1));
			}
			
		}  catch (SQLException | AppDataException e) {
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
	
	
	/* Remove para borrar Autores   */
	
	public void remove(Autor a) throws Exception{
		PreparedStatement stmt=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("delete from autor where idAutor=?");
			stmt.setInt(1, a.getIdAutor());
			stmt.executeUpdate();
		}  catch (SQLException | AppDataException e) {
			throw e;
			}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	
	/* Update para actualizar Autores  */
	
	public void update(Autor a) throws Exception{
		PreparedStatement stmt=null; 
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("update autor set nombreAutor=? where idAutor=?");
			stmt.setString(1, a.getNombre());
			stmt.setInt(2,a.getIdAutor());
			stmt.executeUpdate();
		} catch (SQLException | AppDataException e) {
			throw e;
			}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		
	}
	
	/* validar que el id es valido */ 
	
	public String ValidarId (int id) throws Exception{
		String validacion="invalido";
		Statement stmt=null;
		ResultSet rs=null;
		stmt= FactoryConexion.getInstancia().getConn().createStatement();
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from autor a where a.idAutor=" +id);
			if(rs.first()) {
				validacion="valido";
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
		
		return validacion;		
	}
		
	public ArrayList<Autor> getAllSortedByNombre() throws Exception {		
		Statement stmt=null;
		ResultSet rs=null;	
		ArrayList<Autor> autores = new ArrayList<Autor>();	
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from autor");
			if(rs!=null) {
				while(rs.next()) {
					Autor a = new Autor();
					a.setIdAutor(rs.getInt("idAutor"));
					a.setNombre(rs.getString("nombreAutor"));
					autores.add(a);		
				}
				autores.sort((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
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
		
		return autores;
	
	}
	
	

	public Autor getById(int id) throws Exception{
		Autor a=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from autor where idAutor=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					a=new Autor();
					a.setIdAutor(rs.getInt("idAutor"));
					a.setNombre(rs.getString("nombreAutor"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return a;
}
	
	
	
	
	
	

}
