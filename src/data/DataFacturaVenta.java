package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.FacturaCompra;
import entidades.FacturaVenta;
import entidades.Libro;
import util.AppDataException;



public class DataFacturaVenta {

	
	public int getNroMaxFactura() throws Exception {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int maxNro = 1;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select max(nroFacturaVenta) as max from factura_venta");
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				
				 maxNro = rs.getInt("max");
			}
			
		} catch (Exception e) {
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
		return maxNro;
	}
	

	
	public int addmasClave(FacturaVenta fv) throws Exception{
		PreparedStatement stmt=null;
		java.util.Date uFecha = new java.util.Date();
		uFecha = fv.getFechaEmision();
		int clave=1155;
		java.sql.Date sqlFecha = convertUtilToSql(uFecha);
		ResultSet keyResultSet=null;	
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("INSERT INTO factura_venta (fechaEmision, idUsuario, cuitLibreria) VALUES (?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, sqlFecha);
			stmt.setInt(2, fv.getUsuario().getIdUsuario());
			stmt.setInt(3, fv.getLibreria().getCuit());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				fv.setNroFacturaVenta(keyResultSet.getInt(1));
				clave=keyResultSet.getInt(1);
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
		return clave;
		
	}
	
	
	
	
	
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	
	
	
}
