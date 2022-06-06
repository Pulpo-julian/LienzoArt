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
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
	<script defer type="text/javascript" src="../scripts/sesion.js"></script>
    <title>Iniciar Sesion en LienzoArt</title>
</head>
<body>

    <div class="container">
    
		<!-- HEADER -->
		<jsp:include page="../commons/header.jsp"></jsp:include>
		
		
		<div class="formulario">
		
			<form action="" method="post">
			
				<div class="email">
				
					<label>Correo electronico</label>
					<input type="text" placeholder="correo" id="correo" name="correo">
					
					
				</div>
				
				<div class="contraseña">
				
					<label>Contraseña</label>
					<input type="password" placeholder="contraseña" id="password" name="password">
					
					
				</div>
				
				<input type="submit" name="botonsesion" value="iniciar sesión" class="boton_mov">
			
			</form>
			
			<div class="registro">
			
				<h6>¿No tienes una cuenta? <a href="#">Registrate</a> </h6>
			
			</div>
			
		
		</div>



   	</div>
    
    

    
</body>
</html>