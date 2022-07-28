<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.List"%>
<%@ page import="modelos.Categoria"%>
<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="estilos/register.css">

<!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script defer src="scripts/validacionBootStrap.js"></script>
<title>Registrate en LienzoArt</title>
</head>

<body>

	<div class="formulario">


		<h1>Registro Producto</h1>
		<form action="/CrudNuevoLienzoArt/formularioproducto" method="post" class="form_usuario" enctype="multipart/form-data">

			<div>
			
				<label class="form-label mt-4">Nombre del producto</label>
				<input class="form-control" type="text" id="nombre" name="nombre">	
				
			</div>


			<div>
				<label class="form-label mt-3">Descripcion</label> 
				<input class="form-control" type="text" id="descripcion" name="descripcion">
			</div>

			<div>
				<label class="form-label mt-3">Precio</label> 
				<input class="form-control" type="number" id="precio" name="precio">

			</div>

			<div>
				<label class="form-label mt-3">Existencia</label> 
				<input class="form-control" type="number" id="existencia" name="existencia">

			</div>

			<div class="p_estados">
			
				<p class="form-label mt-3">Seleccione el estado del producto</p>
				<select name="estado" id="" class="form-select">
					<option>--</option>
					<option value="1">Disponible</option>
					<option value="2">No disponible</option>
				</select>
				
			</div>
			
			<div class="p_categorias">
			
				<p class="form-label mt-3">Seleccione la categoria del producto</p>
				<select name="categoria" id="" class="form-select">
					
					<option value="">--</option>
				
					<%if(categorias != null) {%>
						
						<%for (Categoria categoria: categorias) {%>
							
							<option value="<% out.print(categoria.getCodigo()); %>"><% out.print(categoria.getNombre()); %></option>
						
						<%} %>
						
					<%} %>
						
				</select>
			</div>


			<div>
				<label class="form-label mt-3">Tienda</label> 
				<input class="form-control" type="text" placeholder="codigo de tienda" id="tienda" name="tienda">
			</div>
			
			<div>
				<label class="form-label mt-3">Seleccione un archivo de imagen del producto</label> 
				<input class="form-control" type="file" id="imagenes" name="imagenes">
			</div>
			

			<input type="submit" name="productocrear" value="Crear" class="btn btn-primary col-12 mt-3 boton-enviar">

		</form>


	</div>




</body>

</html>