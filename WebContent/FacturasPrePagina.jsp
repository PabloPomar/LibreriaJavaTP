
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingrese el tipo de factura que desea generar</title>
</head>
<body>

<div class="wrapperCenter1">
<h1 class=h1>  Generador de Facturas/Remito   </h1>

<form action="FacturaPreGenerador" method="post">
  <input type="submit" class=botonGris value="Factura">
</form> 

<form action="">
  <input type="submit" class=botonGris value="Remito">
</form>

<form action="PaginaPrincipalAdmin.jsp">
  <input type="submit" class=botonGris value="Volver">
</form> 


</div>


</body>
</html>