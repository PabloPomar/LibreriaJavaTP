package servletCrudAutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlAMBCAutor;
import entidades.Autor;

/**
 * Servlet implementation class ModificarAutor
 */
@WebServlet("/ModificarAutor")
public class ModificarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarAutor() {
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
		CtrlAMBCAutor ctrl= new CtrlAMBCAutor();
		Autor autor= new Autor();
		PrintWriter pwriter=response.getWriter(); 
		String id = request.getParameter("idAutor");
		int idInt = Integer.parseInt(id);
		String nombre = request.getParameter("nombreNuevo");
		autor.setIdAutor(idInt);
		autor.setNombre(nombre);
		
		try {
			String validacion=null;
			validacion = ctrl.validarId(idInt);
			if(validacion.equals("valido")) {
			ctrl.update(autor);
			pwriter.println("Autor Modificado");
			pwriter.write("<form action=\"ModificarAutor.jsp\">\r\n" + 
					"  <input type=\"submit\" value=\"Volver\">\r\n" + 
					"</form> ");
			}
			else {
				pwriter.println("El id del autor no se corresponde con ningun id de la base de datos");
				pwriter.write("<form action=\"ModificarAutor.jsp\">\r\n" + 
						"  <input type=\"submit\" value=\"Volver\">\r\n" + 
						"</form> ");		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pwriter.println("el autor no existe o no se a modificado");
			e.printStackTrace();
		}
		
		
	}

}
