<%@ page import="java.util.List"%>
<%@ page import="modelos.Categoria"%>
<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>
<aside class="categorias">

	<h1>Categorias</h1>


	
		<blockquote class="categoria">
		
		
		
			<ul class="lista">
				<%for(Categoria categoria: categorias) { %>			
					<li>
						<a href="/CrudNuevoLienzoArt/controlprincipal?idcategoria=<% out.print(categoria.getCodigo()); %>&accion=listarporcategoria"><% out.print(categoria.getNombre()); %></a>				
					</li>
				<%} %>		
			</ul>
		

			
			
		
		</blockquote>
	
	

</aside>