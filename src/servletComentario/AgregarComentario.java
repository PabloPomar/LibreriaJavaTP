package servletComentario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlComentario;
import entidades.*;

import java.util.Date;

/**
 * Servlet implementation class AgregarComentario
 */
@WebServlet("/AgregarComentario")
public class AgregarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarComentario() {
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
		CtrlComentario ctrl = new CtrlComentario();
		Comentario comentario = new Comentario();
		PrintWriter pwriter=response.getWriter();	
		int idLibro = Integer.parseInt(request.getParameter("aIdLibro"));
		Usuario user = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		
		if(user == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
			
		}
		else {
		
		comentario.setDescripcion(request.getParameter("aComentario"));
		comentario.setUsuario(user);
		Date fecha = new Date();
		comentario.setFecha_creacion(fecha);
		Libro libro = new Libro();
		libro.setIdLibro(idLibro);
		comentario.setLibro(libro);
		RequestDispatcher pagina = null;	
		
		try {
			ctrl.addComentario(comentario);
			request.removeAttribute("libroActual");
			request.setAttribute("libroActual", libro);
			pagina = request.getServletContext().getRequestDispatcher("/PaginaLibro.jsp");
			pagina.forward(request, response);
			
		} catch (Exception e) {
			pwriter.println("El comentario no se pudo agregar");
			e.printStackTrace();
		}
		
		
		}
	}

}
