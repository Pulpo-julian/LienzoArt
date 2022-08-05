package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelos.GuardarImagen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CtrProducto
 */
@MultipartConfig 
@WebServlet("/formularioproducto")
public class CtrProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String accion = request.getParameter("productocrear");
		
		String urlBase = getServletContext().getRealPath("/");
		
		String urlCarpetaImagenes = urlBase + "imagenesProductos\\"; 
		
		File instaciaCarpetaImagenes = new File(urlCarpetaImagenes);
		
		if(accion.equals("Crear")) {
			
			GuardarImagen guardarImagen = new GuardarImagen();
			
			/*
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			int precio = Integer.parseInt(request.getParameter("precio"));
			int existencia = Integer.parseInt(request.getParameter("existencia"));
			int estado = Integer.parseInt(request.getParameter("estado"));
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int tienda = Integer.parseInt(request.getParameter("tienda"));
			*/
			
			Part imagen = request.getPart("imagen");
			
			//parametro provisional para asignar el codigo del producto
			int codigoProducto = 0;
			
			
			//12:31 en el video 
			//debo seleccionar solo el codigo y la imagen para verificar si funciona
			
			if(imagen == null) {
				System.out.println("No se ha seleccionado el archivo");
			}
			
			if(guardarImagen.validarExtension(imagen.getSubmittedFileName())) {
				
				String urlFotoGuardada = guardarImagen.imagenEnDirectorio(imagen, instaciaCarpetaImagenes);
				
				
				
			}
			
			
			
		}
		
		System.out.println(urlCarpetaImagenes);
		

		
		
	
	}

}
