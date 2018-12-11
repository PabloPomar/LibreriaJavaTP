<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
ArrayList<Libro> listado = new ArrayList<Libro>();

%>

<table class=tablaGris><tr><th>Id Libro</th> <th>Titulo</th> <th>NroEdicion</th> <th>ISBN</th> <th>Descripcion</th> <th>Precio</th> <th>Editorial</th> <th>Genero</th> <th>Autor</th> <th>Cant Propia</th> <th>Cant Consignada</th> </tr>
	<%
	listado= (ArrayList<Libro>)request.getAttribute("lista");
			for(Libro l : listado) {
	%>
		<tr>
	     	<td><%=l.getCantidadConsignada() %></td>
			<td><%=l.getTitulo()%></td>
			<td><%=l.getNroEdicion() %></td>
			<td><%=l.getIsbn() %></td>
			<td><%=l.getDescripcion() %></td>
			<td><%=l.getPrecio() %></td>
			<td><%=l.getEditorial() %></td>
			<td><%=l.getGenero() %></td>
			<td><%=l.getAutor().getNombre() %></td>
			<td><%=l.getCantidadPropia() %></td>
			<td><%=l.getCantidadConsignada() %></td>
		</tr>
	<%
			}
	%>	




</table>

<form action="ConsultarLibros.html">
	<input type="submit" class="botonGrisFinal" value="Volver" >
</form>



</body>
</html>