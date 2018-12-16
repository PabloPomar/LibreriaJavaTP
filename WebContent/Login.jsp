<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<div class="wrapperCenter1">

<h1 class=h1> L O G I N </h1>
<br>
<form action="login" method="post">
<label for="Usuario"><span>Usuario :<span class="required">*</span></span><input type="text" class="input-field" name="aUsuario"></label> <br>
<label for="Contraseña"><span>Contraaseña :<span class="required">*</span></span><input type="text" class="input-field" name="aContraseña"></label> <br>

<input type="submit" class=botonAzul value="Ingresar" >  
</form>

</body>
</html>