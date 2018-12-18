package servletLogin;

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
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUsuario() {
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
		
		String nomYApe = request.getParameter("aNombreYApellido");
		u.setNombreYapellido(nomYApe);
		int dni = Integer.parseInt(request.getParameter("aDni"));
		u.setDni(dni);
		String direccion = request.getParameter("aDireccion");
		u.setDireccion(direccion);
		int telefono = Integer.parseInt(request.getParameter("aTelefono"));
		u.setTelefono(telefono);
		String eMail = request.getParameter("aEmail");
		u.setMail(eMail);
		String usuario = request.getParameter("aUsuario");
		u.setUsuario(usuario);
		String contraseña = request.getParameter("aContraseña");
		u.setContraseña(contraseña);
		
		try {
			String validacion = ctrl.validarUsuario(usuario);
			if (validacion.equals("invalido")) {
				pwriter.println("El nombre de Usuario ya esta en uso. Probar con otro nombre.");
				pwriter.write("<form action=\"RegistroUsuario.jsp\">\r\n" + 
						"  <input type=\"submit\" value=\"Volver\">\r\n" + 
						"</form> ");	
			}
			else {
				ctrl.add(u);
				pwriter.println("Usuario Registrado. Felicitaciones.");
				pwriter.write("<form action=\"RegistroUsuario.jsp\">\r\n" + 
						"  <input type=\"submit\" value=\"Volver\">\r\n" + 
						"</form> ");	
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
