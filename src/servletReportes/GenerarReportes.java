package servletReportes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.*;
import entidades.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * Servlet implementation class GenerarReportes
 */
@WebServlet("/GenerarReportes")
public class GenerarReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarReportes() {
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
		PrintWriter pwriter=response.getWriter(); 
		Date fecha1;
		Date fecha2;

		String criteria = request.getParameter("aCriteria");
		int criteriaInt = Integer.parseInt(criteria);
		String dia1 = request.getParameter("aDia1");
		int dia1int = Integer.parseInt(dia1);
		String mes1 = request.getParameter("aMes1");
		int mes1int = Integer.parseInt(mes1);
		String a�o1 = request.getParameter("aA�o1");
		int a�o1int = Integer.parseInt(a�o1);
		String dia2 = request.getParameter("aDia2");
		int dia2int = Integer.parseInt(dia2);
		String mes2 = request.getParameter("aMes2");
		int mes2int = Integer.parseInt(mes2);
		String a�o2 = request.getParameter("aA�o2");
		int a�o2int = Integer.parseInt(a�o2);
		 Calendar cal1 = Calendar.getInstance();
		 cal1.clear();
		 cal1.set(a�o1int, mes1int - 1, dia1int, 0, 0, 0);
		 fecha1 = cal1.getTime(); 
		 Calendar cal2 = Calendar.getInstance();
		 cal2.clear();
		 cal2.set(a�o2int, mes2int - 1, dia2int, 0, 0, 0);
 		 fecha2= cal2.getTime();
		 

	}

}
