package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



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
	
	
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	
	
	
}
