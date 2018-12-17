<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de lineas de venta</title>
</head>
<body>

<%
ArrayList<LineaVenta> listado = new ArrayList<LineaVenta>();
%>
<% double total = 0; %>

<div class="wrapperCenter1">
<h1 class=h1>Listado de lineas de venta</h1>
</div>

<table class=tablaGris>  <tr> <th>Libreria</th> <th>ID Linea </th><th>Nro Factura</th><th> Fecha Emision </th><th> Titulo </th>  <th> Autor </th> <th>Cliente</th> <th>Nombre Cliente</th>  <th> Cantidad</th>  <th> Precio </th>  <th>SubTotal</th> <th>Total</th> </tr>
 
 <% 
 listado= (ArrayList<LineaVenta>)request.getAttribute("lineasV");
 	for (LineaVenta lv : listado) { 
 %>
  <tr>
		<% total = total + lv.getCantidad()*lv.getLibro().getPrecio()*1.75  ; %>
  		<td><%=lv.getFactura().getLibreria().getRazonSocial() %> </td> 
  		<td><%=lv.getIdLineaVenta() %> </td>
  		<td><%=lv.getFactura().getNroFacturaVenta() %> </td>	
  		<td><%=lv.getFactura().getFechaEmision() %> </td>
  		<td><%=lv.getLibro().getTitulo() %> </td>
		<td><%=lv.getLibro().getAutor().getNombre() %></td>
		<td><%=lv.getFactura().getUsuario().getUsuario() %>  </td>
		<td><%=lv.getFactura().getUsuario().getNombreYapellido() %> </td>
		<td><%=lv.getCantidad() %> </td>  
		<td><%=lv.getLibro().getPrecio() %> </td>
		<td><%=lv.getCantidad()*lv.getLibro().getPrecio() %></td>

		<td><%=total %></td> 
 	</tr> 
 <% }%>
</table>

<form action="GeneradorReportes.jsp">
	<input type="submit" class="botonGrisFinal" value="Volver" >
</form>





</body>
</html>