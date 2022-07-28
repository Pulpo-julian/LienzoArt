package modelos;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.http.Part;

public class GuardarImagen {
	
	private String imagenEnDirectorio(Part part, File fotoSubida, String ruta) {
		
		String rutaRetornar = "";
		
		rutaRetornar = ruta;
		
		try {
			
			Path rutaFotoSubida = Paths.get(part.getSubmittedFileName());
			
			String nombreFotoSubida = rutaFotoSubida.getFileName().toString();
			
			InputStream binarioFotoSubida = part.getInputStream();
			
			if(binarioFotoSubida != null) {
				
				//donde debo corregir en caso de errores
				File archivoDeFoto = new File(fotoSubida, nombreFotoSubida);
				rutaRetornar = archivoDeFoto.getAbsolutePath();
				Files.copy(binarioFotoSubida, archivoDeFoto.toPath());
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		return rutaRetornar;
		
	}
	
	private boolean validarExtension(String nombreRuta, String[] extenciones) {
		
		for(String extencion: extenciones) {
			
			if(nombreRuta.toLowerCase().endsWith(extencion)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	

}
