<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




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
				<input class="form-control" type="number" placeholder="Número de cédula" id="cedula" name="cedula">	
				
			</div>


			<div>
				<label class="form-label mt-3">Descripcion</label> 
				<input class="form-control" type="text" placeholder="Juan" id="nombre" name="nombre">

			</div>

			<div>
				<label class="form-label mt-3">Precio</label> 
				<input class="form-control" type="text" placeholder="Pérez lópez" id="apellidos" name="apellidos">

			</div>

			<div>
				<label class="form-label mt-3">Existencia</label> 
				<input class="form-control" type="text" placeholder="correo@gmail.com" id="correo" name="correo">

			</div>

			<div>
				<label class="form-label mt-3">Contraseña</label> 
				<input class="form-control" type="password" placeholder="Contraseña" id="password" name="password">
				
			</div>

			<div>
				<label class="form-label mt-3">Número de contacto</label> 
				<input class="form-control" type="text" placeholder="000-000-0000" id="telefono" name="telefono">
			</div>

			<div class="p_estados">
				<p class="form-label mt-3">Seleccione estado del Producto</p>
				<select name="ciudades" id="" class="form-select">
					<option value="">Seleccionar:</option>
					<option value="05001">Medellin</option>
					<option value="05318">Guarne</option>
					<option value="05321">Guatape</option>
					<option value="05376">La ceja</option>
					<option value="05440">Marinilla</option>
					<option value="05541">El Peñol</option>
					<option value="05615">Rionegro</option>
					<option value="05649">San carlos</option>
					<option value="05656">San Jerónimo</option>
					<option value="05667">San Rafael</option>
				</select>

			</div>

			<div>
				<label class="form-label mt-3">Código postal</label> 
				<input class="form-control" type="text" placeholder="000000" id="codigoPostal" name="codigoPostal">
				
			</div>

			<div>
				<label class="form-label mt-3">Dirección</label> 
				<input class="form-control" type="text" placeholder="cra x #xx-xx" id="direccion" name="direccion">

				
			</div>
			

			<input type="submit" name="crud" value="Crear" class="btn btn-primary col-12 mt-3 boton-enviar">

		</form>


	</div>




</body>

</html>