 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de admins</title>
</head>
<body>

<div class="wrapperCenter1">
<h1 class=h1>  Pagina de Administradores  </h1>
<h2>  Bienvenido : ${usuarioActual.getUsuario()}        </h2>


<form action="PrincipalCrudLibro.jsp">
  <input type="submit" class=botonGris value="Libros">
</form> 

<form action="PrincipalCRUDAutor.html">
  <input type="submit" class=botonGris value="Autores">
</form>


<form action="FacturasPrePagina.jsp">
  <input type="submit" class=botonGris value="Compras">
</form> 

<form action="GeneradorReportes.jsp" >
  <input type="submit" class=botonGris value="Listados">
</form> 

<form action="LogOut" method="get">
  <input type="submit" class=botonGris value="LogOut">
</form> 


</div>




</body>
</html>