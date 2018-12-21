package ServletFactura;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlFacturas;
import entidades.FacturaCompra;
import entidades.Libreria;
import entidades.Libro;
import entidades.LineaCompra;
import entidades.Proveedor;

/**
 * Servlet implementation class RegistrarFactura
 */
@WebServlet("/RegistrarFactura")
public class RegistrarFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarFactura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlFacturas ctrl= new CtrlFacturas();
		Proveedor prove = new Proveedor();
		Libreria libre = new Libreria();
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String fecha;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		FacturaCompra factura = new FacturaCompra();
		PrintWriter pwriter=response.getWriter();
		
		
		
		int nroFactura = Integer.parseInt(request.getParameter("aNroFactura"));	
		factura.setNroFacturaCompra(nroFactura);
		int cantItems = Integer.parseInt(request.getParameter("aCantItems")) ;
		
		int idProveedor = Integer.parseInt(request.getParameter("aProveedorId"));
		prove.setIdProveedor(idProveedor);
		factura.setProveedor(prove);
		
		int LibreriaCuit = Integer.parseInt(request.getParameter("aLibreriaCuit"));	
		libre.setCuit(LibreriaCuit);
		factura.setLibreria(libre);
		
		fecha = request.getParameter("aFechaEmision");
		try {
			java.util.Date fechaP = sdf1.parse(fecha);
			java.sql.Date fechaSql = new java.sql.Date(fechaP.getTime()); 
			factura.setFechaEmision(fechaSql);
		} catch (ParseException e) {
			pwriter.println("Las Fecha no se han agregado");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ctrl.add(factura);
		} catch (Exception e) {
			pwriter.println("Las Factura no se han agregado");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0; i<cantItems; i++) {
			LineaCompra linea = new LineaCompra();
			Libro lib = new Libro();
			int idLibro = Integer.parseInt(request.getParameter("aIdLibro"+i));
			lib.setIdLibro(idLibro);
			linea.setLibro(lib);
			int cantidad = Integer.parseInt(request.getParameter("aCantidad"+i));
			linea.setCantidad(cantidad);
			linea.setFactura(factura);
			try {
				ctrl.updateCantPropia(lib, cantidad);
				ctrl.addLC(linea);
				pwriter.println("Lineas Agregadas");
				pwriter.write("<form action=\"FacturasPrePagina.jsp\">\r\n" + 
						"  <input type=\"submit\" value=\"Volver\">\r\n" + 
						"</form> ");
				
			} catch (Exception e) {
				pwriter.println("Las lineas no se han agregado");
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}

}
