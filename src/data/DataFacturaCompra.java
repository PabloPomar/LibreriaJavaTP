package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.*;
import util.AppDataException;

public class DataFacturaCompra {
	
	
	public void add(FacturaCompra fc) throws Exception{
		PreparedStatement stmt=null;
		java.util.Date uFecha = new java.util.Date();
		uFecha = fc.getFechaEmision();
		 java.sql.Date sqlFecha = convertUtilToSql(uFecha);
		try {
			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("INSERT INTO factura_compra (nroFacturaCompra, fechaEmision, idProveedor, cuit) VALUES (?, ?, ?, ?)");	
			stmt.setInt(1, fc.getNroFacturaCompra());
			stmt.setDate(2, sqlFecha);
			stmt.setInt(3, fc.getProveedor().getIdProveedor());
			stmt.setInt(4, fc.getLibreria().getCuit());
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
	
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	

}
