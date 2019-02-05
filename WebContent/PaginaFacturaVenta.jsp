<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Carrito.*"%>
<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  border: 2px solid #c6e6f0;
  background-color: #f4f4f4;
  height: 300px;
 
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}


h2 {
font-family: Impact, Charcoal, sans-serif;
font-size: 24px;
letter-spacing: 3.6px;
word-spacing: 1.8px;
color: #494949;
font-weight: normal;
text-decoration: none;
font-style: normal;
font-variant: small-caps;
text-transform: none;
}



</style>


<title>Factura Venta</title>
</head>
<body>


<div class="row">
  <div class="column" >
    <h2>Datos Factura</h2>
    <label>Nro Factura: ${facturaActual.getNroFacturaVenta()} </label>  <br>
    <label> Fecha Emision: ${facturaActual.getFechaEmision()} </label>  <br>
  </div>
  <div class="column" >
    <h2>Datos Cliente</h2>
    	<label> Nombre: ${usuarioActual.getNombreYapellido()} </label>  <br>
		<label> Telefono: ${usuarioActual.getTelefono()} </label>  <br>
		<label> Direccion: ${usuarioActual.getDireccion()} </label>  <br>
		<label> Mail: ${usuarioActual.getMail()} </label>  <br>
  </div>
  <div class="column" >
    <h2>Datos Libreria</h2>
    	<label> CUIT:  ${facturaActual.getLibreria().getCuit() }  </label>  <br>
    	<label> Razon Social: ${facturaActual.getLibreria().getRazonSocial() } </label>  <br>
    	<label> Telefono: ${facturaActual.getLibreria().getTelefonoLibreria() }  </label>  <br>
    	<label> Direccion: ${facturaActual.getLibreria().getDireccionLibreria() } </label>  <br>
    	<label> Mail: ${facturaActual.getLibreria().getMailLibreria() }   </label>  <br>
  </div>
</div>



<%
	Carrito carrito = (Carrito) request.getSession().getAttribute("carritoActual");
	float subtotal = 0;
	float total = 0;  
    ArrayList<LineaVenta> items = carrito.getItems();
    	int numItems = items.size();
	%>
	<br>
	<div class="wrapperCenter2">
	<table >
	<tr><th>Titulo</th><th>Cantidad</th><th>Precio</th><th>Subtotal</th><th>Total</th></tr>
	 <%  for (int i=0; i < numItems; i++)
        {  
		 LineaVenta linea = (LineaVenta) items.get(i); %>
		 
         <tr><td>
         <%=linea.getLibro().getTitulo()%>
         </td><td>
         <%=linea.getCantidad()%>
         </td><td>
         <%=linea.getLibro().getPrecio()%>
         </td><td>
         <% subtotal = linea.getLibro().getPrecio() * linea.getCantidad();%>
         <%=subtotal%>
         </td><td>
         <%total = total + subtotal;%>
         <%=total%>
   
     <%   }
	
	 %>
	</table>
	
	</div>
	
	<% 
	ArrayList<LineaVenta> itemsMail = carrito.getItems();
	LineaVenta lineaMail = (LineaVenta) itemsMail.get(0);%>
	
	<form action="FinalizarCompra" method="post"> 
	 <input type="checkbox" name="aIdAutor" value= <%=lineaMail.getLibro().getAutor().getIdAutor()%>> Notificame cuando se agregen libros del autor: <%out.print(lineaMail.getLibro().getAutor().getNombre()); %>  </input>
	 <input type="submit" class=botonRojo2 value="Finalizar compra" >
	</form>
	

	
	



</body>
</html>