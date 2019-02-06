package data;

public class FactoryConnectionDummy {

	/* Esta clase existe por si necesitamos recuperar el factoy conecction Antiguo. No hace nada */
	
	/*    package data;
import java.sql.*;
import java.util.Properties;

import org.apache.logging.log4j.Level;

import util.AppDataException;


public class FactoryConexion {
	
	private String host="localhost";
	
	private String port="3306";
	
	// The name of the MySQL account to use (or empty for anonymous)
	private final String userName = "root";

	// The password for the MySQL account (or empty for anonymous) 
	private final String password = "admin";

	// The name of the database we are testing with (this default is installed with MySQL) 
	private final String dbName = "autores";
	

	
	Properties connectionProps = new Properties();

	
	private static FactoryConexion instancia;
		
	private FactoryConexion(){
		try {
		      Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static FactoryConexion getInstancia(){
		if (FactoryConexion.instancia == null){		
			FactoryConexion.instancia=new FactoryConexion();
		}
		return FactoryConexion.instancia;
		
	}
	
	private Connection conn;
	private int cantConn=0;
	public Connection getConn() throws SQLException,AppDataException{
		try {
			if(conn==null || conn.isClosed()){
				connectionProps.put("user", this.userName);
				connectionProps.put("password", this.password);
				connectionProps.put("useJDBCCompliantTimezoneShift", true);
				connectionProps.put("useLegacyDatetimeCode", false);
				connectionProps.put("serverTimezone", "UTC");
				conn = DriverManager.getConnection(
			        "jdbc:mysql://"+host+":"+port+"/"+dbName,connectionProps);			
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base de datos", Level.ERROR);
		}
		cantConn++;
		return conn;
	}
	
	public void releaseConn() throws SQLException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	

}  */
	
	
	
	
	
}
