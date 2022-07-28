package modelos;

import java.io.File;
import java.io.InputStream;
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
				
				File archivoDeFoto = new File(fotoSubida, nombreFotoSubida);
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		return rutaRetornar;
		
	}

}
