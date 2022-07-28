<%@ page import="java.util.List"%>
<%@ page import="modelos.Producto"%>
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
	
	
	
	    <div class="row">
		<%if (productos != null && productos.size() > 0) {%>
		
			<% for(Producto producto: productos){ %>
			
				<div class="producto card col-2">
					
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
		</div>
	</main>




</div>


    		
    		
    		
    		