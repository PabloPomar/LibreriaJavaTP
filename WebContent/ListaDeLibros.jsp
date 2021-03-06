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

h3 {
font-family: Impact, Charcoal, sans-serif;
font-size: 18px;
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



<title>Listado de Libros</title>


</head>
<body>

<div class="wrapperCenter2"> 

<h1 class=h1> Libreria Autores </h1>

</div>

<div class="row">
  <div class="column1" > 
     <!-- ACA VA EL LINK A LA PAGINA PRINCIPAL-->
  
<form action="PaginaPrincipal" method="get">
<input type="image" src="imagenes/linkPagPrincipal.jpg" alt="Submit Form" />
</form> 
   
  </div>
  
  
  <div class="column1" > 
  <!-- Aca va el buscador de libros -->



 <table>
   <tr>
   <td>
  <label>Bienvenido : ${usuarioActual.getUsuario()}  </label> 
   </td>
      <form action="LogOut" method="get"> 
   <td>   
	  <input type="submit" class=botonRojo2 value="Log out">
   </td>  
  </form>
  </tr>
  
  </table>
  
  
  <table>
  <tr>
  <form action="ListadoLibros" method="post"> 
  <td>
  <input type="text" name="aTitulo" placeholder="Buscar Libro" required>
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


  <form action="Login" method="post"> 
	  <input type="text" name="aUsuario" placeholder="Usuario"  required>
	  <input type="text" name="aContrase�a" placeholder="Contrase�a" required>
	  <input type="submit" class=botonRojo2 value="Log in">
  </form>
  <p> �Aun no tienes usuario? <a href="RegistroUsuario.jsp">Registrate</a> </p>


    
    
    
  </div>
</div>




<div class="wrapper3"> 
    <!-- Aca va el menu -->

<table>
  <tr>
<form action="ListadoLibros" method="post"> 
  <td>
  <input type="hidden" name="aTitulo" value=" ">
  <input type="submit" class=botonRojo2 value="Libros">
  </td>
</form>
<form action="IniciarCarrito" method="post">
  <td>
  <input type="submit" class=botonRojo2 value="Carrito">
  </td>
</form>
</tr>
</table> 
 

</div>


<c:forEach items="${listaLibros}" var="libro">
<div class="wrapper3">
<form action="RedirigirPagina" method="post">
<input type="hidden" name="aIdLibro" value= ${libro.getIdLibro()} >
  <h2 class=h2>  TITULO: ${libro.getTitulo()} //// Genero:  ${libro.getGenero()} //// Autor: ${libro.getAutor().getNombre()}  </h2>
   <input type="submit" class=botonRojo2 value="Ver Mas">


</form>
</div>    
</c:forEach>













</body>
</html>