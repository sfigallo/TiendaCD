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
          <li><a href="#">Inicio</a></li>
          <li class="active"><a href="#">Discos</a></li> 
          <li><a href="#">Autores</a></li>
          <li><a href="#">Carrito de compras</a></li>  
        </ul>
      </div>
    </div>
  </nav>

<div class="container" style="background-color:#aaa">
  <br><br><br>
  <div align="center">
  	<form role="form" class="form-inline" action="ListaDiscos" method="post" id="formBuscarD" name="formBuscarD">
    	<input class="form-control" type="text" id="searchterm" placeholder="Ingrese el título del disco" size="70" maxlength="45" style="height:100"/>
  		<input class="btn btn-primary" type="submit" value="Buscar" id="eventoBuscarD" name="eventoBuscarD"/>
    </form>
  </div>
  
  <br><br><br>

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
         <tr>
         	<td><big><b>Título:</b> Amor Amarillo<br></big>
         		<b>Autor:</b> Gustavo Cerati<br>
         		<b>Año Lanzamiento:</b> 2000<br>
         		<b>Género:</b> Rock<br>
         		<b>Precio:</b> $100<br>
         	</td>
         	<td>
         		<b>Promedio:</b> 5 puntos
         		<br>
         		<form role="form" class="form-inline" action="discos" method="post" id="valorarDisco" name="valorarDisco">
					<select name="valor">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
					<input class="btn btn-primary btn-xs" type="submit" value="Valorar" id="eventoValorar" name="eventoValorar"/>
				</form>
         	</td>
         	<td style="vertical-align:middle">
         		<input class="btn btn-success" type="submit" value="Comprar" id="eventoComprar" name="eventoComprar" />
         	</td>
         </tr>
        </tbody>
     </table>
  </div> 
</div>
</body>
</html>