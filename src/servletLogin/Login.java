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

		CtrlAMBCUsuario ctrl = new CtrlAMBCUsuario();
		Usuario u = new Usuario();
		PrintWriter pwriter=response.getWriter();	
		String usuario = request.getParameter("aUsuario");	
		String contraseña = request.getParameter("aContraseña");	
		u.setUsuario(usuario);
		u.setContraseña(contraseña);
		RequestDispatcher pagina = null;	

		try {
			
			Usuario us = ctrl.login(u);
			
			if(us==null) {
				
				pagina = request.getServletContext().getRequestDispatcher("/Login.jsp");
				
			}
			else {
			request.getSession().setAttribute("usuarioActual", us);
			
			switch (us.getTipo()) {
				case "usuario": pagina = request.getServletContext().getRequestDispatcher("/PaginaPrincipal");
							break;
				case "administrador": pagina = request.getServletContext().getRequestDispatcher("/PaginaPrincipalAdmin.jsp");
				break;
				default: request.getServletContext().getRequestDispatcher("/Login.jsp");
			}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		pagina.forward(request, response);	

		
	}

}
