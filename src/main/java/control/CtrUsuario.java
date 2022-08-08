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
		
		
		
		if(decision.equals("Crear")) {
			
			
			
			Map<String, String> errores = new HashMap<String, String>();
			
			//validar cedula
			String cedula = request.getParameter("cedula");
			
			if(cedula == null || cedula.isEmpty()) {
				errores.put("cedula", "Debe ingresar su cedula");
			}
			
			//validar nombre
			String nombre = request.getParameter("nombre");
			
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
			
			
			
			
			
			
			
		}
		
		
		
		
		if (decision.equals("eliminar")) {
			
			String cedula = request.getParameter("cedula");
			
			
			try {

				List<Usuario> lista;
				
				DaoUsuario daoUsuario = new DaoUsuario();
				daoUsuario.borrarUsuario(cedula);
				
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
			

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
		
	}

	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	

}

