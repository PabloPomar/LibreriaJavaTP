package Carrito;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoverItem
 */
@WebServlet("/RemoverItem")
public class RemoverItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemIndex = Integer.parseInt(request.getParameter("aItemIndex"));
		System.out.println(itemIndex);
		Carrito carrito = (Carrito) request.getSession().getAttribute("carritoActual");
		
		if (carrito == null) {
			
			carrito = new Carrito();
			request.getSession().setAttribute("carritoActual", carrito);
			
		}
		
		carrito.removerLinea(itemIndex);
		getServletConfig().getServletContext().getRequestDispatcher("/PaginaCarrito.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int itemIndex = Integer.parseInt(request.getParameter("aItemIndex"));
		System.out.println(itemIndex);
		Carrito carrito = (Carrito) request.getSession().getAttribute("carritoActual");
		
		if (carrito == null) {
			
			carrito = new Carrito();
			request.getSession().setAttribute("carritoActual", carrito);
			
		}
		
		carrito.removerLinea(itemIndex);
		getServletConfig().getServletContext().getRequestDispatcher("/PaginaCarrito.jsp").forward(request,response);
		
		
	}

}
