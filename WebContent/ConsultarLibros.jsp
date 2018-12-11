<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Libros</title>
</head>
<body>

<div class=wrapperCenter2>
<div class="form-style-2">
<div class="form-style-2-heading">Consulta de libros</div>
<form action="ConsultarLibro"  method="post">
<label for="TipoOrden"><span>Ordenar por:</span><select name="aValor" class="select-field">
<option   value=1 >ID</option>
<option value=2> Titulo </option>
<option value=3> Autor </option> 
</select></label>
<label><span> </span><input type="submit" value="Ordenar" /></label>
</form>
</div>
</div>




</body>
</html>