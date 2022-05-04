package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;

import java.io.IOException;
import java.io.PrintWriter;

import dao.DaoUsuario;

//import dao.DaoUsuario;

/**
 * Servlet implementation class CtrUsuario
 */
@WebServlet("/formulariousuario")
public class CtrUsuario extends HttpServlet {


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cedula = request.getParameter("cedula");
		
		PrintWriter out = response.getWriter();
		
		try {

			
			DaoUsuario daoUsuario = new DaoUsuario();
			Usuario usuario = daoUsuario.buscarUsuario(cedula);
			//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
			
			out.print("la cedula del usuario es: " + usuario.getDocid());
			out.print("el nombre del usuario es: " + usuario.getNombres());
			out.print("los apellidos del usuario son: " + usuario.getApellidos());
			out.print("el correo del usuario es: " + usuario.getCorreo());
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}	
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		PrintWriter out = response.getWriter();

			
			String cedula = request.getParameter("cedula");
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String correo = request.getParameter("correo");
			String password = request.getParameter("password");
			String telefono = request.getParameter("telefono");
			String ciudad = request.getParameter("ciudades");
			String codigoPostal = request.getParameter("codigoPostal");
			String direccion = request.getParameter("direccion");
			
			try {
				DaoUsuario daoUsuario = new DaoUsuario();
				daoUsuario.insertarUsuario(cedula, nombre, apellidos, correo, 1, password, telefono, ciudad, codigoPostal, direccion);
				//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}			
			
	

			try {

				
				DaoUsuario daoUsuario = new DaoUsuario();
				Usuario usuario = daoUsuario.buscarUsuario(cedula);
				//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
				
				out.print("la cedula del usuario es: " + usuario.getDocid());
				out.print("el nombre del usuario es: " + usuario.getNombres());
				out.print("los apellidos del usuario son: " + usuario.getApellidos());
				out.print("el correo del usuario es: " + usuario.getCorreo());
				
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}			
			

		
		//doGet(request, response);
	}

	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cedula = request.getParameter("cedula");
		
		PrintWriter out = response.getWriter();
		
		try {

			
			DaoUsuario daoUsuario = new DaoUsuario();
			Usuario usuario = daoUsuario.buscarUsuario(cedula);
			//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
			
			out.print("la cedula del usuario es: " + usuario.getDocid());
			out.print("el nombre del usuario es: " + usuario.getNombres());
			out.print("los apellidos del usuario son: " + usuario.getApellidos());
			out.print("el correo del usuario es: " + usuario.getCorreo());
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}	
		
		//super.doTrace(arg0, arg1);
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		
		String cedula = request.getParameter("cedula");
		
		PrintWriter out = response.getWriter();
		
		try {

			
			DaoUsuario daoUsuario = new DaoUsuario();
			daoUsuario.borrarUsuario(cedula);
			//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);

			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		//super.doDelete(req, resp);
	}

	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		String nombres = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		

		
		try {

			
			DaoUsuario daoUsuario = new DaoUsuario();
			daoUsuario.actualizarUsuario(cedula, nombres, apellidos, correo);
			//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
			

			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		
		
		//super.doPut(req, resp);
	}
	
	

}

