package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Categoria;
import modelos.Producto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import dao.DaoCategoria;
import dao.DaoProducto;

/**
 * Servlet implementation class CtrIndex
 */
@WebServlet("/controlprincipal")
public class CtrIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		
		String accion = request.getParameter("accion");
		
		if(accion == null) {
			
			try {
				
				DaoProducto daoPro = new DaoProducto();
				DaoCategoria daoCat = new DaoCategoria();
				
				
				List<Producto> productos = daoPro.listar();
				List<Categoria> categorias = daoCat.listar();
				
				request.setAttribute("productos", productos);
				request.setAttribute("categorias", categorias);
				
				
				
				getServletContext().getRequestDispatcher("/vistas/vistaprincipal.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
		
		// cuando se elija la categoria entra en este else
		} else  {
			
			try {
				
				int codigoCategoria = Integer.parseInt(request.getParameter("idcategoria"));
								
				DaoProducto daoPro = new DaoProducto();
				DaoCategoria daoCat = new DaoCategoria();
				
				List<Producto> productos = daoPro.listarPorCategoria(codigoCategoria);
				List<Categoria> categorias = daoCat.listar();
				
				request.setAttribute("categorias", categorias);
				request.setAttribute("productos", productos);
				request.setAttribute("accion", accion);
				
				getServletContext().getRequestDispatcher("/vistas/vistaprincipal.jsp").forward(request, response);
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace(System.out);
				
			} 
			
		}
		
		

		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//List<String> nombres = new ArrayList<String>();
		
		//nombres.map()
		 
		
		//doGet(request, response);
	}
	
	
	
	
	

}
