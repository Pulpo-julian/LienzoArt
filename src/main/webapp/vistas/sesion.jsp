<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="stylesheet" href="../estilos/sesionstyle.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<<<<<<< HEAD
	<script defer type="text/javascript" src="../scripts/sesion.js"></script>
    <title>Iniciar Sesion en LienzoArt</title>
=======
	<script defer type="text/javascript" src="scripts/sesion.js"></script>
    <title>Iniciar sesión en LienzoArt</title>
>>>>>>> a32c61e672620ff4def7b31c5a4511e797bccf8f
</head>
<body>

    <div class="container">
    
		
		
		<div class="formulario">
		
			<form action="/CrudNuevoLienzoArt/formulariousuario" method="post">
			
				<h1>Iniciar sesión</h1>
				
				<div class="email col-10 m-3">
				
					<label for="correo" class="form-label">Correo electrónico</label>
					<input type="email" placeholder="Correo" id="correo" name="correo" class="form-control">
					
					
				</div>
				
				<div class="contraseña col-10 m-3">
				
					<label for="password" class="form-label">Contraseña</label>
					<input type="password" placeholder="Contraseña" id="password" name="password" class="form-control">
					
					
				</div>
				
				<input type="submit" name="botonsesion" value="Iniciar sesión" class="boton_mov col-10 m-3">
			
			</form>
			
			<div class="registro">
			
<<<<<<< HEAD
				<h6>¿No tienes una cuenta? <a href="/CrudNuevoLienzoArt/usuarioCrud/crearUsuario.jsp">Registrate</a> </h6>
=======
				<form action="/CrudNuevoLienzoArt/controlsesion" method="post">
					
					<h6>¿No tienes una cuenta? <input type="submit" name="sesion" value="Registrate" class="boton_mov col"> </h6>	
					
				</form>	
>>>>>>> a32c61e672620ff4def7b31c5a4511e797bccf8f
			
			</div>
			
		
		</div>



   	</div>
    
    

    
</body>
</html>