package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Categoria;
import modelos.Producto;

import java.io.IOException;
import java.util.List;

import dao.DaoCategoria;
import dao.DaoProducto;

/**
 * Servlet implementation class CtrProductoListarCategorias
 */
@WebServlet("/controlProductoListarCat")
public class CtrProductoListarCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrProductoListarCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			DaoCategoria daoCat = new DaoCategoria();
			
			
			List<Categoria> categorias = daoCat.listar();
			

			request.setAttribute("categorias", categorias);
			
			
			
			getServletContext().getRequestDispatcher("/productosCrud/crearProducto.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
