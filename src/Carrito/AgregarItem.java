package Carrito;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlAMBCLibro;
import entidades.*;

/**
 * Servlet implementation class AgregarItem
 */
@WebServlet("/AgregarItem")
public class AgregarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarItem() {
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
		CtrlCarrito ctrl = new CtrlCarrito();
		int idLibro = Integer.parseInt(request.getParameter("aIdLibro")) ;
		int cantidad = Integer.parseInt(request.getParameter("aCantidad"));
		Libro libro = new Libro();
		PrintWriter pwriter=response.getWriter(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fechaActual = new Date();
		LineaVenta lineaV = new LineaVenta();
		
		Usuario user = (Usuario) request.getSession().getAttribute("usuarioActual");
		FacturaVenta facVen = (FacturaVenta) request.getSession().getAttribute("facturaActual");
		Carrito carrito = (Carrito) request.getSession().getAttribute("carritoActual");
		
		if( user == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);	
		}
		
		else {
			
			
			try {
				libro = ctrl.getById(idLibro);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pwriter.println("Libro no encontrado");
			}
			
			
			if (facVen==null) {
				
				ArrayList <Libreria> librerias = new ArrayList<Libreria>();
				FacturaVenta fV = new FacturaVenta();
				fV.setFechaEmision(fechaActual);
				
				try {
					librerias = ctrl.getAllLibreria();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					pwriter.println("La factura no se pudo generar");
					e.printStackTrace();
				}
				fV.setLibreria(librerias.get(0));
				fV.setUsuario(user);
				request.getSession().setAttribute("facturaActual", fV);
				facVen= fV;
					
			}
	
				 lineaV.setFactura(facVen);
				 lineaV.setCantidad(cantidad);
				 lineaV.setLibro(libro);
				
		
			
			if (carrito == null) {
				
				carrito = new Carrito();
				request.getSession().setAttribute("carritoActual", carrito);
				
			}
			
			carrito.agregarLinea(lineaV);
			getServletConfig().getServletContext().getRequestDispatcher("/PaginaCarrito.jsp").forward(request,response);
		
		}
		
		
	}

}
