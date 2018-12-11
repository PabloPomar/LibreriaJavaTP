package servletCrudAutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.*;
import entidades.*;


/**
 * Servlet implementation class ConsultarAutores
 */
@WebServlet("/ConsultarAutores")
public class ConsultarAutores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarAutores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlAMBCAutor ctrl= new CtrlAMBCAutor();
		PrintWriter pwriter=response.getWriter(); 
		ArrayList<Autor> autoresServlet = new ArrayList<Autor>();	
		try {
			String tabla ="<html><head><link rel=\"stylesheet\" href=\"Estilos/Estilos.css\"></head>";
			tabla+= "<table class=tablaGris><tr><th>Id Autor</th> <th>Nombre</th> </tr>" ;
			autoresServlet=ctrl.getAll();
			for (Autor cadena : autoresServlet) {
				int idAut = cadena.getIdAutor();
				String nombreAut = cadena.getNombre();
				tabla += "<tr><td>" +idAut + "</td> <td> " +nombreAut+ "</td> </tr>"; 				
			}
			pwriter.println(tabla);
			pwriter.write("<div class=\"wrapperRight\"> <form action=\"PrincipalCRUDAutor.html\">\r\n" + 
					"	<input type=\"submit\" class=botonGris value=\"Volver\" >\r\n" + 
					"</form> </div> </html> ");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
