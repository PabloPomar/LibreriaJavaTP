package servletMail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlMail;
import entidades.Libro;
import entidades.Mail;
import util.Emailer;
import util.AppDataException;

/**
 * Servlet implementation class EnviarMail
 */
@WebServlet("/EnviarMail")
public class EnviarMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarMail() {
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
		Libro libro = (Libro)request.getAttribute("nuevoLibro");
		CtrlMail ctrl = new CtrlMail();
		ArrayList<Mail> mails = new ArrayList<Mail>();
		PrintWriter pwriter=response.getWriter(); 
		String tema = "Nuevo libro del autor " + libro.getAutor().getNombre();
		String mensaje = "Desde Libreria Autores queremos informarte que se ah agregado un nuevo libro del autor " + libro.getAutor().getNombre() + "\n Visite la pagina para mas detalles" ;
		
		try {
			mails = ctrl.getAllByIdAutor(libro.getAutor().getIdAutor());
			if( mails.isEmpty() ) {
				pwriter.println("Libro Agregado. No hay mails para enviar");
			} 
			else {
				for (Mail m : mails ) {
					Emailer.getInstance().send(m.getMail(), tema, mensaje); /*Esto no funciono en el server por que la version de jdk me desactivo el api de Javax */
					pwriter.println("Libro Agregado. Mensajes enviados");
				}
			}
			pwriter.write("<form action=\"NuevoLibro.jsp\">\r\n" + 
					"  <input type=\"submit\" value=\"Volver\">\r\n" + 
					"</form> ");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pwriter.println("Los mails no se han podido enviar");
		}
		
		
		
	}

}
