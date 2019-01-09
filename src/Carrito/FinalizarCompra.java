package Carrito;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Autor;
import entidades.Mail;
import entidades.Usuario;

/**
 * Servlet implementation class FinalizarCompra
 */
@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarCompra() {
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
		 HttpSession session = request.getSession();
		 PrintWriter pwriter=response.getWriter();
		  if( request.getParameter("aIdAutor") != null){
			 int idAutor = Integer.parseInt(request.getParameter("aIdAutor"));  
			 CtrlCarrito ctrl = new CtrlCarrito();
			 Mail mail = new Mail();
			 Usuario user = (Usuario) request.getSession().getAttribute("usuarioActual");
			 Autor autor = new Autor();
			 autor.setIdAutor(idAutor);
			 mail.setAutor(autor);
			 mail.setUsuario(user);
			 mail.setMail(user.getMail());
			 try {
				ctrl.addMail(mail);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				pwriter.println("Los mails no se pudieron enviar");
				e.printStackTrace();
			}
			 	
			 
			} 
		 
	        if(session.getAttribute("carritoActual") != null) {
	        	session.removeAttribute("carritoActual");	
	        }
	        if(session.getAttribute("facturaActual") != null) {
	        	session.removeAttribute("facturaActual");
	        }
	        
	        
	        	response.sendRedirect("PaginaPrincipal");
	}

}
