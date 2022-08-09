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
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import dao.DaoProducto;
import dao.DaoUsuario;

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
		
		String accion = request.getParameter("productocrear");	
		
		//En caso de desplegar la app en un servidor se usa esta variable
		//String urlBase = getServletContext().getRealPath("/");
		
		//esta variable contiene la ruta donde se ubica el proyecto pero no donde se desplega el servidor
		String urlBase = System.getProperty("user.home");
		
		String urlCarpetaImagenes = urlBase + "\\git\\LienzoArt\\src\\main\\webapp\\imagenesProductos\\"; 
		
		File carpetaImagenes = new File(urlCarpetaImagenes);
		
		if(accion.equals("Crear")) {
			
			PrintWriter out = response.getWriter();
			
			Map<String, String> errores = new HashMap<String, String>();
			
			//validar nombre
			String nombre = request.getParameter("nombre");
			
			if(nombre == null || nombre.isEmpty()) {
				errores.put("nombre", "Debe asignar un nombre al producto");
			}
			
			//validar descripcion
			String descripcion = request.getParameter("descripcion");
			
			if(nombre == null || nombre.isBlank()) {
				errores.put("descripcion", "coloca una breve descripcion del producto");
			}
			
			//validar precio, debe ser int
			String precioString = request.getParameter("precio");
			
			if(precioString == null || precioString.isBlank()) {
				errores.put("precio", "asigne un precio al producto");
			}
			
			//validar existencia, debe ser int
			String existenciaString = request.getParameter("existencia");
			
			if(existenciaString == null || existenciaString.isBlank()) {
				errores.put("existencia", "ingrese la existencia disponible del producto");
			}
			
			//validar estado
			String estado = request.getParameter("estado");
			
			if(estado == null || estado.isBlank()) {

				errores.put("estado", "seleccione un estado del producto");

			}
			
			//validar categoria
			String categoria = request.getParameter("categoria");
			
			if(categoria == null || categoria.isBlank()) {
				errores.put("categoria", "seleccione una categoria para el producto");
			}
			
			//validar tienda, debe ser int
			String tiendaString = request.getParameter("tienda");
			
			if(tiendaString == null || tiendaString.isBlank()) {
				errores.put("tienda", "ingrese el codigo de la tienda");
			}
			
			//validar si hay archivo de foto
			Part imagen = request.getPart("imagen");
			
			GuardarImagen guardarImagen = new GuardarImagen();
			
			if(imagen == null) {
				errores.put("imagen", "seleccione una imagen para el producto");
			} else if( !(guardarImagen.validarExtension(imagen.getSubmittedFileName())) ) {
				errores.put("imagen", "archivo con extencion no valida");
			}
			
			if(errores.isEmpty()) {
				
				try {
					
					//logica para guardar producto						
					String urlFotoGuardada = guardarImagen.imagenEnDirectorio(imagen, carpetaImagenes);
					
					DaoProducto daoProducto = new DaoProducto();
					
					//int resultado = daoProducto.actualizarProducto(codigoProducto, urlFotoGuardada); 
					
					/*
					if(resultado != 0) {
						response.getWriter().println("Producto Actualizado");
					} else {
						response.getWriter().println("No se ha podido actualizar el producto");
					}
					*/
					
					System.out.println(urlFotoGuardada);
						

					
					
					
					
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
				
			} else {
				
				request.setAttribute("errores", errores);
				request.setAttribute("nombre", nombre);
				request.setAttribute("descripcion", descripcion);
				request.setAttribute("precio", precioString);
				request.setAttribute("existencia", existenciaString);
				request.setAttribute("estado", estado);
				request.setAttribute("categoria", categoria);
				
				getServletContext().getRequestDispatcher("/usuarioCrud/crearUsuario.jsp").forward(request, response);
				
			}
			

			
			
			
		}
		

		

		
		
	
	}

}
