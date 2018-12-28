 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Estilos/Estilos.css">

<style>
* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.column1 {
  float: left;
  width: 33.33%;
  padding: 10px;
  border: 2px solid #c6e6f0;
  background-color: #f4f4f4;
  height: 210px;
}

.column25 {
  float: left;
  width: 25%;
  padding: 10px;
  border: 2px solid #c6e6f0;
  background-color: #f4f4f4;
  height: 300px;
}

.column75 {
  float: left;
  width: 75%;
  padding: 10px;
  border: 2px solid #c6e6f0;
  background-color: #f4f4f4;
  height: 300px;
}




/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}


h2 {
font-family: Impact, Charcoal, sans-serif;
font-size: 24px;
letter-spacing: 3.6px;
word-spacing: 1.8px;
color: #494949;
font-weight: normal;
text-decoration: none;
font-style: normal;
font-variant: small-caps;
text-transform: none;
}


input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
 



</style>




<title>Libreria Autores</title>
</head>
<body>


<div class="wrapperCenter2"> 

<h1 class=h1> Libreria Autores </h1>

</div>

<div class="row">
  <div class="column1" > 
   <p> ACA VA ???? </p>
  </div>
  
  
  <div class="column1" > 
  <!-- Aca va el buscador de libros -->


  
  
  <table>
  <tr>
  <form action=""> 
  <td>
  <input type="text" name="aTitulo" placeholder="Buscar Libro">
  </td>
  <td>
  <input type="submit" class=botonRojo2 value="Buscar">
  </td>
  </form>
  </tr>
  </table>
  
  
  
 
  </div>
  <div class="column1" > 
    <!-- Aca va el Loggin -->


  <form action=""> 
	  <input type="text" name="aUsuario" placeholder="Usuario">
	  <input type="text" name="aContraseña" placeholder="Contraseña">
	  <input type="submit" class=botonRojo2 value="Log in">
  </form>
  <p> ¿Aun no tienes usuario? <a href="RegistroUsuario.jsp">Registrate</a> </p>


    
    
    
  </div>
</div>




<div class="wrapper3"> 
    <!-- Aca va el menu -->

<table>
  <tr>
<form action=""> 
  <td>
  <input type="submit" class=botonRojo2 value="Libros">
  </td>
</form>
<form action="">
  <td>
  <input type="submit" class=botonRojo2 value="Carrito">
  </td>
</form>
</tr>
</table> 
 

</div>

<div class="row"> 
 <div class="column25" > 
 <p> ACA VA UNA IMAGEN </p>
 <img src="<c:url value='/imagenes/libro.jpg'/>"/>
 </div> 
 <div class="column75" > 
   <p> ACA VAN LOS DETALLES DEL LIBRO </p>
 </div> 
</div>


<div class="row"> 
 <div class="column75" >
  <p> ACA VAN LOS DETALLES DEL LIBRO </p>
  </div> 
 <div class="column25" > 
  <p> ACA VA UNA IMAGEN </p>
  <img src="<c:url value='/imagenes/libro.jpg'/>"/>
  </div> 
</div>



<div class="row"> 
 <div class="column25" > 
 <p> ACA VA UNA IMAGEN </p>
 <img src="<c:url value='/imagenes/libro.jpg'/>"/>
 </div> 
 <div class="column75" > 
 <p> ACA VAN LOS DETALLES DEL LIBRO </p>
 </div> 
</div>




</body>
</html>