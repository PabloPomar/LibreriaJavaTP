package servletCrudLibro;

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
 * Servlet implementation class NuevoLibro
 */
@WebServlet("/NuevoLibro")
public class NuevoLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoLibro() {
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
		CtrlAMBCLibro ctrl = new CtrlAMBCLibro();
		CtrlAMBCAutor ctrl2= new CtrlAMBCAutor();
		Libro libro = new Libro();
		Autor autor = new Autor();
		PrintWriter pwriter=response.getWriter(); 
		String titulo= request.getParameter("aTitulo");
		libro.setTitulo(titulo);
		String nroEdicion = request.getParameter("aNroEdicion");
		int nroEdicionInt = Integer.parseInt(nroEdicion);
		libro.setNroEdicion(nroEdicionInt);
		String isbn = request.getParameter("aISBN");
		libro.setIsbn(isbn);
		String desc = request.getParameter("aDescripcion");
		libro.setDescripcion(desc);
		String precio = request.getParameter("aPrecio");
		float precioFl = Float.parseFloat(precio);
		libro.setPrecio(precioFl);
		String editorial = request.getParameter("aEditorial");
		libro.setEditorial(editorial);
		String genero = request.getParameter("aGenero");
		libro.setGenero(genero);
		String idAut = request.getParameter("aAutor");
		int idAutInt = Integer.parseInt(idAut);
		try {
			autor = ctrl2.getById(idAutInt);
			libro.setAutor(autor);
			
		} catch (Exception e) {
			pwriter.println("el autor no se a agregado");
			e.printStackTrace();
		}
		String cantPropia = request.getParameter("aCantPropia");
		int cantPropiaInt = Integer.parseInt(cantPropia);
		libro.setCantidadPropia(cantPropiaInt);
		String cantConsignada = request.getParameter("aCantConsignada");
		int cantConsignadaInt = Integer.parseInt(cantConsignada);
		libro.setCantidadConsignada(cantConsignadaInt);
		
		try {
			ctrl.add(libro);
			pwriter.println("Libro Agregado");
			pwriter.write("<form action=\"NuevoLibro.jsp\">\r\n" + 
					"  <input type=\"submit\" value=\"Volver\">\r\n" + 
					"</form> ");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pwriter.println("el libro no se a agregado");
			e.printStackTrace();
		}
		
		
	}

}
