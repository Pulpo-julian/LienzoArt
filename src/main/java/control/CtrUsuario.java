package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		/*
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
		*/
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String decision = request.getParameter("crud");

		PrintWriter out = response.getWriter();
		
		
		
		if(decision.equals("crear")) {
			
			
			
			Map<String, String> errores = new HashMap<String, String>();
			
			//validar cedula
			String cedula = request.getParameter("cedula");
			
			if(cedula == null || cedula.isEmpty()) {
				errores.put("cedula", "la cedula es requerida");
			}
			
			//validar nombre
			String nombre = request.getParameter("nombre");
			
			if(nombre == null || nombre.isBlank()) {
				errores.put("nombre", "el nombre es requerido");
			}
			
			//validar apellidos
			String apellidos = request.getParameter("apellidos");
			
			if(apellidos == null || apellidos.isBlank()) {
				errores.put("apellidos", "el apellido es requerido");
			}
			
			//validar correo
			String correo = request.getParameter("correo");
			
			if(correo == null || correo.isBlank()) {
				errores.put("correo", "el correo es requerido");
			} else if(!correo.contains("@")) {
				errores.put("correo", "el correo debe tener caracter \"@\"");
			}
			
			//validar password
			String password = request.getParameter("password");
			
			if(password == null || password.isBlank()) {
				errores.put("password", "la contraseña es requerida");
			}
			
			//validar telefono
			String telefono = request.getParameter("telefono");
			
			if(telefono == null || telefono.isBlank()) {
				errores.put("telefono", "el telefono es requerido");
			}
			
			//validar ciudad
			String ciudad = request.getParameter("ciudades");
			
			if(ciudad == null || ciudad.isBlank()) {
				errores.put("ciudades", "la ciudad es requrida");
			}
			
			//validar codigoPostal
			String codigoPostal = request.getParameter("codigoPostal");
			
			if(codigoPostal == null || codigoPostal.isBlank()) {
				errores.put("codigoPostal", "debe ingresar codigo postal");
			}
			
			//validar direccion
			String direccion = request.getParameter("direccion");
			
			if(direccion == null || direccion.isBlank()) {
				errores.put("direccion", "debe ingresar la direccion");
			}
			
			
			if(errores.isEmpty()) {
				
				try {
					DaoUsuario daoUsuario = new DaoUsuario();
					daoUsuario.insertarUsuario(cedula, nombre, apellidos, correo, 1, password, telefono, ciudad, codigoPostal, direccion);
					//getServletContext().getRequestDispatcher("CrudNuevoLienzoArt/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
					out.print("el usuario se ha creado correctamente");
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
				
			} else {
				
				request.setAttribute("errores", errores);
				
				getServletContext().getRequestDispatcher("/CrudNuevoLienzoArt/usuarioCrud/crearUsuario.jsp").forward(request, response);
				
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		if (decision.equals("eliminar")) {
			
			String cedula = request.getParameter("cedula");
			
			
			try {

				List<Usuario> lista;
				
				DaoUsuario daoUsuario = new DaoUsuario();
				daoUsuario.borrarUsuario(cedula);
				
				//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);

				
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
			
			//super.doPost(req, resp);
		}
		
		
		if(decision.equals("listar")) {
			
			try {

				
				DaoUsuario daoUsuario = new DaoUsuario();
				List<Usuario> listaU = daoUsuario.listar();
				
				request.setAttribute("listUsuarios", listaU);
				
				request.getRequestDispatcher("/usuarioCrud/listarUsuarios.jsp").forward(request, response);

				
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
		}
		
		
		
		if(decision.equals("actualizar")) {
			
			try {
				
				String cedula = request.getParameter("cedula");
				String nombres = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String correo = request.getParameter("correo");
				
				
				DaoUsuario daoUsuario = new DaoUsuario();
				daoUsuario.actualizarUsuario(cedula, nombres, apellidos, correo);
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace(System.out);
				
			}
			
		}
		
		if(decision.equals("mostrar")) {
			
			try {
				
				String cedula = request.getParameter("cedula");
				
				
				
				DaoUsuario daoUsuario = new DaoUsuario();
				Usuario usuario = daoUsuario.buscarUsuario(cedula);
				
				request.setAttribute("usuario", usuario);
				
				request.getRequestDispatcher("/usuarioCrud/verUsuario.jsp").forward(request, response);
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace(System.out);
				
			}
			
		}
		
		
		
			
			
		

		/*
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
		*/

		
		//doGet(request, response);
	}

	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
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
		*/	
		
		//super.doTrace(arg0, arg1);
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		/*
		String cedula = request.getParameter("cedula");
		
		PrintWriter out = response.getWriter();
		
		try {

			
			DaoUsuario daoUsuario = new DaoUsuario();
			daoUsuario.borrarUsuario(cedula);
			
			//getServletContext().getRequestDispatcher("CrudNuevoLienzoArto/usuarioCrud/usuarioFormulario.jsp").forward(request, response);

			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		*/
		
		//super.doDelete(req, resp);
	}

	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
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
		*/
		
		
		
		//super.doPut(req, resp);
	}
	
	

}

