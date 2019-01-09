package data;
import java.util.ArrayList;
import java.util.Arrays;

import entidades.*;
import util.AppDataException;
import java.sql.*;

/* Data de libro */

public class DataLibro {
	
	/* Get all para realizar consultas  */
	
	
	public ArrayList<Libro> getAll() throws Exception {		
		Statement stmt=null;
		ResultSet rs=null;	
		ArrayList<Libro> libros = new ArrayList<Libro>();	
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from libro l inner join autor a on l.idAutor = a.idAutor");
			if(rs!=null) {
				while(rs.next()) {
					Libro l = new Libro();
					Autor a = new Autor();
					
					l.setIdLibro(rs.getInt("l.idLibro"));
					l.setTitulo(rs.getString("l.titulo"));
					l.setNroEdicion(rs.getInt("l.nroEdicion"));
					l.setIsbn(rs.getString("l.isbn"));
					l.setDescripcion(rs.getString("l.descripcion"));
					l.setPrecio(rs.getFloat("l.precio"));
					l.setEditorial(rs.getString("l.editorial"));
					l.setGenero(rs.getString("l.genero"));
					l.setCantidadPropia(rs.getInt("l.cantPropia"));
					l.setCantidadConsignada(rs.getInt("l.cantConsignada"));
					a.setIdAutor(rs.getInt("l.idAutor"));
					a.setNombre(rs.getString("a.nombreAutor"));
					l.setAutor(a);
					libros.add(l);		
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
		
		return libros;
	
	}
	
	
	
	/* add para agregar libros */ 
	
	
	public void add(Libro l) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;	
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("INSERT INTO libro (titulo, nroEdicion, isbn, descripcion, precio, editorial, genero, idAutor, cantPropia, cantConsignada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getTitulo());
			stmt.setInt(2, l.getNroEdicion());
			stmt.setString(3, l.getIsbn());
			stmt.setString(4, l.getDescripcion());
			stmt.setFloat(5, l.getPrecio());
			stmt.setString(6, l.getEditorial());
			stmt.setString(7, l.getGenero());
			stmt.setInt(8, l.getAutor().getIdAutor());
			stmt.setInt(9, l.getCantidadPropia());
			stmt.setInt(10, l.getCantidadConsignada());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				l.setIdLibro(keyResultSet.getInt(1));
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
	
	
	/* Remove para borrar Libros   */
	
	public void remove(Libro l) throws Exception{
		PreparedStatement stmt=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("delete from libro where idLibro=?");
			stmt.setInt(1, l.getIdLibro());
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
	
	/* Metodo para modificar Libros  */
	
	public void update(Libro l) throws Exception{
		PreparedStatement stmt=null; 
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE libro SET titulo = ?, nroEdicion = ?, isbn = ?, descripcion = ?, precio = ?, editorial = ?, genero = ?, idAutor = ?, cantPropia = ?, cantConsignada = ? WHERE idLibro = ?");
			stmt.setString(1, l.getTitulo());
			stmt.setInt(2, l.getNroEdicion());
			stmt.setString(3, l.getIsbn());
			stmt.setString(4, l.getDescripcion());
			stmt.setFloat(5, l.getPrecio());
			stmt.setString(6, l.getEditorial());
			stmt.setString(7, l.getGenero());
			stmt.setInt(8, l.getAutor().getIdAutor());
			stmt.setInt(9, l.getCantidadPropia());
			stmt.setInt(10, l.getCantidadConsignada());
			stmt.setInt(11, l.getIdLibro());
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
	
	/* Metodos de sorting */ 
	
	public ArrayList<Libro> SortByTitulo(ArrayList<Libro> libros ) throws Exception {
		libros.sort((l1, l2) -> l1.getTitulo().compareToIgnoreCase(l2.getTitulo()));	
		return libros;	
	}
	

	
	
	
	public ArrayList<Libro> SortByNombreAutor(ArrayList<Libro> libros ) throws Exception {
		
		libros.sort((l1, l2) -> l1.getAutor().getNombre().compareToIgnoreCase(l2.getAutor().getNombre()));
		return libros;	
	}
	

	/* Obtener por id */
	
	public Libro getById(int id) throws Exception{
		Autor a = new Autor();
		Libro l = new Libro();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from libro l inner join autor a on l.idAutor = a.idAutor where idLibro=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){		
				l.setIdLibro(rs.getInt("l.idLibro"));
				l.setTitulo(rs.getString("l.titulo"));
				l.setNroEdicion(rs.getInt("l.nroEdicion"));
				l.setIsbn(rs.getString("l.isbn"));
				l.setDescripcion(rs.getString("l.descripcion"));
				l.setPrecio(rs.getFloat("l.precio"));
				l.setEditorial(rs.getString("l.editorial"));
				l.setGenero(rs.getString("l.genero"));
				l.setCantidadPropia(rs.getInt("l.cantPropia"));
				l.setCantidadConsignada(rs.getInt("l.cantConsignada"));
				a.setIdAutor(rs.getInt("l.idAutor"));
				a.setNombre(rs.getString("a.nombreAutor"));
				l.setAutor(a);
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
		return l;
	}
	
	
	/* validar que el id es valido */ 
	
	public String ValidarId (int id) throws Exception{
		String validacion="invalido";
		Statement stmt=null;
		ResultSet rs=null;
		stmt= FactoryConexion.getInstancia().getConn().createStatement();
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from libro l  where l.idLibro=" +id);
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
	
	/*  Actualizar las cantidades  */
	
	public void updateCantPropia(Libro l, int cantidad) throws Exception{
		PreparedStatement stmt=null; 
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("update libro set cantPropia = cantPropia+? where idLibro=?;");
			stmt.setInt(1, cantidad);
			stmt.setInt(2, l.getIdLibro());
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
	
	public void updateCantConsignada(Libro l, int cantidad) throws Exception{
		PreparedStatement stmt=null; 
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("update libro set cantConsignada = cantConsignada+? where idLibro=?;");
			stmt.setInt(1, cantidad);
			stmt.setInt(2, l.getIdLibro());
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
	
	
	/* Get all para realizar consultas  */
	
	
	public ArrayList<Libro> getByTitulo( String titulo ) throws Exception {		
		PreparedStatement stmt=null; 
		ResultSet rs=null;	
		ArrayList<Libro> libros = new ArrayList<Libro>();	
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from libro l inner join autor a on l.idAutor = a.idAutor where l.titulo like ? ");
			stmt.setString(1, "%" + titulo + "%");
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Libro l = new Libro();
					Autor a = new Autor();
					
					l.setIdLibro(rs.getInt("l.idLibro"));
					l.setTitulo(rs.getString("l.titulo"));
					l.setNroEdicion(rs.getInt("l.nroEdicion"));
					l.setIsbn(rs.getString("l.isbn"));
					l.setDescripcion(rs.getString("l.descripcion"));
					l.setPrecio(rs.getFloat("l.precio"));
					l.setEditorial(rs.getString("l.editorial"));
					l.setGenero(rs.getString("l.genero"));
					l.setCantidadPropia(rs.getInt("l.cantPropia"));
					l.setCantidadConsignada(rs.getInt("l.cantConsignada"));
					a.setIdAutor(rs.getInt("l.idAutor"));
					a.setNombre(rs.getString("a.nombreAutor"));
					l.setAutor(a);
					libros.add(l);		
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
		
		return libros;
	
	}
	
	
	
}
