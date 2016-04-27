<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Capa_de_Entidades.Disco"%>
<%@ page import="Capa_de_Entidades.Usuario"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Capa_de_Control.Controlador" %>
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
        <a class="navbar-brand">TiendaCD</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <% if(request.getSession().getAttribute("usuario") != null){ %>
          <li class="active"><a href="discos.jsp">Discos</a></li> 
          <li><a href="carrito.jsp">Carrito de compras</a></li>
          <%}
        	else{%>
        	<li><a href="inicio.jsp">Inicio</a></li>
        	<li class="active"><a href="discos.jsp">Discos</a></li>
        	<%} %>
        </ul>
      </div>
    </div>
  </nav>

<div class="container" style="background-color:#aaa">
  <br><br><br>
  <div align="center">
  	<form role="form" class="form-inline" action="Discos" method="post" id="formBuscar" name="formBuscar">
    	<input class="form-control" type="text" id="buscar" name="buscar" placeholder="¿Qué está buscando?" size="70" maxlength="45" style="height:100"/>
  		<input class="btn btn-primary" type="submit" value="Buscar" id="eventoBuscar" name="eventoBuscar"/>
    </form>
  </div>
  
  <br>

  <form role="form" class="form-inline" action="Discos" method="post" id="mostrarTodos" name="mostrarTodos">
  	<input class="btn" type="submit" value="Mostrar todos" id="mostrarTodos" name="mostrarTodos"/>
  </form>

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
       		<th>Datos del disco</th>
 			<th>Valoración</th>
 			<th>Añadir al carro</th>
       	</tr>
       </thead>
       <tbody>
       <%
       ArrayList<Disco> discos = new ArrayList<Disco>();
       if( (request.getSession().getAttribute("buscados")) == null){
    	   ArrayList<Disco> discos2 = controlador.getDiscos();
    	   for(Disco d : discos2)
    		   if(d.getCantCopiasDisp()>0)
    			   discos.add(d);
       }
       else
    	   discos = (ArrayList<Disco>) request.getSession().getAttribute("buscados");
     		
     	for(int i=0; i<discos.size(); i++){
           	Disco disco = discos.get(i);
       %>
         <tr>
         	<td><big><b>Título:</b> <%= disco.getTitulo() %><br></big>
         		<b>Autor:</b> <%= disco.getAutor().getNombreAutor() %><br>
         		<b>Año Lanzamiento:</b> <%= disco.getAñoLanzamiento() %><br>
         		<b>Género:</b> <%= disco.getGenero().getDescGenero() %><br>
         		<b>Precio:</b> $<%= disco.getPrecio() %><br>
         	</td>
         	<td style="vertical-align:middle">
         		<b>Promedio:</b> <%=disco.getValoracion() %>
         		<br>
         		<%
         		if(request.getSession().getAttribute("usuario")!=null){
         		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
         		usuario = controlador.buscarUsuario(usuario.getUsuario());
         		request.getSession().setAttribute("usuario", usuario);
         		
         		 if(usuario.getDiscosAValorar().contains(disco.getCodDisco())){
         		%>
         		<form role="form" class="form-inline" action="Discos" method="post" id="valorarDisco" name="valorarDisco">
					<select name="valor">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
					<input type="hidden" name="numero" id="numero" value="<%=i%>"/>
					<input class="btn btn-primary btn-xs" type="submit" value="Valorar" id="eventoValorar" name="eventoValorar"/>
				</form>
				<%} }%>
         	</td>
         	<td style="vertical-align:middle">
         	<form role="form" class="form-inline" action="Discos" method="post" id="comprarDisco" name="comprarDisco">
         		<input type="hidden" name="numero" id="numero" value="<%=i%>"/>
         		<input class="btn btn-success" type="submit" value="Comprar" id="eventoComprar" name="eventoComprar" />
         	</form>
         	</td>
         </tr>
		<%} %>
        </tbody>
     </table>
  </div> 
</div>
</body>
</html>