<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Capa_de_Entidades.Disco"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Capa_de_Control.Controlador" %>
<%@ page import="Capa_de_Entidades.Autor" %>
<%@ page import="Capa_de_Entidades.GeneroMusical" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TiendaCD</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<%Controlador controlador = new Controlador(); %>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
     <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">TiendaCD</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Discos</a></li> 
          <li><a href="#">Autores</a></li>
          <li><a href="#">Géneros</a></li>          
          <li><a href="#">Usuarios</a></li> 
          <li><a href="#">Carrito de compras</a></li>
        </ul>
      </div>
    </div>
  </nav>

<div class="container" style="background-color:#aaa">
  <br><br><br>
  <div class="container">  
	<div align="center">
	
	<!-- Formulario buscar INICIO -->
	
  	<form role="form" action="DiscosAdmin" method="post" id="formBuscar" name="formBuscar">
      <div class="form-inline">
        <input type="text" class="form-control" id="titBuscar" name="titBuscar" placeholder="¿Qué está buscando?" size="60" maxlength="45" style="height:100">
  		<input class="btn btn-primary" type="submit" value="Buscar" id="eventoBuscar" name="eventoBuscar"/>
  	  </div>
    </form>
    
    <!-- Formulario buscar FIN -->
    
    </div>
  	<br>
	  <div class="col-sm-8 col-sm-offset-2" style="background-color:#ffffff">
  	  <br>
  	  <form role="form" action="DiscosAdmin" method="post" id="formBuscar" name="formBuscar">
  	  <table align="center" style="background-color:#ffffff" >
		<tr>
			<td><b>Título:</b></td>
			<td><input type="text" class="form-control" id="tituloDisco" name="tituloDisco" value="<%if(request.getAttribute("tituloDisco")!=null){%><%=request.getAttribute("tituloDisco") %><% }%>" size="55"></td>
		</tr>
		<tr>
			<td><b>Código:</b></td>
			<td> 
				 <div class = "form-inline">
					<input type="text" class="form-control" id="codigoDisco" name="codigoDisco" value="<%if(request.getAttribute("codigoDisco")!=null){%><%=request.getAttribute("codigoDisco") %><% }%>" placeholder="Dejar campo vacío para agregar nuevo disco" size="43">
					<input class="btn btn-primary" type="submit" value="Buscar" id="buscarDisco" name="buscarDisco"/>
				 </div>
			</td>
		</tr>
		<tr>
			<td><b>Autor:</b></td>
			<td>
 				<select class="form-control" id="selectAutor" name="selectAutor">
 				<option><%if(request.getAttribute("autorDisco")!=null){%> <%= request.getAttribute("autorDisco") %> <%}%></option>
 				<%
           		ArrayList<Autor> autores = controlador.getAutores();
          	 	for(Autor autor : autores){
           		%>
 		   		<option><%=autor.getNombreAutor()%></option>
 		   		<%} %>
  				</select>
			</td>
		</tr>
		<tr>
			<td><b>Género:</b></td>
			<td>
 				<select class="form-control" id="selectGenero" name="selectGenero">
 		   		<option><%if(request.getAttribute("generoDisco")!=null){%> <%= request.getAttribute("generoDisco") %> <%}%></option>
  				<%
           		ArrayList<GeneroMusical> generos = controlador.getGeneros();
          	 	for(GeneroMusical genero : generos){
           		%>
 		   		<option><%=genero.getDescGenero()%></option>
 		   		<%} %>
  				</select>
			</td>
		</tr>
		<tr>
			<td><b>Año Lanzamiento: </b></td>
			<td><input type="text" class="form-control" id="añoDisco" name="añoDisco" value="<%if(request.getAttribute("añoDisco")!=null){%><%=request.getAttribute("añoDisco") %><% }%>"></td>
		</tr>
		<tr>
			<td><b>Precio:</b></td>
			<td><input type="text" class="form-control" id="precioDisco" name="precioDisco" value="<%if(request.getAttribute("precioDisco")!=null){%><%=request.getAttribute("precioDisco") %><% }%>"></td>
		</tr>
		<tr>
			<td><b>Stock:</b></td>
			<td><input type="text" class="form-control" id="stockDisco" name="stockDisco" value="<%if(request.getAttribute("stockDisco")!=null){%><%=request.getAttribute("stockDisco") %><% }%>"></td>
		</tr>
	</table>
	<br>
	<div align="center">
	<input class="btn btn-success" type="submit" value="Agregar Nuevo" id="nuevoDisco" name="nuevoDisco"/>
  	<input class="btn btn-primary" type="submit" value="Modificar" id="modificarDisco" name="modificarDisco"/>
  	<input class="btn btn-danger" type="submit" value="Dar de baja" id="eliminarDisco" name="eliminarDisco"/>
    </div>
    </form>
	<br>
  </div>
  </div>
  <br>
  <div class="col-sm-11.5 col-sm-offset-0.5" style="background-color:#ccc">
 	<div class="container">
  	<h3>Discos</h3>
   	</div>
  </div>
  <div class="col-sm-11.5 col-sm-offset-0.5">
     <table class="table table-hover" style="background-color:#ffffff">
       <thead> 
         <tr> 
           <th>Título</th>
           <th>Código</th> 
           <th>Autor</th>
           <th>Año Lanzamiento</th>
           <th>Género</th>
           <th>Precio</th>
           <th>Stock</th>
         </tr> 
       </thead>
       <tbody> <%  
       	   	if(request.getAttribute("discos")==null){
           		ArrayList<Disco> discos = controlador.getDiscos();
           		for(int i=0; i<discos.size(); i++){
           		Disco disco = discos.get(i);										%>
         <tr>
           <td><%= disco.getTitulo() %></td>
           <td><%= disco.getCodDisco() %></td>
           <td><%= disco.getAutor().getNombreAutor() %></td> 
           <td><%= disco.getAñoLanzamiento() %></td>
           <td><%= disco.getGenero().getDescGenero() %></td>
           <td>$<%= disco.getPrecio() %></td>
           <td><%= disco.getCantCopiasDisp() %></td>
         </tr>
         <% 	} 
           	}else {
        		ArrayList<Disco> discos = (ArrayList<Disco>)request.getAttribute("discos");
        		for(Disco disco : discos){%>
        <tr>
           <td><%= disco.getTitulo() %></td>
           <td><%= disco.getCodDisco() %></td>
           <td><%= disco.getAutor().getNombreAutor() %></td> 
           <td><%= disco.getAñoLanzamiento() %></td>
           <td><%= disco.getGenero().getDescGenero() %></td>
           <td>$<%= disco.getPrecio() %></td>
           <td><%= disco.getCantCopiasDisp() %></td>
         </tr>
        		<%}
         	}%>
       </tbody>
     </table>
  </div>
</div>
</body>
</html>