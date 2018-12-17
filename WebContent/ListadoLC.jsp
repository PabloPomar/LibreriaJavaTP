<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de lineas de compras</title>
</head>
<body>

<%
ArrayList<LineaCompra> listado = new ArrayList<LineaCompra>();

%>

<%double total = 0; %>
<div class="wrapperCenter1">
<h1 class=h1>Listado de lineas de compras</h1>
</div>
<table class=tablaGris>  <tr> <th>Libreria</th> <th>ID Linea </th><th>Nro Factura</th><th> Fecha Emision </th><th> Titulo </th>  <th> Autor </th> <th>Proveedor</th>  <th> Cantidad</th>  <th> Precio </th>  <th>SubTotal</th> <th>Total</th> </tr>
 <% 
 listado= (ArrayList<LineaCompra>)request.getAttribute("lineasC");
 	for (LineaCompra lc : listado) { 
 %>
  <tr>
  		<td><%=lc.getFactura().getLibreria().getRazonSocial() %> </td> 
  		<td><%=lc.getIdLineaCompra() %> </td>
  		<td><%=lc.getFactura().getNroFacturaCompra() %> </td>	
  		<td><%=lc.getFactura().getFechaEmision() %> </td>
  		<td><%=lc.getLibro().getTitulo() %> </td>
		<td><%=lc.getLibro().getAutor().getNombre() %></td>
		<td><%=lc.getFactura().getProveedor().getRazonSocial() %>  </td>
		<td><%=lc.getCantidad() %> </td>  
		<td><%=lc.getLibro().getPrecio()*0.70 %> </td>
		<td><%=lc.getCantidad()*lc.getLibro().getPrecio()*0.70 %></td>
		<% total = total + lc.getCantidad()*lc.getLibro().getPrecio()*0.70; %>
		<td><%=total %></td> 
 	</tr> 
 <% }%>
</table>

<form action="GeneradorReportes.jsp">
	<input type="submit" class="botonGrisFinal" value="Volver" >
</form>
</body>
</html>