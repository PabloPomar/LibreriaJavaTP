<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal CRUD Libro</title>
</head>
<body>
<div class="wrapperCenter2">
<h1 class=h1>  AMBC de Libros   </h1>

<form action="NuevoLibro.jsp">
  <input type="submit" class=botonGris value="Nuevo">
</form> 

<form action="BorrarLibro.jsp">
  <input type="submit" class=botonGris value="Borrar">
</form> 

<form action="ConsultarLibros.jsp">
  <input type="submit" class=botonGris value="Consultar">
</form> 

<form action="ModificarLibro.jsp">
  <input type="submit" class=botonGris value="Modificar">
</form> 

<form action="PaginaPrincipalAdmin.jsp">
  <input type="submit" class=botonGris value="Volver">
</form> 


</div>



</body>
</html>