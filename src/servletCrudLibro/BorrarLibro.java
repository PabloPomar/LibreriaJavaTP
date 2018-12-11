package servletCrudLibro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlAMBCAutor;
import controlador.CtrlAMBCLibro;
import entidades.Autor;
import entidades.Libro;

/**
 * Servlet implementation class BorrarLibro
 */
@WebServlet("/BorrarLibro")
public class BorrarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarLibro() {
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
		Libro libro = new Libro();
		PrintWriter pwriter=response.getWriter(); 
		String id = request.getParameter("aIdLibro");
		int idInt = Integer.parseInt(id);
		libro.setIdLibro(idInt);
		try {
			ctrl.delete(libro);
			pwriter.println("Libro Borrado");
			pwriter.write("<form action=\"BorrarLibro.jsp\">\r\n" + 
					"  <input type=\"submit\" value=\"Volver\">\r\n" + 
					"</form>  ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pwriter.println("El libro no ha sido Borrado");
			e.printStackTrace();
		}
		
		
		
	}

}
