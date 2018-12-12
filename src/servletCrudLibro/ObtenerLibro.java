package servletCrudLibro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlAMBCLibro;
import entidades.Libro;

/**
 * Servlet implementation class ObtenerLibro
 */
@WebServlet("/ObtenerLibro")
public class ObtenerLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerLibro() {
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
		PrintWriter pwriter=response.getWriter(); 
		Libro libro= new Libro();
		String idLibro = request.getParameter("aIdLibro");
		String validacion;
		int idLibroInt = Integer.parseInt(idLibro);
		try {
			libro = ctrl.getById(idLibroInt);
			validacion= ctrl.validarId(idLibroInt);
			if (validacion.equals("valido")) {	
			request.setAttribute("libroVar", libro);
			getServletConfig().getServletContext().getRequestDispatcher("/ModificarLibroFormulario.jsp").forward(request,response); 
			}
			else {
				
				pwriter.println("El id del libro no se corresponde con ningun id de la base de datos");
				pwriter.write("<form action=\"ModificarLibro.jsp\">\r\n" + 
						"  <input type=\"submit\" value=\"Volver\">\r\n" + 
						"</form> ");
				
			}
			
		} catch (Exception e) {
			pwriter.println("el id no se corresponde con ningun libro");
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
