package data;
import java.util.ArrayList;
import entidades.*;
import util.AppDataException;
import java.sql.*;

public class DataProveedor {
	
	
	public ArrayList<Proveedor> getAll() throws Exception {		
		Statement stmt=null;
		ResultSet rs=null;	
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();	
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from proveedor p");
			if(rs!=null) {
				while(rs.next()) {
					Proveedor p = new Proveedor();
					
					p.setIdProveedor(rs.getInt("p.idProveedor"));
					p.setRazonSocial(rs.getString("p.razonSocial"));
					p.setTelefono(rs.getInt("p.telefono"));
					p.setMail(rs.getString("p.mail"));
					p.setDireccion(rs.getString("p.direccion"));
					proveedores.add(p);		
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
		
		return proveedores;
	
	}
	
	
	public ArrayList<Proveedor> SortByRazonSocial(ArrayList<Proveedor> proveedores ) throws Exception {
		
		proveedores.sort((p1, p2) -> p1.getRazonSocial().compareTo(p2.getRazonSocial()));
		return proveedores;	
	}

	
	public Proveedor getById(int id) throws Exception{
		Proveedor p = new Proveedor();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from proveedor p where idProveedor = ?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){		
				p.setIdProveedor(rs.getInt("p.idProveedor"));
				p.setRazonSocial(rs.getString("p.razonSocial"));
				p.setTelefono(rs.getInt("p.telefono"));
				p.setMail(rs.getString("p.mail"));
				p.setDireccion(rs.getString("p.direccion"));
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
		return p;
	}
	
	
	
	
}
