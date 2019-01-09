package Carrito;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.FacturaVenta;
import entidades.LineaVenta;
import entidades.Usuario;

/**
 * Servlet implementation class RegistrarCompra
 */
@WebServlet("/RegistrarCompra")
public class RegistrarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarCompra() {
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
		int clave = 1155;
		int cantPropia = 0;
		int cantConsignada = 0;
		int cantidad = 0;
		ArrayList<LineaVenta> lineas =  new ArrayList<LineaVenta>();
		PrintWriter pwriter=response.getWriter();
		Usuario user = (Usuario) request.getSession().getAttribute("usuarioActual");
		FacturaVenta facVen = (FacturaVenta) request.getSession().getAttribute("facturaActual");
		Carrito carrito = (Carrito) request.getSession().getAttribute("carritoActual");
		
		try {
			clave = ctrl.addmasClave(facVen);
			facVen.setNroFacturaVenta(clave);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pwriter.println("La factura no se pudo agregar");
			e.printStackTrace();
		}
		
		lineas = carrito.getItems();
		
		for (LineaVenta lv : lineas) {
			lv.setFactura(facVen);
			cantPropia = lv.getLibro().getCantidadPropia();
			cantConsignada = lv.getLibro().getCantidadConsignada();
			cantidad = lv.getCantidad();
			try {
				ctrl.addLV(lv);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				pwriter.println("La linea no se pudo agregar");
				e.printStackTrace();
			}
			if (cantidad > cantConsignada) {
				try {
					ctrl.updateCantConsignada(lv.getLibro(), cantConsignada*-1 );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					pwriter.println("La cantidad consisgnada no se pudo actualizar");
					e.printStackTrace();
				}
				cantidad = cantidad-cantConsignada;	
				cantidad = cantidad * -1;
				try {
					ctrl.updateCantPropia(lv.getLibro(), cantidad);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					pwriter.println("La cantidad propia no se pudo actualizar");
					e.printStackTrace();
				}
				
			}
			
			else {
				cantidad = cantidad * -1;
				try {
					ctrl.updateCantConsignada(lv.getLibro(), cantidad);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					pwriter.println("La cantidad consignada no se pudo actualizar");
					e.printStackTrace();
				}
				
			}
			
			
		}

		getServletConfig().getServletContext().getRequestDispatcher("/PaginaFacturaVenta.jsp").forward(request,response);
		
		
	}

}
