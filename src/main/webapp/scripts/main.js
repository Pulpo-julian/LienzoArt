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
					
					responseText.forEach((value)  => {
						
						productosHtml += "<div class=\"producto\">";
						
						productosHtml += "		<div class=\"muestra\">";
						
						productosHtml += "			<img alt=\"#\" src=\"\">";
								
									
						productosHtml += "			<h3>" + value.nombre + "</h3>";
						
						productosHtml += "		</div>";
								
						productosHtml += "		<div class=\"informacion\">";
								
						productosHtml += "				<ul class=\"listaproducto\">";
										
						productosHtml += "					<li> <h5>Categoria:" + value.categoria + "</h5> </li>";
						
						productosHtml += "					<li> <h5>Estado:" + value.estado + "</h5> </li>";
						
						productosHtml += "					<li> <h5>Existencia:" + value.existencia + "</h5> </li>";
						
						productosHtml += "					<li> <h5>Tienda: <a href=\"#\">" + value.tienda + "</a> </h5> </li>";
										
						productosHtml += "				</ul>";
								
						productosHtml += "		</div>";
								
						productosHtml += "</div>";
						
					});
					
					//console.log(responseText[0].codigo);
					
					$(".seccion").html(productosHtml);
						
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