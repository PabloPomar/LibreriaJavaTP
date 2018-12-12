<%@page import="entidades.*"%>
<%@page import="controlador.*"%>
<%@page import="java.util.ArrayList"%>
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
	<%
	CtrlAMBCAutor ctrl= new CtrlAMBCAutor();
	ArrayList<Autor> listaAutores = new ArrayList<Autor>();	
	listaAutores = ctrl.getAllSortedByName();

	%>
	
<div class=wrapperCenter2>
<div class="form-style-2">
<div class="form-style-2-heading">Ingrese datos del nuevo libro</div>


<form action="ModificarLibro" method="post">

	
	<input type="hidden" name="aIdLibro" value= "${libroVar.getIdLibro()}">
	<label for="Titulo"><span>Titulo:<span class="required">*</span></span><input type="text" class="input-field" name="aTitulo" value= "${libroVar.titulo}" required ></label> <br>
	<label for="nroEdicion"><span>Nro edicion:<span class="required">*</span></span><input type="text" class="input-field" name="aNroEdicion" value="${libroVar.nroEdicion}"   required ></label> <br>
	<label for="isbn"><span>ISBN:<span class="required">*</span></span><input type="text" class="input-field" name="aISBN" value="${libroVar.isbn}"  required ></label> <br>
	<label for="descripcion"><span>Descripcion:<span class="required">*</span></span><input type="text" class="input-field" name="aDescripcion" value="${libroVar.descripcion}"  required ></label> <br>
	<label for="precio"><span>Precio:<span class="required">*</span></span><input type="text" class="input-field" name="aPrecio" value="${libroVar.precio}"  required  ></label> <br>
	<label for="editorial"><span>Editorial:<span class="required">*</span></span><input type="text" class="input-field" name="aEditorial" value="${libroVar.editorial}"  required ></label> <br>
	<label for="genero"><span>Genero:<span class="required">*</span></span><input type="text" class="input-field" name="aGenero" value="${libroVar.genero}"  required ></label> <br>
	<label for="Autor"><span>Autor</span><select name="aAutor" class="select-field">
	<option selected="selected" value= "${libroVar.getAutor().getIdAutor() }"  >${libroVar.getAutor().getNombre()}</option>
	<% for (Autor a : listaAutores) { %>
	
	<option   value= <%=a.getIdAutor()%>> <%=a.getNombre() %> </option>
	
	<% } %>

	
	
	</select></label>
	<label for="CantPropia"><span>Cantidad Propia inicial:<span class="required">*</span></span><input type="text" class="input-field" name="aCantPropia" value="${libroVar.cantidadPropia}" required ></label> <br>
	<label for="CantConsignada"><span>Cantidad consignada inicial:<span class="required">*</span></span><input type="text" class="input-field" name="aCantConsignada" value="${libroVar.getCantidadConsignada()}" required ></label> <br>
	<label><span> </span><input type="submit" value="Modificar" /></label>


</form>






</div>
</div>



<div class=wrapperRight>
<form action="ModificarLibro.jsp">
	<input type="submit" class="botonGris" value="Volver" >
</form>
</div>




</body>
</html>