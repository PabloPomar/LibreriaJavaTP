package servletCrudAutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.*;
import entidades.*;


/**
 * Servlet implementation class BorrarAutor
 */
@WebServlet("/BorrarAutor")
public class BorrarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarAutor() {
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
		String id = request.getParameter("idAutor");
		PrintWriter pwriter=response.getWriter(); 
		int idInt = Integer.parseInt(id);
		autor.setIdAutor(idInt);
		
		
		try {
			String validacion=null;
			validacion = ctrl.validarId(idInt);
			
			if(validacion.equals("valido")) {
			ctrl.delete(autor);
			pwriter.println("Autor Borrado");
			pwriter.write("<form action=\"BorrarAutor.jsp\">\r\n" + 
					"  <input type=\"submit\" value=\"Volver\">\r\n" + 
					"</form>  ");
			}
			else {
				pwriter.println("El id no se corresponde con ningun autor");
				pwriter.write("<form action=\"BorrarAutor.jsp\">\r\n" + 
						"  <input type=\"submit\" value=\"Volver\">\r\n" + 
						"</form>  ");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pwriter.println("el autor no se a borrado");
			e.printStackTrace();
		}
		
				
	}

}
