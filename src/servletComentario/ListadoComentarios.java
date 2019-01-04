package servletComentario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlAMBCLibro;
import controlador.CtrlComentario;
import entidades.Comentario;
import entidades.Libro;

/**
 * Servlet implementation class ListadoComentarios
 */
@WebServlet(description = "Lista de Comentarios según libro", urlPatterns = { "/ListadoComentarios" })
public class ListadoComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoComentarios() {
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
		CtrlComentario ctrlComentario = new CtrlComentario();
		CtrlAMBCLibro ctrlLibro = new CtrlAMBCLibro();
		ArrayList<Comentario> comentarios = null;
		Libro libro = new Libro();
		PrintWriter pwriter=response.getWriter();	
		RequestDispatcher pagina = null;	
		
		try {
			String idLibro = request.getParameter("aIdLibro");
			Libro l = ctrlLibro.getById(Integer.parseInt(idLibro)); /* busca un libro por su ID*/
			comentarios = ctrlComentario.getByLibro(libro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*falta responder el pedido*/
		
	}

}
