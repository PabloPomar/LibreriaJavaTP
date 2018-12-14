package data;
import java.util.ArrayList;
import entidades.*;
import util.AppDataException;
import java.sql.*;


public class DataLinea {
	
	public  ArrayList<LineaCompra> getLineasCompra(Date fini, Date ffin) throws Exception {
		PreparedStatement stmt=null;
		ResultSet rs=null;	
		ArrayList<LineaCompra> lineasCompra = new ArrayList<LineaCompra>();

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select lc.idLineaCompra, lc.cantCompra, l.*, fc.nroFacturaCompra, fc.fechaEmision, p.*, lib.*, a.nombreAutor  from linea_compra lc \r\n" + 
					"inner join factura_compra fc on lc.nroFacturaCompra = fc.nroFacturaCompra\r\n" + 
					"inner join libro l on lc.idLibro = l.idLibro\r\n" + 
					"inner join proveedor p on fc.idProveedor = p.idProveedor\r\n" + 
					"inner join libreria lib on lib.cuitLibreria = fc.cuit\r\n" + 
					"inner join autor a on l.idAutor = a.idAutor\r\n" + 
					"where fc.fechaEmision >=? and fc.fechaEmision <=?");
			stmt.setDate(1, fini);
			stmt.setDate(2, ffin);
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					
					/* creamos las variables que vamos a necesitar */
					
					LineaCompra linea= new LineaCompra();
					FacturaCompra fc = new FacturaCompra();
					Libro l = new Libro();
					Proveedor prove = new Proveedor();
					Libreria libre= new Libreria();
					Autor a = new Autor();
					
					/*Obtenemos los datos de la linea  */
					linea.setIdLineaCompra(rs.getInt("lc.idLineaCompra"));
					linea.setCantidad(rs.getInt("lc.cantCompra"));
					
					/* obtenemos los datos de la factura de compra */
					fc.setNroFacturaCompra(rs.getInt("fc.nroFacturaCompra"));
					fc.setFechaEmision(rs.getDate("fc.fecha_emision"));
					
					/* Obtenemos los datos del libro */
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
					
					/*Obtenemos los datos del autor  */
					
					a.setIdAutor(rs.getInt("l.idAutor"));
					a.setNombre(rs.getString("a.nombreAutor"));
					
					
					/*Obtenemos los datos del proveedor */
					
					prove.setIdProveedor(rs.getInt("p.idProveedor"));
					prove.setRazonSocial(rs.getString("p.razonSocial"));
					prove.setTelefono(rs.getInt("p.telefono"));
					prove.setMail(rs.getString("p.mail"));
					prove.setDireccion(rs.getString("p.direccion"));
					
					
					/*Obtenemos los datos de la libreria */
					
					libre.setCuit(rs.getInt("lib.cuitLibreria"));
					libre.setRazonSocial(rs.getString("lib.razon_social"));
					libre.setTelefonoLibreria(rs.getInt("lib.telefono"));
					libre.setMailLibreria(rs.getString("lib.mail"));
					libre.setDireccionLibreria(rs.getString("direccion"));
					
					/* Gregamos las subclases a los objetos */
					
					l.setAutor(a);
					fc.setLibreria(libre);
					fc.setProveedor(prove);
					linea.setFactura(fc);
					linea.setLibro(l);
					
					/* Agregamos la linea a la coleccion */
					
					lineasCompra.add(linea);	
				}	
			}		
		}  catch (Exception e) {
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
		return lineasCompra;
	}
	
	
	public  ArrayList<LineaRemito> getLineasRemito(Date fini, Date ffin) throws Exception {
		PreparedStatement stmt=null;
		ResultSet rs=null;	
		ArrayList<LineaRemito> lineasRemito = new ArrayList<LineaRemito>();

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select lr.idLinea_remito, lr.cantidad_remito, l.*, rem.idRemito, rem.fecha_emision_remito, p.*, lib.*, a.nombreAutor  \r\n" + 
					"from linea_remito lr \r\n" + 
					"inner join remito rem on lr.idRemito = rem.idRemito\r\n" + 
					"inner join libro l on lr.idLibro = l.idLibro\r\n" + 
					"inner join proveedor p on rem.idProveedor = p.idProveedor\r\n" + 
					"inner join libreria lib on lib.cuitLibreria = rem.cuit\r\n" + 
					"inner join autor a on l.idAutor = a.idAutor\r\n" + 
					"where rem.fecha_emision_remito >=? and rem.fecha_emision_remito <= ?");
			stmt.setDate(1, fini);
			stmt.setDate(2, ffin);
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					
					/* creamos las variables que vamos a necesitar */
					
					LineaRemito linea= new LineaRemito();
					Remito rem = new Remito();
					Libro l = new Libro();
					Proveedor prove = new Proveedor();
					Libreria libre= new Libreria();
					Autor a = new Autor();
					
					/*Obtenemos los datos de la linea  */
					linea.setIdLineaRemito(rs.getInt("lr.idLinea_remito"));
					linea.setCantidad(rs.getInt("lr.cantidad_remito"));
					
					/* obtenemos los datos del remito */
					rem.setIdRemito(rs.getInt("rem.idRemito"));
					rem.setFechaEmision(rs.getDate("rem.fecha_emision_remito"));
					
					/* Obtenemos los datos del libro */
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
					
					/*Obtenemos los datos del autor  */
					
					a.setIdAutor(rs.getInt("l.idAutor"));
					a.setNombre(rs.getString("a.nombreAutor"));
					
					
					/*Obtenemos los datos del proveedor */
					
					prove.setIdProveedor(rs.getInt("p.idProveedor"));
					prove.setRazonSocial(rs.getString("p.razonSocial"));
					prove.setTelefono(rs.getInt("p.telefono"));
					prove.setMail(rs.getString("p.mail"));
					prove.setDireccion(rs.getString("p.direccion"));
					
					
					/*Obtenemos los datos de la libreria */
					
					libre.setCuit(rs.getInt("lib.cuitLibreria"));
					libre.setRazonSocial(rs.getString("lib.razon_social"));
					libre.setTelefonoLibreria(rs.getInt("lib.telefono"));
					libre.setMailLibreria(rs.getString("lib.mail"));
					libre.setDireccionLibreria(rs.getString("direccion"));
					
					/* Gregamos las subclases a los objetos */
					
					l.setAutor(a);
					rem.setLibreria(libre);
					rem.setProveedor(prove);
					linea.setRemito(rem);
					linea.setLibro(l);
					
					/* Agregamos la linea a la coleccion */
					
					lineasRemito.add(linea);	
				}	
			}		
		}  catch (Exception e) {
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
		return lineasRemito;
	}
	
	
	public  ArrayList<LineaVenta> getLineasVenta(Date fini, Date ffin) throws Exception {
		PreparedStatement stmt=null;
		ResultSet rs=null;	
		ArrayList<LineaVenta> lineasVenta = new ArrayList<LineaVenta>();

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select  lv.idLineaVenta, lv.cantidad, l.*, a.nombreAutor, fv.nroFacturaVenta, fv.fechaEmision, u.*, lib.*\r\n" + 
					"from linea_venta lv\r\n" + 
					"inner join libro l on lv.idLibro = l.idLibro\r\n" + 
					"inner join autor a on l.idAutor = a.idAutor\r\n" + 
					"inner join factura_venta fv on lv.nroFacturaVenta = fv.nroFacturaVenta\r\n" + 
					"inner join usuario u on fv.idUsuario= u.idUsuario\r\n" + 
					"inner join libreria lib on lib.cuitLibreria = fv.cuitLibreria\r\n" + 
					"where fv.fechaEmision >=? and  fv.fechaEmision <=?");
			stmt.setDate(1, fini);
			stmt.setDate(2, ffin);
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					
					/* creamos las variables que vamos a necesitar */
					
					LineaVenta linea= new LineaVenta();
					FacturaVenta fv= new FacturaVenta();
					Libro l = new Libro();
					Usuario u = new Usuario();
					Libreria libre= new Libreria();
					Autor a = new Autor();
					
					/*Obtenemos los datos de la linea  */
					linea.setIdLineaVenta(rs.getInt("lv.idLineaVenta"));
					linea.setCantidad(rs.getInt("lv.cantidad"));
					
					/* obtenemos los datos de la factura de venta*/
					
					fv.setNroFacturaVenta(rs.getInt("fv.nroFacturaVenta"));
					fv.setFechaEmision(rs.getDate("fv.fechaEmision"));
					
					
					/* Obtenemos los datos del libro */
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
					
					/*Obtenemos los datos del autor  */
					
					a.setIdAutor(rs.getInt("l.idAutor"));
					a.setNombre(rs.getString("a.nombreAutor"));
					
					
					/*Obtenemos los datos del usuario */
					
					u.setIdUsuario(rs.getInt("u.idUsuario"));
					u.setTipo(rs.getString("u.tipo"));
					u.setUsuario(rs.getString("u.usuario"));
					u.setContraseña(rs.getString("u.contraseña"));
					u.setNombreYapellido(rs.getString("u.nombreYApellido"));
					u.setDni(rs.getInt("u.dni"));
					u.setDireccion(rs.getString("u.direccion"));
					u.setTelefono(rs.getInt("u.telefono"));
					u.setMail(rs.getString("u.mail"));
	
					
					/*Obtenemos los datos de la libreria */
					
					libre.setCuit(rs.getInt("lib.cuitLibreria"));
					libre.setRazonSocial(rs.getString("lib.razon_social"));
					libre.setTelefonoLibreria(rs.getInt("lib.telefono"));
					libre.setMailLibreria(rs.getString("lib.mail"));
					libre.setDireccionLibreria(rs.getString("direccion"));
					
					/* Gregamos las subclases a los objetos */
					
					l.setAutor(a);
					fv.setLibreria(libre);
					fv.setUsuario(u);
					linea.setFactura(fv);
					linea.setLibro(l);
					
					/* Agregamos la linea a la coleccion */
					
					lineasVenta.add(linea);	
				}	
			}		
		}  catch (Exception e) {
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
		return lineasVenta;
	}
	
	
	
	
	

}
