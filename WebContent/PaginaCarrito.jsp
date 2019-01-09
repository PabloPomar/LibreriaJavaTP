<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Carrito.*"%>
<%@page import="entidades.*"%>
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
  width: 40%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
 
 
</style>



<title>Pagina del Carrito</title>
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
	  <input type="text" name="aContraseña" placeholder="Contraseña" required>
	  <input type="submit" class=botonRojo2 value="Log in">
  </form>
  <p> ¿Aun no tienes usuario? <a href="RegistroUsuario.jsp">Registrate</a> </p>


    
    
    
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

	<%
	Carrito carrito = (Carrito) request.getSession().getAttribute("carritoActual");
	float subtotal = 0;
	float total = 0;
	
    if (carrito == null) {
	
    carrito = new Carrito();
	request.getSession().setAttribute("carritoActual", carrito);
	
    }
    
    ArrayList<LineaVenta> items = carrito.getItems();
		
    if (items.size() == 0)
    {
        out.println("<h3>Tu Carrito esta vacio.</h3>");
    }
    else
    {
    
    	int numItems = items.size();
	%>
	<br>
	<div class="wrapperCenter2">
	<table >
	<tr><th>Titulo</th><th>Cantidad</th><th>Precio</th><th>Subtotal</th><th>Total</th></tr>
	 <%  for (int i=0; i < numItems; i++)
        {  
		 LineaVenta linea = (LineaVenta) items.get(i);
		 
         out.print("<tr><td>");
         out.print(linea.getLibro().getTitulo());
         out.print("</td><td>");
         out.print(linea.getCantidad());
         out.print("</td><td>");
         out.print(linea.getLibro().getPrecio());
         out.print("</td><td>");
         subtotal = linea.getLibro().getPrecio() * linea.getCantidad();
         out.print(subtotal);
         out.print("</td><td>");
         total = total + subtotal;
         out.print(total);
         out.println("</td><td>"+
                 "<a href=\"RemoverItem?aItemIndex="+
                 i+"\">Remove</a></td></tr>");
        
        
        
        }
	
	 %>
	
	</table>
	
		</div>
		
		<div class="wrapperCenter2">
	
	<form action="RegistrarCompra" method="post">
	 <h2> Por favor introdusca los datos de remitente </h2>
	 <label>Metodo de pago <select>  
	 <option value="aTarjetaCredito">Tarjeta de credito</option>
 	 <option value="aTarjetaDebito">Tarjeta de debito</option> 
  	 </select>
	 </label> 
	 <label> Nro Tarjeta: <input type="number" name="aNroTarjeta"> </label> <br>
	 <label> clave de seguridad: <input type="number" name="aClaveSeguridad"> </label> <br>
	 
	 <label> Nombre del remitente: <input type="text" name="aNombreYApellido" value="${usuarioActual.getNombreYapellido()}">    </label>  <br>
	 <label> Direccion: <input type="text" name="aDireccion" value="${usuarioActual.getDireccion()}">    </label>  <br>
	 <label> telefono: <input type="text" name="aTelefono" value="${usuarioActual.getTelefono()}">    </label>  <br>
	 <label> mail: <input type="text" name="aMail" value="${usuarioActual.getMail()}">    </label>   <br>
	  <input type="submit" class=botonRojo2 value="Confirmar Compra" onsubmit="¿return confirm('¿Esta seguro de que desea realizar la compra (no hay vuelta atras)?');" >
	</form>
	
	 </div>
	
	
	
	
	
	<% } %>








</body>
</html>