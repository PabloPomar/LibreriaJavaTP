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
import java.sql.Date;
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
		
		CtrlReportes ctrl = new CtrlReportes();
		PrintWriter pwriter=response.getWriter(); 

		String criteria = request.getParameter("aCriteria");
		int criteriaInt = Integer.parseInt(criteria);
		String dia1 = request.getParameter("aDia1");
		int dia1int = Integer.parseInt(dia1);
		String mes1 = request.getParameter("aMes1");
		int mes1int = Integer.parseInt(mes1);
		String año1 = request.getParameter("aAño1");
		int año1int = Integer.parseInt(año1);
		String dia2 = request.getParameter("aDia2");
		int dia2int = Integer.parseInt(dia2);
		String mes2 = request.getParameter("aMes2");
		int mes2int = Integer.parseInt(mes2);
		String año2 = request.getParameter("aAño2");
		int año2int = Integer.parseInt(año2);
		

		
		Calendar cal1 = Calendar.getInstance();
		cal1.clear();
	    cal1.set(Calendar.YEAR, año1int);
	    cal1.set(Calendar.MONTH, mes1int - 1);
	    cal1.set(Calendar.DATE, dia1int);
	    cal1.set(Calendar.HOUR_OF_DAY, 0);
	    cal1.set(Calendar.MINUTE, 0);
	    cal1.set(Calendar.SECOND, 0);
	    cal1.set(Calendar.MILLISECOND, 0);
		
	    java.sql.Date fecha1 = new java.sql.Date(cal1.getTime().getTime());

	    
	    Calendar cal2 = Calendar.getInstance();
		cal2.clear();
	    cal1.set(Calendar.YEAR, año2int);
	    cal1.set(Calendar.MONTH, mes2int - 1);
	    cal1.set(Calendar.DATE, dia2int);
	    cal1.set(Calendar.HOUR_OF_DAY, 0);
	    cal1.set(Calendar.MINUTE, 0);
	    cal1.set(Calendar.SECOND, 0);
	    cal1.set(Calendar.MILLISECOND, 0);
	    java.sql.Date fecha2 = new java.sql.Date(cal1.getTime().getTime());
	    

	}
	
	

}
