<head>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="estilos/header18.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
    
    <header class="header row"> <!-- Inicio header -->
    
        <div class="logo col-2">
            <img src="img/logoindex.png" alt="LOGO">
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