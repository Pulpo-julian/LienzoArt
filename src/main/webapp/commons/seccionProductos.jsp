<%@ page import="java.util.List"%>
<%@ page import="modelos.Producto"%>
<link rel="stylesheet" href="estilos/estiloscategoriasproductos.css">
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
<% String accion = (String) request.getAttribute("accion"); %>


<div class="seccionprincipal">

	<div class="titulocategoria">
	
		<h1 id="titulorespuesta"></h1>
	
	</div>

	<main class="seccion">
	
	
	
		<%if (accion != null && productos.size() > 0) {%>
		
			<div class="titulocategoria">
				
				<h1>Productos de Categoria: "<% out.print(productos.get(0).getCategoria()); %>"</h1>	
				
			</div>
	
		<%} else if (productos.size() == 0){ %>
		
			<div class="titulocategoria">
				
				<h1>Por el momento no hay productos de esta Categoria</h1>
			
			</div>
			
		<%} %>
	
	
	
	    <div class="flex_container">
		<%if (productos != null && productos.size() > 0) {%>
		
			<% for(Producto producto: productos){ %>
			
				<div class="producto card" style="border-radius: 10px;">
					
					<div class="muestra">
						<img alt="#" src="<% out.println(producto.getUrlImagen()); %>" class="img">
						<h4><% out.print(producto.getNombre());%></h4>
					</div>
					
					<div class="informacion">
					
						<ul class="listaproducto">
							
							<li> <h6>Categoria: 	<% out.print(producto.getCategoria()); %></h6> </li>
							<li> <h6>Estado: <% out.print(producto.getEstado()); %></h6> </li>
							<li> <h6>Existencia: <% out.print(producto.getExistencia()); %></h6> </li>
							<li> <h6>Tienda: <a href="#"><% out.print(producto.getTienda()); %></a> </h6> </li>
							
						</ul>
					
					</div>
					
				</div>
				
			<%} %>
		
		
		<%} %>
		</div>
	</main>




</div>


    		
    		
    		
    		