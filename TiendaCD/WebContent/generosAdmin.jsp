<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Capa_de_Control.Controlador" %>
<%@ page import="Capa_de_Entidades.GeneroMusical"%>
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
          <li><a href="discosAdmin.jsp">Discos</a></li> 
          <li><a href="autoresAdmin.jsp">Autores</a></li>
          <li class="active"><a href="generosAdmin.jsp">Géneros</a></li>          
          <li><a href="usuariosAdmin.jsp">Usuarios</a></li> 
        </ul>
      </div>
    </div>
  </nav>

<div class="container" style="background-color:#aaa">
  <br><br><br>
  <div class="container">  
	<div align="center">
	  <form role="form" action="GenerosAdmin" method="post" id="formBuscar" name="formBuscar">
      <div class="form-inline">
        <input type="text" class="form-control" id="titBuscar" name="titBuscar" placeholder="¿Qué está buscando?" size="60" maxlength="45" style="height:100">
  		<input class="btn btn-primary" type="submit" value="Buscar" id="eventoBuscar" name="eventoBuscar"/>
  	  </div>
    </form>
    </div>
    <br>
    <div class="col-sm-8 col-sm-offset-2" style="background-color:#ffffff">
  	  <br>
  	  <form role="form" action="GenerosAdmin" method="post" id="formBuscarD" name="formBuscarD">
  	  <table align="center" style="background-color:#ffffff" >
		<tr>
			<td><b>Código:</b></td>
			<td> 
				 <div class = "form-inline">
					<input type="text" class="form-control" id="codigoGenero" name="codigoGenero" value="<%if(request.getAttribute("codigoGenero")!=null){%><%=request.getAttribute("codigoGenero") %><% }%>" placeholder="Dejar campo vacío para agregar nuevo género" size="43">
					<input class="btn btn-primary" type="submit" value="Buscar" id="buscarGenero" name="buscarGenero"/>
				 </div>
			</td>
		</tr>
		<tr>
			<td><b>Nombre:</b></td>
			<td><input type="text" class="form-control" id="descGenero" name="descGenero" value="<%if(request.getAttribute("nombreGenero")!=null){%><%=request.getAttribute("nombreGenero") %><% }%>"></td>
		</tr>
	</table>
	<br>
	<div align="center">
	<input class="btn btn-success" type="submit" value="Agregar Nuevo" id="nuevoGenero" name="nuevoGenero"/>
  	<input class="btn btn-primary" type="submit" value="Modificar" id="modificarGenero" name="modificarGenero"/>
    </div>
    </form>
	<br>
  </div>
  </div>
  <br>

  <div class="col-sm-11.5 col-sm-offset-0.5" style="background-color:#ccc">
 	<div class="container">
  	<h3>Géneros</h3>
   	</div>
  </div>
  <div class="col-sm-11.5 col-sm-offset-0.5">
     <table class="table table-hover" style="background-color:#ffffff">
       <thead> 
         <tr> 
           <th>Código</th>
           <th>Nombre</th> 
         </tr> 
       </thead>
       <tbody>
       	<%
       		ArrayList<GeneroMusical> generos = controlador.getGeneros();
           for(int i=0; i<generos.size(); i++){
           GeneroMusical genero = generos.get(i);						%>
         <tr>
           <td><%=genero.getCodGenero()%></td>
           <td><%=genero.getDescGenero()%></td>
         </tr>
         <%} %>
       </tbody>
     </table>
  </div>

</div>
</body>
</html>