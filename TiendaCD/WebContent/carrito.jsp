<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Capa_de_Entidades.Usuario"%>
<%@ page import="Capa_de_Entidades.Disco"%>
<%@ page import="Capa_de_Entidades.Descuento"%>
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
<body>
   <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand">TiendaCD</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <li><a href="discos.jsp">Discos</a></li> 
          <li class="active"><a href="carrito.jsp">Carrito de compras</a></li>
        </ul>
      </div>
    </div>
  </nav>
  

  
<div class="container" style="background-color:#aaa">
	<br><br><br><br>
	<div class="col-sm-11.5 col-sm-offset-0.5" style="background-color:#ccc">
 		<div class="container">
  		<h3>Carrito de Compras</h3>
   		</div>
 	</div>
 	<div class="col-sm-11.5 col-sm-offset-0.5">
     <table class="table table-hover" style="background-color:#ffffff">
       <thead> 
         <tr> 
           <th>Título</th> 
           <th>Autor</th>
           <th>Año Lanzamiento</th>
           <th>Género</th>
           <th>Precio</th>
           <th>Quitar del carro</th>
         </tr> 
       </thead>
       <tbody>
       <%
       ArrayList<Disco> carrito = (ArrayList<Disco>) request.getSession().getAttribute("carrito");
       float monto = 0;
       if(carrito != null){
       for(int i=0; i<carrito.size(); i++){
       		Disco disco = carrito.get(i);
       		monto = monto + disco.getPrecio();
       %>
         <tr>
           <td style="vertical-align:middle"><%=disco.getTitulo()%></td>
           <td style="vertical-align:middle"><%=disco.getAutor().getNombreAutor() %></td> 
           <td style="vertical-align:middle"><%=disco.getAñoLanzamiento() %></td>
           <td style="vertical-align:middle"><%=disco.getGenero().getDescGenero() %></td>
           <td style="vertical-align:middle">$<%=disco.getPrecio() %></td>    
           <td style="vertical-align:middle">
           <form role="form" action="Carrito" method="post" id="eliminar" name="eliminar">
           	<input type="hidden" name="numero" id="numero" value="<%=i%>"/>
  			<input class="btn btn-danger btn-sm" type="submit" value="Eliminar" id="eventoEliminar" name="eventoEliminar" />
           </form>
           </td> 
         </tr>
         <% } } %>
       </tbody>
     </table>
	</div>
	
  	<div class="col-lg-8 col-lg-offset-1" style="background-color:#ccc">
 		<div class="container">
  		<h4>Subtotal: $<%=monto %></h4>
  		<%
  			Controlador con = new Controlador();
  			float dto = 0;
  			int codDto = 0;
  			for(Descuento desc : con.getDescuentos()){
  				if(monto >= desc.getMontoASuperar()){ 
  					codDto = desc.getCodDescuento();
  					dto = desc.getPorcentaje();
  				}
  			}
  			dto = dto*100;
  		%>
  		<h4>Descuento: <%=(int)dto %>%</h4>
  		<%monto= (monto - monto*dto/100); %>
  		<h3>Total: $<%=monto %></h3> 
   		</div>
   		<form role="form" action="Carrito" method="post" id="eliminar" name="eliminar">
   			<input type="hidden" name="monto" id="monto" value="<%=monto%>"/>
   			<input type="hidden" name="descuento" id="descuento" value="<%=codDto%>"/>
   			<input class="btn btn-success" type="submit" value="Confirmar Compra" id="confirmarCompra" name="confirmarCompra" />  		
		</form>
		<br>
	</div>
  	<br><br>	
</div>
</body>
</html>