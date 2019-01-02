package ServletListadoDeLibros;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlListadoLibros;
import entidades.Libro;

/**
 * Servlet implementation class ListadoLibros
 */
@WebServlet("/ListadoLibros")
public class ListadoLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoLibros() {
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
		CtrlListadoLibros ctrl = new CtrlListadoLibros();	
		ArrayList<Libro> libros = new ArrayList<Libro>();
		PrintWriter pwriter=response.getWriter(); 
		String titulo = request.getParameter("aTitulo");
		try {
			libros = ctrl.getByTitulo(titulo);
			libros = ctrl.sortByTitulo(libros);		
			request.setAttribute( "listaLibros", libros);
			request.getRequestDispatcher("/ListaDeLibros.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pwriter.println("Los libros no se han buscado");
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
