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
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>



<title>Registro de factura</title>
</head>
<body>



<%  
Proveedor proveedor = new Proveedor();
Libreria libreria = new Libreria();
int nroFactura ;
int cantItems ; 
java.sql.Date fecha;

proveedor = (Proveedor)request.getAttribute("proveedorInfo");
libreria = (Libreria)request.getAttribute("libreriaInfo");
nroFactura = (Integer)request.getAttribute("nroFacturaInfo") ;
cantItems = (Integer)request.getAttribute("cantidadInfo") ;
fecha =  (java.sql.Date)request.getAttribute("fechaInfo");

%>

<div class="row">
  <div class="column" style="background-color:#aaa;">
    <h2>Column 1</h2>
    <p>Some text..</p>
  </div>
  <div class="column" style="background-color:#bbb;">
    <h2>Column 2</h2>
    <p>Some text..</p>
  </div>
  <div class="column" style="background-color:#ccc;">
    <h2>Column 3</h2>
    <p>Some text..</p>
  </div>
</div>

<div class="wrapperCenter2">
    <p>Algo de Texto</p>
</div>








</body>
</html>