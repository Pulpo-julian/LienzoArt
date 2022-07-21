<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="estilos/primerestilos.css">
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
	<script defer type="text/javascript" src="scripts/principal.js"></script>
    <title>Bienvenido a LienzoArt</title>
</head>
<body>

    <div class="container">
		
		<!-- HEADER -->
		<jsp:include page="../commons/header.jsp"></jsp:include>
		        

		<!-- SECCION PRINCIPAL -->
		<div class="principal">
			
			<!-- ASIDE CATEGORIAS -->			
			<jsp:include page="../commons/aside.jsp"></jsp:include>
		
			
			<!-- SECCION PRODUCTOS -->			
   			<jsp:include page="../commons/seccionProductos.jsp"></jsp:include>
			
		
		</div>
		
		
		<!-- SECCION FOOTER -->
		<jsp:include page="../commons/footer.jsp"></jsp:include>



   	</div>
    
    

    
</body>
</html>




