<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de lineas de remito</title>
</head>
<body>

<%
ArrayList<LineaRemito> listado = new ArrayList<LineaRemito>();
%>
<%double total = 0; %>

<div class="wrapperCenter1">
<h1 class=h1>Listado de lineas de consignacion</h1>
</div>

<table class=tablaGris>  <tr> <th>Libreria</th> <th>ID Linea </th><th>Nro Remito</th><th> Fecha Emision </th><th> Titulo </th>  <th> Autor </th> <th>Proveedor</th>  <th> Cantidad</th>  <th> Precio </th>  <th>SubTotal</th> <th>Total</th> </tr>
 <% 
 listado= (ArrayList<LineaRemito>)request.getAttribute("lineasR");
 	for (LineaRemito lr : listado) { 
 %>
  <tr>
  		<td><%=lr.getRemito().getLibreria().getRazonSocial() %> </td> 
  		<td><%=lr.getIdLineaRemito() %> </td>
  		<td><%=lr.getRemito().getIdRemito() %> </td>	
  		<td><%=lr.getRemito().getFechaEmision() %> </td>
  		<td><%=lr.getLibro().getTitulo() %> </td>
		<td><%=lr.getLibro().getAutor().getNombre() %></td>
		<td><%=lr.getRemito().getProveedor().getRazonSocial() %>  </td>
		<td><%=lr.getCantidad() %> </td>  
		<td><%=lr.getLibro().getPrecio()*0.70 %> </td>
		<td><%=lr.getCantidad()*lr.getLibro().getPrecio()*0.70 %></td>
		<% total = total + lr.getCantidad()*lr.getLibro().getPrecio()*0.70; %>
		<td><%=total %></td> 
 	</tr> 
 <% }%>
</table>

<form action="GeneradorReportes.jsp">
	<input type="submit" class="botonGrisFinal" value="Volver" >
</form>





</body>
</html>