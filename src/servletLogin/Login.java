package servletLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlAMBCUsuario;
import entidades.Autor;
import entidades.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		try {
		CtrlAMBCUsuario ctrl = new CtrlAMBCUsuario();
		Usuario u = new Usuario();
		PrintWriter pwriter=response.getWriter();
		String usuario = request.getParameter("aUsuario");
		String contrase�a = request.getParameter("aContrase�a");
		u.setUsuario(usuario);
		u.setContrase�a(contrase�a);
		RequestDispatcher pagina = null;

		try {
			Usuario us = ctrl.login(u);
			
			pagina = request.getServletContext().getRequestDispatcher("/PrincipalCrudLibro.jsp");

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* 
		if (us.getTipo()= usuario) {
			pagina = request.getServletContext().getRequestDispatcher("/paginaPrincipalUsuario");
		} else {
			pagina = request.getServletContext().getRequestDispatcher("/paginaPrincipalAdmin");
		}
		*/
		pagina.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}