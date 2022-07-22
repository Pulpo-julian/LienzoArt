<head>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="estilos/header4.css">

</head>

<header class="header">

            <div class="cabecera">

                <div class="logo">
                    <img src="img/logo.png" alt="LOGO">
                    <h6>LienzoArt</h6>
                </div>

                <div class="buscador">

					<input type="search" id="buscador" placeholder="Buscar..." >
					
					<div id="btnbuscar">
					
						<i class="fas fa-search"></i>
					
					</div>

                </div>


                <div class="usuario">
     
	                <form action="/CrudNuevoLienzoArt/controlsesion" method="post">
                		
                		<img src="img/user.png" alt="USER">
                		
                		<input type="submit" name="sesion" value="iniciar sesión">

                	</form>                                
                    

                </div>
        
        
            </div>


</header>