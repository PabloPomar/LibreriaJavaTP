package servletCrudLibro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlAMBCLibro;
import entidades.Libro;

/**
 * Servlet implementation class ConsultarLibro
 */
@WebServlet("/ConsultarLibro")
public class ConsultarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarLibro() {
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
		CtrlAMBCLibro ctrl = new CtrlAMBCLibro();
		ArrayList<Libro> libros = new ArrayList<Libro>();
		PrintWriter pwriter=response.getWriter(); 
		String valor=request.getParameter("aValor");
		int valorInt = Integer.parseInt(valor);
		try {
			libros= ctrl.getAll();
			
			
			
			if (valorInt==2) {
				ctrl.sortByTitulo(libros);	
			} else if (valorInt==3) {
				ctrl.sortByNombreAutor(libros);
			}
			
			
			request.setAttribute("lista", libros);
			getServletConfig().getServletContext().getRequestDispatcher("/ConsultarLibrosLista.jsp").forward(request,response);
			
			
		} catch (Exception e) {
			pwriter.println("La consulta no ah sido posible");
			e.printStackTrace();
		}
		
		
		
	}

}
