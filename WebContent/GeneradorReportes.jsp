<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generador de reportes</title>
</head>
<body>
<div class= wrapperCenter2>
<h1 class= h1> Generador de Reportes  </h1>
<div class="form-style-2">
<form action="GenerarReportes"  method="post">

<h1 class=h1> Criteria</h1>
<label for="TipoOrden"><span>Criteria:</span><select name="aCriteria" class="select-field">
<option   value=1 >Compras</option>
<option value=2>Consignaciones</option>
<option value=3>Ventas</option> 
</select></label>


<h1 class=h1> Desde</h1>
<label for="TipoOrden"><span>Mes:</span><select name="aMes1" class="select-field">
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

<label for="TipoOrden"><span>Dia:</span><select name="aDia1" class="select-field">
<% int j1=1; %>
<% for (int i=1; i<32; i++) {
%>
<option value=<%=j1 %>> <%=j1 %> </option>
<% 
j1++;
} %>
</select></label>

<label for="TipoOrden"><span>Año:</span><select name="aAño1" class="select-field">
<% int y1=2015; %>
<% for (int i=1; i<80; i++) {
%>
<option value=<%=y1 %>> <%=y1 %> </option>
<% 
y1++;
} %>
</select></label>


<h1 class=h1> Hasta</h1>
<label for="TipoOrden"><span>Mes:</span><select name="aMes2" class="select-field">
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

<label for="TipoOrden"><span>Dia:</span><select name="aDia2" class="select-field">
<% int j2=1; %>
<% for (int i=1; i<32; i++) {
%>
<option value=<%=j2 %>> <%=j2 %> </option>
<% 
j2++;
} %>
</select></label>

<label for="TipoOrden"><span>Año:</span><select name="aAño2" class="select-field">
<% int y2=2015; %>
<% for (int i=1; i<80; i++) {
%>
<option value=<%=y2 %>> <%=y2 %> </option>
<% 
y2++;
} %>
</select></label>






<label><span> </span><input type="submit" value="Generar" /></label>
</form>




</div>
</div>

<form action="PaginaPrincipalAdmin.jsp">
  <input type="submit" class=botonGrisFinal value="Volver">
</form> 



</body>
</html>