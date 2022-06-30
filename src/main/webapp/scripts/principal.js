$(document).ready(() => {
	

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
				
				console.log(responseText);
				
			});
			
				
		} else {
			return;
		}
		
		
		
	}
	
	
});