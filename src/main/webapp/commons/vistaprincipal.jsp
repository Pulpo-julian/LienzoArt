<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="modelos.Producto"%>

<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="stylesheet" href="./estilos/indexstyle.css">
    <title>Bienvenido a LienzoArt</title>
</head>
<body>

    <div class="container">

        <header class="header">

            <div class="cabecera">

                <div class="logo">
                    <img src="img/sena-logo.png" alt="LOGO">
                    <h6>LienzoArt</h6>
                </div>

                <div class="buscador">

                    <li>
                        <a href="#">
                          <i class="fas fa-search"></i>
                          <h6>buscar...</h6>
                        </a>
                    </li>

                </div>


        
                <div class="lista">
                    <ul>
                        <li>
                            <a href="#">item1</a>
                        </li>
                        <li>
                            <a href="#">item2</a>
                        </li>
                        <li>
                            <a href="#">item3</a>
                        </li>
                        <li>
                            <a href="#">item4</a>
                        </li>
                        <li>
                            <a href="#">item5</a>
                        </li>
                        <li>
                            <a href="#">item6</a>
                        </li>
                    </ul>
                </div>
        
                <div class="usuario">
                    <img src="img/user.png" alt="USER">
                    <p>
                        iniciar Sesion;
                    </p>
                </div>
        
        
            </div>


        </header>


		<div class="principal">
			
			<aside class="categorias">
				
				
			
			</aside>		
		
		
	    	<main class="seccion">
    
	    		<%if (productos != null && productos.size() > 0) {%>
			
					<% for(Producto producto: productos){ %>
					
						<div class="producto">
							
							<div class="muestra">
								<img alt="#" src="">
								<h3><% out.print(producto.getNombre());%></h3>
							</div>
							
							<div class="informacion">
							
								<ul class="listaproducto">
									
									<li> <h5>Categoria: <% out.print(producto.getCategoria()); %></h5> </li>
									<li> <h5>Estado: <% out.print(producto.getEstado()); %></h5> </li>
									<li> <h5>Existencia: <% out.print(producto.getExistencia()); %></h5> </li>
									<li> <h5>Tienda: <a href="#"><% out.print(producto.getTienda()); %></a> </h5> </li>
									
								</ul>
							
							</div>
							
						</div>
						
					<%} %>
				
			
				<%} %>

    		</main>		
			
		
		</div>



    </div>
    
    

    
</body>
</html>




