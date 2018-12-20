package data;
import java.util.ArrayList;
import entidades.*;
import util.AppDataException;
import java.sql.*;



public class DataLibreria {
	
	
	public ArrayList<Libreria> getAll() throws Exception {		
		Statement stmt=null;
		ResultSet rs=null;	
		ArrayList<Libreria> librerias = new ArrayList<Libreria>();	
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from  libreria l");
			if(rs!=null) {
				while(rs.next()) {
					Libreria l = new Libreria();
					int cuit;
					cuit = rs.getInt("l.cuitLibreria");
					l.setCuit(cuit);
					
					l.setRazonSocial(rs.getString("l.razon_social"));
					l.setTelefonoLibreria(rs.getInt("l.telefono"));
					l.setMailLibreria(rs.getString("l.mail"));
					l.setDireccionLibreria(rs.getString("l.direccion"));
					librerias.add(l);	
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
		
		return librerias;
	
	}
	
	
	public Libreria getByCuit(int cuit) throws Exception{
		Libreria l = new Libreria();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from libreria l where cuitLibreria = ? ");
			stmt.setInt(1, cuit);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				l.setCuit(rs.getInt("l.cuitLibreria"));
				l.setRazonSocial(rs.getString("l.razon_social"));
				l.setTelefonoLibreria(rs.getInt("l.telefono"));
				l.setMailLibreria(rs.getString("l.mail"));
				l.setDireccionLibreria(rs.getString("l.direccion"));
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
	
	
	
	
	
	

}
