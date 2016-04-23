<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Capa_de_Control.Controlador" %>
<%@ page import="Capa_de_Entidades.Descuento"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TiendaCD</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
     <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand">TiendaCD</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <li><a href="discosAdmin.jsp">Discos</a></li> 
          <li><a href="autoresAdmin.jsp">Autores</a></li>
          <li><a href="generosAdmin.jsp">Géneros</a></li>
          <li class="active"><a href="descuentosAdmin.jsp">Descuentos</a></li>           
          <li><a href="usuariosAdmin.jsp">Usuarios</a></li> 
        </ul>
      </div>
    </div>
  </nav>
  
  <div class="container" style="background-color:#aaa">
	<br><br><br>

  <div class="container">  
    <div class="col-sm-8 col-sm-offset-2" style="background-color:#ffffff">
  	  <br>
  	  <form role="form" action="DescuentosAdmin" method="post" id="formBuscar" name="formBuscar">
  	  <table align="center" style="background-color:#ffffff" >
		<tr>
			<td><b>Código:</b></td>
			<td> 
				 <div class = "form-inline">
					<input type="text" class="form-control" id="codigoDto" name="codigoDto" value="<%if(request.getAttribute("codigoDto")!=null){%><%=request.getAttribute("codigoDto") %><% }%>" placeholder="Dejar campo vacío para agregar nuevo autor" size="43">
					<input class="btn btn-primary" type="submit" value="Buscar" id="buscarDescuento" name="buscarDescuento"/>
				 </div>
			</td>
		</tr>
		<tr>
			<td><b>Monto a Superar:</b></td>
			<td><input type="text" class="form-control" id="monto" name="monto" value="<%if(request.getAttribute("monto")!=null){%><%=request.getAttribute("monto") %><% }%>"></td>
		</tr>
		<tr>
			<td><b>Porcentaje:</b></td>
			<td><input type="text" class="form-control" id="porcentaje" name="porcentaje" value="<%if(request.getAttribute("porcentaje")!=null){%><%=request.getAttribute("porcentaje") %><% }%>"></td>
		</tr>
	</table>
	<br>
	<div align="center">
	<input class="btn btn-success" type="submit" value="Agregar Nuevo" id="nuevoDescuento" name="nuevoDescuento"/>
  	<input class="btn btn-primary" type="submit" value="Modificar" id="modificarDescuento" name="modificarDescuento"/>
  	<input class="btn btn-danger" type="submit" value="Dar de baja" id="eliminarDescuento" name="eliminarDescuento"/>
    </div>
    </form>
	<br>
  </div>
  </div>
  <br>
	
	<div class="col-sm-11.5 col-sm-offset-0.5" style="background-color:#ccc">
		<div class="container">
		<h3>Usuarios</h3>
 		</div>
	</div>
	<div class="col-sm-11.5 col-sm-offset-0.5">
     <table class="table table-hover" style="background-color:#ffffff">
       <thead> 
         <tr> 
           <th>Código</th>
           <th>Monto a superar</th>
           <th>Porcentaje</th> 
         </tr> 
       </thead>
       <tbody>
			<%
			Controlador con = new Controlador();
           ArrayList<Descuento> descuentos = con.getDescuentos();
           for(int i=0; i<descuentos.size(); i++){
           Descuento desc = descuentos.get(i);						%>
         <tr>
           <td><%=desc.getCodDescuento()%></td>
           <td>$<%=desc.getMontoASuperar() %></td>
           <% float porc = desc.getPorcentaje() * 100; %>
           <td><%=(int)porc%>%</td>
         </tr>
         <%} %>
       </tbody>
     </table>
  </div>
	
  </div>
</body>
</html>