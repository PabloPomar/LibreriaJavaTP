<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

.label {
  color: black;
  padding: 8px;
  font-family: Trebuchet MS;
  font-size:17px;
  font-weight:bold;
}


input[type=text], select {
  width: 35%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}




</style>




<title>Login</title>
</head>
<body>

<div class="wrapperCenter1">
<h1 class=h1> L O G I N </h1>
<br>
<form action="Login" method="post">
<label for="Usuario"><span class="label">Usuario : <span class="required"> </span></span><input type="text" class="input-field" name="aUsuario"></label> <br>
<label for="Contrase�a"><span class="label">Contrase�a : <span class="required"> </span></span><input type="text" class="input-field" name="aContrase�a"></label> <br>

<input type="submit" class="botonAzul" value="Ingresar" >  
</form>
 <p> �Aun no tienes usuario? <a href="RegistroUsuario.jsp">Registrate</a> </p>

</div>

<form action="PaginaPrincipal" method="get">
<input type="submit" class="botonGrisFinal" value="volver" >  
</form>



</body>
</html>