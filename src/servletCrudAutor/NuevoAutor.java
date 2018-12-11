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
import data.*;

/**
 * Servlet implementation class NuevoAutor
 */
@WebServlet("/NuevoAutor")
public class NuevoAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoAutor() {
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
		String nombre = request.getParameter("aName");
		autor.setNombre(nombre);
		try {
			ctrl.add(autor);
			pwriter.println("Autor Agregado");
			pwriter.write("<form action=\"NuevoAutor.jsp\">\r\n" + 
					"  <input type=\"submit\" value=\"Volver\">\r\n" + 
					"</form> ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pwriter.println("el autor no se a agregado");
			e.printStackTrace();
		}

		
	}

}
