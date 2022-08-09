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
			
			//validar nombre
			String nombre2 = request.getParameter("nombre");
			
			if(nombre == null || nombre.isBlank()) {
				errores.put("nombre", "Debe ingresar su nombre");
			}
			
			//validar apellidos
			String apellidos = request.getParameter("apellidos");
			
			if(apellidos == null || apellidos.isBlank()) {
				errores.put("apellidos", "Debe ingresar sus apellidos");
			}
			
			//validar correo
			String correo = request.getParameter("correo");
			
			if(correo == null || correo.isBlank()) {
				errores.put("correo", "Debe ingresar su correo");
			} else if(!correo.contains("@")) {
				errores.put("correo", "El correo debe contener caracter \"@\"");
			}
			
			//validar password
			String password = request.getParameter("password");
			
			if(password == null || password.isBlank()) {

				errores.put("password", "Debe ingresar una contrase�a");

			}
			
			//validar telefono
			String telefono = request.getParameter("telefono");
			
			if(telefono == null || telefono.isBlank()) {
				errores.put("telefono", "Debe ingresar su tel�fono");
			}
			
			//validar ciudad
			String ciudad = request.getParameter("ciudades");
			
			if(ciudad == null || ciudad.isBlank()) {
				errores.put("ciudades", "Seleccione una opci�n");
			}
			
			//validar codigoPostal
			String codigoPostal = request.getParameter("codigoPostal");
			
			if(codigoPostal == null || codigoPostal.isBlank()) {
				errores.put("codigoPostal", "Debe ingresar su c�digo postal");
			}
			
			//validar direccion
			String direccion = request.getParameter("direccion");
			
			if(direccion == null || direccion.isBlank()) {
				errores.put("direccion", "Debe ingresar su direcci�n");
			}
			
			
			if(errores.isEmpty()) {
				
				try {
					DaoUsuario daoUsuario = new DaoUsuario();
					daoUsuario.insertarUsuario(cedula, nombre, apellidos, correo, 1, password, telefono, ciudad, codigoPostal, direccion);
					//getServletContext().getRequestDispatcher("CrudNuevoLienzoArt/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
					out.print("El usuario se ha creado correctamente");
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
				
			} else {
				
				request.setAttribute("errores", errores);
				request.setAttribute("cedula", cedula);
				request.setAttribute("nombre", nombre);
				request.setAttribute("apellidos", apellidos);
				request.setAttribute("correo", correo);
				request.setAttribute("password", password);
				request.setAttribute("telefono", telefono);
				request.setAttribute("ciudad", ciudad);
				request.setAttribute("codigoPostal", codigoPostal);
				request.setAttribute("direccion", direccion);
				
				getServletContext().getRequestDispatcher("/usuarioCrud/crearUsuario.jsp").forward(request, response);
				
			}
			
			
			
			
			
			GuardarImagen guardarImagen = new GuardarImagen();
			
			/*
			
			String descripcion = request.getParameter("descripcion");
			int precio = Integer.parseInt(request.getParameter("precio"));
			int existencia = Integer.parseInt(request.getParameter("existencia"));
			int estado = Integer.parseInt(request.getParameter("estado"));
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int tienda = Integer.parseInt(request.getParameter("tienda"));
			*/
			
			Part imagen = request.getPart("imagen");
			
			//parametro provisional para asignar el codigo del producto
			int codigoProducto = 13;
			
			
			//12:31 en el video 
			//debo seleccionar solo el codigo y la imagen para verificar si funciona
			
			if(imagen == null) {
				System.out.println("No se ha seleccionado el archivo");
			}
			
			if(guardarImagen.validarExtension(imagen.getSubmittedFileName())) {
				
				String urlFotoGuardada = guardarImagen.imagenEnDirectorio(imagen, carpetaImagenes);
				
				DaoProducto daoProducto = new DaoProducto();
				
				int resultado = daoProducto.actualizarProducto(codigoProducto, urlFotoGuardada); 
				
				if(resultado != 0) {
					response.getWriter().println("Producto Actualizado");
				} else {
					response.getWriter().println("No se ha podido actualizar el producto");
				}
				
				System.out.println(urlFotoGuardada);
				
			}
			
			
			
		}
		

		

		
		
	
	}

}
