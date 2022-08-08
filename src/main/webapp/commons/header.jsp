<head>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<<<<<<< HEAD
    <link rel="stylesheet" href="estilos/estilosbarrabusqueda.css">
=======
    <link rel="stylesheet" href="estilos/header19.css">
>>>>>>> c70c021b6101f9ce4ee3ec5bd1fc5ad954a11944
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
    
    <header class="header row"> <!-- Inicio header -->
    
    	
        <div class="logo col-2">
            <a href="/CrudNuevoLienzoArt/controlprincipal"> <img src="img/logoindex.png"> </a>
        </div>
    
        <div class="buscador col-6">
            <input type="search" id="buscador" class="buscar" placeholder="Buscar..." >
    
            <div id="btnbuscar" class="btn">
                <i class="fas fa-search"></i>
            </div>
        </div>
    
    
        <div class="usuario_login col-2">
        
             <form action="/CrudNuevoLienzoArt/controlsesion" method="post">            		 		
                <input type="submit" name="sesion" value="Iniciar sesión" class="btniniciarsesion">
             </form>                                    
    
        </div>
        
        <div class="usuario_register col-2">
        
             <form action="/CrudNuevoLienzoArt/controlsesion" method="post">            		 		
                <input type="submit" name="registro" value="Regístrate" class="btncrearusuario">
             </form>                                
    
        </div>
                    
    </header>