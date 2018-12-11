<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Estilos/Estilos.css">
<title>Modificar Autor</title>
</head>
<body>

<div class="wrapperCenter1">
<h1 class=h1> Modificar Autor </h1>

<form action="ModificarAutor" method="post" onsubmit="¿return confirm('¿Esta seguro de que quiere modificar el autor?');">
 id del autor a modificar : <input type="text" name="idAutor" required><br>
 nuevo nombre del autor : <input type="text"  name="nombreNuevo"  required> <br>
<input type="submit" class=botonVerde value="actualizar">  
</form>
<div class="wrapperRight">
<form action="PrincipalCRUDAutor.html">
	<input type="submit" class="botonGris" value="Volver" >
</form> 
</div>
</div>




</body>
</html>