package servletPaginaPrincipal;

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
import java.util.Random;

/**
 * Servlet implementation class PaginaPrincipal
 */
@WebServlet("/PaginaPrincipal")
public class PaginaPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlAMBCLibro ctrl = new CtrlAMBCLibro();
		ArrayList<Libro> libros = new ArrayList<Libro>();
		PrintWriter pwriter=response.getWriter(); 
		Random rand = new Random();
		int numberOfElements = 3;
		try {
			libros = ctrl.getAll();
		    for (int i = 0; i < numberOfElements; i++) {
		        int randomIndex = rand.nextInt(libros.size());
		        Libro randomElement = libros.get(randomIndex);
		        request.setAttribute("libro" +i, randomElement);
		    }
		    request.getRequestDispatcher("/PaginaPrincipal.jsp").forward(request, response);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pwriter.println("No se ah podido buscar los libros");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
