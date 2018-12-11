<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Libro</title>
</head>
<body>

<div class=wrapperCenter2>
<div class="form-style-2">
<div class="form-style-2-heading">Ingrese datos del nuevo libro</div>


<form action="ObtenerLibro" method="post">
<label for="idLibro"><span>Ingrese id del libro a modificar:<span class="required">*</span></span><input type="text" class="input-field" name="aIdLibro" required ></label> <br>
<label><span> </span><input type="submit" value="Modificar" /></label>
</form>

</div>
</div>






</body>
</html>