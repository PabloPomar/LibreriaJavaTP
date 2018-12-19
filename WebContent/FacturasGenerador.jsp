<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingrese infomracion necesaria para generar la factura</title>
</head>
<body>

<%  
ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
proveedores = (ArrayList<Proveedor>)request.getAttribute("proveedoresLista");
ArrayList<Libreria> librerias = new ArrayList<Libreria>();
librerias = (ArrayList<Libreria>)request.getAttribute("libreriasLista");
%>



<div class=wrapperCenter2>
<div class="form-style-2">
<div class="form-style-2-heading">Ingrese parametros de la factura</div>

	<form action="ModificarLibro" method="post">

	<label for="Titulo"><span>Nro Factura:<span class="required">*</span></span><input type="text" class="input-field" name="aNroFactura"  required ></label> <br>
	
	<h2> Cantidad de itens que tiene la factura (ADVERTENCIA: LUEGO NO PODRA MODIFICARLO)</h2>
	
	<label for="CantItems"><span>Cantidad de items:<span class="required">*</span></span><input type="text" class="input-field" name="aCantItems"  required ></label> <br>
	
	
	<h2> Fecha emision</h2>
	
	<label for="TipoOrden"><span>Mes:</span><select name="aMes" class="select-field">
	<option   value=1 >Enero</option>
	<option value=2>Febrero</option>
	<option value=3>Marzo</option> 
	<option value=4>Abril</option> 
	<option value=5>Mayo</option> 
	<option value=6>Junio</option>
	<option value=7>Julio</option> 
	<option value=8>Agosto</option> 
	<option value=9>Septiembre</option>
	<option value=10>Octubre</option>  
	<option value=11>Noviembre</option> 
	<option value=12>Diciembre</option> 
	</select></label>
	
	<label for="TipoOrden"><span>Dia:</span><select name="aDia" class="select-field">
	<% int j1=1; %>
	<% for (int i=1; i<32; i++) {
	%>
	<option value=<%=j1 %>> <%=j1 %> </option>
	<% 
	j1++;
	} %>
	</select></label>
	
	<label for="TipoOrden"><span>Año:</span><select name="aAño" class="select-field">
	<% int y1=2015; %>
	<% for (int i=1; i<80; i++) {
	%>
	<option value=<%=y1 %>> <%=y1 %> </option>
	<% 
	y1++;
	} %>
	</select></label>

	<h2> Proveedor</h2>

	<label for="Proveedor"><span>Proveedor</span><select name="aProveedor" class="select-field">
	<% for (Proveedor p : proveedores) { %>
	
	<option   value= <%=p.getIdProveedor()%>> <%=p.getRazonSocial() %> </option>
	
	<% } %>
		</select></label>
		
	<h2> Libreria</h2>
	
	<label for="Libreria"><span>Libreria</span><select name="aLibreria" class="select-field">
	<% for (Libreria l : librerias) { %>
	
	<option   value= <%=l.getCuit()%>> <%=l.getRazonSocial() %> </option>
	
	<% } %>
		</select></label>
	
		<label><span> </span><input type="submit" value="Generar" /></label>
	
</form>
</div> </div>


</body>
</html>