<%@ page import="java.util.List"%>
<%@ page import="modelos.Categoria"%>
<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>
<aside class="categorias">

	<h1>Categorias</h1>

	<%for(Categoria categoria: categorias) { %>
	
		<blockquote class="categoria">
		
			<h4><% out.print(categoria.getNombre()); %></h4>
		
		</blockquote>
	
	<%} %>

</aside>