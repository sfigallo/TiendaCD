<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <a class="navbar-brand" href="#">TiendaCD</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <li><a href="#">Discos</a></li> 
          <li><a href="#">Autores</a></li>
          <li><a href="#">Géneros</a></li>          
          <li class="active"><a href="#">Usuarios</a></li> 
          <li><a href="#">Carrito de compras</a></li>
        </ul>
      </div>
    </div>
  </nav>

<div class="container" style="background-color:#aaa">
	<br><br><br>
	<div class="col-sm-11.5 col-sm-offset-0.5" style="background-color:#ccc">
		<div class="container">
		<h3>Usuarios</h3>
 		</div>
	</div>
	<div class="col-sm-11.5 col-sm-offset-0.5">
     <table class="table table-hover" style="background-color:#ffffff">
       
       <thead>
       	<tr>
       		<th>Datos del usuario</th>
 			<th>Acción</th>
       	</tr>
       </thead>
       <tbody>
         <tr>
         	<td><b>Usuario:</b> sfigallo<br>
         		<b>Nombre:</b> Sofía<br>
         		<b>Apellido:</b> Figallo<br>
         		<b>Fecha Nacimiento:</b> 22/09/1994<br>
         		<b>DNI:</b> 388533128<br>
         	</td>
         	<td style="vertical-align:middle">
         		<input class="btn btn-danger" type="submit" value="Eliminar" id="eliminarUsu" name="eliminarUsu" />
         	</td>
         </tr>
        </tbody>
     </table>
  </div>
</div>
</body>
</html>