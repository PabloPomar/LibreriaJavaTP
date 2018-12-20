package ServletFactura;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;

import controlador.*;
import entidades.*;



/**
 * Servlet implementation class FacturaGenerador
 */
@WebServlet("/FacturaGenerador")
public class FacturaGenerador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaGenerador() {
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
		
		int nroFactura = Integer.parseInt(request.getParameter("aNroFactura"));	
		int cantItems = Integer.parseInt(request.getParameter("aCantItems")) ;
		
		int idProveedor = Integer.parseInt(request.getParameter("aProveedorId"));
		int LibreriaCuit = Integer.parseInt(request.getParameter("aLibreriaCuit"));
		
			
		/* obtenemos la fecha */
		
		String dia1 = request.getParameter("aDia");
		int diaint = Integer.parseInt(dia1);
		String mes1 = request.getParameter("aMes");
		int mesint = Integer.parseInt(mes1);
		String año1 = request.getParameter("aAño");
		int añoint = Integer.parseInt(año1);
		
		
		Calendar cal = Calendar.getInstance();
		cal.clear();
	    cal.set(Calendar.YEAR, añoint);
	    cal.set(Calendar.MONTH, mesint - 1);
	    cal.set(Calendar.DATE, diaint);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    
	    java.sql.Date fecha = new java.sql.Date(cal.getTime().getTime());
	    
	    try {
			prove = ctrl.getProveedorById(idProveedor);
			libre = ctrl.getLibreriaByCuit(LibreriaCuit);
			request.setAttribute("proveedorInfo", prove);
			request.setAttribute("libreriaInfo", libre);
			request.setAttribute("fechaInfo", fecha);
			request.setAttribute("cantidadInfo", cantItems);
			request.setAttribute("nroFacturaInfo", nroFactura);
			getServletConfig().getServletContext().getRequestDispatcher("/FacturaRegistro.jsp").forward(request,response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		
		
	}

}
