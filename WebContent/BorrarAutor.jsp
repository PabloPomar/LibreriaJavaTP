<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BorrarAutorDeLaLista</title>
</head>
<body>

<div class="wrapperCenter1">
<h1 class=h1> Borrar Autor de la lista </h1>

<form action="BorrarAutor" method="post" onsubmit="¿return confirm('¿Esta seguro de que quiere borrar el autor?');">
 id del autor a borrar : <input type="text" name="idAutor" required><br><br>
<input type="submit" class="botonRojo" value="Borrar">  
</form>
<div class="wrapperRight">
<form action="PrincipalCRUDAutor.html">
	<input type="submit" class="botonGris" value="Volver" >
</form> 
</div>
</div>
</body>
</html>