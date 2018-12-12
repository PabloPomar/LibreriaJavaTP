<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@page import="controlador.*"%>
<%@page import="java.util.Collections"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Estilos/Estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class=wrapperCenter2>
<div class="form-style-2">
<div class="form-style-2-heading">Ingrese datos del nuevo libro</div>



<%   
CtrlAMBCAutor ctrl= new CtrlAMBCAutor();
ArrayList<Autor> listaAutores = new ArrayList<Autor>();	
listaAutores = ctrl.getAllSortedByName();
%>

<form action="NuevoLibro" method="post">

<label for="Titulo"><span>Titulo:<span class="required">*</span></span><input type="text" class="input-field" name="aTitulo" required ></label> <br>
<label for="nroEdicion"><span>Nro edicion:<span class="required">*</span></span><input type="text" class="input-field" name="aNroEdicion" required ></label> <br>
<label for="isbn"><span>ISBN:<span class="required">*</span></span><input type="text" class="input-field" name="aISBN" required ></label> <br>
<label for="descripcion"><span>Descripcion:<span class="required">*</span></span><input type="text" class="input-field" name="aDescripcion" required ></label> <br>
<label for="precio"><span>Precio:<span class="required">*</span></span><input type="text" class="input-field" name="aPrecio" required ></label> <br>
<label for="editorial"><span>Editorial:<span class="required">*</span></span><input type="text" class="input-field" name="aEditorial" required ></label> <br>
<label for="genero"><span>Genero:<span class="required">*</span></span><input type="text" class="input-field" name="aGenero" required ></label> <br>
<label for="Autor"><span>Autor</span><select name="aAutor" class="select-field">
<% for (Autor a : listaAutores) { %>

<option   value= <%=a.getIdAutor()%>> <%=a.getNombre() %> </option>

<% } %>

</select></label>
<label for="CantPropia"><span>Cantidad Propia inicial:<span class="required">*</span></span><input type="text" class="input-field" name="aCantPropia" required ></label> <br>
<label for="CantConsignada"><span>Cantidad consignada inicial:<span class="required">*</span></span><input type="text" class="input-field" name="aCantConsignada" required ></label> <br>
<label><span> </span><input type="submit" value="Añadir" /></label>


</form>






</div>
</div>

<div class=wrapperRight>
<form action="PrincipalCrudLibro.jsp">
	<input type="submit" class="botonGris" value="Volver" >
</form>
</div>



</body>
</html>