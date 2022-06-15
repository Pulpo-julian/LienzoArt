<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<% Map<String, String> errores = (Map<String, String>)request.getAttribute("errores"); %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="estilos/formularios.css">
<!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script defer src="scripts/main.js"></script>
<title>Registrate en LienzoArt</title>
</head>

<body>

	<div class="formulario">


		<h1>Registro</h1>
		<form action="/CrudNuevoLienzoArt/formulariousuario" method="post" class="form_usuario" novalidate>

			<div>
			
				<label class="form-label mt-4">Cédula</label> <input class="form-control" type="text" placeholder="Número de cédula"
					id="cedula" name="cedula">

				<%if(errores != null && errores.containsKey("cedula")){%>

					<h5>
						<% out.print(errores.get("cedula")); %>
					</h5>


				<%} %>



			</div>


			<div>
				<label class="form-label mt-3">Nombres</label> <input class="form-control" type="text" placeholder="Juan"
					id="nombre" name="nombre">

				<%if(errores != null && errores.containsKey("nombre")){%>

					<h5>
						<% out.print(errores.get("nombre")); %>
					</h5>


				<%} %>

			</div>

			<div>
				<label class="form-label mt-3">Apellidos</label> <input class="form-control" type="text"
					placeholder="Pérez lópez" id="apellidos" name="apellidos">
				<%if(errores != null && errores.containsKey("apellidos")){%>

					<h5>
						<% out.print(errores.get("apellidos")); %>
					</h5>


				<%} %>

			</div>

			<div>
				<label class="form-label mt-3">Correo electrónico</label> <input class="form-control" type="text" placeholder="mrcatsiames@gmail.com"
					id="correo" name="correo">

				<%if(errores != null && errores.containsKey("correo")){%>

					<h5>
						<% out.print(errores.get("correo")); %>
					</h5>


				<%} %>


			</div>

			<div>
				<label class="form-label mt-3">Contraseña</label> <input class="form-control" type="password"
					placeholder="Contraseña" id="password" name="password">
				<%if(errores != null && errores.containsKey("password")){%>

					<h5>
						<% out.print(errores.get("password")); %>
					</h5>


				<%} %>

			</div>

			<div>
				<label class="form-label mt-3">Número de contacto</label> <input class="form-control" type="text" placeholder="3100000000"
					id="telefono" name="telefono">
				<%if(errores != null && errores.containsKey("telefono")){%>

					<h5>
						<% out.print(errores.get("telefono")); %>
					</h5>


				<%} %>

			</div>

			<div class="p_ciudades">
				<p class="form-label mt-3">Seleccione su Ciudad</p>
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
				<%if(errores != null && errores.containsKey("ciudades")){%>

					<h5>
						<% out.print(errores.get("ciudades")); %>
					</h5>


				<%} %>

			</div>

			<div>
				<label class="form-label mt-3">Código postal</label> <input class="form-control" type="text"
					placeholder="050000" id="codigoPostal"
					name="codigoPostal">
				<%if(errores != null && errores.containsKey("codigoPostal")){%>

					<h5>
						<% out.print(errores.get("codigoPostal")); %>
					</h5>


				<%} %>

			</div>

			<div>
				<label class="form-label mt-3">Dirección</label> <input class="form-control" type="text"
					placeholder="cra x #xx-xx" id="direccion" name="direccion">
				<%if(errores != null && errores.containsKey("direccion")){%>

					<h5>
						<% out.print(errores.get("direccion")); %>
					</h5>


				<%} %>

			</div>

			<input type="submit" name="crud" value="Crear" class="boton_mov col-12 mt-3">

		</form>




	</div>




</body>

</html>