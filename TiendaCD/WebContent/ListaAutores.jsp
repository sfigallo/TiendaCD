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
          <li><a href="#">Discos</a></li> 
          <li class="active"><a href="#">Autores</a></li>
          <li><a href="#">Carrito de compras</a></li> 
        </ul>
      </div>
    </div>
  </nav>

<div class="container" style="background-color:#aaa">
  <br><br><br>
  <div align="center">
  	<form role="form" class="form-inline" action="ListaAutores" method="post" id="formBuscar" name="formBuscar">
    	<input class="form-control" type="text" id="searchterm" placeholder="Ingrese el nombre del autor" size="70" maxlength="45" style="height:100"/>
  		<input class="btn btn-primary" type="submit" value="Buscar" id="eventoBuscar" name="eventoBuscar"/>
    </form>
  </div>
  <br><br><br>
  <div class="list-group" style="background-color:#ccc">
  	<div class="container">
   		<h3>Autores</h3>
   	</div>
 	 <a href="#" class="list-group-item">Autor 1</a>
  </div>
</div>
</body>
</html>