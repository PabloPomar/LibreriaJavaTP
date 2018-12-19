package ServletFactura;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import controlador.*;
import entidades.*;

/**
 * Servlet implementation class FacturaPreGenerador
 */
@WebServlet("/FacturaPreGenerador")
public class FacturaPreGenerador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaPreGenerador() {
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
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		ArrayList<Libreria> librerias = new ArrayList<Libreria>();
		
		try {
			proveedores = ctrl.getAllProveedor();
			ctrl.sortByRazonSocial(proveedores);
			librerias = ctrl.getAllLibreria();
			request.setAttribute("proveedoresLista", proveedores);
			request.setAttribute("libreriasLista", librerias);
			getServletConfig().getServletContext().getRequestDispatcher("/FacturasGenerador.jsp").forward(request,response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
