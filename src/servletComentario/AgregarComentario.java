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
import entidades.Comentario;

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

		comentario.setDescripcion(request.getParameter("aComentario"));
		/*aca hay que asignar autor, fecha y libro */
		
		RequestDispatcher pagina = null;	
		
		try {
			ctrl.addComentario(comentario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}