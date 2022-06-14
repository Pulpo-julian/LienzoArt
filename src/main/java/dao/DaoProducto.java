package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexion.Conexion;
import modelos.Producto;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DaoProducto {
	
	private static final String SQL_SELECT = "SELECT\n"
			+ "\n"
			+ "    tp.codproducto,\n"
			+ "    tp.nombre,\n"
			+ "    tp.fechapublicacion,\n"
			+ "    tp.descripcion,\n"
			+ "    tp.precio,\n"
			+ "    tp.existencia,\n"
			+ "    te.nombre,\n"
			+ "    tc.nombre,\n"
			+ "    tt.nombre\n"
			+ "\n"
			+ "FROM \n"
			+ "\n"
			+ "    tblproducto AS tp\n"
			+ "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
			+ "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
			+ "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda;";
	
	private static final String SQL_SELECT_CATEGORIA = "SELECT\n"
			+ "\n"
			+ "    tp.codproducto,\n"
			+ "    tp.nombre,\n"
			+ "    tp.fechapublicacion,\n"
			+ "    tp.descripcion,\n"
			+ "    tp.precio,\n"
			+ "    tp.existencia,\n"
			+ "    te.nombre,\n"
			+ "    tc.nombre,\n"
			+ "    tt.nombre\n"
			+ "\n"
			+ "FROM \n"
			+ "\n"
			+ "    tblproducto AS tp\n"
			+ "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
			+ "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
			+ "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda "
			+ "WHERE tp.categoria = ?;";
	
	
	
	
	private static final String SQL_SELECT_DOCID = "SELECT\n"
			+ "\n"
			+ "    tp.codproducto,\n"
			+ "    tp.nombre,\n"
			+ "    tp.fechapublicacion,\n"
			+ "    tp.descripcion,\n"
			+ "    tp.precio,\n"
			+ "    tp.existencia,\n"
			+ "    te.nombre,\n"
			+ "    tc.nombre,\n"
			+ "    tt.nombre\n"
			+ "\n"
			+ "FROM \n"
			+ "\n"
			+ "    tblproducto AS tp\n"
			+ "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
			+ "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
			+ "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda\n"
			+ "\n"
			+ "WHERE \n"
			+ "\n"
			+ "    tp.codproducto = ?;";
	
	private static final String SQL_INSERT = "INSERT INTO tblproducto VALUES(?,?,?,?,?,?,?,?,?);";
	
	private static final String SQL_UPDATE = "UPDATE tblusuario SET nombres = ?, apellidos = ?, correo = ? WHERE docid = ?;";
	
	private static final String SQL_DELETE = "DELETE FROM tblusuario WHERE docid = ?;";

	
	
	public List<Producto> listar(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Producto> productos = new ArrayList<Producto>();
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				int codProducto = rs.getInt(1);
				String nombre = rs.getString(2);
				String fechaPub = rs.getString(3);
				String descripcion = rs.getString(4);
				int precio = rs.getInt(5);
				int existencia = rs.getInt(6);
				String estado = rs.getString(7);
				String categoria = rs.getString(8);
				String tienda = rs.getString(9);
				
				productos.add(new Producto(codProducto, nombre, fechaPub, descripcion, 
						precio, existencia, estado, categoria, tienda));
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(rs);
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
		return productos;
		
	}
	
	// listar por categoria
	public List<Producto> listarPorCategoria(int codigo){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Producto> productos = new ArrayList<Producto>();
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_CATEGORIA);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				int codProducto = rs.getInt(1);
				String nombre = rs.getString(2);
				String fechaPub = rs.getString(3);
				String descripcion = rs.getString(4);
				int precio = rs.getInt(5);
				int existencia = rs.getInt(6);
				String estado = rs.getString(7);
				String categoria = rs.getString(8);
				String tienda = rs.getString(9);
				
				productos.add(new Producto(codProducto, nombre, fechaPub, descripcion, 
						precio, existencia, estado, categoria, tienda));
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(rs);
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
		return productos;
		
	}
	
	
	//CRUD functions
	public Producto buscarProducto(int codigoProducto){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Producto producto = null;
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_DOCID);
			stmt.setInt(1, codigoProducto);
			rs = stmt.executeQuery();
			
			rs.next();
			
			int codProducto = rs.getInt(1);
			String nombre = rs.getString(2);
			String fechaPub = rs.getString(3);
			String descripcion = rs.getString(4);
			int precio = rs.getInt(5);
			int existencia = rs.getInt(6);
			String estado = rs.getString(7);
			String categoria = rs.getString(8);
			String tienda = rs.getString(9);
			
			producto = new Producto(codProducto, nombre, fechaPub, descripcion, 
					precio, existencia, estado, categoria, tienda);
				
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(rs);
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
		return producto;
		
	}
	
	/*
	public void insertarUsuario(int codigoProducto, String nombre, String apellidos, 
			String correo, int perfil, String clave, String telefono,
			String ciudad, String codigoPost, String direccion) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, docid);
			stmt.setString(2, nombres);
			stmt.setString(3, apellidos);
			stmt.setString(4, correo);
			stmt.setInt(5, perfil);
			stmt.setString(6, clave);
			stmt.setString(7, telefono);
			stmt.setString(8, ciudad);
			stmt.setString(9, codigoPost);
			stmt.setString(10, direccion);
			stmt.executeUpdate();
	
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
	}
	
	public void actualizarUsuario(String docid ,String nombres, String apellidos, String correo) {
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, nombres);
			stmt.setString(2, apellidos);
			stmt.setString(3, correo);
			stmt.setString(4, docid);
			stmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
	}
	
	public void borrarUsuario(String docid) {
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setString(1, docid);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
	}
	*/
	
	/*
	public static void main(String[] args) {
		DaoProducto daoPro = new DaoProducto();
		List<Producto> productos = daoPro.listar();
		
		for(Producto pro: productos) {
			System.out.println(pro);
		}
		
	}
	*/
	
	
}
