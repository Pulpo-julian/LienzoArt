$(document).ready(() => {
	
	$(".respuestabusqueda").hide();

	$("#btnbuscar").click((event) => {
		
		
		buscar();
		
		
	});
	
	$("#buscador").keyup((event) => {
		
		if(event.keyCode == 13){
			
			buscar()
			
		}
		
	});
	
	
	
	function buscar(){
		
		var buscar = $("#buscador").val();
		
		if(buscar != ""){
			
			$.post("barrabusqueda", {buscar: buscar}, (responseText) => {
				
				//$(".seccion").html(responseText);
				
				if(responseText.length > 0) {
					
					$(".seccion").html("");
					
					$(".respuestabusqueda").show();
					
					$("#titulorespuesta").html("Productos relacionados con: \"" + buscar + "\"");
					
					var productosHtml = "";
					
					$.each( responseText , function (key, value) => {
						
					productosHtml += "<div class=\"producto\">";
					
					productosHtml += "<div class=\"muestra\">";
					
					productosHtml += "		<img alt=\"#\" src=\"\">";
							
								
					productosHtml += "		<h3>" + value.nombre + "</h3>";
					
					productosHtml += "</div>";
							
					productosHtml += "<div class=\"informacion\">";
							
					productosHtml += "<ul class=\"listaproducto\">";
									
									<li> <h5>Categoria: <% out.print(producto.getCategoria()); %></h5> </li>
									<li> <h5>Estado: <% out.print(producto.getEstado()); %></h5> </li>
									<li> <h5>Existencia: <% out.print(producto.getExistencia()); %></h5> </li>
									<li> <h5>Tienda: <a href="#"><% out.print(producto.getTienda()); %></a> </h5> </li>
									
								</ul>
							
							</div>
							
						</div>
						
					});

					
					
					
					
					console.log(responseText);	
				} else {
					
					$(".seccion").html("");
					
					$(".respuestabusqueda").show();
					
					$("#titulorespuesta").html("No hay productos relacionados con: \"" + buscar + "\"");
				}
				
				console.log(responseText.length);
				
				
			});
			
				
		} else {
			return;
		}
		
		
		
	}
	
	
});