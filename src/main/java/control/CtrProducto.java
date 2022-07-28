package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.GuardarImagen;

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
		
		if(accion.equals("Crear")) {
			
			GuardarImagen guardarImagen = new GuardarImagen();
			
		}
		
		System.out.println(urlCarpetaImagenes);
		
		String sSistemaOperativo = System.getProperty("os.name");
		System.out.println(sSistemaOperativo);
		
		
	
	}

}