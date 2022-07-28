<head>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<%@ page import="java.util.List"%>
<%@ page import="modelos.Categoria"%>
<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>
<aside class="categorias">

	<h1 class="title_categories">Categorias</h1>


	
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