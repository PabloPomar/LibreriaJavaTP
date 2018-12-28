<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style>
* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
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



</style>



<title>Registro de factura</title>
</head>
<body>



<%  
ArrayList<Libro> listadoLibro = new ArrayList<Libro>();
Proveedor proveedor = new Proveedor();
Libreria libreria = new Libreria();
int nroFactura ;
int cantItems ; 
java.sql.Date fecha;
listadoLibro= (ArrayList<Libro>)request.getAttribute("librosInfo");
proveedor = (Proveedor)request.getAttribute("proveedorInfo");
libreria = (Libreria)request.getAttribute("libreriaInfo");
nroFactura = (Integer)request.getAttribute("nroFacturaInfo") ;
cantItems = (Integer)request.getAttribute("cantidadInfo") ;
fecha =  (java.sql.Date)request.getAttribute("fechaInfo");


%>

<form action="RegistrarFactura" method="post">
 <input type="hidden" name="aProveedorId" value=<%=proveedor.getIdProveedor() %>>
 <input type="hidden" name="aLibreriaCuit" value=<%=libreria.getCuit() %>>
 <input type="hidden" name="aNroFactura" value=<%=nroFactura %>>
 <input type="hidden" name="aCantItems" value=<%=cantItems %>>
 <input type="hidden" name="aFechaEmision" value=<%=fecha %>>
<div class="row">
  <div class="column" >
    <h2>Datos Factura</h2>
    <label>Nro Factura: <%=nroFactura%> </label>  <br>
    <label> Fecha Emision: <%=fecha%> </label>  <br>
  </div>
  <div class="column" >
    <h2>Datos Proveedor</h2>
    	<label> CUIT: <%=proveedor.getIdProveedor()%> </label>  <br>
    	<label> Razon Social: <%=proveedor.getRazonSocial()%> </label>  <br>
		<label> Telefono: <%=proveedor.getTelefono()%> </label>  <br>
		<label> Direccion: <%=proveedor.getDireccion()%> </label>  <br>
		<label> Mail: <%=proveedor.getMail()%> </label>  <br>
  </div>
  <div class="column" >
    <h2>Datos Libreria</h2>
    	<label> CUIT: <%=libreria.getCuit()%> </label>  <br>
    	<label> Razon Social: <%=libreria.getRazonSocial()%> </label>  <br>
    	<label> Telefono: <%=libreria.getTelefonoLibreria()%> </label>  <br>
    	<label> Direccion: <%=libreria.getDireccionLibreria()%> </label>  <br>
    	<label> Mail: <%=libreria.getMailLibreria()%> </label>  <br>
  </div>
</div>

<div class="wrapperCenter2">

	<% for (int i=0; i<cantItems ; i++) { %>
	<label>Libro:   </label><select name=<%="aIdLibro"+i %> >
   	<% for (Libro l : listadoLibro) { %>
	
	<option   value= <%=l.getIdLibro()%>> <%=l.getTitulo() %> </option>
	
	<% } %>
    </select>
    <label> Cantidad:</label> <input type="text" class="input-field" name=<%="aCantidad"+i %> required >
	
    <br>
    <% }%>
    
</div>

<div class="wrapperCenter2">
    <input type="submit" class="botonGris" value="Registrar" >
</div>

</form>

<div class="wrapperCenter2">
    <form action="FacturasPrePagina.jsp">
  <input type="submit" class=botonGris value="Volver">
</form> 
</div>




</body>
</html>