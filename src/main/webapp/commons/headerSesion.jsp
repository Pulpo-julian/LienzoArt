<%String buscar = (String) request.getAttribute("buscar"); %>
<head>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../estilos/estilosheadersesion.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
    
    <header class="header row gx-5"> <!-- Inicio header -->
    
    	
        <div class="logo col-2">
            <a href="/CrudNuevoLienzoArt/controlprincipal"> <img src="img/logoindex.png"> </a>
        </div>
    
        <div class="buscador col-6">
        	
        	<form action="/CrudNuevoLienzoArt/controlprincipal" id="buscarForm">
        		<input type="search" id="buscador" name="buscar" class="buscar" placeholder="Buscar..." value="<%if(buscar != null && !buscar.isEmpty()) {out.println(buscar);} %>">
        	</form>
    
            <div id="btnbuscar" class="btn">
            	<button type="submit" form="buscarForm"><i class="fas fa-search"></i></button>
            </div>
        </div>
    
    
        <div class="micuenta dropdown col-1"> 
        	<button type="button" class="btn btn-secondary dropdown-toggle" id="simpleDropdown" data-bs-toggle="dropdown" aria-expanded="false">
        		Mi cuenta
        	</button>
        	<ul class="dropdown-menu">
        		<li><a href="#" class="dropdown-item">Configuración</a></li>
        		<li><a href="#" class="dropdown-item">Crear tienda</a></li>
        		<li><a href="#" class="dropdown-item">Cerrar sesión</a></li>
        	</ul>
        </div>
        
        <div class="carrocompras col-1">
        
             <form action="/CrudNuevoLienzoArt/controlsesion" method="post">            		 		
                <input type="submit" name="carrocompras" value="carrocompras" class="btncrearusuario">
             </form>                                
    
        </div>
                    
    </header>