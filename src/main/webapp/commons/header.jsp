<head>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="estilos/header16.css">

</head>

<header class="header row"> <!-- Inicio header -->

	<div class="logo col-3">
    	<img src="img/logoindex.png" alt="LOGO">
	</div>

    <div class="buscador col-3 navbar navbar-expand-lg navbar-light border-6">
		<input type="search" id="buscador" placeholder="Buscar..." >

		<div id="btnbuscar">
			<i class="fas fa-search"></i>
		</div>
    </div>


	<div class="usuario col-3">
    
         <form action="/CrudNuevoLienzoArt/controlsesion" method="post">            		
         	<img src="img/user.png" alt="USER"> 		
            <input type="submit" name="sesion" value="iniciar sesión">
 		</form>                                

	</div>
                
</header>