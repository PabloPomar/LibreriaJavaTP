<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrado De Libro</title>
</head>
<body>
<div class=wrapperCenter2>
<div class="form-style-2">
<div class="form-style-2-heading">Ingrese datos del nuevo libro</div>

<form action="BorrarLibro" method="post"  onsubmit="¿return confirm('¿Esta seguro de que quiere borrar el Libro?');">

<label for="IdLibro"><span>Id del Libro a borrar:<span class="required">*</span></span><input type="text" class="input-field" name="aIdLibro" required ></label> <br>
<label><span> </span><input type="submit" value="BORRAR" /></label>

</form>





</div>
</div>

<form action="PrincipalCrudLibro.jsp">
	<input type="submit" class="botonGrisFinal" value="Volver" >
</form>




</body>
</html>