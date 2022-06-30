package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Producto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.DaoBarra;

/**
 * Servlet implementation class CtrBarraBusqueda
 */
@WebServlet("/barrabusqueda")
public class CtrBarraBusqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrBarraBusqueda() {
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
		
		PrintWriter out = response.getWriter();
		
		String buscar = request.getParameter("buscar");
		
		
		try {
			
			DaoBarra daoBarra =  new DaoBarra();
			
			List<Producto> productos = daoBarra.listarProductosBusqueda(buscar);
			
			if(productos != null && productos.size() > 0) {
				
				response.setContentType("application/json");
				
				out.println(new Gson().toJson(productos, new TypeToken<List<Producto>>(){}.getType()));
				
			} else {
				
				out.print("No existen productos relacionados con: \"" + buscar + "\"");
				
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		}
		
		
		//String tituloRespuesta = "Productos relacionados con: \"" + buscar + "\"";
		
		//out.println(tituloRespuesta);
		
		//doGet(request, response);
	}

}
