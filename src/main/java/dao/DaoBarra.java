package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelos.Producto;

public class DaoBarra {
	
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
			+ "    tt.nombre\n,"
			+ "	   tp.urlimagen\n"
			+ "\n"
			+ "FROM \n"
			+ "\n"
			+ "    tblproducto AS tp\n"
			+ "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
			+ "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
			+ "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda"
			+ "    WHERE tp.nombre LIKE ? OR tp.descripcion LIKE ? LIMIT 10;";
	
	//private static final String SQL_BUSCAR_PRODUCTOS = "SELECT * FROM tblproducto WHERE nombre LIKE ? OR descripcion LIKE ? LIMIT 10;";
	
	/*
	private static final String SQL_SELECT_DOCID = "SELECT docid, nombres, apellidos, correo FROM tblusuario WHERE docid = ?;";
	
	private static final String SQL_INSERT = "INSERT INTO tblusuario VALUES(?,?,?,?,?,?,?,?,?,?);";
	
	private static final String SQL_UPDATE = "UPDATE tblusuario SET nombres = ?, apellidos = ?, correo = ? WHERE docid = ?;";
	
	private static final String SQL_DELETE = "DELETE FROM tblusuario WHERE docid = ?;";
	*/
	
	public List<Producto> listarProductosBusqueda(String entrada){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Producto> productos = new ArrayList<Producto>();
		
		try {
			
			entrada = "%".concat(entrada).concat("%");
			//se imprime lo que busco
			System.out.print(entrada);
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			stmt.setString(1, entrada);
			stmt.setString(2, entrada);
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
				String imagen = rs.getString(10);
				
				productos.add(new Producto(codProducto, nombre, fechaPub, descripcion, 
						precio, existencia, estado, categoria, tienda, imagen));
				

				
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
	
	
	

}
