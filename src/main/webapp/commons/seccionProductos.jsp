<%@ page import="java.util.List"%>
<%@ page import="modelos.Producto"%>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
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
    		
    		
    		
    		